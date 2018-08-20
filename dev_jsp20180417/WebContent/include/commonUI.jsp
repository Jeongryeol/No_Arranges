<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	
	//프로젝트 root path를 불러서 절대경로로 전환하기 : root path는 server-module에서 확인가능
	String Project_Root = "/dev_jsp20180417";
%>
<!-- JQeury -->
	<script src="<%=Project_Root %>/js/jquery-1.12.0.js"></script>
<!-- EasyUI -->
	<script src="<%=Project_Root %>/js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=Project_Root %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=Project_Root %>/themes/icon.css?1">
	<link rel="stylesheet" type="text/css" href="<%=Project_Root %>/demo/demo.css">
<!-- bootstrap -->
<%-- 	<link rel="stylesheet" href="<%=Project_Root %>/bootstrap-3.3.2/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=Project_Root %>/bootstrap-3.3.2/dist/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="<%=Project_Root %>/css/Normalize.css">
	<script src="<%=Project_Root %>/bootstrap-3.3.2/dist/js/bootstrap.min.js"></script> --%>