<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	//3번 문제지에서는 아래 코드가 2개 필요해요.
	//왜냐하면 1번과 2번 문제지에 대한 답안정보를 담아야 하니깐.....
	//1번 문제에서 넘어온 답안지를 출력해 볼까?
	String test1 = request.getParameter("htest1");
    String test2 = request.getParameter("htest2");
    String test3 = request.getParameter("htest3");
    String test4 = request.getParameter("htest4");
	out.print("1번 문제 답안 - "+test1+", 2번 문제 답안 - "+test2
			 +", 3번 문제 답안 - "+test3+", 4번 문제 답안 - "+test4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>문제5</title>
<script type="text/javascript">
	function test(pcb){//변수 pcb에는 0,1,2,3 중 하나씩 값이 들어온다.
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
문제5. 다음 중 프로시저에 대한 설명으로 틀린 것을 고르시오.<br>
<input type="checkbox" name="cb" onChange="test(0)">
프로시저를 생성할 때 파라미터를 선언할 수 있다.<br>
<input type="checkbox" name="cb" onChange="test(1)">
파라미터에 여러 변수를 선언할 수 있다.<br>
<input type="checkbox" name="cb" onChange="test(2)">
프로시저안에서 SELECT,INSERT,UPDATE, DELETE 모두 사용 할 수 있다.<br>
<input type="checkbox" name="cb" onChange="test(3)">
프로시저 안에서 commit할 수 없다.
<br>
<br>
<input type="button" value="이전문제" onClick="prev()">
<input type="button" value="다음문제" onClick="next()">
</form>
</body>
</html>