<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Base64.Decoder, java.util.Base64" %>    
<%
	String smem_id = (String)session.getAttribute("smem_id");
	byte[] encodeBytes = smem_id.getBytes();
	out.print("db_id:"+smem_id);
	Decoder idDecoder = Base64.getDecoder();
	byte[] decodeBytes = idDecoder.decode(encodeBytes);
	String org_id = new String(decodeBytes);
	out.print("org_id:"+org_id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	var vfrom_id;//전역변수
	function memoForm(){
		//alert("쪽지쓰기화면 : "+vfrom_id);
		$('#dl_memoForm').dialog('open');
		//주의 : textbox에 값을 초기화 할때 val(), text()사용불가
		$('#to_id').textbox('setValue',vfrom_id);
		//주의 :자바스크립트 코드와 jsp코드를 같이 사용할 수 없지만
		//지금 처럼 자바스크립트 변수(값)에 익스프레션을 이용하면 값을 담을 수 있다.(언제? 이종간에도)
		//단 단점은 문자열 상수가 박혀서 동적으로 값이 변할 수 없다.
		//자바스크립트는 클라이언트 언어이고 익스프레션은 서버 언어임. 처리 주체가 다름.
		//서버 코드가 먼저 실행됨(값이 결정되었다.)
		$('#from_id').textbox('setValue','<%=org_id%>');
	}
	function memoInsert(){
		$("#f_memo").attr("method","post");
		$("#f_memo").attr("action","./member.kos");
		$("#f_memo").submit();
	}
</script>
</head>
<body>
<div id="p_member" class="easyui-panel" title="회원목록" 
        style="width:600px;height:350px;padding:10px;background:#fafafa;"
        data-options="closable:true,collapsible:true,minimizable:true,maximizable:true">
	<table id="dg_member"></table>
</div>
<script type="text/javascript">
	$('#p_member').panel({
		onClose:function(){
			self.close();
		}
	}); 
	$('#dg_member').datagrid({
		width:'500px',
		height:'250px',
		singleSelect:true,
	    url:'./member.kos?gubun=memberList',
	    columns:[[
	        {field:'RNO',title:'번호',width:100, align:'center'},
	        {field:'MEM_ID',title:'아이디',width:100, align:'center'},
	        {field:'MEM_NAME',title:'이름',width:120, align:'center'},
	        {field:'ACTION',title:'',width:120, align:'center', hidden:true},
            {field:'ACTIONUI',title:'',width:120,align:'center',
                formatter:function(value,row,index){
                        var e = '<a href="javascript:memoForm()">쪽지보내기</a> ';
                        return e;
                }
            }
	    ]],
	    onClickRow:function(index,row){
	    	vfrom_id = row.MEM_ID;
	    }
/* 		data: [
			{NO:'1', MEM_ID:'haha1', MEM_NAME:'이순신1'},
			{NO:'2', MEM_ID:'haha2', MEM_NAME:'이순신2'},
			{NO:'3', MEM_ID:'haha3', MEM_NAME:'이순신3'}
		] */
	});
</script>
<!-- 쪽지 쓰기 팝업창 시작 -->
<div id="dl_memoForm">
<!-- 사용자가 입력한 값을 전송할 땐 form전송 처리 할것. -->
	<form id="f_memo">
	<input type="hidden" name="gubun" value="memoInsert">
	<table width="500px" height="auto">
	<tr>
		<td width="100px">받는이</td>
		<td width="350px">
		<!-- 쪽지쓰기 클릭했을 때 그 로우의 아이디값을 읽어서 담기 -->
		<input id="to_id" name="to_id" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px">
		</td>
	</tr>
	<tr>
		<td width="100px">보내는이</td>
		<!-- 현재 로그인한 상태이므로 세션에서 이름을 읽어서 담기 -->
		<td width="350px"><input id="from_id" name="from_id" class="easyui-textbox" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">내용</td>
		<!-- 쪽지 내용만 사용자로부터 입력 받기 -->
		<td width="350px"><input id="memo_content" name="memo_content" class="easyui-textbox" multiline="true" style="width:300px;height:50px"></td>
	</tr>		
	</table>
	<table width="500px" height="30px">
		<tr>
			<td colspan="2">
			<a id="btn" href="javascript:memoInsert()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">보내기</a>
<!-- href속성에는 페이지 요청뿐 아니라 자바스크립트 함수도 호출 가능함. -->			
			<a id="btn" href="javascript:$('#dl_memoForm').dialog('close')" 
			class="easyui-linkbutton" data-options="iconCls:'icon-no'">닫기</a>
			</td>
		</tr>
	</table>
	</form>
</div>
<script type="text/javascript">
	$('#dl_memoForm').dialog({
	    title: '쪽지쓰기',
	    width: 500,
	    height: 200,
	    closed: true,
	    cache: false,
	    modal: true
	});
</script>
<!-- 쪽지 쓰기 팝업창 끝  -->
</body>
</html>