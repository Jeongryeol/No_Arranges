<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String gName = request.getParameter("gName");
	String gValue = request.getParameter("gValue");
	//out.print("�̸�:"+gName+", ��:"+gValue);
	Cookie c = new Cookie(gName,gValue);
	c.setMaxAge(60*60*24);
	response.addCookie(c);
	response.sendRedirect("./main.jsp");
%>