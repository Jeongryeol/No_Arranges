<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder" %>
<%
	String smem_name = null;
	String sstatus = null;
	if(session.getAttribute("smem_name")!=null){
		smem_name = session.getAttribute("smem_name").toString();
	}
	if(session.getAttribute("sstatus")!=null){
		sstatus = session.getAttribute("sstatus").toString();
	}
	Cookie[] cs = request.getCookies();
	String c_value = null;
	String sunglass = null;
	String shortpants = null;
	String suncream = null;
	String shortshirts = null;
	String slipper = null;
	if(cs !=null && cs.length>0){//��Ű�� �����ϴ�?
		for(int i=0;i<cs.length;i++){
			String c_name = cs[i].getName();
			if("JSESSIONID".equals(c_name)){
				c_value = cs[i].getValue();
			}
			else if("cmem_name".equals(c_name)){
				c_value = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			/* ��ǰ ���� ��ȸ �ϱ� ���� */
			else if(c_name=="sunglass"){
				sunglass = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="shortpants"){
				shortpants = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="suncream"){
				suncream = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="shortshirts"){
				shortshirts = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="slipper"){
				slipper = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			/* ��ǰ ���� ��ȸ �ϱ�  �� */
		}	
	}///end of if
	//out.print(c_value);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../semantic/semantic.css" />
<script src="../semantic/jquery-1.12.0.js"></script>
<script src="../js/jquery.easyui.min.js"></script>
<script src="../semantic/semantic.js"></script>
<script src="../js/commons.js"></script>
<title>�ø�ƽUI APIȰ��</title>
<script type="text/javascript">
	var status ='<%=c_value%>';
	var cnt = 0;
	function pwSearch(){
		//�ӽú���� �߱� ���� �� ���̵� �ʿ��� - �ʼ��Է»��� - ��ȿ���˻� ó��
		var user_id = $("#mem_id").val();
		if(user_id==null || user_id.length==0){
			alert("���̵� �Է��ϼ���.");
			return;//pwSearch�Լ� Ż��
		}
		else{
			var param = "gubun=pwSearch&user_id="+$("#mem_id").val();
			$.ajax({
				method:"POST",
				data:param,//user_id=����ڰ� �Է��� ���̵�
				url:"./member.kos",//��1���� �Ұ����� , ��2�� �Ұ����� �����ϱ�
				success:function(result){
						
				},
				error:function(xhrObject){
					alert(xhrObject.responseText);
				}
			}); 			
		}
	}
	function memoMgr(){
		//â�� ����� ó���ؾ� EasyUI�� sementic�� �浹���� �ʴ´�.
		cmm_window_popup("./memberList.jsp","700","450","testForm1");
	}
	function onLineTest(){
		cmm_window_popup("../onLineTest/testForm1.html","700","450","testForm1");
	}
	function cart(gName,gValue){
		location.href="./cartAction.jsp?gName="+gName+"&gValue="+gValue;
	}
/* 	function cartList(){
		cmm_window_popup("cartInfoList.jsp","700","450","cartInfo");
	} */
	function memberShip(){
		cmm_window_popup("memberForm.jsp","700","450","memberForm");
	}
	function loginCheck(){
		if(status == 'null' || status.length==0){
			alert("�α��� �ϼ���");
			return;
		}
	}
    function logout(){
		$.ajax({
			method:"GET",
//			url:"./logoutCookie.jsp",
			url:"./logoutSession.jsp",
			success:function(result){
				status = "";
				$("#mem_id").val("");
				$("#mem_pw").val("");
				$("#loginForm").show();
				$("#logoutForm").hide();
			},
			error:function(xhrObject){
				alert(xhrObject.responseText);
			}
		});    	
    }
	function login(){
		var x = document.cookie;
		alert("x:"+x);
		var param = "command=login&mem_id="+$("#mem_id").val()+"&mem_pw="+$("#mem_pw").val();
		$.ajax({
			method:"POST",
			url:"./member.kos?gubun=login",
			data:param,
			success:function(result){
				//��ȸ����� ���� json�������� ��� �׽�Ʈ
				//document.write(result);
				var jsonDoc = JSON.parse(result);
  				for(var i=0;i<jsonDoc.length;i++){
  					if(jsonDoc[i].cnt!=null){
  						if(jsonDoc[i].cnt==5){
  							alert("ĸí���� �̵�");
  							return;
  						}
  					}
					if(-1==jsonDoc[i].sstatus){
						alert("���̵� �������� �ʽ��ϴ�.");
						$("#loginForm").show();
						$("#mem_id").focus();
						return;
					}
					else if(0==jsonDoc[i].sstatus){
						alert("����� ���� �ʽ��ϴ�.");
						cnt=cnt+1;
						document.cookie = "cnt="+cnt+"; expires="+expires+"; path=/";
						$("#loginForm").show();
						$("#mem_pw").focus();
						return;
					}
					else if(1==jsonDoc[i].sstatus){
						$("#loginForm").hide();
						$("#logoutForm").show();
						$("#d_msg").html(jsonDoc[i].smem_name+"�� ȯ���մϴ�.");			
					}
				}
			},
			error:function(xhrObject){
				alert(xhrObject.responseText);
			}
		});		
	}
</script>
</head>
<body>
<!-- <body onLoad="cartList()"> -->
	<div class="ui inverted vertical masthead center aligned segment teal">
		<div class="ui text container">
			<h1 class="ui inverted header">������</h1>
		</div>
		<div class="ui container">
			<div class="ui secondary  menu">
				<div class="left menu">
					<div class="item">
						<div class="ui icon input">
							<input type="text" placeholder="�˻�"> <i class="search link icon"></i>
						</div>
					</div>
				</div>			
				<!-- ���̵�� ��й�ȣ -->	
<!--======================[[ �α��� ȭ�� �߰� ���� ]]=====================-->		
				<div id="loginForm" class="item">
					<div class="ui mini input">
						<input value='test' type="text" id="mem_id" name="mem_id" placeholder="���̵�" style="margin-right: 10px;">
						<input value='123' type="text" id="mem_pw" name="mem_pw" placeholder="��й�ȣ" style="margin-right: 10px;">
						<button id="btn_login" class="ui inverted white button" style="margin-right: 10px;">�α���</button>
						<button id="btn_pwSearch" class="ui inverted white button" onClick="pwSearch()">���ã��</button>
						<button id="btn_member" class="ui inverted white button" onClick="memberShip()">ȸ������</button>
					</div>
				</div>
<!--======================[[ �α��� ȭ�� �߰�   �� ]]=====================-->
<!--======================[[ �α׾ƿ� ȭ�� �߰� ���� ]]=====================-->		
				<div id="logoutForm" class="item">
					<div id="d_msg"></div>
					<button id="btn_logout" class="ui inverted white button" style="margin-right: 5px;">�α׾ƿ�</button>
					<button id="btn_memberUpd" class="ui inverted white button">��������</button>
				</div>
<!--======================[[ �α׾ƿ� ȭ�� �߰� ��    ]]=====================-->				
			</div>
		</div>
	</div>
	<div class="ui container">
		<div class="ui grid" style="margin-top: 15px;">
			<div class="four wide column">
<!--======================[[ ���̵� �޴� �߰� ���� ]]=====================-->			
				<div class="ui vertical fluid tabular menu" id="menu">
					<a id="m_intro" class="item">��Ʈ�� </a>
					<a id="m_memo" class="item">��������</a>
					<a id="m_cart" class="item"> ��ٱ��� </a>
					<a id="m_gmap" class="item"> ���۸� </a>
					<a id="m_ontest" class="item"> �¶��ν��� </a>
					<a id="m_board" class="item"> �Խ��� </a>
				</div>
<!--======================[[ ���̵� �޴� �߰�  ��   ]]=====================-->						
			</div>
			<div class="twelve wide stretched column">
<!--======================[[ ���̵� �޴� ���� ���� ]]=====================-->				
				<div id="c_intro" class="ui segment">
				��Ʈ�� ������
				</div>
				<div id="c_cart" class="ui segment">
				��ٱ��� ����
				<table border="1">
					<tr><th>��ǰ��</th><th>&nbsp;</th></tr>
					<tr><th>��׶�</th><th><a href="javascript:cart('sunglass','��׶�')">��ٱ��ϴ��</a></th></tr>
					<tr><th>�ݹ���</th><th><a href="javascript:cart('shortpants','�ݹ���')">��ٱ��ϴ��</a></th></tr>
					<tr><th>��ũ��</th><th><a href="javascript:cart('suncream','��ũ��')">��ٱ��ϴ��</a></th></tr>
					<tr><th>����Ƽ</th><th><a href="javascript:cart('shortshirts','����Ƽ')">��ٱ��ϴ��</a></th></tr>
					<tr><th>������</th><th><a href="javascript:cart('slipper','������')">��ٱ��ϴ��</a></th></tr>
				</table>
				</div>
				<div id="c_gmap" class="ui segment">
				���۸� ����
				</div>
				<div id="c_ontest" class="ui segment">
				�¶��� ���� ����
				</div>
				<div id="c_board" class="ui segment">
				�Խ��� ���� ����
				</div>
<!--======================[[ ���̵� �޴� ����   ��  ]]=====================-->						
			</div>
		</div>
	</div>
	<script>
/* ó�� �������� �� 4�� ������ �� ������̤� �����?  ȭ�� �ʱ�ȭ ó���� �ʿ��ؿ� */
		$(document).ready(function(){
			$("#c_intro").show();
			$("#c_cart").hide();
			$("#c_gmap").hide();
			$("#c_ontest" ).hide();
			$("#c_board").hide();	
			$("#logoutForm").hide();
			$("#btn_login").click(function (){
				//alert("�α��ι�ư Ŭ����....");
				login();
			});
			$("#btn_logout").click(function (){
				logout();
			});
		});
		$('#menu').find('a').click(function() {
			$('#menu').find('a').attr('class', 'item');
			$(this).attr('class', 'item active');
			//alert($(this).attr('id'));
			if(status == 'null' || status.length==0){
				alert("�α��� �ϼ���");
				return;
			}
 			if($(this).attr('id')=='m_intro'){//��Ʈ�� �����ѰŴ�?
 				$("#c_intro").show();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();
			}
			else if($(this).attr('id')=='m_memo'){//��ٱ��ϰ� �ʿ���?
 				$("#c_intro").hide();
 				$("#c_cart").hide();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();
 				memoMgr();
			}
			else if($(this).attr('id')=='m_cart'){//��ٱ��ϰ� �ʿ���?
 				$("#c_intro").hide();
 				$("#c_cart").show();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();				
			}
			else if($(this).attr('id')=='m_gmap'){//���۸ʼ��񽺰� �ʿ���?
 				$("#c_intro").hide();
 				$("#c_gmap").show();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();				
			}
			else if($(this).attr('id')=='m_ontest'){//���躼�Ŵ�?
 				$("#c_intro").hide();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();	
 				onLineTest();
			}
			else if($(this).attr('id')=='m_board'){//�Խ��� ���ǰ�?
 				$("#c_intro").hide();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").show();				
			}
		})
	</script>
</body>
</html>