<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- 공통코드 영역 -->
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<!-- 스크립트 코드 영역 -->
	<script type="text/javascript">
		function showcontent(menu){
			//$('#content').html('당신이 선택한 메뉴는  ' + menu);
			if(menu=='login'){
				//alert("로그인");
				$("#login").show();
				$("#board").hide();
				$("#email").hide();				
			}
			else if(menu=='board'){
				//alert("계층형게시판");
				$("#login").hide();
				$("#board").show(function (){
					/* 데이터그리드 초기화 하기 */
					$("#dg_board").datagrid({
					    singleSelect:true
					   //,url:'./boardjson.jsp'
					   ,url:'http://192.168.0.24:9015/datagrid/JsonboardList.jsp'
					   ,toolbar:'#tb_board'
					   ,columns:[[
							{field:'B_NO', title:'글번호', width:70, align:'center', editor:'text'}
						   ,{field:'B_TITLE', title:'제목', width:200, align:'center', editor:'text'}
						   ,{field:'B_CONTENT', title:'내용', width:360, align:'center', editor:'text'}
						   ,{field:'B_WRITER', title:'작성자', width:120, align:'center', editor:'text'}
						   ,{field:'B_DATE', title:'작성일', width:150, align:'center', editor:'text'}
						   ,{field:'B_HIT', title:'조회수', width:100, align:'center', editor:'text'}
						]]/////////////////end of column
					});////////////////////end of datagrid
				});
				$("#email").hide();
			}
			else if(menu=='email'){
				//alert("이메일");
				$("#login").hide();
				$("#board").hide();
				$("#email").show();
			}
			//페이지 이동처리할 함수 구현하기
			/*
			@param1 : 현재 바라보는 페이지
			@param2 : 한 페이지에 뿌려질 로우 수
			*/
			function pageMove(pageNumber, pageSize){
				alert("현재 바라보는 페이지 : "+pageNumber+", 한 페이지에 출력될 로우 수 : "+pageSize);
				$("#dg_board").datagrid({
				//json은 그저 자료가 테이블로 구성되서 담긴 형태이기 때문에 원하는 조건으로 부분조회과정이 불가능함.
					//url:'./boardjson.json?pageNumber='+pageNumber+"&pageSize="+pageSize
					
				//그래서 선택되는 jsp
					//url:'./boardjson.jsp?pageNumber='+pageNumber+"&pageSize="+pageSize
					url:'http://localhost:9000/datagrid/jsonGetBoardList.jsp'
					
				})
			}
		}
	</script>

</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$("#login").show();
		$("#board").hide();
		$("#email").hide();
		$('#pn_board').pagination({
			 pageList: [10,20,30]
			,pageSize: 10
			//pageNumber : 현재 바라보고 있는 페이지 수 (1번 페이지부터~~~~)
			//pageSize : 한 페이지에 몇개 씩 뿌릴거지?
			,onSelectPage: function(pageNumber, pageSize){
				alert(pageNumber+", "+pageSize);
			}
		});
	});
</script>
<!-- 화면 처리 영역 -->
	<h2>계층형 게시판 구현</h2>
	<table border="1" borderColor="gray">
		<tr>
			<td>
		<div class="easyui-layout" style="width:1200px;height:550px;">
			<div region="west" split="true" title="Navigator" style="width:150px;height:200px">
				<p style="padding:5px;margin:0;">업무관리</p>
				<ul>
					<li><a href="javascript:void(0)" onclick="showcontent('login')">로그인</a></li>
					<li><a href="javascript:void(0)" onclick="showcontent('board')">계층형게시판</a></li>
					<li><a href="javascript:void(0)" onclick="showcontent('email')">이메일</a></li>
				</ul>
			</div>
			<div id="content" region="center" title="EASYUI솔루션" style="padding:5px;">
				<div id="login" style="padding:5px;">
					<table id="p_login" class="easyui-panel" title="로그인"></table>
				</div>	
				<div id="board" style="padding:5px;">
					<table id="dg_board" class="easyui-datagrid" title="계층형 게시판"></table>
					<!-- 페이지 네이션 바 추가 시작 -->
						<div id="pn_board" class="easyui-pagination" style="width:1022px;background:#efefef;border:1px solid #ccc;">
						</div>
					<!-- 페이지 네이션 바 추가  끝  -->
					<div id="tb_board">
					    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:boardSearch()">조회</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:boardAdd()">등록</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascript:boardUpd()">수정</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:boardDel()">삭제</a>
					</div>
				</div>	
				<div id="email" style="padding:5px;">
					<table id="p_email" class="easyui-panel" title="이메일"></table>
				</div>	
			</div>			
			</td>
		</tr>
	</table>
</body>
</html>