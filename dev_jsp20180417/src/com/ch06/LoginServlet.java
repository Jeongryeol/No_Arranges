package com.ch06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
	//�α��غ�
	Logger logger = Logger.getLogger(LoginServlet.class);
	//GET|POST��� ��ο� ���� ���� �غ�
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		//
		LoginDao logDao = null;
		
		//���������� ���� command �Ӽ� �Է�
		String command = req.getParameter("command");
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		/* [ [ logDao�� ������ SQL ] ]
		  	SELECT mem_name FROM member
		   	 WHERE mem_id = 'test'
		       AND mem_pw = 123 */
		
		//�������� ����� ó�� : �����(���������)�� ������ ���� ����
		if ("login".equals(command)) {
			logger.info("�α��� ���� ��û ����");
			String mem_name = logDao.login(mem_id,mem_pw);
			logger.info("�α��� �޼ҵ� ȣ�� �Ϸ�");
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
