<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--안내문   html5부터는 상기3번의 html이하 내용 필요없음 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% //←자바코드를 입력가능한 스크립틀릿 영역 규정
	//자바네 땅
	String myName = "이순신";
	//아래 print메소드는 어디에 출력을 내보내는 걸까요??
	out.print("<b>"+myName+"</b>"+"님 환영합니다.");//태그를 추가하면 태그의 해석은 jvm이 아닌 브라우저가 한다.
%>
</body>
</html>