<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URL, java.net.HttpURLConnection" %>    
<%@ page import="java.io.BufferedReader, java.io.InputStreamReader" %>    
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String clientId = "mhkDPKVN6jZJhjVRvCrB";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
	String clientSecret = "C2fuWbk3NP";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
	try {
		String code = "1"; // Ű �߱޽� 0,  ĸ�� �̹��� �񱳽� 1�� ����
		String key = request.getParameter("captchakey"); // ĸ�� Ű �߱޽� ���� Ű��
		String value = request.getParameter("value"); // ����ڰ� �Է��� ĸ�� �̹��� ���ڰ�
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code + "&key=" + key + "&value="+ value;
		//out.print("apiURL:"+apiURL);
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // ���� ȣ��
			out.print("200 ok");
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // ���� �߻�
			out.print("204 error");
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();
		//out.println(res.toString());
	} catch (Exception e) {
		out.println(e);
	}
%>