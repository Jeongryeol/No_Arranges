<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.setAttribute("mem_id", "test");
	session.setAttribute("bread", "�Һ��λ�");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>session �׽�Ʈ :: Tomcat�� �⺻�� 30���Դϴ�.</title>
</head>
<body>
īƮ�� ��� ���� ��� : <%= session.getAttribute("bread").toString() %>
<%
	String myName = "myName�� ��µǾ��׿�. �����Ͱ� �����˴ϴ�.";
	request.setAttribute("myName",myName);
	
	//sendRedirect�� ����ϸ� URL�� �ٲ��.
	//URL�� �ٲ�� ���ο� ��û�� �� ������ �ν��ϹǷ� request�� ������ ������ ���� ����
		//�� ���帮���̷�Ʈ�� ��û�� �� �������� �ּҿ� ������ ������ �������� �ּҰ� �ٸ�
	//response.sendRedirect("03_session_account.jsp");
	
	//include - URL�� �״�� �̹Ƿ� �����ȴ�.
	
	//forward - URL�� �ٲ��� �ʴµ� �������� �ٲ�鼭 ������.
		//��, ������� ��û�� �� �������� �ּҿ� ������ ������ �������� �ּҰ� ����
	RequestDispatcher view = request.getRequestDispatcher("03_session_account.jsp");
	view.forward(request,response);
	/* 
		���� �и� 02_session.jsp�� ��û(request��ü)�ߴµ�,
		����ȭ�鿡 ��µǴ°� 03_session_account.jsp�������� ��µ˴ϴ�.
		���ϼ����� ��û�� �����Ǵ� ������ �Ǵ��Ͽ�
		02_session�� "�ּ�(URL)"��  03_session_account�� "ȭ��"�� ����մϴ�.
	*/
%>
</body>
</html>