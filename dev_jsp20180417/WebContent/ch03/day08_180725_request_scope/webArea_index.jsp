<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	/* ����ڰ� ��ȭ�鿡 DB�� �̸��� ����޶�� ��û�ߴٸ�, �ڹ��ڵ��� ������ ������. */
	String name1 = "�̼���";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ּ�</title>
<!-- ������[[HEAD style : css]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<style type="text/css">

</style>

<!-- ������[[ import ]]�������������������������������������������������������������������������������������������������������������������������������������������������������������������� -->
	<!-- css import code -->
<link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/themes/icon.css">
	<!-- jQuery script import code :: $-undifined error ����!!! -->
<script type="text/javascript" src="/js/jquery-1.12.0.js"></script>

<!-- ������[[HEAD script : javascript]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<script type="text/javascript">
	function methodA(){
		alert("methodA td_word 3 : "+$("#td_word").attr("id"));
	}
</script>
</head>
<!--
��������������������������������������������������������������������������������������������������������������
-->
<%
	String name2 = "�̼���";
%>
<body>
<!-- ������[[BODY script : javascript]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<script type="text/javascript">
	/* HTML������ ��ĵ�ǰ� �ڿ� (DOM��������) �±׿� �����Ͽ� ����� �� �ִ�. */
	$(document).ready(function() {//���๮�� �ǰ� �ϱ����� function�� �����ؾ���
		$("#d_word").text("�ȳ�");//<div>�±׿����� ���ڴ��
									  //�Ӽ��� �����ϴ� .attr("id")
		alert("methodA td_word 1 : "+$("#td_word").attr("id"));// �𸣴� ���¶� undifined
		/* <div>�±׷� ������ ������ ajax�� �񵿱⿵�� �����ϱ� */
		//DOM���� ajax�� ������ �����忡 ���������
		$.ajax({
			 method:"POST"//�׽�Ʈ�� POST������� �ϱ�(GET����� ���ͼ�Ʈ����)
			,url:"webArea_ajax.jsp"//�񵿱���� ajax�� �� �������� ��û�ص�
			,success:function(code){//��û�� ������ �������κ��� ������ ���ƿ��� ������ ����
				$("#d_word").html(code); 
				methodA();//id�� ����
			}
		});
		//������ ���� �������� ���� �����̰�, �̿ͺ����� ������� ������ ����Ǳ⶧���� ������ id���� �𸣴� ����
		alert("methodA td_word 2 : "+$("#td_word").attr("id"));// �𸣴� ���¶� undifined
	})
</script>

<!-- ������[[BODY content : html]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<table>
	<tr>
		<td><%=name1 %></td>
		<%-- <td> <%=name3 %>���𺸴� ȣ���� ���� �����Ƿ� �����߻�</td> --%>
	</tr>
</table>
<div id="d_word"></div>
</body>
</html>
<%
	String name3 = "��Ȳ";
%>