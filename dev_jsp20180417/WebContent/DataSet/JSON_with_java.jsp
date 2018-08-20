<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataSet.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Web���� ����� gson������ �ڹٿ��� ����ϱ�</title>
</head>
<body>
<H1> Web���� ����� gson������ �ڹٿ��� ����ϱ� </H1>

<%
	//ListŸ������ �ڷḦ �غ��մϴ�.
	List<UserVO> users = new ArrayList<UserVO>();

	//VOŬ���� �� ȣ���ؼ� �� �÷��� �ο츦 ����
	UserVO uvo = new UserVO();
	uvo.setId("id1");
	uvo.setPw("pw1");
	uvo.setName("name1");
	users.add(uvo);//����Ʈ�� �ش� �ο츦 ����
	
	uvo = new UserVO();
	uvo.setId("id2");
	uvo.setPw("pw2");
	uvo.setName("name2");
	users.add(uvo);//����Ʈ�� �ش� �ο츦 ����
	
	uvo = new UserVO();
	uvo.setId("id3");
	uvo.setPw("pw3");
	uvo.setName("name3");
	users.add(uvo);//����Ʈ�� �ش� �ο츦 ����
	

	//Gson������ �غ��մϴ�.
	Gson gson = new Gson();
	
	//������ List�ڷḦ Gson�� �̿��ؼ� Json���� ��ȯ�մϴ�.(���ڿ�����)
	String userJSON = gson.toJson(users);
	out.print("userJSON = "+userJSON+"<br><br>");//���
	
	//��ȯ�� Json���κ��� VO���� ��ü�迭�� ��ȯ�մϴ�.
	UserVO[] JSONusers = gson.fromJson(userJSON, UserVO[].class);
	out.print("JSONusers[0] = "+JSONusers[0]+"<br>");
	out.print("JSONusers[1] = "+JSONusers[1]+"<br>");
	out.print("JSONusers[2] = "+JSONusers[2]+"<br>");
	out.print("JSONusers[0].getId() = "+JSONusers[0].getId()+"<br>");
	out.print("JSONusers[0].getPw() = "+JSONusers[0].getPw()+"<br>");
	out.print("JSONusers[0].getName() = "+JSONusers[0].getName()+"<br><br>");
	
	//��ȯ�� ��ü�迭�� List�� ��ȯ��ŵ�ϴ�.
	users = new ArrayList<>(Arrays.asList(JSONusers));
	out.print("users.get(0) = "+users.get(0)+"<br>");
	out.print("users.get(0).getId() = "+users.get(0).getId()+"<br>");
	out.print("users.get(0).getPw() = "+users.get(0).getPw()+"<br>");
	out.print("users.get(0).getName() = "+users.get(0).getName()+"<br><br>");
	
	//������ for������ ����մϴ�.
	for(UserVO uVO : users){
		out.print(uVO.getId()+", ");
		out.print(uVO.getPw()+ ", ");
		out.print(uVO.getName()+"<br>");
	}
	
%>

</body>
</html>