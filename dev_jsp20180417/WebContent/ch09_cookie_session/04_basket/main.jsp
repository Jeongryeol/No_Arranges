<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ��� �����ϱ�</title>

	<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>
	<link rel="stylesheet" href="../../semantic/semantic.css">
	<script src="../../semantic/semantic.js"></script>
	<script src="../../js/commons.js"></script>

<script type="text/javascript">
	/* ����Ʈ div�ȿ��� inut�±׸� ã�� Ŭ�������� �̺�Ʈ ó�� */
	$('#list').find('input').click(function(){
		alert("īƮ��� ȣ��");
		if($(this).attr('id')=='amount_pen1'){//��Ʈ�� ����
        	//alert("c_intro ����")
        	$("#c_intro").show();
        }
        else if($(this).attr('id')=='amount_pen2'){//���۸� ���� ����
        	 //alert("c_gmap ����")
         	$("#c_gmap").show();
        }
        else if($(this).attr('id')=='amount_pen3'){//�¶��� ���� ����
        	 //alert("c_ontest ����")
        	$("#c_ontest").show();
        }
        else if($(this).attr('id')=='amount_pen4'){//�Խ��� ����
        	 //alert("c_board ����")
         	$("#c_board").show();
        }
		var param = "command=addCart";
		$.ajax({
			 method:"POST"
			,url:"cartAddAction.jsp"
			,data:param
			,success:function(result){
				
			}
			,error:function(xhrObject){
				alert(xhrObject);
			}
		});
	});
	function addCart(){
		
	}
	//��ٱ��� ����
	function ejectCart(){
		alert("īƮ���� ȣ��");
	}
</script>

</head>
<body>

<div class="ui four column grid">
  <!-- ��� �׷��� -->
  <div class="two column row">
    <div class="column"></div>
  </div>
  <!-- �ϴ� ���1 -->
  <div class="column" align="center" id="list">
  	<!-- �� �̹��� -->
  	<div class="ui statistic">
		<div class="ui move reveal">
  			<div class="visible content">
  				<img src="http://pendepot.co.kr/web/product/medium/201802/4348_shop1_869757.jpg" class="ui small image"></div>
  			<div class="hidden content">
  				<img src="http://image.babosarang.co.kr/product/detail/RWG/1802231716013065/_300.jpg" class="ui small image"></div>
		</div>
		Pen
		<div class="ui input focus">
			<input 	id="amount_pen1" type="text" value="input amount" style="width: 130px;text-align:center;"
					onclick="javascript:$('#amount_pen1').val('')"></div>
	</div><br>
	<!-- īƮ��� -->
  	<div class="ui animated fade button" tabindex="0" onclick="addCart()">
	  <div class="hidden content">���</div>
	  <div class="visible content"><i class="shop icon"></i></div>
	</div>
	<!-- �����ϱ� -->
  	<div class="ui animated fade button" tabindex="0" onclick="ejectCart()">
		<div class="hidden content">����</div>
		<div class="visible content"><i class="cut icon"></i></div>
	</div>
  </div>
  <!-- �ϴ� ���2 -->
  <div class="column" align="center">
  	<!-- �� �̹��� -->
  	<div class="ui statistic">
		<div class="ui move reveal">
  			<div class="visible content">
  				<img src="http://pendepot.co.kr/web/product/medium/201802/4348_shop1_869757.jpg" class="ui small image"></div>
  			<div class="hidden content">
  				<img src="http://image.babosarang.co.kr/product/detail/RWG/1802231716013065/_300.jpg" class="ui small image"></div>
		</div>
		Pen
		<div class="ui input focus">
			<input 	id="amount_pen2" type="text" value="input amount" style="width: 130px;text-align:center;"
					onclick="javascript:$('#amount_pen2').val('')"></div>
	</div><br>
	<!-- īƮ��� -->
  	<div class="ui animated fade button" tabindex="0" onclick="addCart()">
	  <div class="hidden content">���</div>
	  <div class="visible content"><i class="shop icon"></i></div>
	</div>
	<!-- �����ϱ� -->
  	<div class="ui animated fade button" tabindex="0" onclick="ejectCart()">
		<div class="hidden content">����</div>
		<div class="visible content"><i class="cut icon"></i></div>
	</div>
  </div>
  <!-- �ϴ� ���3 -->
  <div class="column" align="center">
  	<!-- �� �̹��� -->
  	<div class="ui statistic">
		<div class="ui move reveal">
  			<div class="visible content">
  				<img src="http://pendepot.co.kr/web/product/medium/201802/4348_shop1_869757.jpg" class="ui small image"></div>
  			<div class="hidden content">
  				<img src="http://image.babosarang.co.kr/product/detail/RWG/1802231716013065/_300.jpg" class="ui small image"></div>
		</div>
		Pen
		<div class="ui input focus">
			<input 	id="amount_pen3" type="text" value="input amount" style="width: 130px;text-align:center;"
					onclick="javascript:$('#amount_pen3').val('')"></div>
	</div><br>
	<!-- īƮ��� -->
  	<div class="ui animated fade button" tabindex="0" onclick="addCart()">
	  <div class="hidden content">���</div>
	  <div class="visible content"><i class="shop icon"></i></div>
	</div>
	<!-- �����ϱ� -->
  	<div class="ui animated fade button" tabindex="0" onclick="ejectCart()">
		<div class="hidden content">����</div>
		<div class="visible content"><i class="cut icon"></i></div>
	</div>
  </div>
</div>

</body>
</html>