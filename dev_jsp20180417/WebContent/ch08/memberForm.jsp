<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
</head>
<body>
<jsp:useBean id="jobDao" class="com.ch08.JobDao" scope="request"/>
//insert here - �޼ҵ� ȣ���ϱ�
<%
	List<Map<String,Object>> jobList = jobDao.getJobList("1");
	//out.print(jobList.size());
	int size = 0;//��ȸ����� �ִ� ��� ó���ؾ� �ϹǷ� �ο��� ���� ���
	if(jobList !=null){
		size = jobList.size();
	}
%>
���̵� : <br>
��  �� : <br>
�� �� : <br>
���� : <select>
<%
	for(int i=0;i<size;i++){
		Map<String,Object> rMap = jobList.get(i);
%>
 		<option value="<%= rMap.get("J_NAME")%>"><%= rMap.get("J_NAME")%></option>
<%
	}
%>
	  </select><br><!-- DB�������� ��ȸ�� ��� ����(���Դ���, ȭ�����, ����) -->
</body>
</html>








