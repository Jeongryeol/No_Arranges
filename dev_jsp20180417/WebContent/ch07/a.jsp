<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp</title>
</head>
<body>
1�� �ڵ� ó��<br>
2�� �ڵ� ó��<br>
<%
//�� �������� ȭ�鿡�� ���� �� �� �����
//�ֳ��ϸ� �� �ȿ� forward�� �ֱ� ��������
	String mem_id = "test";//�̰��� getParameter�� �о�� �ؿ�
	request.setAttribute("mem_pw", "123");//�̰��� getAttribute�� ���� �� ����
%>    
<jsp:forward page="b.jsp">
	<jsp:param name="mem_id" value="<%=mem_id %>"/>
</jsp:forward>
3�� �ڵ� ó�� �ȵ� - �ֳĸ� ����ó���� ���� å�ӵ� �̵��ǹ���.
</body>
</html>