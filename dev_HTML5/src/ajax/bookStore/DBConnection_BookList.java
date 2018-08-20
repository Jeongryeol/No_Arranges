package ajax.bookStore;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import ajax.book.BookServlet;

/***********************************************************************
 * @author	Jeongryeol Lee (이정렬)
 * @since	2018.07.27
 * @last 	2018.07.27
 * @purpose
 * 	1.	DB연동을 위한 연결객체 SqlSession을 생성하는 재사용클래스
 * 		이 때, MyBatis를 통해서 DB연동을 진행하기때문에, 아래 경로의 xml문서를 함께 작성했다.
 * 		- Java Resources/src/com/mybatis/MapperConfig_Book.xml
 ***********************************************************************/

public class DBConnection_BookList {

	//로그기록 준비
	Logger logger = Logger.getLogger(BookServlet.class);
	
	//MyBatis
	String resource
		= "util/db_mybatis/MapperConfig_Book.xml";//커넥션에 필요한 정보를 담은 xml문서
	SqlSessionFactory sqlMapper = null;
	SqlSession		  sqlSes	= null;

	public SqlSession getConnection(){
		logger.info("getConnection 호출 성공");
		
		try {
			//mybatis-3.4.6.pdf 2페이지  하단 참조
			//InputStream 대신 Reader class사용 : 한글바이트 때문
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();	//SqlSession 생성
	        reader.close();	//자원반납
	        
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("SqlSession 생성에러");
		}
		logger.info("getConnection 종료");
		
		return sqlSes;//SqlSession반납
	}
}
