<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jQuery���� Ajax�� ����Ͽ� �����ֹ�ȭ�� �����ϱ�</title>

<!-- �������������������������������������������� Ajax jQuery��� ���� ���� �������������������������������������������� -->
<script type="text/javascript" src="http://localhost:9000/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	//���������� ����
	var request = null;
	var m_name = '';
	var m_addr = '';
	var myhp = '';
	
	
	function getCustomerInfo(){ // text�Է�ĭ"phone"�� ��ȭ(onchange)�� ����� ����Ǵ� �Լ� : Enter
		//alert("getCustomerInfo() �Լ� ȣ�� �����߽��ϴ�.\n�� ������ ���� �ֹ��޴� ������ ��ü�մϴ�.");
	
		myhp = $("#m_phone").val();		//�ش� id�� ����ִ� ���� ���, ���� ���� ������ �ʱ�ȭ�� [  .val()�� get ]
		 
	/* 	https://api.jquery.com/jQuery.ajax/ */
		$.ajax({//jquery���� �����ϴ� ajax��ü�� �����.(XMLHttpRequest ���� ��� ������)
			 type:"GET"//���۹�� ����
			,url:"./json/phoneNum.json"		//url�ɼ�  : ������(ó���� ��ġ)
			 								//ó���δ� �ڹ��ڵ尡 �Էµ�. DB������ ���⼭ ����.
			 								//DB������ �����(output)������ json,xml(spring))
			,dataType:"json"//�������� ����Ÿ��
			,success:function(data){		//success�ɼ� : �ݹ��Լ��� �����ؼ� �����غ� �Ϸ�� ���¿� ������ ����
				var temp='';
				$.each(data,function(i,n){	//each �Լ� : ������ ������ �ο캰�� ó���϶�. 
											//�Ķ���� 1 - ������� : data
											//�Ķ���� 2 - �Լ��� �����Ҷ�, i(�ε���)�� n(json���� Ű��)�� ���� �����϶�
					temp=n["m_hp"];	//n(Ű��)�� ["Ű��"]�� json�� �� ���� temp�� ����
					if(myhp==temp){			//��ƿ°� �Է¹��� ���� ����? 
						m_name=n["m_name"];
						m_addr=n["m_addr"];
						$("#m_name").val(m_name);	//�ش� id�� ������ �������� �ִ� �Լ�  [  .val(value)�� set ]
						$("#m_addr").val(m_addr);	//�ش� id�� ������ �������� �ִ� �Լ�
					}
				});
				//alert("temp:"+temp);
			}
		});
	}/* end of function getCustomerInfo() */
	function myInfoProcess(){
		 if(request.readyState==4){
			 var myInfo = request.responseText;
			 //alert("ó����� : "+myInfo);
			 var temp;
			 $.each(request.responseText,function(i,n){
				 temp+=n["m_name"];
			 });
			 alert("temp:"+temp);
		 }		
	}
</script>
<!-- �������������������������������������������� Ajax jQuery��� ���� �� �������������������������������������������� -->

</head>
<body>
<h1>P-I-Z-Z-A O-R-D-E-R</h1>
<h3>�� Enter your phone number</h3>
<p><input type="text" size="20" id="m_phone" name="m_phone" onchange="getCustomerInfo()"> <div id="d_msg">"��ϵ��� ���� ��ȭ��ȣ�Դϴ�." ��� ��� �ڸ�</div></p>
	<br>
<h3>�� Enter your name</h3>
<p><input type="text" size="20" id="m_name" name="m_name" readonly> </p>
	<br>
<h3>�� Enter your order</h3>
<p><textarea id="m_order" name="m_order" rows="4" cols="50"></textarea> </p>
	<br>
<h3>�� Enter your receiving address</h3>
<p><textarea id="m_addr" name="m_addr" rows="4" cols="50"></textarea> </p>
	<br>
<input type="button" value="��� �������� �ֹ� ��û�մϴ�." size="20" onclick="myOrder()" >
</body>
</html>