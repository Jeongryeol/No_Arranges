<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

main.jsp���� ������ ��³���1

<%
	//main.jsp���� ������ �����ߴ�.
	//sub.jsp���� �� ������ ����� �� ����.
	String name = "���� ������";//���������̴�.
%>

<jsp:include page="./sub.jsp"/>

main.jsp���� ������ ��³���3

</body>
</html>