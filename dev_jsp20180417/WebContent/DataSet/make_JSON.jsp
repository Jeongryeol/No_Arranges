<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.List, java.util.ArrayList"%>
<%@ page import = "java.util.Map, java.util.HashMap" %>
<%@ page import = "com.google.gson.Gson" %>
<%@ page import = "DataSet.UserVO" %>
<%@ page import = "java.util.Arrays" %>
<%@ page trimDirectiveWhitespaces = "true" %><%-- xml/json���� �������� --%>
<%
	//List �غ�
	List<Map<String,Object>> userList = new ArrayList<>();
	//Map �غ�
	Map<String,Object> rMap	= new HashMap<>();
	
	//Map�� Ű�� �� ���, List�� ���(�ݺ�)
	rMap.put("id","First_Account");
	rMap.put("pw","123");
	rMap.put("name","ù��° ����� �̸�");
	userList.add(rMap);
	
	rMap = new HashMap<String,Object>();
	rMap.put("id","Second_Account");
	rMap.put("pw","456");
	rMap.put("name","�ι�° ����� �̸�");
	userList.add(rMap);
	
	rMap = new HashMap<String,Object>();
	rMap.put("id","Third_Account");
	rMap.put("pw","789");
	rMap.put("name","����° ����� �̸�");
	userList.add(rMap);
	
	//Gson�غ�
	Gson gs = new Gson();
	//Gson��ü�� �޼ҵ带 �̿��ؼ� List�� json���ڿ��� ��ȯ�ϱ�
	String jsonUser = gs.toJson(userList);

/*
	==========[[ JAVA���� ��밡���ϵ��� JSON���� ��ȯ�ϱ�]]==========
*/
	//json���ڿ��κ��� VO���ϰ�ü�迭 �����ϱ�
	UserVO[] users = gs.fromJson(jsonUser,UserVO[].class);
	//��ü�迭�� List�� ��ȯ�ϱ�
	List<UserVO> newList = new ArrayList<>(Arrays.asList(users));
	//������ for������ ����� Ȯ���մϴ�.
	for(UserVO uvo : newList){
		out.print(uvo.getId()+", ");
		out.print(uvo.getPw()+", ");
		out.print(uvo.getName()+"<br>");
	}
%>