<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	function memberInsert(){
		$("#f_member").attr("method", "post");
		$("#f_member").attr("action", "./member.kos?gubun=memINS");
		$("#f_member").submit();
	}
</script>
</head>
<body>
<div id="p_member" class="easyui-panel" title="회원가입" 
        style="width:650px;height:390px;padding:10px;background:#fafafa;"
        data-options="closable:true,
                collapsible:true,minimizable:true,maximizable:true">
<form id="f_member">      
<table align="center">
	<tr>
		<td width="100px">아이디</td>
		<td width="250px"><input name="mem_id" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">비밀번호</td>
		<td width="250px"><input name="mem_pw" class="easyui-passwordbox" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">이름</td>
		<td width="250px"><input name="mem_name" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px"></td>
	</tr>
</table>          
<center>
<a href="javascript:memberInsert();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">가입</a>  
</center>
</form>    
</div>
<script type="text/javascript">
	$('#p_member').panel({
		onClose:function(){
			//alert("되니?");
			self.close();
		}
	});
</script>
</body>
</html>