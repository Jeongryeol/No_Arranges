<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이메일</title>
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
</head>
<body>
<script type="text/javascript">

$(document).ready(function() {
	alert("11");
	$('#dg').datagrid({
	    columns:[[
	        {field:'b_no',title:'Code',width:100},
	        {field:'b_title',title:'Name',width:100},
	        {field:'b_writer',title:'Price',width:100,align:'right'}
	    ]],		
		onLoadSuccess:function(){
			document.write("success");
		},
		onLoadError:function(){
			document.write("error");
		}
	});
});
</script>
<h2>이메일</h2>
<table id="dg" style="width:400px;height:250px" data-options="url:'./jSonGetBoard.jsp'">
<!--     <thead>
        <tr>
            <th data-options="field:'b_no',width:100">내가</th>
            <th data-options="field:'b_title',width:100">이러고</th>
            <th data-options="field:'b_writer',width:100,align:'right'">산다</th>
        </tr>
    </thead> -->
</table>
        <!-- data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"> -->
   <!--  <thead>
        <tr>
            <th data-options="field:'b_no',width:100">Code</th>
            <th data-options="field:'b_title',width:100">Name</th>
            <th data-options="field:'b_writer',width:100,align:'right'">Price</th>
        </tr>
    </thead> -->
<!--     <tbody>
        <tr>
            <td>001</td><td>name1</td><td>2323</td>
        </tr>
        <tr>
            <td>002</td><td>name2</td><td>4612</td>
        </tr>
    </tbody> -->
</body>
</html>