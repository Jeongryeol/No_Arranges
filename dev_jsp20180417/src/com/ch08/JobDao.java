package com.ch08;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.ch06.LoginDao;

public class JobDao {
	Logger logger = Logger.getLogger(JobDao.class);
	String resource = "com/mybatis/MapperConfig.xml";
	SqlSessionFactory sqlMapper = null;
	SqlSession        sqlSes    = null;	
	public List<Map<String,Object>> getJobList(String j_yn){
		logger.info("getJobList ȣ�� ����");
		List<Map<String,Object>> jobList = null;
		Map<String,Object> pMap = new HashMap<String,Object>();
		pMap.put("j_yn", j_yn);
		try {
			Reader reader = null;//2byte������(�ѱ�-2byte����ó��)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					 new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			reader.close();
			jobList = sqlSes.selectList("getJobList", pMap);
			logger.info("��ȸ��� : "+jobList.size());
		} catch (Exception e) {
			logger.info(e.toString()+" , "+e.getMessage());
		}
		return jobList;
	}

}
