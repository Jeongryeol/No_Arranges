<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.invalidate();//���ǿ� ��� ��� �� �����ϱ�
	response.sendRedirect("main.jsp");
%>