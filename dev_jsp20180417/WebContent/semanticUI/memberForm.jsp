<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	var g_id=0;
	var g_dong;//��������-����ڰ� �Է��� ���̸��� ���� - searchbox
	function memberInsert(){
		if(g_id==0){
			alert("���̵� �ߺ� üũ �ϼ���.");
			return;
		}else if(g_id==1){
			if($("#mem_id").val()==null || $("#mem_id").val().length==0){
				alert("���̵� �Է��ϼ���.");
				$("#mem_id").focus();
				return;
			}
			else if($("#mem_pw").val()==null || $("#mem_pw").val().length==0){
				alert("����� �Է��ϼ���.");
				return;
			}
			else if($("#mem_name").val()==null || $("#mem_name").val().length==0){
				alert("�̸��� �Է��ϼ���.");
				return;
			}
			else{
				$("#f_member").attr("method", "post");
				$("#f_member").attr("action", "./member.kos?gubun=memINS");
				$("#f_member").submit();
			}
		}
	}
	function idCheck(){
		g_id = 1;
		var param = "gubun=idCheck&mem_id="+$("#mem_id").val();
		$.ajax({
			method:"POST",
			url:"./member.kos",
			data:param,
			success:function(result){
				var jsonDoc = JSON.parse(result);
  				for(var i=0;i<jsonDoc.length;i++){
					if(-1==jsonDoc[i].sstatus){
						alert("���̵� ����� �� �ֽ��ϴ�.");
						$("#loginForm").show();
						$("#mem_pw").focus();
						return;
					}
					if(2==jsonDoc[i].sstatus){
						alert("���̵� ����� �� �����ϴ�.");
						$("#loginForm").show();
						$("#mem_id").focus();
						return;
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
<div id="p_member" class="easyui-panel" title="ȸ������" 
        style="width:650px;height:390px;padding:10px;background:#fafafa;"
        data-options="closable:true,
                collapsible:true,minimizable:true,maximizable:true">
<script type="text/javascript">
	$('#p_member').panel({
	    onClose:function(){
	        //alert('close....');
	        self.close();
	    }
	}); 
</script>                
<form id="f_member">      
<table align="center">
	<tr>
		<td width="100px">���̵�</td>
		<td width="450px">
		<input id="mem_id" name="mem_id" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px">
		<a href="javascript:idCheck();" class="easyui-linkbutton">�ߺ�üũ</a> 
		</td>
	</tr>
	<tr>
		<td width="100px">��й�ȣ</td>
		<td width="450px"><input id="mem_pw" name="mem_pw" class="easyui-passwordbox" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">�̸�</td>
		<td width="450px"><input id="mem_name" name="mem_name" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">�����ȣ</td>
		<td width="450px"><input id="zipcode" name="zipcode"></td>
	</tr>
	<tr>
		<td width="100px">�ּ�</td>
		<td width="350px"><input id="address" name="address"></td>
	</tr>
	<script type="text/javascript">
		$('#zipcode').searchbox({
		    searcher:function(value,name){
		        //alert(value + "," + name);
		        if(value==null || value.length==0){//�� ���̸� �Է¾�����?
		        	alert("���̸��� �Է��ϼ���.");
		        	return;
		        }else{
			        $('#d_zipcode').dialog('open');
			    //datagrid�� �±׷� ����� ��� �ڹٽ�ũ��Ʈ���� �������� Ȱ���� �Ұ�    
			    //������ ���� - ȭ��ܿ��� �Է¹��� �� ó���� �� ���� ���� ó���ϴ� ��� �� ã�ƺ�����.......
			        $('#dg_zipcode').datagrid({
				    url:'./member.kos?gubun=zipcode&dong='+value,
				    columns:[[
				        {field:'ZIPCODE',title:'�����ȣ',width:120},
				        {field:'ADDRESS',title:'�ּ�',width:450},
				    ]],
				    onDblClickRow:function(index,row){
//easyui���� ����ϴ� ���̾�αװ� �� ������ �ҽ��� ����־ �θ�â�� ������ API���̵� �ٷ� ������ �� �ִ�.				    	
				    	//alert("index:"+index+", row:"+row+", �̸�:"+row.ADDRESS);
//textbox�� ���ο� ������ ������ �� setValue�Ӽ��� ����� ��.
						//������ ���̸��� ������ textbox�� ������ �����ȣ ����ó��
				    	$("#zipcode").textbox('setValue',row.ZIPCODE);
				    	$("#address").textbox('setValue',row.ADDRESS);
				    	//�ּ� �˻��� �������Ƿ� ���̾�α�â�� closeó��
				    	$('#d_zipcode').dialog('close');
				    },
				});		        	
		        }
		    },
		    prompt:'���� �Է��ϼ���.'
		});
	</script>	
	<script type="text/javascript">
		$('#address').textbox({
		    prompt:'�ּ������� �ڵ����� ó���غ���',
		    width:'400px'
		});
	</script>		
</table>          
<center>
<a href="javascript:memberInsert();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">����</a>  
</center>
</form>    
</div>
<!-- �����ȣ �˻� ���̾�α� ���� ���� -->
<div id="d_zipcode">
	<table id="dg_zipcode"></table>
</div>
<script type="text/javascript">
	$('#d_zipcode').dialog({
	    title: '�����ȣ �˻� ����',
	    width: 500,
	    height: 350,
	    closed: true,
	    cache: false,
	    //href: './member.kos?gubun=zipcode',
	    modal: true
	});
</script>
</body>
</html>









