<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
	������ ��û�ϱ�
	1) loaction.href = "";
	2) ajax���� ��û�� ��
		url:
	3) form ������ ��
	4) respoonse.sendRedirect("");
	5) RequestDispatcher view = request.getRequestDispatcher("");
	   view.forward(request, response);
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ��û�ϴ� 5���� ���</title>

	<!-- jQuery script import code :: $-undifined error ����!!! -->
<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>

<script type="text/javascript">
	function pageAjax(){
		$.ajax({
			 url:"www.naver.com"
			,method:"POST"
			,success:function(htmlCode){
				$(insert_here).html(htmlCode);
			}
		});
	}
</script>

</head>
<body>
<script type="text/javascript">
	//��� 1
	//location.href = "http://www.naver.com/";
	//location�� js(javascritpt ���尴ü)
</script>
<input type="button" onclick="pageAjax()" value="ajax�� ȭ���̵�" />
<div id="insert_here"></div>
</body>
</html>