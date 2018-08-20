<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<body>
<jsp:useBean id="jobDao" class="com.ch08.JobDao" scope="request"/>
//insert here - 메소드 호출하기
<%
	List<Map<String,Object>> jobList = jobDao.getJobList("1");
	//out.print(jobList.size());
	int size = 0;//조회결과가 있는 경우 처리해야 하므로 로우의 수를 담기
	if(jobList !=null){
		size = jobList.size();
	}
%>
아이디 : <br>
이  름 : <br>
비 번 : <br>
직업 : <select>
<%
	for(int i=0;i<size;i++){
		Map<String,Object> rMap = jobList.get(i);
%>
 		<option value="<%= rMap.get("J_NAME")%>"><%= rMap.get("J_NAME")%></option>
<%
	}
%>
	  </select><br><!-- DB서버에서 조회한 결과 제공(무게단위, 화폐단위, 직업) -->
</body>
</html>








