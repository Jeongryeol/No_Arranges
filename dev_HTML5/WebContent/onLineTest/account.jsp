<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String isPass = request.getParameter("isPass");
	boolean b_pass = Boolean.getBoolean(isPass);
	if(b_pass){
		out.print("����� <font color='blue'>�հ�</font>");
	} else {
		out.print("����� <font color='blue'>�հ�</font>");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>