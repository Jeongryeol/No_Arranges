<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch03.Sonata" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!--
	SCOPE(웹에 저장되는 데이터 유지범위에 따른 4가지 옵션범위)
	1) page : 페이지 안에서 유지 - 재사용성이 떨어짐 [기본값]
	2) request : 요청이 유지되는 동안
	3) session : 세션이 유지하는 동안 기억
	4) application : 서버PC의 전원을 끄지 않는 한 데이터를 계속 유지함. - 서버에 부담을 줌
 -->
			<!-- id는 인스턴스 변수 -->
<jsp:useBean id="gnomCar" scope="request" class="com.ch03.Sonata"/>
<jsp:useBean id="yourCar" scope="session" class="com.ch03.Sonata"/>

<%
	//소나타 클래스 인스턴스화하기
	Sonata herCar = new Sonata();
	
	//출력테스트
	out.print("herCar speed : "+herCar.speedUp());
	out.print("<br>gnomCar speed : "+gnomCar.speedUp());
	
	//요청객체(request)에 저장하기
	//forward를 하더라도 요청객체에 사용할 객체의 주소번지를 담아야한다.
		//request.setAttribute("herCar", herCar);
		//request.setAttribute("GnomCar", gnomCar);
		//session.setAttribute("yourCar", yourCar);
	
	//응답객체(response)로 sendRedirect하기 (목적지로 페이지이동)
	//세션에 담긴 내용만 이동한 페이지에서 읽혀진다.
		response.sendRedirect("scope_forward.jsp");
%>
</body>
</html>