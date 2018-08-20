<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- �����ڵ� ���� -->
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css?1">
	<link rel="stylesheet" type="text/css" href="../demo/demo.css">
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	    function myformatter(date){
	        var y = date.getFullYear();
	        var m = date.getMonth()+1;
	        var d = date.getDate();
	        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	    }
	    function myparser(s){
	        if (!s) return new Date();
	        var ss = (s.split('-'));
	        var y = parseInt(ss[0],10);
	        var m = parseInt(ss[1],10);
	        var d = parseInt(ss[2],10);
	        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
	            return new Date(y,m-1,d);
	        } else {
	            return new Date();
	        }
	    }	
		function idSearch(){
			alert("�˻�");
		}
		//���߰�
		function addRow(){
			$('#dg_member').datagrid('appendRow',{
				mem_id: '',
				mem_name: '',
				mem_gender: '',
				mem_hp:''
			});
		}
		//�����
		function delRow(index){
			//alert("������ �ο��� index:"+index);
			$('#dg_member').datagrid('deleteRow',index);//ȭ��󿡼��� ����. DB���� �����Ǵ� �� �ƴ�.			
		}
		//��ȸ ó��
		function search1(){
			//alert("��ȸ ȣ�� ����");//document.write();//���� ��ü �ʱ�ȭ
			$("#dg_member").datagrid({
				url:"../json/memberJSON.json",
			});
		}
		//���ȭ�� ���� ó��
		function add(){
			//alert("��� ȣ�� ����");
			$('#dlg_memIns').dialog('open');
		}
		//����ó��
		function pencil(){
			alert("���� ȣ�� ����");
		}
		//����ó��
		function cut(){
			//�� �����ϰ� ���� �ο� �����Ѱž�?
			//������ �ο� ������ ������ ��
			var row = $("#dg_member").datagrid('getSelected');//������Ʈ
			if(row==null){
				alert("������ �ο츦 �����ϼ���.");
				return;//cut�Լ� Ż��
			}
			//���� ������ �ο��� �ε��� ������ �� �� �ִٸ� �����ٵ�........
			var sindex = $("#dg_member").datagrid('getRowIndex',row);
			delRow(sindex);
			//alert(row);//Object....
			//alert(row.mem_id+", index������? "+sindex);
		}
		//����
		function save(){
			alert("����ȣ�� ����");
		}
		//����
		function order2(){
			alert("����ȣ�� ����");
			$('#dg_member').datagrid('sort', {
				sortName: 'mem_id',
				sortOrder: 'desc',
				url:"../json/memberJSON.json"
			});
		}
		//���ȭ�鿡�� �����ư ����
		function memIns(){//���� ����Ŭ�������� INSERTó��
			//alert("DB������ �����Ͽ� INSERTó��");
			$("#f_memIns").attr("method","post");
			$("#f_memIns").attr("action","./memInsAction.jsp");//memInsAction.jsp���� DB�� INSERTó���� ����.
			$("#f_memIns").submit();//�� �� �����PC���� ��Ĺ������ ������ �Ͼ.		
			$('#dlg_memIns').dialog('close');
		}
		</script>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function(){
		$("#dg_member").datagrid({
			width:500,
			height:250,
			title:"ȸ������",
			toolbar:"#tb_member",
			singleSelect:true,
			//url:"../json/memberJSON.json",
		    columns:[[
		        {field:'mem_ck',title:'����',width:50},
		        {field:'mem_id',title:'���̵�',width:100, sortable:'true'},
		        {field:'mem_name',title:'�̸�',width:150},
		        {field:'mem_gender',title:'����',width:50,align:'right'},
		        {field:'mem_hp',title:'HP',width:120,align:'center'}
		    ]],
		    onLoadSuccess:function(){
		    	//alert("ok");
		    },
		    onLoadError:function(){
		    	alert("fail");
		    },
		    onDblClickRow:function(index,row){
		    	//alert("����Ŭ��");
		    	//document.write("index:"+index+", row:"+row);
		    	//alert("index:"+index+", row:"+row+", �̸�:"+row.mem_name+", hp:"+row.mem_hp);
		    },
		    onCheck:function(index,row){
		    	//alert('mem_ck'+$(this).is(':checked'));
		    	if(index>=0){
		    		$.messager.confirm('Confirm','���� �����Ұž�?',function(r){
		    			if(r){
			    			alert("ok"+r);
			    			delRow(index);	
		    			}
		    			else{
		    				alert("cancel: �۾����");	    	
		    				return;
		    			}
		    		});
		    	}
		    }
		    
		});//��ü-�Ӽ��� �Լ�
	});
</script>
	<!--============================= ���� ���� ==============================-->
	<div id="tb_member">
	<table>
	<!-- �˻���� �߰��ϱ� ���� -->
		<tr><!-- ���̵� �˻� and �޷�������Ʈ �߰� 2�� -->
			<td>
			<input id="ss" class="easyui-searchbox" style="width:200px"
        			data-options="searcher:idSearch,prompt:'���̵��Է�'"></input>
        	<!-- ����� �߰� -->
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�����	
        	<input class="easyui-datebox" labelPosition="top" data-options="formatter:myformatter,parser:myparser" style="width:150;">
			</td>
		</tr>
	<!-- �˻���� �߰��ϱ�  ��   -->
	<!--============================= ��ư �߰� ���� ============================-->
		<tr><!-- ��ư �߰� 1�� -->
			<td>	
	    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:search1()">��ȸ</a>
	    <a href="#" onclick="javascript:addRow()">���߰�</a>
	    <a href="#" onclick="javascript:delRow(0)">�����</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:add()">���</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascript:pencil()">����</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:cut()">����</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:save()">����</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-order2" plain="true" onclick="javascript:order2()">����</a>
			</td>
		</tr>
	<!--============================= ��ư �߰� ��  =============================-->			
	</table>		
	</div>
	<!--============================= ���� �� =================================-->
	<!-- ȸ�� ��� ���� -->
	<table id="dg_member"></table>
	<!-- ȸ�� ��� ��   -->
	<!-- ���ȭ�� ���� -->
	<div id="dlg_memIns" class="easyui-dialog" title="ȸ�����" data-options="iconCls:'icon-save',closed:'true',modal:'true',buttons:'#btn_dlg_memIns'" style="width:400px;height:280px;padding:10px">
        <form id="f_memIns">
        <table>
        	<tr>
        		<td width="150px">���̵�</td>
        		<td width="250px"><input class="easyui-textbox" id="mem_id" name="mem_id" size="12" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">�̸�</td>
        		<td width="250px"><input class="easyui-textbox" id="mem_name" name="mem_name" size="15" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">����</td>
        		<td width="250px"><input class="easyui-textbox"  id="mem_gender" name="mem_gender" size="5"></td>
        	</tr>
        	<tr>
        		<td width="150px">HP</td>
        		<td width="250px"><input class="easyui-textbox"  id="mem_hp" name="mem_hp" size="12"></td>
        	</tr>        	        	        	
        </table>
        </form>
    </div>
    <!-- ���ȭ�鿡 ��ư �߰��ϱ� ���� -->
    <div id="btn_dlg_memIns">
		<a href="javascript:memIns()" class="easyui-linkbutton">����</a>
		<a href="javascript:$('#dlg_memIns').dialog('close');" class="easyui-linkbutton">�ݱ�</a>
	</div>
    <!-- ���ȭ�鿡 ��ư �߰��ϱ�  ��   -->
	<!-- ���ȭ��  ��   -->
</body>
</html>















