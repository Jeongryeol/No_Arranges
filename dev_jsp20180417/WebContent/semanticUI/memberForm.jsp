<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	var g_id=0;
	function memberInsert(){
		if(g_id==0){
			alert("아이디 중복 체크 하세요.");
			return;
		}else if(g_id==1){
			if($("#mem_id").val()==null || $("#mem_id").val().length==0){
				alert("아이디를 입력하세요.");
				$("#mem_id").focus();
				return;
			}
			else if($("#mem_pw").val()==null || $("#mem_pw").val().length==0){
				alert("비번을 입력하세요.");
				return;
			}
			else if($("#mem_name").val()==null || $("#mem_name").val().length==0){
				alert("이름을 입력하세요.");
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
<div id="p_member" class="easyui-panel" title="회원가입" 
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
		<td width="100px">아이디</td>
		<td width="250px">
		<input id="mem_id" name="mem_id" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px">
		<a href="javascript:idCheck();" class="easyui-linkbutton">중복체크</a> 
		</td>
	</tr>
	<tr>
		<td width="100px">비밀번호</td>
		<td width="250px"><input id="mem_pw" name="mem_pw" class="easyui-passwordbox" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">이름</td>
		<td width="250px"><input id="mem_name" name="mem_name" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px"></td>
	</tr>
</table>          
<center>
<a href="javascript:memberInsert();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">가입</a>  
</center>
</form>    
</div>
</body>
</html>