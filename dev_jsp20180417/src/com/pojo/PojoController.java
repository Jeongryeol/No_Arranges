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
		logger.info("execute ȣ�� ����");
		ActionForward forward = new ActionForward();
		List<Map<String,Object>> pojoList = new ArrayList<Map<String,Object>>();
		pojoList = new Vector<Map<String,Object>>();
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("mem_id", "test");
		rMap.put("mem_name", "�̼���");
		pojoList.add(rMap);
		rMap = new HashMap<String,Object>();
		rMap.put("mem_id", "haha");
		rMap.put("mem_name", "����");
		pojoList.add(rMap);
		forward.setList(pojoList);
		forward.setRedirect(true);
		forward.setPath("./getPojoList.jsp");
		return forward;
	}
	/******************************************************************************************************
	 * �Է� | ���� | ���� ����
	 * 
	 *****************************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap)
			throws Exception {
		logger.info("executeȣ�� ����");
		String path = null;
		String gubun = pMap.get("gubun").toString();
		ActionForward forward = new ActionForward();
		int result = 0;//�Է� | ���� | ���� ���� ����
		//�� �Է� �����ž�?
		if("insert".equals(gubun)) {
			logger.info("�Է� ���μ��� ȣ�� ����");
			//result = 1;
			if(result==1) {
				path = "getPojoList.kos";
			}
			else {
				path = "./pojoInsertFail.jsp";
			}
			forward.setPath(path);
			//insert here
			forward.setRedirect(true);//true�̸�  sendRedirect false�̸� forward�� ó����.
			forward.setList(null);
		}
		//Ȥ�� ������ ����?
		else if("update".equals(gubun)) {
			
		}
		//���� Ż���ҰŴ�?
		else if("delete".equals(gubun)) {
			
		}
		return forward;
	}


}





