<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String isPass = request.getParameter("isPass");
	out.print(isPass);
	boolean b_pass = Boolean.parseBoolean(isPass);
	if(b_pass){
		out.print("����� <font color='blue'>�հ�</font> �Դϴ�.");
	}
	else{
		out.print("����� <font color='red'>���հ�</font> �Դϴ�.");
	}
%>    