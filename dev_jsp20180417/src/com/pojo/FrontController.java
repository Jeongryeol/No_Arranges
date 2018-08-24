package com.pojo;

import java.io.IOException;
import java.util.Base64.Encoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Post_Hangul_Conversion;
/*
 * ������Ʈ���� Ŭ������ �ɰ��� ������ ���........
 * �������� �ɰ���. - �ֹ�����, ȸ������, ������
 * � ������ �¿��� ������ ��� ��������?
 * ��Ʈ - ������ ���� ��û�� �������� �ް� �ֳ���?
 * req.getRequestURI():String  -> /dev_jsp20180417/semanticUI/main.jsp
 * req.getContextPath():String -> /dev_jsp20180417
 * �� url��û������ �о�� �ұ�?
 * �������� �б� - if�� 
 * ����
 * XXX.jsp  - ��1 - ǥ�ؼ��� ó��  
 * XXX.kos - ��2 - ����� ���� ���� �¿��.
 * 
 * XXX.kos������ �ʿ���.
 * 
 * FrontController�� ����
 * 1)�������� -�Ѱ��Ŵ��� - url����
 * 2)������������ ���� ȣ����  ���⼭ ó��(����) - ���� 
 * 
 * 
 */
public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException
	{
		logger.info("serviceȣ�� ����");
		//logger.info(req.getRequestURI()+" , "+req.getContextPath());
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		logger.info("command:"+command);// /pojo/getPojoList.kos
		ActionForward forward = null;
		PojoController pojoCtrl = new PojoController();
		if("/semanticUI/member.kos".equals(command)) {
			int result = 0;
			MemberController memCtrl = new MemberController();
			try {
				Map<String,Object> pMap = new HashMap<String,Object>();
				String gubun = req.getParameter("gubun");
				pMap.put("gubun", gubun);
				logger.info("ȸ������ : "+pMap.get("gubun"));
				if("login".equals(gubun)) {
					req.setAttribute("gubun", "login");//scope-����,����
					forward = memCtrl.execute(req, res);
				}
				else if("zipcode".equals(gubun)) {
					req.setAttribute("gubun", "zipcode");//scope-����,����
					forward = memCtrl.execute(req, res);
				}
				else if("memberList".equals(gubun)) {
					req.setAttribute("gubun", "memberList");//scope-����,����
					forward = memCtrl.execute(req, res);
				}
				else if("pwSearch".equals(gubun)) {
					req.setAttribute("gubun", "pwSearch");//scope-����,����
					forward = memCtrl.execute(req, res);
				}				
				else if("memINS".equals(gubun)) {
					String mem_id = req.getParameter("mem_id");
					byte[] idBytes = mem_id.getBytes();
					Encoder idEncoder = Base64.getEncoder();
					byte[] idEncoderBytes = idEncoder.encode(idBytes);
					//StringŬ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ��� ���ο� ��ü�� �����Ұ�.
					String base64ID = new String(idEncoderBytes);
					pMap.put("mem_id", base64ID);
					String mem_pw = req.getParameter("mem_pw");
					byte[] pwBytes = mem_pw.getBytes();
					Encoder pwEncoder = Base64.getEncoder();
					byte[] pwEncoderBytes = pwEncoder.encode(pwBytes);
					//StringŬ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ��� ���ο� ��ü�� �����Ұ�.
					String base64PW = new String(pwEncoderBytes);
					pMap.put("mem_pw", base64PW);
					String mem_name = 
							Post_Hangul_Conversion.toKor(req.getParameter("mem_name"));
					pMap.put("mem_name", mem_name);
					String zipcode = req.getParameter("zipcode");
					pMap.put("zipcode", zipcode);
					String address = 
							Post_Hangul_Conversion.toKor(req.getParameter("address"));
					pMap.put("address", address);
					forward = memCtrl.execute(req, res, pMap);
				}				
				//////////////////////////���� ������ ����
				else if("memoInsert".equals(gubun)) {
					req.setAttribute("gubun", "memoInsert");
					String from_id = req.getParameter("from_id");
					byte[] idBytes = from_id.getBytes();
					Encoder idEncoder = Base64.getEncoder();
					byte[] idEncoderBytes = idEncoder.encode(idBytes);
					//StringŬ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ��� ���ο� ��ü�� �����Ұ�.
					String base64ID = new String(idEncoderBytes);
					pMap.put("from_id", base64ID);
					String to_id = req.getParameter("to_id");
					byte[] tidBytes = to_id.getBytes();
					Encoder tidEncoder = Base64.getEncoder();
					byte[] tidEncoderBytes = tidEncoder.encode(tidBytes);
					//StringŬ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ��� ���ο� ��ü�� �����Ұ�.
					String base64TID = new String(tidEncoderBytes);
					pMap.put("to_id", base64TID);					
					String memo_content = 
							Post_Hangul_Conversion.toKor(req.getParameter("memo_content"));
					pMap.put("memo_content", memo_content);
					forward = memCtrl.execute(req, res, pMap);
				}				
				//////////////////////////���� ������ ��
			} catch (Exception e) {
				logger.info("exception:"+e.toString());
			}			
		}
		
		else if("/pojo/getPojoList.kos".equals(command)) {
			//����
			List<Map<String,Object>> pojoList = null;
			try {
				forward = pojoCtrl.execute(req, res);
				//logger.info("forward:"+forward);
				//logger.info("list:"+forward.getList());
				req.setAttribute("pojoList", forward.getList());
			} catch (Exception e) {
				logger.info("exception:"+e.toString());
			}
		}
		else if("/pojo/pojoInsert.kos".equals(command)) {
/*
 * ��������:���� Ŭ���� ������ ����� �߰��ɶ� ���� Controller ��� �����ϴ� ��������. - �����? - ��������� �ֱ�?
 * �ذ���1
 * PojoControllerŬ������ �޼ҵ尡 �Ѱ��̹Ƿ� if������ �б��� �� �ֵ��� ���� �����ڸ� �ϳ� ������ ó���� ����.
 * (PojoController�� ������ �ƴϴ� - ����������Ŭ ������ ������ �ؾߵȴ�.)
 * ���� ������ �� ����
 * ���������ڸ� ��� ���� �� ������?
 * ���a) �������� �Ķ���ͷ� ������.
 * ���b) execute�޼ҵ带 �����ε��Ͽ� �Ű�����(�Ķ����)�� ������.
 * 			
 */
			int result = 0;
			try {
				Map<String,Object> pMap = new HashMap<String,Object>();
				pMap.put("gubun", "insert");
				forward = pojoCtrl.execute(req, res, pMap);
				
			} catch (Exception e) {
				logger.info("exception:"+e.toString());
			}
		}		
		//������ ó���� ���� ���� - sendRedirect | forward
		//��Ʈ ��� ��ȸ�� ��� 4���ΰ�? �ƴ� 5���� �����ؾ� �ϳ�?
		if(forward !=null) {
			if(!forward.isRedirect()) {//isRedirect() or setRedirect()
				res.sendRedirect(forward.getPath());
			}
			else {
				//insert here
				RequestDispatcher view = req.getRequestDispatcher(forward.getPath());
				view.forward(req, res);
			}
		}///////////////end of forward null check
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}	
}
