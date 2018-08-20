<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	String test1 = request.getParameter("htest1");
	String test2 = request.getParameter("htest2");
	String test3 = request.getParameter("htest3");
	String test4 = request.getParameter("htest4");
	out.print("1번 문제 답안 - "+test1+", 2번 문제 답안 - "+test2+", 3번 문제 답안 - "+test3+", 4번 문제 답안 - "+test4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>문제5</title>
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
				document.f_test1.htest2.value = temp;/* 변수로 처리함 */
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
<input type="hidden" name="htest1" value="<%out.print(test1);%>"><!-- 상수로 처리함 : 실행을 Tomcat이 하고 결과문을 jsp로 내기때문에, 브라우저에서 개발자도구로 확인하면 상수값이 나옴 -->
<input type="hidden" name="htest2" value="<%out.print(test2);%>"><!-- 상수로 처리함 : 실행을 Tomcat이 하고 결과문을 jsp로 내기때문에, 브라우저에서 개발자도구로 확인하면 상수값이 나옴 -->
<input type="hidden" name="htest3" value="<%out.print(test3);%>"><!-- 상수로 처리함 : 실행을 Tomcat이 하고 결과문을 jsp로 내기때문에, 브라우저에서 개발자도구로 확인하면 상수값이 나옴 -->
<input type="hidden" name="htest4" value="<%out.print(test4);%>"><!-- 상수로 처리함 : 실행을 Tomcat이 하고 결과문을 jsp로 내기때문에, 브라우저에서 개발자도구로 확인하면 상수값이 나옴 -->
<input type="hidden" name="htest5">
문제5. 다음중 DDL 구문이 아닌 것을 고르시고<BR>
<input type="checkbox" name="cb" onChange="test(0)">create<br>
<input type="checkbox" name="cb" onChange="test(1)">drop<br>
<input type="checkbox" name="cb" onChange="test(2)">alter<br>
<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<br>
<input type="button" value="이전문제" onclick ="prev()">
<input type="button" value="제출하기" onclick ="next()">
</form>
</body>
</html>