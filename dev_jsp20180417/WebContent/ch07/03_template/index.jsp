<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");//�ѱ�ó�� ��������~
	request.setAttribute("mem_name","�̼���");
	
	String mission = "mis";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include �׼��±׿� ���̷�Ƽ�긦 �����ϴ� ���ø� ����������</title>
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
				<%-- param�׼��±״� ������ name���θ� �̸��� �� �� �ִ�. ȭ�鿡�� ó���Ǳ����� ���� ���� �����ϱ� �����ε�? --%>
				<%-- jsp�׼��±״� �ڹٽ�ũ��Ʈ �����̹Ƿ� �ڹٽ�ũ��Ʈ �ּ��� �����ؾ� WAS�� StackOverFlow�� ���Ҽ��ִ� (500����) --%>
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