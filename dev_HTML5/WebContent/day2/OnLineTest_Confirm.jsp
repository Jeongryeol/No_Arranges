<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8" />
<%
request.setCharacterEncoding("euc-kr");
String db_testno = "A0001";
String db_testname = "�̼���";

String u_testno = request.getParameter("mem_id");
String u_testname = request.getParameter("mem_name");

//out.println(u_testname+" ��, ���������غ� �Ϸ�Ǿ����ϴ�. �����Ͻðڽ��ϱ�?");
if(db_testno.equals(u_testno)){
	if(db_testname.equals(u_testname)){
		response.sendRedirect("./OnLineTestOk.html");//���������޽������
	}else{
		response.sendRedirect("./OnLineTestNo.html");//���������޽������
	}
} 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CONFRIM</title>
<script type="text/javascript">
	function send(){
		document.getElementById("i_form").submit();
	}
 </script>
</head>
<body>
<form name="n_form" id="i_form" method="post" action="./OnLineTest_1.jsp">
	<input type="button" value="�����ϱ�" onClick="send()">
</form>
</body>