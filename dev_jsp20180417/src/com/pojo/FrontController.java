package com.pojo;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;
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
 * 프로젝트에서 클래스를 쪼개는 기준은 어떻게........
 * 업무별로 쪼갠다. - 주문관리, 회원관리, 고객관리
 * 어떤 업무를 태워야 할지를 어떻게 구분하지?
 * 힌트 - 업무에 대한 요청을 무엇으로 받고 있나요?
 * req.getRequestURI():String  -> /dev_jsp20180417/semanticUI/main.jsp
 * req.getContextPath():String -> /dev_jsp20180417
 * 왜 url요청정보를 읽어야 할까?
 * 업무별로 분기 - if문 
 * 질문
 * XXX.jsp  - 모델1 - 표준서블릿 처리  
 * XXX.kos - 모델2 - 사용자 정의 서블릿 태운다.
 * 
 * XXX.kos정보가 필요함.
 * 
 * FrontController의 역할
 * 1)총지배인 -총괄매니저 - url공격
 * 2)응답페이지에 대한 호출을  여기서 처리(관리) - 판정 
 * 
 * 
 */
public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException
	{
		logger.info("service호출 성공");
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
				logger.info("회원관리 : "+pMap.get("gubun"));
				if("login".equals(gubun)) {
					req.setAttribute("gubun", "login");//scope-저장,유지
					forward = memCtrl.execute(req, res);
				}
				else if("memberList".equals(gubun)) {
					req.setAttribute("gubun", "memberList");//scope-저장,유지
					forward = memCtrl.execute(req, res);
				}
				else if("pwSearch".equals(gubun)) {
					req.setAttribute("gubun", "pwSearch");//scope-저장,유지
					forward = memCtrl.execute(req, res);
				}				
				else if("memINS".equals(gubun)) {
					//Base64방식으로 적용하는 보안모듈 [ 아이디 ]
					String mem_id = req.getParameter("mem_id");		  //입력값읽기
					byte[] idBytes = mem_id.getBytes();				  //바이트배열로 변환
					Encoder idEncoder = Base64.getEncoder();		  //변환객체 생성
					byte[] idEncoderBytes = idEncoder.encode(idBytes);//변환객체로 배열을 변환
					String base64ID = new String(idEncoderBytes);	  //String 클래스는 원본이 바뀌지 않는 클래스 이므로 인코딩 된 새로운 객체를 생성할 것
					//Base64방식으로 적용하는 보안모듈 [ 비밀번호 ]
					String mem_pw = req.getParameter("mem_pw");		  //입력값읽기
					byte[] pwBytes = mem_pw.getBytes();				  //바이트배열로 변환
					Encoder pwEncoder = Base64.getEncoder();		  //변환객체 생성
					byte[] pwEncoderBytes = idEncoder.encode(pwBytes);//변환객체로 배열을 변환
					String base64PW = new String(pwEncoderBytes);	  //String 클래스는 원본이 바뀌지 않는 클래스 이므로 인코딩 된 새로운 객체를 생성할 것
					//이름은 인코딩할 필요가 없음
					String mem_name = Post_Hangul_Conversion.toKor(req.getParameter("mem_name"));
					//담기
					pMap.put("mem_id", base64ID);
					pMap.put("mem_pw", base64PW);
					pMap.put("mem_name", mem_name);
					forward = memCtrl.execute(req, res, pMap);
				}				
				
			} catch (Exception e) {
				logger.info("exception:"+e.toString());
			}			
		}
		else if("/pojo/getPojoList.kos".equals(command)) {
			//판정
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
 * 문제제기:현재 클래스 구조는 기능이 추가될때 마다 Controller 계속 증가하는 문제있음. - 어떡하지? - 개선방법이 멀까?
 * 해결방법1
 * PojoController클래스에 메소드가 한개이므로 if문으로 분기할 수 있도록 업무 구분자를 하나 보내서 처리해 본다.
 * (PojoController는 서블릿이 아니다 - 라이프사이클 관리를 개발자 해야된다.)
 * 다음 생각해 볼 문제
 * 업무구분자를 어떻게 보낼 수 있을까?
 * 방법a) 생성자의 파라미터로 보낸다.
 * 방법b) execute메소드를 오버로딩하여 매개변수(파라미터)로 보낸다.
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
		//페이지 처리에 대한 판정 - sendRedirect | forward
		//힌트 목록 조회의 경우 4번인가? 아님 5번을 선택해야 하나?
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
