<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
				//������Ʈ�� ��Ű������ ����
				Cookie replace_Cookie = new Cookie(cName //��Ű�� ������ ����ִ� �̸�
						,URLEncoder.encode("��ü����","UTF-8"));//�̸��� ���� ��
				response.addCookie(replace_Cookie);		 //����� ������ ��Ű�� ���
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