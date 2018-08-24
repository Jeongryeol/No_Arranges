<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글목록</title>
<!-- 공통 코드 include처리 -->
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	function bSearch(){
	//지금의 경우 이미 DOM구성이 완료되었을 때 액션을 이미 탄 상태가 되고 그 결과는 jsonBoardList.jsp로 응답이 나온다.
/* 		$("#f_search").attr("method","get");
		$("#f_search").attr("action","./mvcBoard.bd?gubun=getBoardList");
		$("#f_search").submit(); */
		$("#dg_list").datagrid({
		    url:'./mvcBoard.bd?gubun=getBoardList&cb_type='+$("#cb_type").val()+'&sb_keyword='+$("#sb_keyword").val()		
		});
	}
	function boardInsert(){
		$("#dl_boardInsert").dialog('open');
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#dg_list").datagrid({
		    url:'./mvcBoard.bd?gubun=getBoardList',
		    columns:[[
		        {field:'B_NO',title:'글번호',width:100, align:'center'},
		        {field:'B_TITLE',title:'제목',width:400, align:'center'},
		        {field:'B_NAME',title:'이름',width:100, align:'center'},
		        {field:'B_FILE',title:'첨부파일',width:150, align:'center'},
		        {field:'B_HIT',title:'조회수',width:100, align:'center'},
		    ]]			
		});
		$('#pg_board').pagination({
		    total:2000,
		    pageSize:10
		});
	});
</script>
<table align="center" width="900px">
<!-- 검색 조건 화면 추가하기 -->
<form id="f_search">
	<tr>
		<td>
		<select id="cb_type" class="easyui-combobox" name="cb_type" style="width:200px;">
		    <option value="b_title">제목</option>
		    <option value="b_content">내용</option>
		    <option value="b_name">작성자</option>
		</select>
		<input id="sb_keyword" name="sb_keyword" class="easyui-searchbox" style="width:300px"
        data-options="searcher:bSearch,prompt:'Please Input Value'"></input>
		</td>
	</tr>
</form>	
<!-- 글쓰기 버튼 추가 -->	
	<tr>
		<td align="left">
        <a id="btn_write" href="javascript:boardInsert()" class="easyui-linkbutton">글쓰기</a>
		</td>
	</tr>	
<!-- 목록처리 화면 추가하기(datagrid) -->
	<tr>
		<td>
		<table id="dg_list"></table>
		</td>
	</tr>	
<!-- 페이지 네이션 처리(pagination) -->
	<tr>
		<td>
		<div id="pg_board" style="background:#efefef;border:1px solid #ccc;">
		</div>		
		</td>
	</tr>	
</table>
<!-- 
글쓰기 다이얼 로그 처리(writeForm.jsp화면 처리)
처음엔 닫힌 상태로 있다가 글쓰기 버튼을 클릭하면 창을 띄움.
 -->
<div id="dl_boardInsert" class="easyui-dialog" title="글쓰기" style="width:600px;height:350px;"
     data-options="resizable:true,modal:true,closed:true">
    <table align="center">
	    <form id="b_insert">
	    	<tr>
	    	<td>제목</td>
	    	<td><input id="b_title" name="b_title" data-options="width:'250px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>작성자</td>
	    	<td><input id="b_name" name="b_name" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>내용</td>
	    	<td><input id="b_content" name="b_content" data-options="multiline:'true', width:'350px', height:'90px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>비밀번호</td>
	    	<td><input id="b_pwd" name="b_pwd" class="easyui-passwordbox"></td>
	    	</tr>	    	
	    </table>
	    <table align="center">
	    	<tr>
	    	<td>
				<a href="javascript:boardAction()" class="easyui-linkbutton">저장</a>
				<a href="javascript:$('#dl_boardInsert').dialog('close');" class="easyui-linkbutton">닫기</a>
	    	</td>
	    	</tr>
	    </table>
    </form>
</div> 
</body>
</html>










