package com.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/*
 * �ܼ� ����(�Է�|����|����|��ȸ - ���̺��� ���� �Ѱ��϶�)ó�������� LogicŬ�������� �ϴ� ���� ����.
 * 1)���
 * 2)�Ǵ�, ����, å��, ����
 *  :�������� ���μ����� �� �� Ŭ�������� ó���� �� �ʿ伺�� ������ ����.
 */
public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	/*
	 * �Ʒ��� ���� ���� �ν��Ͻ�ȭ �ϴ� ���� ������ ������ �ƴϴ�.
	 * ���� �ν��Ͻ�ȭ �� ��� ��ü�� ���� ����������Ŭ���� å���� ������
	 * �׷��� spring�� ���� ���� �����ӿ�ũ�� Ȱ���ϸ� �̷��� ���� �ν��Ͻ�ȭ ���� ����.
	 */
	SqlMemberDao memDao = new SqlMemberDao();
	public int memberInsert(Map<String,Object> pMap) {
		int result = 0;
		result = memDao.memberInsert(pMap);
		logger.info("result:"+result);
		return result;
	}
	public List<Map<String, Object>> getMemberList() {
		logger.info("getMemberList ȣ�� ����");
		List<Map<String, Object>> rlist = memDao.getMemberListAll();
		return rlist;
	}
	public Map<String, Object> login(Map<String, Object> pMap) {
		logger.info("login ȣ�� ����");
		int status = -2;
		Map<String, Object> rMap = new HashMap<String,Object>();
		status = memDao.idExist(pMap.get("mem_id").toString());
		//SqlMemberDao�� login�޼ҵ�� ���� ȣ���ؾ� �ұ��?
		if(status==2) {//���̵� �����ϴ� ��� - �̶��� ����� üũ�ϸ� ��.
			rMap = memDao.login(pMap);
			if(rMap.get("MEM_NAME")!=null && rMap.get("MEM_NAME").toString().length()>=1) {
				rMap.put("status", "1");
			}
			else {
				rMap.put("status", "0");
			}
		}
		else {
			rMap.put("status", status);//status���� � ���ڰ� ��� ���� ���? -1
		}
		return rMap;
	}	
}








