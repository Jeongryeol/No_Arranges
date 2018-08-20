package com.pojo;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, Map<String,Object> pMap)
	throws Exception;
	/*
	public List<Map<String,Object>> execute(HttpServletResponse res, HttpServletRequest req)
	throws Exception;
	public List<Map<String,Object>> execute(int i, HttpServletResponse res, HttpServletRequest req)
	throws Exception;
	public List<Map<String,Object>> execute(ServletResponse res, ServletRequest req)
	throws Exception;*/
}
