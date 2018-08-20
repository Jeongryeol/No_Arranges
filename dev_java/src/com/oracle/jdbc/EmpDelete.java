package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmpDelete extends JFrame {//JOptionPane�� ���� ��ӽ�Ŵ

	DBConnection dbcon = new DBConnection();
	Connection con = null;
	Statement stmt = null;
					//�����Ҷ��� �Ķ���ͷ� PK�� ���� �ǰ���??
					//PK�� ����ũ�ϴ� + �ε�����  ������ �ִ� (�˻��ӵ� UP) + NOT NULL  
	public int empDel(int empno)
	{
		int result = 0;
		
/*		String sql ="";
		sql+="DELETE FROM emp    ";
		sql+=" WHERE empno="+empno;*/
	    
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM emp WEHERE empno = "+empno);
		
	    try {
	    	/* �ڹٿ����� �⺻������ AutoCommit��尡 �����ִ�.
	    	 * ��, �ڹٿ��� ����Ŭ ����� �ڵ� commit��
	    	 * ���� AutoCommit��带 ���� ������ �Ʒ� ����
	    	 * [Oracle] commit;  �� [JAVA.SQL] con.commit();
	    	 * [Oracle] rollback;  �� [JAVA.SQL] con.rollback(); */
	    	//con.setAutoCommit(false);
	    	
	    	con = dbcon.getConnection();//����õ�
	    	stmt = con.createStatement();//Statement�޼ҵ��ν��Ͻ�ȭ
	    	System.out.println("[[query]]"+sql);//������ ���
	    	result = stmt.executeUpdate(sql.toString());
	    	//Statement�޼ҵ忡 SQL���� �־ ����Ŭ�� �Է½�Ű�� �� ������� �ް� result������ �ʱ�ȭ��Ų��. 
	    	
	    	//insert here = �Է¼��� |�Է½���
	    	if(result==1) {
	    		System.out.println("��������!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"��������","ó�����"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("��������!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
		return result;
	}
	
}
