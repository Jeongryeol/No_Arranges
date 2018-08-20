package com.oracle.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.swing.JOptionPane;

public class ProcedureExam2_CURSOR {

	//�����
	DBConnection dbcon = new DBConnection();
	Connection con = null;
	CallableStatement cstmt = null;	
	
	//������
	public ProcedureExam2_CURSOR() {
//		System.out.println(userInput());//������ �� ȣ��+��� [�����׽�Ʈ2/3]
		int deptno = userInput();
		String msg = salaryUpdate(deptno);
		System.out.println("[[ó�����]]"+msg);
	}//msg�� �������� ��µǵ��� ���ν������� �޾Ƶΰ�, �� ���߰��� �޾� �ͼ� �� �ٿ��� �����
	
	
	//����� ���� �޼ҵ�
	//1. ����ڷκ��� �μ���ȣ�� �Է¹޴� �޼ҵ� �����ϱ�
	public int userInput() {
		int deptno=0;
		String u_deptno = JOptionPane.showInputDialog("�μ���ȣ�� �Է����ּ���.");
		deptno = Integer.parseInt(u_deptno);
		return deptno;//����Ÿ���� �ִ� �޼ҵ�� ����� �� �� �ִ�.[�����׽�Ʈ1/3]
	}
	
	//2. �Է¹��� �μ���ȣ�� ������ �޿��λ��� ������Ʈ(ó��)�ϴ� �޼ҵ� �����ϱ�
	public String salaryUpdate(int pdeptno) {
		String msg = null;
		try {
			//����Ŀ�� ��Ȱ��ȭ
			con.setAutoCommit(false);
			//���������� ������ DB������ Ŀ�ؼ� �α�
			con = dbcon.getConnection();
			//����Ŭ ������ ���ν��� ȣ���ϱ�
			cstmt = con.prepareCall("{call proc_emp_update_salary(?,?)}");
			//�� ���ν��� ȣ���� �� �ĸ����� �ѱ��
			cstmt.setInt(1,pdeptno);
			cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			//�� ���ν��� ó�� ��û�ϱ�
			int result = cstmt.executeUpdate();
			msg =cstmt.getString(2);
		}catch(Exception e) {
		}
		return msg;
	}
	
	//���θ޼ҵ�
	public static void main(String[] args) {
		new ProcedureExam2_CURSOR();
	}
}
