<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Ajax�� Ȱ���� ������ �ڵ������ϱ� : ���������ϱ�</title>

<!-- ������[[ import ]]�������������������������������������������������������������������������������������������������������������������������������������������������������������������� -->
	<!-- jQuery script import code :: $-undifined error ����!!! -->
	<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>

<!-- ������[[ HEAD script ]]���������������������������������������������������������������������������������������������������������������������������������������������������� -->
<script type="text/javascript">
	var watch;
	var i=0;
	function autoReload(){
		//alert("autoReload ȣ�⼺��");
		//INSERT HERE : �ڵ����Ž� ó���� ������ ó���ϱ� (ajax code add)
		//$("#d_news").text("��������..."+i);
		//i=i+1;
		
		//INSERT HERE : �ڵ����ŵǴ� 5���� ���� jsp �Է�
		$.ajax({
			 url : "./getNewsTitle.jsp"
			,method:"GET"
			,success : function(clip){
				//alert("success");//�����׽�Ʈ��
				$("#d_news").html(clip);
			}
			,error : function(xhrObject){
				alert(xhrObject.responseText());
			}
		})
	}
	function start(){
		watch=setInterval(autoReload,1000);//1000ms��  1��
	}
	function stop(){
		setTimeout(function(){
			clearInterval(watch);
		},100000);
	}
</script>

</head>
<!--
��������������������������������������������������������������������������������������������������������������
-->
<body>
<!-- ������[[ BODY script ]]���������������������������������������������������������������������������������������������������������������������������������������������������� -->
<script type="text/javascript">
	start();
	stop();
</script>

<!-- ������[[ BODY content ]]���������������������������������������������������������������������������������������������������������������������������������������������������� -->
<h3>�ڵ� ���� ������ �����ϱ� : ��������</h3>
<input type="button" value="����" onClick="start()">
<input type="button" value="��" onClick="stop()">
<div id="d_news"></div>
</body>
</html>