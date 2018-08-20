<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- JSP파일의 영역에서는 이걸로 주석을 달아야함 --%>
    <!-- 이 주석은 HTML 구간에서 사용하는 주석  (eclipse가 이걸 자동완성함....)-->
<%@ page import = "java.util.*" %>
<%@ page import = "com.google.gson.Gson" %>

<%
	/*  랜덤하게 자료를 관리하는 HashMap은 List계열보다 자료처리속도가 월등히 빠르다.
		그러므로 대용량 자료를 관리하는 경우에는 HashMap으로 자료를 관리하는 것이 좋다.*/
	
	List<HashMap<String,Object>> boardList
		= new ArrayList<HashMap<String,Object>>();
	HashMap<String,Object> map
		= new HashMap<String,Object>();
	
	map.put("b_no",5);
	map.put("b_title","게시판 연습");
	map.put("b_writer","이순신");
	boardList.add(map);

	map = new HashMap<String,Object>();
	map.put("b_no",4);
	map.put("b_title","게시판 연습2");
	map.put("b_writer","이성계");
	boardList.add(map);
	
	map = new HashMap<String,Object>();
	map.put("b_no",3);
	map.put("b_title","게시판 연습3");
	map.put("b_writer","홍길동");
	boardList.add(map);
	
	Gson g = new Gson();
	String board=g.toJson(boardList);
	//웹 브라우저에 출력
	out.print(board);
%>

