<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니 구현하기</title>

	<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>
	<link rel="stylesheet" href="../../semantic/semantic.css">
	<script src="../../semantic/semantic.js"></script>
	<script src="../../js/commons.js"></script>

<script type="text/javascript">
	/* 리스트 div안에서 inut태그를 찾고 클릭했을때 이벤트 처리 */
	$('#list').find('input').click(function(){
		alert("카트담기 호출");
		if($(this).attr('id')=='amount_pen1'){//인트로 선택
        	//alert("c_intro 선택")
        	$("#c_intro").show();
        }
        else if($(this).attr('id')=='amount_pen2'){//구글맵 서비스 선택
        	 //alert("c_gmap 선택")
         	$("#c_gmap").show();
        }
        else if($(this).attr('id')=='amount_pen3'){//온라인 시험 선택
        	 //alert("c_ontest 선택")
        	$("#c_ontest").show();
        }
        else if($(this).attr('id')=='amount_pen4'){//게시판 선택
        	 //alert("c_board 선택")
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
	//장바구니 빼기
	function ejectCart(){
		alert("카트빼기 호출");
	}
</script>

</head>
<body>

<div class="ui four column grid">
  <!-- 상단 그룹핑 -->
  <div class="two column row">
    <div class="column"></div>
  </div>
  <!-- 하단 목록1 -->
  <div class="column" align="center" id="list">
  	<!-- 펜 이미지 -->
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
	<!-- 카트담기 -->
  	<div class="ui animated fade button" tabindex="0" onclick="addCart()">
	  <div class="hidden content">담기</div>
	  <div class="visible content"><i class="shop icon"></i></div>
	</div>
	<!-- 제외하기 -->
  	<div class="ui animated fade button" tabindex="0" onclick="ejectCart()">
		<div class="hidden content">빼기</div>
		<div class="visible content"><i class="cut icon"></i></div>
	</div>
  </div>
  <!-- 하단 목록2 -->
  <div class="column" align="center">
  	<!-- 펜 이미지 -->
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
	<!-- 카트담기 -->
  	<div class="ui animated fade button" tabindex="0" onclick="addCart()">
	  <div class="hidden content">담기</div>
	  <div class="visible content"><i class="shop icon"></i></div>
	</div>
	<!-- 제외하기 -->
  	<div class="ui animated fade button" tabindex="0" onclick="ejectCart()">
		<div class="hidden content">빼기</div>
		<div class="visible content"><i class="cut icon"></i></div>
	</div>
  </div>
  <!-- 하단 목록3 -->
  <div class="column" align="center">
  	<!-- 펜 이미지 -->
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
	<!-- 카트담기 -->
  	<div class="ui animated fade button" tabindex="0" onclick="addCart()">
	  <div class="hidden content">담기</div>
	  <div class="visible content"><i class="shop icon"></i></div>
	</div>
	<!-- 제외하기 -->
  	<div class="ui animated fade button" tabindex="0" onclick="ejectCart()">
		<div class="hidden content">빼기</div>
		<div class="visible content"><i class="cut icon"></i></div>
	</div>
  </div>
</div>

</body>
</html>