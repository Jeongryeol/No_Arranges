package ajax.bookStore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ajax.book.BookServlet;
/*************************************************************************
 * @author	Jeongryeol Lee (이정렬)
 * @since	2018.07.27
 * @last 	2018.07.27
 * @purpose
 * 	1.	BookIntro.jsp로부터 ajax로 요청받은 조회업무(SELECT)를 수행하고 결과를 반환한다.
 * 		이 때, DAO 클래스와 연동하여 다른 SQL문에 대한 재사용성을 고려한다.  
 *************************************************************************/
@WebServlet("/BookList.JL")
public class BookListServlet extends HttpServlet {
	
	//로그기록 준비
	Logger logger = Logger.getLogger(BookServlet.class);
	
	/**********************************************
	 * @method doShare
	 * @perpose CRUD 업무분기하여 적합한 DAO실행
	 **********************************************/
    public void doShare(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
    	logger.info("doShare() 호출성공...업무분기 시작");//로그
    }
    
    @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	doShare(req, res);//업무를 분기하는 메소드로 주입객체 원본전달
	}
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doShare(req, res);//업무를 분기하는 메소드로 주입객체 원본전달
	}

}
