package com.ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class C9_MemberController extends HttpServlet {
	//�α��غ�
	Logger logger = Logger.getLogger(C9_MemberController.class);
	C9_MemberDao mDao = new C9_MemberDao();//DB������ü
	
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		String command = req.getParameter("command");
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		if("login".equals(command)) {
			logger.info("�α��� ó�� ����");
			String mem_name = mDao.login(mem_id,mem_pw);//���̵�� �н����� ����  
			//�α��ο� ����������
			if (mem_id!=null&&mem_name.length()>=1) {
				Cookie c_name = new Cookie("cmem_name",URLEncoder.encode(mem_name,"UTF-8"));
				c_name.setMaxAge(60*60);
				res.addCookie(c_name);//��Ű �߰�
				res.setContentType("text/html;charset=UTF-8");//���� ȭ�鿡 �Ѹ��Ƿ� �ѱ����ڵ�
				PrintWriter out = res.getWriter();
				out.print(mem_name+"�� ȯ���մϴ�.");
				//res.sendRedirect("./loginAction.jsp");
			}
			//�α��ο� ����������
			else {//ajaxó���� �����ϰ� �α��� ������������ �̵�����
				res.sendRedirect("./loginActionFail.jsp");
			}
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		doService(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doService(req,res);
	}
}
