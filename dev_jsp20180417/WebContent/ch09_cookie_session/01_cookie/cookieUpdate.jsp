<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//요청헤더에 쓰인 사용자선택값(파라메터)를 받음
	String cname = request.getParameter("cname");
	//각 개인 PC에 저장된 쿠키정보를 서버에 요청하고, 요청헤더에 쓰인 쿠키를 배열로 받음
	Cookie[] cs = request.getCookies();
	
	int result = 0;//변경반영여부 확인할 변수
	
	if(cs!=null&&cs.length>0){				//쿠키배열객체 cs가 존재할 때
		for(int i=0;i<cs.length;i++){		//반복수행
			String cName = cs[i].getName();	//쿠키에 들어있는 이름을 얻음
			if(cName.equals(cname)){	//쿠키에 들어있는 값과 사용자 선택 값이 같은지 비교
				//업데이트할 쿠키정보를 담음
				Cookie replace_Cookie = new Cookie(cName //쿠키에 기존에 들어있던 이름
						,URLEncoder.encode("교체정보","UTF-8"));//이름에 대한 값
				response.addCookie(replace_Cookie);		 //변경된 내용을 쿠키에 담기
				result = 1;
			}////end : if
		}////////end : for
	}////////////end : if
	
	if(result==1){
		response.sendRedirect("getCookieList.jsp");
	} else {
		response.sendRedirect("cookieUpdateFail.jsp");
	}
%>