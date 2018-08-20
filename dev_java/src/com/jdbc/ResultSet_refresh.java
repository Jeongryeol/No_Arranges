package com.jdbc;
/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [��ǥ]�ڹٿ��� ������Ʈ�ϰ� �����ϱ�
 * 
 ************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr;

public class ResultSet_refresh {
	/*�����*/
	//insert here :: DB������ ���� ����Ǿ���ϴ� ���
	DBConnectionMgr dbMgr	= null;	//Ŀ�ؼ� Ǯ�� ������� Ŭ���� �����ϱ�
	Connection		con		= null;	//Ŀ�ؼ� �������̽� �߰�
	//�������� ���� ��ü �߰�-StringBuffer or StringBuilder
	StringBuilder	sql		= new StringBuilder();
/*	String��� StringBuilder�� StringBuffer�� ����ϴ� ����??
 * 	String�� ���ڿ��� �����ϰ� �߰�[+="�߰����ڿ�"]�ؼ� ������ �� ��ü�� �Ź� �����ǰ�,
 * 	������ ������ �ʾƼ� �ݵ�� ���Կ����ڿ� ���� ��������.
 *
 *	StringBuilder�� StringBuffer��  ������ �� ���ڴ����� ����ǰ�,
 *	�߰�[.append("�߰����ڿ�")]�Ͽ� ������ ���ϹǷ�, ȣ���ϸ� �ﰢ ��ȭ�Ȱ��� Ȯ���� �� �ִ�.
 *	
 *	StringBuilder�� StringBuffer�� ������ ��ȭ���Ѽ� �޸𸮿� �Ҵ�Ǵ� ���� ����
 *	StringBuilder�� �̱۽����忡�� | StringBuffer�� ��Ƽ�����忡�� �����ϴ�.
 *	BuilderŬ������ BufferŬ������ �������� ���� ��Ŀ������ Ȯ���� ��!! */
	PreparedStatement pstmt1 = null;	//�������� ������ �������̽� �߰�
	PreparedStatement pstmt2 = null;	//�������� ������ �������̽� �߰�
	ResultSet		  rs	 = null;	//Ŀ���� �����ϴ� �������̽� �߰�
	
	/*��������Ǹ޼ҵ�*/
	public void methodA() {
		dbMgr = DBConnectionMgr.getInstance();
		sql.append("SELECT empno, ename, sal FROM emp");
		try {
			con = dbMgr.getConnection();
			pstmt1 = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_READ_ONLY);
			//OPEN-CURSOR-FETCH
			//Fetch��, ������ ���̽����� ������ ���������� block�� �ִ� row��
			//���ϴ� ��� ���ϴ� �÷� ���¿� ���� Ŭ���̾�Ʈ�� �����ִ� �����̴�.
			//���� 100���� ���� setFetchSize(10)���� �����ϸ� 10ȸ�� I/O�� �߻��ȴ�.
			
			pstmt1.setFetchSize(1);
			//trigger�������� Toad���� Ʈ���Ÿ� �����ش� :: alter trigger tri_test3 dsiable
			rs = pstmt1.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+", "+rs.getString("ename")+", "+rs.getDouble("sal"));
			}
			
			sql = new StringBuilder();
			sql.append("UPDATE emp SET sql=sql+500");
			pstmt2 = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_READ_ONLY);
			pstmt2.executeUpdate();
			pstmt2.close();
			
			System.out.println("���� �� refresh�� ���� emp���̺� ����Ʈ");
			double salary = 0.0;
			while(rs.next()) {
				salary = rs.getDouble("sal");
				System.out.print("salary : "+salary+"������");
				rs.refreshRow();
				System.out.println(rs.getInt("empno")+"|"+rs.getString("ename")+"|"+rs.getDouble("sal"));
			}
			
		} catch (Exception e) {

		}
		
	}
	
	/*���θ޼ҵ�*/
	public static void main(String[] args) {
		ResultSet_refresh rr = new ResultSet_refresh();
		rr.methodA();
	}
}
