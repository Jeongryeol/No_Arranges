package com.ch17.day02_pageMove;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderSurvlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res)
				throws ServletException, IOException
	{
		System.out.println("doGet() ȣ�� ����");
		
		//�ڷᱸ���� DB�����ϸ鼭 �޾ƿ;��ϴ� ������ �Ʒ��� ���� ��Ƽ� �����Ѵ�.
		List<Map<String,Object>> orderList = 
				new ArrayList<Map<String,Object>>();
		Map<String,Object> pMap =
				new HashMap<String,Object>();
		pMap.put("ord_no",123456);
		pMap.put("oname","�̼���");
		pMap.put("goods","��Ų");
		orderList.add(pMap);
		
		pMap = new HashMap<String,Object>();
		pMap.put("ord_no",123457);
		pMap.put("oname","�̼���");
		pMap.put("goods","����");
		orderList.add(pMap);
		
		pMap = new HashMap<String,Object>();
		pMap.put("ord_no",123458);
		pMap.put("oname","������");
		pMap.put("goods","�౸��");
		
		orderList.add(pMap);//List �����Ϸ�

		//���ǿ� �ڷ���(�ڼ��� ������ ����)
		HttpSession session = req.getSession();
		session.setAttribute("orderList",orderList);
		
		res.sendRedirect("jsonOrderList.jsp");//�������̵�-404����
		
	/*URL Pattern�� ��ϵ� �������� �̵��ϰ��� �Ҷ�, �������� ��������ȯ�� ������ �� �ִ�.*/
		//���� �ȿ��� ������ �̵� 1
//		res.sendRedirect("jsonOrderList.jsp");
		
		//���� �ȿ��� ������ �̵� 2
//		RequestDispatcher view = req.getRequestDispatcher("jsonOrderList.jsp");
//		view.forward(req, res);
	}
	
}
