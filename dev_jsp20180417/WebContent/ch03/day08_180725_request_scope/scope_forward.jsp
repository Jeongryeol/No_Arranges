<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch03.Sonata" %>
<%
	//foward�� �Ѿ�� �ҳ�Ÿ ��ü�� ������ �����غ���. ��� �ϸ� �ɱ�?
	Sonata gnomCar =(Sonata)request.getAttribute("gnomCar");
	Sonata herCar =(Sonata)request.getAttribute("herCar");
	Sonata yourCar =(Sonata)session.getAttribute("yourCar");
	out.print("");
	out.print("gromCar �ּҹ��� : "+gnomCar);
	out.print("<br>herCar �ּҹ��� : "+herCar);
	out.print("<br>yourCar �ּҹ��� : "+yourCar);
%>