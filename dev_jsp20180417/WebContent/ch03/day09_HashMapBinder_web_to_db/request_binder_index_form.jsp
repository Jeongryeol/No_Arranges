<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>request�� name��ü�� �ϰ������ϱ�</title>
	<!-- jQuery script import code :: $-undifined error ����!!! -->
<script type="text/javascript" src="/js/jquery-1.12.0.js"></script>
</head>
<body>
<!-- 
	get��� : ��ũ�� �� �� �ִ�.
			�ѱ� �� �ִ� ���� ������ �ִ�.
			�����׽�Ʈ�� �����ϴ�.
			���� ����ȴ�.
		�ѱ�ó���� server.xml�� �Ѵ�.
		���ͼ�Ʈ ���� �� �ִ�.(������ ȣ���ߴ� �������� ��� cache�޸𸮿� ����Ǿ� �ֱ� ������ �������� ���޾���)
			
	post��� : ��ũ�� �� �� ����.
			 �ѱ�� �ִ� ���� ������ ����.
			 �����׽�Ʈ�� �Ұ����ϴ�.
			 ���� ������� �ʴ´�.
		���ͼ�Ʈ�� �� ����. (��? ����Ǿ��־ ������ �ȵǹǷ� ������ ������ �ѱ�)
 -->
<form action="../login.do" method="GET">
	�̸� : <input type="text" name="name"/><br><br>
	�޴��ȣ : <input type="text" name="hp"/><br><br>
	�����ȣ : <input type="text" name="zipcode"/><br><br>
	�����ּ� : <input type="text" name="address"/><br><br>
	��Ÿ1 : <input type="text" name="input1"/><br><br>
	��Ÿ2 : <input type="text" name="input2"/><br><br>
	��Ÿ3 : <input type="text" name="input3"/><br><br>
	<input type="checkbox" name="pet" value="pet"/>������
	<input type="checkbox" name="pet2" value="pet"/>�����
	<input type="checkbox" name="pet3" value="pet"/>����ġ<br><br>
	<input type="submit" name="����"/><!-- ������ ��� ���� -->
</form>
</body>
</html> 	