<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Map, java.util.HashMap, java.net.URLEncoder" %>
<%
	//DB����ó�� - SKIP
	//����ڰ� �Է��� ��� ���� 
	String newsTitle = request.getParameter("n_title");
	//����ڰ� �Է��� ��� ����
	String newsContent = request.getParameter("n_content");
	//get��Ŀ����� �ѱ�ó���� server.xml�� �ص� �����̹Ƿ� ���ڰ� ������ ����
	
	//����-��, ���-�� ���� "HashMap"�� ����
	Map<String,Object> rMap = new HashMap<String,Object>();
	rMap.put("n_title",newsTitle);
	rMap.put("n_content",newsContent);
	
	//�������� ���� : ����ȭ������ ���ƿ;߰���??
	//response.sendRedirect("./news_index_ajax.jsp");

	//news_InsAction.jsp���� �޾ƿ� ������ news_index_ajax.jsp���� ����� �� ������?
	//���� �����ϴٸ� �����??
	//fowardó��  �Ǵ� ��Ű/����ó��
	//�׷��� �̹����� �̷��� ó���غ���
	newsTitle = URLEncoder.encode(newsTitle,"euc-kr");
	newsContent = URLEncoder.encode(newsContent,"euc-kr");
	response.sendRedirect("./news_index_ajax.jsp?n_title="+newsTitle+"&n_content="+newsContent);
	//�޴��� news_index_ajax.jsp���� ���������ϰ� �޾ƺ���. 
%>