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
 * @author	Jeongryeol Lee (������)
 * @since	2018.07.27
 * @last 	2018.07.27
 * @purpose
 * 	1.	BookIntro.jsp�κ��� ajax�� ��û���� ��ȸ����(SELECT)�� �����ϰ� ����� ��ȯ�Ѵ�.
 * 		�� ��, DAO Ŭ������ �����Ͽ� �ٸ� SQL���� ���� ���뼺�� ����Ѵ�.  
 *************************************************************************/
@WebServlet("/BookList.JL")
public class BookListServlet extends HttpServlet {
	
	//�αױ�� �غ�
	Logger logger = Logger.getLogger(BookServlet.class);
	
	/**********************************************
	 * @method doShare
	 * @perpose CRUD �����б��Ͽ� ������ DAO����
	 **********************************************/
    public void doShare(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
    	logger.info("doShare() ȣ�⼺��...�����б� ����");//�α�
    }
    
    @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	doShare(req, res);//������ �б��ϴ� �޼ҵ�� ���԰�ü ��������
	}
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doShare(req, res);//������ �б��ϴ� �޼ҵ�� ���԰�ü ��������
	}

}
