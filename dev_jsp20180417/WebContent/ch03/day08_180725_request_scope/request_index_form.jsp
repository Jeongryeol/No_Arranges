<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>request�����</title>
</head>
<body>
<form action="request_method.jsp" method="get">
	�̸� : <input type="text" name="name"/><br><br>
	�޴��ȣ : <input type="text" name="hp"/><br><br>
	�����ȣ : <input type="text" name="zipcode"/><br><br>
	�����ּ� :<input type="text" name="address"/><br><br>
	��Ÿ1<input type="text" name="input1"/><br><br>
	��Ÿ2<input type="text" name="input2"/><br><br>
	��Ÿ3<input type="text" name="input3"/><br><br>
	<input type="checkbox" name="pet" value="pet"/>������
	<input type="checkbox" name="pet2" value="pet"/>�����
	<input type="checkbox" name="pet3" value="pet"/>����ġ<br><br>
	<input type="submit" name="����"/><!-- ������ ��� ���� -->
</form>
</body>
</html>