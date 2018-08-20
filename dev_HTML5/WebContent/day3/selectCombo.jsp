<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>selectCombo사용하기</title>
<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
</head>
<body>

문제1. 다음 중에서 재덕이가 좋아하는 과목을 선택하세요?<br>
<select id="subject">
	<option>html</option>
	<option>javascript</option>
	<option>java</option>
	<option>oracle</option>
</select>
<br>
<input type="text" id="choice"><!-- 재덕이가 선택한 과목명을 출력하시오. -->
<br>
문제2. 다음 중에서 은비가 좋아하는 간식을 두 개 선택하세요?<br>
<select id="food" multiple="multiple">
	<option>삼겹살</option>
	<option selected="selected">꽃등심</option>
	<option>차돌박이</option>
	<option>스테이크</option>
</select><br>
<input type="text" id="f_choice"><!-- 은비가 좋아하는 간식을 출력하시오. -->
<br>
문제3. 다음 중에서 보현이가 좋아하는 하체운동은 무엇인가요?<br>
<input type="checkbox" id="train1" name="train" value="스쿼트">스쿼트
<input type="checkbox" id="train2" name="train" value="런지">런지
<input type="checkbox" id="train3" name="train" value="V스쿼트">V스쿼트
<input type="checkbox" id="train4" name="train" value="스미스머신">스미스머신
<br>
<input type="text" id="t_choice"><!-- 보현가 좋아하는 간식을 출력하시오. -->
<script type="text/javascript">
 	$(document).ready(function(){
/*		$("#subject").change(function (){
			var selectedText = $("#subject option:selected").text();
			//insert here
			$("#choice").val(selectedText);
		});
		$("#food").change(function (){
			var selectedText = "";
			$("#food option:selected").each(function(){
				selectedText+=$(this).text()+" ";
			});
			//insert here
			$("#f_choice").val(selectedText);
		});
		//체크 박스 처리하기
 		$("input").change(function (){
 			//alert("change");
 			var ch = $('input:checked');
 			alert(ch.length);
			for(var i=0;i<ch.length;i++){
				alert("ch["+i+"]"+ch[i].checked);
				if(ch[i].checked){
					
				}else{
					
				}
			}
		}); */
		//alert($("input:checkbox[name=train]").length);

 		$("#train1").click(function (){
			if($("#train1").is(":checked")==true){
				$("#t_choice").val($("#train1").val());
			}
			else{
				$("#t_choice").val("");
			}
		});
		$("#train2").click(function (){
			if($("#train2").is(":checked")==true){
				$("#t_choice").val($("#train2").val());
			}
			else{
				$("#t_choice").val("");
			}
		});
		$("#train3").click(function (){
			if($("#train3").is(":checked")==true){
				$("#t_choice").val($("#train3").val());
			}
			else{
				$("#t_choice").val("");
			}
		});
		$("#train4").click(function (){
			if($("#train4").is(":checked")==true){
				$("#t_choice").val($("#train4").val());
			}
			else{
				$("#t_choice").val("");
			}
		}); 
	});
</script>
</body>
</html>







