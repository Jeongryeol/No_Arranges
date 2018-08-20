package com.semi.addressbook_2nd;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
/*
 * [ DB연결을 담당하는 클래스 Addr_DBConectionMgr ]
 * 	재사용성 증가!! - 프로그램과 사용자가 소통하는 과정에서 공통적으로 사용되므로,
 * 	생성자를 통해 다른 모든 메소드에서 사용되는 계정관련정보 및 주소, 드라이버 정보들을 한데묶어 실행함
 * 	이후 변경, 이전 등의 다양한 상황에 기존 코드를 일부 변경하는 것으로 대응할 수 있음. 
 */
public class Addr_DBConnectionMgr {

	String input_URL	= "jdbc:oracle:thin:@";
	String input_USER	= null;
	String input_PW 	= null;

	Connection 	 con 	= null;// Connection 연결, 관련성
	
	void con(String _URL, String _USER, String _PW){

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(_URL, _USER, _PW);// 주소, 이름, 비밀번호  인스턴스와 같은 효과
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}	//오라클.자바API.드라이버.오라클드라이버
	
	}
			
	public Addr_DBConnectionMgr() {//연결

		input_URL += JOptionPane.showInputDialog("접속하고자하는 서버의 IP주소를 입력하시오");
		input_URL += ":1521:orcl11";
		input_USER = JOptionPane.showInputDialog("계정을 입력하십시오");
		input_PW   = JOptionPane.showInputDialog("비밀번호를 입력하십시오");
		
//		final String _URL 	= input_URL;
//		final String _USER 	= input_USER;
//		final String _PW 	= input_PW;
		
		con(input_URL,input_USER,input_PW);
	}
}
