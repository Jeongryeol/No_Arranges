<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> zipCodeList = 
		(List<Map<String,Object>>)request.getAttribute("zipCodeList");
	Gson gs = new Gson();
	String jsonZipCode = gs.toJson(zipCodeList);
	out.print(jsonZipCode);
%>