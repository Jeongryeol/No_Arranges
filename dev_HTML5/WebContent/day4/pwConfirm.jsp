<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>암호 확인하기</title>
<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	function dmgInit() {
		//alert("함수 호출 성공")
		//keyup이벤트가 감지 되면 메시지를 지운다.
		$("#txtPw").keyup(function(){
			$("#d_msg").text("");
		});
		$("#txtPw2").keyup(function(){
			if($("#txtPw").val() != $("#txtPw2").val()){
				$("#d_msg").html("<font color='red'><b>암호가 틀립니다.</b></font>");
			}else{
				$("#d_msg").html("<font color='green'><b>암호가 일치합니다.</b></font>");
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
<h2> 비밀번호 일치여부 확인하기</h2>
<table style="border:1px solid skyblue">
	<tr>
		<td>암호 </td><td>: <input type="password" id="txtPw" id="mem_pw1"></td>
	</tr>
	<tr>
		<td>암호확인 </td><td>: <input type="password" id="txtPw2" id="mem_pw1"></td>
	</tr>
</table>
<div id="d_msg">암호를 입력하세요.</div>
</body>
</html>
