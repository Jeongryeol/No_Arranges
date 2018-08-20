<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
		Cookie cLogin = new Cookie("mem_id","test");//쿠키생성하기
		response.addCookie(cLogin);					//생성한 정보를 보내기
		Cookie cGoods1 = new Cookie("pants",URLEncoder.encode("나이키반바지","UTF-8"));//쿠키에 한글인코딩시 반드시 수행
		response.addCookie(cGoods1);
		Cookie cGoods2 = new Cookie("cream",URLEncoder.encode("UV썬크림","UTF-8"));
		response.addCookie(cGoods2);
		
		//쿠키를 생성하는 구문을 서버에 실행하두고 다른 파일에서 읽어보자
%>

</body>
</html>