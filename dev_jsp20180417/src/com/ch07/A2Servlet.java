package com.ch07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class A2Servlet extends HttpServlet {

	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		List<Map<String,Object>> boardList = new ArrayList<Map<String,Object>>();
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("b_no", 1);
		rMap.put("b_title", "게시판 제목1");
		boardList.add(rMap);
		rMap = new HashMap<String,Object>();
		rMap.put("b_no", 2);
		rMap.put("b_title", "게시판 제목2");
		boardList.add(rMap);
		req.setAttribute("boardList", boardList);
		RequestDispatcher view = req.getRequestDispatcher("a2.jsp");
		view.forward(req, res);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}

}
