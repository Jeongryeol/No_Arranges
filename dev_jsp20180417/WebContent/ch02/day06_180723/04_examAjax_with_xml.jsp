<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>xml ������ �޾Ƽ� ajax�� �о�� + jQuery</title>

<!-- ������[[ import ]]�������������������������������������������������������������������������������������������������������������������������������������������������������������������� -->

	<!-- jQuery script import code :: $-undifined error ����!!! -->
	<script type="text/javascript" src="/js/jquery-1.12.0.js"></script>

</head>
<!--
��������������������������������������������������������������������������������������������������������������
-->
<body>
<!-- ������[[BODY content]]������������������������������������������������������������������������������������������������������������������������������������������������������������������ -->
<script type="text/javascript">
	$.ajax({
		 method:"get"
		,url:"./xmlExample2.xml"
		,dataType:"xml"
		,success:function(result){
			//alert(result);
			// [object XMLDocument]
			// �� ���·δ� XML������ ������ �� ����. ȣȯ�ϴ� �ڵ带 �� �����ϱ� �ٶ��ϴ�.
		
			/* [][�߿�]] xml������ ��ũ��Ʈ�ڵ�� �ٲپ� �������� ����ϴ� �ڵ� */
			$(result).find('deptList').each(function(){
				//alert("�ο찡 ����ߴ�?");//3��
				var $entry = $(this);
				alert($entry.find('deptno').text()
				+", "+$entry.find('dname').text()
				+", "+$entry.find('loc').text()
					 );
			});		
		}
		,error:function(xhrObject){
			alert(xhrObject.responseText);
		}
	})
</script>
</body>
</html>