<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLDecoder"%>
<%
	int result = 0;
	//�α��� ���� üũ
	Cookie[] cs = request.getCookies();
	String c_value = null;
	if(cs != null && cs.length>0){//��Ű�� �����Ѵٸ�
		for(int i=0;i<cs.length;i++){
			String c_name = cs[i].getName();
			if("cmem_name".equals(c_name)){
				c_value = cs[i].getValue();
			}
		}
	}
	String s_mem_name = "�̼���";
	out.print(s_mem_name+" �� ȯ���մϵ�.");
%>