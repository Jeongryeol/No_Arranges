package com.semi.addressbook_2nd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

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

/*
 * ����ڿ� �ý����� �����ϱ� ���� UI�� �����ų Ŭ����
 * ȭ���� �����ϴ� �����Ӱ� ��ư, �����˻������ ��������� ����
 * �� ������ �Է�â�� ����â�� �ٽ��Ѽ�(Dialog) �ٸ� Ŭ������ �����غ���
 */
public class AddressBookUI {

	//����� (�������� �� �����ν��Ͻ����� ����)
	Addr_DBConnectionMgr dbcon = new Addr_DBConnectionMgr();//DB������ ����
	Connection con = null;//JavaAPI SQL�� ����API Connection Ŭ����Ÿ�� �������� (������������)
	Statement stmt = null;//JavaAPI SQL�� ����API Statement Ŭ����Ÿ�� �������� (�ۼ�����������)
	ResultSet rs   = null;//JavaAPI SQL�� ���API ResultSet Ŭ����Ÿ�� �������� (������� ����)
	
	String [][] addrArray = null;//��ȸ����� ���� 2���迭 ��������
	
	//�����2 (ȭ��-�޴��� ������ ���� ����)
	JFrame		jf_addr		= new JFrame();
	JMenuBar	jmb_addr	= new JMenuBar();
	JMenu		jm_file		= new JMenu("File");
	JMenu		jm_edit		= new JMenu("edit");
	JMenuItem	jmi_ins		= new JMenuItem("�Է�");
	JMenuItem	jmi_upd		= new JMenuItem("����");
	JMenuItem	jmi_del		= new JMenuItem("����");
	JMenuItem	jmi_det		= new JMenuItem("����ȸ");
	JMenuItem	jmi_all		= new JMenuItem("��ü��ȸ");
	JMenuItem	jmi_exit	= new JMenuItem("����");
	
	//�����3 (ȭ��-���ٸ� ������ ��������)
	JToolBar	jtb			= new JToolBar();
	JButton		jbtn_ins	= new JButton();
	JButton		jbtn_upd	= new JButton();
	JButton		jbtn_del	= new JButton();
	JButton		jbtn_det	= new JButton();
	JButton		jbtn_all	= new JButton();
	JButton		jbtn_exit	= new JButton();
	
	//�����4 (ȭ��-���پ������� �̹������ ����)
	String imgPath = "E:\\dev_kosmo201804\\dev_java\\src\\com\\images";
	
	//�����5 (ȭ��-����ڷḦ ������ ��������)
	String[][]	datas_addr	= new String [50][4];//�������� ũ������
	String[]	header_addr	= {"����","�̸�","�ڵ���","�̸����ּ�"};//�������� �÷����� ����
	DefaultTableModel dtm_addr = new DefaultTableModel(datas_addr, header_addr);//�����͸� �����صδ� �⺻�����ͼ�
	JTable jt_addr = new JTable(dtm_addr);//�����ͼ��� �����ֵ��� ����ִ� JTable
	JScrollPane jsp_addr = new JScrollPane(jt_addr);//JTable�� ����� ��ȭ�� ������ �ϴ� JScrollPane
	
	//�����6 (����� �ܺθ޼ҵ� �ν��Ͻ�ȭ)
	AddressCUD addrCUD = new AddressCUD();
	
	
	
	//������
	//default�����ڸ� ������ �����Ͽ� ���θ޼ҵ忡�� �ν��Ͻ�ȭ�ϸ� �ڵ����� ����ǵ��� ����
	public AddressBookUI() {}
	
	
	
	//��������� �޼ҵ�
	//ȭ���� �ѵ��� �����ϴ� �޼ҵ�
	public void initDisplay() {
		//�̺�Ʈ�ҽ� ������ �ϴ� 5���� ��ư�� �̺�Ʈó���� ����ϴ� Ŭ����(actionPerformed����)�� ����
		//�̺�Ʈó��	:: �̺�Ʈ�ҽ��� Ŭ��|üũ �Ǵ°��� ���� ( ActionListener �� ���� )
		//�̺�Ʈ �ڵ鷯	:: �̺�Ʈ�ҽ��� �̺�Ʈó���� ����	 ( ActionPerformed  �� ���� )
		jbtn_ins.addActionListener((ActionListener)this);
		jbtn_upd.addActionListener((ActionListener)this);
		
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {deletActionPerformed(e);} });
		jmi_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {deletActionPerformed(e);} });
	}
	
	//�˻������ �����ϴ� �޼ҵ� (SELECT) //SQL : SELECT * FROM ���ո� WHERE �̸� = '�̸�(�Է°�)'
	public String[][] getAddressList(String name) {
		//����Ŭ(DB)������ ������ SQL�� �ۼ�(�ʱ�ȭ)
		String sql = "SELECT addno, addname, addhp, addemail FROM ADDRASS";
		sql +=" WHERE addname = '"+name+"' ORDER BY addno";
		//���޽õ�
		try {//����迭�� ũ�Ⱑ �޶������� �����ϱ����� ���
			stmt = dbcon.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE//�������������� createStatement()�޼ҵ� �ν��Ͻ�ȭ
					 					    ,ResultSet.CONCUR_UPDATABLE);//�׸��� ��ũ�ѿ� ���� Ŀ���� �̵��� �����ϰ��ϴ� �޼ҵ带 �Ķ���Ϳ� �Է� 
			System.out.println("[[query]]"+sql);//������ ���
	        rs = stmt.executeQuery(sql);
	        ResultSetMetaData column = rs.getMetaData();//rsĿ���� (�÷�)�ּҰ��� �޾ƿ��� �Լ�
	        rs.last();//Ŀ���� ���� ���������� �̵���Ŵ
	        int row = rs.getRow();//Ŀ���� �ο������� �� int������ ������
	        rs.beforeFirst();//Ŀ���� �ٽ� ó������ ���ͽ�Ŵ
	  		
	        String[][] addrArray = new String[row][column.getColumnCount()];//��ȸ�� ����� ���� �迭ũ�⸦ ����
	  		int count = 0;//�ο��ȣ�� ���� ��������
	  	    while(rs.next()) {//Ŀ���� �̵���Ű�鼭 �迭�� ����
	  	    				 addrArray[count][0] = rs.getString("addno");
	  	    				 addrArray[count][1] = rs.getString("addname");
	  	    				 addrArray[count][2] = rs.getString("addhp");
	  	    				 addrArray[count][3] = rs.getString("addemail");
	  	    				 count += 1;//�迭���ǰ� ������ �ο��ȣ�� 1�� �ø�
	  	    }//while������ �ݺ�
	  	    
	  	    for(int i=0;i<addrArray[i].length;i++) {
	  	    	for(int j=0;j<addrArray[i][j].length();j++) {
	  	    		System.out.print(addrArray[i][j]);
	  	    	}
	  	    }//for������ ������Ȯ��
		} catch(Exception e) {}
		return addrArray;//��ȸ����� ��� ���ϰ� ����
	}
	
	//��������� �����ϴ� �޼ҵ� (DELETE) //SQL : DELETE FROM �����̸� WHERE ����
	public  void deletActionPerformed(ActionEvent e) {
		int[] index= jt_addr.getSelectedRows();//JTable�� ����� ���� ������ �Ϳ� ���� �ο츦 �ν��ϰ� get��
		if(index.length==0) {//���õ� �ο찡 ��� �迭�� ���̰� 0�϶�
			JOptionPane.showMessageDialog(jf_addr,"������ ����� �������ּ���.","INFO"
										 ,JOptionPane.INFORMATION_MESSAGE);
		} else {//���� �����߱���
			for(int i=0;i<dtm_addr.getRowCount();i++) {//��ü �����;���� �ο찪�� ������ for���� �ְ���� ��������
				if(jt_addr.isRowSelected(i))//JTable�� ������ ���߿��� ���õǾ������� �Ҹ����� ���Ϲް�
				{System.out.println(dtm_addr.getValueAt(i,0));}//�Էµ� ���� ������
			}
		}
		
	}
	
	
	
	//���θ޼ҵ�
	//���θ޼ҵ� (�����)
	public static void main(String[] args) {
		AddressBookUI test = new AddressBookUI();
		test.getAddressList("��ö��");
	}

}
