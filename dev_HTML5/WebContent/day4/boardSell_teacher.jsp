<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>판매 관리</title>
<link rel="stylesheet" type="text/css" href="../css/boards.css">
<script type="text/javascript">
	function account(){
		//보드 판매량 읽어오기
		//보드 판매량 데이터를 감싸고 있는 span태그 정보 담기
		var el_boardsold = document.getElementById("board_sold");
		//소비자가 데이터를 감싸고 있는 span태그 정보 담기
		var el_price = document.getElementById("price");
		//구매가 데이터를 감싸고 있는 span태그 정보 담기
		var el_cost = document.getElementById("cost");
		var boardsold = getText(el_boardsold);
		var price = getText(el_price);
		var cost = getText(el_cost);
		//보드한개당 마진 금액을 담기
		//var cashPerBoard = price - cost;
		//alert("보드 판매량:"+boardsold+", 소비자가:"+price+", 구매가:"+cost);
		//새로집계된 보드 판매량
		replaceText(el_boardsold,15);
		var tot = boardsold*cashPerBoard;
		var el_margin = document.getElementById("d_margin");
		replaceText(el_margin,tot);
		alert("총 마진금액 : "+tot);
	}
/**********************************************************************
 * 텍스트 노드의 값을 새로운 값으로 변경하는  함수 구현
      파라미터 1 : 텍스트 노드를 감싸고 있는 span태그의 오브젝트정보
      파라미터 2 : 텍스트 노드에 출력할 정보      
      리턴값 : 해당없음.
      사용예: replaceText(el,15);기존에 12개에서 15개로 변경됨.   
 *********************************************************************/
		function replaceText(el,text){//el를 받아오는 코드는 document.getElementById("id");
			if(el!=null){
				//기존 노드에 들어가 있는 값은 초기화 시킨다.
				clearText(el);
				var newNode = document.createTextNode(text);
				el.appendChild(newNode);
			}/////////el이 널이 아니면
		}/////////////end of replaceText		
/**********************************************************************
 * 텍스트 노드의 값을 지우는 함수 구현
      파라미터 : 텍스트 노드를 감싸고 있는 span태그의 오브젝트정보
      리턴값 : 해당없음.
 *********************************************************************/
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
		}/////////////end of getText	
/**********************************************************************
 * 텍스트 노드의 값을 읽어오는 함수 구현
   파라미터 : 텍스트 노드를 감싸고 있는 span태그의 오브젝트정보
  리턴값 : 텍스트 노드의 값
 *********************************************************************/
	function getText(el){//el를 받아오는 코드는 document.getElementById("id");
		alert("el:"+el);//el은 element의 약자
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
<h2>웨이크 보드 판매현황</h2>
<table border="1" width="300px" height="80px">
	<tr>
		<th width="130px">보드판매량</th>
		<td width="170px"><span id="board_sold">12</span></td>
	</tr>
	<tr>
		<th width="130px">소비자가</th>
		<td width="170px"><span id="price">3800000</span></td>
	</tr>
	<tr>
		<th width="130px">구매가</th>
		<td width="170px"><span id="cost">2500000</span></td>
	</tr>		
</table>
<br>
<input type="button" value="마진은?" onClick="account()"/>
<div id="d_margin">총마진 금액은 XXXXX입니다.</div>
</body>
</html>