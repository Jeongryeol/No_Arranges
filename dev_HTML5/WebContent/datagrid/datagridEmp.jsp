<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원관리시스템</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css?1">
	<link rel="stylesheet" type="text/css" href="../demo/demo.css">
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	//새로운 사원목록 가져오기
	function getEmpList(){
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
	function getRowIndex(target){
	    var tr = $(target).closest('tr.datagrid-row');
	    return parseInt(tr.attr('datagrid-row-index'));
	}
	function editrow(target){
	    $('#dg_emp').datagrid('beginEdit', getRowIndex(target));
	}
	function deleterow(target){
	    $.messager.confirm('Confirm','Are you sure?',function(r){
	        if (r){
	            //사용자가 환면에서 선택한 로우 정보 가져오기 : 선택한 로우의 object정보임
	            //따라서 
	        	//$('#dg_emp').datagrid('deleteRow', getRowIndex(target));
	            location.href="./empDelAction.jsp?empno=9958";
	            //getEmpList();
	        }
	    });
	}
	function saverow(target){
	    $('#dg_emp').datagrid('endEdit', getRowIndex(target));
	}
	function cancelrow(target){
	    $('#dg_emp').datagrid('cancelEdit', getRowIndex(target));
	}	
	</script>
</head>
<body>
<script type="text/javascript">
//이문서 전체를 받아주는 객체가 있다.- document - html - head[title태그]&body[table]
//URL(Uniform Resource Locator)~도메인,IP주소
/*
 * ready함수 : 사용자(업무담당자)가 URL에 요청한 해당 페이지를
 				브라우저(크롬 등)가 요청받아서
 				서버(톰켓v8.5)로부터 응답을 받아서 결과를 출력한다.
 				응답을 받았다=클라이언트에 다운로드가 일어났다(get방식-노출,보안취약,인터셉트 발생[서버까지 전달이 안됨])
 				
 				응답을 받고나면(다운로드가 일어나면)
 				돔(DOM, Document Object Model : html-head-body의 트리구조)구성이 끝난다.
 				
 				이미 다운로드가 완료된 상태로 활성화가 되어 있기 때문에
 				ready(function(){ 실행문, 이벤트처리, 속성추가 가능 })
 				
 				이벤트를 처리하기 필요한 대상 : 태그이름 혹은 태그아이디, 속성값 등
 				즉, 위 대상은 접근가능해야하기 때문에 DOM구성이 완료되어 있어야 한다.
 				
 */
	$(document).ready(function (){
		getEmpList();
	});////////////////////////end of ready
</script>
	<table id="dg_emp"></table>
<!-- 요기에 텍스트박스 2개만 추가해주세요. -->
<input class="easyui-textbox" id="tb_empno" style="width:100px">	
<input class="easyui-textbox" id="tb_ename" style="width:150px">	
<input class="easyui-textbox" id="tb_job" style="width:150px">	
<input class="easyui-textbox" id="tb_hiredate" style="width:150px">	
<input class="easyui-textbox" id="tb_deptno" style="width:100px">
<!-- id옵션 : UI(Client)에서 사용하는 이름  ▶▶▶ $('#____')
   / name옵션 : Server에서 사용하는 이름  ▶▶▶ request.getParameter("name") -->	
</body>
</html>











