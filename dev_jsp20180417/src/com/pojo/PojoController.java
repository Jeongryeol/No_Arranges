package com.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class PojoController implements Action{
	Logger logger = Logger.getLogger(PojoController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		ActionForward forward = new ActionForward();
		List<Map<String,Object>> pojoList = new ArrayList<Map<String,Object>>();
		pojoList = new Vector<Map<String,Object>>();
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("mem_id", "test");
		rMap.put("mem_name", "이순신");
		pojoList.add(rMap);
		rMap = new HashMap<String,Object>();
		rMap.put("mem_id", "haha");
		rMap.put("mem_name", "하하");
		pojoList.add(rMap);
		forward.setList(pojoList);
		forward.setRedirect(true);
		forward.setPath("./getPojoList.jsp");
		return forward;
	}
	/******************************************************************************************************
	 * 입력 | 수정 | 삭제 구현
	 * 
	 *****************************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap)
			throws Exception {
		logger.info("execute호출 성공");
		String path = null;
		String gubun = pMap.get("gubun").toString();
		ActionForward forward = new ActionForward();
		int result = 0;//입력 | 수정 | 삭제 성공 여부
		//너 입력 누른거야?
		if("insert".equals(gubun)) {
			logger.info("입력 프로세스 호출 성공");
			//result = 1;
			if(result==1) {
				path = "getPojoList.kos";
			}
			else {
				path = "./pojoInsertFail.jsp";
			}
			forward.setPath(path);
			//insert here
			forward.setRedirect(true);//true이면  sendRedirect false이면 forward로 처리됨.
			forward.setList(null);
		}
		//혹시 수정을 원해?
		else if("update".equals(gubun)) {
			
		}
		//정말 탈퇴할거니?
		else if("delete".equals(gubun)) {
			
		}
		return forward;
	}


}





