package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmpSelect extends JFrame {

	DBConnection dbcon = new DBConnection();
	Connection con = null;
	Statement stmt = null;
	
	public EmpVO[] empSel()	{
		
		EmpVO[] evos = new EmpVO[14];//��ü�迭�� ����ϱ� ���� ���� EmpVO
		int result = 0;
		String sql="";
		
		try {
	    	con = dbcon.getConnection();//����õ�
	    	stmt = con.createStatement();//Statement�޼ҵ��ν��Ͻ�ȭ
	    	System.out.println("[[query]]"+sql);//������ ���
	    	result = stmt.executeUpdate(sql);
	    	//Statement�޼ҵ忡 SQL���� �־ ����Ŭ�� �Է½�Ű�� �� ������� �ް� result������ �ʱ�ȭ��Ų��.
			
	    	if(result==1) {
	    		System.out.println("��ȸ����!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"��ȸ����","ó�����"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("��ȸ����!! result = "+result);	    		
	    	}
		} catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
		}
		
		return evos;
	}
	public static void main(String args[]) {
		EmpSelect aa = new EmpSelect();
		aa.empSel();
	}
}
