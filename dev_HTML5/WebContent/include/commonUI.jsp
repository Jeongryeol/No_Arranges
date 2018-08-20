<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	
	//프로젝트 root path를 불러서 절대경로로 전환하기 : root path는 server-module에서 확인가능
	String Project_Root = "/dev_HTML5";
%>
<link rel="stylesheet" type="text/css" href="<%=Project_Root %>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=Project_Root %>/themes/icon.css?1">
<link rel="stylesheet" type="text/css" href="<%=Project_Root %>/demo/demo.css">
<script type="text/javascript" src="<%=Project_Root %>/js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="<%=Project_Root %>/js/jquery.easyui.min.js"></script>