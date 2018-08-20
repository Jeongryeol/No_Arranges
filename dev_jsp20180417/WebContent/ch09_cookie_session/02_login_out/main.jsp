<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%
	//로그인 상태 체크
	Cookie[] cs = request.getCookies();
	String c_value = null;
	if(cs != null && cs.length>0){//쿠키가 존재한다면
		for(int i=0;i<cs.length;i++){
			String c_name = cs[i].getName();
			if("cmem_name".equals(c_name)){
				//생성된 쿠키의 값을 디코딩해서 읽어봄
				c_value = URLDecoder.decode(cs[i].getValue(),"UTF-8");
			}
		}
	}
	//out.print(c_value);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>
<link rel="stylesheet" href="../../semantic/semantic.css">
<script src="../../semantic/semantic.js"></script>
<script src="../../js/jquery.easyui.min.js"></script>
<script src="../../js/commons.js"></script>
<title>시멘틱UI</title>
<script type="text/javascript">
	//로그인 처리
	function login(){
		//alert("imgObj:"+imgObj.attr("id"));//id의 값을 읽어오는 코드
		var param = "command=login"
					+"&mem_id="+$("#mem_id").val()
					+"&mem_pw="+$("#mem_pw").val();
		$.ajax({
			method:"POST",
			url:"./memberMgr.do",
			data:param,
			success:function(result){
	    		//alert("테스터 님 환영합니다.");
	       		$("#loginForm").hide();//로그인 폼은 감춰두기
	       		$("#logoutForm").show();//로그아웃 폼보여주기
				$("#d_msg").html(result);//출력				
			},
			error:function(xhrObject){
				alert(xhrObject.responseText);
			}
		});
	}
	//로그아웃처리
	function logout(){
		var param = "command=logout"
		$.ajax({
			 method:"POST"
			,url:"logoutCookie.jsp"
			,data:param
			,success:function(result){
				alert("로그아웃 되었습니다.");
				$("#logoutForm").hide();//로그아웃 폼은 감춰두기
		       	$("#loginForm").show();//로그인 폼은 보이게하기
		       	$("#mem_id").val("");//비우기
		       	$("#mem_pw").val("");//비우기
			}
			,error:function(xhrObject){
				alert(xhrObject);
			}
		});
	}
	//회원가입
	function memberShip(){
		cmm_window_popup("memberForm.jsp","700","450","memberForm");
	}
	//온라인시험 팝업구현
	function onLineTest(){
		cmm_window_popup("../../onLineTest/testForm1.html","700","450","testForm1");
	}
</script>	
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
       	//초기화면 처리
		$("#c_intro").hide();
       	$("#c_gmap").hide();
       	$("#c_ontest").hide();
       	$("#c_board").hide();
       	//로그인상태 체크 반영
       	var status = "<%=c_value %>";
       	if(status=='null' || status.length==0){
   			$("#logoutForm").hide();
   			$("#loginForm").show();
		} else {
   			$("#loginForm").hide();
   			$("#logoutForm").show();
		}
	})
</script>
<!-- 다이얼로그 시작-->
<div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    Dialog Content.
</div>
<!-- 다이얼로그 끝-->
   <div class="ui inverted vertical masthead center aligned segment pink">
      <div class="ui container"></div>
      <div class="ui text container">
         <h1 class="ui inverted header">Project Name</h1>
      </div>
      <div class="ui container">
         <div class="ui secondary menu">
				<!-- ===========[[로그인을 해야하는 상태의 화면]]=========== -->
				<div class="right menu">
		            <div class="item">
		               <div class="ui icon input">
		                  <input type="text" placeholder="Search">
		                   <i class="search link icon"></i>
		               </div>
		            </div>
		        </div>
				<div id="loginForm" class="item">
					<!--  아이디 추가  -->
					<div class="ui mini input">
						<input id="mem_id" name="mem_id" type="text" placeholder="ID" style="margin-right: 10px;">
					</div>
					<!--  비밀번호 추가  -->
					<div class="ui mini input">
						<input id="mem_pw" name="mem_pw" type="text" placeholder="PW" style="margin-right: 15px;">
					</div>
					<!--  로그인 추가  -->
					<div id="d_logBtn" class="ui mini input" style="width: 200px;">
						<button id="btn_login" class="ui inverted red button"
								style="padding-bottom: 7px; padding-right: 15px; padding-top: 7px; padding-left: 15px;"
								onclick="login()">로그인</button>
					</div>
					<!-- 회원가입 추가 -->
					<div id="d_logBtn" class="ui mini input" style="width: 200px;">
						<button id="btn_join" class="ui inverted red button"
								style="padding-bottom: 7px; padding-right: 15px; padding-top: 7px; padding-left: 15px;"
								onclick="memberShip()">회원가입</button>
					</div>
				</div>
				<!-- ==========[[ 로그아웃을 해야하는 상태의 화면]]=========== -->
				<div id="logoutForm" class="item">
					<!--  환영인사 추가  -->
					<div id="d_msg" class="ui mini input"></div>
					<!--  로그아웃 추가  -->
					<div id="d_logBtn" class="ui mini input">
						<button id="btn_logout" class="ui inverted red button"
								style="padding-bottom: 7px; padding-right: 15px; padding-top: 7px; padding-left: 15px;"
								onclick="logout()">로그아웃</button>
					</div>
				</div>
          </div>
      </div>
   </div>
<!-- =====================[[ 사이드 메뉴 추가 시작 ]]===================== -->
   <div class="ui container">
      <div class="ui grid" style="margin-top: 5px;">
         <div class="four wide column">
            <div id="menu" class="ui vertical fluid tabular menu">
               <a id="m_intro" class="item"> 인트로 </a> 
               <a id="m_gmap" class="item"> 구글맵 </a>
               <a id="m_ontest" class="item"> 온라인시험 </a> 
               <a id="m_board" class="item"> 게시판 </a>
            </div>
<!-- =====================[[ 사이드 메뉴 추가 끝 ]]===================== -->
         </div>
  		 <div class="twelve wide stretched column">
<!-- =====================[[ 사이드 메뉴 본문 시작 ]]===================== -->
			<div id="c_intro" class="ui segment">
				인트로 페이지
			</div>
			<div id="c_gmap" class="ui segment">
				구글맵 서비스
			</div>
			<div id="c_ontest" class="ui segment">
				온라인 시험 서비스
			</div>
			<div id="c_board" class="ui segment">
				게시판 구현 서비스
			</div>
	    </div>
<!-- =====================[[ 사이드 메뉴 본문 끝 ]]===================== -->
      </div>
   </div>
   <script type="text/javascript">
    /* 메뉴부분에서  a태그를 찾고, 클릭했을때의 이벤트를 지정 */  
   	$('#menu').find('a').click(function(){
        
   		$('#menu').find('a').attr('class','item');
        $(this).attr('class','item active');
        
        //alert("눌렀니?");
        /* 화면 분기  */
       	$("#c_intro").hide("slow");
       	$("#c_gmap").hide("slow");
       	$("#c_ontest").hide("slow");
       	$("#c_board").hide("slow");
       	
       	//로그인체크
       	var status = "<%=c_value %>";
       	alert("status ="+status);
       	if(status=='null' || status.length==0){
			alert("로그인하세요");
			$("#c_intro").show();
			return;
		}
       	
        if($(this).attr('id')=='m_intro'){//인트로 선택
        	//alert("c_intro 선택")
        	$("#c_intro").show();
        }
        else if($(this).attr('id')=='m_gmap'){//구글맵 서비스 선택
        	 //alert("c_gmap 선택")
         	$("#c_gmap").show();
        }
        else if($(this).attr('id')=='m_ontest'){//온라인 시험 선택
        	 //alert("c_ontest 선택")
        	$("#c_ontest").hide();
        	onLineTest();
        	
        }
        else if($(this).attr('id')=='m_board'){//게시판 선택
        	 //alert("c_board 선택")
         	$("#c_board").show();
        }
      })
   </script>
</body>
</html>