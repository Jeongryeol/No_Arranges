<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

main2.jsp���� ������ ��³���1
<%
	//main2.jsp���� ������ �����ߴ�.
	//sub2.jsp���� �� ������ ����� �� �ִ�.
	String name = "���� ������";//��������������, ���̷�Ƽ��� �ѱ� ������ sub2.jsp������ ��������ó�� �޾Ƶ��δ�.
%>

<%@ include file="./sub2.jsp" %>

<br>
main2.jsp���� ������ ��³���3


</body>
</html>