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
 *	[목표] ORACLE에서 생성한 프로시저(proc_emptest)를 Java에서 사용하기
 *	[테스트내용]
 *		1) 프로시저  호출하기
 *		2) 프로시저  파라미터(a:IN속성, b:OUT속성)
 *	[프로시저 선언문]
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
	/*선언부*/
	//insert here :: DB연동을 위해 선언되어야하는 요소
	DBConnectionMgr dbMgr	= null;	//커넥션 풀을 얻기위한 클래스 생성하기
	Connection		con		= null;	//커넥션 인터페이스 추가
	CallableStatement cstmt	= null;	//쿼리문을 전달할 인터페이스 추가

	/*사용자정의메소드*/
	//student 테이블에 추가하는 프로시저 처리하기
	/** @param p(parameter) 입력값을 담는 변수 / r(return) 리턴값을 담는 변수*/
	public void studentIns(int pstd_no, int pgrade, String pdepartment, String psname) {
		dbMgr = DBConnectionMgr.getInstance();	//커넥션 풀 생성
		int result = 0;	//오라클서버로부터 받은 결과값을 담는 변수 ( 0:실패, 1:성공 )
		String rmsg = null;
		try {
			con = dbMgr.getConnection();
			/******************************************************************************
			 * 
			 * <<NOTICE>>
			 * SQL[SELECT] ~ executeQueru():ResultSet
			 * SQL[INS,DEL,UPD] ~ executeUpdate():int
			 * PL/SQL[PROCEDURE] ~ prepareCall("{call 프로시저이름(파라미터)}"):ORACLE TYPE에 맞게 수령
			 *  
			 ******************************************************************************/
			cstmt = con.prepareCall("{call proc_studentINS2(?,?,?,?,?)}");
			cstmt.setInt(1, pstd_no);		//첫번째 ?자리에 파라미터로 받은 값을 넣어서 프로시저의 IN속성에 대응
			cstmt.setInt(2, pgrade);		//두번째 ?자리에 파라미터로 받은 값을 넣어서 프로시저의 IN속성에 대응
			cstmt.setString(3, pdepartment);//세번째 ?자리에 파라미터로 받은 값을 넣어서 프로시저의 IN속성에 대응
			cstmt.setString(4, psname);		//네번째 ?자리에 파라미터로 받은 값을 넣어서 프로시저의 IN속성에 대응
			cstmt.registerOutParameter(5, java.sql.Types.INTEGER);//다섯번째 ?자리는 프로시저의 OUT속성에 대응
			
			result = cstmt.executeUpdate();//자바가 오라클서버에 처리요청하여 결과담음
			System.out.println("Java가 ORACLE SERVER에 요청하여 받은 결과값 result = "+result);
			
			rmsg = cstmt.getString(5);
			System.out.println(rmsg);
			
			if("1".equals(rmsg)) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패 / rmsg = "+rmsg);
			}
			
		} catch (SQLException se) {
			System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	/** @param p(parameter) 입력값을 담는 변수 / r(return) 리턴값을 담는 변수*/
	public void methodA(int pempno, String rmsg) {
		dbMgr = DBConnectionMgr.getInstance();	//커넥션 풀 생성
		int result = 0;	//오라클서버로부터 받은 결과값을 담는 변수 ( 0:실패, 1:성공 )
		try {
			con = dbMgr.getConnection();
			/******************************************************************************
			 * 
			 * <<NOTICE>>
			 * SQL[SELECT] ~ executeQueru():ResultSet
			 * SQL[INS,DEL,UPD] ~ executeUpdate():int
			 * PL/SQL[PROCEDURE] ~ prepareCall("{call 프로시저이름(파라미터)}"):ORACLE TYPE에 맞게 수령
			 *  
			 ******************************************************************************/
			cstmt = con.prepareCall("{call proc_emptest(?,?)}");
			cstmt.setInt(1, pempno);//첫번째 ?자리에 파라미터로 받은 값을 넣어서 프로시저의 IN속성에 대응
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);//두번째 ?자리는 프로시저의 OUT속성에 대응
			
			result = cstmt.executeUpdate();//자바가 오라클서버에 처리요청하여 결과담음
			System.out.println("Java가 ORACLE SERVER에 요청하여 받은 결과값 result = "+result);
			
			rmsg = cstmt.getString(2);
			System.out.println(rmsg);
			
		} catch (SQLException se) {
			System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	/*메인메소드*/
	public static void main(String[] args) {
		Proc_emptest pe = new Proc_emptest();
	/*
		System.out.println("사원번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);//입력된 값을 읽는 스캐너 클래스를 활용해서 입력받은 값을 스캔함
		int pempno = 0;
		String temp = scan.nextLine();
		pempno = Integer.parseInt(temp);
		String rmsg = null;
		pe.methodA(pempno,rmsg);
	*/
		pe.studentIns(18020119, 3, "사회체육학과", "이성계");
	}

}
