package com.ch17.day04_survlet_limit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * [�ε巯�� ������ ���� ������ ����]
 * @author	���� �ۼ��ߴ��� �ۼ�
 * @sql		� SQL������ �۵���Ű���� �ۼ�
 * @param	pMap : ������ ������ �ۼ�
 * @return	������ �����ϴ��� �ۼ�
 */
public class BoardDAO {
	/* **************************
	 * ȿ������ ������� ���� log4j Ȱ���ϱ�
	 * (org.apache�� import�ϼ���~)
	 ****************************/
	Logger logger = Logger.getLogger(BoardDAO.class);
	
	//��ȸ�� �����ϴ� DAO
	public List<Map<String,Object>> getBoardList(Map<String,Object> pMap) {
		logger.info("getBoardList() �޼ҵ� ȣ�� ����");
		List<Map<String,Object>> boardList
			= new ArrayList<Map<String,Object>>();
		//INSERT HERE : DB����
		return boardList;
	}
	
	//�Է��� �����ϴ� DAO
	public int boardInsert(Map<String,Object> pMap) {
		logger.info("boardInsert() �޼ҵ� ȣ�� ����");
		int result = 0;
		//INSERT HERE : DB����
		return result;
	}
	
	//������ �����ϴ� DAO
	public int boardUpdate(Map<String,Object> pMap) {
		logger.info("boardUpdate() �޼ҵ� ȣ�� ����");
		int result = 0;
		//INSERT HERE : DB����
		return result;
	}
	
	//������ �����ϴ� DAO
	public int boardDelete(Map<String,Object> pMap) {
		logger.info("boardDelete() �޼ҵ� ȣ�� ����");
		int result = 0;
		//INSERT HERE : DB����
		return result;
	}
}
