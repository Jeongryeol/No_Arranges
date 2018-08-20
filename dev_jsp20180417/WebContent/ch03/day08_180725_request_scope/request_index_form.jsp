<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>request방식을</title>
</head>
<body>
<form action="request_method.jsp" method="get">
	이름 : <input type="text" name="name"/><br><br>
	휴대번호 : <input type="text" name="hp"/><br><br>
	우편번호 : <input type="text" name="zipcode"/><br><br>
	자택주소 :<input type="text" name="address"/><br><br>
	기타1<input type="text" name="input1"/><br><br>
	기타2<input type="text" name="input2"/><br><br>
	기타3<input type="text" name="input3"/><br><br>
	<input type="checkbox" name="pet" value="pet"/>강아지
	<input type="checkbox" name="pet2" value="pet"/>고양이
	<input type="checkbox" name="pet3" value="pet"/>고슴도치<br><br>
	<input type="submit" name="전송"/><!-- 누르는 즉시 전송 -->
</form>
</body>
</html>