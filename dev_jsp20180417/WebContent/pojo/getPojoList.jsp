<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- ����� ó���ϴ� ������ :: �� SELECT�� ó���ϴ� ������ --%>
<%
	//�� �������� ��û�� ��û��ü���� �Ѿ�� �Ӽ��� ��
	List<Map<String,Object>> pojoList
			= (List<Map<String,Object>>)request.getAttribute("pojoList");

	//ȭ�鿡 �Ѹ�
	out.print(pojoList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>


</head>
<body>



</body>
</html>