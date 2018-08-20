<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLEncoder"%>
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
				Cookie delete_Cookie = new Cookie(cName,"");//쿠키에 들어있던 이름에 빈칸으로 초기화
				delete_Cookie.setMaxAge(0);			//최대시간 0 = 쿠키삭제
				response.addCookie(delete_Cookie);	//삭제된 내용을 쿠키에 반영하기
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