<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!--
	JSP�� ����
	1) ȭ��ó�� : ȸ������ȭ���̳� �α���ȭ�鰰��..
	2) json���� ���� ���� : xxx.json
		json�� ���, ������ Gson�� Ȱ���ϹǷ� �ش����
	3) xml���� ���� ���� : xxx.xml
	 	xml�� ���, �����ڰ� ���������� ���� ������ �����ϹǷ�
	 	���������̷�Ƽ���ڸ��� �������� ���� ���� �ذ��� �ʿ���
 -->
<%
	//MIME TYPE ����� response��ü Ȱ���մϴ�.
	//response.setContentType("text/xml;charset=euc-kr");
	out.print("<table border='1' width='300'>");
	out.print("<tr><td>404ȣ</td></tr>");
	out.print("<tr><td>�������б� 6���ǵ�</td></tr>");
	out.print("</table>");
%>