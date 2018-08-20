<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- BasicType으로 태드안에다 만들 파일 -->

<!--
	javascript코드는 html태그안에 어디든 올 수 있다. (head태그 안, body태그 안)
	두 위치의 차이는??
		head태그의 javascript는 선언할 때 사용함
			( 변수-전역변수 , 함수 ) : 선언 후 불러야 실행됨
		body태그의 javascript는 따로 부르지 않아도 실행됨
			: 주의사항 ! DOM구성이 먼저 ( 선언 후 사용 /구현 후 호출 )
			: DOM구성한 정보는 브라우저가 알고 있다.
	
	1)DOM구성이 완료되었을 때를 브라우저에게 묻고싶다.-ready() 호출
	2)함수의 파라미터 자리에도 코딩전개(구현)이 가능하다.-주의사항 : 좌우중괄호로 구현부 영역표시 ( {} )
	3)좌중괄호와 우중괄호안에는 속성추가, 이벤트처리(이벤트구현)가 가능하다
-->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>A TYPE</title>

<!-- js파일과 css파일 import -->
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	
</head>
<body><!-- 화면에 보여주기위해 body태그를 만듬 -->
<table border="1" width="500px" class="easyui-datagrid" title = "메신저">
	<thead>
		<tr>
			<th data-options="field:'nickName',width:120,align:'center'">대화명</th>
			<th data-options="field:'roomName',width:200">방이름</th>
			<th data-options="field:'status',width:120">대화명</th>
		</tr>
	</thead>
	<tbody>
        <tr>
            <td>001</td><td>name1</td><td>2323</td>
        </tr>
        <tr>
            <td>002</td><td>name2</td><td>4612</td>
        </tr>
    </tbody>
</table>
</body>
</html>