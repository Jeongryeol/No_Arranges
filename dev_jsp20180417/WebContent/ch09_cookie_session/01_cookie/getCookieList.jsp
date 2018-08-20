<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>쿠키 읽어오기</title>
</head>
<body>

<h2>쿠키 읽어오기</h2>
<%
	//현재 요청헤더에 등록된 쿠키들을 배열로 받아온다
	Cookie[] cs = request.getCookies(); 
	
	for(int i=0;i<cs.length;i++){
		String cName = cs[i].getName();
		out.print("쿠키이름 : "+cName+", 쿠키값 : "+URLDecoder.decode(cs[i].getValue(),"UTF-8")+"<br>");//쿠키의 정보를 얻어올때 한글은
	}
%>

<br><br>
<h2>쿠키목록</h2>
<table border="1" width="700px">
	<tr>
		<th width="150px">쿠키이름</th>
		<th width="350px">쿠키값</th>
		<th width="200px"><a href="">쿠키변경</a> | <a href="">쿠키삭제</a></th>
	</tr>
<%
	for(int i=0;i<cs.length;i++){
		//세션ID를 제외하는 구문
		if("JSESSIONID".equals(cs[i].getName())) continue;
%>
	<tr>
		<td align="center"><%=cs[i].getName() %></td>
		<td align="center"><%=URLDecoder.decode(cs[i].getValue(),"UTF-8") %></td>
		<td align="center">		<!-- ?,= 연산자로  값을 넘기는 방법-->
			<a href="cookieUpdate.jsp?cname=<%=cs[i].getName() %>">쿠키변경</a>
			|
			<a href="cookieDelete.jsp?cname=<%=cs[i].getName() %>">쿠키삭제</a>
		</td>
	</tr>
<%
	}
%>
</table>

</body>
</html>