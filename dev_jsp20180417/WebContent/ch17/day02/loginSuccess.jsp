<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//�ڹٿ���
	String result = request.getParameter("result");
	if("1".equals(result)){
	//�������� ó���Ѵٸ� out.print()�ȿ� �±׸� ��� ��ƾ� ��. �������� �ſ� ������
	//jsp���� �ڹ��ڵ尡 �������� ���ڴ�.
	//������ ������ ����Ŭ�� ��Ĺ�� �����ϰ�
	//��(������)�� �ʿ��Ҷ� �� ������ �Ҹ�Ǿ� ������ �������� �� �� ����
%>
	<!-- HTML���� -->
	ȸ�����Կ� �����Ͽ����ϴ�.
<%
	//�ڹٿ���
	}
	else {
%>
	<!-- HTML���� -->
	ȸ�����Կ� �����Ͽ����ϴ�.
<%
	//�ڹٿ���
	}
%>