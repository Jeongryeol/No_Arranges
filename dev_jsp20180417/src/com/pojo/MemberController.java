package com.pojo;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Base64.Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.util.Post_Hangul_Conversion;

public class MemberController implements Action {
	Logger logger = Logger.getLogger(MemberController.class);
	MemberLogic memLogic = new MemberLogic();
/*************************************************************************************************************
 * ����Ʈ
 * @param : req - ���ǻ���, ����ڰ� �Է��� �� ��û, �ѱ�ó��, forwardó���� ��, scope, ����ҿ���
 * @param : res - ����Ÿ��, ���ڵ� ����, PrintWriter����(���������� ó��), ������ �̵�(sendRedirect)
 * @return : ActionForward - ������ �̵� ���, ���� ���ߵ���?-����������
 *         , �ڷᱸ�� �߰�(����ó�� ����� ����) - View���� ����
 ************************************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute ȣ�� ���� / gubun = "+req.getAttribute("gubun"));
		//String mem_id = req.getParameter("mem_id");
		//String mem_pw = req.getParameter("mem_pw");
		String gubun = req.getAttribute("gubun").toString();
		
		
		logger.info("����� �����ߴ�?");
		
		ActionForward af = new ActionForward();
		String path = null;
		if("login".equals(gubun)) {//�α����� ó���� ��
			//Base64������� �����ϴ� ���ȸ�� [ ���̵� ]
			String mem_id = req.getParameter("mem_id");		  //�Է°��б�
			byte[] idBytes = mem_id.getBytes();				  //����Ʈ�迭�� ��ȯ
			Encoder idEncoder = Base64.getEncoder();		  //��ȯ��ü ����
			byte[] idEncoderBytes = idEncoder.encode(idBytes);//��ȯ��ü�� �迭�� ��ȯ
			String base64ID = new String(idEncoderBytes);	  //String Ŭ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ� �� ���ο� ��ü�� ������ ��
			//Base64������� �����ϴ� ���ȸ�� [ ��й�ȣ ]
			String mem_pw = req.getParameter("mem_pw");		  //�Է°��б�
			byte[] pwBytes = mem_pw.getBytes();				  //����Ʈ�迭�� ��ȯ
			Encoder pwEncoder = Base64.getEncoder();		  //��ȯ��ü ����
			byte[] pwEncoderBytes = idEncoder.encode(pwBytes);//��ȯ��ü�� �迭�� ��ȯ
			String base64PW = new String(pwEncoderBytes);	  //String Ŭ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ� �� ���ο� ��ü�� ������ ��
			//�̸��� ���ڵ��� �ʿ䰡 ����
			String mem_name = Post_Hangul_Conversion.toKor(req.getParameter("mem_name"));
			//���
			Map<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("mem_id", base64ID);
			pMap.put("mem_pw", base64PW);
			pMap.put("mem_name", mem_name);
			
			Map<String,Object> rMap = memLogic.login(pMap);
			/*
			 * ���ʿ��� �α��� �������� ���� ���ǿ� ������� ajaxó���� ���������� ���� �������� ��츦 ����Ͽ� ����ó����.
			 * ������ ������ ���� ���ǽĿ� status�� ���Ͽ� 3���� ��츦 ������ ó���ϴ� �ڵ�� ������.
			 * 
			 */
			HttpSession session = req.getSession();
			if("1".equals(rMap.get("status").toString())) {
			//���ǿ� ����� �̸��� ���°��� ������Ƿ� forwardó�� ���� �ʴ��� 30�а� ���� ������ �� �ִ�.	
				session.setAttribute("smem_name", rMap.get("MEM_NAME").toString());
				//���ǿ� ���̵� ������Ƿ� �������������� �� �̸��� ���ǿ��� ������ �ȴ�.
				//ȭ�鿡�� �� �̸��� �Է¹��� �ʿ䰡 ���� ����.
				//�� ��й�ȣ ã�� ������ ���� ������ �ȵ� �����̹Ƿ� ����ڰ� �Է��� ���� �����.
				//���� ȸ������ ���� Ȥ�� ȸ������ ��Ǵ� ����Ʈ���� �ֹ��ڼ���, �ֹ��� ���̵� ������ ���� ���ǿ���...
				session.setAttribute("smem_id", rMap.get("MEM_ID").toString());//����
				session.setAttribute("sstatus", rMap.get("status").toString());
				path = "loginSuccess.jsp";
				af.setRedirect(false);
				af.setPath(path);			
			}
			else if("0".equals(rMap.get("status").toString())) {
				session.setAttribute("smem_name", "default");
				session.setAttribute("sstatus", rMap.get("status").toString());
				path = "pwDifferent.jsp";
				af.setRedirect(false);
				af.setPath(path);	
			}
			else if("-1".equals(rMap.get("status").toString())) {
				session.setAttribute("smem_name", "default");
				session.setAttribute("sstatus", rMap.get("status").toString());
				path = "idNotFound.jsp";
				af.setRedirect(false);
				af.setPath(path);	
			}			
		
		}
		else if("memberList".equals(gubun)) {
			logger.info("memberList ���� ����");
			List<Map<String,Object>> rMapList = memLogic.getMemberList();
			logger.info("rMapList = "+rMapList);
			req.setAttribute("memberList",rMapList);
			path="jsonMemberList.jsp";
			af.setPath(path);
			af.setRedirect(true);
			
		}
		else if("pwSearch".equals(gubun)) {//���ã�� ó���� ��
			
		}
		else {
			logger.info("�ƹ��͵� �ɸ��� ����. ������Ȳ�߻�");
		}
		logger.info("�̰� ������?");

		return af;
	}
	/*************************************************************************************************************
	 * Ȯ����
	 * @param : req - ���ǻ���, ����ڰ� �Է��� �� ��û, �ѱ�ó��, forwardó���� ��, scope, ����ҿ���
	 * @param : res - ����Ÿ��, ���ڵ� ����, PrintWriter����(���������� ó��), ������ �̵�(sendRedirect)
	 * @param : pMap - ������ ����?, ��������?, �� �ʿ��Ѱ���?
	 *          a) ����ڰ� �Է��� ���� ��´�. - ��)HashMapBinderŬ���� ���� �ϼ���.
	 *          b) View������ ������ ���� ��´�. ��)ActionForward�� List�� ���� �� ������ ȭ��ܿ��� ���� �� ��������......?????
	 * @return : ActionForward - ������ �̵� ���, ���� ���ߵ���?-����������
	 *         , �ڷᱸ�� �߰�(����ó�� ����� ����) - View���� ����
	 ************************************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap)
			throws Exception {
		ActionForward af = new ActionForward();
		String gubun = pMap.get("gubun").toString();
		int result = 0;
		if("memINS".equals(gubun)) {
			logger.info("ȸ�� ��� ó�� ����");
/*			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);*/
			result = memLogic.memberInsert(pMap);
			af.setRedirect(false);
			if(result==1) {
				af.setPath("memberInsertOk.jsp");
			}
			else if(result==0) {
				af.setPath("memberInsertFail.jsp");
			}
		}
		else if("memUPD".equals(gubun)) {
			//insert here - �����̰�
			
		}
		else if("memDEL".equals(gubun)) {
			//insert here - ����...
		}
		return af;
	}

}
