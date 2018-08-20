<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>request의 name객체를 일괄저장하기</title>
	<!-- jQuery script import code :: $-undifined error 주의!!! -->
<script type="text/javascript" src="/js/jquery-1.12.0.js"></script>
</head>
<body>
<!-- 
	get방식 : 링크를 걸 수 있다.
			넘길 수 있는 값에 제한이 있다.
			단위테스트가 가능하다.
			값이 노출된다.
		한글처리는 server.xml에 한다.
		인터셉트 당할 수 있다.(이전에 호출했던 페이지의 경우 cache메모리에 저장되어 있기 때문에 서버까지 전달안함)
			
	post방식 : 링크를 걸 수 없다.
			 넘길수 있는 값에 제한이 없다.
			 단위테스트가 불가능하다.
			 값이 노출되지 않는다.
		인터셉트할 수 없다. (왜? 포장되어있어서 노출이 안되므로 무조건 서버에 넘김)
 -->
<form action="../login.do" method="GET">
	이름 : <input type="text" name="name"/><br><br>
	휴대번호 : <input type="text" name="hp"/><br><br>
	우편번호 : <input type="text" name="zipcode"/><br><br>
	자택주소 : <input type="text" name="address"/><br><br>
	기타1 : <input type="text" name="input1"/><br><br>
	기타2 : <input type="text" name="input2"/><br><br>
	기타3 : <input type="text" name="input3"/><br><br>
	<input type="checkbox" name="pet" value="pet"/>강아지
	<input type="checkbox" name="pet2" value="pet"/>고양이
	<input type="checkbox" name="pet3" value="pet"/>고슴도치<br><br>
	<input type="submit" name="전송"/><!-- 누르는 즉시 전송 -->
</form>
</body>
</html> 	