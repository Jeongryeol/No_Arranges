<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Ǹ� ����</title>
<link rel="stylesheet" type="text/css" href="../css/boards.css">
<script type="text/javascript">
	function account(){
		//���� �Ǹŷ� �о����
		//���� �Ǹŷ� �����͸� ���ΰ� �ִ� span�±� ���� ���
		var el_boardsold = document.getElementById("board_sold");
		//�Һ��ڰ� �����͸� ���ΰ� �ִ� span�±� ���� ���
		var el_price = document.getElementById("price");
		//���Ű� �����͸� ���ΰ� �ִ� span�±� ���� ���
		var el_cost = document.getElementById("cost");
		var boardsold = getText(el_boardsold);
		var price = getText(el_price);
		var cost = getText(el_cost);
		//�����Ѱ��� ���� �ݾ��� ���
		//var cashPerBoard = price - cost;
		//alert("���� �Ǹŷ�:"+boardsold+", �Һ��ڰ�:"+price+", ���Ű�:"+cost);
		//��������� ���� �Ǹŷ�
		replaceText(el_boardsold,15);
		var tot = boardsold*cashPerBoard;
		var el_margin = document.getElementById("d_margin");
		replaceText(el_margin,tot);
		alert("�� �����ݾ� : "+tot);
	}
/**********************************************************************
 * �ؽ�Ʈ ����� ���� ���ο� ������ �����ϴ�  �Լ� ����
      �Ķ���� 1 : �ؽ�Ʈ ��带 ���ΰ� �ִ� span�±��� ������Ʈ����
      �Ķ���� 2 : �ؽ�Ʈ ��忡 ����� ����      
      ���ϰ� : �ش����.
      ��뿹: replaceText(el,15);������ 12������ 15���� �����.   
 *********************************************************************/
		function replaceText(el,text){//el�� �޾ƿ��� �ڵ�� document.getElementById("id");
			if(el!=null){
				//���� ��忡 �� �ִ� ���� �ʱ�ȭ ��Ų��.
				clearText(el);
				var newNode = document.createTextNode(text);
				el.appendChild(newNode);
			}/////////el�� ���� �ƴϸ�
		}/////////////end of replaceText		
/**********************************************************************
 * �ؽ�Ʈ ����� ���� ����� �Լ� ����
      �Ķ���� : �ؽ�Ʈ ��带 ���ΰ� �ִ� span�±��� ������Ʈ����
      ���ϰ� : �ش����.
 *********************************************************************/
		function clearText(el){//el�� �޾ƿ��� �ڵ�� document.getElementById("id");
			var text="";
			if(el!=null){
				if(el.childNodes){
					for(var i=0;i<el.childNodes.length;i++){
						var childNode = el.childNodes[i];	
						el.removeChild(childNode);
					}
				}
			}/////////el�� ���� �ƴϸ�
		}/////////////end of getText	
/**********************************************************************
 * �ؽ�Ʈ ����� ���� �о���� �Լ� ����
   �Ķ���� : �ؽ�Ʈ ��带 ���ΰ� �ִ� span�±��� ������Ʈ����
  ���ϰ� : �ؽ�Ʈ ����� ��
 *********************************************************************/
	function getText(el){//el�� �޾ƿ��� �ڵ�� document.getElementById("id");
		alert("el:"+el);//el�� element�� ����
		var text="";
		if(el!=null){
			if(el.childNodes){
				for(var i=0;i<el.childNodes.length;i++){
					var childNode = el.childNodes[i];
					//�� �ؽ�Ʈ ����?
						if(childNode.nodeValue !=null){
							text = text+childNode.nodeValue;
						}		
				}
			}
		}/////////el�� ���� �ƴϸ�
		return text;
	}/////////////end of getText
</script>
</head>
<body>
<h2>����ũ ���� �Ǹ���Ȳ</h2>
<table border="1" width="300px" height="80px">
	<tr>
		<th width="130px">�����Ǹŷ�</th>
		<td width="170px"><span id="board_sold">12</span></td>
	</tr>
	<tr>
		<th width="130px">�Һ��ڰ�</th>
		<td width="170px"><span id="price">3800000</span></td>
	</tr>
	<tr>
		<th width="130px">���Ű�</th>
		<td width="170px"><span id="cost">2500000</span></td>
	</tr>		
</table>
<br>
<input type="button" value="������?" onClick="account()"/>
<div id="d_margin">�Ѹ��� �ݾ��� XXXXX�Դϴ�.</div>
</body>
</html>