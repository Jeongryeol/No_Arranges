<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ǸŰ���</title>
<link rel="stylesheet" type="text/css" href="../css/boards.css">
<script type="text/javascript">
	function account(){
		//���� �Ǹŷ� �о����
		//���� �Ǹŷ� �����͸� ���ΰ� �ִ� span�±� ���� ���
		var el_boardsold = document.getElementById("i_boardsold");
		//�Һ��ڰ� �����͸� ���ΰ� �ִ� span�±� ���� ���
		var el_price = document.getElementById("i_price");
		//���Ű� �����͸� ���ΰ� �ִ� span�±� ���� ���
		var el_cost = document.getElementById("i_cost");
		var boardsold = getText(el_boardsold);
		var price = getText(el_price);
		var cost = getText(el_cost);
		//�����Ѱ��� ���� �ݾ� ���
		var cashPerBoard = price - cost;
		//�� �����ݾ� ���
		var tot = boardsold*cashPerBoard;
		//alert("�����Ǹŷ� :"+boardsold+", �Һ��ڰ� : "+price+", ���Ű� : "+cost);
		//��������� ���� �Ǹŷ�
		replaceText(el_boardsold,15);
		var tot = boardsold*cashPerBoard;
		var el_margin = document.getElementById("d_margin");
		replaceText(el_margin,tot);
		alert("�� �����ݾ� : "+tot);
	}
/*************************************************
 * �ؽ�Ʈ ����� ����  ���ο� ������ �����ϴ� �Լ� ����
 * @�Ķ����1 : �ؽ�Ʈ ��带 ���ΰ� �ִ� span�±��� ������Ʈ����
 * @�Ķ����2 : �ؽ�Ʈ ��忡 �����  ����
 * @���ϰ� : �ش���� 
 * @��뿹 : replaceText(el,15);������ 12������ 15���� �����.
 *************************************************/
	function replaceText(el,text){//el�� �޾ƿ��� �ڵ�� document.getElementById("id");
		if(el!=null){
			//���� ��忡 �� �ִ� ���� �ʱ�ȭ ��Ų��.
			clearText(el);
			var newNode = document.createTextNode(text);
			el.appendChild(newNode);
		}/////////el�� ���� �ƴϸ�
	}/////////////end of replaceText	
/*************************************************
 * �ؽ�Ʈ ����� ���� ����� �Լ� ����
 * @�Ķ���� : �ؽ�Ʈ ��带 ���ΰ� �ִ� span�±��� ������Ʈ ����
 * @���ϰ� : �ش���� 
 *************************************************/
 	function clearTest(el){//el�� �޾ƿ��� �ڵ�� document.getElementById("id");
 		var text="";
 		if(el!=null){
 			if(el.childNodes){
 				for(var i=0;i<el.childNodes.length;i++){
 					var childNode = el.childNodes[i];
 					el.removeChild(childNode);
 				}
 			}
 		}//el�� ���� �ƴϸ�
 	}//////end of clearText
/*************************************************
 * �ؽ�Ʈ ����� ���� �о���� �Լ� ����
 * @�Ķ���� : �ؽ�Ʈ ��带 ���ΰ� �ִ� span�±��� ������Ʈ ����
 * @���ϰ� : �ؽ�Ʈ ����� �� 
 *************************************************/
	function getText(el){//el�� �޾ƿ��� �ڵ�� document.gewtElementById("id");
		alert("el:"+el);//el�� element�� ����
		var text="";
		if(el!=null){
			if(el.childNodes){
				for(var i=0;i<el.childNodes.length;i++){
					var childNode = el.childNodes[i];
					//�� �ؽ�Ʈ ����?
							if(childNode.nodeValue != null){
								text = text + childNode.nodeValue;
							}
				}	
			}
		}
	}
</script>
<style type="text/css">
@charset "EUC-KR";
body{
	font-family: sans-serif;
	font-size: small;
	text-align:center;
}
table{
	margin-left: auto;
	margin-right: auto;
	border: thin solid black;
	font-size: small;
}
td,th{
	border: thin dotted grey;
	padding: 5px;
	text-align: center;
}
th{	/* ���� �����ϰ� ������ ���δ� ��� */
	background-color:#FFAAAA;
}
</style><!-- CSS�� ���� �����̳ʵ��� �������ش�. ������ ���ؼ��� �� �� �˾ƾ��ϹǷ� ���� ����غ���. -->
</head>
<body>
<h2>����ũ ���� �Ǹ���Ȳ</h2>
<table border="1" width="300px" height="80px">
    <tr>
        <td width="130px">�����Ǹŷ�</td>
        <td width="170px"><span id="i_boardsold">12</span></td>
    </tr>    
    <tr>
        <td width="130px">�Һ��ڰ�</td>
        <td width="170px"><span id="i_price">38000000</span></td>
    </tr>    
    <tr>
        <td width="130px">���Ű�</td>
        <td width="170px"><span id="i_cost">25000000</span></td>
    </tr>    
</table><BR>
<input type="button" value="������?" onClick="account()">
<div id="d_margin">�� ���� �ݾ��� XXXXXX�Դϴ�.</div>
</body>
</html>