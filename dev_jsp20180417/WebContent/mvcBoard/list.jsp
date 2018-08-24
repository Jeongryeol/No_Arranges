<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۸��</title>
<!-- ���� �ڵ� includeó�� -->
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	function bSearch(){
	//������ ��� �̹� DOM������ �Ϸ�Ǿ��� �� �׼��� �̹� ź ���°� �ǰ� �� ����� jsonBoardList.jsp�� ������ ���´�.
/* 		$("#f_search").attr("method","get");
		$("#f_search").attr("action","./mvcBoard.bd?gubun=getBoardList");
		$("#f_search").submit(); */
		$("#dg_list").datagrid({
		    url:'./mvcBoard.bd?gubun=getBoardList&cb_type='+$("#cb_type").val()+'&sb_keyword='+$("#sb_keyword").val()		
		});
	}
	function boardInsert(){
		$("#dl_boardInsert").dialog('open');
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#dg_list").datagrid({
		    url:'./mvcBoard.bd?gubun=getBoardList',
		    columns:[[
		        {field:'B_NO',title:'�۹�ȣ',width:100, align:'center'},
		        {field:'B_TITLE',title:'����',width:400, align:'center'},
		        {field:'B_NAME',title:'�̸�',width:100, align:'center'},
		        {field:'B_FILE',title:'÷������',width:150, align:'center'},
		        {field:'B_HIT',title:'��ȸ��',width:100, align:'center'},
		    ]]			
		});
		$('#pg_board').pagination({
		    total:2000,
		    pageSize:10
		});
	});
</script>
<table align="center" width="900px">
<!-- �˻� ���� ȭ�� �߰��ϱ� -->
<form id="f_search">
	<tr>
		<td>
		<select id="cb_type" class="easyui-combobox" name="cb_type" style="width:200px;">
		    <option value="b_title">����</option>
		    <option value="b_content">����</option>
		    <option value="b_name">�ۼ���</option>
		</select>
		<input id="sb_keyword" name="sb_keyword" class="easyui-searchbox" style="width:300px"
        data-options="searcher:bSearch,prompt:'Please Input Value'"></input>
		</td>
	</tr>
</form>	
<!-- �۾��� ��ư �߰� -->	
	<tr>
		<td align="left">
        <a id="btn_write" href="javascript:boardInsert()" class="easyui-linkbutton">�۾���</a>
		</td>
	</tr>	
<!-- ���ó�� ȭ�� �߰��ϱ�(datagrid) -->
	<tr>
		<td>
		<table id="dg_list"></table>
		</td>
	</tr>	
<!-- ������ ���̼� ó��(pagination) -->
	<tr>
		<td>
		<div id="pg_board" style="background:#efefef;border:1px solid #ccc;">
		</div>		
		</td>
	</tr>	
</table>
<!-- 
�۾��� ���̾� �α� ó��(writeForm.jspȭ�� ó��)
ó���� ���� ���·� �ִٰ� �۾��� ��ư�� Ŭ���ϸ� â�� ���.
 -->
<div id="dl_boardInsert" class="easyui-dialog" title="�۾���" style="width:600px;height:350px;"
     data-options="resizable:true,modal:true,closed:true">
    <table align="center">
	    <form id="b_insert">
	    	<tr>
	    	<td>����</td>
	    	<td><input id="b_title" name="b_title" data-options="width:'250px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>�ۼ���</td>
	    	<td><input id="b_name" name="b_name" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>����</td>
	    	<td><input id="b_content" name="b_content" data-options="multiline:'true', width:'350px', height:'90px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>��й�ȣ</td>
	    	<td><input id="b_pwd" name="b_pwd" class="easyui-passwordbox"></td>
	    	</tr>	    	
	    </table>
	    <table align="center">
	    	<tr>
	    	<td>
				<a href="javascript:boardAction()" class="easyui-linkbutton">����</a>
				<a href="javascript:$('#dl_boardInsert').dialog('close');" class="easyui-linkbutton">�ݱ�</a>
	    	</td>
	    	</tr>
	    </table>
    </form>
</div> 
</body>
</html>










