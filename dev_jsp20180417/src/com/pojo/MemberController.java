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
 * 디폴트
 * @param : req - 세션생성, 사용자가 입력한 값 요청, 한글처리, forward처리할 때, scope, 저장소역할
 * @param : res - 마임타입, 인코딩 설정, PrintWriter생성(응답페이지 처리), 페이지 이동(sendRedirect)
 * @return : ActionForward - 페이지 이동 방법, 어디로 가야되지?-응답페이지
 *         , 자료구조 추가(업무처리 결과를 담음) - View계층 유지
 ************************************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공 / gubun = "+req.getAttribute("gubun"));
		//String mem_id = req.getParameter("mem_id");
		//String mem_pw = req.getParameter("mem_pw");
		String gubun = req.getAttribute("gubun").toString();
		
		
		logger.info("여기는 도착했니?");
		
		ActionForward af = new ActionForward();
		String path = null;
		if("login".equals(gubun)) {//로그인을 처리할 때
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
			Map<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("mem_id", base64ID);
			pMap.put("mem_pw", base64PW);
			pMap.put("mem_name", mem_name);
			
			Map<String,Object> rMap = memLogic.login(pMap);
			/*
			 * 최초에는 로그인 성공했을 때만 세션에 담았지만 ajax처리로 여러가지의 값을 내보내는 경우를 고려하여 개선처리함.
			 * 세션을 밖으로 빼고 조건식에 status를 비교하여 3가지 경우를 나누어 처리하는 코드로 변경함.
			 * 
			 */
			HttpSession session = req.getSession();
			if("1".equals(rMap.get("status").toString())) {
			//세션에 사용자 이름과 상태값을 담았으므로 forward처리 하지 않더라도 30분간 값을 유지할 수 있다.	
				session.setAttribute("smem_name", rMap.get("MEM_NAME").toString());
				//세션에 아이디도 담았으므로 업무페이지에서 내 이름은 세션에서 읽으면 된다.
				//화면에서 내 이름을 입력받을 필요가 전혀 없다.
				//단 비밀번호 찾기 서비스의 경우는 인증이 안된 상태이므로 사용자가 입력한 값을 사용함.
				//만일 회원정보 수정 혹은 회원제로 운영되는 사이트에서 주문자성명, 주문자 아이디를 가져올 때는 세션에서...
				session.setAttribute("smem_id", rMap.get("MEM_ID").toString());//주의
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
			logger.info("memberList 선택 성공");
			List<Map<String,Object>> rMapList = memLogic.getMemberList();
			logger.info("rMapList = "+rMapList);
			req.setAttribute("memberList",rMapList);
			path="jsonMemberList.jsp";
			af.setPath(path);
			af.setRedirect(true);
			
		}
		else if("pwSearch".equals(gubun)) {//비번찾기 처리할 때
			
		}
		else {
			logger.info("아무것도 걸리지 않음. 에러상황발생");
		}
		logger.info("이건 나오니?");

		return af;
	}
	/*************************************************************************************************************
	 * 확장팩
	 * @param : req - 세션생성, 사용자가 입력한 값 요청, 한글처리, forward처리할 때, scope, 저장소역할
	 * @param : res - 마임타입, 인코딩 설정, PrintWriter생성(응답페이지 처리), 페이지 이동(sendRedirect)
	 * @param : pMap - 역할이 머지?, 언제쓸까?, 왜 필요한거지?
	 *          a) 사용자가 입력한 값을 담는다. - 예)HashMapBinder클래스 참고 하세요.
	 *          b) View계층에 전달할 값을 담는다. 예)ActionForward에 List에 담을 수 있으니 화면단에서 누릴 수 있을지도......?????
	 * @return : ActionForward - 페이지 이동 방법, 어디로 가야되지?-응답페이지
	 *         , 자료구조 추가(업무처리 결과를 담음) - View계층 유지
	 ************************************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap)
			throws Exception {
		ActionForward af = new ActionForward();
		String gubun = pMap.get("gubun").toString();
		int result = 0;
		if("memINS".equals(gubun)) {
			logger.info("회원 등록 처리 시작");
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
			//insert here - 영식이가
			
		}
		else if("memDEL".equals(gubun)) {
			//insert here - 동희가...
		}
		return af;
	}

}
