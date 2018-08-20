<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table border="1" bordercolor="red" align="center" width="800px" height="600px">
<%
	String mission = request.getParameter("p_mission");
	String quest = request.getParameter("p_quest");
%>
<%
	java.util.Date CURRNENT_TIME = new java.util.Date();
%>
	<tr valign="middle">
		<!-- 메뉴 : menu.jsp include하자-->
		<td align="center">
			<jsp:include page="./menu.jsp"/>
			<%= CURRNENT_TIME %>
			<h3>mission = <font color="#31B404"><%=mission %></font></h3>
			<h3>quest = <font color="#0551F4"><%=quest%></font></h3>
		</td>
		<!-- 내용 : body.jsp include하자-->
		<td align="center">
			<jsp:include page="./body.jsp">
				<jsp:param value="<%=CURRNENT_TIME %>" name="time"/>
			</jsp:include>
		</td>
	</tr>
</table>