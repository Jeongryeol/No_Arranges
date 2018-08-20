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
		logger.info("getJobList 호출 성공");
		List<Map<String,Object>> jobList = null;
		Map<String,Object> pMap = new HashMap<String,Object>();
		pMap.put("j_yn", j_yn);
		try {
			Reader reader = null;//2byte단위로(한글-2byte단위처리)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					 new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			reader.close();
			jobList = sqlSes.selectList("getJobList", pMap);
			logger.info("조회결과 : "+jobList.size());
		} catch (Exception e) {
			logger.info(e.toString()+" , "+e.getMessage());
		}
		return jobList;
	}

}
