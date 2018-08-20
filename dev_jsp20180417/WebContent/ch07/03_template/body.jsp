<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	String time = request.getParameter("time").toString();
%>
<div>
	<h1>여기가 보디!</h1>
	현재시간은 <%=time %>
</div>