package com.ch5;

public class ArrayTest4_ObjectArray_DeptVOSimulation {

	public static void main(String[] args) {
		ArrayTest4_ObjectArray_DeptVO dvos[] = new ArrayTest4_ObjectArray_DeptVO[4];
/*
 *		int	   deptnos[] = new int[4];
 *		String dnames[]  = new String[4];
 *		String loc[]     = new String[4];
 *		//DeptVOŬ������ ���� ������ ���ž�? - ���� �ٸ� ������ ���� �� ������ �� �־��.
 *		//DeptVO���� �ѹ��� �� �� �ο츦 ���� �� ������? - ������ 3�� ����Ǿ� �����ϱ� �ѹ��� �� �� �ο츸 ���� �� �־��.
 */
		ArrayTest4_ObjectArray_DeptVO dvo = new ArrayTest4_ObjectArray_DeptVO();
		dvo.deptno = 10;
		dvo.dname  = "ACCOUNTING";
		dvo.loc	   = "NEW YORK";
		dvos[0]    = dvo;//������ �ѹ��� �ϳ��� ���� ���� �� �ְ�, �ҷ��� Ŭ���� �ȿ� �ִ� �͵� �����̱� ������ �ѹ��� �ϳ��� �ο츸 ���� �� �ִ� ��.
		dvo = new ArrayTest4_ObjectArray_DeptVO();//�Ȱ��� dvo���� ������ new�� �̿��Ͽ� �ν��Ͻ�ȭ �߱⶧����, ���ο� �ּҹ����� ���� 
		dvo.deptno = 20;
		dvo.dname  = "RESEARCH";
		dvo.loc	   = "DALLOS";
		dvos[1]    = dvo;
		dvo = new ArrayTest4_ObjectArray_DeptVO();//�Ȱ��� dvo���� ������ new�� �̿��Ͽ� �ν��Ͻ�ȭ �߱⶧����, ���ο� �ּҹ����� ���� 
		dvo.deptno = 30;
		dvo.dname  = "SALES";
		dvo.loc	   = "CHICAGO";
		dvos[2]    = dvo;
		dvo = new ArrayTest4_ObjectArray_DeptVO();//�Ȱ��� dvo���� ������ new�� �̿��Ͽ� �ν��Ͻ�ȭ �߱⶧����, ���ο� �ּҹ����� ���� 
		dvo.deptno = 40;
		dvo.dname  = "OPERATION";
		dvo.loc	   = "BOSTON";
		dvos[3]    = dvo;
		for(int i=0;i<dvos.length;i++) {
			ArrayTest4_ObjectArray_DeptVO dvo2 = dvos[i];
			System.out.println(dvo2.deptno+", "+dvo2.dname+", "+dvo2.loc);
		}
		
	}

}
