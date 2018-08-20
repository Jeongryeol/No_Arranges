<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

main.jsp에서 생성한 출력내용1

<%
	//main.jsp에서 변수를 선언했다.
	//sub.jsp에서 이 변수를 사용할 수 없다.
	String name = "나는 변수다";//지역변수이다.
%>

<jsp:include page="./sub.jsp"/>

main.jsp에서 생성한 출력내용3

</body>
</html>