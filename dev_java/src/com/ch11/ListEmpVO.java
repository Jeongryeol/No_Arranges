package com.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vo.EmpVO;

public class ListEmpVO {

	List<EmpVO> empList = new ArrayList<EmpVO>();
	List<Map<String,Object>> empMap = new ArrayList<Map<String,Object>>();
	
	public void setList() {
		//VO패턴에는 한 번에 한 개 로우 값만 담을 수 있다.
		EmpVO evo = new EmpVO();
		evo.setEname("초기값"); //여기서 초기값은 EmpVO안에 ename변수(set)에 저장된 값
		empList.add(evo);
	} 
	public void setList2() {
		//VO패턴에는 한 번에 한 개 로우 값만 담을 수 있다.
		EmpVO evo = new EmpVO();
		evo.setEname("초기값"); //여기서 초기값은 EmpVO안에 ename변수(set)에 저장된 값
		empList.add(evo);
		
		//선호도의 차이...
		//단, ORM솔루션에서는 HashMap은 제공이 되지만, VO는 별도로 만든것이라 어려워질것
		if(empList.get(0) instanceof EmpVO) {
			//EmpVO에 있는 변수타입만 담고 꺼낼 수 있다.
			
		}else if(empList.get(0) instanceof Map) {
			//Map은 키를 이용해서 넣고 빼기가 가능하다.
			//Map의 오브젝트에 다양한 형태를 담을 수 있다.
		}
	}
	public int empInsert(int empno, String ename, String job, int mgr
			,String hiredate, double sal, double comm, int deptno) {
		int result = 0;
		return result;
	}
	
	public static void main(String[] args) {
		ListEmpVO lev = new ListEmpVO();
		System.out.println(lev.empList.size());
		//사원번호의 초기값을 출력해볼까?
		System.out.println("-----------------------------------");
		//System.out.println(lev.empList.get(0).getEmpno());
		//0번째 자료가 없으므로 indexBoundofException 에러 발생
		
		//담아서 다시 초기값을 출력해볼까?
		lev.setList();
		System.out.println("사원번호 초기값 : "+lev.empList.get(0).getEmpno());
		System.out.println("사원명 초기값 : "+lev.empList.get(0).getEname());
	}
	
}
