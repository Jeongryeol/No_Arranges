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
//document.write("��Ű ��� �� : "+$.cookie());
$(document).ready(function(){ 
	$("#saveButton").click(function(){
		//�Է°� var 
		cookie_value = $("#save").val(); 
		//'cookie'��� key������ �Է°��� �����Ѵ�. 
		//1��° parameter = ��Ű�� 
		// 2��° parameter = �����ϰ��� �ϴ� ��Ű�� 
		$.cookie('cookie', cookie_value); 
	}); 
		//�ҷ������ư Ŭ�� 
	$("#loadButton").click(function(){ 
		//�����ưŬ���� 'cookie' key���� �ҷ��´�. 
		var cookie_value = $.cookie('cookie'); 
		// load��� id text�±׿� cookie_value������ ����ִ� ���� ��´�. 
		$("#load").val(cookie_value); 
    }); 
		//������ư Ŭ�� 
	$("#deleteButton").click(function(){ 
		//'cookie' ��� key���� ��Ű�� �����Ѵ� 
		$.removeCookie("cookie"); 
	}) 
})

</script>
���尪 : <input type="text" id="save" /> 
<input type="button" value="��Ű����" id="saveButton" /><br/> 
��Ű��ȣ�� : <input type="text" id="load" /> 
<input type="button" value="��Ű�ҷ�����" id="loadButton" /> 
<input type="button" value="��Ű����" id="deleteButton" />

</body>
</html>