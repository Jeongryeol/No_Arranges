<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>selectCombo����ϱ�</title>
<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
</head>
<body>

����1. ���� �߿��� ����̰� �����ϴ� ������ �����ϼ���?<br>
<select id="subject">
	<option>html</option>
	<option>javascript</option>
	<option>java</option>
	<option>oracle</option>
</select>
<br>
<input type="text" id="choice"><!-- ����̰� ������ ������� ����Ͻÿ�. -->
<br>
����2. ���� �߿��� ���� �����ϴ� ������ �� �� �����ϼ���?<br>
<select id="food" multiple="multiple">
	<option>����</option>
	<option selected="selected">�ɵ��</option>
	<option>��������</option>
	<option>������ũ</option>
</select><br>
<input type="text" id="f_choice"><!-- ���� �����ϴ� ������ ����Ͻÿ�. -->
<br>
����3. ���� �߿��� �����̰� �����ϴ� ��ü��� �����ΰ���?<br>
<input type="checkbox" id="train1" name="train" value="����Ʈ">����Ʈ
<input type="checkbox" id="train2" name="train" value="����">����
<input type="checkbox" id="train3" name="train" value="V����Ʈ">V����Ʈ
<input type="checkbox" id="train4" name="train" value="���̽��ӽ�">���̽��ӽ�
<br>
<input type="text" id="t_choice"><!-- ������ �����ϴ� ������ ����Ͻÿ�. -->
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
		//üũ �ڽ� ó���ϱ�
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







