<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.mail.*,javax.mail.internet.*, java.util.Properties" %>
<%
	String smtpServer = "smtp.naver.com";
	final String sendId = "kimjoy70";
	final String sendPass = "hyun_0907!";
	String sendMailAddr = "kimjoy70@naver.com";
	int smtpPort=465;
	
	//�޴� ��
	String receiveMailAddr = "kimjoy70@gmail.com";
	String subject = "�ȳ��ϼ���. �����׽�Ʈ�Դϴ�.";
	String content = "�н������� ���� �׽�Ʈ ���Դϴ�.";
	
	Properties props = System.getProperties();
	props.put("mail.smtp.host",smtpServer);
	props.put("mail.smtp.port",smtpPort);
	props.put("mail.smtp.auth",true);
	props.put("mail.smtp.ssl.enable",true);
	props.put("mail.smtp.ssl.trust",smtpServer);
	
	Session session2 = Session.getDefaultInstance(props, new Authenticator(){
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(sendId, sendPass);
		}
	});
	session2.setDebug(true);
	Message msg = new MimeMessage(session2);
	msg.setFrom(new InternetAddress(sendMailAddr));
	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMailAddr));
	msg.setSubject(subject);
	msg.setText(content);
	Transport.send(msg);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>sendMailTest.jsp</title>
</head>
<body>

</body>
</html>