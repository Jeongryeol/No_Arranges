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
		logger.info("execute ȣ�� ����"+req.getAttribute("gubun"));
		String gubun = req.getAttribute("gubun").toString();
		ActionForward af = new ActionForward();
		String path = null;
		if("login".equals(gubun)) {//�α����� ó���� ��
			String mem_id = req.getParameter("mem_id");
			byte[] idBytes = mem_id.getBytes();
			Encoder idEncoder = Base64.getEncoder();
			byte[] idEncoderBytes = idEncoder.encode(idBytes);
			//StringŬ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ��� ���ο� ��ü�� �����Ұ�.
			String base64ID = new String(idEncoderBytes);
			String mem_pw = req.getParameter("mem_pw");
			byte[] pwBytes = mem_pw.getBytes();
			Encoder pwEncoder = Base64.getEncoder();
			byte[] pwEncoderBytes = pwEncoder.encode(pwBytes);
			//StringŬ������ ������ �ٲ��� �ʴ� Ŭ���� �̹Ƿ� ���ڵ��� ���ο� ��ü�� �����Ұ�.
			String base64PW = new String(pwEncoderBytes);
			Map<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("mem_id", base64ID);
			pMap.put("mem_pw", base64PW);			
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
		else if("zipcode".equals(gubun)){
			String dong = req.getParameter("dong");
			List<Map<String,Object>> zipCodeList = memLogic.zipCodeList(dong);
			req.setAttribute("zipCodeList", zipCodeList);
			path = "jsonZipCodeList.jsp";
			af.setRedirect(true);
			af.setPath(path);
		}
		else if("memberList".equals(gubun)){
			List<Map<String,Object>> memberList = memLogic.memberList();
			req.setAttribute("memberList", memberList);
			path = "jsonMemberList.jsp";
			af.setRedirect(true);
			af.setPath(path);
		}
		else if("pwSearch".equals(gubun)) {//���ã�� ó���� ��
			
		}

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
			result = memLogic.memberInsert(pMap);
			af.setRedirect(false);
			if(result==1) {
				af.setPath("memberInsertOk.jsp");
			}
			else if(result==0) {
				af.setPath("memberInsertFail.jsp");
			}
		}
		else if("memoInsert".equals(gubun)) {
			logger.info("���� ������ ó�� ����");
			result = memLogic.memoInsert(pMap);
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
