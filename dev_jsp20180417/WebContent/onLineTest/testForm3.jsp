<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	//3번 문제지에서는 아래 코드가 2개 필요해요.
	//왜냐하면 1번과 2번 문제지에 대한 답안정보를 담아야 하니깐.....
	//1번 문제에서 넘어온 답안지를 출력해 볼까?
	//String test1 = request.getParameter("htest1");
    //String test2 = request.getParameter("htest2");
	//out.print("1번 문제 답안 - "+test1+", 2번 문제 답안 - "+test2);
    
	String test2 = request.getParameter("htest2");
	Cookie c = new Cookie("test2",test2);
	c.setMaxAge(60*60);
	response.addCookie(c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>문제3</title>
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
		location.href="testForm2.html";
	}
	function next(){
		var temp=1;
		for(var i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest3.value = temp;
			}else{
				temp = temp + 1;
			}
		}
		document.f_test1.submit();		
	}
</script>
</head>
<body>
<form name="f_test1" method="get" action="testForm4.jsp">
<%-- <input type="hidden" name="htest1" value="<%out.print(test1);%>">
<input type="hidden" name="htest2" value="<%out.print(test2);%>"> --%>
<input type="hidden" name="htest3" value="3">
문제3. 다음 중 DCL구문으로 맞는 것을 고르시오.<br>
<input type="checkbox" name="cb" onChange="test(0)">grant<br>
<input type="checkbox" name="cb" onChange="test(1)">drop<br>
<input type="checkbox" name="cb" onChange="test(2)">alter<br>
<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<br>
<input type="button" value="이전문제" onClick="prev()">
<input type="button" value="다음문제" onClick="next()">
</form>
</body>
</html>