<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	var g_id=0;
	function memberInsert(){
		if(g_id==0){
			alert("���̵� �ߺ� üũ �ϼ���.");
			return;
		}else if(g_id==1){
			if($("#mem_id").val()==null || $("#mem_id").val().length==0){
				alert("���̵� �Է��ϼ���.");
				$("#mem_id").focus();
				return;
			}
			else if($("#mem_pw").val()==null || $("#mem_pw").val().length==0){
				alert("����� �Է��ϼ���.");
				return;
			}
			else if($("#mem_name").val()==null || $("#mem_name").val().length==0){
				alert("�̸��� �Է��ϼ���.");
				return;
			}
			else{
				$("#f_member").attr("method", "post");
				$("#f_member").attr("action", "./member.kos?gubun=memINS");
				$("#f_member").submit();
			}
		}
	}
	function idCheck(){
		g_id = 1;
	}
</script>
</head>
<body>
<div id="p_member" class="easyui-panel" title="ȸ������" 
        style="width:650px;height:390px;padding:10px;background:#fafafa;"
        data-options="closable:true,
                collapsible:true,minimizable:true,maximizable:true">
<script type="text/javascript">
	$('#p_member').panel({
	    onClose:function(){
	        //alert('close....');
	        self.close();
	    }
	}); 
</script>                
<form id="f_member">      
<table align="center">
	<tr>
		<td width="100px">���̵�</td>
		<td width="250px">
		<input id="mem_id" name="mem_id" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px">
		<a href="javascript:idCheck();" class="easyui-linkbutton">�ߺ�üũ</a> 
		</td>
	</tr>
	<tr>
		<td width="100px">��й�ȣ</td>
		<td width="250px"><input id="mem_pw" name="mem_pw" class="easyui-passwordbox" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">�̸�</td>
		<td width="250px"><input id="mem_name" name="mem_name" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px"></td>
	</tr>
</table>          
<center>
<a href="javascript:memberInsert();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">����</a>  
</center>
</form>    
</div>
</body>
</html>