<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.google.googleMap_db.DAO_Food" %>
<%@ page import="com.google.googleMap_db.VO_FS_Menu" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%
	/* json���Ͽ� DB�� �ڷḦ �����ͺ���!! import�� ���� ���� ����!!*/
	/* TomCat�� jdbc�� jar������ ã�����ؼ� ����̹��� ���� ���Ѵٸ�,
		WEB-INF.lib�� jar������ �����صΰų� 
		TomCat��ġ�� ����� jar������ ���ΰ��� jar����̹��� �������ش�.*/
		
		
		DAO_Food fDao = new DAO_Food();	//DAOŬ���� ����Ʈ ��  �ν��Ͻ�ȭ
		List<VO_FS_Menu> foodList = fDao.getFoodInfoList(null);
										//
		Gson gs = new Gson();
		String jsonFoodList = gs.toJson(foodList);
		out.print(jsonFoodList);
%>