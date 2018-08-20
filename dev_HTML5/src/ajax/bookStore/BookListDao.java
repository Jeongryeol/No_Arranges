package ajax.bookStore;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import ajax.book.BookServlet;

/***********************************************************************
 * @author	Jeongryeol Lee (������)
 * @since	2018.07.27
 * @last 	2018.07.27
 * @purpose
 * 	1.	[ BookListServlet.java ]���� ȣ����� �� ������ SQL���� ȣ���ϵ��� �Ѵ�.
 * 		�� ��, MyBatis�� ���ؼ� DB������ �����ϱ⶧����, �Ʒ� ����� xml������ �԰� �ۼ��ߴ�.
 * 		- Java Resources/src/com/mybatis/MapperConfig_Book.xml
 * 		- Java Resources/src/com/mybatis/maps/bookList.xml
 * 	2.	DB������ ��ȯ���� [ BookListServlet.java ]�� �����ش�.
 * 		- SELECT ��ȸ �۾��� ��ȯ�����ʹ� List<Map<String,Object>> Ÿ��
 * 		- INSERT,UPDATE,DELETE �Է�,����,���� �۾��� ��ȯ�����ʹ� int Ÿ��
 ***********************************************************************/

public class BookListDao {

	//�αױ�� �غ�
	Logger logger = Logger.getLogger(BookServlet.class);
	
	//MyBatis-���ᰴü(SqlSession)�����غ�
	DBConnection_BookList dbcon = new DBConnection_BookList();
	SqlSession sqlSes = null;
	
	/*******************************************************************
	 * @purpose	��������ȸ
	 * @param	pMap : �������κ��� ���޹��� ������� �Է°�
	 * 		{"b_name",b_name}
	 * @map.xml	bookList.xml
	 * @return	rlist : �������� ���� DB ��ȸ����
	 *******************************************************************/
	public List<Map<String,Object>> getBookList(Map<String,Object> pMap){
		List<Map<String,Object>> rlist = null;	//��ȯŸ�� ����
		sqlSes = dbcon.getConnection();			//���ᰴü ����
		
		rlist = sqlSes.selectList("getBookList", pMap);//DB��ȯ
		
		return rlist;//��ȯ
	}
}
