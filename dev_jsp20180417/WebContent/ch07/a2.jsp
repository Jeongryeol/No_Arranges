<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
/*
	
*/
	List<Map<String,Object>> boardList = 
	(List<Map<String,Object>>)request.getAttribute("boardList");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr><th>글번호</th><th>글제목</th></tr>
<%
	if(boardList !=null && boardList.size()>0){
		for(int i=0;i<boardList.size();i++){
		Map<String,Object> rMap = boardList.get(i);
%>
<!-- myBatis를 사용할 땐 반드시 대문자로 작성할것. -->
    <tr><th><%=rMap.get("b_no") %></th><th><%=rMap.get("B_title") %></th></tr>
<%
		}
	}
	else{
%>	
    <tr><th colspan="2">조회결과가 없습니다.</th></tr>
<%
	}
%>
</table>
</body>
</html>