<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");//한글처리 잊지말기~
	request.setAttribute("mem_name","이순신");
	
	String mission = "mis";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include 액션태그와 다이렉티브를 경험하는 템플릿 메인페이지</title>
</head>
<body>
<div align="center">
<table border="1" width="900px" height="900px">
	<tr>
		<td align="center">
			<jsp:include page="./top.jsp" flush="false"/>
		</td>
	</tr>
	<tr>
		<td align="center">
			<jsp:include page="./main.jsp" flush="false">
				<jsp:param value="<%=mission%>" name="p_mission"/>
				<jsp:param value="quest" name="p_quest" />
				<%-- param액션태그는 무조건 name으로만 이름을 줄 수 있다. 화면에서 처리되기전에 먼저 값을 전달하기 때문인듯? --%>
				<%-- jsp액션태그는 자바스크립트 영역이므로 자바스크립트 주석을 삽입해야 WAS의 StackOverFlow를 피할수있다 (500에러) --%>
			</jsp:include>
		</td>
	</tr>
	<tr>
		<td align="center">
			<jsp:include page="./bottom.jsp" flush="false"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>