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
		BoardLogic bLogic = new BoardLogic();//������������ �̷��� ���� �ν��Ͻ�ȭ ���� �ʽ��ϴ�.
		ActionForward af = new ActionForward();
		String path = null;
//��ȸ ��û�� ����� �޶� ������������ �ٸ� ��쿡�� �б��Ѵ�.		
		if("getBoardList".equals(gubun)) {
			logger.info("�۸�� ��ȸ ȣ�� ����");
			String cb_type = req.getParameter("cb_type");
			String sb_keyword = req.getParameter("sb_keyword");
			logger.info(cb_type+","+sb_keyword);
			//���ǰ˻��� �ʿ��� �� - ����|�ۼ���|����
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
			logger.info("�۾��� ȣ�� ����");
			pMap = new HashMap<String, Object>();
			//����ڰ� �Է��� �� ���
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result = 0;
			result = bLogic.boardInsert(pMap);
			//��� ������ ��
			if(result==1) {
				path = "boardSuccess.jsp";
			}
			//��� ������ ��
			else {
				path = "boardFail.jsp";
			}
			af.setPath(path);
			af.setRedirect(false);//false->true:sendRedirect, true-false:forwardó��
		}
		return af;
	}

}









