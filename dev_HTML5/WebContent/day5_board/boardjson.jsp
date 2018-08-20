<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch11.BoardDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	/* json파일에 DB의 자료를 가져와보자!! import를 절대 잊지 말걸!!*/
	/* TomCat이 jdbc의 jar파일을 찾지못해서 드라이버를 열지 못한다면,
		WEB-INF.lib에 jar파일을 복사해두거나 
		TomCat설치된 경로의 jar파일이 모인곳에 jar드라이버를 복사해준다.*/
	BoardDao bDao = new BoardDao();
	List<Map<String,Object>> boardList = bDao.getBoardList(null);
	Gson gs = new Gson();
	String jsonBoardList = gs.toJson(boardList);
	out.print(jsonBoardList);
%>