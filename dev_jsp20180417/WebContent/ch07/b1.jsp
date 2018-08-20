<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String mem_id = request.getParameter("mem_id");
	//String mem_pw2 = request.getAttribute("mem_pw");
	Object mem_pw = request.getAttribute("mem_pw");
	out.print("아이디 : "+mem_id);
	out.print("<br>");
	out.print("비번 : "+mem_pw.toString());
%>
</body>
</html>