<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%! 
	//��Ŭ�����̼� : �������� �����ϰų� �޼ҵ带 ������ �� ����. (�ν��Ͻ�ȭ ��Ģ�� �޶� ���󵵰� ����.)
	int i = 0;
%>
<%
	StringBuilder news1 = new StringBuilder();
	StringBuilder news2 = new StringBuilder();
	StringBuilder news3 = new StringBuilder();
	StringBuilder news4 = new StringBuilder();
	StringBuilder news5 = new StringBuilder();
	StringBuilder news6 = new StringBuilder();
	//INSERT HERE-�������� ���
	news1.append("[��] �������� 1");
	news2.append("[��] �������� 2");
	news3.append("[��] �������� 3");
	news4.append("[��] �������� 4");
	news5.append("[��] �������� 5");
	news6.append("[��] �������� 6");
	
	//���ѷ���
		switch(i){
			case 0 : {
				StringBuilder ntitle = new StringBuilder();
				ntitle.append("<table border='1'>");
				ntitle.append("<tr><td>"+news1.toString()+"</td></tr>");
				ntitle.append("</table>");
				out.clear();
				out.print(ntitle.toString());
				i++;
				break;
			}
			case 1 : {
				StringBuilder ntitle = new StringBuilder();
				ntitle.append("<table border='1'>");
				ntitle.append("<tr><td>"+news2.toString()+"</td></tr>");
				ntitle.append("</table>");
				out.clear();
				out.print(ntitle.toString());
				i++;
				break;
			}
			case 2 : {
				StringBuilder ntitle = new StringBuilder();
				ntitle.append("<table border='1'>");
				ntitle.append("<tr><td>"+news3.toString()+"</td></tr>");
				ntitle.append("</table>");
				out.clear();
				out.print(ntitle.toString());
				i++;
				break;
			}
			case 3 : {
				StringBuilder ntitle = new StringBuilder();
				ntitle.append("<table border='1'>");
				ntitle.append("<tr><td>"+news4.toString()+"</td></tr>");
				ntitle.append("</table>");
				i++;
				out.clear();
				out.print(ntitle.toString());
				break;
			}
			case 4 : {
				StringBuilder ntitle = new StringBuilder();
				ntitle.append("<table border='1'>");
				ntitle.append("<tr><td>"+news5.toString()+"</td></tr>");
				ntitle.append("</table>");
				out.clear();
				out.print(ntitle.toString());
				i++;
				break;
			}
			case 5 : {
				StringBuilder ntitle = new StringBuilder();
				ntitle.append("<table border='1'>");
				ntitle.append("<tr><td>"+news6.toString()+"</td></tr>");
				ntitle.append("</table>");
				out.clear();
				out.print(ntitle.toString());
			//	i++;
				i=0;
				break;
			}
		/* 	default : {
				i=0;
				break;
			} */
		}
%>
