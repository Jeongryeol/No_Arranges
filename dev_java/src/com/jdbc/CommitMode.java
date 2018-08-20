package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DBConnectionMgr;

/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [목표]자바에서 DB의 commit을 관리하기
 * 
 * 반영 : commit; -> con.commit();
 * 복구 : rollback; -> con.rollback();
 *
 * 자바의 반영 기본값은 뭐지? autoCommit이다|아니다
 ************************************************************/
public class CommitMode {
	/*선언부*/
	//insert here :: DB연동을 위해 선언되어야하는 요소
	DBConnectionMgr dbMgr	= null;	//커넥션 풀을 얻기위한 클래스 생성하기
	Connection		con		= null;	//커넥션 인터페이스 추가
	//INSERT | UPDATE | DELETE 일때는 커서 해당없음.
	StringBuilder	sql		= new StringBuilder();//쿼리문을 담을 객체 추가-StringBuffer or StringBuilder
	/*	String대신 StringBuilder나 StringBuffer를 사용하는 이유??
		String은 문자열을 저장하고 추가[+="추가문자열"]해서 갱신할 때 객체가 매번 생성되고,
		원본이 변하지 않아서 반드시 대입연산자에 새로 담아줘야함.
		
		StringBuilder나 StringBuffer는  원본을 각 문자단위로 저장되고,
		추가[.append("추가문자열")]하여 원본이 변하므로, 호출하면 즉각 변화된것을 확인할 수 있다.
		
		StringBuilder나 StringBuffer는 원본을 변화시켜서 메모리에 할당되는 값을 줄임
		StringBuilder는 싱글스레드에서 | StringBuffer는 멀티스레드에서 적합하다.
		
		Builder클래스와 Buffer클래스의 내부적인 저장 매커니즘은 확인할 것!! */
	PreparedStatement pstmt = null;	//추가할 쿼리문을 전달할 인터페이스 추가
	
	/*사용자정의메소드*/
	public void methodA() {
		sql.append("INSERT INTO emp(empno,ename) VALUES(?,?)");
		dbMgr = DBConnectionMgr.getInstance();
		int result = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			//JDBC의 SQL요청은 자동커밋모드가 기본이다
			//수동모드로 돌리고 싶다면?
			con.setAutoCommit(false);//수동커밋모드로 전환됨
			//true : 오토커밋, false: 수동커밋~따로처리과정을 거치게 하겠다[ con.commit();, con.rollback(); ]
			
			//입력함
			pstmt.setInt(1, 9958);
			pstmt.setString(2, "테스트이름");
			result = pstmt.executeUpdate();
			if(result==1) {
				System.out.println("입력성공");
			}else if(result==0) {
				System.out.println("입력 실패");
			}
			//아래 메소드를 지원할 때 트랜젝션 처리가 가능하다.
			//트랜젝션 처리는 업무를 하나로 묶어서 처리하는 작업
			//con.commit();
			//con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
	}
	
	/*메인메소드*/
	public static void main(String[] args) {
		CommitMode cm = new CommitMode();
		cm.methodA();
	}
}
