<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Cookie c = new Cookie("info","info");
	response.addCookie(c);
%>    
<script>
	alert("�α����� �ؾ� �̿��� �� �ֽ��ϴ�.");
	self.close();
	//location.href="./main.jsp";
</script>