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
	//�α��غ�
	Logger logger = Logger.getLogger(C9_MemberController.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession 		  sqlSes 	= null;
	String resource = "com/mybatis/MapperConfig.xml";
	/*****************************************************************************
	 * [[�α���ó��]]
	 * @param mem_id - ���̵� (����ڰ� �ڽ��� ���̵� �Է�)
	 * @param mem_pw - ��й�ȣ (����ڰ� �ڽ��� ��й�ȣ�� �Է�)
	 * @return String - �̸�(��Ű�� ���� ��) Cookie c = new Cookie("cmem_name","�̼���");
	 *****************************************************************************/
	public String login(String mem_id, String mem_pw) {
		logger.info("login ȣ�� ����");
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
			logger.info("��ȸ��� : "+memList.size());
			//NullPointerException ����
			mem_name = memList.get(0).get("MEM_NAME").toString();
			
		} catch (Exception e) {
			logger.info(e.toString()+" , "+e.getMessage());
		}
		
		return mem_name;
	}

	
}
