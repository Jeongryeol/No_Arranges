<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../../../js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	//비동기 통신 객체 변수 선언 - 자판기가 두 대이므로 변수 선언 두 개가 필요하겠지요?
	var request1 = createRequest();
	var request2 = createRequest();
	var yourTea1 = '';//첫번째 자판기 선택 메뉴
	var yourTea2 = '';//두번째 자판기 선택 메뉴
	var yourName1 = '';
	var yourName2 = '';
	//비동기통신 객체 생성 함수 추가하기
	function createRequest(){
		var qrequest = null;
		try {
			qrequest = new XMLHttpRequest();//사파리,오페라,크롬, 파이어폭스, 익스플로러10.0
		} catch(trymicrosoft){
			try {
				qrequest = new ActiveObject("Msxml2.XMLHTTP");
			} catch (othermicrosoft) {
				try {
					qrequest = new ActiveObject("Microsoft.XMLHTTP");
				} catch (failed) {
					qrequest = null;
				}
			}
		}
		if(qrequest==null){
			alert("Error creating XMLHttpRequest Object!!!");
		}
		else{
			return qrequest;
		}
	}////////////end of createRequest()
	//너가 선택한 메뉴는?
	function getBeverage(yourTea){
		//alert('너가 선택한 메뉴===>'+yourTea+", 주문자:"+$("#uname1").val());
		var uname = $("#uname1").val();
		var beverage = yourTea;
		//첫번째 머신이 일하고 있는지 여부 체크
		var status1 = getText(document.getElementById("d_cm1Status"));
		//alert("status1:"+status1+", status2:"+status2);
		if(status1 =="Idle"){
			replaceText(document.getElementById("d_cm1Status"),uname+"님의 "+beverage+"를(을) 내리는 중...");
			document.forms[0].reset();//폼태그 내용 전체 초기화 처리
			var url = "coffeeMaker.jsp?uname1="+uname+"&cm1=1"+"&"+new Date().getTime();
			sendRequest(request1, url);
		}
		else{
			//두번째 머신이 일하고 있는지 여부 체크
			var status2 = getText(document.getElementById("d_cm2Status"));
			if(status2 =="Idle"){
				replaceText(document.getElementById("d_cm2Status")
						   ,uname+"님의 "+beverage+"를(을) 내리는 중...");
				document.forms[0].reset();//폼태그 내용 전체 초기화 처리
				var url = "coffeeMaker.jsp?uname1="+uname+"&cm1=2"+"&"+new Date().getTime();
				sendRequest(request2, url);			
			}
			else{
				document.forms[0].reset();
				alert("미안해! 두 대가 모두 커피를 내리는 중..... 잠시후에 사용하세요.");
			}
		}/////////////////////end of else
	}/////////////////////////end of beverage
	//선택한 메뉴 처리하기
	function orderDrink(){
		//alert("orderDrink호출 : "+request1.readyState+", "+request2.readyState);
		if(request1.readyState == 4){//첫번째 자판기의 주문 처리가 끝났을 때
			var result1 = request1.responseText;
		    //alert("result1 : "+result1);
		    var wcoffee = result1.substring(0,1);
		    var name = result1.substring(1,result1.length);
		    if(wcoffee=="1"){
		    	replaceText(document.getElementById("d_cm1Status"),"Idle");
		    }else{
		    	replaceText(document.getElementById("d_cm2Status"),"Idle");
		    }
		    alert(name+"님의 커피가 준비되었습니다!!");
		    request1 = createRequest();
		}
		else if(request2.readyState == 4){//두번째 자판기의 주문 처리가 끝났을 때
			var result2 = request2.responseText;
			//alert("result2 : "+result2);
		    var wcoffee = result2.substring(0,1);
		    var name = result2.substring(1,result2.length);
		    if(wcoffee=="1"){
		    	replaceText(document.getElementById("d_cm1Status"),"Idle");
		    }else{
		    	replaceText(document.getElementById("d_cm2Status"),"Idle");
		    }
		    alert(name+"님의 커피가 준비되었습니다!!");
			 request2 = createRequest();
		}
	}
	//주문한 메뉴 서버로 전송요청하기
	function sendRequest(prequest, url){
		prequest.onreadystatechange = orderDrink;//콜백함수 호출하기
		prequest.open("GET",url, true);
		prequest.send(null);
	}
	function clearText(el){//el를 받아오는 코드는 document.getElementById("id");
		var text="";
		if(el!=null){
			if(el.childNodes){
				for(var i=0;i<el.childNodes.length;i++){
					var childNode = el.childNodes[i];	
					el.removeChild(childNode);
				}
			}
		}/////////el이 널이 아니면
	}/////////////end of clearText		
	/*
		1)el:태그오브젝트
		2)text:태그 오브젝트 변환할 문자열값
	*/
	function replaceText(el,text){//el를 받아오는 코드는 document.getElementById("id");
		if(el!=null){
			//기존 노드에 들어가 있는 값은 초기화 시킨다.
			clearText(el);
			var newNode = document.createTextNode(text);
			el.appendChild(newNode);
		}/////////el이 널이 아니면
	}/////////////end of replaceText	
	//div태그 텍스트 노드값 읽어오기
	function getText(el){//el를 받아오는 코드는 document.getElementById("id");
		//alert("el:"+el);//el은 element의 약자
		var text="";
		if(el!=null){
			if(el.childNodes){
				for(var i=0;i<el.childNodes.length;i++){
					var childNode = el.childNodes[i];
					//너 텍스트 노드야?
						if(childNode.nodeValue !=null){
							text = text+childNode.nodeValue;
						}		
				}
			}
		}/////////el이 널이 아니면
		return text;
	}/////////////end of getText	
</script>
</head>
<body>
<center><h1>휴게실</h1></center>
<table align="center" width="1060" height="800">
	<tr>
<!-- 자판기1 -->	
		<td width="100%" height="100%">
		<form name="f_cm">
		<table border="7" borderColor="orange" width="530" height="762">
			<tr>
			<td width="530" height="38">
			주문자 : <input type="text" id="uname1" name="uname1" size="12">
			<div id="d_cm1Status">Idle</div>
			<div id="d_cm1">상태메시지</div>
			</td>
			</tr>
			<tr>
			<td width="530" height="762">
			<img src="./coffeeMa.png" border="0" width="520" height="762" usemap="map_cm1">
			<map name="map_cm1">
				<a href="javascript:getBeverage('율무차1')"><area id="tea1" shape="rect" coords="80,122,144,190"></a>
				<area id="tea2" href="javascript:getBeverage('밀크커피1');" shape="rect" coords="151,122,215,190">
				<area id="tea3" href="javascript:getBeverage('블랙커피1');" shape="rect" coords="223,122,287,190">
			</map>
			</td>
			</tr>
		</table>
		</form>
		</td>
<!-- 자판기2 -->		
		<td width="100%" height="100%">
		<table border="7" borderColor="green" width="520" height="762">
			<tr>
			<td width="530" height="38">
			주문자 : <input type="text" id="uname2" name="uname2" size="12">
			<div id="d_cm2Status">Idle</div>
			<div id="d_cm2">상태메시지</div>
			</td>
			</tr>
			<tr>
			<td width="530" height="762">
			<img src="./coffeeMa.png" border="0" width="520" height="762" usemap="map_cm2">
			<map name="map_cm2">
				<a href="javascript:getBeverage('율무차2')"><area id="tea1" shape="rect" coords="80,122,144,190"></a>
				<area id="tea2" href="javascript:getBeverage('밀크커피2');" shape="rect" coords="151,122,215,190">
				<area id="tea3" href="javascript:getBeverage('블랙커피2');" shape="rect" coords="223,122,287,190">
			</map>
			</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>