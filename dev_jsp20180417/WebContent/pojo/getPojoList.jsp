<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 목록을 처리하는 페이지 :: 즉 SELECT를 처리하는 페이지 --%>
<%
	//이 페이지를 요청한 요청객체에서 넘어올 속성을 얻어냄
	List<Map<String,Object>> pojoList
			= (List<Map<String,Object>>)request.getAttribute("pojoList");

	//화면에 뿌림
	out.print(pojoList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>목록</title>


</head>
<body>



</body>
</html>