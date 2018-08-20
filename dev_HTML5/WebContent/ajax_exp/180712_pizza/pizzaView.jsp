<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jQuery없이 Ajax를 사용하여 피자주문화면 구현하기</title>

<!-- ────────────────────── Ajax jQuery방식 구현 시작 ────────────────────── -->
<script type="text/javascript" src="http://localhost:9000/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	//전역변수로 선언
	var request = null;
	var m_name = '';
	var m_addr = '';
	var myhp = '';
	
	
	function getCustomerInfo(){ // text입력칸"phone"에 변화(onchange)가 생기면 실행되는 함수 : Enter
		//alert("getCustomerInfo() 함수 호출 성공했습니다.\n이 행위로 고객의 주문받는 것으로 대체합니다.");
	
		myhp = $("#m_phone").val();		//해당 id에 들어있는 값을 얻고, 얻은 값을 변수에 초기화함 [  .val()은 get ]
		 
	/* 	https://api.jquery.com/jQuery.ajax/ */
		$.ajax({//jquery에서 제공하는 ajax객체를 사용함.(XMLHttpRequest 등을 모두 내포함)
			 type:"GET"//전송방식 지정
			,url:"./json/phoneNum.json"		//url옵션  : 목적지(처리부 위치)
			 								//처리부는 자바코드가 입력됨. DB연동을 여기서 진행.
			 								//DB연동의 결과물(output)형식은 json,xml(spring))
			,dataType:"json"//데이터의 마임타입
			,success:function(data){		//success옵션 : 콜백함수가 성공해서 접근준비가 완료된 상태에 진행할 내용
				var temp='';
				$.each(data,function(i,n){	//each 함수 : 각각의 데이터 로우별로 처리하라. 
											//파라미터 1 - 대상데이터 : data
											//파라미터 2 - 함수를 수행할때, i(인덱스)의 n(json안의 키값)에 따라 수행하라
					temp=n["m_hp"];	//n(키값)이 ["키값"]인 json을 찍어서 변수 temp에 담음
					if(myhp==temp){			//담아온게 입력받은 값과 같니? 
						m_name=n["m_name"];
						m_addr=n["m_addr"];
						$("#m_name").val(m_name);	//해당 id에 지정한 변수값을 넣는 함수  [  .val(value)는 set ]
						$("#m_addr").val(m_addr);	//해당 id에 지정한 변수값을 넣는 함수
					}
				});
				//alert("temp:"+temp);
			}
		});
	}/* end of function getCustomerInfo() */
	function myInfoProcess(){
		 if(request.readyState==4){
			 var myInfo = request.responseText;
			 //alert("처리결과 : "+myInfo);
			 var temp;
			 $.each(request.responseText,function(i,n){
				 temp+=n["m_name"];
			 });
			 alert("temp:"+temp);
		 }		
	}
</script>
<!-- ────────────────────── Ajax jQuery방식 구현 끝 ────────────────────── -->

</head>
<body>
<h1>P-I-Z-Z-A O-R-D-E-R</h1>
<h3>▼ Enter your phone number</h3>
<p><input type="text" size="20" id="m_phone" name="m_phone" onchange="getCustomerInfo()"> <div id="d_msg">"등록되지 않은 전화번호입니다." 라고 띄울 자리</div></p>
	<br>
<h3>▼ Enter your name</h3>
<p><input type="text" size="20" id="m_name" name="m_name" readonly> </p>
	<br>
<h3>▼ Enter your order</h3>
<p><textarea id="m_order" name="m_order" rows="4" cols="50"></textarea> </p>
	<br>
<h3>▼ Enter your receiving address</h3>
<p><textarea id="m_addr" name="m_addr" rows="4" cols="50"></textarea> </p>
	<br>
<input type="button" value="상기 내용으로 주문 요청합니다." size="20" onclick="myOrder()" >
</body>
</html>