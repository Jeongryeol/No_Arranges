<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	/* ���������ϰ� news_InsAction.jsp���� ���� ���� �������� */
	String n_title = request.getParameter("n_title");
	String n_content = request.getParameter("n_content");
	out.print("�Ķ���ͷ� �Ѿ�� ���� : "+n_title+", ���� : "+n_content);
/*
	���� �� �������� ���ڵ������� �߻��Ѵٸ�, Servers�� Tomcat�������� server.xml�� Ȯ���ϱ� �ٶ��ϴ�.
	server.xml�� 63�� connector �±׿� [ URIEncoding="EUC-KR" ] �ɼ��� �߰��ؾ��մϴ�.
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>AjaxȰ���� NEWSȭ�� �����ϱ�  + ��� + �α���</title>

<!-- ������[[ import ]]�������������������������������������������������������������������������������������������������������������������������������������������������������������������� -->
		<!-- �� $-undifined error ����!!! -->
<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>

<!-- ������[[ HEAD script ]]���������������������������������������������������������������������������������������������������������������������������������������������������� -->
<script type="text/javascript">
	function newsInsert(){
		/* ��۴ޱ� ��ư ó�� (����Է�â ����) */
		alert("newsInsertȣ�� ����");
		$("#f_newsIns").attr("method","get");
	//	$("#f_newsIns").attr("action","DB����ó���������� ����");
		$("#f_newsIns").attr("action","news_InsAction.jsp");
		$("#f_newsIns").submit();
	}//////////end of login()
	
	function login(){
		/* �α��� ��ư ó�� */
		//�α����� ���� ����ڰ� �Է��� ������ <input>�±׿� �ԷµǾ��ֽ��ϴ�.
		//�� ���� ���ͼ� ���̵�� ��й�ȣ�� ��ƺ����ô�.
		var id =$("#mem_id").val();//ȭ��ܿ��� id�� ���� ����� ���� ���� 
		var pw =$("#mem_pw").val();//ȭ��ܿ��� id�� ���� ����� ���� ����
		var param ="mem_id="+id+"&mem_pw="+pw;
		
		$.ajax({
			//�α��� ó���� ������(DB������������ ������)
			 url : "./login_action.jsp"
			//���������� �������� �ʴ°� ���ڽ��ϴ�.
			,method : "POST"
			//POST����� ������ �Ӽ����� ������ �Ѱܾ��մϴ�.
			,data : param
			,success : function(result){
				//alert("ó����� : "+result);//�����׽�Ʈ��
				//ȭ��ٲ�ġ�⸦ ���ؼ� <div>�±׸� �̿����մϴ�.
				$("#d_login").hide();
				$("#d_loginSucess").html(result);
			}
			,error : function(xhrObject){//����׿� �ڵ�
				alert("error : "+xhrObject.responseText);
			}
		});////end ajax
	}//////////end of login()
	
	/*
		AJAX�� ���� ���ŵ� �ϸ��� DOM������ ���� ���Ŀ� �߰��� ȭ���� ��ȭ�̹Ƿ�
		�ش� ��ȭ���� ���� �̺�Ʈó���� ���� �Լ��� <HEAD>�±׿��� �����ؾ� �մϴ�.
		ajax�� ���� ���ŵǸ鼭 ��µ� Ȩ������ �����������϶�, ���� �������������� ���ٰ� �ϴ���
		�ٲ�ġ��� �������� �Լ��̸��� ������������ ���ǵ� �Լ��̸��� ���ٸ� �۵��Ǵ� �����Դϴ�.
	*/
	function logout(){
		/* �α׾ƿ� ��ư ó�� */
		$.ajax({
			 url : "./logout_view.jsp"
			,method : "GET"
			,success : function(result){
				//alert("�α׾ƿ� �Ǿ����ϴ�.");//�����׽�Ʈ��
				//ajax�� �̹� �ٲ� <div>�ڸ��̹Ƿ� ���Ƴ���� �˴ϴ�..
				$("#d_loginSucess").html(result);
			}
			,error : function(xhrObject){//����׿� �ڵ�
				alert("error : "+xhrObject.responseText);
			}
		});////end ajax
	}//////////end of logou()
</script>

</head>
<!--
��������������������������������������������������������������������������������������������������������������
--> 
<body>
<!-- ������[[ BODY script ]]���������������������������������������������������������������������������������������������������������������������������������������������������� -->
<script type="text/javascript">
	/* 	DOM�� �����ǰ� �ڿ� ȭ�鿡 ��ȭ�� ajax�� �������غ��ϴ�.(������ȭ�����ϱ�)
		
		>> �̶� �����ؾ��� ��
		>> DOM������ �������Ŀ� �۵��ϴ� $(document).ready()�Լ���
		>> ajax�� �Ϻκи� ��ȭ��Ų �κ��� ��ü�� �ν����� ���մϴ�.
		
		>> �ֳ��ϸ�  ������ �ٿ�ε尡 ���� ������ �������� ȭ���� id���� �ν��ϱ⶧����
		>> ajax�� �񵿱ⰴü�� ������ id�� HTML�� �����������ϴ�.
		>> �̷��� �Ѱ踦 �غ��� ���� Ajax�Դϴ�. (Asynchronized Javascript And XML)
	*/
	$(document).ready(function() {
		/* ��۴ޱ� ��ư ó�� */
		$("#btn_reple").click(function() {
			//insert here : ajax code add
			$.ajax({
				 url:"./news_action.jsp"
			//	 url:ó�������� url ��ġ : "./XXX.jsp �Ǵ� /hello.dk"
			/* 	 	news_action.jsp�� ������?
					div_reple�� �� ȭ�� ������ ����ϴ�.(jsp������  HTML�±� ) */
				,method:"GET"
				,success:function(data){
					//$("#d_riple").html("<b>��۾��� ȭ��</b>")#btn_reple"#btn_reple"
					$("#d_btnreple").hide();
					$("#d_reple").html(data);
				}
				,error:function(xhrObject){
					alert("error : "+xhrObject.responseText);
				}
			});
		});
	});//////////end-DOM-ready
</script>

<!-- ������[[ BODY content ]]���������������������������������������������������������������������������������������������������������������������������������������������������� -->
<!-- �ܰ����̺����  -��üũ�� ���� + �⺻��ȹ ����  :: 3��� (TOP-NEWS-BOTTOM) -->
<table width="800px" height="600px">
<!-- TOP���� ���� -->
<tr>
<td width="100%" height="80px">
	<!-- �Ҵ�� �����ȿ��� �������̺� ���� �� �ܰ�ũ�� Ȯ�� ( border ) -->
	<table width="100%" height="100%" border="1" bordercolor="orange">
		<tr>
			<td align="center">
				top ���� �Դϴ�.(��ȭ���� ����-ajax������κ�)
			</td>
		</tr>
	</table>
</td>
</tr>
<!-- TOP���� �� -->

<!-- NEWS���� ���� -->
<tr>
<td width="100%" height="480px">
	<table width="100%" height="100%" border="1" bordercolor="green">
		<tr>
			<!-- [[���ʿ��ʿ��ʿ���]] -->
			<td width="40%" align="center">
				<table >
				<!-- �α���ȭ�� �߰� -->
				<tr>
					<td>
					<div id="d_login">
						<table id="t_login" width="250px" height="60px" border="1" bordercolor="red">
							<tr>
								<td width="150px" align="center">
									<!-- ���̵� �Է�â -->
									<input type="text" id="mem_id" value="ID" size="10"
										onClick="javascript:document.getElementById('mem_id').value=''">
								</td>
									<!-- �α��ι�ư+Ȯ��-->
								<td rowspan="2" width="80px" align="center">
									<input type="button" id="btn_login" value="LOGIN"
									 onClick="javascript:login()">
								</td>
							</tr>
							<tr>
								<td align="center" >
									<!-- ��й�ȣ �Է�â -->
									<input type="text" id="mem_pw" value="PW" size="10"
										onClick="javascript:document.getElementById('mem_pw').value=''">
								</td>
							</tr>
						</table>
					</div>
					<div id="d_loginSucess"></div>
					</td>
				</tr>
				<tr height="300px">
					<td></td>
				</tr>
				</table>
			</td>
			<!-- [[�����ʿ����ʿ����ʿ�����]] -->
			<td width="60%" align="center">
				NEWS �����Դϴ�.<br>
				�������� : ����.....<br>
				�������� : ����.....<br>
				<!-- INSERT HERE : �ۼ��� ��� ������ ���⿡ ��µǵ��� �ϼ���. -->
<%
	//��۳����� �ֳ���? - ������ ó���غ�����.
			if((n_title!=null)&&(n_content!=null)){
				out.print("������� : "+n_title);
				out.print("<br>");
				out.print("��۳��� : "+n_content);
			}
%>								
				<div id="d_btnreple"><input id="btn_reple" type="button" value="��۾���"></div>
				<div id="d_reple">���⿡ ��۾��� ȭ�� ���� [jsp���� ����]</div>
			</td>
		</tr>
	</table>
</td>
</tr>
<!-- NEWS���� �� -->

<!-- BOTTOM���� ���� -->
<tr>
<td width="100%" height="40px">
	<table width="100%" height="100%" border="1" bordercolor="blue">
		<tr>
			<td align="center">
				ȸ��Ұ� | �λ縻 | ����å����(��ȭ���� ����-ajax������κ�)
			</td>
		</tr>
	</table>
</td>
</tr>
<!-- BOTTOM���� �� -->

<!-- �ܰ����̺� �� -->
</body>

</html>