<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.List, java.util.Map" %>
<%@ page import = "com.google.gson.Gson" %>
<%
	//json포맷으로 변경함
	List<Map<String,Object>> memberList =
			(List<Map<String,Object>>)request.getAttribute("memberList");
	Gson gs = new Gson();
	String jsonMember = gs.toJson(memberList);
	out.print(jsonMember);
%>