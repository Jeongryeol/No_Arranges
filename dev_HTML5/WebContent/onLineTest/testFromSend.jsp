<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	String test1 = request.getParameter("htest1");
	String test2 = request.getParameter("htest2");
	String test3 = request.getParameter("htest3");
	String test4 = request.getParameter("htest4");
	String test5 = request.getParameter("htest5");
	out.print("1번 문제 답안 - "+test1+", 2번 문제 답안 - "+test2+", 3번 문제 답안 - "+test3+", 4번 문제 답안 - "+test4+", 5번 문제 답안 - "+test5);
	//한 문제당 배점을 담을 변수
	int perJumsu = 20;
	//맞힌 개수
	int cnt = 0;
	//총점수
	int hap = 0;
	//판정하기
	boolean isPass = false;//true이면 합격, false이면 불합격
	//합격기준점수
	int pass = 60;
	String daps[] = {"3","4","1","2","4"};
	String test[] = new String[5];
	test[0] = request.getParameter("htest1");
	test[1] = request.getParameter("htest2");
	test[2] = request.getParameter("htest3");
	test[3] = request.getParameter("htest4");
	test[4] = request.getParameter("htest5");
	for(int i=0;i<test.length;i++){
		for(int j=0;j<daps.length;j++){
			if(daps[i].equals(test[j])){
				cnt += 1;
				if(i==j) return;
			}
		}
	}
	hap = cnt * perJumsu;
	if(hap>=pass){
		isPass = true;
	}else{
		isPass = false;
	}
	out.print("<br>맞힌개수는 "+cnt+"개 입니다.<BR>따라서 당신의 점수는 "+hap+"점 입니다.");
	response.sendRedirect("account.jsp?isPass"+isPass);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>채점결과</title>
</head>
<body>

</body>
</html>