<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%/* 스크립틀릿영역 만들어서 자바코드 불러오기 */

	List<HashMap<String,Object>> chatLists
		= new ArrayList<HashMap<String,Object>>();
	HashMap<String,Object> chatMaps
		= new HashMap<String,Object>();
	
	chatMaps.put("nickName","깐족이");
	chatMaps.put("roomName","칼퇴반");
	chatMaps.put("status","퇴근한다");
	chatLists.add(chatMaps);
	
	chatMaps = new HashMap<String,Object>();
	chatMaps.put("nickName","기름종이");
	chatMaps.put("roomName","칼퇴반");
	chatMaps.put("status","저녁먹을사람...");
	chatLists.add(chatMaps);
	
	chatMaps = new HashMap<String,Object>();
	chatMaps.put("nickName","지우개전사");
	chatMaps.put("roomName","칼퇴반");
	chatMaps.put("status","나..먹음..");
	chatLists.add(chatMaps);
	
	chatMaps = new HashMap<String,Object>();
	chatMaps.put("nickName","칼날부리");
	chatMaps.put("roomName","경영팀");
	chatMaps.put("status","자리비움....");
	chatLists.add(chatMaps);
	
	Gson g = new Gson();
	String jsonChatList = g.toJson(chatLists);
	
	out.print(jsonChatList);
	

%>