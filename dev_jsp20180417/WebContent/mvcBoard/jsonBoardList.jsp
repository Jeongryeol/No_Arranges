<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> getBoardList = 
		(List<Map<String,Object>>)request.getAttribute("getBoardList");
	Gson gs = new Gson();
	String jsonBoard = gs.toJson(getBoardList);
	out.print(jsonBoard);
%>