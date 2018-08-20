<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

main2.jsp에서 생성한 출력내용1
<%
	//main2.jsp에서 변수를 선언했다.
	//sub2.jsp에서 이 변수를 사용할 수 있다.
	String name = "나는 변수다";//지역변수이지만, 다이렉티브로 넘긴 내용을 sub2.jsp에서는 전역변수처럼 받아들인다.
%>

<%@ include file="./sub2.jsp" %>

<br>
main2.jsp에서 생성한 출력내용3


</body>
</html>