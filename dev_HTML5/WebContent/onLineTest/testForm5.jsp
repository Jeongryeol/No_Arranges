<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	String test1 = request.getParameter("htest1");
	String test2 = request.getParameter("htest2");
	String test3 = request.getParameter("htest3");
	String test4 = request.getParameter("htest4");
	out.print("1�� ���� ��� - "+test1+", 2�� ���� ��� - "+test2+", 3�� ���� ��� - "+test3+", 4�� ���� ��� - "+test4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����5</title>
<script>
	function test(pcb){
		for(var i=0;i<document.f_test1.cb.length;i++){
			if(pcb==i){
				document.f_test1.cb[i].checked=1;
			}else{
				document.f_test1.cb[i].checked=0;
			}
		}
	}
	function prev(){
		location.href="testForm4.jsp";
	}
	function next(){
		var temp=1;
		for(var i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest2.value = temp;/* ������ ó���� */
			}else{
				temp = temp+1
			}
		}
		document.f_test1.submit();
	}
</script>
</head>
<body>
<form name="f_test1" method="get" action="./testFromSend.jsp">
<input type="hidden" name="htest1" value="<%out.print(test1);%>"><!-- ����� ó���� : ������ Tomcat�� �ϰ� ������� jsp�� ���⶧����, ���������� �����ڵ����� Ȯ���ϸ� ������� ���� -->
<input type="hidden" name="htest2" value="<%out.print(test2);%>"><!-- ����� ó���� : ������ Tomcat�� �ϰ� ������� jsp�� ���⶧����, ���������� �����ڵ����� Ȯ���ϸ� ������� ���� -->
<input type="hidden" name="htest3" value="<%out.print(test3);%>"><!-- ����� ó���� : ������ Tomcat�� �ϰ� ������� jsp�� ���⶧����, ���������� �����ڵ����� Ȯ���ϸ� ������� ���� -->
<input type="hidden" name="htest4" value="<%out.print(test4);%>"><!-- ����� ó���� : ������ Tomcat�� �ϰ� ������� jsp�� ���⶧����, ���������� �����ڵ����� Ȯ���ϸ� ������� ���� -->
<input type="hidden" name="htest5">
����5. ������ DDL ������ �ƴ� ���� ���ð�<BR>
<input type="checkbox" name="cb" onChange="test(0)">create<br>
<input type="checkbox" name="cb" onChange="test(1)">drop<br>
<input type="checkbox" name="cb" onChange="test(2)">alter<br>
<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<br>
<input type="button" value="��������" onclick ="prev()">
<input type="button" value="�����ϱ�" onclick ="next()">
</form>
</body>
</html>