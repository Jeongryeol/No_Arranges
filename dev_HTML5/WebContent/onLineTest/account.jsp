<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String isPass = request.getParameter("isPass");
	boolean b_pass = Boolean.getBoolean(isPass);
	if(b_pass){
		out.print("당신은 <font color='blue'>합격</font>");
	} else {
		out.print("당신은 <font color='blue'>합격</font>");
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