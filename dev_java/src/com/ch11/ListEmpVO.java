package com.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vo.EmpVO;

public class ListEmpVO {

	List<EmpVO> empList = new ArrayList<EmpVO>();
	List<Map<String,Object>> empMap = new ArrayList<Map<String,Object>>();
	
	public void setList() {
		//VO���Ͽ��� �� ���� �� �� �ο� ���� ���� �� �ִ�.
		EmpVO evo = new EmpVO();
		evo.setEname("�ʱⰪ"); //���⼭ �ʱⰪ�� EmpVO�ȿ� ename����(set)�� ����� ��
		empList.add(evo);
	} 
	public void setList2() {
		//VO���Ͽ��� �� ���� �� �� �ο� ���� ���� �� �ִ�.
		EmpVO evo = new EmpVO();
		evo.setEname("�ʱⰪ"); //���⼭ �ʱⰪ�� EmpVO�ȿ� ename����(set)�� ����� ��
		empList.add(evo);
		
		//��ȣ���� ����...
		//��, ORM�ַ�ǿ����� HashMap�� ������ ������, VO�� ������ ������̶� ���������
		if(empList.get(0) instanceof EmpVO) {
			//EmpVO�� �ִ� ����Ÿ�Ը� ��� ���� �� �ִ�.
			
		}else if(empList.get(0) instanceof Map) {
			//Map�� Ű�� �̿��ؼ� �ְ� ���Ⱑ �����ϴ�.
			//Map�� ������Ʈ�� �پ��� ���¸� ���� �� �ִ�.
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
		//�����ȣ�� �ʱⰪ�� ����غ���?
		System.out.println("-----------------------------------");
		//System.out.println(lev.empList.get(0).getEmpno());
		//0��° �ڷᰡ �����Ƿ� indexBoundofException ���� �߻�
		
		//��Ƽ� �ٽ� �ʱⰪ�� ����غ���?
		lev.setList();
		System.out.println("�����ȣ �ʱⰪ : "+lev.empList.get(0).getEmpno());
		System.out.println("����� �ʱⰪ : "+lev.empList.get(0).getEname());
	}
	
}
