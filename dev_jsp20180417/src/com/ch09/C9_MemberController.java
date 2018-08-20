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
	//로그준비
	Logger logger = Logger.getLogger(C9_MemberController.class);
	C9_MemberDao mDao = new C9_MemberDao();//DB연동객체
	
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		String command = req.getParameter("command");
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		if("login".equals(command)) {
			logger.info("로그인 처리 시작");
			String mem_name = mDao.login(mem_id,mem_pw);//아이디와 패스워드 전송  
			//로그인에 성공했을때
			if (mem_id!=null&&mem_name.length()>=1) {
				Cookie c_name = new Cookie("cmem_name",URLEncoder.encode(mem_name,"UTF-8"));
				c_name.setMaxAge(60*60);
				res.addCookie(c_name);//쿠키 추가
				res.setContentType("text/html;charset=UTF-8");//직접 화면에 뿌리므로 한글인코딩
				PrintWriter out = res.getWriter();
				out.print(mem_name+"님 환영합니다.");
				//res.sendRedirect("./loginAction.jsp");
			}
			//로그인에 실패했을때
			else {//ajax처리는 배제하고 로그인 실패페이지로 이동하자
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
