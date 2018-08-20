<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String mem_name = (String)request.getAttribute("mem_name");
%>
<div>
	<h1> Hello, world!</h1>
	<h4>이곳은 로고가 들어가는 <%=mem_name %>의 자리입니다.</h4>
</div>