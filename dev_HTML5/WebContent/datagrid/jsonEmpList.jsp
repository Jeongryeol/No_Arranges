<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch11.EmpDAO,com.vo.VO_FoodStore" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%
	/* json���Ͽ� DB�� �ڷḦ �����ͺ���!! import�� ���� ���� ����!!*/
	/* TomCat�� jdbc�� jar������ ã�����ؼ� ����̹��� ���� ���Ѵٸ�,
		WEB-INF.lib�� jar������ �����صΰų� 
		TomCat��ġ�� ����� jar������ ���ΰ��� jar����̹��� �������ش�.*/
	EmpDAO eDao = new EmpDAO();
	List<VO_FoodStore> empList = eDao.getEmpList(null);
	Gson gs = new Gson();
	String jsonEmp = gs.toJson(empList);
	out.print(jsonEmp);
%>