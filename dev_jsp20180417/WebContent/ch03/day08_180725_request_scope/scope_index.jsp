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
	SCOPE(���� ����Ǵ� ������ ���������� ���� 4���� �ɼǹ���)
	1) page : ������ �ȿ��� ���� - ���뼺�� ������ [�⺻��]
	2) request : ��û�� �����Ǵ� ����
	3) session : ������ �����ϴ� ���� ���
	4) application : ����PC�� ������ ���� �ʴ� �� �����͸� ��� ������. - ������ �δ��� ��
 -->
			<!-- id�� �ν��Ͻ� ���� -->
<jsp:useBean id="gnomCar" scope="request" class="com.ch03.Sonata"/>
<jsp:useBean id="yourCar" scope="session" class="com.ch03.Sonata"/>

<%
	//�ҳ�Ÿ Ŭ���� �ν��Ͻ�ȭ�ϱ�
	Sonata herCar = new Sonata();
	
	//����׽�Ʈ
	out.print("herCar speed : "+herCar.speedUp());
	out.print("<br>gnomCar speed : "+gnomCar.speedUp());
	
	//��û��ü(request)�� �����ϱ�
	//forward�� �ϴ��� ��û��ü�� ����� ��ü�� �ּҹ����� ��ƾ��Ѵ�.
		//request.setAttribute("herCar", herCar);
		//request.setAttribute("GnomCar", gnomCar);
		//session.setAttribute("yourCar", yourCar);
	
	//���䰴ü(response)�� sendRedirect�ϱ� (�������� �������̵�)
	//���ǿ� ��� ���븸 �̵��� ���������� ��������.
		response.sendRedirect("scope_forward.jsp");
%>
</body>
</html>