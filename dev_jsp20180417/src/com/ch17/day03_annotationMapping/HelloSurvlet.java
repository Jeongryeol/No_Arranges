package com.ch17.day03_annotationMapping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.ForwardRequest;

import com.ch17.day01_console_browser.HelloServlet;
import com.sun.istack.internal.logging.Logger;
import com.util.Post_Hangul_Conversion;
					//���ϰ���� ���� ���� �������� dev_jsp20180417 path�κ��� ����Ѵٴ� �ǹ̸� ������
@WebServlet(urlPatterns = "/ch17/hello.dk")
public class HelloSurvlet extends HttpServlet {

	Logger logger = Logger.getLogger(HelloServlet.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws IOException, ServletException{
		logger.info("doGetȣ�⼺�� - log4j�� Ȱ���ؼ� �پ��� �α� Ȯ�� ");
		//�̰��� ������ �ܼ� �� ��Ĺ �ֿܼ� ��µǴ� ��
		System.out.println("doGetȣ�⼺��");
		//�̰��� ������ ��µǴ� ��
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.print("<b>����<font color='blue' size='20'>html</font>����</b>");
	}
	/**********************************************************************
	 *  ȭ��ܿ��� post������� ��û�ϸ� doPost�޼ҵ尡 ȣ���
	 *  @req - ���ϼ����� ������ ���� ��û�� �Ͼ�� ��û��ü�� ��������.
	 *  @res - ���ϼ����� ������ ���� ��û�� �Ͼ�� ���䰴ü�� ��������.
	 *  doPost�� �޼ҵ� �������̵��� �޼ҵ��̹Ƿ� ����Ÿ���� �ٲ� �� ����.
	 *  doPost�� URL��û���δ� ���� ȣ���� �� ����. [�ʼ��ϱ����!]
	 *  	�ذ��� : �ڹٽ�ũ��Ʈ �ڵ忡���� ȣ���� �� ����.
	 *  	�������� �̵��ϴ� �޼ҵ�� �Լ� �����ص� ��.
	 **********************************************************************/
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException{
		logger.info("doPostȣ�⼺�� - log4j�� Ȱ���ؼ� �پ��� �α� Ȯ�� ");
		//������ �ܼ� ��, ���� �ֿܼ� ����Ѵ�.
		System.out.println("doPostȣ�� ����");
		req.setCharacterEncoding("euc-kr");//�޴� ���ڵ� Ÿ���� ����
		res.setCharacterEncoding("euc-kr");//�������� ���ڵ� Ÿ���� ����
		res.setContentType("text/html;charset=euc-kr");//�������� �ڷ��� ����Ÿ�԰� ���α�Ϲ��(����)
		PrintWriter out = res.getWriter();
		//����ڰ� ȭ�鿡 �Է��� �̸��� ����غ�����
		//insert here
		String name = req.getParameter("tb_name");//���ڵ���  �ʿ��� ��
		//String name = Post_Hangul_Conversion.toKor(req.getParameter("tb_name"));
		logger.info("����ڰ� �Է��� �̸� : "+name);
		//�Ʒ��� �������� ��µȴ�.
		out.print("<b>����ڰ� �Է��� �̸���<font color='blue' size='20'>"+name+"</font> �Դϴ�.</b>");
		//res.sendRedirect("./end.jsp");//������ �̵�
	}
	
}
