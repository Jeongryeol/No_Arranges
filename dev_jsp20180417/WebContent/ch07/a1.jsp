<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a1.jsp</title>
</head>
<body>
1번 코드 처리<br>
2번 코드 처리<br>
<%
	String mem_id = "test";//이값은 getParameter로 읽어야 해요
	request.setAttribute("mem_pw", "123");//이값은 getAttribute로 읽을 수 있죠
%>    
<jsp:include page="b1.jsp">
	<jsp:param name="mem_id" value="<%=mem_id %>"/>
</jsp:include>
3번 코드 처리 안됨 - 왜냐면 응답처리에 대한 책임도 이동되버림.
</body>
</html>