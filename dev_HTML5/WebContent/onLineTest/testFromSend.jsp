<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	String test1 = request.getParameter("htest1");
	String test2 = request.getParameter("htest2");
	String test3 = request.getParameter("htest3");
	String test4 = request.getParameter("htest4");
	String test5 = request.getParameter("htest5");
	out.print("1�� ���� ��� - "+test1+", 2�� ���� ��� - "+test2+", 3�� ���� ��� - "+test3+", 4�� ���� ��� - "+test4+", 5�� ���� ��� - "+test5);
	//�� ������ ������ ���� ����
	int perJumsu = 20;
	//���� ����
	int cnt = 0;
	//������
	int hap = 0;
	//�����ϱ�
	boolean isPass = false;//true�̸� �հ�, false�̸� ���հ�
	//�հݱ�������
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
	out.print("<br>���������� "+cnt+"�� �Դϴ�.<BR>���� ����� ������ "+hap+"�� �Դϴ�.");
	response.sendRedirect("account.jsp?isPass"+isPass);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ä�����</title>
</head>
<body>

</body>
</html>