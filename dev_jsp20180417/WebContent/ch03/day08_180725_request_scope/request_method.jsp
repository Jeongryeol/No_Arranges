<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map, java.util.HashMap"%>
<%
/*
	입력하는 화면에서 사용자로부터 입력받아야하는 값이 100가지가 넘는다고 가정해보자.
	이 값들을 다 서버로 넘기려면 아주 불편하게 된다.
	이 값들을 하나의 주소번지에 처리하여 재사용성을 높이는 방법은 없을까? [ hint:Map ]
*/
	/* String mem_id = request.getParameter("mem_id");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String zipcode = request.getParameter("zipcode");
	String address = request.getParameter("address"); */

	//재사용성을 높이기 위해 반복되는 코드를 줄이는 방법이 있을 것.
	//Spring Framework에 MVC패턴을 포함한 재사용성 증대기능이 포함되어있긴 함.
	
	//방법?
	Enumeration<String> enNames = request.getParameterNames();
	Map<String,Object> nameMap = new HashMap<String,Object>();
	for(int i=0;enNames.hasMoreElements();i++){
		nameMap.put("name"+i, enNames.nextElement());
	}
	for(int i=0;i<nameMap.size();i++){
		out.print("idMap["+i+"] = "+nameMap.get("name"+i)+"<br>");
	}
	
%>
<%
	//Enumeration : Iterator의 조상인터페이스
	//.getParameterNames("") : 파라미터의 이름(name속성)을 얻어냄 
	Enumeration<String> en = request.getParameterNames();
	while(en.hasMoreElements()){//출력테스트
		String key = en.nextElement();
		out.print("key : "+key+"<br>");
	}
	
	//.getParameterValues("") : 파라미터의 값(value속성)을 얻어냄
	String pets[] = request.getParameterValues("pet");
	for(int i=0;i<pets.length;i++){//출력테스트
		out.print("pets["+i+"] : "+pets[i]+"<br>");
	}
	
	//.getContentType() : String ::사용자가 요청객체정보를 전송할때 사용한 컨텐츠 타입을 얻음
	Cookie cookie[] = request.getCookies();
	
%>
	<br>
	<br>클라이언트 ip = <%= request.getRemoteAddr()%>
	<br>요청정보길이 = <%= request.getContentLength()%>
	<br>요청정보 인코딩 = <%= request.getCharacterEncoding()%>
	<br>요청정보 컨텐츠타입 = <%= request.getContentType()%>
	<br>요청정보 프로토콜 = <%= request.getProtocol()%>
	<br>요청정보 전송방식 = <%= request.getMethod()%>
	<br>요청 URL = <%= request.getRequestURL()%>
	<br>컨텍스트 경로 = <%= request.getContextPath()%>
	<br>서버이름 = <%= request.getServerName()%>
	<br>서버포트 = <%= request.getServerPort()%>