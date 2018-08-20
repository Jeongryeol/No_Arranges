<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- 공통코드영역 : 추후 include로 편하게 하는 방법을 배울 것 -->
    <script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css?1">
	<link rel="stylesheet" type="text/css" href="../demo/demo.css">

<!-- jquery 기반의 easyUI +html + CSS + JS
	 1. 태그에 적용하는 방법
	 2. 자바스크립트에 적용하는 방법  
-->

<!-- 툴바의 이벤트처리를 하기위해 등록할 구간 : Java와 만나는 부분!! -->
	<script type="text/javascript">
		//검색처리
		function idSearch(){
			alert("검색");
		}
		
		//조회처리
		function search1(){
			//alert("조회호출성공");//확인용 //document.write(); 이것은 문서 전체 초기화임
			$("#dg_member").datagrid({
				url:"../json/memberJSON.json",
				rownumbers:true
			});
		}
		//행추가
		function addRow(){
			$('#dg_member').datagrid('appendRow',{
				name: 'new name',
				age: 30,
				note: 'some messages'
			});
		}
		//행삭제
		function delRow(index){
			alert("삭제할 로우의 index:"+index);
			$("#dg_member").datagrid('deleteRow',index);
		}
		//등록화면 버튼누르면 열기처리
		function add(){
			//alert("등록호출성공");//확인용
			$("#dlg_memIns").dialog('open');//누르면 이 표에서 다이얼로그창을 띄움
		}
		//수정처리
		function edit(){
			alert("수정호출성공");
		}
		//삭제처리
		function cut(){
			//alert("삭제호출성공");//확인용
/* 			$("#dg_member").datagrid({
				onSelect:function(index,row){
					//alert(삭제할 로우를 선택하세요.);
					delRow(index);
				}
			});*/
			
/* 			$("#dg_member").datagrid({'selectOnCheck':$(this).is('false')});
			$("#dg_member").datagrid({'checkOnSelect':$(this).is('checked')});
			//EasyUI의 datagrid의 getSelected 메소드를 추가하고, 값을 접근하는 방법
			//변수 이름  = $("대상id").소유주('메소드명'); 
			var row = $("#dg_member").datagrid('getSelected');//오브젝트
			*/
			
			//선택한 로우 정보를 가져올때
			var row = $("#dg_member").datagrid('getSelected');//오브젝트
			if(row==null){
				alert("삭제를 원하는 대상을 선택해주세요.");
				return;//cut함수를 탈출함!!!
			}else{
				//만일 선택한 로우의 인덱스 정보를 알 수 있다면 좋을텐데....
				var sindex = $("#dg_member").datagrid('getRowIndex',row);
				alert(row);//Object...라고 찍힐 것
				alert(row.mem_id+', index정보는? '+sindex);
				//여기에 바디에서 구현한 삭제하는것까지 넣고싶은데.. 어떡하지??
			}
			
		}
		//저장처리
		function save(){
			alert("저장호출성공");//확인용
		}
		//●●●이미지로 CSS아이콘버튼 만들기
		function order2(){
			alert("정렬호출성공")
		}
		//등록화면(다이얼로그)에서 저장버튼 구현하기
		function memIns(){
			//alert("실제  오라클서버에 접속해서 INSERT를 처리하는 코드가 여기 위치");
			//$("#f_memIns").attr("method","get");//get방식 전송 : 경로공개
			$("#f_memIns").attr("method","post");//post방식 전송 : 경로은폐(post방식의 한글처리하는 인코딩 위치가 달라서 깨질것)
			$("#f_memIns").attr("action","./memInsAction.jsp");//jsp에서 DB에 INSERT처리할 것
			$("#f_memIns").submit();//이때 사용자의PC에서 톰켓서버로 전송이 일어남.
			$('#dlg_memIns').dialog('close');//저장하고나면 닫게됨
		}
		
		/* 지정형식으로 달력출력하기위한 함수선언부 */
		function myformatter(date){
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
        }
        function myparser(s){
            if (!s) return new Date();
            var ss = (s.split('-'));
            var y = parseInt(ss[0],10);
            var m = parseInt(ss[1],10);
            var d = parseInt(ss[2],10);
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
                return new Date(y,m-1,d);
            } else {
                return new Date();
            }
        }
	</script>	
</head>
<body>
<!--

	회원관리업무
	-회원가입 	~(Oracle)INSERT INTO 회원집합 VALUES(?,?,?,?); >>> 파라미터가 필요하다!!
			~메소드이름(String id, String name, String gender, String phoneNum)
	
	-회원탈퇴 ~(Oracle)DELETE FROM 회원집합 WHERE mem_id=? >>파라미터 1개(PK)
	
	-회원정보수정 ~(Oracle)UPDATE 회원집합  SET address =? WHERE mem_id=?
	
	-회원정보조회  ~(Oracle)Select
	
	
	SQL실행 4단계
	1) 파싱
	2) 실행계획
	3) 옵티마이저 실행계획 넘김
	4) open....cursor....fetch....close
	
	정적쿼리 :: 상수이기때문에, 모두 다 다른 코드로 인식
	
	동적쿼리(PreparedStatement) :: 1,2단계스킵 (공정이 줄어든다 ) >> SQL실행속도 상승 >> 
	
	프로시저용 동적쿼리(CallableStatement)
	
	
	View계층(Client)~UI :: xxxx.jsp
		저장버튼(이벤트처리-js-jqeury)
		서버접속(WerServer-Tomcat & DBServer-Oracle)
		전송(파라미터를 넘겨야한다) : testbox에 입력된 값을 서버로 넘긴다~~~
		웹서버 전송방식(get(주소창 경로노출-보안취약)|post(경로은폐))
		
		화면단의 폼전송(<form (전송방식)method="get|post" (이벤트처리)action="../xxx.jsp|javacode")
		폼전송을 jquery API로 해보자..!
		
		<form id="이름" method"got|post> action="xxxx.jsp | xxxx.java(서블릿-HTTP통신)"
			입력창 4개( 아이디, 이름, 성별, HP )
		</form>
		
		자바스크립트로 쓰면?
		document, detElementByid("f_member).method="get';
	
		jquery로 바꾸면?
		$("#f_member").attr("method","get");
		$("#f_member").attr("action","xxx.jsp");
		$("#f_member").submit();//이때 사용자의PC에서 톰켓서버로 전송이 일어남.
		
		xxx.jsp
		
		memberAction.jsp
		
 -->
	<script type="text/javascript">
		/* 이 jsp문서 전체를 가리키는 내장객체 document */
		$("document").ready(function() {
			$("#dg_member").datagrid({//객체-속성과 함수를 거느릴 수 있다. 실행문으로 소화시키자
				width:502,
				height:450,
				title:"회원관리",
				toolbar:"#tb_member",
			//조회를 눌러야 보이도록 변경했음(바디에서 처리되는 json을 넣지않으면 됨)
			/* 	url:"../json/memberJSON.json", */
			    columns:[[
			        //자바스크립트에 한해서, boolean은 0을 제외한 모든 값이 true이다. 0은 false임
			    	{field:'mem_ck',title:'선택',width:50,checkbox:'true',align:'center'},
			        {field:'mem_id',title:'ID',width:100,align:'center'},
			        {field:'mem_name',title:'견종명',width:100,align:'center'},
			        {field:'mem_gender',title:'성별',width:100,align:'center'},
			        {field:'mem_hp',title:'보호자연락처',width:172,align:'center'}
			    ]],
			    onDblClickRow:function(index,row){
			    	alert("index : "+index+", row : "+row.mem_name
			    			+", hp : "+row.mem_hp);
			    }/* ,
			    onCheck:function(index,row){
			    	alert('mem_ck'+$(this).is('checked'));
			    	if(index>=0){
			    		$.messager.confirm('confirm','정말 삭제할거야?',function(r){
			    			if(r){
			    				alert('mem_id+"의 삭제가 완료되었습니다.");
			    				delRow(index);
			    			}
			    			else{
			    				alert(r+"의 삭제가 취소되었습니다.");
			    			}
			    		});
			    	}
			    } */
	 		    //checkOnSelect:true
			    //onLoadSuccess:function(){alert("성공")},
			    //onLoadError:function(){alert("실패")}
			});
			///////////////////////////////////////////////end of datagird
			$('#pg_top').pagination({
			    total:100,
			    pageSize:10
			});
		});
		
	</script>
		<div id="tb_member">
			<table>
				<tr><!-- 2층  : 아이디 검색 &달력컴포넌트 추가-->
					<td>
				<!-- =============================[검색기능 추가하기 시작]============================= -->
						<input id="ss" class="easyui-searchbox" style="width:230px"
		        				data-options="searcher:idSearch,prompt:'아이디입력'"></input>
				<!-- =============================[검색기능 추가하기 끝]============================= -->
						<!-- 등록일 추가 -->
						&nbsp;&nbsp;등록일 :&nbsp;
				<!-- =============================[달력 추가하기 끝]============================= -->
						<!--자체블럭이 있는 div 
						<div id="cal_date" class="easyui-calendar" style="width:250px;height:250px;"></div> -->
						<!-- 인라인요소인 span 
						<span id="cal_date" class="easyui-calendar" style="width:50%;height:250px;"></div>-->
						<input class="easyui-datebox" labelPosition="top" data-options="formatter:myformatter,parser:myparser" style="width:35%;">
				<!-- =============================[달력 추가하기 끝]============================= -->
					</td>
				</tr>
			</table>
			
			<!--=============================[툴바버튼 추가 시작]============================= -->
			<tr><!-- 1층 : 버튼추가 -->
			<td>
				<!-- themes/icons.css 에서 아이콘 조회하고 이름으로 링크추가가능-->
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"	plain="true" onclick="javascript:search1()">조회</a>
				<a href="#"	onclick="javascript:addRow()">행추가</a>
				<a href="#"	onclick="javascript:delRow()">행삭제</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-add" closed="true" plain="true" onclick="javascript:add()">등록</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-edit" plain="true"onclick="javascript:edit()">수정</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:cut()">삭제</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-save" plain="true"onclick="javascript:save()">저장</a>
				<a href="#"	class="easyui-linkbutton" iconCls="icon-order2" plain="true"onclick="javascript:order2()">링크</a>
			</td>
			</tr>
		</div>
		<!--=============================[툴바버튼 추가 끝]============================= -->
	<!-- =============================[검색기능 추가하기  끝]============================= -->
	
	
	<table id="dg_member" class = "easyui-datagrid" style = "width : height:" url = "../json/memberJSON.json ">
	</table><!-- 상단의 body스크립트에서 정의된 내용의 테이블을 표시함 -->

	<!--====	=========================[회원목록 시작]=============================-->
<!-- 	<thead id="dg_member">
		<tr>
			<th width="50px" checkbox='tree'></th>
			<th width="120px" feild='mem_id'>아이디</th>
			<th width="150px" feild='mem_name'>이름</th>
			<th width="80px" feild='mem_gender'>성별</th>
			<th width="150px" feild='mem_hp'>HP</th>
		</tr>
	</thead> -->
	<!--=============================[회원목록 끝]=============================-->
	
	<!--=============================[등록화면(다이얼로그) 시작 ]=============================-->
	<div id="dlg_memIns" class="easyui-dialog" title="회원등록" style="width:400px;height:220px;"
        data-options="iconCls:'icon-save',closed:true,resizable:true,modal:true,buttons:'#btn_dlg_memIns'">
        <!-- 폼태그로 서버로 자료옮기기 -->
        <form id="f_memIns">
        <!-- 오와 열을 맞추어 입력창을 넣기위해 Table이 추가됨-->
        <!--=============================[등록화면에 기입할 자리 넣기 시작]=============================-->
        <table>
        	<tr><!-- 공백울 주는 예약어 : &nbsp; -->
        		<td width="150px">아이디</td>
        		<td width="250px"><input class="easyui-textbox" style="width:230px" name="mem_id" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">이름</td>
        		<td width="250px"><input class="easyui-textbox" style="width:150px" name="mem_name" required="true"></td>
        	</tr>
        	<tr>
        		<td width="150px">성별</td>
        		<td width="250px"><input class="easyui-textbox" style="width:150px" name="mem_gender"></td>
        	</tr>
        	<tr>
        		<td width="150px">연락처</td>
        		<td width="250px"><input class="easyui-textbox" style="width:230px" name="mem_hp"></td>
        	</tr>
        </table>
        </form>
	</div>
    <!-- =============================[등록화면에 기입할 자리 넣기 끝]=============================-->
    
	<!-- =============================[등록화면에 버튼넣기 시작 ]=============================-->
	<div id="btn_dlg_memIns">
		<a href="javascript:memIns()" class="easyui-linkbutton">저장</a>
		<a href="javascript:$('#dlg_memIns').dialog('close')" class="easyui-linkbutton">닫기</a>
	</div>
	<!-- =============================[등록화면에 버튼넣기 끝 ]=============================-->
	
	<!-- =============================[페이지네이션 시작]============================= -->
	<div id="pg_top" style="background:#efefef;border:1px solid #ccc;width:496px"></div>
	<!-- =============================[페이지네이션 끝]============================= -->
</body>
</html>