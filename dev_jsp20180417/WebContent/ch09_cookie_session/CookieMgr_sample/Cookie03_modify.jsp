<%@page import="java.net.URLEncoder"%>
<%@page import="util.CookieMgr"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��Ű�����ϱ�</title>
</head>
<body>

<h3>[���尴ü�� ������ ��Ű : cookie1]</h3>

<%
//�������������������������������������������
//���������������[ [ �� �� �� �� ] ]����������������
//�������������������������������������������
//������� ���尴ü Cookie Ŭ���� Ȱ���Ͽ� ��Ű�����ϱ� �������
//�������������������������������������������	
	
	//��û��ü ����� ��� ��Ű�� ��� �� �迭�� ����
	Cookie[] cookies = request.getCookies();
	
	//�迭�� ��� ��Ű�� �����Ҷ�
	if(cookies!=null&&cookies.length>0){
		//�迭�� ���������� �ݺ�������
		for(int i=0;i<cookies.length;i++){	
			
			//JSESSIONID�� �ɷ���
			if("JSESSIONID".equals(cookies[i].getName())) continue;
		
			//���濡 ��� ��Ű�� �̸� �о����
			out.print("�Ѿ�� ��Ű["+i+"] : "+cookies[i].getName()+"<br>");
			
			//�̸������� ������
			if("cookie1".equals(cookies[i].getName())){
				//�ش� �̸��� ��Ű�� ���� ���� �����ϱ�
				Cookie cookie1 = new Cookie("cookie1",URLEncoder.encode("������ ���尴ü�� ���� ��Ű�� ���� �ٲ� ����","UTF-8"));
				//���䰴ü�� ��Ű�߰��ϱ�
				response.addCookie(cookie1);
			}
		}
	}
	
	out.print("<br>===============================================<br>");
%>

<h3>[CookieMgr Ŭ������ ������ ��Ű : cookie2]</h3>

<%
//	��������������������������������������������
//	���������������[ [ ��Ű �Ŵ��� ] ]����������������
//	��������������������������������������������
//	������ CookieMgr.java Ŭ���� Ȱ���Ͽ� ��� �����ϱ� ������
//	��������������������������������������������
	
	//�ν��Ͻ��Ҷ� �����ڿ� ��û��ü�� �Ѱܼ� �Ŵ���Ŭ���� ���ο� ��Ű���� Map���� �غ��ص�
	CookieMgr cm = new CookieMgr(request,response);
	
	//��Ű�� ������ ��
	if(cm.checkCookie("cookie2")){
		
		//�ش� �̸��� ���� ��Ű �� �����ϱ�
		//���� �� res��ü��� �����ϸ� 1��ȯ / �����ϸ� 0��ȯ
		int result = cm.changeCookieValue("cookie2","���浵 ���ڵ� ���ص� �˴ϴ�.");
		
		//������ ��Ű�� ������
		String changedValue = cm.getCookieValue("cookie2");
		
		out.print("CookieMgr.java Ŭ������ �����û�� ��� : result = "+result+"<br>");
		out.print("CookieMgr.java Ŭ������ �����û�� ��Ű�� ��: cookie2 = "+changedValue+"<br>");
		
	}
	
%>

<br>
�Ʒ� ��ũ�� ���� �������� �̵��Ͻʽÿ�.<br>
<br>
<a href="Cookie04_delete.jsp">��Ű�� �����ϴ� ������</a>
</body>
</html>