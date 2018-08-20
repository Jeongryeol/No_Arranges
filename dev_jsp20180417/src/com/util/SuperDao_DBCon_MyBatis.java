package com.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SuperDao_DBCon_MyBatis {
	SqlSessionFactory sqlMapper;
	SqlSession sqlSession;
	String resource = "com/mybatis/MapperConfig.xml";
	
	public SqlSession getSqlSession() {
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlMapper.openSession();
			reader.close();//다 사용했으면 닫기
			System.out.println("sqlSession 넘김");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sqlSession;
	}
}
