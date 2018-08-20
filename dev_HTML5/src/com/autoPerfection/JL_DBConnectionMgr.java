package com.autoPerfection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JL_DBConnectionMgr {

	public static JL_DBConnectionMgr dbMgr = null;
	
	public final String _DRIVER	= "oracle.jdbc.driver.OracleDriver";
	public final String _URL	= "jdbc:oracle:thin:@192.168.0.234:1521:orcl11";
	public final String _USER 	= "scott";
	public final String _PW		= "tiger";
	
	Connection			con		= null;
	PreparedStatement	pstmt	= null;//SQL�� �����Ҷ� ����ϴ� ����
	CallableStatement	cstmt	= null;//���ν����� ȣ���� �� ����ϴ� ����
	ResultSet			rs		= null;
	
	//DB������ �ʿ��� DBConnectionMgr �ν��Ͻ� ���
	public static JL_DBConnectionMgr getInstance() {
		if(dbMgr==null) {
			dbMgr = new JL_DBConnectionMgr();
		}
		return dbMgr;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		}catch (ClassNotFoundException cne) {
			System.out.println("����̹�Ŭ������ ã�� �� �����ϴ�.");
		}catch (Exception e) {
			System.out.println("����Ŭ �������� Ŀ�ؼ� ����!!!!!!");
		}
		return con;
	}
	
	//����� �ڿ� �ݳ��ϱ� (���������� �ݴ������ �ݱ�)
	/* 1. ���ν��� ȣ�⿡ ���ɶ��� 2��
	 * 2. INSERT, UPDATE, DELETE �϶��� 2��
	 * 3. SELECT �϶� 3�� 
	 */
	public void freeConnection(Connection con, CallableStatement cstmt) {
		try {
			if(cstmt!=null) cstmt.close();
			if(con!=null) con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
