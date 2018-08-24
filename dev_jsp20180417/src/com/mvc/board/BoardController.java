package com.mvc.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.Action;
import com.pojo.ActionForward;
import com.util.HashMapBinder;

public class BoardController implements Action {
	Logger logger = Logger.getLogger(BoardController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String gubun = req.getParameter("gubun");// URL- mvcBoard.kos?gubun=getBoardList
		BoardLogic bLogic = new BoardLogic();//스프링에서는 이렇게 직접 인스턴스화 하지 않습니다.
		ActionForward af = new ActionForward();
		String path = null;
//조회 요청이 기능이 달라서 응답페이지가 다를 경우에는 분기한다.		
		if("getBoardList".equals(gubun)) {
			logger.info("글목록 조회 호출 성공");
			String cb_type = req.getParameter("cb_type");
			String sb_keyword = req.getParameter("sb_keyword");
			logger.info(cb_type+","+sb_keyword);
			//조건검색에 필요한 값 - 제목|작성자|내용
			Map<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("cb_type", cb_type);//b_title, b_content, b_name
			pMap.put("sb_keyword", sb_keyword);
			List<Map<String,Object>> getBoardList = null;
			getBoardList = bLogic.getBoardList(pMap);
			req.setAttribute("getBoardList", getBoardList);
			path = "jsonBoardList.jsp";
			af.setPath(path);
			af.setRedirect(true);
		}
/*		else if() {
			
		}*/
		return af;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap)
			throws Exception {
		String gubun = req.getAttribute("gubun").toString();// URL - /mvcBoard/mvcBoard.bd?gubun=boardInsert
		BoardLogic bLogic = new BoardLogic();
		ActionForward af = new ActionForward();
		String path = null;
		if("boardInsert".equals(gubun)) {
			logger.info("글쓰기 호출 성공");
			pMap = new HashMap<String, Object>();
			//사용자가 입력한 값 담기
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result = 0;
			result = bLogic.boardInsert(pMap);
			//등록 성공일 때
			if(result==1) {
				path = "boardSuccess.jsp";
			}
			//등록 실패일 때
			else {
				path = "boardFail.jsp";
			}
			af.setPath(path);
			af.setRedirect(false);//false->true:sendRedirect, true-false:forward처리
		}
		return af;
	}

}









