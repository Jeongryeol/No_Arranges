<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	//3�� ������������ �Ʒ� �ڵ尡 2�� �ʿ��ؿ�.
	//�ֳ��ϸ� 1���� 2�� �������� ���� ��������� ��ƾ� �ϴϱ�.....
	//1�� �������� �Ѿ�� ������� ����� ����?
	String test1 = request.getParameter("htest1");
    String test2 = request.getParameter("htest2");
    String test3 = request.getParameter("htest3");
    String test4 = request.getParameter("htest4");
	out.print("1�� ���� ��� - "+test1+", 2�� ���� ��� - "+test2
			 +", 3�� ���� ��� - "+test3+", 4�� ���� ��� - "+test4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����5</title>
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
		location.href="testForm3.html";
	}
	function next(){
		var temp=1;
		for(var i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest5.value = temp;
			}else{
				temp = temp + 1;
			}
		}
		document.f_test1.submit();		
	}
</script>
</head>
<body>
<form name="f_test1" method="get" action="testFormSend.jsp">
<input type="hidden" name="htest1" value="<%out.print(test1);%>">
<input type="hidden" name="htest2" value="<%out.print(test2);%>">
<input type="hidden" name="htest3" value="<%out.print(test3);%>">
<input type="hidden" name="htest4" value="<%out.print(test4);%>">
<input type="hidden" name="htest5">
����5. ���� �� ���ν����� ���� �������� Ʋ�� ���� ���ÿ�.<br>
<input type="checkbox" name="cb" onChange="test(0)">
���ν����� ������ �� �Ķ���͸� ������ �� �ִ�.<br>
<input type="checkbox" name="cb" onChange="test(1)">
�Ķ���Ϳ� ���� ������ ������ �� �ִ�.<br>
<input type="checkbox" name="cb" onChange="test(2)">
���ν����ȿ��� SELECT,INSERT,UPDATE, DELETE ��� ��� �� �� �ִ�.<br>
<input type="checkbox" name="cb" onChange="test(3)">
���ν��� �ȿ��� commit�� �� ����.
<br>
<br>
<input type="button" value="��������" onClick="prev()">
<input type="button" value="��������" onClick="next()">
</form>
</body>
</html>