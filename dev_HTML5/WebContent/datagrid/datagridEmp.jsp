<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��������ý���</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css?1">
	<link rel="stylesheet" type="text/css" href="../demo/demo.css">
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	//���ο� ������ ��������
	function getEmpList(){
		/* �����ͱ׸��� �ʱ�ȭ �ϱ� */
		$("#dg_emp").datagrid({
		    //url:'../json/empJSON.json'
		    url:'./jsonEmpList.jsp'
		   ,singleSelect:true
		   ,columns:[[
				/* ���̺� ��� �ʱ�ȭ [�����ȣ ����� JOB �Ի����� �μ���ȣ] */
				{field:'empno', title:'�����ȣ', width:100, align:'center', editor:'text'}
			   ,{field:'ename', title:'�����', width:120, align:'center', editor:'text'}
			   ,{field:'job', title:'JOB', width:150, align:'center', editor:'text'}
			   ,{field:'hiredate', title:'�Ի�����', width:180, align:'center', editor:'text'}
			   ,{field:'dname', title:'�μ���', width:100, align:'center', editor:'text', hidden:'true'}
			   ,{field:'deptno', title:'�μ���', width:200, align:'center',  
				 editor:{
					 type:'combobox'
					,options:{
						valueField:'deptno'//���� ������ �Ѿ�� �ʵ�
					   ,textField:'dname'//ȭ�鿡 ��µǴ� �ʵ�
					   ,url:'./jsonDeptList.jsp'
/* 					   ,data:[{
						    "deptno":10,
						    "dname":"ACCOUNTING"
						},{
						    "deptno":20,
						    "dname":"RESEARCH"
						},{
						    "deptno":30,
						    "dname":"SALES"
						    //"selected":true
						},{
						    "deptno":40,
						    "dname":"OPERATIONS"
						}] */
					}
				 }/////////////end of editor
			   }///////////////end of field
			  ,{field:'action',title:'Action',width:80,align:'center',
	                formatter:function(value,row,index){
	                    if (row.editing){
	                        var s = '<a href="javascript:void(0)" onclick="saverow(this)">Save</a> ';
	                        var c = '<a href="javascript:void(0)" onclick="cancelrow(this)">Cancel</a>';
	                        return s+c;
	                    } else {
	                        var e = '<a href="javascript:void(0)" onclick="editrow(this)">Edit</a> ';
	                        var d = '<a href="javascript:void(0)" onclick="deleterow(this)">Delete</a>';
	                        return e+d;
	                    }
	                }
	            }//////////////end of action field
			]]/////////////////end of column
		//Eventó��	
		,onSelect:function(index,row){
			//alert("index:"+index+", row:"+row+", row.empno:"+row.empno);
			$("#tb_empno").textbox('setValue',row.empno);
			$("#tb_ename").textbox('setValue',row.ename);
			$("#tb_job").textbox('setValue',row.job);
			$("#tb_hiredate").textbox('setValue',row.hiredate);
			$("#tb_deptno").textbox('setValue',row.deptno);
		}
        ,onEndEdit:function(index,row){
            var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'productid'
            });
            row.productname = $(ed.target).combobox('getText');
        },
        onBeforeEdit:function(index,row){
            row.editing = true;
            $(this).datagrid('refreshRow', index);
        },
        onAfterEdit:function(index,row){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
        },
        onCancelEdit:function(index,row){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
        }
		});////////////////////end of datagrid
	}
	function getRowIndex(target){
	    var tr = $(target).closest('tr.datagrid-row');
	    return parseInt(tr.attr('datagrid-row-index'));
	}
	function editrow(target){
	    $('#dg_emp').datagrid('beginEdit', getRowIndex(target));
	}
	function deleterow(target){
	    $.messager.confirm('Confirm','Are you sure?',function(r){
	        if (r){
	            //����ڰ� ȯ�鿡�� ������ �ο� ���� �������� : ������ �ο��� object������
	            //���� 
	        	//$('#dg_emp').datagrid('deleteRow', getRowIndex(target));
	            location.href="./empDelAction.jsp?empno=9958";
	            //getEmpList();
	        }
	    });
	}
	function saverow(target){
	    $('#dg_emp').datagrid('endEdit', getRowIndex(target));
	}
	function cancelrow(target){
	    $('#dg_emp').datagrid('cancelEdit', getRowIndex(target));
	}	
	</script>
</head>
<body>
<script type="text/javascript">
//�̹��� ��ü�� �޾��ִ� ��ü�� �ִ�.- document - html - head[title�±�]&body[table]
//URL(Uniform Resource Locator)~������,IP�ּ�
/*
 * ready�Լ� : �����(���������)�� URL�� ��û�� �ش� ��������
 				������(ũ�� ��)�� ��û�޾Ƽ�
 				����(����v8.5)�κ��� ������ �޾Ƽ� ����� ����Ѵ�.
 				������ �޾Ҵ�=Ŭ���̾�Ʈ�� �ٿ�ε尡 �Ͼ��(get���-����,�������,���ͼ�Ʈ �߻�[�������� ������ �ȵ�])
 				
 				������ �ް���(�ٿ�ε尡 �Ͼ��)
 				��(DOM, Document Object Model : html-head-body�� Ʈ������)������ ������.
 				
 				�̹� �ٿ�ε尡 �Ϸ�� ���·� Ȱ��ȭ�� �Ǿ� �ֱ� ������
 				ready(function(){ ���๮, �̺�Ʈó��, �Ӽ��߰� ���� })
 				
 				�̺�Ʈ�� ó���ϱ� �ʿ��� ��� : �±��̸� Ȥ�� �±׾��̵�, �Ӽ��� ��
 				��, �� ����� ���ٰ����ؾ��ϱ� ������ DOM������ �Ϸ�Ǿ� �־�� �Ѵ�.
 				
 */
	$(document).ready(function (){
		getEmpList();
	});////////////////////////end of ready
</script>
	<table id="dg_emp"></table>
<!-- ��⿡ �ؽ�Ʈ�ڽ� 2���� �߰����ּ���. -->
<input class="easyui-textbox" id="tb_empno" style="width:100px">	
<input class="easyui-textbox" id="tb_ename" style="width:150px">	
<input class="easyui-textbox" id="tb_job" style="width:150px">	
<input class="easyui-textbox" id="tb_hiredate" style="width:150px">	
<input class="easyui-textbox" id="tb_deptno" style="width:100px">
<!-- id�ɼ� : UI(Client)���� ����ϴ� �̸�  ������ $('#____')
   / name�ɼ� : Server���� ����ϴ� �̸�  ������ request.getParameter("name") -->	
</body>
</html>











