package com.jdbc;
/************************************************************
 * @author Jeongryeol Lee
 * @since 2018.07.09
 * @category JDBC 
 * 
 * [목표]데이터를 추가하고 조회하고, 삭제하고 조회하기.
 ************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnectionMgr;

public class ResultSet_InsDel {
	/*선언부*/
	//insert here :: DB연동을 위해 선언되어야하는 요소
	DBConnectionMgr dbMgr	= null;	//커넥션 풀을 얻기위한 클래스 생성하기
	Connection		con		= null;	//커넥션 인터페이스 추가
	//쿼리문을 담을 객체 추가-StringBuffer or StringBuilder
	StringBuilder	sql		= new StringBuilder();
	/*	String대신 StringBuilder나 StringBuffer를 사용하는 이유??
		String은 문자열을 저장하고 추가[+="추가문자열"]해서 갱신할 때 객체가 매번 생성되고,
		원본이 변하지 않아서 반드시 대입연산자에 새로 담아줘야함.
		
		StringBuilder나 StringBuffer는  원본을 각 문자단위로 저장되고,
		추가[.append("추가문자열")]하여 원본이 변하므로, 호출하면 즉각 변화된것을 확인할 수 있다.
		
		StringBuilder나 StringBuffer는 원본을 변화시켜서 메모리에 할당되는 값을 줄임
		StringBuilder는 싱글스레드에서 | StringBuffer는 멀티스레드에서 적합하다.
		
		Builder클래스와 Buffer클래스의 내부적인 저장 매커니즘은 확인할 것!! */
	PreparedStatement pstmtInsert = null;	//추가할 쿼리문을 전달할 인터페이스 추가
	PreparedStatement pstmtDelete = null;	//삭제할 쿼리문을 전달할 인터페이스 추가
	ResultSet		  rs	= null;	//커서를 조작하는 인터페이스 추가
	
	/*사용자정의메소드*/
	//데이터를 추가하고 조회하고 삭제하고 조회하기까지 한번에 진행할 메소드
	public void doInsertAndDelete() {
		dbMgr = DBConnectionMgr.getInstance();
		sql.append("SELECT empno, ename FROM emp");
		try {
			con = dbMgr.getConnection();
			pstmtInsert = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			rs = pstmtInsert.executeQuery();
			//데이터추가하기
			rs.moveToInsertRow();//추가 가능한 로우로 커서 이동
			rs.updateInt(1,9555);
			rs.updateString(2,"이길한");
			rs.insertRow();
			
			rs.moveToInsertRow();//추가 가능한 로우로 커서 이동
			rs.updateInt(1,9556);
			rs.updateString(2,"최재영");
			rs.insertRow();
			//rs.close();
			
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("=====[데이터 추가 후 테이블 리스트]=====");
			while(rs.next()) {
				System.out.println("사원번호 :"+rs.getInt("empno")
					//		+". 사원명 : "+rs.getString(2));//컬럼명의 이름에 따라 얻어내도록 직관성을 올릴것
							+". 사원명 : "+rs.getString("ename"));
			}
			
			System.out.println("=====[데이터 삭제 후 테이블 리스트]=====");
			pstmtDelete = con.prepareStatement(sql.toString()
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			rs = pstmtDelete.executeQuery();
			
			
			//데이터  삭제하기
			if(!rs.isBeforeFirst()) {//커서가 맨 마지막 위치에 있는 지 체크
				rs.beforeFirst();//커서의 위치를 맨 마지막으로 이동
			}
			while(rs.next()) {
				if(rs.getInt("empno")==9555) {
					rs.deleteRow();
				}
				if(rs.getInt("empno")==9556) {
					rs.deleteRow();
				}
			}
			if(!rs.isBeforeFirst()) {//커서가 맨 마지막 위치에 있는 지 체크
				rs.beforeFirst();//커서의 위치를 맨 마지막으로 이동
			}
			//데이터를 조회함
			while(rs.next()) {
				System.out.println("사원번호 :"+rs.getInt("empno")
				//		+". 사원명 : "+rs.getString(2));//컬럼명의 이름에 따라 얻어내도록 직관성을 올릴것
				+". 사원명 : "+rs.getString("ename"));
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
	/*메인메소드*/
	public static void main(String[] args) {
		ResultSet_InsDel rsID = new ResultSet_InsDel();
		rsID.doInsertAndDelete();
	}

}
