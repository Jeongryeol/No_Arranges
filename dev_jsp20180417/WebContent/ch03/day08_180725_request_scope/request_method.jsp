<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map, java.util.HashMap"%>
<%
/*
	�Է��ϴ� ȭ�鿡�� ����ڷκ��� �Է¹޾ƾ��ϴ� ���� 100������ �Ѵ´ٰ� �����غ���.
	�� ������ �� ������ �ѱ���� ���� �����ϰ� �ȴ�.
	�� ������ �ϳ��� �ּҹ����� ó���Ͽ� ���뼺�� ���̴� ����� ������? [ hint:Map ]
*/
	/* String mem_id = request.getParameter("mem_id");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String zipcode = request.getParameter("zipcode");
	String address = request.getParameter("address"); */

	//���뼺�� ���̱� ���� �ݺ��Ǵ� �ڵ带 ���̴� ����� ���� ��.
	//Spring Framework�� MVC������ ������ ���뼺 �������� ���ԵǾ��ֱ� ��.
	
	//���?
	Enumeration<String> enNames = request.getParameterNames();
	Map<String,Object> nameMap = new HashMap<String,Object>();
	for(int i=0;enNames.hasMoreElements();i++){
		nameMap.put("name"+i, enNames.nextElement());
	}
	for(int i=0;i<nameMap.size();i++){
		out.print("idMap["+i+"] = "+nameMap.get("name"+i)+"<br>");
	}
	
%>
<%
	//Enumeration : Iterator�� �����������̽�
	//.getParameterNames("") : �Ķ������ �̸�(name�Ӽ�)�� �� 
	Enumeration<String> en = request.getParameterNames();
	while(en.hasMoreElements()){//����׽�Ʈ
		String key = en.nextElement();
		out.print("key : "+key+"<br>");
	}
	
	//.getParameterValues("") : �Ķ������ ��(value�Ӽ�)�� ��
	String pets[] = request.getParameterValues("pet");
	for(int i=0;i<pets.length;i++){//����׽�Ʈ
		out.print("pets["+i+"] : "+pets[i]+"<br>");
	}
	
	//.getContentType() : String ::����ڰ� ��û��ü������ �����Ҷ� ����� ������ Ÿ���� ����
	Cookie cookie[] = request.getCookies();
	
%>
	<br>
	<br>Ŭ���̾�Ʈ ip = <%= request.getRemoteAddr()%>
	<br>��û�������� = <%= request.getContentLength()%>
	<br>��û���� ���ڵ� = <%= request.getCharacterEncoding()%>
	<br>��û���� ������Ÿ�� = <%= request.getContentType()%>
	<br>��û���� �������� = <%= request.getProtocol()%>
	<br>��û���� ���۹�� = <%= request.getMethod()%>
	<br>��û URL = <%= request.getRequestURL()%>
	<br>���ؽ�Ʈ ��� = <%= request.getContextPath()%>
	<br>�����̸� = <%= request.getServerName()%>
	<br>������Ʈ = <%= request.getServerPort()%>