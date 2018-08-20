package com.pojo;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SqlMemberDao {
	Logger logger = Logger.getLogger(SqlMemberDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;
	String resource = "com/mybatis/MapperConfig.xml";
	/****************************************************************************************************
	 * ��й�ȣ�� �ؾ��� ��� �ӽ� ��� ä���ϱ� ����
	 * @param mem_id - ȭ�鿡�� �α��� ���� �� ���ǿ� ����� ���̵� �����´�.
	 * @return 
	 ***************************************************************************************************/
	public String getImsiPW(String mem_id) {
		String imsiPW = null;
		try {
			Reader reader = null;//2byte������(�ѱ�-2byte����ó��)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					 new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			imsiPW = sqlSes.selectOne("getImsiPW", mem_id);
		}catch(Exception e) {
			logger.info("exception : "+e.toString());
		}			
		return imsiPW;
	}
	/****************************************************************************************************
	 * ����ڰ� �Է��� ���̵� �����ϴ��� üũ�ϱ�
	 * @param mem_id - ����ڰ� �α��� ȭ�鿡�� �Է��� ��
	 * @return status  1:�α��μ���, -1:���̵� ����, 0:���Ʋ��, 2:���̵� ����.
	 ****************************************************************************************************/
	public int idExist(String mem_id) {
		logger.info("idExistȣ�� ����");
		int status = -2;
		try {
			Reader reader = null;//2byte������(�ѱ�-2byte����ó��)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					 new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			status = sqlSes.selectOne("idExist", mem_id);
		}catch(Exception e) {
			logger.info("exception : "+e.toString());
		}		
		return status;
	}
	/********************************************************************************************************
	 * �α��� ó�� ����
	 * @param pMap - ���̵�� ����� ����ڷ� ���� �Է¹���.
	 * @return - �̸�, ���̵� ����
	 ********************************************************************************************************/
	public Map<String,Object> login(Map<String,Object> pMap) {
		logger.info("loginȣ�� ����");
		int status = -2;
		List<Map<String,Object>> list = null;
		Map<String,Object> rMap = null;
		try {
			Reader reader = null;//2byte������(�ѱ�-2byte����ó��)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			//���� - list�ȿ��� � ������ ��� ������? 1)���̵�, 2)�̸�, 3)���
			//�� - �̸��� ��� ���� list.get(0).get("mem_name");
			list = sqlSes.selectList("getMemberList", pMap);
/*
 * ����� login�޼ҵ� �����̹Ƿ� id�� �����ϴ� ���� Ȯ���� �Ǿ���.
 * �׷��� ����� ��ġ�ϴ��� üũ�ؾ� �ϹǷ� ���̵�� ����� ���������� ���Ǻ��ϴµ� ����� ���� �ʴ°��
 * select�� ����� ����. select����� ���� �Ǹ� myBatis�� ��ȸ����� List���� ���� ����.
 * �̷���� NullPointerException�� �߻��ϴ� �����̵�.
 * ���� �Ʒ� else���� �߰��Ͽ� ���� �ν��Ͻ�ȭ �ϰ�(rMap) �׾ȿ� Ű������ 0�� ��Ҵ�.
 * �̷��� NullPointerException���� �ذ���.			
 */
			if(list!=null && list.size()==1) {
				rMap = list.get(0);
			}
			else{
				rMap = new HashMap<String,Object>();
				rMap.put("status", 0);
			}
		}catch(Exception e) {
			logger.info("exception : "+e.toString());
		}		
		return rMap;
	}
	public List<Map<String,Object>> getMemberListAll() {
		logger.info("getMemberListAllȣ�� ����");
		List<Map<String,Object>> memberList = null;
		try {
			Reader reader = null;//2byte������(�ѱ�-2byte����ó��)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			memberList = sqlSes.selectList("getMemberListAll");
			logger.info("memberList.size() : "+memberList.size());
		}catch(Exception e) {
			logger.info("exception : "+e.toString());
		}		
		return memberList;
	}
	public int memberInsert(Map<String,Object> pMap) {
		logger.info("memberInsertȣ�� ����");
		int result = 0;
		try {
			Reader reader = null;//2byte������(�ѱ�-2byte����ó��)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					 new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			result = sqlSes.insert("memberInsert", pMap);
			sqlSes.commit();
		}catch(Exception e) {
			logger.info("exception : "+e.toString());
		}
		return result;
	}
}
