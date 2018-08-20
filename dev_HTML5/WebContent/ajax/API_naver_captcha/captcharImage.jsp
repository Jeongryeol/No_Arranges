<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.OutputStream"%>

<%--
	�� �������� ȭ���� ó���ϴ� �������� �ƴմϴ�.
	captchaView.jsp�� �ѷ��� ĸí�̹����� (���̹�API�� ���� ������)�����ϰ�
	�� �������� ��û�� ��ġ�� ajax�� �Ѹ��� ������ �������ִ� ���� ó���ϴ� ���Դϴ�.
	
	�׷��Ƿ� ��ȯ������ ĸí�̹��� �̸��� �ʿ��մϴ�.
	�ֳ��ϸ� d_captcha�� �� �̹����� �Ѹ� �� src�Ӽ��� �̹����̸��� �־�� �̹����� �ҷ��� �� �ֱ� ����������.
--%>
<%	//out.print("./googlePage.png");//�����׽�Ʈ������ �̹����� �ѷ���
	
	//1�ܰ� : ĸí�̹��� �߱޿� Ű�߱�
	String clientId = "4hItvAK19u6MoyPVewbq";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
    String clientSecret = "e8v3XoiIwv";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
    StringBuffer sb = null;//Ű���� ��� ��Ʈ������
   	String sendKey = null;
    try {
        String code = "0"; // Ű �߱޽� 0,  ĸ�� �̹��� �񱳽� 1�� ����
        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        int responseCode = con.getResponseCode();
        BufferedReader br;//response�� ������̹Ƿ� br�� ����
        if(responseCode==200) { // ���� ȣ��
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {  // ���� �߻�
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        sb = new StringBuffer();//Ű���� ��� ��Ʈ������
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        	//System.out.println(sb.toString());//Ȯ��
        	sendKey = sb.substring(8,24);
        }
        br.close();
    } catch (Exception e) {
        System.out.println(e);
    }
	    
    String apiURL //������ �߱޹��� Ű�� �ѱ� �غ�
       = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key="+sendKey;//������ �߱޹��� Ű ��������

    //out.print(apiURL);
    
%>
<!-- �Ѿ �������� ���������̸� �κ�ó���ϱ����� �� ���������� ���� ����Ʈ -->
<script type="text/javascript" src="/dev_HTML5/js/jquery.easyui.min.js"></script>
		<!-- 3�ܰ� ĸí�̹��� ��ġ -->
	<img id="captchaIMG" width="200px" height="90px" src="<%=apiURL %>">
	<br><!-- ���ΰ�ħ ��ư -->
	<a id="btn_reload" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'"
		onclick="newCaptcha()">���ΰ�ħ</a>
	<input id="captchaKey" type="hidden" value="<%=sendKey%>">
<%	
/*  
    //ĸí�̹��� �߱޹ޱ� ( �̹����� �ٿ�޾Ƽ� ���ÿ� �����ϴ� �������� �� �����ϴ� �⺻API����)
    String imgPath = "E:\\dev_kosmo201804\\dev_HTML5\\WebContent\\ajax\\naver\\";//�̹������
    try {
        String apiURL //������ �߱޹��� Ű�� �ѱ� �غ�
        	= "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key="+sendKey;//������ �߱޹��� Ű ��������
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        int responseCode = con.getResponseCode();
        if(responseCode==200) { // ���� ȣ��
            InputStream is = con.getInputStream();
            int read = 0;
            byte[] bytes = new byte[1024];
            // ������ �̸�����  ���� ����
            String tempname = Long.valueOf(new Date().getTime()).toString();
            String filepath = imgPath+tempname+".jpg";
            File f = new File(filepath);
            f.createNewFile();
            OutputStream outputStream = new FileOutputStream(f);//���� �̹��� ����
            while ((read =is.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            is.close();
            outputStream.close();
        	System.out.println(filepath);//�������ϰ�� Ȯ��
        	out.print(filepath);//�������� ��� (ajax�� �ν��ϴ� HTML�κ�)
        } else {  // ���� �߻�
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            String inputLine;
            sb = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();
            System.out.println("[[������������]]response.toString()");
            
        }
    } catch (Exception e) {
        System.out.println(e);
    }
     */
%>