<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������� �޶� ���ǿ� �����ֱ� ������ 30�е����� �����˴ϴ�.</title>
</head>
<body>
02_session���� <b>session</b>�� �����߾��� "bread" ���� ���⼭�� ���ɱ�?<br>
<br>
	īƮ�� ��� ���� ��� : <%= session.getAttribute("bread").toString() %><br>
<br>
	������ ������ �⺻������ 30�а� �����մϴ�. �׷��Ƿ� �������� �޶� ���� ���ֽ��ϴ�.
<br>
<br>
�׷��ٸ�, 02_session���� <b>sendRedirect</b>�� �̰��� �Ѱܿ�  myName�� ���⼭�� �ҷ������?<br>
	<%-- <%= myName %> --%>
	������ �߻��Ұ̴ϴ�.<br>
	URL�� �ٲ���� ������ ���ο� ��û�� �Ͼ���Ƿ� ��ũ��Ʈ���� ������������ ������ ���Դϴ�.<br>
<br>
<br>
�׷��ٸ�, 02_session���� <b>forward</b>�� ������ �̵��� �Ѵٸ� ����?<br>
	<b><%= request.getAttribute("myName") %><br></b>
	ȭ���� ���� ȭ���� ������ ���� �� ���� �а� �ְ�����,<br>
	�ּҴ� 02_session�� URL�� �״�� �̿��ϰ� �����̴ϴ�.<br>
	�׷��鼭 �����ʹ� �� �����ǰ� �ְ���.<br>

</body>
</html>