<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLEncoder"%>
<%
	//��û����� ���� ����ڼ��ð�(�Ķ����)�� ����
	String cname = request.getParameter("cname");
	//�� ���� PC�� ����� ��Ű������ ������ ��û�ϰ�, ��û����� ���� ��Ű�� �迭�� ����
	Cookie[] cs = request.getCookies();
 	
	int result = 0;//����ݿ����� Ȯ���� ����
	
	if(cs!=null&&cs.length>0){				//��Ű�迭��ü cs�� ������ ��
		for(int i=0;i<cs.length;i++){		//�ݺ�����
			String cName = cs[i].getName();	//��Ű�� ����ִ� �̸��� ����
			if(cName.equals(cname)){	//��Ű�� ����ִ� ���� ����� ���� ���� ������ ��
				Cookie delete_Cookie = new Cookie(cName,"");//��Ű�� ����ִ� �̸��� ��ĭ���� �ʱ�ȭ
				delete_Cookie.setMaxAge(0);			//�ִ�ð� 0 = ��Ű����
				response.addCookie(delete_Cookie);	//������ ������ ��Ű�� �ݿ��ϱ�
				result = 1;
			}////end : if
		}////////end : for
	}////////////end : if
	
	if(result==1){
		response.sendRedirect("getCookieList.jsp");
	} else {
		response.sendRedirect("cookieUpdateFail.jsp");
	}
%>