<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%/* ��ũ��Ʋ������ ���� �ڹ��ڵ� �ҷ����� */

	List<HashMap<String,Object>> chatLists
		= new ArrayList<HashMap<String,Object>>();
	HashMap<String,Object> chatMaps
		= new HashMap<String,Object>();
	
	chatMaps.put("nickName","������");
	chatMaps.put("roomName","Į���");
	chatMaps.put("status","����Ѵ�");
	chatLists.add(chatMaps);
	
	chatMaps = new HashMap<String,Object>();
	chatMaps.put("nickName","�⸧����");
	chatMaps.put("roomName","Į���");
	chatMaps.put("status","����������...");
	chatLists.add(chatMaps);
	
	chatMaps = new HashMap<String,Object>();
	chatMaps.put("nickName","���찳����");
	chatMaps.put("roomName","Į���");
	chatMaps.put("status","��..����..");
	chatLists.add(chatMaps);
	
	chatMaps = new HashMap<String,Object>();
	chatMaps.put("nickName","Į���θ�");
	chatMaps.put("roomName","�濵��");
	chatMaps.put("status","�ڸ����....");
	chatLists.add(chatMaps);
	
	Gson g = new Gson();
	String jsonChatList = g.toJson(chatLists);
	
	out.print(jsonChatList);
	

%>