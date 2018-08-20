package com.ch11._180717_board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* boardAction.jsp파일을 Survlet으로 변경해보자 */
public class BoardActionSurvlet extends HttpServlet {

	public void doGet(HttpServletRequest req
					 ,HttpServletResponse res)
				throws ServletException, IOException
	{
		System.out.println("doGet() 호출성공");
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pwOut = res.getWriter();
		pwOut.println("26");
		
	}
	//이렇게 작성하고
	//web.xml에 URL패턴을 넣어주자~
	
}
