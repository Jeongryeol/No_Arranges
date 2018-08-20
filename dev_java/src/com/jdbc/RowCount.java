package com.jdbc;
/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [��ǥ]�����͸� ��ȸ�ϰ�, ��ȸ�� ����� �ο���ڸ� ����� : getRowCount()
 ************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr;

public class RowCount {
	/*�����*/
	//insert here :: DB������ ���� ����Ǿ���ϴ� ���
	DBConnectionMgr dbMgr	= null;	//Ŀ�ؼ� Ǯ�� ������� Ŭ���� �����ϱ�
	Connection		con		= null;	//Ŀ�ؼ� �������̽� �߰�
	StringBuilder	sql		= new StringBuilder();//�������� ���� ��ü �߰�-StringBuffer or StringBuilder
	/*	String��� StringBuilder�� StringBuffer�� ����ϴ� ����??
		String�� ���ڿ��� �����ϰ� �߰�[+="�߰����ڿ�"]�ؼ� ������ �� ��ü�� �Ź� �����ǰ�,
		������ ������ �ʾƼ� �ݵ�� ���Կ����ڿ� ���� ��������.
		
		StringBuilder�� StringBuffer��  ������ �� ���ڴ����� ����ǰ�,
		�߰�[.append("�߰����ڿ�")]�Ͽ� ������ ���ϹǷ�, ȣ���ϸ� �ﰢ ��ȭ�Ȱ��� Ȯ���� �� �ִ�.
		
		StringBuilder�� StringBuffer�� ������ ��ȭ���Ѽ� �޸𸮿� �Ҵ�Ǵ� ���� ����
		StringBuilder�� �̱۽����忡�� | StringBuffer�� ��Ƽ�����忡�� �����ϴ�.
		
		BuilderŬ������ BufferŬ������ �������� ���� ��Ŀ������ Ȯ���� ��!! */
	PreparedStatement pstmt	= null;	//�������� ������ �������̽� �߰�
	ResultSet		  rs	= null;	//Ŀ���� �����ϴ� �������̽� �߰�
	
	/*��������Ǹ޼ҵ�*/
	//ORACLE�� ���Ŀ���� ��ȸ�� ��� row�� ������ Ȯ���ϴ� ���� �ڹٿ��� �����غ���
	public int getRowCount() {
		int result = 0;
		sql.append("SELECT empno FROM emp");
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_SENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			/* [preparedStatement(ResultSet.OPTIONS)
			 * TYPE_FORWORD_ONLY		:: ���������� Ŀ���� �̵�
			 * TYPE_SCROLL_INSENSITIVE	:: ����������� Ŀ���̵� (���ü� �����ȵ�)
			 * TYPE_SCROLL_SENSITIVE	:: ���������� Ŀ���̵� (���ü� ����)
			 * CONCUR_UPDATABLE			:: ���������� Ŀ��
			 * CONCUR_READ_ONLY			:: ��ȭ�� �ټ� ���� �б⸸ ������ Ŀ��
			 */
			rs = pstmt.executeQuery();
			rs.last();
			result = rs.getRow();
			rs.beforeFirst();
			System.out.println("Total row : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs); //�ڿ� �ݳ��ϱ�
		}
		return result;
	}
	
	/*���θ޼ҵ�*/
	public static void main(String[] args) {
		int result =0;
		RowCount rc = new RowCount();
		result = rc.getRowCount();
		System.out.println("�츮ȸ�翡 �ٹ��ϴ� ������� ��  : "+result);
	}

}
