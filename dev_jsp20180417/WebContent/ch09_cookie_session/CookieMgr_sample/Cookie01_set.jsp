<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="util.CookieMgr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>CookiesŬ������ �̿��� ��Ű �����ϱ�</title>
</head>
<body>
<%
//	�������������������������������������������
//	���������������[ [ �� �� �� �� ] ]����������������
//	�������������������������������������������
//	������� ���尴ü Cookie Ŭ���� Ȱ���Ͽ� ��Ű�����ϱ� �������
//	�������������������������������������������
	
	//��Ű�����ϱ�
	Cookie cookie1 = new Cookie("cookie1",URLEncoder.encode("������ ���尴ü�� ���� ��Ű","UTF-8"));
	//���䰴ü�� ��Ű�߰��ϱ�
	response.addCookie(cookie1);
%>
<br>
��Ű������ �Ϸ�Ǿ����ϴ�.<br>
<br>
<h3>[���尴ü�� ������ ��Ű : cookie1]</h3>

�����Ű�� �ּҹ����� ���ɴϴ�<br>
	<font color="blue">
	�������ڸ��� ���� ������������ ������ ��Ű�� Ȯ���� �� �����ϴ�.<br></font>
Cookie[]
		= <%=request.getCookies() %><br>

����̸��� ���ɴϴ�.<br>
cookie1.getName()
		= <%=cookie1.getName() %><br> 

��尪�� ���ɴϴ�.<br>
cookie1.getValue()
		= <%=URLDecoder.decode(cookie1.getValue(),"UTF-8")%><br>
<br>
<%
	out.print("===============================================<br>");

//	��������������������������������������������
//	���������������[ [ ��Ű �Ŵ��� ] ]����������������
//	��������������������������������������������
//	������ CookieMgr.java Ŭ���� Ȱ���Ͽ� ��� �����ϱ� ������
//	��������������������������������������������
	
	//�ν��Ͻ��Ҷ� �����ڿ� ��û��ü�� �Ѱܱ�� (���ʽ���� ��Ű ���� ���̹Ƿ� ����ִ� �αװ� ����)
	CookieMgr cm = new CookieMgr(request,response);
	//��Ű���� �� ���䰴ü�� ��Ű�߰��ϱ�
	cm.setCookie("cookie2","�ѱ۵� ������� ��Ű�Ŵ���");
	
%>

<h3>[CookieMgr Ŭ������ ������ ��Ű : cookie2]</h3>

�����Ű�� �ּҹ����� ���ɴϴ�<br>
	<font color="blue">
	�������ڸ��� ���� ������������ ������ ��Ű�� Ȯ���� �� �����ϴ�.<br>
	�׷��� ��Ű �Ŵ����� �̿��ϸ� ���䰴ü�� ������ ��Ű�� ���ΰ�ħ�����ʾƵ� �ҷ��� �� �ֽ��ϴ�.<br></font>
cm.getCookie("cookie2")
		= <%=cm.getCookie("cookie2")%><br>

�����Ű�� �̸��� ���ɴϴ�<br>
cm.getCookieName("cookie2")
		= <%=cm.getCookieNameFromValue("cookie2")%><br>

��尪�� ���ɴϴ�.<br>
cm.getCookieValue("cookie2")
		= <%=cm.getCookieValue("cookie2")%><br>


<br>
<br>
�Ʒ� ��ũ�� ���� �������� �̵��Ͻʽÿ�.<br>
<br>
<a href="Cookie02_get.jsp">��Ű�� �о���� ������</a>

</body>
</html>