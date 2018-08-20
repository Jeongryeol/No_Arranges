<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� �̵��ϴ� 6���� ��� ����</title>

<!-- ������[[ import ]]�������������������������������������������������������������������������������������������������������������������������������������������������������������������� -->
	<!-- css import code -->
<link rel="stylesheet" type="text/css" href="../../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../demo/demo.css">
	<!-- jQuery script import code :: $-undifined error ����!!! -->
<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>
	<!-- EasyUI for jQuery script import code -->
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>

<!-- ������[[HEAD script : javascript]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<script type="text/javascript">
	/* �ڹٽ�ũ��Ʈ �������̵��ϱ� */
	function moveJsc(){
		location.href="target.jsp";
	}
	/* ajax �������̵��ϱ�  : �ܺ��� �������� �� ������ ������ ��*/
	function moveAjax(){
		$.ajax({
			 url:"target.jsp"	//������
			,method:"post"		//���۹��
			,success:function(htmlCode){//��û������ ������������ HTML�ڵ尡 �������� ���ƿ�
				$(d_ajax).html(htmlCode);//�ش���ġ(div)�� �ڵ带 ������ 
			}
		});
	}
	/* EasyUI ������ �̵��ϱ�  */
	function moveEasyui_getEmpList(){
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
</script>
</head>
<!--
��������������������������������������������������������������������������������������������������������������
-->
<body>
<!-- ������������������������������������������������������������������������������������������������������������������������������������������������ -->
	<!-- HTML �ּ�  	-->
	<%-- JSP �ּ� 		--%>
	<%! /*��Ŭ�����̼� */		%>
	<% 	/*��ũ��Ʋ�� */	 	%>
	<%=	/* �ͽ��÷��̼� */" "	%>
<!-- ������������������������������������������������������������������������������������������������������������������������������������������������ -->

	<%-- jsp �Ǵ� servlet �������̵��ϱ� --%>
	<% 	
	//��ũ��Ʋ���� ���� ����ǹǷ� �� �������� ���ڸ��� �ٷ� �������� �����Ƿ� ���� �������� �� �� ����.
			//servlet�� ȣ���� ��, ���ε� url�ּҸ� �������� �Է�
		//response.sendRedirect("../login.do");
			//jsp�� ȣ���Ҷ�, jsp���� ��θ� �������� �Է�
		//response.sendRedirect("target.jsp");
	%>
	
	<!-- �ڹٽ�ũ��Ʈ �������̵��ϱ� [HEAD script �ʼ�����!!] -->
	<input type="button" value="�ڹٽ�ũ��Ʈ�� �Լ��� �������̵�" onclick="moveJsc()">
	
<br><br>
	<!-- ajax �������̵��ϱ�  : �ܺ��� �������� �� ������ ������ �� [HEAD script �ʼ�����!!]-->
	<input type="button" value="���۽� �Լ��� �������̵�" onclick="moveAjax()">
	<div id="d_ajax"></div>
	
<br><br>
	
	<!-- <a>�±׷� �������̵��ϱ� -->
	<a href="http://www.10x10.co.kr/">
		<img src="./tenbyten.png" border="0">
	</a>
	
<br><br>
	<!-- <form>�±׷� �������̵��ϱ� -->
	<form action="target.jsp" method="get">
		<input type="submit" value="form�±׷� �������̵��ϱ�"/>
	</form>

<br><br>
	<!-- EasyUI�� �������̵��ϱ� [import ��������!!] -->
	<input type="button" value="EasyUI�� �������̵�" onClick="moveEasyui_getEmpList()">
	<table id="dg_emp"></table>
	
</body>
</html>