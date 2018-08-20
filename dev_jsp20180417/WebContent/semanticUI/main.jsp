<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder" %>
<%
	String smem_name = null;
	String sstatus = null;
	if(session.getAttribute("smem_name")!=null){
		smem_name = session.getAttribute("smem_name").toString();
	}
	if(session.getAttribute("sstatus")!=null){
		sstatus = session.getAttribute("sstatus").toString();
	}
	Cookie[] cs = request.getCookies();
	String c_value = null;
	String sunglass = null;
	String shortpants = null;
	String suncream = null;
	String shortshirts = null;
	String slipper = null;
	if(cs !=null && cs.length>0){//쿠키가 존재하니?
		for(int i=0;i<cs.length;i++){
			String c_name = cs[i].getName();
			if("JSESSIONID".equals(c_name)){
				c_value = cs[i].getValue();
			}
			else if("cmem_name".equals(c_name)){
				c_value = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			/* 상품 정보 조회 하기 시작 */
			else if(c_name=="sunglass"){
				sunglass = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="shortpants"){
				shortpants = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="suncream"){
				suncream = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="shortshirts"){
				shortshirts = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			else if(c_name=="slipper"){
				slipper = URLDecoder.decode(cs[i].getValue(),"utf-8");
			}
			/* 상품 정보 조회 하기  끝 */
		}	
	}///end of if
	//out.print(c_value);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../semantic/semantic.css" />
<script src="../semantic/jquery-1.12.0.js"></script>
<script src="../js/jquery.easyui.min.js"></script>
<script src="../semantic/semantic.js"></script>
<script src="../js/commons.js"></script>
<title>시맨틱UI API활용</title>
<script type="text/javascript">
	var status ='<%=c_value%>';
	var cnt = 0;
	function pwSearch(){
		//임시비번을 발급 받을 때 아이디 필요함 - 필수입력사항 - 유효성검사 처리
		var user_id = $("#mem_id").val();
		if(user_id==null || user_id.length==0){
			alert("아이디를 입력하세요.");
			return;//pwSearch함수 탈출
		}
		else{
			var param = "gubun=pwSearch&user_id="+$("#mem_id").val();
			$.ajax({
				method:"POST",
				data:param,//user_id=사용자가 입력한 아이디
				url:"./member.kos",//모델1으로 할것인지 , 모델2로 할것인지 결정하기
				success:function(result){
						
				},
				error:function(xhrObject){
					alert(xhrObject.responseText);
				}
			}); 			
		}
	}
	function memoMgr(){
		//창을 띄워서 처리해야 EasyUI와 sementic이 충돌나지 않는다.
		cmm_window_popup("./memberList.jsp","700","450","testForm1");
	}
	function onLineTest(){
		cmm_window_popup("../onLineTest/testForm1.html","700","450","testForm1");
	}
	function cart(gName,gValue){
		location.href="./cartAction.jsp?gName="+gName+"&gValue="+gValue;
	}
/* 	function cartList(){
		cmm_window_popup("cartInfoList.jsp","700","450","cartInfo");
	} */
	function memberShip(){
		cmm_window_popup("memberForm.jsp","700","450","memberForm");
	}
	function loginCheck(){
		if(status == 'null' || status.length==0){
			alert("로그인 하세요");
			return;
		}
	}
    function logout(){
		$.ajax({
			method:"GET",
//			url:"./logoutCookie.jsp",
			url:"./logoutSession.jsp",
			success:function(result){
				status = "";
				$("#mem_id").val("");
				$("#mem_pw").val("");
				$("#loginForm").show();
				$("#logoutForm").hide();
			},
			error:function(xhrObject){
				alert(xhrObject.responseText);
			}
		});    	
    }
	function login(){
		var x = document.cookie;
		alert("x:"+x);
		var param = "command=login&mem_id="+$("#mem_id").val()+"&mem_pw="+$("#mem_pw").val();
		$.ajax({
			method:"POST",
			url:"./member.kos?gubun=login",
			data:param,
			success:function(result){
				//조회결과를 담을 json포맷정보 출력 테스트
				//document.write(result);
				var jsonDoc = JSON.parse(result);
  				for(var i=0;i<jsonDoc.length;i++){
  					if(jsonDoc[i].cnt!=null){
  						if(jsonDoc[i].cnt==5){
  							alert("캡챠서비스 이동");
  							return;
  						}
  					}
					if(-1==jsonDoc[i].sstatus){
						alert("아이디가 존재하지 않습니다.");
						$("#loginForm").show();
						$("#mem_id").focus();
						return;
					}
					else if(0==jsonDoc[i].sstatus){
						alert("비번이 맞지 않습니다.");
						cnt=cnt+1;
						document.cookie = "cnt="+cnt+"; expires="+expires+"; path=/";
						$("#loginForm").show();
						$("#mem_pw").focus();
						return;
					}
					else if(1==jsonDoc[i].sstatus){
						$("#loginForm").hide();
						$("#logoutForm").show();
						$("#d_msg").html(jsonDoc[i].smem_name+"님 환영합니다.");			
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
<!-- <body onLoad="cartList()"> -->
	<div class="ui inverted vertical masthead center aligned segment teal">
		<div class="ui text container">
			<h1 class="ui inverted header">집나와</h1>
		</div>
		<div class="ui container">
			<div class="ui secondary  menu">
				<div class="left menu">
					<div class="item">
						<div class="ui icon input">
							<input type="text" placeholder="검색"> <i class="search link icon"></i>
						</div>
					</div>
				</div>			
				<!-- 아이디와 비밀번호 -->	
<!--======================[[ 로그인 화면 추가 시작 ]]=====================-->		
				<div id="loginForm" class="item">
					<div class="ui mini input">
						<input value='test' type="text" id="mem_id" name="mem_id" placeholder="아이디" style="margin-right: 10px;">
						<input value='123' type="text" id="mem_pw" name="mem_pw" placeholder="비밀번호" style="margin-right: 10px;">
						<button id="btn_login" class="ui inverted white button" style="margin-right: 10px;">로그인</button>
						<button id="btn_pwSearch" class="ui inverted white button" onClick="pwSearch()">비번찾기</button>
						<button id="btn_member" class="ui inverted white button" onClick="memberShip()">회원가입</button>
					</div>
				</div>
<!--======================[[ 로그인 화면 추가   끝 ]]=====================-->
<!--======================[[ 로그아웃 화면 추가 시작 ]]=====================-->		
				<div id="logoutForm" class="item">
					<div id="d_msg"></div>
					<button id="btn_logout" class="ui inverted white button" style="margin-right: 5px;">로그아웃</button>
					<button id="btn_memberUpd" class="ui inverted white button">정보수정</button>
				</div>
<!--======================[[ 로그아웃 화면 추가 끝    ]]=====================-->				
			</div>
		</div>
	</div>
	<div class="ui container">
		<div class="ui grid" style="margin-top: 15px;">
			<div class="four wide column">
<!--======================[[ 사이드 메뉴 추가 시작 ]]=====================-->			
				<div class="ui vertical fluid tabular menu" id="menu">
					<a id="m_intro" class="item">인트로 </a>
					<a id="m_memo" class="item">쪽지관리</a>
					<a id="m_cart" class="item"> 장바구니 </a>
					<a id="m_gmap" class="item"> 구글맵 </a>
					<a id="m_ontest" class="item"> 온라인시험 </a>
					<a id="m_board" class="item"> 게시판 </a>
				</div>
<!--======================[[ 사이드 메뉴 추가  끝   ]]=====================-->						
			</div>
			<div class="twelve wide stretched column">
<!--======================[[ 사이드 메뉴 본문 시작 ]]=====================-->				
				<div id="c_intro" class="ui segment">
				인트로 페이지
				</div>
				<div id="c_cart" class="ui segment">
				장바구니 서비스
				<table border="1">
					<tr><th>물품명</th><th>&nbsp;</th></tr>
					<tr><th>썬그라스</th><th><a href="javascript:cart('sunglass','썬그라스')">장바구니담기</a></th></tr>
					<tr><th>반바지</th><th><a href="javascript:cart('shortpants','반바지')">장바구니담기</a></th></tr>
					<tr><th>썬크림</th><th><a href="javascript:cart('suncream','썬크림')">장바구니담기</a></th></tr>
					<tr><th>반팔티</th><th><a href="javascript:cart('shortshirts','반팔티')">장바구니담기</a></th></tr>
					<tr><th>슬리퍼</th><th><a href="javascript:cart('slipper','슬리퍼')">장바구니담기</a></th></tr>
				</table>
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
<!--======================[[ 사이드 메뉴 본문   끝  ]]=====================-->						
			</div>
		</div>
	</div>
	<script>
/* 처음 실행했을 때 4개 내용이 다 보여요ㅜㅜ 어떡하지?  화면 초기화 처리가 필요해요 */
		$(document).ready(function(){
			$("#c_intro").show();
			$("#c_cart").hide();
			$("#c_gmap").hide();
			$("#c_ontest" ).hide();
			$("#c_board").hide();	
			$("#logoutForm").hide();
			$("#btn_login").click(function (){
				//alert("로그인버튼 클릭시....");
				login();
			});
			$("#btn_logout").click(function (){
				logout();
			});
		});
		$('#menu').find('a').click(function() {
			$('#menu').find('a').attr('class', 'item');
			$(this).attr('class', 'item active');
			//alert($(this).attr('id'));
			if(status == 'null' || status.length==0){
				alert("로그인 하세요");
				return;
			}
 			if($(this).attr('id')=='m_intro'){//인트로 선택한거니?
 				$("#c_intro").show();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();
			}
			else if($(this).attr('id')=='m_memo'){//장바구니가 필요해?
 				$("#c_intro").hide();
 				$("#c_cart").hide();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();
 				memoMgr();
			}
			else if($(this).attr('id')=='m_cart'){//장바구니가 필요해?
 				$("#c_intro").hide();
 				$("#c_cart").show();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();				
			}
			else if($(this).attr('id')=='m_gmap'){//구글맵서비스가 필요해?
 				$("#c_intro").hide();
 				$("#c_gmap").show();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();				
			}
			else if($(this).attr('id')=='m_ontest'){//시험볼거니?
 				$("#c_intro").hide();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").hide();	
 				onLineTest();
			}
			else if($(this).attr('id')=='m_board'){//게시판 쓸건가?
 				$("#c_intro").hide();
 				$("#c_gmap").hide();
 				$("#c_ontest" ).hide();
 				$("#c_board").show();				
			}
		})
	</script>
</body>
</html>