package com.mvc.board;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	SqlBoardDao bDao = new SqlBoardDao();
	public List<Map<String, Object>> getBoardList(Map<String, Object> pMap) {
		logger.info("getBoardList ȣ�� ����");
		List<Map<String,Object>> getBoardList = null;
		//�˻� ��û�� ��ü ��ȸ�� ��� ���� �˻��� ��� ����������.
		if(pMap.containsKey("cb_type")) {
			pMap.put("column", pMap.get("cb_type"));
		}
		getBoardList=bDao.getBoardList(pMap);
		return getBoardList;
	}
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsertȣ�� ����");
		int mresult = 0;
		int sresult = 0;
		int result=0;//2�̸� �� ���̺� ��� ���� 1�̸� boardMaster���� ����
		mresult = bDao.boardMInsert(pMap);
		if(pMap.get("b_file")!=null) {//÷�������� �ִ�
			sresult = bDao.boardSInsert(pMap);
		}
		result = mresult+sresult;
		return result;
	}
}






