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
	//�α׸� ��� loj4j�� �ΰ� ����ϱ�
	Logger logger = Logger.getLogger(BookListServlet.class);
	
	/* 	Tomcat�� �������ִ� res, req�� ����� ��  �ִ°���
		doGet(), doPost()�޼ҵ��̹Ƿ� �ܺο��� ó���ؼ� �ٽ� �޼ҵ�� �Ѱ��� */
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
