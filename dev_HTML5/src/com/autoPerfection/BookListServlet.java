package com.autoPerfection;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.googleMap_db.DAO_Food;
import com.google.googleMap_db.FoodServlet;
import com.google.googleMap_db.VO_FS_Menu;

public class BookListServlet extends HttpServlet {
	//로그를 찍는 loj4j의 로거 사용하기
	Logger logger = Logger.getLogger(BookListServlet.class);
	
	/* 	Tomcat이 주입해주는 res, req를 사용할 수  있는것은
		doGet(), doPost()메소드이므로 외부에서 처리해서 다시 메소드로 넘겨줌 */
	private void doService(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
	{
		DAO_Book bDao = new DAO_Book();
		List<VO_BookList> foodList = bDao.getBookInfoList(null);
		System.out.println(foodList.size());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
}
