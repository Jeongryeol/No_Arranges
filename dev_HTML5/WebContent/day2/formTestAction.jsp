<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%//JSP�� �����ߴٴ� ���� ȭ���� ������ ������ �ƴ�, ������ DB�� ������ ����߱� ������.

	//�����(USER)�� �Է��� ID��
	//TOMCAT������ ���ļ�
	//JAVA�� API(����̺�Ŭ���� ORACLE�� ����)��
	//ORACLE������ SELECT���� ��������.
	
	String mem_id = request.getParameter("mem_id");
	//SELECT 1 FROM dual WHERE mem_id = ?
	String mem_pw = request.getParameter("mem_pw");
		//�α��ο� ���� ����Ʈ��?
		//SELECT mem_name FROM ��� WHERE mem_id=? AND mem_pw=?
		//����Ÿ��(1��)�� �Ķ����(2��)�� ������ �� �ְ� SQL������ �����Ͽ� �ѱ� �� �ִ�.
	
	//�������� ����ϱ� ó��
	out.println(mem_id+", "+mem_pw);
%>