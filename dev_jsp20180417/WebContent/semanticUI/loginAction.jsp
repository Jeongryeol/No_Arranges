<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Cookie[] cs = request.getCookies();
	String c_value = null;
	if(cs !=null && cs.length>0){//��Ű�� �����ϴ�?
		for(int i=0;i<cs.length;i++){
			String c_name = cs[i].getName();
			if("cmem_name".equals(c_name)){
				c_value = cs[i].getValue();
			}
		}	
	}///end of if
	//out.print(c_value);
	String s_mem_name = c_value;
	out.print(s_mem_name+"�� ȯ���մϴ�.");
%>