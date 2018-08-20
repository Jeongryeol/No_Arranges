package com.ch11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

//DAO : Data Access Object (DB연동을 전담하는 클래스로 설계함)
//별도설계이유 : 재사용성을 높이기 위한 클래스설계
//업무와 업무사이에는 관계가 있고, 그 관계에 종속적이지 않은 상태로 클래스설계를 해야
//관련있는 업무사이에서 메소드를 공유할 수 있다.
//--->결합도가 낮은 코드를 전개하는 것이 좋대.
//--->결합도가 낮아야 단위테스트가 가능하고 통합테스트가 가능해진다.
//프로젝트 진행과정
//분석 설계 --> 개발(코딩) ---> 테스트 ---> 시스템 이행 ---> 끝

public class BoardDao {//JDBC구현 클래스
	/*선언부*/
	DBConnectionMgr		dbMgr = DBConnectionMgr.getInstance();
	Connection			con	  = null;
	PreparedStatement	pstmt = null;
	ResultSet			rs 	  = null;//커서를 컨트롤하자 ::전체범위처리/부분범위처리/속도에 관한 이해
	
	/*조회처리*/
	//사원번호 조회처리 [ 메소드이름 : getEmpList(??):?? ]
	public List<Map<String,Object>> getBoardList(Map<String,Object> pMap) {
		List<Map<String,Object>> boardList = new ArrayList<Map<String,Object>>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b_no, b_title, b_content, b_writer, b_date, b_hit FROM JDBC_BOARD");
		try {
			con = dbMgr.getConnection();
			System.out.println("[[요청한 동적쿼리문]] "+sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Map<String,Object> rMap = null;
			while(rs.next()) {//커서가 제일 앞이라면 다음으로 달려가게 반복문 가동
				rMap = new HashMap<String,Object>();
				rMap.put("B_NO",rs.getInt("b_no"));
				rMap.put("B_TITLE",rs.getString("b_title"));
				rMap.put("B_CONTENT",rs.getString("b_content"));
				rMap.put("B_WRITER",rs.getString("b_writer"));
				rMap.put("B_DATE",rs.getString("b_date"));
				rMap.put("B_HIT",rs.getInt("b_hit"));
				//저장된 Map<String,Object>클래스를 List에 담기
				boardList.add(rMap);
			}//반복하기
			
		} catch (SQLException se) {
			System.out.println("SQL요청 중 에러발생!");
			System.out.println("[[query]] "+sql.toString());
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
}
