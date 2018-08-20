package com.ch11;


import java.util.ArrayList;
import java.util.List;

import com.vo.EmpVO;

public class EmpController {//전역변수로 업무에 대한 분기처리를 하는 클래스로 사용됨

	final static String _INS = "insert";//반환타입 : int
	final static String _UPD = "update";//반환타입 : int
	final static String _DEL = "delete";//반환타입 : int
	final static String _SEL = "select";//반환타입 : ResultSet( Cursor조작이 필요함 )
	
	EmpVO	pevo = new EmpVO();
	EmpDAO	eDao = new EmpDAO();//JDBC구현클래스
	
	public int CUDEmp() {//입력,수정,삭제를 분기할 메소드
		int result = 0;
		if(_INS.equals(pevo.getCommand())) {
			
		}else if(_UPD.equals(pevo.getCommand())){
			
		}else if(_DEL.equals(pevo.getCommand())) {
			
		}
		return result;
	}
	//주석을 붙이는 습관을 반드시 들일 것!!
	/********************************************************
	 * 사원목록 조회 구현
	 * @param	evo - 사용자가 선택한 정보 (조건 검색할 때 )
	 * @return	List<EmpVO>
	 * @since	2018-07-05
	 * @author	이정렬
	 ********************************************************/
	public List<EmpVO> getEmpList(EmpVO evo){
		//반환타입 정의
		List<EmpVO> empList = new ArrayList<EmpVO>();
		//전체조회
		empList = eDao.getEmpList(evo);
		
		return empList;
	}
}
