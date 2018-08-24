package com.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/*
 * 단순 업무(입력|수정|삭제|조회 - 테이블이 오직 한개일때)처리에서는 Logic클래스에서 하는 일이 없다.
 * 1)약속
 * 2)판단, 선택, 책임, 결정
 *  :여러가지 프로세스를 한 개 클래스에서 처리할 때 필요성을 느낄수 있음.
 */
public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	/*
	 * 아래와 같이 직접 인스턴스화 하는 것은 의존성 주입이 아니다.
	 * 직접 인스턴스화 할 경우 객체에 대한 사이프사이클관리 책임이 개발자
	 * 그러나 spring과 같은 오픈 프레임워크를 활용하면 이렇게 직접 인스턴스화 하지 않음.
	 */
	SqlMemberDao memDao = new SqlMemberDao();
	public int memberInsert(Map<String,Object> pMap) {
		int result = 0;
		result = memDao.memberInsert(pMap);
		logger.info("result:"+result);
		return result;
	}
	public Map<String, Object> login(Map<String, Object> pMap) {
		logger.info("login 호출 성공");
		int status = -2;
		Map<String, Object> rMap = new HashMap<String,Object>();
		status = memDao.idExist(pMap.get("mem_id").toString());
		//SqlMemberDao의 login메소드는 언제 호출해야 할까요?
		if(status==2) {//아이디가 존재하는 경우 - 이때만 비번을 체크하면 됨.
			rMap = memDao.login(pMap);
			if(rMap.get("MEM_NAME")!=null && rMap.get("MEM_NAME").toString().length()>=1) {
				rMap.put("status", "1");
			}
			else {
				rMap.put("status", "0");
			}
		}
		else {
			rMap.put("status", status);//status에는 어떤 숫자가 담겨 있을 까요? -1
		}
		return rMap;
	}
	public List<Map<String, Object>> memberList() {
		logger.info("memberList 호출 성공");
		List<Map<String, Object>> memberList = new ArrayList<Map<String,Object>>();
		memberList = memDao.memberList();
		return memberList;
	}
	public List<Map<String, Object>> zipCodeList(String dong) {
		logger.info("zipCodeList 호출 성공");
		List<Map<String, Object>> zipCodeList = new ArrayList<Map<String,Object>>();
		zipCodeList = memDao.zipCodeList(dong);
		return zipCodeList;
	}
	//쪽지 보내기 구현
	public int memoInsert(Map<String, Object> pMap) {
		int result = 0;
		result = memDao.memoInsert(pMap);
		logger.info("result:"+result);
		return result;
	}	
}








