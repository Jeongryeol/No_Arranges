<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	//3번 문제지에서는 아래코드가 2개 필요해요
	//왜냐하면 1번 과 2번 문제지에 대한 답안정보를 담아야 하니깐....
	//1번 문제에서 넘어온 답안지를 출력해 볼까?(화면에 보여줄 필요가 없어서 히든에 저장하기 위해서 이곳에 기록)
	String test1 = request.getParameter("htest1");
	out.print("1번 문제 답안 - "+test1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>문제2</title>
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
		location.href="testForm1.html";
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
<form name="f_test1" method="get" action="./testForm3.jsp">
<input type="hidden" name="htest1" value="<%out.print(test1);%>"><!-- 상수로 처리함 : 실행을 Tomcat이 하고 결과문을 jsp로 내기때문에, 브라우저에서 개발자도구로 확인하면 상수값이 나옴 -->
<input type="hidden" name="htest2">
문제2. 다음중 DDL 구문이 아닌 것을 고르시고<BR>
<input type="checkbox" name="cb" onChange="test(0)">create<br>
<input type="checkbox" name="cb" onChange="test(1)">drop<br>
<input type="checkbox" name="cb" onChange="test(2)">alter<br>
<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<br>
<input type="button" value="이전문제" onclick ="prev()">
<input type="button" value="다음문제" onclick ="next()">
</form>
</body>
</html>