<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch03.Sonata" %>
<%
	//foward로 넘어온 소나타 객체의 원본을 참조해보자. 어떻게 하면 될까?
	Sonata gnomCar =(Sonata)request.getAttribute("gnomCar");
	Sonata herCar =(Sonata)request.getAttribute("herCar");
	Sonata yourCar =(Sonata)session.getAttribute("yourCar");
	out.print("");
	out.print("gromCar 주소번지 : "+gnomCar);
	out.print("<br>herCar 주소번지 : "+herCar);
	out.print("<br>yourCar 주소번지 : "+yourCar);
%>