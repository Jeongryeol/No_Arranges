<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ȣ Ȯ���ϱ�</title>
<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	function dmgInit() {
		//alert("�Լ� ȣ�� ����")
		//keyup�̺�Ʈ�� ���� �Ǹ� �޽����� �����.
		$("#txtPw").keyup(function(){
			$("#d_msg").text("");
		});
		$("#txtPw2").keyup(function(){
			if($("#txtPw").val() != $("#txtPw2").val()){
				$("#d_msg").html("<font color='red'><b>��ȣ�� Ʋ���ϴ�.</b></font>");
			}else{
				$("#d_msg").html("<font color='green'><b>��ȣ�� ��ġ�մϴ�.</b></font>");
			}
		});
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		dmgInit();
	})
</script>
<h2> ��й�ȣ ��ġ���� Ȯ���ϱ�</h2>
<table style="border:1px solid skyblue">
	<tr>
		<td>��ȣ </td><td>: <input type="password" id="txtPw" id="mem_pw1"></td>
	</tr>
	<tr>
		<td>��ȣȮ�� </td><td>: <input type="password" id="txtPw2" id="mem_pw1"></td>
	</tr>
</table>
<div id="d_msg">��ȣ�� �Է��ϼ���.</div>
</body>
</html>
