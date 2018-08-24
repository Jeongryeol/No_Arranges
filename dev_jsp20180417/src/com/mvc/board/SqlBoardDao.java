package com.mvc.board;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SqlBoardDao {
	Logger logger = Logger.getLogger(SqlBoardDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;
	String resource = "com/mybatis/MapperConfig.xml";
	public List<Map<String, Object>> getBoardList(Map<String, Object> pMap) {
		logger.info("getBoardList ȣ�� ����");
		List<Map<String,Object>> getBoardList = null;
		try {
			Reader reader = null;//2byte������(�ѱ�-2byte����ó��)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper =
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes =  sqlMapper.openSession();
			getBoardList = sqlSes.selectList("getBoardList", pMap);
			logger.info("getBoardList.size():"+getBoardList.size());
		}catch(Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return getBoardList;
	}
	public int boardSInsert(Map<String, Object> pMap) {
		logger.info("boardMInsert ȣ�� ����");
		int result = 0;
		return result;
	}
	public int boardMInsert(Map<String, Object> pMap) {
		logger.info("boardSInsert ȣ�� ����");
		int result = 0;
		return result;
	}
}
