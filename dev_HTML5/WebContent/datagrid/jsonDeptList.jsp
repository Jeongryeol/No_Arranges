<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch11.EmpDAO, com.vo.DeptVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%
	/* json���Ͽ� DB�� �ڷḦ �����ͺ���!! import�� ���� ���� ����!!*/
	/* TomCat�� jdbc�� jar������ ã�����ؼ� ����̹��� ���� ���Ѵٸ�,
		WEB-INF.lib�� jar������ �����صΰų� 
		TomCat��ġ�� ����� jar������ ���ΰ��� jar����̹��� �������ش�.*/
	EmpDAO eDao = new EmpDAO();
	List<DeptVO> deptList = eDao.getDeptList(null);
	Gson gs = new Gson();
	String jsonDept = gs.toJson(deptList);
	out.print(jsonDept);
%>