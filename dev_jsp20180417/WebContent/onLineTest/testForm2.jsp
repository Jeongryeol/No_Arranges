<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	//3�� ������������ �Ʒ� �ڵ尡 2�� �ʿ��ؿ�.
	//�ֳ��ϸ� 1���� 2�� �������� ���� ��������� ��ƾ� �ϴϱ�.....
	//1�� �������� �Ѿ�� ������� ����� ����?
	//String test1 = request.getParameter("htest1");
	//out.print("1�� ���� ��� - "+test1);
	
	//��Ű�� ������Ƿ�
	String test1 = request.getParameter("htest1");
	Cookie c = new Cookie("test1",test1);
	c.setMaxAge(60*60);
	response.addCookie(c);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����2</title>
<script type="text/javascript">
	function test(pcb){//���� pcb���� 0,1,2,3 �� �ϳ��� ���� ���´�.
		for(var i=0;i<document.f_test1.cb.length;i++){
			if(pcb==i){
				document.f_test1.cb[i].checked=1;
			}else{
				document.f_test1.cb[i].checked=0;
			}
		}
	}///////////end of test
	function prev(){
		location.href="testForm1.html";
	}
	function next(){
		var temp=1;
		for(var i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest2.value = temp;
			}else{
				temp = temp + 1;
			}
		}
		document.f_test1.submit();		
	}
</script>
</head>
<body>
<form name="f_test1" method="get" action="testForm3.jsp">
<%-- <input type="hidden" name="htest1" value="<%out.print(test1);%>"> --%>
<input type="hidden" name="htest2">
����2. ���� �� DDL������ �ƴ� ���� ���ÿ�.<br>
<input type="checkbox" name="cb" onChange="test(0)">create<br>
<input type="checkbox" name="cb" onChange="test(1)">drop<br>
<input type="checkbox" name="cb" onChange="test(2)">alter<br>
<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<br>
<input type="button" value="��������" onClick="prev()">
<input type="button" value="��������" onClick="next()">
</form>
</body>
</html>