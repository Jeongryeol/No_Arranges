<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
    <!-- 공통코드영역 : 추후 include로 편하게 하는 방법을 배울 것 -->
    <script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
</head>
<body>
<script type="text/javascript">
	/* 이 jsp문서 전체를 가리키는 내장객체 document */
	$("document").ready(function() {
/* 		$("#dg_member").datagrid({//객체-속성과 함수를 거느릴 수 있다. 실행문으로 소화시키자
			width:502,
			height:250,
			url:"../json/memberJSON.json",
		    columns:[[
		        {field:'mem_id',title:'ID',width:100,align:'center'},
		        {field:'mem_name',title:'견종명',width:100,align:'center'},
		        {field:'mem_gender',title:'성별',width:100,align:'center'},
		        {field:'mem_hp',title:'보호자연락처',width:200,align:'center'}
		    ]],
		    onDblClickRow:function(index,row){
		    	alert("index : "+index+", row : "+row.mem_name
		    			+", hp : "+row.mem_hp);
		    }
 		    //checkOnSelect:true,
		    //onLoadSuccess:function(){alert("성공")},
		    //onLoadError:function(){alert("실패")}
		}); */
	});
</script>
	<table id="dg_member" class="easyui-datagrid" width="500px"
	data-options="url:'../json/memberJSON.json',fitColumns:true,singleSelect:true">
		<thead>
		<!-- 태그로 표 작업을 하는것이 기본이긴 하지만, 이벤트처리가 어려우므로, 스크립트기반인  ver1을 권장함 -->
			<th data-options="field:'mem_id',width:120">아이디</th>
			<th data-options="field:'mem_name',width:150">이름</th>
			<th data-options="field:'code',width:80">성별</th>
		</thead>
	
	<tbody>
<% /* JSON이 아닐때, 자바코드를 이용해서 원하는 조건에 맞는 값을 for문에 사용할 수 있다. */
	for(int i=0;i<3;i++){
%>
		<tr>
			<td><%out.print("test");%></td>
			<td><%out.print("토시노리");%></td>
			<td><%out.print("남");%></td>
		</tr>
<%
	}
%>
	</tbody>
	</table>
</body>
</html>