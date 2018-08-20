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
	<script type="text/javascript">
		//행추가
		function addRow(){
			$('#dg_member').datagrid('appendRow',{
				mem_id: '',
				mem_name: '',
				mem_gender: '',
				mem_hp:''
			});
		}
		//행삭제
		function delRow(index){
			//alert("삭제할 로우의 index:"+index);
			$('#dg_member').datagrid('deleteRow',index);			
		}
		//조회 처리
		function search1(){
			//alert("조회 호출 성공");//document.write();//문서 전체 초기화
			$("#dg_member").datagrid({
				url:"../json/memberJSON.json",
			});
		}
		//등록화면 열기 처리
		function add(){
			//alert("등록 호출 성공");
			$('#dlg_memIns').dialog('open');
		}
		//수정처리
		function pencil(){
			alert("수정 호출 성공");
		}
		//삭제처리
		function cut(){
			//alert("삭제 호출 성공");
			var row = $("#dg_member").datagrid('getSelected');
			alert("row : "+row.mem_id);
			//delRow(row);
		}
		//저장
		function save(){
			alert("저장호출 성공");
		}
		//등록화면에서 저장버튼 구현
		function memIns(){//실제 오라클서버연동 INSERT처리
			//alert("DB서버에 접속하여 INSERT처리");
			$("#f_memIns").attr("method","post");
			$("#f_memIns").attr("action","./memInsAction.jsp");//memInsAction.jsp에서 DB에 INSERT처리할 것임.
			$("#f_memIns").submit();//이 때 사용자PC에서 톰캣서버로 전송이 일어남.		
			$('#dlg_memIns').dialog('close');
		}
		</script>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function(){
		$("#dg_member").datagrid({
			width:500,
			height:250,
			title:"회원관리",
			toolbar:"#tb_member",
			singleSelect:true,
			//url:"../json/memberJSON.json",
		    columns:[[
		        {field:'mem_id',title:'아이디',width:100},
		        {field:'mem_name',title:'이름',width:150},
		        {field:'mem_gender',title:'성별',width:50,align:'right'},
		        {field:'mem_hp',title:'HP',width:120,align:'center'}
		    ]],
		    onLoadSuccess:function(){
		    	//alert("ok");
		    },
		    onLoadError:function(){
		    	alert("fail");
		    },
		    onDblClickRow:function(index,row){
		    	//alert("더블클릭");
		    	//document.write("index:"+index+", row:"+row);
		    	//alert("index:"+index+", row:"+row+", 이름:"+row.mem_name+", hp:"+row.mem_hp);
		    }
		});//객체-속성과 함수
	});
</script>
	<table id="dg_member"></table>
	<div id="tb_member">
	    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:search1()">조회</a>
	    <a href="#" onclick="javascript:addRow()">행추가</a>
	    <a href="#" onclick="javascript:delRow(0)">행삭제</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:add()">등록</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascript:pencil()">수정</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:cut()">삭제</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:save()">저장</a>
	</div>
	<!-- 등록화면 시작 -->
	<div id="dlg_memIns" class="easyui-dialog" title="회원등록" data-options="iconCls:'icon-save',closed:'true',modal:'true',buttons:'#btn_dlg_memIns'" style="width:400px;height:280px;padding:10px">
        <form id="f_memIns">
        <table>
        	<tr>
        		<td width="150px">아이디</td>
        		<td width="250px"><input class="easyui-textbox" id="mem_id" name="mem_id" size="12" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">이름</td>
        		<td width="250px"><input class="easyui-textbox" id="mem_name" name="mem_name" size="15" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">성별</td>
        		<td width="250px"><input class="easyui-textbox"  id="mem_gender" name="mem_gender" size="5"></td>
        	</tr>
        	<tr>
        		<td width="150px">HP</td>
        		<td width="250px"><input class="easyui-textbox"  id="mem_hp" name="mem_hp" size="12"></td>
        	</tr>        	        	        	
        </table>
        </form>
    </div>
    <!-- 등록화면에 버튼 추가하기 시작 -->
    <div id="btn_dlg_memIns">
		<a href="javascript:memIns()" class="easyui-linkbutton">저장</a>
		<a href="javascript:$('#dlg_memIns').dialog('close');" class="easyui-linkbutton">닫기</a>
	</div>
    <!-- 등록화면에 버튼 추가하기  끝   -->
	<!-- 등록화면  끝   -->
</body>
</html>















