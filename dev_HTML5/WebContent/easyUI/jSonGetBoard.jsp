<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- JSP������ ���������� �̰ɷ� �ּ��� �޾ƾ��� --%>
    <!-- �� �ּ��� HTML �������� ����ϴ� �ּ�  (eclipse�� �̰� �ڵ��ϼ���....)-->
<%@ page import = "java.util.*" %>
<%@ page import = "com.google.gson.Gson" %>

<%
	/*  �����ϰ� �ڷḦ �����ϴ� HashMap�� List�迭���� �ڷ�ó���ӵ��� ������ ������.
		�׷��Ƿ� ��뷮 �ڷḦ �����ϴ� ��쿡�� HashMap���� �ڷḦ �����ϴ� ���� ����.*/
	
	List<HashMap<String,Object>> boardList
		= new ArrayList<HashMap<String,Object>>();
	HashMap<String,Object> map
		= new HashMap<String,Object>();
	
	map.put("b_no",5);
	map.put("b_title","�Խ��� ����");
	map.put("b_writer","�̼���");
	boardList.add(map);

	map = new HashMap<String,Object>();
	map.put("b_no",4);
	map.put("b_title","�Խ��� ����2");
	map.put("b_writer","�̼���");
	boardList.add(map);
	
	map = new HashMap<String,Object>();
	map.put("b_no",3);
	map.put("b_title","�Խ��� ����3");
	map.put("b_writer","ȫ�浿");
	boardList.add(map);
	
	Gson g = new Gson();
	String board=g.toJson(boardList);
	//�� �������� ���
	out.print(board);
%>

