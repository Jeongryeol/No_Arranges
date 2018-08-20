package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class EmpUpdate extends JFrame {//JOptionPane�� ���� ��ӽ�Ŵ

	DBConnection dbcon = new DBConnection();
	Connection con = null;
	Statement stmt = null;
	
	public int empUpd(int empno, String ename, String job, String hiredate)
	{
		int result = 0;//ó����� ��ȯ�� ������ �������� ( 1:�������� / 0: �������� )
		/* �ڡڡ�[������ ����Ű]-[�ϰ��Է�]�ڡڡ�
		 * Shift+Alt+A Ű�� �̿��ؼ� �ϰ��Է»��·� Ŀ���� ����(��)
		 * �ϰ��Է��� ������ �巡�� �� ����ϰ�, �ϰ��Է�
		 * Shift+Alt+A ���Է��ؼ� �ϰ��Է»��� ���� */
		String sql = ""; 
		sql+="UPDATE emp                       ";
		sql+="   SET ename    = '"+ename+"'    ";
		sql+="      ,job      = '"+job+"'      ";
		sql+="      ,hiredate = '"+hiredate+"' ";
		sql+=" WHERE empno="+empno+"           ";
	    
	    try {
	    	//con.setAutoCommit(false);
	    	con = dbcon.getConnection();//����õ�
	    	stmt = con.createStatement();//Statement�޼ҵ��ν��Ͻ�ȭ
	    	System.out.println("[[query]]"+sql);//������ ���
	    	result = stmt.executeUpdate(sql);
	    	//Statement�޼ҵ忡 SQL���� �־ ����Ŭ�� �Է½�Ű�� �� ������� �ް� result������ �ʱ�ȭ��Ų��. 
	    	
	    	//insert here = �Է¼��� |�Է½���
	    	if(result==1) {
	    		System.out.println("�Է¼���!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"��������","ó�����"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("�Է½���!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
	    return result;
	}

	public int empUpd(EmpVO evo) {
		int result = 0;
		
	/*	String sql = ""; 
		sql+="UPDATE emp                       ";
		sql+="   SET ename    = '"+ename+"'    ";
		sql+="      ,job      = '"+job+"'      ";
		sql+="      ,hiredate = '"+hiredate+"' ";
		sql+=" WHERE empno="+empno+"           ";*/
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE emp SET ename = "+evo.getEname()+", job = "+evo.getJob()
				+", hiredate = "+evo.getHiredate()+" WHERE empno = "+evo.getEmpno());
	    
	    try {
	    	//con.setAutoCommit(false);
	    	con = dbcon.getConnection();//����õ�
	    	stmt = con.createStatement();//Statement�޼ҵ��ν��Ͻ�ȭ
	    	System.out.println("[[query]]"+sql);//������ ���
	    	result = stmt.executeUpdate(sql.toString());
	    	//Statement�޼ҵ忡 SQL���� �־ ����Ŭ�� �Է½�Ű�� �� ������� �ް� result������ �ʱ�ȭ��Ų��. 
	    	
	    	//insert here = �Է¼��� |�Է½���
	    	if(result==1) {
	    		System.out.println("�Է¼���!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"��������","ó�����"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("�Է½���!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
	    
		return result;
	}

}
