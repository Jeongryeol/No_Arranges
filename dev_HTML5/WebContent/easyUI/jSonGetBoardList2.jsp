<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<HashMap<String,Object>> boardList
		= new ArrayList<HashMap<String,Object>>();
    HashMap<String,Object> map = 
    		new HashMap<String,Object>();
    map.put("b_no",5);
    map.put("b_title","게시판 연습");
    map.put("b_writer","이순신");
    boardList.add(map);
    map = new HashMap<String,Object>();
    map.put("b_no",4);
    map.put("b_title","게시판 연습2");
    map.put("b_writer","김유신");
    boardList.add(map);
    map = new HashMap<String,Object>();
    map.put("b_no",3);
    map.put("b_title","게시판 연습3");
    map.put("b_writer","이성계");
    boardList.add(map);
    Gson g = new Gson();
    String jsonBoard = g.toJson(boardList);
    //웹브라우저에 출력
    out.print(jsonBoard);
%>









