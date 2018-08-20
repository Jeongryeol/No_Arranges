package com.jdbc;
/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [목표]데이터를 조회하고, 조회한 결과의 로우숫자를 세어보기 : getRowCount()
 ************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr;

public class RowCount {
	/*선언부*/
	//insert here :: DB연동을 위해 선언되어야하는 요소
	DBConnectionMgr dbMgr	= null;	//커넥션 풀을 얻기위한 클래스 생성하기
	Connection		con		= null;	//커넥션 인터페이스 추가
	StringBuilder	sql		= new StringBuilder();//쿼리문을 담을 객체 추가-StringBuffer or StringBuilder
	/*	String대신 StringBuilder나 StringBuffer를 사용하는 이유??
		String은 문자열을 저장하고 추가[+="추가문자열"]해서 갱신할 때 객체가 매번 생성되고,
		원본이 변하지 않아서 반드시 대입연산자에 새로 담아줘야함.
		
		StringBuilder나 StringBuffer는  원본을 각 문자단위로 저장되고,
		추가[.append("추가문자열")]하여 원본이 변하므로, 호출하면 즉각 변화된것을 확인할 수 있다.
		
		StringBuilder나 StringBuffer는 원본을 변화시켜서 메모리에 할당되는 값을 줄임
		StringBuilder는 싱글스레드에서 | StringBuffer는 멀티스레드에서 적합하다.
		
		Builder클래스와 Buffer클래스의 내부적인 저장 매커니즘은 확인할 것!! */
	PreparedStatement pstmt	= null;	//쿼리문을 전달할 인터페이스 추가
	ResultSet		  rs	= null;	//커서를 조작하는 인터페이스 추가
	
	/*사용자정의메소드*/
	//ORACLE의 결과커서로 조회된 결과 row의 개수를 확인하는 것을 자바에서 진행해보기
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
			 * TYPE_FORWORD_ONLY		:: 순차적으로 커서를 이동
			 * TYPE_SCROLL_INSENSITIVE	:: 비순차적으로 커서이동 (동시성 유지안됨)
			 * TYPE_SCROLL_SENSITIVE	:: 순차적으로 커서이동 (동시성 유지)
			 * CONCUR_UPDATABLE			:: 수정가능한 커서
			 * CONCUR_READ_ONLY			:: 변화를 줄수 없는 읽기만 가능한 커서
			 */
			rs = pstmt.executeQuery();
			rs.last();
			result = rs.getRow();
			rs.beforeFirst();
			System.out.println("Total row : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs); //자원 반납하기
		}
		return result;
	}
	
	/*메인메소드*/
	public static void main(String[] args) {
		int result =0;
		RowCount rc = new RowCount();
		result = rc.getRowCount();
		System.out.println("우리회사에 근무하는 사원들의 수  : "+result);
	}

}
