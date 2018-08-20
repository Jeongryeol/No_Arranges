package com.pojo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController extends GenericServlet {
	
	public abstract List<Map<String,Object>> 
	getList(HttpServletRequest req, HttpServletResponse res,Map<String,Object> pMap) throws Exception;
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String mode = req.getParameter("mode");
		Map<String,Object> pMap = new HashMap<String,Object>();
		try {
			if("select".equals(mode)) {
				getList(req,res,null);
			}else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
}
