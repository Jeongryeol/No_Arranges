package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DBConnectionMgr;

/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [��ǥ]�ڹٿ��� DB�� commit�� �����ϱ�
 * 
 * �ݿ� : commit; -> con.commit();
 * ���� : rollback; -> con.rollback();
 *
 * �ڹ��� �ݿ� �⺻���� ����? autoCommit�̴�|�ƴϴ�
 ************************************************************/
public class CommitMode {
	/*�����*/
	//insert here :: DB������ ���� ����Ǿ���ϴ� ���
	DBConnectionMgr dbMgr	= null;	//Ŀ�ؼ� Ǯ�� ������� Ŭ���� �����ϱ�
	Connection		con		= null;	//Ŀ�ؼ� �������̽� �߰�
	//INSERT | UPDATE | DELETE �϶��� Ŀ�� �ش����.
	StringBuilder	sql		= new StringBuilder();//�������� ���� ��ü �߰�-StringBuffer or StringBuilder
	/*	String��� StringBuilder�� StringBuffer�� ����ϴ� ����??
		String�� ���ڿ��� �����ϰ� �߰�[+="�߰����ڿ�"]�ؼ� ������ �� ��ü�� �Ź� �����ǰ�,
		������ ������ �ʾƼ� �ݵ�� ���Կ����ڿ� ���� ��������.
		
		StringBuilder�� StringBuffer��  ������ �� ���ڴ����� ����ǰ�,
		�߰�[.append("�߰����ڿ�")]�Ͽ� ������ ���ϹǷ�, ȣ���ϸ� �ﰢ ��ȭ�Ȱ��� Ȯ���� �� �ִ�.
		
		StringBuilder�� StringBuffer�� ������ ��ȭ���Ѽ� �޸𸮿� �Ҵ�Ǵ� ���� ����
		StringBuilder�� �̱۽����忡�� | StringBuffer�� ��Ƽ�����忡�� �����ϴ�.
		
		BuilderŬ������ BufferŬ������ �������� ���� ��Ŀ������ Ȯ���� ��!! */
	PreparedStatement pstmt = null;	//�߰��� �������� ������ �������̽� �߰�
	
	/*��������Ǹ޼ҵ�*/
	public void methodA() {
		sql.append("INSERT INTO emp(empno,ename) VALUES(?,?)");
		dbMgr = DBConnectionMgr.getInstance();
		int result = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			//JDBC�� SQL��û�� �ڵ�Ŀ�Ը�尡 �⺻�̴�
			//�������� ������ �ʹٸ�?
			con.setAutoCommit(false);//����Ŀ�Ը��� ��ȯ��
			//true : ����Ŀ��, false: ����Ŀ��~����ó�������� ��ġ�� �ϰڴ�[ con.commit();, con.rollback(); ]
			
			//�Է���
			pstmt.setInt(1, 9958);
			pstmt.setString(2, "�׽�Ʈ�̸�");
			result = pstmt.executeUpdate();
			if(result==1) {
				System.out.println("�Է¼���");
			}else if(result==0) {
				System.out.println("�Է� ����");
			}
			//�Ʒ� �޼ҵ带 ������ �� Ʈ������ ó���� �����ϴ�.
			//Ʈ������ ó���� ������ �ϳ��� ��� ó���ϴ� �۾�
			//con.commit();
			//con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
	}
	
	/*���θ޼ҵ�*/
	public static void main(String[] args) {
		CommitMode cm = new CommitMode();
		cm.methodA();
	}
}
