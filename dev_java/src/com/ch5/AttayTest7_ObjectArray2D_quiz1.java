package com.ch5;

import java.util.Random;

/*
 * 퀴즈 : -10에서 10 사이의 정수를 10개 채번하여 음수와 양수의 합계를 구하시오.
 * 힌트 : Random 클래스 활용하기
 */
public class AttayTest7_ObjectArray2D_quiz1 {

	public static void main(String[] args) {
		Random r  = new Random();
		int dap = 0;
		int[] rArr = new int[args.length];
		int sum = 0;
		
		for(int i=0;i<args.length;i++) {
			dap = r.nextInt(10);
			rArr[i] = dap;
			sum = sum + dap;
			System.out.println(i+" 번째 채번숫자 : "+rArr[i]);
			if(i==9)
				System.out.println("\n"+i+"번째 채번숫자까지의 합계 : "+sum);
		}

	}

}
