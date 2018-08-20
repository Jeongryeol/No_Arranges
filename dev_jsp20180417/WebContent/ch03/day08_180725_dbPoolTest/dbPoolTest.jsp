<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*"%>
<%
	//JDBC기본오브젝트 준비	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//테스트용 SQL문 작성
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT TO_CHAR(sysdate,'YYYY-MM-DD') curday FROM dual");
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/dbPool");
		con = ds.getConnection();
		out.print("<h3>연결 되었습니다.</h3>");
		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		while(rs.next()){
			String curday = rs.getString("curday");
			out.print("오늘의 날짜 : "+curday);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>