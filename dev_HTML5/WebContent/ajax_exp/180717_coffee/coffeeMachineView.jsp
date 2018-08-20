<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../../../js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	//�񵿱� ��� ��ü ���� ���� - ���ǱⰡ �� ���̹Ƿ� ���� ���� �� ���� �ʿ��ϰ�����?
	var request1 = createRequest();
	var request2 = createRequest();
	var yourTea1 = '';//ù��° ���Ǳ� ���� �޴�
	var yourTea2 = '';//�ι�° ���Ǳ� ���� �޴�
	var yourName1 = '';
	var yourName2 = '';
	//�񵿱���� ��ü ���� �Լ� �߰��ϱ�
	function createRequest(){
		var qrequest = null;
		try {
			qrequest = new XMLHttpRequest();//���ĸ�,�����,ũ��, ���̾�����, �ͽ��÷η�10.0
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
	//�ʰ� ������ �޴���?
	function getBeverage(yourTea){
		//alert('�ʰ� ������ �޴�===>'+yourTea+", �ֹ���:"+$("#uname1").val());
		var uname = $("#uname1").val();
		var beverage = yourTea;
		//ù��° �ӽ��� ���ϰ� �ִ��� ���� üũ
		var status1 = getText(document.getElementById("d_cm1Status"));
		//alert("status1:"+status1+", status2:"+status2);
		if(status1 =="Idle"){
			replaceText(document.getElementById("d_cm1Status"),uname+"���� "+beverage+"��(��) ������ ��...");
			document.forms[0].reset();//���±� ���� ��ü �ʱ�ȭ ó��
			var url = "coffeeMaker.jsp?uname1="+uname+"&cm1=1"+"&"+new Date().getTime();
			sendRequest(request1, url);
		}
		else{
			//�ι�° �ӽ��� ���ϰ� �ִ��� ���� üũ
			var status2 = getText(document.getElementById("d_cm2Status"));
			if(status2 =="Idle"){
				replaceText(document.getElementById("d_cm2Status")
						   ,uname+"���� "+beverage+"��(��) ������ ��...");
				document.forms[0].reset();//���±� ���� ��ü �ʱ�ȭ ó��
				var url = "coffeeMaker.jsp?uname1="+uname+"&cm1=2"+"&"+new Date().getTime();
				sendRequest(request2, url);			
			}
			else{
				document.forms[0].reset();
				alert("�̾���! �� �밡 ��� Ŀ�Ǹ� ������ ��..... ����Ŀ� ����ϼ���.");
			}
		}/////////////////////end of else
	}/////////////////////////end of beverage
	//������ �޴� ó���ϱ�
	function orderDrink(){
		//alert("orderDrinkȣ�� : "+request1.readyState+", "+request2.readyState);
		if(request1.readyState == 4){//ù��° ���Ǳ��� �ֹ� ó���� ������ ��
			var result1 = request1.responseText;
		    //alert("result1 : "+result1);
		    var wcoffee = result1.substring(0,1);
		    var name = result1.substring(1,result1.length);
		    if(wcoffee=="1"){
		    	replaceText(document.getElementById("d_cm1Status"),"Idle");
		    }else{
		    	replaceText(document.getElementById("d_cm2Status"),"Idle");
		    }
		    alert(name+"���� Ŀ�ǰ� �غ�Ǿ����ϴ�!!");
		    request1 = createRequest();
		}
		else if(request2.readyState == 4){//�ι�° ���Ǳ��� �ֹ� ó���� ������ ��
			var result2 = request2.responseText;
			//alert("result2 : "+result2);
		    var wcoffee = result2.substring(0,1);
		    var name = result2.substring(1,result2.length);
		    if(wcoffee=="1"){
		    	replaceText(document.getElementById("d_cm1Status"),"Idle");
		    }else{
		    	replaceText(document.getElementById("d_cm2Status"),"Idle");
		    }
		    alert(name+"���� Ŀ�ǰ� �غ�Ǿ����ϴ�!!");
			 request2 = createRequest();
		}
	}
	//�ֹ��� �޴� ������ ���ۿ�û�ϱ�
	function sendRequest(prequest, url){
		prequest.onreadystatechange = orderDrink;//�ݹ��Լ� ȣ���ϱ�
		prequest.open("GET",url, true);
		prequest.send(null);
	}
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
	}/////////////end of clearText		
	/*
		1)el:�±׿�����Ʈ
		2)text:�±� ������Ʈ ��ȯ�� ���ڿ���
	*/
	function replaceText(el,text){//el�� �޾ƿ��� �ڵ�� document.getElementById("id");
		if(el!=null){
			//���� ��忡 �� �ִ� ���� �ʱ�ȭ ��Ų��.
			clearText(el);
			var newNode = document.createTextNode(text);
			el.appendChild(newNode);
		}/////////el�� ���� �ƴϸ�
	}/////////////end of replaceText	
	//div�±� �ؽ�Ʈ ��尪 �о����
	function getText(el){//el�� �޾ƿ��� �ڵ�� document.getElementById("id");
		//alert("el:"+el);//el�� element�� ����
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
<center><h1>�ްԽ�</h1></center>
<table align="center" width="1060" height="800">
	<tr>
<!-- ���Ǳ�1 -->	
		<td width="100%" height="100%">
		<form name="f_cm">
		<table border="7" borderColor="orange" width="530" height="762">
			<tr>
			<td width="530" height="38">
			�ֹ��� : <input type="text" id="uname1" name="uname1" size="12">
			<div id="d_cm1Status">Idle</div>
			<div id="d_cm1">���¸޽���</div>
			</td>
			</tr>
			<tr>
			<td width="530" height="762">
			<img src="./coffeeMa.png" border="0" width="520" height="762" usemap="map_cm1">
			<map name="map_cm1">
				<a href="javascript:getBeverage('������1')"><area id="tea1" shape="rect" coords="80,122,144,190"></a>
				<area id="tea2" href="javascript:getBeverage('��ũĿ��1');" shape="rect" coords="151,122,215,190">
				<area id="tea3" href="javascript:getBeverage('��Ŀ��1');" shape="rect" coords="223,122,287,190">
			</map>
			</td>
			</tr>
		</table>
		</form>
		</td>
<!-- ���Ǳ�2 -->		
		<td width="100%" height="100%">
		<table border="7" borderColor="green" width="520" height="762">
			<tr>
			<td width="530" height="38">
			�ֹ��� : <input type="text" id="uname2" name="uname2" size="12">
			<div id="d_cm2Status">Idle</div>
			<div id="d_cm2">���¸޽���</div>
			</td>
			</tr>
			<tr>
			<td width="530" height="762">
			<img src="./coffeeMa.png" border="0" width="520" height="762" usemap="map_cm2">
			<map name="map_cm2">
				<a href="javascript:getBeverage('������2')"><area id="tea1" shape="rect" coords="80,122,144,190"></a>
				<area id="tea2" href="javascript:getBeverage('��ũĿ��2');" shape="rect" coords="151,122,215,190">
				<area id="tea3" href="javascript:getBeverage('��Ŀ��2');" shape="rect" coords="223,122,287,190">
			</map>
			</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>