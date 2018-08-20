package com.google.googleMap_db;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FoodServlet extends HttpServlet {

	//�α׸� ��� loj4j�� �ΰ� ����ϱ�
	Logger logger = Logger.getLogger(FoodServlet.class);
	
	/* 	Tomcat�� �������ִ� res, req�� ����� ��  �ִ°���
		doGet(), doPost()�޼ҵ��̹Ƿ� �ܺο��� ó���ؼ� �ٽ� �޼ҵ�� �Ѱ��� */
	private void doService(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
	{
		DAO_Food fDao = new DAO_Food();
		List<VO_FS_Menu> foodList = fDao.getFoodInfoList(null);
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
