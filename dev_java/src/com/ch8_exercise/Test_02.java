package com.ch8_exercise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.jdbc.DBConnection;

public class Test_02 {
	
	public static void main(String[] args) {
		DBConnection dbcon = null;
		Connection con = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;//오라클 커서를 조작하는데 필요한 메소드 제공,  next(), isFirst()
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno2 FROM dept");
		
		try {
			//methodA();
			//예외발생가능성이 있는 코드
			dbcon = new DBConnection();
			con = dbcon.getConnection();//연결이 잘못된 내용과 관련한 예외발생가능
			pstmt = con.prepareStatement(sql.toString());//NullPointException 발생가능
			rs = pstmt.executeQuery();
			System.out.println(rs.next());
			
		}catch(SQLException se) {
			//존재하지않는 에러로 인해  생기는 논리문제
			//SQL문에 대한 에러이므로 25번줄의 sql문에 대한 대응가능
			System.out.println("힌트를 넣어서 제발 보자..!");
			//SQL문에러에 대한 Toad의 Oracle에러를 확인가능
			//하지만, Toad에서 단위테스트한 다음에 사용하자
			System.out.println("[[SQLException]] : "+se.toString());
			//쿼리문에 대한 내용을 출력해서 Toad에서 단위테스트 하자
			System.out.println("[[query]] : "+sql.toString());
/*		}catch(IOException ie) {
			System.out.println("Caught IOException");*/
		}catch(Exception e) {
			System.out.println("Caught Exception"); 
		}
	}

	public static void methodA() throws IOException {
		//throws를 메소드에 쓰면,
		//호출한 다른 메소드에서 예외를 처리하도록 미룬다.
		throw new IOException();
	}
	
/*	public void methodA() {
		//throw를 실행문에서 사용하면 즉시 예외를 발생시키므로
		//반드시 try-catch 구문에서 에러를 잡아야한다.
		try {
			throw new IOException();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
}

	//What is the result?
	/*
		A. Compilation fails. [정답]
		B. The output is "Caught Exception." [ ● ]
		C. The output is "Caught IOException."
		D. The program executes normally whithout printing a message.
	*/