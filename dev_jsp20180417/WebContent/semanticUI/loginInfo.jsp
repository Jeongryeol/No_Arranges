<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Cookie c = new Cookie("info","info");
	response.addCookie(c);
%>    
<script>
	alert("로그인을 해야 이용할 수 있습니다.");
	self.close();
	//location.href="./main.jsp";
</script>