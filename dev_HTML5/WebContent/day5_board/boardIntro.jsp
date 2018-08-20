<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- �����ڵ� ���� -->
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<!-- ��ũ��Ʈ �ڵ� ���� -->
	<script type="text/javascript">
		function showcontent(menu){
			//$('#content').html('����� ������ �޴���  ' + menu);
			if(menu=='login'){
				//alert("�α���");
				$("#login").show();
				$("#board").hide();
				$("#email").hide();				
			}
			else if(menu=='board'){
				//alert("�������Խ���");
				$("#login").hide();
				$("#board").show(function (){
					/* �����ͱ׸��� �ʱ�ȭ �ϱ� */
					$("#dg_board").datagrid({
					    singleSelect:true
					   //,url:'./boardjson.jsp'
					   ,url:'http://192.168.0.24:9015/datagrid/JsonboardList.jsp'
					   ,toolbar:'#tb_board'
					   ,columns:[[
							{field:'B_NO', title:'�۹�ȣ', width:70, align:'center', editor:'text'}
						   ,{field:'B_TITLE', title:'����', width:200, align:'center', editor:'text'}
						   ,{field:'B_CONTENT', title:'����', width:360, align:'center', editor:'text'}
						   ,{field:'B_WRITER', title:'�ۼ���', width:120, align:'center', editor:'text'}
						   ,{field:'B_DATE', title:'�ۼ���', width:150, align:'center', editor:'text'}
						   ,{field:'B_HIT', title:'��ȸ��', width:100, align:'center', editor:'text'}
						]]/////////////////end of column
					});////////////////////end of datagrid
				});
				$("#email").hide();
			}
			else if(menu=='email'){
				//alert("�̸���");
				$("#login").hide();
				$("#board").hide();
				$("#email").show();
			}
			//������ �̵�ó���� �Լ� �����ϱ�
			/*
			@param1 : ���� �ٶ󺸴� ������
			@param2 : �� �������� �ѷ��� �ο� ��
			*/
			function pageMove(pageNumber, pageSize){
				alert("���� �ٶ󺸴� ������ : "+pageNumber+", �� �������� ��µ� �ο� �� : "+pageSize);
				$("#dg_board").datagrid({
				//json�� ���� �ڷᰡ ���̺�� �����Ǽ� ��� �����̱� ������ ���ϴ� �������� �κ���ȸ������ �Ұ�����.
					//url:'./boardjson.json?pageNumber='+pageNumber+"&pageSize="+pageSize
					
				//�׷��� ���õǴ� jsp
					//url:'./boardjson.jsp?pageNumber='+pageNumber+"&pageSize="+pageSize
					url:'http://localhost:9000/datagrid/jsonGetBoardList.jsp'
					
				})
			}
		}
	</script>

</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$("#login").show();
		$("#board").hide();
		$("#email").hide();
		$('#pn_board').pagination({
			 pageList: [10,20,30]
			,pageSize: 10
			//pageNumber : ���� �ٶ󺸰� �ִ� ������ �� (1�� ����������~~~~)
			//pageSize : �� �������� � �� �Ѹ�����?
			,onSelectPage: function(pageNumber, pageSize){
				alert(pageNumber+", "+pageSize);
			}
		});
	});
</script>
<!-- ȭ�� ó�� ���� -->
	<h2>������ �Խ��� ����</h2>
	<table border="1" borderColor="gray">
		<tr>
			<td>
		<div class="easyui-layout" style="width:1200px;height:550px;">
			<div region="west" split="true" title="Navigator" style="width:150px;height:200px">
				<p style="padding:5px;margin:0;">��������</p>
				<ul>
					<li><a href="javascript:void(0)" onclick="showcontent('login')">�α���</a></li>
					<li><a href="javascript:void(0)" onclick="showcontent('board')">�������Խ���</a></li>
					<li><a href="javascript:void(0)" onclick="showcontent('email')">�̸���</a></li>
				</ul>
			</div>
			<div id="content" region="center" title="EASYUI�ַ��" style="padding:5px;">
				<div id="login" style="padding:5px;">
					<table id="p_login" class="easyui-panel" title="�α���"></table>
				</div>	
				<div id="board" style="padding:5px;">
					<table id="dg_board" class="easyui-datagrid" title="������ �Խ���"></table>
					<!-- ������ ���̼� �� �߰� ���� -->
						<div id="pn_board" class="easyui-pagination" style="width:1022px;background:#efefef;border:1px solid #ccc;">
						</div>
					<!-- ������ ���̼� �� �߰�  ��  -->
					<div id="tb_board">
					    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:boardSearch()">��ȸ</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:boardAdd()">���</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascript:boardUpd()">����</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:boardDel()">����</a>
					</div>
				</div>	
				<div id="email" style="padding:5px;">
					<table id="p_email" class="easyui-panel" title="�̸���"></table>
				</div>	
			</div>			
			</td>
		</tr>
	</table>
</body>
</html>