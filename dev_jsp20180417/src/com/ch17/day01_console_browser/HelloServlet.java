package com.ch17.day01_console_browser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req
					 ,HttpServletResponse res) throws IOException, ServletException	{
		//�̰��� ������ �ܼ� �� ��Ĺ �ֿܼ� ��µǴ� ��
		System.out.println("doGetȣ�⼺��");
		
		//�̰��� ������ ��µǴ� ��
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.print("<b>����<font color='blue' size='20'>html</font>����</b>");
	}
	
}
