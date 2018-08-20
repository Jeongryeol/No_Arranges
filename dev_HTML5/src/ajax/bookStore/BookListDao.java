package ajax.bookStore;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import ajax.book.BookServlet;

/***********************************************************************
 * @author	Jeongryeol Lee (이정렬)
 * @since	2018.07.27
 * @last 	2018.07.27
 * @purpose
 * 	1.	[ BookListServlet.java ]에서 호출받을 때 적합한 SQL문을 호출하도록 한다.
 * 		이 때, MyBatis를 통해서 DB연동을 진행하기때문에, 아래 경로의 xml문서를 함게 작성했다.
 * 		- Java Resources/src/com/mybatis/MapperConfig_Book.xml
 * 		- Java Resources/src/com/mybatis/maps/bookList.xml
 * 	2.	DB연동한 반환값을 [ BookListServlet.java ]로 돌려준다.
 * 		- SELECT 조회 작업의 반환데이터는 List<Map<String,Object>> 타입
 * 		- INSERT,UPDATE,DELETE 입력,수정,삭제 작업의 반환데이터는 int 타입
 ***********************************************************************/

public class BookListDao {

	//로그기록 준비
	Logger logger = Logger.getLogger(BookServlet.class);
	
	//MyBatis-연결객체(SqlSession)생성준비
	DBConnection_BookList dbcon = new DBConnection_BookList();
	SqlSession sqlSes = null;
	
	/*******************************************************************
	 * @purpose	도서명조회
	 * @param	pMap : 서블릿으로부터 전달받은 사용자의 입력값
	 * 		{"b_name",b_name}
	 * @map.xml	bookList.xml
	 * @return	rlist : 서블릿으로 보낼 DB 조회정보
	 *******************************************************************/
	public List<Map<String,Object>> getBookList(Map<String,Object> pMap){
		List<Map<String,Object>> rlist = null;	//반환타입 설정
		sqlSes = dbcon.getConnection();			//연결객체 생성
		
		rlist = sqlSes.selectList("getBookList", pMap);//DB반환
		
		return rlist;//반환
	}
}
