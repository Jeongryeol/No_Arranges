<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<!-- EasyUI-Tutorial-Layout-Build border layout for Web Pages -->
	<script type="text/javascript">
		function showcontent(menu){
    		if(menu=='login'){
    		/* div의 panel을 컨트롤하기위해 소스코드 입양 : EasyUI-Documentation-panel-source copy */
    			$('#p_content').panel({
    		    	width:735,
    		    	height:485,
    		        href:'login.jsp',
    		    	title:'로그인',
    			});
    		}else if(menu='board'){
    			//alert(menu);
    			$('#p_content').panel({
    		    	width:735,
    		    	height:485,
    		        href:'board.jsp',
    		    	title:'계층형게시판',
    			});
    		}else if(menu='email'){
    			//alert(menu);
    			$('#p_content').panel({
    		    	width:735,
    		    	height:485,
    		        href:'email.jsp',
    		    	title:'이메일',
    			});
    			//alert(menu);//함수로 넘어오는지 확인하기위해 경고창 띄우기
				//$('#content').html('Introduction to ' + menu + ' language');
    		}
		}
	</script>
</head>
<body>
<!-- EasyUI-Tutorial-Layout-Build border layout for Web Pages -->
<table border=1px" borderColor="gray" width="900px" height="500px">
	<tr><!-- 수평선  -->
		<td>
		<!-- west시작 -->
		<div class="easyui-layout" style="width:900px;height:500px;">
    		<div region="west" split="true" title="Navigator" style="width:150px;">
        		<p style="padding:5px;margin:0;">Select language:</p>
        		<ul>
            		<li><a href="javascript:void(0)" onclick="showcontent('login')">로그인</a></li>
            		<li><a href="javascript:void(0)" onclick="showcontent('board')">계층형게시판</a></li>
            		<li><a href="javascript:void(0)" onclick="showcontent('email')">이메일</a></li>
        		</ul>
	    	</div>
		<!-- west 끝 -->    	
		<!-- center 시작 -->
    		<div id="content" region="center" style="width:750px;padding:5px;"><!-- 레이아웃만 제공하고 내용은 panel에서 채움 -->
    		<!--화면부분을 동쪽으로 밀어내기위해서  -->
    		<!-- Panel(easyui) 시작 -->
    			<div id="p_content" class="easyui-panel" title="계층형게시판"></div>
    		<!-- Panel(easyui) 끝 -->
    		</div>
		</div>
		<!-- center 끝 -->
		</td><!-- 수직선 -->
	</tr>
</table>

</body>
</html>