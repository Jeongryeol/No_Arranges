<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%
	//�α��� ���� üũ
	Cookie[] cs = request.getCookies();
	String c_value = null;
	if(cs != null && cs.length>0){//��Ű�� �����Ѵٸ�
		for(int i=0;i<cs.length;i++){
			String c_name = cs[i].getName();
			if("cmem_name".equals(c_name)){
				//������ ��Ű�� ���� ���ڵ��ؼ� �о
				c_value = URLDecoder.decode(cs[i].getValue(),"UTF-8");
			}
		}
	}
	//out.print(c_value);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>
<link rel="stylesheet" href="../../semantic/semantic.css">
<script src="../../semantic/semantic.js"></script>
<script src="../../js/jquery.easyui.min.js"></script>
<script src="../../js/commons.js"></script>
<title>�ø�ƽUI</title>
<script type="text/javascript">
	//�α��� ó��
	function login(){
		//alert("imgObj:"+imgObj.attr("id"));//id�� ���� �о���� �ڵ�
		var param = "command=login"
					+"&mem_id="+$("#mem_id").val()
					+"&mem_pw="+$("#mem_pw").val();
		$.ajax({
			method:"POST",
			url:"./memberMgr.do",
			data:param,
			success:function(result){
	    		//alert("�׽��� �� ȯ���մϴ�.");
	       		$("#loginForm").hide();//�α��� ���� ����α�
	       		$("#logoutForm").show();//�α׾ƿ� �������ֱ�
				$("#d_msg").html(result);//���				
			},
			error:function(xhrObject){
				alert(xhrObject.responseText);
			}
		});
	}
	//�α׾ƿ�ó��
	function logout(){
		var param = "command=logout"
		$.ajax({
			 method:"POST"
			,url:"logoutCookie.jsp"
			,data:param
			,success:function(result){
				alert("�α׾ƿ� �Ǿ����ϴ�.");
				$("#logoutForm").hide();//�α׾ƿ� ���� ����α�
		       	$("#loginForm").show();//�α��� ���� ���̰��ϱ�
		       	$("#mem_id").val("");//����
		       	$("#mem_pw").val("");//����
			}
			,error:function(xhrObject){
				alert(xhrObject);
			}
		});
	}
	//ȸ������
	function memberShip(){
		cmm_window_popup("memberForm.jsp","700","450","memberForm");
	}
	//�¶��ν��� �˾�����
	function onLineTest(){
		cmm_window_popup("../../onLineTest/testForm1.html","700","450","testForm1");
	}
</script>	
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
       	//�ʱ�ȭ�� ó��
		$("#c_intro").hide();
       	$("#c_gmap").hide();
       	$("#c_ontest").hide();
       	$("#c_board").hide();
       	//�α��λ��� üũ �ݿ�
       	var status = "<%=c_value %>";
       	if(status=='null' || status.length==0){
   			$("#logoutForm").hide();
   			$("#loginForm").show();
		} else {
   			$("#loginForm").hide();
   			$("#logoutForm").show();
		}
	})
</script>
<!-- ���̾�α� ����-->
<div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    Dialog Content.
</div>
<!-- ���̾�α� ��-->
   <div class="ui inverted vertical masthead center aligned segment pink">
      <div class="ui container"></div>
      <div class="ui text container">
         <h1 class="ui inverted header">Project Name</h1>
      </div>
      <div class="ui container">
         <div class="ui secondary menu">
				<!-- ===========[[�α����� �ؾ��ϴ� ������ ȭ��]]=========== -->
				<div class="right menu">
		            <div class="item">
		               <div class="ui icon input">
		                  <input type="text" placeholder="Search">
		                   <i class="search link icon"></i>
		               </div>
		            </div>
		        </div>
				<div id="loginForm" class="item">
					<!--  ���̵� �߰�  -->
					<div class="ui mini input">
						<input id="mem_id" name="mem_id" type="text" placeholder="ID" style="margin-right: 10px;">
					</div>
					<!--  ��й�ȣ �߰�  -->
					<div class="ui mini input">
						<input id="mem_pw" name="mem_pw" type="text" placeholder="PW" style="margin-right: 15px;">
					</div>
					<!--  �α��� �߰�  -->
					<div id="d_logBtn" class="ui mini input" style="width: 200px;">
						<button id="btn_login" class="ui inverted red button"
								style="padding-bottom: 7px; padding-right: 15px; padding-top: 7px; padding-left: 15px;"
								onclick="login()">�α���</button>
					</div>
					<!-- ȸ������ �߰� -->
					<div id="d_logBtn" class="ui mini input" style="width: 200px;">
						<button id="btn_join" class="ui inverted red button"
								style="padding-bottom: 7px; padding-right: 15px; padding-top: 7px; padding-left: 15px;"
								onclick="memberShip()">ȸ������</button>
					</div>
				</div>
				<!-- ==========[[ �α׾ƿ��� �ؾ��ϴ� ������ ȭ��]]=========== -->
				<div id="logoutForm" class="item">
					<!--  ȯ���λ� �߰�  -->
					<div id="d_msg" class="ui mini input"></div>
					<!--  �α׾ƿ� �߰�  -->
					<div id="d_logBtn" class="ui mini input">
						<button id="btn_logout" class="ui inverted red button"
								style="padding-bottom: 7px; padding-right: 15px; padding-top: 7px; padding-left: 15px;"
								onclick="logout()">�α׾ƿ�</button>
					</div>
				</div>
          </div>
      </div>
   </div>
<!-- =====================[[ ���̵� �޴� �߰� ���� ]]===================== -->
   <div class="ui container">
      <div class="ui grid" style="margin-top: 5px;">
         <div class="four wide column">
            <div id="menu" class="ui vertical fluid tabular menu">
               <a id="m_intro" class="item"> ��Ʈ�� </a> 
               <a id="m_gmap" class="item"> ���۸� </a>
               <a id="m_ontest" class="item"> �¶��ν��� </a> 
               <a id="m_board" class="item"> �Խ��� </a>
            </div>
<!-- =====================[[ ���̵� �޴� �߰� �� ]]===================== -->
         </div>
  		 <div class="twelve wide stretched column">
<!-- =====================[[ ���̵� �޴� ���� ���� ]]===================== -->
			<div id="c_intro" class="ui segment">
				��Ʈ�� ������
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
	    </div>
<!-- =====================[[ ���̵� �޴� ���� �� ]]===================== -->
      </div>
   </div>
   <script type="text/javascript">
    /* �޴��κп���  a�±׸� ã��, Ŭ���������� �̺�Ʈ�� ���� */  
   	$('#menu').find('a').click(function(){
        
   		$('#menu').find('a').attr('class','item');
        $(this).attr('class','item active');
        
        //alert("������?");
        /* ȭ�� �б�  */
       	$("#c_intro").hide("slow");
       	$("#c_gmap").hide("slow");
       	$("#c_ontest").hide("slow");
       	$("#c_board").hide("slow");
       	
       	//�α���üũ
       	var status = "<%=c_value %>";
       	alert("status ="+status);
       	if(status=='null' || status.length==0){
			alert("�α����ϼ���");
			$("#c_intro").show();
			return;
		}
       	
        if($(this).attr('id')=='m_intro'){//��Ʈ�� ����
        	//alert("c_intro ����")
        	$("#c_intro").show();
        }
        else if($(this).attr('id')=='m_gmap'){//���۸� ���� ����
        	 //alert("c_gmap ����")
         	$("#c_gmap").show();
        }
        else if($(this).attr('id')=='m_ontest'){//�¶��� ���� ����
        	 //alert("c_ontest ����")
        	$("#c_ontest").hide();
        	onLineTest();
        	
        }
        else if($(this).attr('id')=='m_board'){//�Խ��� ����
        	 //alert("c_board ����")
         	$("#c_board").show();
        }
      })
   </script>
</body>
</html>