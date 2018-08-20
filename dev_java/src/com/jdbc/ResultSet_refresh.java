package com.jdbc;
/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [목표]자바에서 업데이트하고 갱신하기
 * 
 ************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr;

public class ResultSet_refresh {
	/*선언부*/
	//insert here :: DB연동을 위해 선언되어야하는 요소
	DBConnectionMgr dbMgr	= null;	//커넥션 풀을 얻기위한 클래스 생성하기
	Connection		con		= null;	//커넥션 인터페이스 추가
	//쿼리문을 담을 객체 추가-StringBuffer or StringBuilder
	StringBuilder	sql		= new StringBuilder();
/*	String대신 StringBuilder나 StringBuffer를 사용하는 이유??
 * 	String은 문자열을 저장하고 추가[+="추가문자열"]해서 갱신할 때 객체가 매번 생성되고,
 * 	원본이 변하지 않아서 반드시 대입연산자에 새로 담아줘야함.
 *
 *	StringBuilder나 StringBuffer는  원본을 각 문자단위로 저장되고,
 *	추가[.append("추가문자열")]하여 원본이 변하므로, 호출하면 즉각 변화된것을 확인할 수 있다.
 *	
 *	StringBuilder나 StringBuffer는 원본을 변화시켜서 메모리에 할당되는 값을 줄임
 *	StringBuilder는 싱글스레드에서 | StringBuffer는 멀티스레드에서 적합하다.
 *	Builder클래스와 Buffer클래스의 내부적인 저장 매커니즘은 확인할 것!! */
	PreparedStatement pstmt1 = null;	//쿼리문을 전달할 인터페이스 추가
	PreparedStatement pstmt2 = null;	//쿼리문을 전달할 인터페이스 추가
	ResultSet		  rs	 = null;	//커서를 조작하는 인터페이스 추가
	
	/*사용자정의메소드*/
	public void methodA() {
		dbMgr = DBConnectionMgr.getInstance();
		sql.append("SELECT empno, ename, sal FROM emp");
		try {
			con = dbMgr.getConnection();
			pstmt1 = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_READ_ONLY);
			//OPEN-CURSOR-FETCH
			//Fetch란, 데이터 베이스에서 쿼리를 살행했을때 block에 있는 row를
			//원하는 행과 원하는 컬럼 형태에 의해 클라이언트에 보여주는 과정이다.
			//만일 100개의 행을 setFetchSize(10)으로 설정하면 10회의 I/O가 발생된다.
			
			pstmt1.setFetchSize(1);
			//trigger에러나면 Toad에서 트리거를 지워준다 :: alter trigger tri_test3 dsiable
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
			
			System.out.println("수정 후 refresh를 통한 emp테이블 리스트");
			double salary = 0.0;
			while(rs.next()) {
				salary = rs.getDouble("sal");
				System.out.print("salary : "+salary+"▶▶▶");
				rs.refreshRow();
				System.out.println(rs.getInt("empno")+"|"+rs.getString("ename")+"|"+rs.getDouble("sal"));
			}
			
		} catch (Exception e) {

		}
		
	}
	
	/*메인메소드*/
	public static void main(String[] args) {
		ResultSet_refresh rr = new ResultSet_refresh();
		rr.methodA();
	}
}
