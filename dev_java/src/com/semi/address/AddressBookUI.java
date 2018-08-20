package com.semi.address;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class AddressBookUI implements ActionListener {
	//�����
	static AddressBookUI aBook = null;
	JFrame 		jf_addr 	= new JFrame();
	JMenuBar 	jmb 		= new JMenuBar();
	JMenu 		jm_file 	= new JMenu("File");
	JMenu 		jm_edit 	= new JMenu("Edit");
	JMenuItem 	jmi_ins 	= new JMenuItem("�Է�");
	JMenuItem 	jmi_upd 	= new JMenuItem("����");
	JMenuItem 	jmi_del 	= new JMenuItem("����");
	JMenuItem 	jmi_det 	= new JMenuItem("����ȸ");
	JMenuItem 	jmi_all 	= new JMenuItem("��ü��ȸ");
	JMenuItem 	jmi_exit 	= new JMenuItem("����");
	//���� �߰�
	JToolBar    jtbBar		= new JToolBar();
	JButton		jbtn_ins	= new JButton();
	JButton		jbtn_upd	= new JButton();
	JButton		jbtn_del	= new JButton();
	JButton		jbtn_det	= new JButton();
	JButton		jbtn_all	= new JButton();
	//JTable�߰��ϱ�
	String[] header = {"����","�̸�","����"};
	String[][] datas = new String[0][3];
	//�����ͼ�(����ü)-Object�̸� ��� �� OK 
	DefaultTableModel dtm   = new DefaultTableModel(datas,header);
	//��(���)-JTable�� �ν��Ͻ�ȭ �Ҷ� �Ķ���Ϳ� DefaultTableModel �ѱ��(����)
	JTable 		jtb_addr	= new JTable(dtm);
	//JScrollPane�� ��ȭ��(��ũ�ѹ�)
	JScrollPane jsp_addr	= new JScrollPane(jtb_addr);
	//�̹��� ��� ���� �����ϱ�
	String imgPath = "E:\\dev_kosmo201804\\dev_java\\src\\com\\images\\";
	ImageIcon titleIcon = new ImageIcon(imgPath+"address.png");//����ǥ������ ������ ��μ����ϱ�
	AddressCUD  aCUD = new AddressCUD();
	//������
	public AddressBookUI() {
		initDisplay();
	}
	//ȭ��ó�� �޼ҵ�
	public void initDisplay() {
		
		//JFrame���� â���� X��ư�� Ŭ�������� ������ ó���ϱ�
		jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���Ʒ� ���, ������ ������ ���� ���
/*		jf_addr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});//�ݱ� ���� �ڿ� ���������Ű�� �����츮���� + ������Ŭ��¡ 
*/		
		//�޴��������� �����ư Ŭ�������� ������ ó���ϱ�
		jmi_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);//�ڹٰ���ӽŰ� ������� ���´�.
				//cadidate���·� �ش� �ڿ�UI�� ������ ���� JVM�� ȸ����
			}
		});
		
		//�̺�Ʈ �ҽ�(��ư5��)�� �̺�Ʈ ó���� ����ϴ� Ŭ����(actionPerformed����)��
		//����
		//�̺�Ʈó��-�̺�Ʈ�ҽ��� Ŭ��|üũ ����(ActionListener)
		//�̺�Ʈ�ҽ��� �̺�Ʈ ó�� Ŭ������ ����(actionPerformed����Ŭ����)
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});//����
		jmi_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}			
		});
	//	jbtn_det.addActionListener(this);
		jbtn_det.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//�Ķ���� e�� ������ �̺�Ʈ �ҽ��� ������(�̺�Ʈ�� ��� �Ͼ��?)
				detailActionPerformed(e);
				
			}
			
		});
		//jbtn_all.addActionListener(this);
		jbtn_all.addActionListener(new ActionListener() {//�͸� Ŭ���� �����ϱ�
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshData(e);
			}
		});
		
		//��ư�� �̹��� ������ �߰��ϱ�
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif"));
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif"));
		jbtn_det.setIcon(new ImageIcon(imgPath+"detail.gif"));
		jbtn_all.setIcon(new ImageIcon(imgPath+"search.gif"));
		//���� ��ư�� ǳ���� �߰��ϱ�
		jbtn_ins.setToolTipText("�Է�");
		jbtn_upd.setToolTipText("����");
		jbtn_del.setToolTipText("����");
		jbtn_det.setToolTipText("����ȸ");
		jbtn_all.setToolTipText("��ü��ȸ");
		//���ٿ� ��ư �߰��ϱ�
		jtbBar.add(jbtn_ins);
		jtbBar.add(jbtn_upd);
		jtbBar.add(jbtn_del);
		jtbBar.add(jbtn_det);
		jtbBar.add(jbtn_all);
		jmb.add(jm_file);
		jm_file.add(jmi_exit);
		jmb.add(jm_edit);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jm_edit.add(jmi_det);
		jm_edit.add(jmi_all);
		jf_addr.setJMenuBar(jmb);
		//���� ���ʿ� ��ġ�ϱ�
		jf_addr.add("North",jtbBar);
		jf_addr.add("Center", jsp_addr);
		jf_addr.setIconImage(titleIcon.getImage());//�������̹�����ġ
		jf_addr.setTitle("�ּҷ� Ver1.0");
		jf_addr.setSize(500, 400);
	//	jf_addr.setLocation(800, 300);//â�� ������ ��ġ�� ������ǥ�� ������ 
		Dimension di = Toolkit.getDefaultToolkit().getScreenSize();//���� �������� ����� �������
		Dimension di2 = jf_addr.getSize();//���� JFrame�� ����� ã����
		jf_addr.setLocation((int)(di.getWidth()/2-di2.getWidth()/2)
						   ,(int)(di.getHeight()/2-di2.getHeight()/2));//â�� ������ ��ġ�� ������ǥ�� ������ 
		jf_addr.setVisible(true);
	}
	/************************************************************************
	 * [�󼼺��� ����]
	 * @param e - �̺�Ʈ�ҽ���  ����  ��)e.getSource():Object		 ::��ü�� �ּҹ��� ����
	 * 						      ��)e.getActionCommand():String ::��ư�� �� �� ����
	 ************************************************************************/
    protected void detailActionPerformed(ActionEvent e) {
		Object obj	 = e.getSource();
		String label = e.getActionCommand();
		//�� ������ ���� ������ ���� ���� �ž�?-�ĺ��� PK�� ���õǾ���� <ano>
		//�����(���������)�� �����ϰ� �����ϴ°� JVM, �װ��� �����ϴ°��� ������
		int index[] = jtb_addr.getSelectedRows();
		if(index.length==0) {//������ if���� ȿ����
			JOptionPane.showMessageDialog(jf_addr
					                     ,"������� �����͸� �����ϼ���"
					                     ,"WARN"
					                     ,JOptionPane.WARNING_MESSAGE);
			return;//���þ������� 
		} else if (index.length>1) {
			JOptionPane.showMessageDialog(jf_addr
					,"������� �����͸� 1�Ǹ� �����ϼ���"
					,"WARN"
					,JOptionPane.WARNING_MESSAGE);
			return;//���þ������� 
		} else {//1���̻� ����������
			//������ �ο��� PK�� ano�� �о���� - WHERE ano=?
			Integer ano = (Integer)dtm.getValueAt(index[0], 0);
			//getAddressList�޼ҵ� ȣ���Ҷ�
			//������ �ο��� PK ano�� AddressVOŸ�Կ� ��Ƽ� �Ѱܾ� ��.
			//�׷��� �ν��Ͻ�ȭ�ϰ�, �� Ŭ������ ano ������ ������ �ο��� ano�� ����.
			AddressVO pavo = new AddressVO();
			pavo.setAno(ano);
			//aDAO�� ��ü��ȸ�� ����ȸ�� ��� ��ȸ�ϴ� �޼ҵ� ȣ���Ҷ� ���� ��� pavo�� �ѱ�
			AddressBookDAO aDAO = new AddressBookDAO();
			AddressVO ravos[] = aDAO.getAddressList(pavo);
			//�迭�� �濡 �ִ� ������ ������ ���� 			
			AddressVO ravo = null;
			if(ravos.length==1) ravo = ravos[0];
			System.out.println("����:"+ravo.getGender());
			//�ڽ�â�� ������ �������� �ʱ�ȭ�ϰ�
			aCUD.set("����ȸ",true, aBook,ravo,false);
			//�ʱ�ȭ�� ������ �ڽ�â�� ��������(����)
			aCUD.initDisplay();
		}
		
	}
	//�����޴��������̳� ���� ������ ���ý� �۾��� ����
	protected void deleteActionPerformed(ActionEvent e) {
		int[] index = jtb_addr.getSelectedRows();
		int anos[] = new int[index.length];//�迭�� ���̸� ����Ͽ� �� ����
		int result = 0;
		/*for(int i:index) {
			System.out.println("i:"+i);
		}*/
		if(index.length==0) {//�� ������ �ο츦 ���þ��߱���?
			JOptionPane.showMessageDialog(jf_addr, "������ �ο츦 �����ϼ���.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;//deleteActionPerformedŻ��
		}
		else {//�� �����߱���? 1..n��
			int j=0;//������ �ο��� ano�� ���� ���� index��
			for(int i=0;i<jtb_addr.getRowCount();i++) {
				//System.out.println(dtm.getValueAt(i, 0));
				if(jtb_addr.isRowSelected(i)) {					
					anos[j] = (Integer)dtm.getValueAt(i,0);
					j++;
				}
			}
			for(int ano:anos) {//������ �ο��� ������ ����� �ԷµǾ����� �׽�Ʈ
				System.out.println("ano : "+ano);				
			}
			AddressBookDAO aDAO = new AddressBookDAO();
			result = aDAO.addrDelete(anos);
			JOptionPane.showMessageDialog(jf_addr
					,result+"���� �����Ǿ����ϴ�."
					,"INFO",JOptionPane.INFORMATION_MESSAGE);
			refreshData(null);
		}
	}
	//��ü �����͸� �ٽ� ��ȸ�մϴ�.
	public void refreshData(ActionEvent e)
	{
		//�̹� ���̺� �������� �����Ͱ� �ִ� ��� ��� �����ϰ� �ٽ� ���
		while(dtm.getRowCount()>0) {
			dtm.removeRow(0);
		}
		AddressBookDAO aDAO = new AddressBookDAO();
		AddressVO pavo = new AddressVO();
		AddressVO[] ravos = aDAO.getAddressList(pavo);
		for(int i=0;i<ravos.length;i++) {
			Vector oneRow = new Vector();//DefaultTableModel�� addRow()����,�Ķ���ͷ� Vector
			oneRow.add(ravos[i].getAno());
			oneRow.add(ravos[i].getA_name());
			oneRow.add(ravos[i].getGender());
			dtm.addRow(oneRow);
		}
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		aBook = new AddressBookUI();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ �ҽ�(��ư5��)�� ���ڿ� 
		String label = ae.getActionCommand();
		//�̺�Ʈ �ҽ��� �ּҹ���
		Object obj = ae.getSource();
		if(obj==jbtn_ins) {//�� �Է¹�ư �����ž�?
			//�ڽ�â�� ȭ�鿡 ����
			aCUD.set("�Է�",true,aBook,null,true);
			aCUD.initDisplay();
		}
		else if(obj==jbtn_upd) {//�� ������ư Ŭ���߾�?
			int index[] = jtb_addr.getSelectedRows();
			if(index.length==0) {//������ if���� ȿ����
				JOptionPane.showMessageDialog(jf_addr
						                     ,"������� �����͸� 1�� �����ϼ���"
						                     ,"WARN"
						                     ,JOptionPane.WARNING_MESSAGE);
				return;//���þ������� 
			} else if (index.length>1) {
				JOptionPane.showMessageDialog(jf_addr
						,"������� �����͸� 1�Ǹ� �����ϼ���"
						,"WARN"
						,JOptionPane.WARNING_MESSAGE);
				return;//���þ������� 
			} else {//1���̻� ����������
				//������ �ο��� PK�� ano�� �о���� - WHERE ano=?
				Integer ano = (Integer)dtm.getValueAt(index[0], 0);
				AddressVO pavo = new AddressVO();
				pavo.setAno(ano);
				AddressBookDAO aDAO = new AddressBookDAO();
				AddressVO ravos[] = aDAO.getAddressList(pavo);	
				AddressVO ravo = null;
				if(ravos.length==1) ravo = ravos[0];
				System.out.println("����:"+ravo.getGender());
				//�ڽ�â�� ������ �������� �ʱ�ȭ�ϰ�
				aCUD.set("����",true, aBook,ravo,true);
				//�ʱ�ȭ�� ������ �ڽ�â�� ��������(����)
				aCUD.initDisplay();
			}
		}/////////end of else if
	}/////////////end of actionPerformed
}/////////////////end of AddressBookUI
