<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��Ű �о����</title>
</head>
<body>

<h2>��Ű �о����</h2>
<%
	//���� ��û����� ��ϵ� ��Ű���� �迭�� �޾ƿ´�
	Cookie[] cs = request.getCookies(); 
	
	for(int i=0;i<cs.length;i++){
		String cName = cs[i].getName();
		out.print("��Ű�̸� : "+cName+", ��Ű�� : "+URLDecoder.decode(cs[i].getValue(),"UTF-8")+"<br>");//��Ű�� ������ ���ö� �ѱ���
	}
%>

<br><br>
<h2>��Ű���</h2>
<table border="1" width="700px">
	<tr>
		<th width="150px">��Ű�̸�</th>
		<th width="350px">��Ű��</th>
		<th width="200px"><a href="">��Ű����</a> | <a href="">��Ű����</a></th>
	</tr>
<%
	for(int i=0;i<cs.length;i++){
		//����ID�� �����ϴ� ����
		if("JSESSIONID".equals(cs[i].getName())) continue;
%>
	<tr>
		<td align="center"><%=cs[i].getName() %></td>
		<td align="center"><%=URLDecoder.decode(cs[i].getValue(),"UTF-8") %></td>
		<td align="center">		<!-- ?,= �����ڷ�  ���� �ѱ�� ���-->
			<a href="cookieUpdate.jsp?cname=<%=cs[i].getName() %>">��Ű����</a>
			|
			<a href="cookieDelete.jsp?cname=<%=cs[i].getName() %>">��Ű����</a>
		</td>
	</tr>
<%
	}
%>
</table>

</body>
</html>