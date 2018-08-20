<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%//JSP를 선택했다는 것은 화면을 구성할 목적이 아닌, 서버와 DB의 연동을 희망했기 때문임.

	//사용자(USER)가 입력한 ID를
	//TOMCAT서버를 거쳐서
	//JAVA의 API(드라이브클래스 ORACLE이 제공)로
	//ORACLE서버의 SELECT문에 보내야함.
	
	String mem_id = request.getParameter("mem_id");
	//SELECT 1 FROM dual WHERE mem_id = ?
	String mem_pw = request.getParameter("mem_pw");
		//로그인에 대한 셀렉트문?
		//SELECT mem_name FROM 멤버 WHERE mem_id=? AND mem_pw=?
		//리턴타입(1개)과 파라메터(2개)를 선택할 수 있고 SQL문으로 구성하여 넘길 수 있다.
	
	//브라우저에 출력하기 처리
	out.println(mem_id+", "+mem_pw);
%>