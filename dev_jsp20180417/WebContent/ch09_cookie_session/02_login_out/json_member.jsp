<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
	List<Map<String,Object>> memberList = new ArrayList<>();
	Map<String,Object> rMap = new HashMap<>();
	rMap.put("id", "test");
	rMap.put("password", "123");
	rMap.put("name","테스터");
		memberList.add(rMap);
	rMap = new HashMap<>();
	rMap.put("id", "guest");
	rMap.put("password", "456");
	rMap.put("name","게스트");
		memberList.add(rMap);
	rMap = new HashMap<>();
	rMap.put("id", "admin");
	rMap.put("password", "789");
	rMap.put("name","관리자");
		memberList.add(rMap);
	//out.print(memberList);
	
	Gson gs = new Gson();
	String jsonMember = gs.toJson(memberList);
	
%>