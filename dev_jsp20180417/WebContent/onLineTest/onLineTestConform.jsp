<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String db_testno = "A0001";
	String db_testname= "�̼���";
	//����ڰ� �Է��� �����ȣ ��������
	String u_testno = request.getParameter("test_no");
	//����ڰ� �Է��� �̸� ��������
	//<input type="text" name="test_name" size="15">
	String u_testname = request.getParameter("test_name");
	out.println("�����ȣ:"+u_testno+", �̸�:"+u_testname);
	if(db_testno.equals(u_testno)){
		if(db_testname.equals(u_testname)){
			response.sendRedirect("./onLineTestOk.html");//���������޽��� ���
		}
	}
%>