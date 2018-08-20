<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	/* 담당자가 웹화면에 DB의 이름을 띄워달라고 요청했다면, 자바코드의 선언이 먼저다. */
	String name1 = "이순신";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주석</title>
<!-- ―――[[HEAD style : css]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
<style type="text/css">

</style>

<!-- ―――[[ import ]]―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
	<!-- css import code -->
<link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/themes/icon.css">
	<!-- jQuery script import code :: $-undifined error 주의!!! -->
<script type="text/javascript" src="/js/jquery-1.12.0.js"></script>

<!-- ―――[[HEAD script : javascript]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
<script type="text/javascript">
	function methodA(){
		alert("methodA td_word 3 : "+$("#td_word").attr("id"));
	}
</script>
</head>
<!--
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
-->
<%
	String name2 = "이성계";
%>
<body>
<!-- ―――[[BODY script : javascript]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
<script type="text/javascript">
	/* HTML문서가 스캔되고난 뒤에 (DOM구성이후) 태그에 접근하여 사용할 수 있다. */
	$(document).ready(function() {//실행문이 되게 하기위해 function을 선언해야함
		$("#d_word").text("안녕");//<div>태그영역에 글자담기
									  //속성에 접근하는 .attr("id")
		alert("methodA td_word 1 : "+$("#td_word").attr("id"));// 모르는 상태라 undifined
		/* <div>태그로 지정된 영역에 ajax로 비동기영역 설정하기 */
		//DOM에서 ajax를 별도의 스레드에 실행시켰음
		$.ajax({
			 method:"POST"//테스트는 POST방식으로 하기(GET방식은 인터셉트당함)
			,url:"webArea_ajax.jsp"//비동기통신 ajax가 이 페이지에 요청해둠
			,success:function(code){//요청한 내용이 페이지로부터 응답이 돌아오면 수행할 내용
				$("#d_word").html(code); 
				methodA();//id값 찍음
			}
		});
		//응답이 아직 도착하지 않은 상태이고, 이와별개로 순서대로 구문이 실행되기때문에 여전히 id값은 모르는 상태
		alert("methodA td_word 2 : "+$("#td_word").attr("id"));// 모르는 상태라 undifined
	})
</script>

<!-- ―――[[BODY content : html]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
<table>
	<tr>
		<td><%=name1 %></td>
		<%-- <td> <%=name3 %>선언보다 호출을 먼저 했으므로 에러발생</td> --%>
	</tr>
</table>
<div id="d_word"></div>
</body>
</html>
<%
	String name3 = "이황";
%>