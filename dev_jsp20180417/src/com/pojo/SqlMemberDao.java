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
	 * 비밀번호를 잊었을 경우 임시 비번 채번하기 구현
	 * @param mem_id - 화면에서 로그인 했을 때 세션에 저장된 아이디를 가져온다.
	 * @return 
	 ***************************************************************************************************/
	public String getImsiPW(String mem_id) {
		String imsiPW = null;
		try {
			Reader reader = null;//2byte단위로(한글-2byte단위처리)
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
	 * 사용자가 입력한 아이디가 존재하는지 체크하기
	 * @param mem_id - 사용자가 로그인 화면에서 입력한 값
	 * @return status  1:로그인성공, -1:아이디 없음, 0:비번틀림, 2:아이디 있음.
	 ****************************************************************************************************/
	public int idExist(String mem_id) {
		logger.info("idExist호출 성공");
		int status = -2;
		try {
			Reader reader = null;//2byte단위로(한글-2byte단위처리)
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
	 * 로그인 처리 구현
	 * @param pMap - 아이디와 비번을 사용자로 부터 입력받음.
	 * @return - 이름, 아이디도 담자
	 ********************************************************************************************************/
	public Map<String,Object> login(Map<String,Object> pMap) {
		logger.info("login호출 성공");
		int status = -2;
		List<Map<String,Object>> list = null;
		Map<String,Object> rMap = null;
		try {
			Reader reader = null;//2byte단위로(한글-2byte단위처리)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			//질문 - list안에는 어떤 정보가 담겨 있을까? 1)아이디, 2)이름, 3)비번
			//답 - 이름이 담겨 있음 list.get(0).get("mem_name");
			list = sqlSes.selectList("getMemberList", pMap);
/*
 * 여기는 login메소드 영역이므로 id가 존재하는 것은 확인이 되었다.
 * 그러나 비번이 일치하는지 체크해야 하므로 아이디와 비번을 교집합으로 조건비교하는데 비번이 맞지 않는경우
 * select의 결과는 없다. select결과가 없게 되면 myBatis는 조회결과를 List담을 수가 없다.
 * 이럴경우 NullPointerException이 발생하는 원인이됨.
 * 따라서 아래 else문을 추가하여 직접 인스턴스화 하고(rMap) 그안에 키값으로 0을 담았다.
 * 이렇게 NullPointerException문제 해결함.			
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
		logger.info("getMemberListAll호출 성공");
		List<Map<String,Object>> memberList = null;
		try {
			Reader reader = null;//2byte단위로(한글-2byte단위처리)
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
		logger.info("memberInsert호출 성공");
		int result = 0;
		try {
			Reader reader = null;//2byte단위로(한글-2byte단위처리)
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
