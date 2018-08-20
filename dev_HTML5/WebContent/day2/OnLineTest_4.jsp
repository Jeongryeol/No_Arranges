<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Question 4번</title>
<script type="text/javascript">
	var dap;
	function prev(){
	      location.href = "./OnLineTest_3.jsp";//페이지 이동이 일어남.
	}
	function next(){
		var innA = "";
		if(document.n_q1.qn1.checked == 1){alert("A번체크"); dap=1; innA += "1"}
		if(document.n_q1.qn2.checked == 1){alert("B번체크"); dap=2; innA += "2"}
		if(document.n_q1.qn3.checked == 1){alert("C번체크"); dap=3; innA += "3"}
		if(document.n_q1.qn4.checked == 1){alert("D번체크"); dap=4; innA += "4"}
		if(document.n_q1.qn5.checked == 1){alert("E번체크"); dap=5; innA += "5"}
		document.getElementById("h4").value = innA;
		alert("사용자가 선택한 답안지 정보 : "+innA)
		document.n_q1.submit();//submit()은 전송하다 라는 의미 (브라우저->서버 [Tomcat-dev_html5]->목적지(action값))
	}
 </script>
</head>
<body>
<form name="n_q1" id="i_q1" method="post" action="./OnLineTest_5.jsp">
<input type="hidden" id = "h1"><!-- 폼태그안에 있기때문에 서버에 전송할 수 있음 -->
<input type="hidden" id = "h2"><!-- 폼태그안에 있기때문에 서버에 전송할 수 있음 -->
<input type="hidden" id = "h3"><!-- 폼태그안에 있기때문에 서버에 전송할 수 있음 -->
<input type="hidden" id = "h4"><!-- 폼태그안에 있기때문에 서버에 전송할 수 있음 -->
<input type="hidden" id = "h5"><!-- 폼태그안에 있기때문에 서버에 전송할 수 있음 -->
<br>&nbsp;&nbsp;<b>QUESTION: 4</b>
<br>&nbsp;&nbsp;&nbsp;&nbsp;given:
<br>&nbsp;&nbsp;&nbsp;&nbsp;1. public class ItemTest {
<br>&nbsp;&nbsp;&nbsp;&nbsp;2. private final int id;
<br>&nbsp;&nbsp;&nbsp;&nbsp;3. public ItemTest(int id) { this.id = id; }
<br>&nbsp;&nbsp;&nbsp;&nbsp;4. public void updateId(int newId) { id = newId; }
<br>&nbsp;&nbsp;&nbsp;&nbsp;5.
<br>&nbsp;&nbsp;&nbsp;&nbsp;6. public static void main(String[] args) {
<br>&nbsp;&nbsp;&nbsp;&nbsp;7. ItemTest fa = new ItemTest(42);
<br>&nbsp;&nbsp;&nbsp;&nbsp;8. fa.updateId(69);
<br>&nbsp;&nbsp;&nbsp;&nbsp;9. System.out.println(fa.id);
<br>&nbsp;&nbsp;&nbsp;&nbsp;0. }
<br>&nbsp;&nbsp;&nbsp;&nbsp;1. }
<br>&nbsp;&nbsp;
<br>&nbsp;&nbsp;<b>What is the result?</b>
<br>&nbsp;&nbsp;&nbsp;<input type="checkbox" name="qn1" value="A"> A. Compilation fails.
<br>&nbsp;&nbsp;&nbsp;<input type="checkbox" name="qn2" value="B"> B. An exception is thrown at runtime.
<br>&nbsp;&nbsp;&nbsp;<input type="checkbox" name="qn3" value="C"> C. The attribute id in the ItemTest object remains unchanged.
<br>&nbsp;&nbsp;&nbsp;<input type="checkbox" name="qn4" value="D"> D. The attribute id in the ItemTest object is modified to the new value.
<br>&nbsp;&nbsp;&nbsp;<input type="checkbox" name="qn5" value="E"> E. A new ItemTest object is created with the preferred value in the id attribute.
<br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="이전문제" onClick="prev()">
&nbsp;&nbsp;&nbsp;<input type="button" value="다음문제" onClick="next()">
</form>
</body>
</html>