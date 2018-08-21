<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> memberList = 
		(List<Map<String,Object>>)request.getAttribute("memberList");
	Gson gs = new Gson();
	String jsonMember = gs.toJson(memberList);
	out.print(jsonMember);
%>