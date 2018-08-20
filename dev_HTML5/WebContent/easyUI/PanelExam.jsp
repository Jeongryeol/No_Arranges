<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>easyUI-Panel</title>
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
</head>
<body>
<script type="text/javascript">
/* 
자바스크립트 내장객체 document는 PanelExam.jsp문서 전체를 받는 객체임.
내장객체란 인스턴스화 없이 사용할 수 있는 객체임.
이 문서의 최상위 객체가 document이고 그 아래 <html>태그가 있음.
<html>아래 <head>와 <body>가 있음.
이런 태그들을 모두 스캔하여 DOM 트리구조를 그리게 됨
(누가?-웹브라우저가,언제?-요청이 일어났을 때, 왜?-화면에 출력을 내보내야 되니깐)
*/
	$(document).ready(function(){//DOM구성이 끝났을 때-html태그에 대한 트리
		$("#p_test").panel({
			title:"계층형게시판",
			//href:"./layoutExam.jsp",
			width:500,
			height:350
		});
		$("#dg_test").datagrid({
			title:"글목록",
			url:"./jSonGetBoardList2.jsp"
		});
	});
</script>
<div id="p_test" class="easyui-panel" title="panel">
	<table id="dg_test" class="easyui-datagrid">
	    <thead>
	        <tr>
	            <th data-options="field:'b_no',width:100">글번호</th>
	            <th data-options="field:'b_title',width:300">글제목</th>
	            <th data-options="field:'b_writer',width:100">작성자</th>
	        </tr>
	    </thead>
	</table>
</div>
</body>
</html>