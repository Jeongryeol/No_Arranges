<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src ="../../js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	function account(){
		$.ajax({
			 //url : "../180712_experience/boardAction.jsp?"+new Date().getTime()
			 url : "/dev_HTML5/BoardAction?"+new Date().getTime()
					 //xml������ �� UML�������� Survlet���� ȣ��� URL��ο���, ��Ʈ��ȣ ������ �ּҰ� �����Ѵ�.
			,method : "GET"
			,statusCode : {//������ ��Ʈ �ɼ�!!! jsp�� status�� jquery���� Ȯ���ϴ� status code!!!
				200 : function(){
					alert("200 :: Ok");
				},
				404 : function(){
					alert("page not found");
				},
				405 : function(){//method�̸��� ������ ������ 405 ���°� �ǰ�, �׶� �˸�â�� �ߵ��� ����
					alert("405 error");
				}
			}
			,success : function(data){//4�̸鼭 200ok
				//alert(data);//request1.responseText(json), request1.responseXml
				alert("���� ����� �Ǹŷ� : "+data);
				//insert here - ����� �Ǹŷ����� ���� �ݾ��� ����Ͽ� �� ���� �ݾ��� ����Ͻÿ�.
				var real = ($("#price").text()-$("#cost").text())*$("#board_sold").text()
				
				//$("#d_margin).text("�����ݾ��� "+????+"�Դϴ�.");
				//$("#d_margin").text("<font color ='red'>�����ݾ�</font>�� "+1000+"�Դϴ�.");
				$("#d_margin").html("<font color ='red'>�����ݾ�</font>�� "+real+"�Դϴ�.");
			}
			,error : function(request1, status){
				alert("status : "+status);
				alert(request1.responseText);
			}
		});
	}
</script>
</head>
<body>
<h2>����ũ ���� �Ǹ���Ȳ-Ajax����</h2>
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
		<td width="170px"><span id="cost">2500000</td>
	</tr>		
</table>
<br>
<input type="button" value="������?" onClick="javascript:account()"/>
<div id="d_margin">�Ѹ��� �ݾ��� XXXXX�Դϴ�.</div>
</body>
</html>