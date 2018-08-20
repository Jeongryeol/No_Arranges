package com.ch4;

import java.util.Random;

public class ControlSt_Test3_switch2 {
	/*
	 * 연습문제
	 * 1부터 100사이의 숫자를 채번해서 5의 배수이면 5의 배수입니다 라고 출력하고
	 * 7로 나눈 나머지가 0이면 7의 배수 입니다. 라고 출력하고
	 * 5로 나눈 나머지가 0이고 7로 나눈 나머지도 0이면 5와 7의 공배수 라고 출력하는
	 * 프로그램을 작성하시오.
	 * 
	 * 순서가 중요하다
	 * 순서에 따라 결과가 달라질 수 있다.
	 * 35에 대해 5로 먼저 나누거나 7로 먼저 나누면 한쪽으로 넘어가서 올바르게 만들어지지 않음
	 * 공배수로 나눠서 남은 나머지에 대한 case를 작성하면 작성해야하는 코드량도 적고 부하도 적어짐
	 * (switch문이든 if문이든 짧게 만들어야 효율적이고, 중복사용을 하지 않아야 부하가 적다. 
	 * 
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int rnum = r.nextInt(100);
		rnum = rnum+1;//1부터 100까지 채번하기 위해 처리
		System.out.println("채번된 숫자는 "+rnum);
		switch(rnum%35) {
			case 0:
				System.out.println(rnum+"는 5와 7의 공배수입니다.");
				break;
		
			case 5: case 10: case 15: case 20: case 25: case 30:  
				System.out.println(rnum+"는 5의 배수입니다.");
				break;
			case 7: case 14: case 21: case 28:  
				System.out.println(rnum+"는 7의 배수입니다.");
				break;
			default:
				System.out.println(rnum);
				break;
		}
	}
}

