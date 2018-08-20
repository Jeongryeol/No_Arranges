<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%
	String smem_name = null;
    String sstatus = null;
	if(session.getAttribute("smem_name")!=null){
		smem_name = session.getAttribute("smem_name").toString();
	}
	if(session.getAttribute("sstatus")!=null){
		sstatus = session.getAttribute("sstatus").toString();
	}
	//out.println(smem_name);
	//JSON포맷으로 내보내기
	StringBuilder sb = new StringBuilder();
	sb.append("[{\"sstatus\":"+sstatus+","+"\"smem_name\":\""+smem_name.trim()+"\"}]");
	out.clear();//앞에 처리된 내용을 비운다.
	out.print(sb.toString());
%>	