<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%
	String smem_name = null;
    String sstatus = null;
    int cnt = 0;
	if(session.getAttribute("smem_name")!=null){
		smem_name = session.getAttribute("smem_name").toString();
	}
	if(session.getAttribute("sstatus")!=null){
		sstatus = session.getAttribute("sstatus").toString();
	}
	if(session.getAttribute("cnt")!=null){
		cnt = Integer.parseInt(session.getAttribute("cnt").toString());
		cnt = cnt+1;
		session.setAttribute("cnt",cnt);
	}	
	//out.println(smem_name);
	//JSON�������� ��������
	StringBuilder sb = new StringBuilder();
	sb.append("[{\"sstatus\":"+sstatus+","+"\"smem_name\":\""+smem_name.trim()+"\""+","+"\"cnt\":"+cnt+"}]");
	out.clear();//�տ� ó���� ������ ����.
	out.print(sb.toString());
%>