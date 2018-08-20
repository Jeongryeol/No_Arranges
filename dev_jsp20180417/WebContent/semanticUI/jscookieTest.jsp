<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	var cnt = 0;
</script>
</head>
<body>
<script type="text/javascript">
$.cookie('cnt',cnt,{expire: '1',path: '/semanticUI',domain:'localhost:8080'});
document.write($.cookie('cnt'));
cnt = cnt+1;
$.cookie('cnt',cnt,{expire: '2',path: '/semanticUI',domain:'localhost:8080'});
//alert($.cookie('cnt'));
//document.write("쿠키 모든 값 : "+$.cookie());
$(document).ready(function(){ 
	$("#saveButton").click(function(){
		//입력값 var 
		cookie_value = $("#save").val(); 
		//'cookie'라는 key값으로 입력값을 저장한다. 
		//1번째 parameter = 쿠키명 
		// 2번째 parameter = 저장하고자 하는 쿠키값 
		$.cookie('cookie', cookie_value); 
	}); 
		//불러오기버튼 클릭 
	$("#loadButton").click(function(){ 
		//저장버튼클릭시 'cookie' key값을 불러온다. 
		var cookie_value = $.cookie('cookie'); 
		// load라는 id text태그에 cookie_value변수에 들어있는 값을 담는다. 
		$("#load").val(cookie_value); 
    }); 
		//삭제버튼 클릭 
	$("#deleteButton").click(function(){ 
		//'cookie' 라는 key값의 쿠키를 삭제한다 
		$.removeCookie("cookie"); 
	}) 
})

</script>
저장값 : <input type="text" id="save" /> 
<input type="button" value="쿠키저장" id="saveButton" /><br/> 
쿠키값호출 : <input type="text" id="load" /> 
<input type="button" value="쿠키불러오기" id="loadButton" /> 
<input type="button" value="쿠키삭제" id="deleteButton" />

</body>
</html>