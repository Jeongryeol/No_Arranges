package com.jdbc;
/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [��ǥ]�����͸� �߰��ϰ� ��ȸ�ϰ�, �����ϰ� ��ȸ�ϱ�.
 ************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnectionMgr;

public class ResultSet_InsDel {
	/*�����*/
	//insert here :: DB������ ���� ����Ǿ���ϴ� ���
	DBConnectionMgr dbMgr	= null;	//Ŀ�ؼ� Ǯ�� ������� Ŭ���� �����ϱ�
	Connection		con		= null;	//Ŀ�ؼ� �������̽� �߰�
	//�������� ���� ��ü �߰�-StringBuffer or StringBuilder
	StringBuilder	sql		= new StringBuilder();
	/*	String��� StringBuilder�� StringBuffer�� ����ϴ� ����??
		String�� ���ڿ��� �����ϰ� �߰�[+="�߰����ڿ�"]�ؼ� ������ �� ��ü�� �Ź� �����ǰ�,
		������ ������ �ʾƼ� �ݵ�� ���Կ����ڿ� ���� ��������.
		
		StringBuilder�� StringBuffer��  ������ �� ���ڴ����� ����ǰ�,
		�߰�[.append("�߰����ڿ�")]�Ͽ� ������ ���ϹǷ�, ȣ���ϸ� �ﰢ ��ȭ�Ȱ��� Ȯ���� �� �ִ�.
		
		StringBuilder�� StringBuffer�� ������ ��ȭ���Ѽ� �޸𸮿� �Ҵ�Ǵ� ���� ����
		StringBuilder�� �̱۽����忡�� | StringBuffer�� ��Ƽ�����忡�� �����ϴ�.
		
		BuilderŬ������ BufferŬ������ �������� ���� ��Ŀ������ Ȯ���� ��!! */
	PreparedStatement pstmtInsert = null;	//�߰��� �������� ������ �������̽� �߰�
	PreparedStatement pstmtDelete = null;	//������ �������� ������ �������̽� �߰�
	ResultSet		  rs	= null;	//Ŀ���� �����ϴ� �������̽� �߰�
	
	/*��������Ǹ޼ҵ�*/
	//�����͸� �߰��ϰ� ��ȸ�ϰ� �����ϰ� ��ȸ�ϱ���� �ѹ��� ������ �޼ҵ�
	public void doInsertAndDelete() {
		dbMgr = DBConnectionMgr.getInstance();
		sql.append("SELECT empno, ename FROM emp");
		try {
			con = dbMgr.getConnection();
			pstmtInsert = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			rs = pstmtInsert.executeQuery();
			//�������߰��ϱ�
			rs.moveToInsertRow();//�߰� ������ �ο�� Ŀ�� �̵�
			rs.updateInt(1,9555);
			rs.updateString(2,"�̱���");
			rs.insertRow();
			
			rs.moveToInsertRow();//�߰� ������ �ο�� Ŀ�� �̵�
			rs.updateInt(1,9556);
			rs.updateString(2,"���翵");
			rs.insertRow();
			//rs.close();
			
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("=====[������ �߰� �� ���̺� ����Ʈ]=====");
			while(rs.next()) {
				System.out.println("�����ȣ :"+rs.getInt("empno")
					//		+". ����� : "+rs.getString(2));//�÷����� �̸��� ���� ������ �������� �ø���
							+". ����� : "+rs.getString("ename"));
			}
			
			System.out.println("=====[������ ���� �� ���̺� ����Ʈ]=====");
			pstmtDelete = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			rs = pstmtDelete.executeQuery();
			
			
			//������  �����ϱ�
			if(!rs.isBeforeFirst()) {//Ŀ���� �� ������ ��ġ�� �ִ� �� üũ
				rs.beforeFirst();//Ŀ���� ��ġ�� �� ���������� �̵�
			}
			while(rs.next()) {
				if(rs.getInt("empno")==9555) {
					rs.deleteRow();
				}
				if(rs.getInt("empno")==9556) {
					rs.deleteRow();
				}
			}
			if(!rs.isBeforeFirst()) {//Ŀ���� �� ������ ��ġ�� �ִ� �� üũ
				rs.beforeFirst();//Ŀ���� ��ġ�� �� ���������� �̵�
			}
			//�����͸� ��ȸ��
			while(rs.next()) {
				System.out.println("�����ȣ :"+rs.getInt("empno")
				//		+". ����� : "+rs.getString(2));//�÷����� �̸��� ���� ������ �������� �ø���
				+". ����� : "+rs.getString("ename"));
			}
			rs.close();
			
		} catch (SQLException sqle) {
			System.out.println("[[query]] "+sql.toString());
			System.out.println(sqle.toString());
			System.out.println(sqle.getMessage());
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmtInsert, rs);
			try {
				if(pstmtDelete!=null) pstmtDelete.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	/*���θ޼ҵ�*/
	public static void main(String[] args) {
		ResultSet_InsDel rsID = new ResultSet_InsDel();
		rsID.doInsertAndDelete();
	}

}
