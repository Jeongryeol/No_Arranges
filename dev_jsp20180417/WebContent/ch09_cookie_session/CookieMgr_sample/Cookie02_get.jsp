<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="util.CookieMgr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��Ű �о����</title>
</head>
<body>

<h3>[���尴ü�� �о�� ��Ű : cookie1]</h3>

<%
//�������������������������������������������
//���������������[ [ �� �� �� �� ] ]����������������
//�������������������������������������������
//������� ���尴ü Cookie Ŭ���� Ȱ���Ͽ� ��Ű�о���� �������
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
				//��Ű�� ��� name�Ӽ� ����ϱ�
				out.print("���尴ü�� ���� ��Ű�� �� : "+URLDecoder.decode(cookies[i].getValue(),"UTF-8")+"<br>");
			}
		}
	}
	
	out.print("<br>===============================================<br>");
%>

<h3>[CookieMgrŬ������ ���� ��Ű : cookie2]</h3>

<%	
//	��������������������������������������������
//	���������������[ [ ��Ű �Ŵ��� ] ]����������������
//	��������������������������������������������
//	������ CookieMgr.java Ŭ���� Ȱ���Ͽ� ��� �о���� ������
//	��������������������������������������������
	
	//�ν��Ͻ��Ҷ� �����ڿ� ��û��ü�� �Ѱܼ� �Ŵ���Ŭ���� ���ο� ��Ű���� Map���� �غ��ص�
	CookieMgr cm = new CookieMgr(request,response);
	
	//��Ű�� ������ ��
	if(cm.checkCookie("cookie2")){
		
		//�ش� �̸��� ���� ��Ű �б�(�ּҹ���)
		Cookie c = cm.getCookie("cookie2");
	
		//�ش� �̸��� ���� ��Ű �б�(�ּҹ���)
		String cn = cm.getCookieNameFromValue("cookie2");	
		
		//�ش� �̸��� ���� ��Ű ���б�
		String cv = cm.getCookieValue("cookie2");			
		
		out.print("CookieMgr.java Ŭ������ ����� �����ؼ� ���� ��Ű�ּҹ��� : "+c+"<br>");
		out.print("CookieMgr.java Ŭ������ ����� �����ؼ� ���� ��Ű�̸� : "+cn+"<br>");
		out.print("CookieMgr.java Ŭ������ ����� �����ؼ� ���� ��Ű�� �� : "+cv+"<br>");
	}
%>



<br>
�Ʒ� ��ũ�� ���� �������� �̵��Ͻʽÿ�.<br>
<br>
<a href="Cookie03_modify.jsp">��Ű�� �����ϴ� ������</a>
</body>
</html>