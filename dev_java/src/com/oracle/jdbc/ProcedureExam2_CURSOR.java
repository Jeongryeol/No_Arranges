package com.oracle.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.swing.JOptionPane;

public class ProcedureExam2_CURSOR {

	//선언부
	DBConnection dbcon = new DBConnection();
	Connection con = null;
	CallableStatement cstmt = null;	
	
	//생성자
	public ProcedureExam2_CURSOR() {
//		System.out.println(userInput());//생성자 내 호출+출력 [단위테스트2/3]
		int deptno = userInput();
		String msg = salaryUpdate(deptno);
		System.out.println("[[처리결과]]"+msg);
	}//msg가 다중으로 출력되도록 프로시저에서 받아두고, 그 다중값을 받아 와서 윗 줄에서 출력함
	
	
	//사용자 정의 메소드
	//1. 사용자로부터 부서번호를 입력받는 메소드 구현하기
	public int userInput() {
		int deptno=0;
		String u_deptno = JOptionPane.showInputDialog("부서번호를 입력해주세요.");
		deptno = Integer.parseInt(u_deptno);
		return deptno;//리턴타입이 있는 메소드는 출력해 볼 수 있다.[단위테스트1/3]
	}
	
	//2. 입력받은 부서번호를 가지고 급여인상을 업데이트(처리)하는 메소드 구현하기
	public String salaryUpdate(int pdeptno) {
		String msg = null;
		try {
			//오토커밋 비활성화
			con.setAutoCommit(false);
			//물리적으로 떨어진 DB서버에 커넥션 맺기
			con = dbcon.getConnection();
			//오라클 서버에 프로시저 호출하기
			cstmt = con.prepareCall("{call proc_emp_update_salary(?,?)}");
			//그 프로시저 호출할 때 파마리터 넘기기
			cstmt.setInt(1,pdeptno);
			cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			//그 프로시저 처리 요청하기
			int result = cstmt.executeUpdate();
			msg =cstmt.getString(2);
		}catch(Exception e) {
		}
		return msg;
	}
	
	//메인메소드
	public static void main(String[] args) {
		new ProcedureExam2_CURSOR();
	}
}
