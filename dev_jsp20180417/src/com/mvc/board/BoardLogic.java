package com.mvc.board;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	SqlBoardDao bDao = new SqlBoardDao();
	public List<Map<String, Object>> getBoardList(Map<String, Object> pMap) {
		logger.info("getBoardList 호출 성공");
		List<Map<String,Object>> getBoardList = null;
		//검색 요청이 전체 조회인 경우 조건 검색인 경우 나누어진다.
		if(pMap.containsKey("cb_type")) {
			pMap.put("column", pMap.get("cb_type"));
		}
		getBoardList=bDao.getBoardList(pMap);
		return getBoardList;
	}
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert호출 성공");
		int mresult = 0;
		int sresult = 0;
		int result=0;//2이면 두 테이블에 모두 삽입 1이면 boardMaster에만 삽입
		mresult = bDao.boardMInsert(pMap);
		if(pMap.get("b_file")!=null) {//첨부파일이 있다
			sresult = bDao.boardSInsert(pMap);
		}
		result = mresult+sresult;
		return result;
	}
}






