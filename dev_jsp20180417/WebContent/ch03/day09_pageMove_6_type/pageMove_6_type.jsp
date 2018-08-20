<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>페이지를 이동하는 6가지 방법 정리</title>

<!-- ―――[[ import ]]―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
	<!-- css import code -->
<link rel="stylesheet" type="text/css" href="../../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../demo/demo.css">
	<!-- jQuery script import code :: $-undifined error 주의!!! -->
<script type="text/javascript" src="../../js/jquery-1.12.0.js"></script>
	<!-- EasyUI for jQuery script import code -->
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>

<!-- ―――[[HEAD script : javascript]]――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――― -->
<script type="text/javascript">
	/* 자바스크립트 페이지이동하기 */
	function moveJsc(){
		location.href="target.jsp";
	}
	/* ajax 페이지이동하기  : 외부의 페이지가 내 안으로 들어오게 함*/
	function moveAjax(){
		$.ajax({
			 url:"target.jsp"	//목적지
			,method:"post"		//전송방식
			,success:function(htmlCode){//요청성공시 목적페이지의 HTML코드가 응답으로 돌아옴
				$(d_ajax).html(htmlCode);//해당위치(div)에 코드를 실행함 
			}
		});
	}
	/* EasyUI 페이지 이동하기  */
	function moveEasyui_getEmpList(){
		/* 데이터그리드 초기화 하기 */
		$("#dg_emp").datagrid({
		    //url:'../json/empJSON.json'
		    url:'./jsonEmpList.jsp'
		   ,singleSelect:true
		   ,columns:[[
				/* 테이블 헤더 초기화 [사원번호 사원명 JOB 입사일자 부서번호] */
				{field:'empno', title:'사원번호', width:100, align:'center', editor:'text'}
			   ,{field:'ename', title:'사원명', width:120, align:'center', editor:'text'}
			   ,{field:'job', title:'JOB', width:150, align:'center', editor:'text'}
			   ,{field:'hiredate', title:'입사일자', width:180, align:'center', editor:'text'}
			   ,{field:'dname', title:'부서명', width:100, align:'center', editor:'text', hidden:'true'}
			   ,{field:'deptno', title:'부서명', width:200, align:'center',  
				 editor:{
					 type:'combobox'
					,options:{
						valueField:'deptno'//실제 서버에 넘어가는 필드
					   ,textField:'dname'//화면에 출력되는 필드
					   ,url:'./jsonDeptList.jsp'
/* 					   ,data:[{
						    "deptno":10,
						    "dname":"ACCOUNTING"
						},{
						    "deptno":20,
						    "dname":"RESEARCH"
						},{
						    "deptno":30,
						    "dname":"SALES"
						    //"selected":true
						},{
						    "deptno":40,
						    "dname":"OPERATIONS"
						}] */
					}
				 }/////////////end of editor
			   }///////////////end of field
			  ,{field:'action',title:'Action',width:80,align:'center',
	                formatter:function(value,row,index){
	                    if (row.editing){
	                        var s = '<a href="javascript:void(0)" onclick="saverow(this)">Save</a> ';
	                        var c = '<a href="javascript:void(0)" onclick="cancelrow(this)">Cancel</a>';
	                        return s+c;
	                    } else {
	                        var e = '<a href="javascript:void(0)" onclick="editrow(this)">Edit</a> ';
	                        var d = '<a href="javascript:void(0)" onclick="deleterow(this)">Delete</a>';
	                        return e+d;
	                    }
	                }
	            }//////////////end of action field
			]]/////////////////end of column
		//Event처리	
		,onSelect:function(index,row){
			//alert("index:"+index+", row:"+row+", row.empno:"+row.empno);
			$("#tb_empno").textbox('setValue',row.empno);
			$("#tb_ename").textbox('setValue',row.ename);
			$("#tb_job").textbox('setValue',row.job);
			$("#tb_hiredate").textbox('setValue',row.hiredate);
			$("#tb_deptno").textbox('setValue',row.deptno);
		}
        ,onEndEdit:function(index,row){
            var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'productid'
            });
            row.productname = $(ed.target).combobox('getText');
        },
        onBeforeEdit:function(index,row){
            row.editing = true;
            $(this).datagrid('refreshRow', index);
        },
        onAfterEdit:function(index,row){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
        },
        onCancelEdit:function(index,row){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
        }
		});////////////////////end of datagrid
	}
</script>
</head>
<!--
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
-->
<body>
<!-- ───────────────────────────────────────────────────────────────────────ㄴ -->
	<!-- HTML 주석  	-->
	<%-- JSP 주석 		--%>
	<%! /*디클러레이션 */		%>
	<% 	/*스크립틀릿 */	 	%>
	<%=	/* 익스플레이션 */" "	%>
<!-- ───────────────────────────────────────────────────────────────────────ㄴ -->

	<%-- jsp 또는 servlet 페이지이동하기 --%>
	<% 	
	//스크립틀릿이 먼저 실행되므로 이 페이지를 열자마자 바로 목적지를 열리므로 현재 페이지를 볼 수 없다.
			//servlet을 호출할 때, 매핑된 url주소를 목적지로 입력
		//response.sendRedirect("../login.do");
			//jsp를 호출할때, jsp파일 경로를 목적지로 입력
		//response.sendRedirect("target.jsp");
	%>
	
	<!-- 자바스크립트 페이지이동하기 [HEAD script 필수참고!!] -->
	<input type="button" value="자바스크립트로 함수로 페이지이동" onclick="moveJsc()">
	
<br><br>
	<!-- ajax 페이지이동하기  : 외부의 페이지가 내 안으로 들어오게 함 [HEAD script 필수참고!!]-->
	<input type="button" value="아작스 함수로 페이지이동" onclick="moveAjax()">
	<div id="d_ajax"></div>
	
<br><br>
	
	<!-- <a>태그로 페이지이동하기 -->
	<a href="http://www.10x10.co.kr/">
		<img src="./tenbyten.png" border="0">
	</a>
	
<br><br>
	<!-- <form>태그로 페이지이동하기 -->
	<form action="target.jsp" method="get">
		<input type="submit" value="form태그로 페이지이동하기"/>
	</form>

<br><br>
	<!-- EasyUI로 페이지이동하기 [import 잊지말기!!] -->
	<input type="button" value="EasyUI로 페이지이동" onClick="moveEasyui_getEmpList()">
	<table id="dg_emp"></table>
	
</body>
</html>