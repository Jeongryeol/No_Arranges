<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String p_deptno
	= request.getParameter("deptno");
	String sql = "SELECT dname, loc FROM dept WHERE dname = '¿µ¾÷ºÎ'";
	sql += p_deptno;
	out.print("sql : "+sql);
%>