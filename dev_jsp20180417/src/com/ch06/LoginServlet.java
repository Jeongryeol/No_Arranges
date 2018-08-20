package com.ch06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
	//로그준비
	Logger logger = Logger.getLogger(LoginServlet.class);
	//GET|POST방식 모두에 대한 서비스 준비
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		//
		LoginDao logDao = null;
		
		//업무종류에 따른 command 속성 입력
		String command = req.getParameter("command");
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		/* [ [ logDao가 수행할 SQL ] ]
		  	SELECT mem_name FROM member
		   	 WHERE mem_id = 'test'
		       AND mem_pw = 123 */
		
		//업무별로 나누어서 처리 : 사용자(업무담당자)가 업무에 대한 선택
		if ("login".equals(command)) {
			logger.info("로그인 업무 요청 성공");
			String mem_name = logDao.login(mem_id,mem_pw);
			logger.info("로그인 메소드 호출 완료");
		}
/*		else if (condition) {
			
		} else if (condition) {
			
		} else if (condition) {
			
		} else {
			
		}*/
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {	doService(req,res); }
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {	doService(req,res);	}
}
