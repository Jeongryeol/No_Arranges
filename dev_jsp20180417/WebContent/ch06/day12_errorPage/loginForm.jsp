<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<jsp:include page="../../includelist/initJQ_EU_H.jsp"></jsp:include>
<html>
<head>
<meta charset="EUC-KR">
<title>에러페이지 처리하기</title>

<!-- ―――[[HEAD script : javascript]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
<script type="text/javascript">
	function welcomeLogin(){
		$.messager.show({
			 title:'Nice to See you'
			,msg:$("#inp_id").val()+'님, 환영합니다!'
			,width:300//Defaults to 250.
			,height:90//Defaults to 100.
			,timeout:800
			,showType:'show'
			,style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
</script>
</head>
<!--
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
-->
<body style="margin-left: 200px;">
<!-- ―――[[BODY script : javascript]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
<script type="text/javascript">
	$(document).ready(function(){
		$('#d_login').panel('move',{
		      left:500
		     ,top:500
		});
		$('#inp_id').textbox({
		     iconCls:'icon-man'
		    ,iconAlign:'right'
		    //,buttonText:'버튼이름'
		});
		$('#inp_pw').passwordbox({
		     iconCls:'icon-lock'
		    ,iconAlign:'right'
		    //,showEye: true
		});
	});
</script>

<!-- ―――[[BODY content : html]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->

<!-- ―――[[form-login OPEN ]]――― -->
<div class="ui input focus">
  <input type="text" placeholder="Search...">
</div>

<div id="d_login" title="LOGIN IN" style="width:100%;max-width:350px;padding:20px 30px;">
    <form id="f_login" method="post">
        <div class="ui large input focus">
			<input id="inp_id" name="email"	type="text" placeholder="여기">
		</div>
        <div style="text-align:center;padding:5px 0">
			<button class="ui primary button" onclick="submitForm()">
				로그인
			</button>
			&nbsp;
			<button class="ui button" onclick="clearForm()">
				재입력
			</button>
    	</div>
    </form>
    <script>
     function submitForm() {
     	$('#f_login').form({
     	     url:''
     	    ,onSubmit: function(){
     	        // do some check
     	        // return false to prevent submit;
     	    }
     	    ,success:function(xhrObject){
     	        alert(xhrObject)
     	    }
     	});
     	welcomeLogin();
     }
     function clearForm() {
     	$('#f_login').form('clear');
     }
	</script>
</div>
<!-- ―――[[form-login CLOSE ]]――― -->
</body>
</html>