<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="../include/commonUI.jsp" %>
</head>
<body>
<div id="p_member" class="easyui-panel" title="ȸ�����" 
        style="width:600px;height:350px;padding:10px;background:#fafafa;"
        data-options="closable:true,collapsible:true,minimizable:true,maximizable:true">
	<table id="dg_member"></table>
</div>
<script type="text/javascript">
	$('#p_member').panel({
		onClose:function(){
			self.close();
		}
	}); 
	$('#dg_member').datagrid({
		width:'500px',
		height:'250px',
	    url:'./member.kos?gubun=memberList',
	    columns:[[
	        {field:'RNO',title:'��ȣ',width:100, align:'center'},
	        {field:'MEM_ID',title:'���̵�',width:100, align:'center'},
	        {field:'MEM_NAME',title:'�̸�',width:120, align:'center'}
	    ]],
/* 		data: [
			{NO:'1', MEM_ID:'haha1', MEM_NAME:'�̼���1'},
			{NO:'2', MEM_ID:'haha2', MEM_NAME:'�̼���2'},
			{NO:'3', MEM_ID:'haha3', MEM_NAME:'�̼���3'}
		] */
	});
</script>
</body>
</html>