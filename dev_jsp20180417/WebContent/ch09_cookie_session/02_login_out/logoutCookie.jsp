<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//�α׾ƿ��� ���� ��Ű�� ������
	Cookie c = new Cookie("cmem_name","");
	c.setMaxAge(0);
	response.addCookie(c);
	response.sendRedirect("./main.jsp");
%>