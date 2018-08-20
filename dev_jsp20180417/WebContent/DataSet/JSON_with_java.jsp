<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataSet.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Web에서 사용한 gson파일을 자바에서 사용하기</title>
</head>
<body>
<H1> Web에서 사용한 gson파일을 자바에서 사용하기 </H1>

<%
	//List타입으로 자료를 준비합니다.
	List<UserVO> users = new ArrayList<UserVO>();

	//VO클래스 를 호출해서 각 컬럼에 로우를 담음
	UserVO uvo = new UserVO();
	uvo.setId("id1");
	uvo.setPw("pw1");
	uvo.setName("name1");
	users.add(uvo);//리스트에 해당 로우를 담음
	
	uvo = new UserVO();
	uvo.setId("id2");
	uvo.setPw("pw2");
	uvo.setName("name2");
	users.add(uvo);//리스트에 해당 로우를 담음
	
	uvo = new UserVO();
	uvo.setId("id3");
	uvo.setPw("pw3");
	uvo.setName("name3");
	users.add(uvo);//리스트에 해당 로우를 담음
	

	//Gson파일을 준비합니다.
	Gson gson = new Gson();
	
	//생성한 List자료를 Gson을 이용해서 Json으로 변환합니다.(문자열상태)
	String userJSON = gson.toJson(users);
	out.print("userJSON = "+userJSON+"<br><br>");//출력
	
	//변환한 Json으로부터 VO패턴 객체배열로 변환합니다.
	UserVO[] JSONusers = gson.fromJson(userJSON, UserVO[].class);
	out.print("JSONusers[0] = "+JSONusers[0]+"<br>");
	out.print("JSONusers[1] = "+JSONusers[1]+"<br>");
	out.print("JSONusers[2] = "+JSONusers[2]+"<br>");
	out.print("JSONusers[0].getId() = "+JSONusers[0].getId()+"<br>");
	out.print("JSONusers[0].getPw() = "+JSONusers[0].getPw()+"<br>");
	out.print("JSONusers[0].getName() = "+JSONusers[0].getName()+"<br><br>");
	
	//변환한 객체배열을 List로 변환시킵니다.
	users = new ArrayList<>(Arrays.asList(JSONusers));
	out.print("users.get(0) = "+users.get(0)+"<br>");
	out.print("users.get(0).getId() = "+users.get(0).getId()+"<br>");
	out.print("users.get(0).getPw() = "+users.get(0).getPw()+"<br>");
	out.print("users.get(0).getName() = "+users.get(0).getName()+"<br><br>");
	
	//개선된 for문으로 출력합니다.
	for(UserVO uVO : users){
		out.print(uVO.getId()+", ");
		out.print(uVO.getPw()+ ", ");
		out.print(uVO.getName()+"<br>");
	}
	
%>

</body>
</html>