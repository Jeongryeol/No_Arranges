<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	/* json���Ͽ� DB�� �ڷḦ �����ͺ���!! import�� ���� ���� ����!!*/
	/* TomCat�� jdbc�� jar������ ã�����ؼ� ����̹��� ���� ���Ѵٸ�,
		WEB-INF.lib�� jar������ �����صΰų� 
		TomCat��ġ�� ����� jar������ ���ΰ��� jar����̹��� �������ش�.*/
	List<Map<String,Object>> orderList = null;
	Gson gs = new Gson();
	String jsonOrderList = gs.toJson(orderList);
	out.print(jsonOrderList);
%>