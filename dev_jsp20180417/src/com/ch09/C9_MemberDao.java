package com.ch09;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class C9_MemberDao {
	//로그준비
	Logger logger = Logger.getLogger(C9_MemberController.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession 		  sqlSes 	= null;
	String resource = "com/mybatis/MapperConfig.xml";
	/*****************************************************************************
	 * [[로그인처리]]
	 * @param mem_id - 아이디 (사용자가 자신의 아이디를 입력)
	 * @param mem_pw - 비밀번호 (사용자가 자신의 비밀번호를 입력)
	 * @return String - 이름(쿠키에 담을 값) Cookie c = new Cookie("cmem_name","이순신");
	 *****************************************************************************/
	public String login(String mem_id, String mem_pw) {
		logger.info("login 호출 성공");
		String mem_name = null;
		
		List<Map<String,Object>> memList = null;
		Map<String,Object> pMap = new HashMap<String,Object>();
		pMap.put("mem_id", mem_id);
		pMap.put("mem_pw", mem_pw);
		
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					 new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			reader.close();
			memList = sqlSes.selectList("getMemberList", pMap);
			logger.info("조회결과 : "+memList.size());
			//NullPointerException 주의
			mem_name = memList.get(0).get("MEM_NAME").toString();
			
		} catch (Exception e) {
			logger.info(e.toString()+" , "+e.getMessage());
		}
		
		return mem_name;
	}

	
}
