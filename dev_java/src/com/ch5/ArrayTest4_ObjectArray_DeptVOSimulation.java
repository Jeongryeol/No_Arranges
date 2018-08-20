package com.ch5;

public class ArrayTest4_ObjectArray_DeptVOSimulation {

	public static void main(String[] args) {
		ArrayTest4_ObjectArray_DeptVO dvos[] = new ArrayTest4_ObjectArray_DeptVO[4];
/*
 *		int	   deptnos[] = new int[4];
 *		String dnames[]  = new String[4];
 *		String loc[]     = new String[4];
 *		//DeptVO클래스에 대해 생각해 본거야? - 서로 다른 변수를 여러 개 선언할 수 있어요.
 *		//DeptVO에는 한번에 한 개 로우를 담을 수 있을까? - 변수가 3개 선언되어 있으니까 한번에 한 개 로우만 담을 수 있어요.
 */
		ArrayTest4_ObjectArray_DeptVO dvo = new ArrayTest4_ObjectArray_DeptVO();
		dvo.deptno = 10;
		dvo.dname  = "ACCOUNTING";
		dvo.loc	   = "NEW YORK";
		dvos[0]    = dvo;//변수는 한번에 하나의 값만 담을 수 있고, 불러온 클래스 안에 있는 것도 변수이기 때문에 한번에 하나의 로우만 담을 수 있는 것.
		dvo = new ArrayTest4_ObjectArray_DeptVO();//똑같은 dvo변수 이지만 new를 이용하여 인스턴스화 했기때문에, 새로운 주소번지를 가짐 
		dvo.deptno = 20;
		dvo.dname  = "RESEARCH";
		dvo.loc	   = "DALLOS";
		dvos[1]    = dvo;
		dvo = new ArrayTest4_ObjectArray_DeptVO();//똑같은 dvo변수 이지만 new를 이용하여 인스턴스화 했기때문에, 새로운 주소번지를 가짐 
		dvo.deptno = 30;
		dvo.dname  = "SALES";
		dvo.loc	   = "CHICAGO";
		dvos[2]    = dvo;
		dvo = new ArrayTest4_ObjectArray_DeptVO();//똑같은 dvo변수 이지만 new를 이용하여 인스턴스화 했기때문에, 새로운 주소번지를 가짐 
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
