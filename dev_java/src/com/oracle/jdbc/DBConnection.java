package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * 이 클래스는 공통적으로 필요한 코드를 추가하는 클래스임.
 * 단독으로 실행되는 클래스가 아님
 * main메소드는 버림.
 */
public class DBConnection {
//											IP주소		  Port SID
	final String _URL 	= "jdbc:oracle:thin:@192.168.0.18:1521:orcl11";
	final String _USER 	= "scott";
	final String _PW	= "tiger";
	
	Connection 	con		= null;
	
	//JAVA가 메소드중심으로 코딩하게해서 재사용하게 해주자
	public Connection getConnection() {
	    try {
	    	/*[1단계] : DB서버 제품의 드라이버 클래스를 메모리에 로딩한다. - decode지원
	    	 *	DriverClass : 제조사,기능, 특성 확인
	    	 *	오라클회사에서 드라이브정보를 제공해줘야 함
	    	 * 		E:\app\509\product\11.1.0\db_1\jdbc\lib :: 라이브러리 내 JAR File 확인 (고급언어)
	    	 * 		ojdbc6\oracle\jdbc\driver :: JAR File 내 class file 확인 (저급언어)
	    	 *  오라클에서 제공하는 JAR드라이브 추가하기 ( 노트 W05-3 참고 )
	    	 */
	    	Class.forName("oracle.jdbc.driver.OracleDriver");		
			//[2단계] : 물리적으로 떨어져있는 DB서버에 접속하기. - 커넥션맺기
			con = DriverManager.getConnection(_URL, _USER, _PW);//인스턴스화와 같은 효과	    	
	    } catch(Exception e) {
	    	System.out.println(e.toString());
	    }
		return con;
	}
}
