<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a1.jsp</title>
</head>
<body>
1�� �ڵ� ó��<br>
2�� �ڵ� ó��<br>
<%
	String mem_id = "test";//�̰��� getParameter�� �о�� �ؿ�
	request.setAttribute("mem_pw", "123");//�̰��� getAttribute�� ���� �� ����
%>    
<jsp:include page="b1.jsp">
	<jsp:param name="mem_id" value="<%=mem_id %>"/>
</jsp:include>
3�� �ڵ� ó�� �ȵ� - �ֳĸ� ����ó���� ���� å�ӵ� �̵��ǹ���.
</body>
</html>