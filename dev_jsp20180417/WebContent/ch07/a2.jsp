<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
/*
	
*/
	List<Map<String,Object>> boardList = 
	(List<Map<String,Object>>)request.getAttribute("boardList");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr><th>�۹�ȣ</th><th>������</th></tr>
<%
	if(boardList !=null && boardList.size()>0){
		for(int i=0;i<boardList.size();i++){
		Map<String,Object> rMap = boardList.get(i);
%>
<!-- myBatis�� ����� �� �ݵ�� �빮�ڷ� �ۼ��Ұ�. -->
    <tr><th><%=rMap.get("b_no") %></th><th><%=rMap.get("B_title") %></th></tr>
<%
		}
	}
	else{
%>	
    <tr><th colspan="2">��ȸ����� �����ϴ�.</th></tr>
<%
	}
%>
</table>
</body>
</html>