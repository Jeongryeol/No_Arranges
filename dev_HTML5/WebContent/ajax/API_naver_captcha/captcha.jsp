<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/include/commonUI.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Naver OPEN API :: Captcha Service</title>
<script type="text/javascript">
	function testPopup(){
		//alert("�����Ǿ����ϴ�.");
		location.href = "./captchaView.jsp";
	}
</script>
</head>
<body>
<!-- ��ġ���� -->
<div align="center">
<table width="600" height="400">
<tr valign="middle"><td align="center">
<!-- �׵θ� -->
<table border="1">
<tr><td>
<!-- �α��ιڽ� -->
<table>
	<tr valign="middle">
		<td align="center">
		<!-- ���̵� �Է�ĭ -->
		<div style="margin-top:10px;margin-bottom:10px;margin-right:5px">
		<a href="#" title="���̵� �Է����ּ���" class="easyui-tooltip" position="left">
		<input class="easyui-textbox" prompt="ID"
				iconWidth="28" data-options="iconCls:'icon-man'"
				style="text-align:center;width:100%;height:34px;padding:10px 10px;"/></a>
		</div>
		<!-- ��й�ȣ �Է�ĭ -->
		<div style="margin-bottom:10px;margin-right:5px">
		<a href="#" title="��й�ȣ�� �Է����ּ���" class="easyui-tooltip" position="left">
		<input class="easyui-passwordbox" prompt="Password" iconWidth="28"
				style="text-align:center;width:100%;height:34px;padding:10px 10px" /></a>
		</div>
		</td>
		<td align="center"><!-- �α��ι�ư -->
		<a type="submit" class="easyui-linkbutton"
			 iconCls="icon-ok" style="width:100%;height:80px">Login</a>
		</td>
	</tr>
	<tr valign="middle"><!-- �ɼ� -->
		<td align="center" colspan="2">
			<a href="javascript:testPopup()">ȸ������</a>
			&nbsp;|&nbsp;
			<a href="javascript:testPopup()">��й�ȣã��</a>
		</td>
	</tr>
</table><!-- �α��ιڽ� �� -->
</td></tr>
</table><!-- ������ ��-->
</td></tr>
</table>
</div><!-- ��ġ���� �� -->

</body>
</html>