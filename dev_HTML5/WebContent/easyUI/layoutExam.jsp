<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
</head>
<script type="text/javascript">
	$(document).ready(function (){
		$('#cc').layout('add',{
			region: 'west',
		    width: '180px',
		    height: '200px',
		    title: 'layout연습',
		    split: true,
		    tools: [{
		        iconCls:'icon-add',
		        handler:function(){alert('add')}
		    },{
		        iconCls:'icon-remove',
		        handler:function(){alert('remove')}
		    }]
		});		
	});
</script>
<body id="cc" class="easyui-layout">
</body>
</html>