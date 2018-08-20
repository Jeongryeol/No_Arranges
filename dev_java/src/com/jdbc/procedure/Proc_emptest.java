package com.jdbc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.oracle.jdbc.DBConnection;
import com.util.DBConnectionMgr;
/**************************************************************************************
 * 
 * @author Jeongryeol Lee
 * @since 2018.07.11
 *
 *	[��ǥ] ORACLE���� ������ ���ν���(proc_emptest)�� Java���� ����ϱ�
 *	[�׽�Ʈ����]
 *		1) ���ν���  ȣ���ϱ�
 *		2) ���ν���  �Ķ����(a:IN�Ӽ�, b:OUT�Ӽ�)
 *	[���ν��� ����]
 *		CREATE OR REPLACE PROCEDURE proc_studentINS
			    (pstd_no     IN NUMBER
			    ,pgrade      IN NUMBER
			    ,pdepartment IN VARCHAR2
			    ,psname      IN VARCHAR2
			    ,msg        OUT VARCHAR2
			    )
 *
 *		CREATE OR REPLACE PROCEDURE proc_emptest(p_empno IN number,msg OUT varchar2)
 *		
 **************************************************************************************/
public class Proc_emptest {
	/*�����*/
	//insert here :: DB������ ���� ����Ǿ���ϴ� ���
	DBConnectionMgr dbMgr	= null;	//Ŀ�ؼ� Ǯ�� ������� Ŭ���� �����ϱ�
	Connection		con		= null;	//Ŀ�ؼ� �������̽� �߰�
	CallableStatement cstmt	= null;	//�������� ������ �������̽� �߰�

	/*��������Ǹ޼ҵ�*/
	//student ���̺� �߰��ϴ� ���ν��� ó���ϱ�
	/** @param p(parameter) �Է°��� ��� ���� / r(return) ���ϰ��� ��� ����*/
	public void studentIns(int pstd_no, int pgrade, String pdepartment, String psname) {
		dbMgr = DBConnectionMgr.getInstance();	//Ŀ�ؼ� Ǯ ����
		int result = 0;	//����Ŭ�����κ��� ���� ������� ��� ���� ( 0:����, 1:���� )
		String rmsg = null;
		try {
			con = dbMgr.getConnection();
			/******************************************************************************
			 * 
			 * <<NOTICE>>
			 * SQL[SELECT] ~ executeQueru():ResultSet
			 * SQL[INS,DEL,UPD] ~ executeUpdate():int
			 * PL/SQL[PROCEDURE] ~ prepareCall("{call ���ν����̸�(�Ķ����)}"):ORACLE TYPE�� �°� ����
			 *  
			 ******************************************************************************/
			cstmt = con.prepareCall("{call proc_studentINS2(?,?,?,?,?)}");
			cstmt.setInt(1, pstd_no);		//ù��° ?�ڸ��� �Ķ���ͷ� ���� ���� �־ ���ν����� IN�Ӽ��� ����
			cstmt.setInt(2, pgrade);		//�ι�° ?�ڸ��� �Ķ���ͷ� ���� ���� �־ ���ν����� IN�Ӽ��� ����
			cstmt.setString(3, pdepartment);//����° ?�ڸ��� �Ķ���ͷ� ���� ���� �־ ���ν����� IN�Ӽ��� ����
			cstmt.setString(4, psname);		//�׹�° ?�ڸ��� �Ķ���ͷ� ���� ���� �־ ���ν����� IN�Ӽ��� ����
			cstmt.registerOutParameter(5, java.sql.Types.INTEGER);//�ټ���° ?�ڸ��� ���ν����� OUT�Ӽ��� ����
			
			result = cstmt.executeUpdate();//�ڹٰ� ����Ŭ������ ó����û�Ͽ� �������
			System.out.println("Java�� ORACLE SERVER�� ��û�Ͽ� ���� ����� result = "+result);
			
			rmsg = cstmt.getString(5);
			System.out.println(rmsg);
			
			if("1".equals(rmsg)) {
				System.out.println("�Է¼���");
			}else {
				System.out.println("�Է½��� / rmsg = "+rmsg);
			}
			
		} catch (SQLException se) {
			System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	/** @param p(parameter) �Է°��� ��� ���� / r(return) ���ϰ��� ��� ����*/
	public void methodA(int pempno, String rmsg) {
		dbMgr = DBConnectionMgr.getInstance();	//Ŀ�ؼ� Ǯ ����
		int result = 0;	//����Ŭ�����κ��� ���� ������� ��� ���� ( 0:����, 1:���� )
		try {
			con = dbMgr.getConnection();
			/******************************************************************************
			 * 
			 * <<NOTICE>>
			 * SQL[SELECT] ~ executeQueru():ResultSet
			 * SQL[INS,DEL,UPD] ~ executeUpdate():int
			 * PL/SQL[PROCEDURE] ~ prepareCall("{call ���ν����̸�(�Ķ����)}"):ORACLE TYPE�� �°� ����
			 *  
			 ******************************************************************************/
			cstmt = con.prepareCall("{call proc_emptest(?,?)}");
			cstmt.setInt(1, pempno);//ù��° ?�ڸ��� �Ķ���ͷ� ���� ���� �־ ���ν����� IN�Ӽ��� ����
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);//�ι�° ?�ڸ��� ���ν����� OUT�Ӽ��� ����
			
			result = cstmt.executeUpdate();//�ڹٰ� ����Ŭ������ ó����û�Ͽ� �������
			System.out.println("Java�� ORACLE SERVER�� ��û�Ͽ� ���� ����� result = "+result);
			
			rmsg = cstmt.getString(2);
			System.out.println(rmsg);
			
		} catch (SQLException se) {
			System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	/*���θ޼ҵ�*/
	public static void main(String[] args) {
		Proc_emptest pe = new Proc_emptest();
	/*
		System.out.println("�����ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);//�Էµ� ���� �д� ��ĳ�� Ŭ������ Ȱ���ؼ� �Է¹��� ���� ��ĵ��
		int pempno = 0;
		String temp = scan.nextLine();
		pempno = Integer.parseInt(temp);
		String rmsg = null;
		pe.methodA(pempno,rmsg);
	*/
		pe.studentIns(18020119, 3, "��ȸü���а�", "�̼���");
	}

}
