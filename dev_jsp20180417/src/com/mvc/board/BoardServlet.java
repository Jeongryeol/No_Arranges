package com.mvc.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.ActionForward;

//스프링에서는 DispatcherServlet-> HttpServlet
//스트럿츠 ActionServlet        
//스트럿츠2(apache재단)에서는 ActionSupport -> HttpServlet 나는 서블릿에 의존적이지 않다.
public class BoardServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardServlet.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		logger.info("command:"+command);
		ActionForward forward = null;
		if("/mvcBoard/mvcBoard.bd".equals(command)) {
			BoardController bCtrl = new BoardController();
			String gubun = req.getParameter("gubun");
			Map<String,Object> pMap = new HashMap<String,Object>();
			try {
				//컨트롤 계층의 메소드 호출
				if("getBoardList".equals(gubun)) {
					forward = bCtrl.execute(req, res);
				}
				else if("boardInsert".equals(gubun)) {
					req.setAttribute("gubun", "boardInsert");
					forward = bCtrl.execute(req, res, pMap);
				}
			} catch (Exception e) {
				e.printStackTrace();//stack에 쌓여 있는 에러 메시지 출력하기
			}
		}
		//////////////////  응답 페이지 처리를 위한 코드 추가 /////////////////////
		if(forward !=null) {
			if(!forward.isRedirect()) {//isRedirect() or setRedirect()
				res.sendRedirect(forward.getPath());
			}
			else {
				//insert here
				RequestDispatcher view = req.getRequestDispatcher(forward.getPath());
				view.forward(req, res);
			}
		}///////////////end of forward null check
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		doService(req,res);
	}
}
