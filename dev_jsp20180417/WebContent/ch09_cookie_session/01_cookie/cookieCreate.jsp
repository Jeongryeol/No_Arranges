<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
		Cookie cLogin = new Cookie("mem_id","test");//��Ű�����ϱ�
		response.addCookie(cLogin);					//������ ������ ������
		Cookie cGoods1 = new Cookie("pants",URLEncoder.encode("����Ű�ݹ���","UTF-8"));//��Ű�� �ѱ����ڵ��� �ݵ�� ����
		response.addCookie(cGoods1);
		Cookie cGoods2 = new Cookie("cream",URLEncoder.encode("UV��ũ��","UTF-8"));
		response.addCookie(cGoods2);
		
		//��Ű�� �����ϴ� ������ ������ �����ϵΰ� �ٸ� ���Ͽ��� �о��
%>

</body>
</html>