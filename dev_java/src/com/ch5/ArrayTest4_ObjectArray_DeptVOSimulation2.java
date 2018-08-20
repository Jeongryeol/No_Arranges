package com.ch5;

public class ArrayTest4_ObjectArray_DeptVOSimulation2 {

	public static void main(String[] args) {

		int 	deptnos[] = {10,20,30,40};
		String	dnames[]  = {"ACCOUNTING","RESEARCH","SALES","OPERATION"};
		String	locs[]    = {"NEW YORK","DALLAS","CHICAGO","BOSTON"};
		for(int i=0;i<deptnos.length;i++) {
			System.out.println(deptnos[i]+", "+dnames[i]+", "+locs[i]);
			
		}
	}

}
