<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
	페이지 요청하기
	1) loaction.href = "";
	2) ajax에서 요청할 때
		url:
	3) form 전송할 때
	4) respoonse.sendRedirect("");
	5) RequestDispatcher view = request.getRequestDispatcher("");
	   view.forward(request, response);
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>페이지 요청하는 5가지 방법</title>

	<!-- jQuery script import code :: $-undifined error 주의!!! -->
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
	//방법 1
	//location.href = "http://www.naver.com/";
	//location은 js(javascritpt 내장객체)
</script>
<input type="button" onclick="pageAjax()" value="ajax로 화면이동" />
<div id="insert_here"></div>
</body>
</html>