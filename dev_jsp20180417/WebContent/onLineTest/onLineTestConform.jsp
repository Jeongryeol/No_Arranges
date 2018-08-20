<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String db_testno = "A0001";
	String db_testname= "이순신";
	//사용자가 입력한 수험번호 가져오기
	String u_testno = request.getParameter("test_no");
	//사용자가 입력한 이름 가져오기
	//<input type="text" name="test_name" size="15">
	String u_testname = request.getParameter("test_name");
	out.println("수험번호:"+u_testno+", 이름:"+u_testname);
	if(db_testno.equals(u_testno)){
		if(db_testname.equals(u_testname)){
			response.sendRedirect("./onLineTestOk.html");//인증성공메시지 출력
		}
	}
%>