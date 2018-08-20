<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>
Google Map �߰��ϱ�
</title>

<!-- ������[[ import ]]�������������������������������������������������������������������������������������������������������������������������������������������������������������������� -->

	<!-- Google Map API import code -->
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCoiFcL5pbT3d5Oe5rLCQwTB14i6acEkQs"></script>
		<!-- Google Map APU Documnet Link
		https://developers.google.com/maps/documentation/javascript/tutorial -->
	
	<!-- jQuery script import code :: $-undifined error ����!!! -->
	<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>
	
<!-- ������[[HEAD script]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<script type="text/javascript">
	var gmap; //����
	var myPosition = { //���� ������ġ
			 latitude:37.478710
			,longitude:126.878700
	}
	/* ���� ���� ��ġ�� ��� �Լ� */
	function getMyLocation(){
		//�������� ���������̼� API�� �����ϴ� ���θ� �˻��ϴ� �κ�
		//navigator.geolocation��ü�� �����ϸ� �����ϴ� ���̴�.
		if(navigator.geolocation) {//�����ϰ� �ִٸ�..
			console.log("���� �����̼��� �����˴ϴ�.");
			//navigator.geolocation�Ӽ��� ���������̼� API��ü�� �����ϴ� ��ü�̴�.
			//�� API�� ���� �޼ҵ尡 �������� ��ġ�� �������� ���� �ϴ� getCurrentPostion()�Լ�
			//�����ϰ� �ִٸ� getCurrentPosition�޼ҵ带 ȣ���ؼ� displayLocation�̶� �ڵ鷯�Լ��� ȣ����
			navigator.geolocation.getCurrentPosition(displayLocation);
		}else{
			console.log("�̷�.. ���� �����̼��� �������� �ʽ��ϴ�.");
		}
	}
	function displayLocation(position){
		console.log('displayLocation() ȣ�⼺��');
		var latitude = position.coords.latitude;
		var longitude = position.coords.longitude;
		$("#location").text("����� ���� : "+latitude+" / ����� �浵 : "+longitude);
		showMap(position.coords);
	}
	function showMap(coords){
		//������ġ(����,�浵)
		var latNlong = new google.maps.LatLng(coords.latitude, coords.longitude);
		console.log("latNlong : "+latNlong);//�ܼ�Ȯ�ο�
		//�����ɼ�
		var mapOptions={
				 zoom : 16 		//�⺻ ��
				,maxZoom : 20 	//�ִ� ��
			    ,minZoom : 8 	//�ּ� ��
				,center:latNlong//�����߽���ġ
				,disableDefaultUI : true 		//�⺻ UI
				,disableDoubleClickZoom : true 	//����Ŭ�� ���� �߽����� ���� Ȯ���� ��뿩��
				,draggable : true 				//���� �巡���̵����� ��뿩��
				,keyboardShortcuts : true 		//Ű�������Ű ��뿩��
				,mapTypeId:google.maps.MapTypeId.ROADMAP//SATELITE(����)�� HYBRID
		};
		//�������� : (<div>�±׿� ������ ��ġ��ų��,) ���� ��ġ�� ǥ���ϱ�
	//	gmap = new google.maps.Map($("#location")[0],mapOptions);					//jQuery
		gmap = new google.maps.Map(document.getElementById("location"),mapOptions);	//ǥ�� ��ũ��Ʈ
			//�ڹٽ�ũ��Ʈ������ DOM�� ������ �� �ִ�.
			//�� DOM�� ������ �� �迭ǥ�������� ����� �� �ִ�.
			//���� �̸��� �������� �Ǹ� �ڵ����� �迭�� ��ȯ�ȴ�.(��Ģ�� 1��¥���� �迭�� ��ȯ��������)
		console.log("map : "+gmap);//�׽�Ʈ�� �ܼ����
		
		//���� �� ��Ŀ�� ��ǳ�� �߰�
		var markerTitle = "'������'�� ��õ�ϴ� ����";	//��Ŀ���� ��ü
		var parklatNlong = new google.maps.LatLng(37.480430, 126.879001); //��Ŀ��ġ���� ��ü
		var marker = new google.maps.Marker({ 	//��Ŀ���� �� �ɼ��߰�
			 position : parklatNlong 			//ǥ����ġ : ��ġ�����Է�
			,map : gmap 						//ǥ������ : ������ü �Է�
			,title : markerTitle 				//ǥ�ø�Ŀ���� : ��Ŀ����ü �Է� 
		});
		var markerMaxWidth = 300;	//��Ŀ�� Ŭ������ �� ��Ÿ���� ��ǳ���� �ִ� ũ��
		var mcontent = "<div>";		//��ǳ���� ����
			mcontent+= "<h2>"+markerTitle+"</h2><p>���ִ� �޴��� �����̿� ������� . �����̴� �ж��� �Ἥ �ξ� �̱��ϰ��. ���� �̸��� �ұ����� �Ծ���ؿ� �׸��� ����� ��� �ٻ����� �������� �������� Ƣ�踸�ο� ����� ���ܼ� ���� ���Ƶ�ž� ���� �ξ� ���ƿ�~^^ �׸��� 3�� �̻��̸� �ݶ� ���񽺡�</p>";
			mcontent+= "</div>"
		var infoWin = new google.maps.InfoWindow({
			 content : mcontent 		//��������API�� ��Ŀ�������� ����
			,maxWidth : markerMaxWidth 	//��Ŀ�ִ����
		});
		
		//��Ŀ �̺�Ʈó�� : ��ǳ�� ����
		google.maps.event.addListener(marker,'click',function(){//�����󿡼� ���� ��Ŀ Ŭ����
			infoWin.open(gmap,marker);							//���� ��ǳ���˾� ǥ���ϱ�	
		});
		//��Ŀ �̺�Ʈó�� : ��ǳ�� �ݱ�
		google.maps.event.addListener(marker,'click',function(){//�����󿡼� ���� ��Ŀ Ŭ����
			infoWin.close();									//���� ��ǳ���˾� �ݱ�	
		});
		console.log("gmap : "+gmap);
	}
	function foodInfoSearch(){
		$.ajax({
			 url : "./jsonFood.jsp"
			,method : "GET"
		//	,dataType : "json"
			,success : function(json){
				$("#d_foodInfo").text(json);
			}
			,error : function(xhrObject){
				alert(xhrObject.responseText);
			}
		});
	}
</script>
</head>
<!--
��������������������������������������������������������������������������������������������������������������
-->
<body onload="getMyLocation()">
<!-- ������[[BODY script]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<script type="text/javascript">

</script>

<!-- ������[[BODY content]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<p>
	<!-- �˻�â +�˻� ��ư �߰��ϱ� -->
	<input type="text" id="address" width="300px" value="����޸����2��">
	<input type="button" id="btn_search" value="��Ұ˻�" onClick="foodInfoSearch()">
</p>
	<!-- �������� �߰��ϱ� -->
<div id="location" style="width:800px;height:600px;">
	<!-- INSERT YOUR LOCATION IN GOOGLE MAP HERE -->
</div>

<div id="d_foodInfo">
<!-- ��ġ���� �����Դ��� Ȯ���ϱ����� �׽�Ʈ�ڵ� -->
</div>

</body>
</html>