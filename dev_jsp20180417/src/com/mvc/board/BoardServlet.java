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

//������������ DispatcherServlet-> HttpServlet
//��Ʈ���� ActionServlet        
//��Ʈ����2(apache���)������ ActionSupport -> HttpServlet ���� ������ ���������� �ʴ�.
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
				//��Ʈ�� ������ �޼ҵ� ȣ��
				if("getBoardList".equals(gubun)) {
					forward = bCtrl.execute(req, res);
				}
				else if("boardInsert".equals(gubun)) {
					req.setAttribute("gubun", "boardInsert");
					forward = bCtrl.execute(req, res, pMap);
				}
			} catch (Exception e) {
				e.printStackTrace();//stack�� �׿� �ִ� ���� �޽��� ����ϱ�
			}
		}
		//////////////////  ���� ������ ó���� ���� �ڵ� �߰� /////////////////////
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
