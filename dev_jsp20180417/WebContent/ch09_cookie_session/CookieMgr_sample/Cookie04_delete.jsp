<%@page import="util.CookieMgr"%>
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
//	�������������������������������������������
//	���������������[ [ �� �� �� �� ] ]����������������
//	�������������������������������������������
//	������� ���尴ü Cookie Ŭ���� Ȱ���Ͽ� ��Ű�����ϱ� �������
//	�������������������������������������������	

	//�� ���� PC�� ����� ��Ű������ ������ ��û�ϰ�, ��û����� ���� ��Ű�� �迭�� ����
	Cookie[] cs = request.getCookies();
 	
	int result = 0;//����ݿ����� Ȯ���� ����
	
	//�����ϰ����ϴ� ��Ű�� �̸�
	String del_CookieName = "cookie1";
	out.print("<br>�����ϰ����ϴ� ��Ű�� �̸� : "+del_CookieName+"<br><br>");
	
	if(cs!=null&&cs.length>0){				//��Ű�迭��ü cs�� ������ ��
		for(int i=0;i<cs.length;i++){		//�ݺ�����
			
			if("JSESSIONID".equals(cs[i].getName())) continue;
			
			//��Ű�� ����ִ� �̸��� ����
			String cName = cs[i].getName();
			
			//��Ű�� ����ִ� ���� ����� ���� ���� ������ ��
			if(del_CookieName.equals(cName)){
				
				//��Ű�����ϱ� 3�ܰ�
				Cookie delete_Cookie = new Cookie(cName,"");//��Ű�� ����ִ� �̸��� ��ĭ���� �ʱ�ȭ
				delete_Cookie.setMaxAge(0);					//�ִ�ð� 0 = ��Ű����
				response.addCookie(delete_Cookie);			//������ ������ ��Ű�� �ݿ��ϱ�
				
				result = 1;//���������Ƿ� ������� 1�� ����
				out.print("��Ű��������� 1�� �ݿ��մϴ�. <br>");
				
			}////end : if
		}////////end : for
	}////////////end : if
	
	//�������� ���Ͽ�
	if(result==1){
		//response.sendRedirect("getCookieList.jsp");
		out.print("�����Ű( "+del_CookieName+")�� ��Ű������ �����߽��ϴ�.");
	} else {
		//response.sendRedirect("cookieUpdateFail.jsp");
		out.print("�����Ű( "+del_CookieName+")�� ��Ű������ �����߽��ϴ�. �̹� ������������.");
	}
	out.print("<br><br>===============================================<br>");
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

	String del_CookieName2 = "cookie2";
	out.print("<br>�����ϰ����ϴ� ��Ű�� �̸� : "+del_CookieName2+"<br><br>");

	//��Ű�� ������ ��
	if(cm.checkCookie(del_CookieName2)){
		
		//�ش� �̸��� ���� ��Ű �� �����ϱ�
		//���� �� res��ü��� �����ϸ� 1��ȯ / �����ϸ� 0��ȯ
		int result2 = cm.deleteCookie(del_CookieName2);
		
		out.print("��Ű��������� 1�� �ݿ��մϴ�. <br>");
	}

	//�������� ���Ͽ�
	if(result==1){
		//response.sendRedirect("getCookieList.jsp");
		out.print("�����Ű( "+del_CookieName2+")�� ��Ű������ �����߽��ϴ�.<br>");
	} else {
		//response.sendRedirect("cookieUpdateFail.jsp");
		out.print("�����Ű( "+del_CookieName2+")�� ��Ű������ �����߽��ϴ�. �̹� ������������.<br>");
	}	
	
%>

<br>
<br>
<br>
�Ʒ� ��ũ�� ���� �������� �̵��Ͻʽÿ�.<br>
<br>
<a href="Cookie01_set.jsp">��Ű�� �����ϴ� ������</a>

</body>
</html>