package com.autoPerfection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.autoPerfection.JL_DBConnectionMgr;

/* 
 * 도서정보를 저장한 DataBase에 접속하여
 * 원하는 도서정보를 조회해오는 Data Access Object class
 * 
 * 조회된 정보가 자동완성될 데이터에 표시할 정보로 사용된다.
 */
public class DAO_Book {
	
	/*선언부*/
	//static을 붙였기 때문에 바로 인스턴스화 됨
		//Calendar cal = Calendar.getInstance(); 이런식으로 인스턴스화가 가능하다!!
	JL_DBConnectionMgr	dbMgr = JL_DBConnectionMgr.getInstance();
	Connection			con	  = null;
	PreparedStatement	pstmt = null;
	ResultSet			rs 	  = null;//커서를 컨트롤하자 ::전체범위처리/부분범위처리/속도에 관한 이해
		//web.xml 확인/
	Logger logger = Logger.getLogger(DAO_Book.class);
	
	/*조회처리*/
	//맛집정보 조회처리
	public List<VO_BookList> getBookInfoList(VO_BookList bsmvo) {
		List<VO_BookList> bookInfoList = null;
		bookInfoList = new ArrayList<VO_BookList>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b_code,b_name,b_price,b_picture FROM v_booklist");
		sql.append(" WHERE b_name='?'");

		//DB연동은 오라클 서버에 접속하는 것이므로 예외처리 필수임.
		try {
			con = dbMgr.getConnection();
				//연결정보로부터 전령을 준비할때 SQL문을 담음
			System.out.println("[[요청한 동적쿼리문]] "+sql.toString());
			pstmt = con.prepareStatement(sql.toString());
				//담은 정보를 돌리고 결과에 대한 커서 가져옴
			pstmt.setString(1, bsmvo.toString());
			rs = pstmt.executeQuery();

			if(rs==null) return bookInfoList;
			
			//테스트용 로그
		//	logger.info(sql);
		//	logger.info("rs.next() : "+rs.next());
		//	logger.info("rs.isFirst() : "+rs.isFirst());
		//	System.out.println(rs.isFirst());//커서가 제일 앞에 있니?
		//	System.out.println(rs.isLast()); //커서가 제일 뒤에 있니?
		//	while(rs.previous()) {	//커서가 제일 뒤에 있다면 뒤로 돌아가게 반복문 가동
		//	while(rs.absolute(3) {	//커서를 특정위치에 옮겨가게 해준다. 
			
			VO_BookList booklistVO = null;//VO클래스
			while(rs.next()) {//커서가 제일 앞이라면 다음으로 달려가게 반복문 가동
			/*조회한 row 하나를 담을 새로운 VO 인스턴스로 생성하기*/
				booklistVO = new VO_BookList();
				//조회한 결과의 각 컬럼에 해당하는 로우값을 VO클래스에 저장(set)하기
				booklistVO.setB_code(rs.getInt("b_code"));
				booklistVO.setB_name(rs.getString("b_name"));
				booklistVO.setB_price(rs.getString("b_price"));
				booklistVO.setB_picture(rs.getString("b_picture"));
				//저장된 VO클래스를 List에 담기
				bookInfoList.add(booklistVO);
			}//커서에 대한 조건이므로 커서의 다음내용이 없을때까지 반복수행함
			
		} catch (SQLException se) {//SQL에러
			System.out.println("SQL요청 중 에러발생!");
			System.out.println("[[query]] "+sql.toString());
			se.printStackTrace();
			/* *********************************************************
			 * SQLException 에러가 발생했다면 다음 중 해당되는 내용이 있는지 체크하세요.
			 * 	1. SQL문이 에러가 났는가? - Toad에서 에러체크
			 * 	2. 조회된 컬럼의 타입과 받아서 넣는 해쉬맵의 타입이 일치하는가?
			 * 		( ex. int-date,String-varchar2 )
			 ***********************************************************/
			
		} catch (Exception e) {//기타에러
			e.printStackTrace();
		}
		
		return bookInfoList;
	}
}
