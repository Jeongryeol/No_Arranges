<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
�ֱٿ� �� ��ǰ ���
<table border="1">
	<tr><th>��ǰ��</th><th>&nbsp;</th></tr>
<%
Cookie[] cs = request.getCookies();
String c_value = null;
String sunglass = null;
String shortpants = null;
String suncream = null;
String shortshirts = null;
String slipper = null;
if(cs !=null && cs.length>0){//��Ű�� �����ϴ�?
	for(int i=0;i<cs.length;i++){
		String c_name = cs[i].getName();
		/* ��ǰ ���� ��ȸ �ϱ� ���� */
		if(c_name=="sunglass"){
			sunglass = URLDecoder.decode(cs[i].getValue(),"utf-8");
			out.print("<tr><th>"+sunglass+"</th></tr>");
		}
		else if(c_name=="shortpants"){
			shortpants = URLDecoder.decode(cs[i].getValue(),"utf-8");
			out.print("<tr><th>"+shortpants+"</th></tr>");
		}
		else if(c_name=="suncream"){
			suncream = URLDecoder.decode(cs[i].getValue(),"utf-8");
			out.print("<tr><th>"+suncream+"</th></tr>");
		}
		else if(c_name=="shortshirts"){
			shortshirts = URLDecoder.decode(cs[i].getValue(),"utf-8");
			out.print("<tr><th>"+shortshirts+"</th></tr>");
		}
		else if(c_name=="slipper"){
			slipper = URLDecoder.decode(cs[i].getValue(),"utf-8");
			out.print("<tr><th>"+slipper+"</th></tr>");
		}
		/* ��ǰ ���� ��ȸ �ϱ�  �� */
	}	
}///end of if
%>	
<%

%>
	<tr><td colspan="2">�ֱٿ� �� ��ǰ�� �����ϴ�.</td></tr>
</table>
</body>
</html>