<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch11.BoardDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	/* json���Ͽ� DB�� �ڷḦ �����ͺ���!! import�� ���� ���� ����!!*/
	/* TomCat�� jdbc�� jar������ ã�����ؼ� ����̹��� ���� ���Ѵٸ�,
		WEB-INF.lib�� jar������ �����صΰų� 
		TomCat��ġ�� ����� jar������ ���ΰ��� jar����̹��� �������ش�.*/
	BoardDao bDao = new BoardDao();
	List<Map<String,Object>> boardList = bDao.getBoardList(null);
	Gson gs = new Gson();
	String jsonBoardList = gs.toJson(boardList);
	out.print(jsonBoardList);
%>