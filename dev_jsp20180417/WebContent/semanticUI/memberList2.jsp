<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	function getRowIndex(target){
		var tr = $(target).closest('tr.datagrid-row');
		return parseInt(tr.attr('datagrid-row-index'));
	}
	function editrow(target){
		$('#tt').datagrid('beginEdit', getRowIndex(target));
	}
</script>
</head>
<body>
<div id="p_member" class="easyui-panel" title="회원목록" 
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
	        {field:'RNO',title:'번호',width:100, align:'center'},
	        {field:'MEM_ID',title:'아이디',width:100, align:'center'},
	        {field:'MEM_NAME',title:'이름',width:120, align:'center'},
			{field:'action',title:'',width:80,align:'center',
				formatter:function(value,row,index){
					var e = '<a href="javascript:void(0)" onclick="editrow(this)">쪽지쓰기</a> ';
					return e;
				}
			}
	    ]],
		onEndEdit:function(index,row){
			var ed = $(this).datagrid('getEditor', {
				index: index,
				field: 'productid'
			});
			row.productname = $(ed.target).combobox('getText');
		},
		onBeforeEdit:function(index,row){
			row.editing = true;
			$(this).datagrid('refreshRow', index);
		},
		onAfterEdit:function(index,row){
			row.editing = false;
			$(this).datagrid('refreshRow', index);
		},
		onCancelEdit:function(index,row){
			row.editing = false;
			$(this).datagrid('refreshRow', index);
		}
	    
/* 		data: [
			{NO:'1', MEM_ID:'haha1', MEM_NAME:'이순신1'},
			{NO:'2', MEM_ID:'haha2', MEM_NAME:'이순신2'},
			{NO:'3', MEM_ID:'haha3', MEM_NAME:'이순신3'}
		] */
	});
</script>
</body>
</html>