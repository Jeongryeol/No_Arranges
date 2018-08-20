package com.ch11;

import java.util.List;
import java.util.Map;

import com.vo.VO_FoodStore;

public class EmpDaoSimulation {

	public static void main(String[] args) {
		//∞¥√º¡÷¿‘
		EmpDAO eDao = new EmpDAO();
		List<VO_FoodStore> empList = eDao.getEmpList(null);
		//SELECT COUNT(*) FROM emp
		System.out.println(empList.size());
		
		int result = 0;
		result = eDao.delete(9958);
		//DELETE FROM emp WHERE empno = ?
		System.out.println(result);
		
		result = 0;
		BoardDao bDao = new BoardDao();
		List<Map<String,Object>> boardList = bDao.getBoardList(null);
		result = boardList.size();
		System.out.println(result);
		
	}

}
