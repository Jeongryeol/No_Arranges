package com.ch2;

import java.util.Random;

public class W02_B1_VariableTestChange {

	public static void main(String[] args) {
		//x와 y값을 서로 교환해보기 예제
		int x=10;
		int y=20;
		System.out.println("현재 변수 x와 y의 값은 각각 "+x+", "+y+"이다.");
		System.out.println(" ");
		System.out.println("이제 x와 y의 값을 서로 변경해보자.");
		System.out.println(" ");
		int z=0;//z라는 새 변수 선언
		z=y;//z라는 변수에 y값 기억
		y=x;//y에 x값 기억
		x=z;//x에 기존 y값 기억
		System.out.println("변경된 변수 x와 y의 값은 각각 "+x+", "+y+"이다.");
		System.out.println(" ");
		//----쉬는시간에 하는 개인도전----
		//Random을 적용해서 교환해보자.
		Random r = new Random();//r은 랜덤API에 의한 주소번지를 가짐 java.util.Random@5c647e05
		int dap = r.nextInt(50);
		System.out.println(" ");
		System.out.println("---쉬는시간에 하는 개인복습---");
		System.out.println(" ");
		System.out.println("이번 시도때 랜덤으로 선택된 값(dap)은 "+dap+"이다.");
		System.out.println(" ");	
		System.out.println("이제 변경된 변수 x에 랜덤 선택된 값을 집어넣고,");
		System.out.println("x값을 다시 y값에 넣어보자.");
		System.out.println(" ");
		y=x;
		x=dap;
		System.out.println("랜덤되어 변경된 변수 x와 y의 값은 각각 "+x+", "+y+"이다.");
		System.out.println(" ");
		
		
	}

}
