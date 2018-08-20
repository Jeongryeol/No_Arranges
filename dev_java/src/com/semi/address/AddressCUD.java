package com.semi.address;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddressCUD extends JDialog implements ActionListener {
	//JDialog 	jdi_cud 	= new JDialog();
	JLabel 		jlb_name 	= new JLabel("�̸� :");
	JTextField 	jtf_name	= new JTextField(20);
	JLabel 		jlb_id 	= new JLabel("���̵� :");
	JTextField 	jtf_id	= new JTextField(10);
	JLabel 		jlb_pw 	= new JLabel("��� :");
	JTextField 	jtf_pw	= new JTextField(10);
	JLabel 		jlb_gender 	= new JLabel("���� :");
	String[]    genderList  = {"����","����"};
	JComboBox 	jcb_gender	= new JComboBox(genderList);
	JLabel 		jlb_bigo 	= new JLabel("�� :");
	JTextArea 	jta_bigo	= new JTextArea(3,20);
	JScrollPane jsp_bigo    = new JScrollPane(jta_bigo);
	JPanel      jp_center   = new JPanel();
	//��ư �߰��ϱ�
	JButton     jbtn_cud	= new JButton();
	JButton     jbtn_cancel	= new JButton("���");
	//�ڽ�â�� Ȱ��ȭ|��Ȱ��(�޸𸮿��� �ε��Ǿ� ������ ȭ�鿡�� �Ⱥ���)
	boolean isView = false;
	//�ڽ�â�� Ÿ��Ʋ ���
	String title = null;
	//�θ�â�� �ּҹ����� ���-����
	AddressBookUI aBook = null;
	AddressVO pvo = null;
	AddressBookDAO aDAO = new AddressBookDAO();
	public AddressCUD() {
	}
	//�Ķ���͸� ���� �����ڰ� �ϳ��� ������ ����Ʈ �����ڴ� �����ȵ�.
	public AddressCUD(boolean isView) {
		this.isView = isView;
	}
	//�θ�â���� �ڽ�â �����ϱ�
	public void set(String title, boolean isView, AddressBookUI aBook) {
		this.title = title;
		this.isView = isView;
		this.aBook = aBook;
	}
	//�θ�â���� �ڽ�â �����ϱ�
	/******************************************************************
	 * �θ�â���� �ڽ�â �������� �ڵ� �߰�
	 * @param title - �Է�|����|����ȸ
	 * @param isView - �ڽ�â�� Ȱ��ȭ|��Ȱ��
	 * @param aBook - �θ�â�� �ּҹ��� - ���ΰ�ħ
	 * @param pvo - select�� ���
	 * @param isOk - �Է�������Ʈ�� Ȱ��ȭ|��Ȱ��ȭ
	 *****************************************************************/
	public void set(String title, boolean isView, AddressBookUI aBook
			      , AddressVO pvo, boolean isOk) {
		this.title = title;
		this.isView = isView;
		this.aBook = aBook;
		this.pvo = pvo;
		this.setValue(pvo);
		this.setEditable(isOk);
	}	
	//�Է��� ��� ������Ʈ�� ��� ���� ���ڿ��� ó��
	//��ȸ�� �����ô� Value Object(AddressVO)���� ���� ������ ����
	public void setValue(AddressVO pvo) {//pvo-��ȸ����� �������.
		if(pvo==null) {//�� �Է¹�ư�� �����ž�?
			setName("");
			setBigo("");
			setGender("����");
			setId("");
			setPw("");
		}
		else {//����ȸ ��ư|������ư�� �����ž�?
			setName(pvo.getA_name());
			setBigo(pvo.getA_bigo());
			setGender(pvo.getGender());
			//���� �߰�����? jtf_id, jtf_pw, ����(���̵�� ���)�� �߰�����?
			//���(set()ȣ�� �Ѿ����-ravo)�� ����?
			setId(pvo.getA_id());
			setPw(pvo.getA_pw());
		}
	}
	//�ڽ�â�� ��ġ�� ������Ʈ�� ���¸� Ȱ��ȭ �Ǵ� ��Ȱ��ȭ
	public void setEditable(boolean isOk) {
		jtf_name.setEditable(isOk);
		jta_bigo.setEditable(isOk);
	}
	public void initDisplay() {
		jbtn_cud.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		//jtf_name.setText("����) �����");
		//System.out.println(jtf_name.getText());
		jp_center.setLayout(null);
		jlb_name.setBounds(20, 20, 100, 20);
		jtf_name.setBounds(120, 20, 150, 20);
		jlb_gender.setBounds(20, 45, 100, 20);
		jcb_gender.setBounds(120, 45, 150, 20);
		jlb_bigo.setBounds(20, 70, 100, 20);
		jsp_bigo.setBounds(120, 70, 200, 60);
		jlb_id.setBounds(20, 135, 100, 20);
		jtf_id.setBounds(120, 135, 100, 20);
		jlb_pw.setBounds(20, 160, 100, 20);
		jtf_pw.setBounds(120, 160, 100, 20);
		jbtn_cud.setBounds(60, 300, 100, 25);
		jbtn_cancel.setBounds(180, 300, 100, 25);
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_gender);
		jp_center.add(jcb_gender);
		jp_center.add(jlb_bigo);
		jp_center.add(jsp_bigo);
		jbtn_cud.setText(title);
		jp_center.add(jbtn_cud);
		jp_center.add(jbtn_cancel);
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jlb_pw);
		jp_center.add(jtf_pw);		
		this.add("Center",jp_center);
		this.setTitle(title);
		this.setSize(350, 500);
		this.setVisible(isView);
	}
	//�� �÷��� ������ ������Ʈ(JTextField)�������ϰų�  �о���� getter/setter�޼ҵ� �߰��ϱ�
	public String getId() {
		return jtf_id.getText();
	}
	public void setId(String id) {
		jtf_id.setText(id);
	}
	public String getPw() {
		return jtf_pw.getText();
	}
	public void setPw(String pw) {
		jtf_pw.setText(pw);
	}	
	public String getName() {
		return jtf_name.getText();
	}
	public void setName(String name) {
		jtf_name.setText(name);
	}
	public String getBigo() {
		return jta_bigo.getText();
	}
	public void setBigo(String bigo) {
		jta_bigo.setText(bigo);
	}	
	public String getGender() {
		if("����".equals(jcb_gender.getSelectedItem())) return "1";
		else return "0";
	}
	public void setGender(String gender) {
		if("����".equals(gender)) jcb_gender.setSelectedItem("����");
		else jcb_gender.setSelectedItem("����");
	}	
	public static void main(String args[]) {
	    //AddressCUD aCUD = new AddressCUD(true);
		//aCUD.initDisplay();
		//aCUD.setName("�����");
		//System.out.println(aCUD.getName());
		//aCUD.setBigo("�׽�Ʈ..�׽�Ʈ....");
		//System.out.println(aCUD.getBigo());
		//aCUD.setGender("0");
		//System.out.println(aCUD.getGender());
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻��� Ŭ������ �ּҹ����� ��´�.(jbtn_cud or jbtn_cancel)
		Object obj = ae.getSource();
		if(obj==jbtn_cud) {
			System.out.println(jbtn_cud.getText());
			if("�Է�".equals(jbtn_cud.getText())) {
				AddressVO pavo = new AddressVO();
				pavo.setA_name(getName());
				pavo.setA_bigo(getBigo());
				pavo.setGender(getGender());
				pavo.setA_id(getId());
				pavo.setA_pw(getPw());
				JOptionPane.showMessageDialog(aBook.jf_addr
						                    , pavo.getA_id()
						                 +","+pavo.getA_pw()
						                 +","+pavo.getA_name()
						                 +","+pavo.getGender()
						                 +","+pavo.getA_bigo()
						                    , "INFO"
						                    , JOptionPane.INFORMATION_MESSAGE);
				int result = aDAO.addrInsert(pavo);
				if(result==1) {//��ϵȰž�?
					JOptionPane.showMessageDialog(aBook.jf_addr
							                     ,"�ּҷϿ� �߰��Ǿ����ϴ�."
							                     ,"INFO"
							                     , JOptionPane.INFORMATION_MESSAGE);
					jbtn_cud.setText("");
					this.dispose();
					aBook.refreshData(null);
				}else {//��� �����߳�......
					JOptionPane.showMessageDialog(aBook.jf_addr
		                     ,"��� ����."
		                     ,"ERROR"
		                     , JOptionPane.ERROR_MESSAGE);
				}
			}
			else if("����".equals(jbtn_cud.getText())) {
				AddressVO pavo = new AddressVO();
				pavo.setAno(pvo.getAno());
				pavo.setA_id(getId());
				pavo.setA_pw(getPw());
				pavo.setA_bigo(getBigo());
				pavo.setGender(getGender());
				int result = aDAO.addrUpdate(pavo);
				if(result==1) {//�����Ѱž�?
					JOptionPane.showMessageDialog(aBook.jf_addr
							                     ,"�����Ǿ����ϴ�."
							                     ,"INFO"
							                     , JOptionPane.INFORMATION_MESSAGE);
					jbtn_cud.setText("");
					this.dispose();
					aBook.refreshData(null);
				}else {//��� �����߳�......
					JOptionPane.showMessageDialog(aBook.jf_addr
		                     ,"���� ����."
		                     ,"ERROR"
		                     , JOptionPane.ERROR_MESSAGE);
				}				
			}
		}
	}
}










