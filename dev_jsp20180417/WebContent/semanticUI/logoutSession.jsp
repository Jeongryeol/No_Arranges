<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.invalidate();//세션에 담긴 모든 값 삭제하기
	response.sendRedirect("main.jsp");
%>