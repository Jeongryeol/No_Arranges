package com.semi.addressbook_2nd;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
/*
 * [ DB������ ����ϴ� Ŭ���� Addr_DBConectionMgr ]
 * 	���뼺 ����!! - ���α׷��� ����ڰ� �����ϴ� �������� ���������� ���ǹǷ�,
 * 	�����ڸ� ���� �ٸ� ��� �޼ҵ忡�� ���Ǵ� ������������ �� �ּ�, ����̹� �������� �ѵ����� ������
 * 	���� ����, ���� ���� �پ��� ��Ȳ�� ���� �ڵ带 �Ϻ� �����ϴ� ������ ������ �� ����. 
 */
public class Addr_DBConnectionMgr {

	String input_URL	= "jdbc:oracle:thin:@";
	String input_USER	= null;
	String input_PW 	= null;

	Connection 	 con 	= null;// Connection ����, ���ü�
	
	void con(String _URL, String _USER, String _PW){

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(_URL, _USER, _PW);// �ּ�, �̸�, ��й�ȣ  �ν��Ͻ��� ���� ȿ��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}	//����Ŭ.�ڹ�API.����̹�.����Ŭ����̹�
	
	}
			
	public Addr_DBConnectionMgr() {//����

		input_URL += JOptionPane.showInputDialog("�����ϰ����ϴ� ������ IP�ּҸ� �Է��Ͻÿ�");
		input_URL += ":1521:orcl11";
		input_USER = JOptionPane.showInputDialog("������ �Է��Ͻʽÿ�");
		input_PW   = JOptionPane.showInputDialog("��й�ȣ�� �Է��Ͻʽÿ�");
		
//		final String _URL 	= input_URL;
//		final String _USER 	= input_USER;
//		final String _PW 	= input_PW;
		
		con(input_URL,input_USER,input_PW);
	}
}
