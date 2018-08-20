package com.oracle.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
/*
 * 물리적으로 떨어져있는 DB서버(oracle)에 커넥션 맺기
 * 학습목표
 * 나는 자바에서 제공하는 API를 활용하여 프로시저를 호출하고 그 결과값을 받아올 수 있다.
 */
public class ProcedureExam1_Update {
	
	//선언부
	DBConnection dbcon = new DBConnection();
	Connection con = null;
	CallableStatement cstmt = null;
	
	//생성자
	public ProcedureExam1_Update() {
//		System.out.println(userInput());//생성자 내 호출+출력 [단위테스트2/3]
		int pempno = userInput();
		String msg = salaryUpdate(pempno);
		System.out.println("[[처리결과]]"+msg);
	}
	
	//사용자정의 메소드
	//1.사용자로부터 사원번호를 입력받는 메소드 구현 : userInput() [ DB연동 불필요 ]
	public int userInput() {
		int empno=0;
		String u_empno = JOptionPane.showInputDialog("사원번호를 입력해주세요.");
		empno = Integer.parseInt(u_empno);
		return empno;//리턴타입이 있는 메소드는 출력해 볼 수 있다.[단위테스트1/3]
	}
	//2.입력받은 사원번호를 가지고 급여를 인상처리하는 메소드 구현 : salaryUpdate() [ DB연동 ]
	public String salaryUpdate(int pempno) {
		String msg = null;
		try {
			//물리적으로 떨어진 DB서버에 커넥션 맺기
			con = dbcon.getConnection();
			//오라클 서버에 프로시저 호출하기
			cstmt = con.prepareCall("{call proc_emp_sal_update(?,?)}");
			//그 프로시저 호출할 때 파마리터 넘기기
			cstmt.setInt(1,pempno);
			cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			//그 프로시저 처리 요청하기
			int result = cstmt.executeUpdate();
			msg =cstmt.getString(2);
		}catch(Exception e) {
		}
		//System.out.println("XXX사원은 1.2급여인상으로 XXX가 되었습니다.");
		//결과를 다른 메소드로 넘기기위해 msg 선언
		return msg;
	}
/*	SQL문의 SELECT과 UPDATE가 들어갈 내용이므로
	프로시저의 파라미터로 메소드의 파라메터와 리턴타입을 구분할 수 있다.
	프로시저의 파라미터가 IN인 경우 입력하는 것이므로 메소드의 파라미터에 들어가야함.
	프로시저의 파라미터에 OUT이 있는 경우 출력하는 것이므로 메소드의 리턴타입이 정해져야함.*/
	
	//메인메소드
	public static void main(String[] args) {
		new ProcedureExam1_Update();
		
	}

}
