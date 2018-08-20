package ajax.book;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BookServlet extends HttpServlet {

	//로그기록 준비
	Logger logger = Logger.getLogger(BookServlet.class);
	
	//업무분기를 수행하는 서비스메소드
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		logger.info("SELECT/조회호출 성공");//로그
		BookDAO_MyBatis bookDao = new  BookDAO_MyBatis();			 //DAO-JDBC연동 전담
		String command = req.getParameter("command");//String객체-요청객체의 속성값 담기
		
		//조회 SELECT
		if("select".equals(command)) {
			logger.info("SELECT/조회호출 성공");//로그
			List<Map<String,Object>> bookList = null;//DB에서 넘어온 자료를 담을 List 준비
			bookList = bookDao.getBookList(null);	 //DB에서 넘어온 자료를 리턴한 List 담기
			
		}
		//등록 INSERT
		else if("insert".equals(command)) {
			logger.info("INSERT/입력호출 성공");//로그
			int result = 0;							//DB에서 넘어온 결과값을 담을 int 준비
			result = bookDao.getBookInsert(null);	//DB에서 넘어온 결과값을 리턴한 int 담기
			
		}
		//수정 UPDATE
		else if("update".equals(command)) {
			logger.info("UPDATE/수정호출 성공");//로그
			int result = 0;							//DB에서 넘어온 결과값을 담을 int 준비
			result = bookDao.getBookUpdate(null);	//DB에서 넘어온 결과값을 리턴한 int 담기
		}
		//삭제 DELETE
		else if("delete".equals(command)) {
			logger.info("DELETE/삭제호출 성공");//로그
			int result = 0;							//DB에서 넘어온 결과값을 담을 int 준비
			result = bookDao.getBookUpdate(null);	//DB에서 넘어온 결과값을 리턴한 int 담기
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);//업무분기메소드로 넘김
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);//업무분기메소드로 넘김
	}
	
}
