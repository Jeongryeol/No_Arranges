package com.ch11;


import java.util.List;

import com.vo.VO_FoodStore;

public class EmpController {//전역변수로 업무에 대한 분기처리를 하는 클래스로 사용됨

	final static String _INS = "insert";//반환타입 : int
	final static String _UPD = "update";//반환타입 : int
	final static String _DEL = "delete";//반환타입 : int
	final static String _SEL = "select";//반환타입 : ResultSet( Cursor조작이 필요함 )
	
	VO_FoodStore	pevo = new VO_FoodStore();
	EmpDAO	eDao = new EmpDAO();//JDBC구현클래스
	
	public int CUDEmp() {//입력,수정,삭제를 분기할 메소드
		int result = 0;
		if(_INS.equals(pevo.getCommand())) {
			
		}else if(_UPD.equals(pevo.getCommand())){
			
		}else if(_DEL.equals(pevo.getCommand())) {
			
		}
		return result;
	}
	
	public List<VO_FoodStore> getEmpList(VO_FoodStore evo){
		
		return null;
	}
}
