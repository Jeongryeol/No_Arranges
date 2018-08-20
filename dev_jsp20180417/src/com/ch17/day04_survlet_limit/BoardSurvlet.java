package com.ch17.day04_survlet_limit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/********************************************************************************
 * 	
 * 	������ �Խ��� ������ ���� ���� Ŭ������ �Ϻ��Դϴ�.
 * 	�� Ŭ�������� "��ȸ/�Է�/����/����"����� ó�� �Ǳ⸦ ���մϴ�.
 * 	�� ������ Ÿ�ο��� �����ϱ�� �ߴٸ�
 * 	Ÿ���� �� 4���� ����ó���� ���� �޼ҵ带 ��� ������ �����ؾ� �ұ��?
 * 
 ********************************************************************************/
/*
 * 
 * 	1. 	�Ѱ��� Ŭ������ ������ �ް� , [ /board/crud.do ] 
 * 		������ ���� query/String�� ���ķ� �ְ�, if/switch�� �б���
 * 			[req.getParameter("name") : String // id�� ȭ��ܿ��� , name�� �����ܿ��� ����Ѵ�!!]
 * 							    ��query/String
 *			/board/crud.do?command=select
 *			/board/crud.do?command=insert
 *			/board/crud.do?command=update
 *			/board/crud.do?command=delete
 *
 *	2.	web.xml�� URL������ ���� 4������ ����ؾ���.
 *		�������, 1000���� ��ǰ�� �ֹ��� ���� ������ ������... ���� ( X )
 * 
 *  3.	doGet(req,res)�� �ν��Ͻ�ȭ������ ������ �����ڰ� ������, ������ �������ش�.
 *  	�ּҹ����� ���������� �Ѱܼ� method�� ���������� �̿���  
 *  
 */
public class BoardSurvlet extends HttpServlet {
	/* ȿ������ ������� ���� log4j Ȱ���ϱ� (org.apache�� import�ϼ���~) */
	Logger logger = Logger.getLogger(BoardDAO.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		logger.info("doGet() �޼ҵ� ȣ�� ����");

		//URL����  http://IP:Port/dev_jsp20180417/ch17/crud?command=select|insert|update|delete
		//'query/String'�� URL ���� �־ Ȯ���մϴ�.
		/*
		 * 	������̼��� ���� URL���ε� �� ����Ŭ������ �����ϰ�,
		 * 	URL����(..do?command=______) 'query/String'�� �����ؼ� ��������� Ȯ���غ�����.
		 * 
		 * 	http://localhost:9000/dev_jsp20180417/ch17/crud.do?command=select
		 * 	http://localhost:9000/dev_jsp20180417/ch17/crud.do?command=insert
		 * 	http://localhost:9000/dev_jsp20180417/ch17/crud.do?command=update
		 * 	http://localhost:9000/dev_jsp20180417/ch17/crud.do?command=delete
		 * 
		 */
		
		//�б������ ȭ��ܿ� ������ ��ü�� name�� �Ķ���ͷ� �ް� ���� ������(StringŸ��)
		//id�� ȭ��ܿ��� , name�� �����ܿ��� ����Ѵ�!!
		String command = req.getParameter("command");
		
		//�������� ������ ���� DAOŬ������ ���� �� �غ��Ѵ�.
		//DAOŬ������ �������� ������ �����ϴ� Ŭ�����̰�, DB���� �ڷḦ �޾ƿ��� ������ ����־���Ѵ�.
		BoardDAO bDAO = new BoardDAO();
		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;cahrset=EUC-KR");
		PrintWriter out = res.getWriter();
		
		//[��ȸ]�Խñ� ��� ��ȸ�ϱ� ������ ��
		if("select".equals(command)) {
			logger.info("select �޼ҵ� ȣ�� ����");
			//INSERT HERE : DB����
			out.println("<html><head><title>WebServletTest</title></head>");
			out.println("<body>");
			out.println("<font color='blue' size='20'>SELECT</font>�� ȣ�⼺���߽��ϴ�.");
			out.println("</body></html>");
		}
		//[���]�� ����ϱ� ������ ��
		else if("insert".equals(command)) {
			logger.info("insert �޼ҵ� ȣ�� ����");
			//INSERT HERE : DB����
			out.println("<html><head><title>WebServletTest</title></head>");
			out.println("<body>");
			out.println("<font color='red' size='20'>INSERT</font>�� ȣ�⼺���߽��ϴ�.");
			out.println("</body></html>");
		}
		//[����]�� �����ϱ� ������ ��
		else if("update".equals(command)) {
			logger.info("update �޼ҵ� ȣ�� ����");
			//INSERT HERE : DB����
			out.println("<html><head><title>WebServletTest</title></head>");
			out.println("<body>");
			out.println("<font color='green' size='20'>UPDATE</font>�� ȣ�⼺���߽��ϴ�.");
			out.println("</body></html>");
		}
		//[����]�� �����ϱ� ������ ��
		else if("delete".equals(command)) {
			logger.info("delete �޼ҵ� ȣ�� ����");
			//INSERT HERE : DB����
			out.println("<html><head><title>WebServletTest</title></head>");
			out.println("<body>");
			out.println("<font color='magenta' size='20'>DELETE</font>�� ȣ�⼺���߽��ϴ�.");
			out.println("</body></html>");
		}
	}
	
/*	����(����)�� ��ü������ �����ʱ⶧���� �ȵ�
	//��ȸ�� ������ �޼ҵ�
	public void select(HttpServletRequest req) {
		//���⼭ DB����
		//����� ����??? 
	}
	
	//�Է��� ������ �޼ҵ�
	public void insert(HttpServletRequest req) {
		
	}
	
	//������ ������ �޼ҵ�
	public void update(HttpServletRequest req) {
		
	}
	
	//�Է��� ������ �޼ҵ�
	public void delete(HttpServletRequest req) {
		
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException{
		int num = req.hashCode();
		
		switch(num) {
		case 1 : select(req);
		case 2 : insert(req);
		case 3 : update(req);
		case 4 : delete(req);
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
	
 */
}
