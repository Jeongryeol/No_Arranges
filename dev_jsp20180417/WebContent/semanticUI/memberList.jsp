<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<%@ include file="../include/commonUI.jsp" %>

</head>
<body>

<table id="dg_member" ></table>
<script type="text/javascript">
	$('#dg_member').datagrid({
		width:'500px',
		height:'250px',
	    url:'./member.kos?gubun=memberList',
	    columns:[[
	        {field:'RNO',title:'ȸ����ȣ',width:100},
	        {field:'MEM_ID',title:'���̵�',width:100},
	        {field:'MEM_NAME',title:'�̸�',width:100,align:'right'}
	    ]]
	});
</script>

</body>
</html>