<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String uname1 = request.getParameter("uname");
    String cm1 = request.getParameter("cm1");//자판기 구분자
    for(double i=0;i<9000000000.0;i++){
    	//커피 만드는 시늉을 한다.
    }
    //기존에 입력된 값이 계속 버퍼에 남아 있게 되면 마지막 자판기 정보만 비워지므로..
    out.clear();
	out.print(cm1+uname1);
%>