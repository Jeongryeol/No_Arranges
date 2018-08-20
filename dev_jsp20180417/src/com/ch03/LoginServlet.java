package com.ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class LoginServlet extends HttpServlet {

	//�αװ�ü �غ�
	Logger logger = Logger.getLogger(LoginServlet.class);
	
	//����޼ҵ�
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		HttpSession session = req.getSession();	//��û��ü�κ��� ���ǰ�ü���
		Cookie cookies[] = req.getCookies();	//��û��ü�κ��� ��Ű�迭 ���
		
		Map<String,Object> pMap
				= new HashMap<String,Object>();	//�� Map�迭 �ڷ��� �غ�
		HashMapBinder hmb
				= new HashMapBinder(req);//�����ڵ� BinderŬ������ ��û��ü �����ּ� ����
		hmb.bind(pMap);					 //bind()�� Map�迭 �ڷ��� ������ �����ϱ�
		
		//Map�迭 �ڷ����� <key>�� ������ Set�迭 �ڷ������� ��ȯ�ϰ�,
		//�� Set�迭 �ڷ����� ��üŸ�� �迭�� ��ȯ�Ͽ� �����ϱ� 
		Object keys[] = pMap.keySet().toArray();
		
		//�����׽�Ʈ : �α׸� ���� ������ �Ѿ�� Ű�� ���� Ȯ���ϱ�
		for(int i=0;i<keys.length;i++) {
			String key = (String)keys[i];//����� Ű�迭�� �� �濡 ��� Ű���� �����ϰ�
			logger.info("pMap.get("+key+")="
						+pMap.get(key)); //����� Ű������ ��ȯ�ϴ� ������ �α׷� Ȯ���ϱ�
		}
		//�����׽�Ʈ : �迭�� ���� �α�
		logger.info("�迭�� ���� : "+keys.length);		
		
		//�����׽�Ʈ : ��ȭ�鿡 ����ϱ�
		PrintWriter out = res.getWriter();
		res.setContentType("text/html;charset=euc-kr");
		out.print("<b>fin.....</b>");
	}
	
	@Override //GET���
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req, res);
	}
	
	@Override //POST���
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req, res);
	}
}
