<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="util.CookieMgr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ��� ��Ű�� ���� ����Ʈ</title>
</head>
<body>
<h2>��Ű�� �����մϴ�.</h2>
<%
	CookieMgr cm = new CookieMgr(request,response);
	cm.setCookie("ckNo1", "ù��°�� �����ߴ� ��Ű");
	cm.setCookie("ckNo2", "�ι�°�� �����ߴ� ��Ű");
	cm.setCookie("ckNo3", "����°�� �����ߴ� ��Ű");
	cm.setCookie("ckNo4", "�׹�°�� �����ߴ� ��Ű");
%>
---------------------------
<h2>�ܼ�â�� ��ü ��Ű�� ��ȸ�մϴ�.</h2>
<%
	cm.showAllCookie_console();
%>
</body>
</html>