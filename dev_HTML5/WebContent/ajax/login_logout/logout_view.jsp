<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table id="t_login" width="250px" height="60px" border="1" bordercolor="red">
	<tr>
		<td width="150px" align="center">
			<!-- ���̵� �Է�â -->
			<input type="text" id="mem_id" value="ID" size="10"
				onClick="javascript:document.getElementById('mem_id').value=''">
		</td>
			<!-- �α��ι�ư+Ȯ��-->
		<td rowspan="2" width="80px" align="center">
			<input type="button" id="btn_login" value="LOGIN"
			 onClick="javascript:login()">
		</td>
	</tr>
	<tr>
		<td align="center" >
			<!-- ��й�ȣ �Է�â -->
			<input type="text" id="mem_pw" value="PW" size="10"
				onClick="javascript:document.getElementById('mem_pw').value=''">
		</td>
	</tr>
</table>