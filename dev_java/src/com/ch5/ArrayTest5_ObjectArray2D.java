package com.ch5;

public class ArrayTest5_ObjectArray2D {

	public static void main(String[] args) {
		int is[][] = new int[3][2];//방은 몇개? 초기값은 얼마?
		for(int i=0;i<is.length;i++) {//is.length는 얼마니? row의 개수 3개
			for(int j=0;j<is[i].length;j++) {//그렇다면, column의 길이는 어떻게 구하지?
				System.out.println("["+i+"]["+j+"] = "+is[i][j]);
			}
		}
		System.out.println(" ");

		int is2[][] = {
						{10,11,12}
					   ,{13,14,15}
					   ,{16,17,18}
			   		  };
		//insert here l- is2배열을 출력해 보세요.
		for(int i=0;i<is2.length;i++) {
			System.out.println(is2[i]);
			System.out.println("is2["+i+"] = "+is2[i]);
		}
		System.out.println(" ");
		for(int i=0;i<is2.length;i++) {
			for(int j=0;j<is2[i].length;j++) {
				System.out.println("is2["+i+"]["+j+"] = "+is2[i][j]);
			}
		}
		System.out.println(" ");

		for(int i=0;i<is2.length;i++) {
			for(int j=0;j<is2[i].length;j++) {
				System.out.printf("is2[%d][%d]="+is2[i][j]+"%n",i,j);
			}
		}
		System.out.println(" ");
		
		int is3[][] = new int [2][];//size가 결정되지 않은상태로 배열이 선언됨
		is3[0] = new int [3];
		is3[0][0] = 1;
		is3[0][1] = 2;
		is3[0][2] = 3;
		is3[1] = new int [5];//컬럼의 수가 로우마다 다르게 지정될 수 있고, 출력할 수 있음
		is3[1][0] = 10;
		is3[1][1] = 20;
		is3[1][2] = 30;
		is3[1][3] = 40;
		is3[1][4] = 50;
		for(int i=0;i<is3.length;i++) {
			for(int j=0;j<is3[i].length;j++) {
				System.out.println("is3["+i+"]["+j+"] = "+is3[i][j]);
			}
		}
		
	}

}
