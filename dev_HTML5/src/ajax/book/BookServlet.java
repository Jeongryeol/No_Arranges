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

	//�αױ�� �غ�
	Logger logger = Logger.getLogger(BookServlet.class);
	
	//�����б⸦ �����ϴ� ���񽺸޼ҵ�
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		logger.info("SELECT/��ȸȣ�� ����");//�α�
		BookDAO_MyBatis bookDao = new  BookDAO_MyBatis();			 //DAO-JDBC���� ����
		String command = req.getParameter("command");//String��ü-��û��ü�� �Ӽ��� ���
		
		//��ȸ SELECT
		if("select".equals(command)) {
			logger.info("SELECT/��ȸȣ�� ����");//�α�
			List<Map<String,Object>> bookList = null;//DB���� �Ѿ�� �ڷḦ ���� List �غ�
			bookList = bookDao.getBookList(null);	 //DB���� �Ѿ�� �ڷḦ ������ List ���
			
		}
		//��� INSERT
		else if("insert".equals(command)) {
			logger.info("INSERT/�Է�ȣ�� ����");//�α�
			int result = 0;							//DB���� �Ѿ�� ������� ���� int �غ�
			result = bookDao.getBookInsert(null);	//DB���� �Ѿ�� ������� ������ int ���
			
		}
		//���� UPDATE
		else if("update".equals(command)) {
			logger.info("UPDATE/����ȣ�� ����");//�α�
			int result = 0;							//DB���� �Ѿ�� ������� ���� int �غ�
			result = bookDao.getBookUpdate(null);	//DB���� �Ѿ�� ������� ������ int ���
		}
		//���� DELETE
		else if("delete".equals(command)) {
			logger.info("DELETE/����ȣ�� ����");//�α�
			int result = 0;							//DB���� �Ѿ�� ������� ���� int �غ�
			result = bookDao.getBookUpdate(null);	//DB���� �Ѿ�� ������� ������ int ���
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);//�����б�޼ҵ�� �ѱ�
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);//�����б�޼ҵ�� �ѱ�
	}
	
}
