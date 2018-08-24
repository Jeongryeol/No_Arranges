<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<%@ include file="../include/commonUI.jsp" %>
<script type="text/javascript">
	var g_id=0;
	var g_dong;//전역변수-사용자가 입력한 동이름을 매핑 - searchbox
	function memberInsert(){
		if(g_id==0){
			alert("아이디 중복 체크 하세요.");
			return;
		}else if(g_id==1){
			if($("#mem_id").val()==null || $("#mem_id").val().length==0){
				alert("아이디를 입력하세요.");
				$("#mem_id").focus();
				return;
			}
			else if($("#mem_pw").val()==null || $("#mem_pw").val().length==0){
				alert("비번을 입력하세요.");
				return;
			}
			else if($("#mem_name").val()==null || $("#mem_name").val().length==0){
				alert("이름을 입력하세요.");
				return;
			}
			else{
				$("#f_member").attr("method", "post");
				$("#f_member").attr("action", "./member.kos?gubun=memINS");
				$("#f_member").submit();
			}
		}
	}
	function idCheck(){
		g_id = 1;
		var param = "gubun=idCheck&mem_id="+$("#mem_id").val();
		$.ajax({
			method:"POST",
			url:"./member.kos",
			data:param,
			success:function(result){
				var jsonDoc = JSON.parse(result);
  				for(var i=0;i<jsonDoc.length;i++){
					if(-1==jsonDoc[i].sstatus){
						alert("아이디를 사용할 수 있습니다.");
						$("#loginForm").show();
						$("#mem_pw").focus();
						return;
					}
					if(2==jsonDoc[i].sstatus){
						alert("아이디를 사용할 수 없습니다.");
						$("#loginForm").show();
						$("#mem_id").focus();
						return;
					}
				}
			},
			error:function(xhrObject){
				alert(xhrObject.responseText);
			}
		});			
	}
</script>
</head>
<body>
<div id="p_member" class="easyui-panel" title="회원가입" 
        style="width:650px;height:390px;padding:10px;background:#fafafa;"
        data-options="closable:true,
                collapsible:true,minimizable:true,maximizable:true">
<script type="text/javascript">
	$('#p_member').panel({
	    onClose:function(){
	        //alert('close....');
	        self.close();
	    }
	}); 
</script>                
<form id="f_member">      
<table align="center">
	<tr>
		<td width="100px">아이디</td>
		<td width="450px">
		<input id="mem_id" name="mem_id" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px">
		<a href="javascript:idCheck();" class="easyui-linkbutton">중복체크</a> 
		</td>
	</tr>
	<tr>
		<td width="100px">비밀번호</td>
		<td width="450px"><input id="mem_pw" name="mem_pw" class="easyui-passwordbox" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">이름</td>
		<td width="450px"><input id="mem_name" name="mem_name" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:200px"></td>
	</tr>
	<tr>
		<td width="100px">우편번호</td>
		<td width="450px"><input id="zipcode" name="zipcode"></td>
	</tr>
	<tr>
		<td width="100px">주소</td>
		<td width="350px"><input id="address" name="address"></td>
	</tr>
	<script type="text/javascript">
		$('#zipcode').searchbox({
		    searcher:function(value,name){
		        //alert(value + "," + name);
		        if(value==null || value.length==0){//너 동이름 입력안했지?
		        	alert("동이름을 입력하세요.");
		        	return;
		        }else{
			        $('#d_zipcode').dialog('open');
			    //datagrid를 태그로 사용할 경우 자바스크립트에서 조건절에 활용이 불가    
			    //생각해 보기 - 화면단에서 입력받은 값 처리할 때 시점 문제 처리하는 방법 꼭 찾아보세요.......
			        $('#dg_zipcode').datagrid({
				    url:'./member.kos?gubun=zipcode&dong='+value,
				    columns:[[
				        {field:'ZIPCODE',title:'우편번호',width:120},
				        {field:'ADDRESS',title:'주소',width:450},
				    ]],
				    onDblClickRow:function(index,row){
//easyui에서 사용하는 다이얼로그가 한 페이지 소스에 들어있어서 부모창에 별도의 API없이도 바로 적용할 수 있다.				    	
				    	//alert("index:"+index+", row:"+row+", 이름:"+row.ADDRESS);
//textbox에 새로운 값으로 변경할 때 setValue속성을 사용할 것.
						//기존에 동이름을 적었던 textbox에 선택한 우편번호 변경처리
				    	$("#zipcode").textbox('setValue',row.ZIPCODE);
				    	$("#address").textbox('setValue',row.ADDRESS);
				    	//주소 검색이 끝났으므로 다이얼로그창은 close처리
				    	$('#d_zipcode').dialog('close');
				    },
				});		        	
		        }
		    },
		    prompt:'동을 입력하세요.'
		});
	</script>	
	<script type="text/javascript">
		$('#address').textbox({
		    prompt:'주소정보는 자동으로 처리해봐요',
		    width:'400px'
		});
	</script>		
</table>          
<center>
<a href="javascript:memberInsert();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">가입</a>  
</center>
</form>    
</div>
<!-- 우편번호 검색 다이얼로그 구현 시작 -->
<div id="d_zipcode">
	<table id="dg_zipcode"></table>
</div>
<script type="text/javascript">
	$('#d_zipcode').dialog({
	    title: '우편번호 검색 서비스',
	    width: 500,
	    height: 350,
	    closed: true,
	    cache: false,
	    //href: './member.kos?gubun=zipcode',
	    modal: true
	});
</script>
</body>
</html>









