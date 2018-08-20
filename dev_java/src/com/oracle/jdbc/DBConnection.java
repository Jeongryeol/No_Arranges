package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * �� Ŭ������ ���������� �ʿ��� �ڵ带 �߰��ϴ� Ŭ������.
 * �ܵ����� ����Ǵ� Ŭ������ �ƴ�
 * main�޼ҵ�� ����.
 */
public class DBConnection {
//											IP�ּ�		  Port SID
	final String _URL 	= "jdbc:oracle:thin:@192.168.0.18:1521:orcl11";
	final String _USER 	= "scott";
	final String _PW	= "tiger";
	
	Connection 	con		= null;
	
	//JAVA�� �޼ҵ��߽����� �ڵ��ϰ��ؼ� �����ϰ� ������
	public Connection getConnection() {
	    try {
	    	/*[1�ܰ�] : DB���� ��ǰ�� ����̹� Ŭ������ �޸𸮿� �ε��Ѵ�. - decode����
	    	 *	DriverClass : ������,���, Ư�� Ȯ��
	    	 *	����Ŭȸ�翡�� ����̺������� ��������� ��
	    	 * 		E:\app\509\product\11.1.0\db_1\jdbc\lib :: ���̺귯�� �� JAR File Ȯ�� (��޾��)
	    	 * 		ojdbc6\oracle\jdbc\driver :: JAR File �� class file Ȯ�� (���޾��)
	    	 *  ����Ŭ���� �����ϴ� JAR����̺� �߰��ϱ� ( ��Ʈ W05-3 ���� )
	    	 */
	    	Class.forName("oracle.jdbc.driver.OracleDriver");		
			//[2�ܰ�] : ���������� �������ִ� DB������ �����ϱ�. - Ŀ�ؼǸα�
			con = DriverManager.getConnection(_URL, _USER, _PW);//�ν��Ͻ�ȭ�� ���� ȿ��	    	
	    } catch(Exception e) {
	    	System.out.println(e.toString());
	    }
		return con;
	}
}
