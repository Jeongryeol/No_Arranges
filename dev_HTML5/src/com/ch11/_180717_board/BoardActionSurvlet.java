package com.ch11._180717_board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* boardAction.jsp������ Survlet���� �����غ��� */
public class BoardActionSurvlet extends HttpServlet {

	public void doGet(HttpServletRequest req
					 ,HttpServletResponse res)
				throws ServletException, IOException
	{
		System.out.println("doGet() ȣ�⼺��");
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pwOut = res.getWriter();
		pwOut.println("26");
		
	}
	//�̷��� �ۼ��ϰ�
	//web.xml�� URL������ �־�����~
	
}
