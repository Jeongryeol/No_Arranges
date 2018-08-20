<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.List, java.util.ArrayList"%>
<%@ page import = "java.util.Map, java.util.HashMap" %>
<%@ page import = "com.google.gson.Gson" %>
<%@ page import = "DataSet.UserVO" %>
<%@ page import = "java.util.Arrays" %>
<%@ page trimDirectiveWhitespaces = "true" %><%-- xml/json포맷 공백제거 --%>
<%
	//List 준비
	List<Map<String,Object>> userList = new ArrayList<>();
	//Map 준비
	Map<String,Object> rMap	= new HashMap<>();
	
	//Map에 키와 값 담고, List에 담기(반복)
	rMap.put("id","First_Account");
	rMap.put("pw","123");
	rMap.put("name","첫번째 사용자 이름");
	userList.add(rMap);
	
	rMap = new HashMap<String,Object>();
	rMap.put("id","Second_Account");
	rMap.put("pw","456");
	rMap.put("name","두번째 사용자 이름");
	userList.add(rMap);
	
	rMap = new HashMap<String,Object>();
	rMap.put("id","Third_Account");
	rMap.put("pw","789");
	rMap.put("name","세번째 사용자 이름");
	userList.add(rMap);
	
	//Gson준비
	Gson gs = new Gson();
	//Gson객체의 메소드를 이용해서 List를 json문자열로 변환하기
	String jsonUser = gs.toJson(userList);

/*
	==========[[ JAVA에서 사용가능하도록 JSON포맷 변환하기]]==========
*/
	//json문자열로부터 VO패턴객체배열 생성하기
	UserVO[] users = gs.fromJson(jsonUser,UserVO[].class);
	//객체배열을 List로 변환하기
	List<UserVO> newList = new ArrayList<>(Arrays.asList(users));
	//개선된 for문으로 결과를 확인합니다.
	for(UserVO uvo : newList){
		out.print(uvo.getId()+", ");
		out.print(uvo.getPw()+", ");
		out.print(uvo.getName()+"<br>");
	}
%>