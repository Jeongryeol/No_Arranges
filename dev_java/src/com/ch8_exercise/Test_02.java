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
		ResultSet rs = null;//����Ŭ Ŀ���� �����ϴµ� �ʿ��� �޼ҵ� ����,  next(), isFirst()
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno2 FROM dept");
		
		try {
			//methodA();
			//���ܹ߻����ɼ��� �ִ� �ڵ�
			dbcon = new DBConnection();
			con = dbcon.getConnection();//������ �߸��� ����� ������ ���ܹ߻�����
			pstmt = con.prepareStatement(sql.toString());//NullPointException �߻�����
			rs = pstmt.executeQuery();
			System.out.println(rs.next());
			
		}catch(SQLException se) {
			//���������ʴ� ������ ����  ����� ������
			//SQL���� ���� �����̹Ƿ� 25������ sql���� ���� ��������
			System.out.println("��Ʈ�� �־ ���� ����..!");
			//SQL�������� ���� Toad�� Oracle������ Ȯ�ΰ���
			//������, Toad���� �����׽�Ʈ�� ������ �������
			System.out.println("[[SQLException]] : "+se.toString());
			//�������� ���� ������ ����ؼ� Toad���� �����׽�Ʈ ����
			System.out.println("[[query]] : "+sql.toString());
/*		}catch(IOException ie) {
			System.out.println("Caught IOException");*/
		}catch(Exception e) {
			System.out.println("Caught Exception"); 
		}
	}

	public static void methodA() throws IOException {
		//throws�� �޼ҵ忡 ����,
		//ȣ���� �ٸ� �޼ҵ忡�� ���ܸ� ó���ϵ��� �̷��.
		throw new IOException();
	}
	
/*	public void methodA() {
		//throw�� ���๮���� ����ϸ� ��� ���ܸ� �߻���Ű�Ƿ�
		//�ݵ�� try-catch �������� ������ ��ƾ��Ѵ�.
		try {
			throw new IOException();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
}

	//What is the result?
	/*
		A. Compilation fails. [����]
		B. The output is "Caught Exception." [ �� ]
		C. The output is "Caught IOException."
		D. The program executes normally whithout printing a message.
	*/