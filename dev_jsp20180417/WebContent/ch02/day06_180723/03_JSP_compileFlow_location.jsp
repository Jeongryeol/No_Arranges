<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html> <!-- �̷��� �ϸ� HTML5 ���� -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JavaServer Pages(JSP) �ڵ弱��԰�</title>
</head>
<body>
<!-- 
	[[ ������� ]]
	time.jsp -> time_jsp.java(����) -> time_jsp.class(���-html�±�) - ������
 -->

<!-- ����� JSP�� �����ϵ� ����� (java �� class����)�� ���ִ� ���
E:\dev_kosmo201804\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\dev_jsp20180417\org\apache\jsp\ch02
time.jsp -> time_jsp.java(����) -> time_jsp.class(���-html�±�) - ������
 -->
<%!
	//��Ŭ�����̼�(decleration)
	//	�������� ���𰡴�
	//	�޼ҵ� ���𰡴� ( POJO class : ����Ŭ����  )
	//	�ν��Ͻ�ȭ �Ұ� : ���뼺�� �������� ���� ������
	//	(WAS,���������� ����Ģ�� �޶���)
	
	int i; // ��������(�������,�۷ι�����)
	public void methodA(){}
%>

<%
	//��ũ��Ʋ��(scriptlet) : service() {} �۵���
	//	�������� ���𰡴�
	//	�ν��Ͻ�ȭ����
	//	��� ��밡�� : ���ǹ� / �ݺ���
	//	�ڷᱸ�� ��°��� ( json / xml )
	//	��jsp�� �޵��� �ϴ°� �ȵ� (MODEL2��Ŀ����� servlet�� ����)
	
	int i = 0; // ��������(���ú���,�����ƽ����)
	out.print("��ũ��Ʋ��");
	out.print("<br>");//������ ���ļ� �������� �ٿ�޴� <br>�ٹٲ��ڵ�
%>
<br><!-- HTML������ �������� �ٿ�޴� <br>�ڵ� -->
<%=
	//�ͽ�������(expression)
	//	<td>�±׾��� ����  ����ϴ� �뵵�� �ַ� ���
	//	�����ݷ�(;)�� ���� ����
	
	"���"
%>
</body>
</html>