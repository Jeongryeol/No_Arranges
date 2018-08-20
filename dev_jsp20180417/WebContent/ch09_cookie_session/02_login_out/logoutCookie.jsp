<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//로그아웃을 위해 쿠키를 삭제함
	Cookie c = new Cookie("cmem_name","");
	c.setMaxAge(0);
	response.addCookie(c);
	response.sendRedirect("./main.jsp");
%>