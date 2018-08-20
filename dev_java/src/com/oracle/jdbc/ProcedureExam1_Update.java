package com.oracle.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
/*
 * ���������� �������ִ� DB����(oracle)�� Ŀ�ؼ� �α�
 * �н���ǥ
 * ���� �ڹٿ��� �����ϴ� API�� Ȱ���Ͽ� ���ν����� ȣ���ϰ� �� ������� �޾ƿ� �� �ִ�.
 */
public class ProcedureExam1_Update {
	
	//�����
	DBConnection dbcon = new DBConnection();
	Connection con = null;
	CallableStatement cstmt = null;
	
	//������
	public ProcedureExam1_Update() {
//		System.out.println(userInput());//������ �� ȣ��+��� [�����׽�Ʈ2/3]
		int pempno = userInput();
		String msg = salaryUpdate(pempno);
		System.out.println("[[ó�����]]"+msg);
	}
	
	//��������� �޼ҵ�
	//1.����ڷκ��� �����ȣ�� �Է¹޴� �޼ҵ� ���� : userInput() [ DB���� ���ʿ� ]
	public int userInput() {
		int empno=0;
		String u_empno = JOptionPane.showInputDialog("�����ȣ�� �Է����ּ���.");
		empno = Integer.parseInt(u_empno);
		return empno;//����Ÿ���� �ִ� �޼ҵ�� ����� �� �� �ִ�.[�����׽�Ʈ1/3]
	}
	//2.�Է¹��� �����ȣ�� ������ �޿��� �λ�ó���ϴ� �޼ҵ� ���� : salaryUpdate() [ DB���� ]
	public String salaryUpdate(int pempno) {
		String msg = null;
		try {
			//���������� ������ DB������ Ŀ�ؼ� �α�
			con = dbcon.getConnection();
			//����Ŭ ������ ���ν��� ȣ���ϱ�
			cstmt = con.prepareCall("{call proc_emp_sal_update(?,?)}");
			//�� ���ν��� ȣ���� �� �ĸ����� �ѱ��
			cstmt.setInt(1,pempno);
			cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			//�� ���ν��� ó�� ��û�ϱ�
			int result = cstmt.executeUpdate();
			msg =cstmt.getString(2);
		}catch(Exception e) {
		}
		//System.out.println("XXX����� 1.2�޿��λ����� XXX�� �Ǿ����ϴ�.");
		//����� �ٸ� �޼ҵ�� �ѱ������ msg ����
		return msg;
	}
/*	SQL���� SELECT�� UPDATE�� �� �����̹Ƿ�
	���ν����� �Ķ���ͷ� �޼ҵ��� �Ķ���Ϳ� ����Ÿ���� ������ �� �ִ�.
	���ν����� �Ķ���Ͱ� IN�� ��� �Է��ϴ� ���̹Ƿ� �޼ҵ��� �Ķ���Ϳ� ������.
	���ν����� �Ķ���Ϳ� OUT�� �ִ� ��� ����ϴ� ���̹Ƿ� �޼ҵ��� ����Ÿ���� ����������.*/
	
	//���θ޼ҵ�
	public static void main(String[] args) {
		new ProcedureExam1_Update();
		
	}

}
