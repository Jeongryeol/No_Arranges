<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch11.EmpDAO,com.vo.VO_FoodStore" %>
<%
	/* json���Ͽ� DB�� �ڷḦ �����ͺ���!! import�� ���� ���� ����!!*/
	/* TomCat�� jdbc�� jar������ ã�����ؼ� ����̹��� ���� ���Ѵٸ�,
		WEB-INF.lib�� jar������ �����صΰų� 
		TomCat��ġ�� ����� jar������ ���ΰ��� jar����̹��� �������ش�.*/
	int userEmpno = Integer.parseInt(
					request.getParameter("empno"));
	EmpDAO eDao = new EmpDAO();
	int result = 0;
	result = eDao.delete(userEmpno);
	//out.println(result);
	response.sendRedirect("./datagridEmp.jsp");//������ ��ȯ�ϵ��� ����
%>