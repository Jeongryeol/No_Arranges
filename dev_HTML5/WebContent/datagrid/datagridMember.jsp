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
	<link rel="stylesheet" type="text/css" href="../themes/icon.css?1">
	<link rel="stylesheet" type="text/css" href="../demo/demo.css">

<!-- jquery ����� easyUI +html + CSS + JS
	 1. �±׿� �����ϴ� ���
	 2. �ڹٽ�ũ��Ʈ�� �����ϴ� ���  
-->

<!-- ������ �̺�Ʈó���� �ϱ����� ����� ���� : Java�� ������ �κ�!! -->
	<script type="text/javascript">
		//�˻�ó��
		function idSearch(){
			alert("�˻�");
		}
		
		//��ȸó��
		function search1(){
			//alert("��ȸȣ�⼺��");//Ȯ�ο� //document.write(); �̰��� ���� ��ü �ʱ�ȭ��
			$("#dg_member").datagrid({
				url:"../json/memberJSON.json",
				rownumbers:true
			});
		}
		//���߰�
		function addRow(){
			$('#dg_member').datagrid('appendRow',{
				name: 'new name',
				age: 30,
				note: 'some messages'
			});
		}
		//�����
		function delRow(index){
			alert("������ �ο��� index:"+index);
			$("#dg_member").datagrid('deleteRow',index);
		}
		//���ȭ�� ��ư������ ����ó��
		function add(){
			//alert("���ȣ�⼺��");//Ȯ�ο�
			$("#dlg_memIns").dialog('open');//������ �� ǥ���� ���̾�α�â�� ���
		}
		//����ó��
		function edit(){
			alert("����ȣ�⼺��");
		}
		//����ó��
		function cut(){
			//alert("����ȣ�⼺��");//Ȯ�ο�
/* 			$("#dg_member").datagrid({
				onSelect:function(index,row){
					//alert(������ �ο츦 �����ϼ���.);
					delRow(index);
				}
			});*/
			
/* 			$("#dg_member").datagrid({'selectOnCheck':$(this).is('false')});
			$("#dg_member").datagrid({'checkOnSelect':$(this).is('checked')});
			//EasyUI�� datagrid�� getSelected �޼ҵ带 �߰��ϰ�, ���� �����ϴ� ���
			//���� �̸�  = $("���id").������('�޼ҵ��'); 
			var row = $("#dg_member").datagrid('getSelected');//������Ʈ
			*/
			
			//������ �ο� ������ �����ö�
			var row = $("#dg_member").datagrid('getSelected');//������Ʈ
			if(row==null){
				alert("������ ���ϴ� ����� �������ּ���.");
				return;//cut�Լ��� Ż����!!!
			}else{
				//���� ������ �ο��� �ε��� ������ �� �� �ִٸ� �����ٵ�....
				var sindex = $("#dg_member").datagrid('getRowIndex',row);
				alert(row);//Object...��� ���� ��
				alert(row.mem_id+', index������? '+sindex);
				//���⿡ �ٵ𿡼� ������ �����ϴ°ͱ��� �ְ������.. �����??
			}
			
		}
		//����ó��
		function save(){
			alert("����ȣ�⼺��");//Ȯ�ο�
		}
		//�ܡܡ��̹����� CSS�����ܹ�ư �����
		function order2(){
			alert("����ȣ�⼺��")
		}
		//���ȭ��(���̾�α�)���� �����ư �����ϱ�
		function memIns(){
			//alert("����  ����Ŭ������ �����ؼ� INSERT�� ó���ϴ� �ڵ尡 ���� ��ġ");
			//$("#f_memIns").attr("method","get");//get��� ���� : ��ΰ���
			$("#f_memIns").attr("method","post");//post��� ���� : �������(post����� �ѱ�ó���ϴ� ���ڵ� ��ġ�� �޶� ������)
			$("#f_memIns").attr("action","./memInsAction.jsp");//jsp���� DB�� INSERTó���� ��
			$("#f_memIns").submit();//�̶� �������PC���� ���ϼ����� ������ �Ͼ.
			$('#dlg_memIns').dialog('close');//�����ϰ��� �ݰԵ�
		}
		
		/* ������������ �޷�����ϱ����� �Լ������ */
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
	</script>	
</head>
<body>
<!--

	ȸ����������
	-ȸ������ 	~(Oracle)INSERT INTO ȸ������ VALUES(?,?,?,?); >>> �Ķ���Ͱ� �ʿ��ϴ�!!
			~�޼ҵ��̸�(String id, String name, String gender, String phoneNum)
	
	-ȸ��Ż�� ~(Oracle)DELETE FROM ȸ������ WHERE mem_id=? >>�Ķ���� 1��(PK)
	
	-ȸ���������� ~(Oracle)UPDATE ȸ������  SET address =? WHERE mem_id=?
	
	-ȸ��������ȸ  ~(Oracle)Select
	
	
	SQL���� 4�ܰ�
	1) �Ľ�
	2) �����ȹ
	3) ��Ƽ������ �����ȹ �ѱ�
	4) open....cursor....fetch....close
	
	�������� :: ����̱⶧����, ��� �� �ٸ� �ڵ�� �ν�
	
	��������(PreparedStatement) :: 1,2�ܰ轺ŵ (������ �پ��� ) >> SQL����ӵ� ��� >> 
	
	���ν����� ��������(CallableStatement)
	
	
	View����(Client)~UI :: xxxx.jsp
		�����ư(�̺�Ʈó��-js-jqeury)
		��������(WerServer-Tomcat & DBServer-Oracle)
		����(�Ķ���͸� �Ѱܾ��Ѵ�) : testbox�� �Էµ� ���� ������ �ѱ��~~~
		������ ���۹��(get(�ּ�â ��γ���-�������)|post(�������))
		
		ȭ����� ������(<form (���۹��)method="get|post" (�̺�Ʈó��)action="../xxx.jsp|javacode")
		�������� jquery API�� �غ���..!
		
		<form id="�̸�" method"got|post> action="xxxx.jsp | xxxx.java(����-HTTP���)"
			�Է�â 4��( ���̵�, �̸�, ����, HP )
		</form>
		
		�ڹٽ�ũ��Ʈ�� ����?
		document, detElementByid("f_member).method="get';
	
		jquery�� �ٲٸ�?
		$("#f_member").attr("method","get");
		$("#f_member").attr("action","xxx.jsp");
		$("#f_member").submit();//�̶� �������PC���� ���ϼ����� ������ �Ͼ.
		
		xxx.jsp
		
		memberAction.jsp
		
 -->
	<script type="text/javascript">
		/* �� jsp���� ��ü�� ����Ű�� ���尴ü document */
		$("document").ready(function() {
			$("#dg_member").datagrid({//��ü-�Ӽ��� �Լ��� �Ŵ��� �� �ִ�. ���๮���� ��ȭ��Ű��
				width:502,
				height:450,
				title:"ȸ������",
				toolbar:"#tb_member",
			//��ȸ�� ������ ���̵��� ��������(�ٵ𿡼� ó���Ǵ� json�� ���������� ��)
			/* 	url:"../json/memberJSON.json", */
			    columns:[[
			        //�ڹٽ�ũ��Ʈ�� ���ؼ�, boolean�� 0�� ������ ��� ���� true�̴�. 0�� false��
			    	{field:'mem_ck',title:'����',width:50,checkbox:'true',align:'center'},
			        {field:'mem_id',title:'ID',width:100,align:'center'},
			        {field:'mem_name',title:'������',width:100,align:'center'},
			        {field:'mem_gender',title:'����',width:100,align:'center'},
			        {field:'mem_hp',title:'��ȣ�ڿ���ó',width:172,align:'center'}
			    ]],
			    onDblClickRow:function(index,row){
			    	alert("index : "+index+", row : "+row.mem_name
			    			+", hp : "+row.mem_hp);
			    }/* ,
			    onCheck:function(index,row){
			    	alert('mem_ck'+$(this).is('checked'));
			    	if(index>=0){
			    		$.messager.confirm('confirm','���� �����Ұž�?',function(r){
			    			if(r){
			    				alert('mem_id+"�� ������ �Ϸ�Ǿ����ϴ�.");
			    				delRow(index);
			    			}
			    			else{
			    				alert(r+"�� ������ ��ҵǾ����ϴ�.");
			    			}
			    		});
			    	}
			    } */
	 		    //checkOnSelect:true
			    //onLoadSuccess:function(){alert("����")},
			    //onLoadError:function(){alert("����")}
			});
			///////////////////////////////////////////////end of datagird
			$('#pg_top').pagination({
			    total:100,
			    pageSize:10
			});
		});
		
	</script>
		<div id="tb_member">
			<table>
				<tr><!-- 2��  : ���̵� �˻� &�޷�������Ʈ �߰�-->
					<td>
				<!-- =============================[�˻���� �߰��ϱ� ����]============================= -->
						<input id="ss" class="easyui-searchbox" style="width:230px"
		        				data-options="searcher:idSearch,prompt:'���̵��Է�'"></input>
				<!-- =============================[�˻���� �߰��ϱ� ��]============================= -->
						<!-- ����� �߰� -->
						&nbsp;&nbsp;����� :&nbsp;
				<!-- =============================[�޷� �߰��ϱ� ��]============================= -->
						<!--��ü���� �ִ� div 
						<div id="cal_date" class="easyui-calendar" style="width:250px;height:250px;"></div> -->
						<!-- �ζ��ο���� span 
						<span id="cal_date" class="easyui-calendar" style="width:50%;height:250px;"></div>-->
						<input class="easyui-datebox" labelPosition="top" data-options="formatter:myformatter,parser:myparser" style="width:35%;">
				<!-- =============================[�޷� �߰��ϱ� ��]============================= -->
					</td>
				</tr>
			</table>
			
			<!--=============================[���ٹ�ư �߰� ����]============================= -->
			<tr><!-- 1�� : ��ư�߰� -->
			<td>
				<!-- themes/icons.css ���� ������ ��ȸ�ϰ� �̸����� ��ũ�߰�����-->
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"	plain="true" onclick="javascript:search1()">��ȸ</a>
				<a href="#"	onclick="javascript:addRow()">���߰�</a>
				<a href="#"	onclick="javascript:delRow()">�����</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-add" closed="true" plain="true" onclick="javascript:add()">���</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-edit" plain="true"onclick="javascript:edit()">����</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:cut()">����</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-save" plain="true"onclick="javascript:save()">����</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-order2" plain="true"onclick="javascript:order2()">��ũ</a>
			</td>
			</tr>
		</div>
		<!--=============================[���ٹ�ư �߰� ��]============================= -->
	<!-- =============================[�˻���� �߰��ϱ�  ��]============================= -->
	
	
	<table id="dg_member" class = "easyui-datagrid" style = "width : height:" url = "../json/memberJSON.json ">
	</table><!-- ����� body��ũ��Ʈ���� ���ǵ� ������ ���̺��� ǥ���� -->

	<!--====	=========================[ȸ����� ����]=============================-->
<!-- 	<thead id="dg_member">
		<tr>
			<th width="50px" checkbox='tree'></th>
			<th width="120px" feild='mem_id'>���̵�</th>
			<th width="150px" feild='mem_name'>�̸�</th>
			<th width="80px" feild='mem_gender'>����</th>
			<th width="150px" feild='mem_hp'>HP</th>
		</tr>
	</thead> -->
	<!--=============================[ȸ����� ��]=============================-->
	
	<!--=============================[���ȭ��(���̾�α�) ���� ]=============================-->
	<div id="dlg_memIns" class="easyui-dialog" title="ȸ�����" style="width:400px;height:220px;"
        data-options="iconCls:'icon-save',closed:true,resizable:true,modal:true,buttons:'#btn_dlg_memIns'">
        <!-- ���±׷� ������ �ڷ�ű�� -->
        <form id="f_memIns">
        <!-- ���� ���� ���߾� �Է�â�� �ֱ����� Table�� �߰���-->
        <!--=============================[���ȭ�鿡 ������ �ڸ� �ֱ� ����]=============================-->
        <table>
        	<tr><!-- ����� �ִ� ����� : &nbsp; -->
        		<td width="150px">���̵�</td>
        		<td width="250px"><input class="easyui-textbox" style="width:230px" name="mem_id" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">�̸�</td>
        		<td width="250px"><input class="easyui-textbox" style="width:150px" name="mem_name" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">����</td>
        		<td width="250px"><input class="easyui-textbox" style="width:150px" name="mem_gender"></td>
        	</tr>
        	<tr>
        		<td width="150px">����ó</td>
        		<td width="250px"><input class="easyui-textbox" style="width:230px" name="mem_hp"></td>
        	</tr>
        </table>
        </form>
	</div>
    <!-- =============================[���ȭ�鿡 ������ �ڸ� �ֱ� ��]=============================-->
    
	<!-- =============================[���ȭ�鿡 ��ư�ֱ� ���� ]=============================-->
	<div id="btn_dlg_memIns">
		<a href="javascript:memIns()" class="easyui-linkbutton">����</a>
		<a href="javascript:$('#dlg_memIns').dialog('close')" class="easyui-linkbutton">�ݱ�</a>
	</div>
	<!-- =============================[���ȭ�鿡 ��ư�ֱ� �� ]=============================-->
	
	<!-- =============================[���������̼� ����]============================= -->
	<div id="pg_top" style="background:#efefef;border:1px solid #ccc;width:496px"></div>
	<!-- =============================[���������̼� ��]============================= -->
</body>
</html>