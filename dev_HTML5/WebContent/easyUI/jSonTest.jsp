<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

</head>
<body>
	<script>
	/*
	 * �ڹٽ�ũ��Ʈ ���尴ü document�� PanelExam.jsp���� ��ü�� �޴� ��ü��.
	 * ���尴ü�� �ν��Ͻ�ȭ ���� ����� �� �ִ� ��ü��.
	 * �� ������ �ֻ��� ��ü�� document�̰� �� �Ʒ�<html>�±װ� ����.
	 * <html>�Ʒ�<head>�� <body>�� ����.
	 * �̷� �±׵��� ��� ��ĵ�Ͽ� DOM Ʈ�������� �׸��� ��
	 * (����?-������(����������)��, ����?-��û�� �Ͼ�� ��, ��?-ȭ�鿡 ����� �������� �Ǵϱ�)
	 */
	$(document).ready(function() { //DOM������ ������ �� - html�±׿� ���� Ʈ���� �ϼ��Ǿ��� ��
		$("#p_test").panel({
		      title:"�������Խ���",
		//      href:"http://localhost:8080/easyUI/login.jsp",
		      width:300
		   });
		   
		   $("#dg_test").datagrid({
		      title:'�۸��',
		       url:'./jSonGetBoard.jsp'
		   });
	});
	</script>
	<div id="p_test" class="easyui-panel" title="panel">
	   <table id="dg_test" class="easyui-datagrid">
		   <thead>
		        <tr>
		            <th data-options="field:'b_no',width:100">b_no</th>
		            <th data-options="field:'b_title',width:100">b_title</th>
		            <th data-options="field:'b_writer',width:100,align:'right'">b_writer</th>
		        </tr>
		    </thead>
	   </table>
	</div>
</body>
</html>