<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
    <!-- �����ڵ念�� : ���� include�� ���ϰ� �ϴ� ����� ��� �� -->
    <script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
</head>
<body>
<script type="text/javascript">
	/* �� jsp���� ��ü�� ����Ű�� ���尴ü document */
	$("document").ready(function() {
/* 		$("#dg_member").datagrid({//��ü-�Ӽ��� �Լ��� �Ŵ��� �� �ִ�. ���๮���� ��ȭ��Ű��
			width:502,
			height:250,
			url:"../json/memberJSON.json",
		    columns:[[
		        {field:'mem_id',title:'ID',width:100,align:'center'},
		        {field:'mem_name',title:'������',width:100,align:'center'},
		        {field:'mem_gender',title:'����',width:100,align:'center'},
		        {field:'mem_hp',title:'��ȣ�ڿ���ó',width:200,align:'center'}
		    ]],
		    onDblClickRow:function(index,row){
		    	alert("index : "+index+", row : "+row.mem_name
		    			+", hp : "+row.mem_hp);
		    }
 		    //checkOnSelect:true,
		    //onLoadSuccess:function(){alert("����")},
		    //onLoadError:function(){alert("����")}
		}); */
	});
</script>
	<table id="dg_member" class="easyui-datagrid" width="500px"
	data-options="url:'../json/memberJSON.json',fitColumns:true,singleSelect:true">
		<thead>
		<!-- �±׷� ǥ �۾��� �ϴ°��� �⺻�̱� ������, �̺�Ʈó���� �����Ƿ�, ��ũ��Ʈ�����  ver1�� ������ -->
			<th data-options="field:'mem_id',width:120">���̵�</th>
			<th data-options="field:'mem_name',width:150">�̸�</th>
			<th data-options="field:'code',width:80">����</th>
		</thead>
	
	<tbody>
<% /* JSON�� �ƴҶ�, �ڹ��ڵ带 �̿��ؼ� ���ϴ� ���ǿ� �´� ���� for���� ����� �� �ִ�. */
	for(int i=0;i<3;i++){
%>
		<tr>
			<td><%out.print("test");%></td>
			<td><%out.print("��ó븮");%></td>
			<td><%out.print("��");%></td>
		</tr>
<%
	}
%>
	</tbody>
	</table>
</body>
</html>