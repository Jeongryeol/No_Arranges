<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/include/commonUI.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
	function checkCaptcha(){
		var param = "captchakey="+$("#captchaKey").val();//�߱޵Ǽ� �Ѿ�� Ű��
				  +"&value="+$("#d_input").val();//����ڰ� �Է��� ���ڰ�
		$.ajax({
			 method:"POST"
			,url:"./captchaResult.jsp"
			,data:param
			,success:function(response){
				console.log(response);
				alert(response.toString());
				//������ ���ְ� ��ȯ�� ���ڿ��� ����
				//if(response.trim()=="200 ok"){
				if(response=="200 ok"){
					alert("���εǾ����ϴ�.")
					//location.href="./captchaIntro.jsp";
				}else{
					alert("���������ϴ�. �ٽ��ϼ���.")
					//ocation.href="pwConfirmFail.jsp";
				}
				
			}
			,error:function(xhrObject){
				alert(xhrObject);
			}
		});
	}
	//ĸí���� ���۽� 
	function newCaptcha() {
		var param = "command=getIMG";
		$.ajax({
			method : "POST",
			url : "./captcharImage.jsp", /* 1�ܰ�:Ű�߱�,2�ܰ�:ĸí�̹�������(ajax/naver)*/
			data : param,
			success : function(captchaIMG) {
				/* 	//�̹����� �Ѿ���� ��Ŀ� ���� �����׽�Ʈ
					alert("captchaIMG = "+captchaIMG);
					alert("captchaIMG.length = "+captchaIMG.length);
					alert("captchaIMG.substring(1,99) = "+captchaIMG.substring(1,99)); */
				$("#d_captcha").html(captchaIMG);
			},
			error : function(xhrObject) {
				alert(xhrObject);
			}
		});
	}
</script>

</head>
<body>
<!--
�����ϰ��� �Ѵٸ� HEAD��ũ��Ʈ��!
	������ �Լ��� �ƴ϶�� BODY��ũ��Ʈ��!
 -->
	<script type="text/javascript">
		//DOM
		$(document).ready(function(){
				newCaptcha();//ĸ������ ȣ��
		});
	</script>

	<!-- ĸí�̹��� + ���Ź�ư -->
	<div align="center">
		<div id="d_captcha">
			<h1>ĸí�̹���</h1>
		</div>

		<br>&nbsp;
	</div>
	<!-- �Է¶� + Ȯ�ι�ư -->
	<div align="center">
		<input id="d_input" class="easyui-textbox" style="width: 120px" />
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
			onclick="checkCaptcha()">Ȯ��</a>
	</div>
</body>
</html>