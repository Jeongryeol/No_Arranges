package ajax.bookStore;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import ajax.book.BookServlet;

/***********************************************************************
 * @author	Jeongryeol Lee (������)
 * @since	2018.07.27
 * @last 	2018.07.27
 * @purpose
 * 	1.	DB������ ���� ���ᰴü SqlSession�� �����ϴ� ����Ŭ����
 * 		�� ��, MyBatis�� ���ؼ� DB������ �����ϱ⶧����, �Ʒ� ����� xml������ �Բ� �ۼ��ߴ�.
 * 		- Java Resources/src/com/mybatis/MapperConfig_Book.xml
 ***********************************************************************/

public class DBConnection_BookList {

	//�αױ�� �غ�
	Logger logger = Logger.getLogger(BookServlet.class);
	
	//MyBatis
	String resource
		= "util/db_mybatis/MapperConfig_Book.xml";//Ŀ�ؼǿ� �ʿ��� ������ ���� xml����
	SqlSessionFactory sqlMapper = null;
	SqlSession		  sqlSes	= null;

	public SqlSession getConnection(){
		logger.info("getConnection ȣ�� ����");
		
		try {
			//mybatis-3.4.6.pdf 2������  �ϴ� ����
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ ����
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();	//SqlSession ����
	        reader.close();	//�ڿ��ݳ�
	        
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("SqlSession ��������");
		}
		logger.info("getConnection ����");
		
		return sqlSes;//SqlSession�ݳ�
	}
}
