package com.ch4;

import java.util.Random;

public class ControlSt_Test2_if {
/*
 * 연습문제
 * 1부터 100사이의 숫자를 채번해서 5의 배수이면 5의 배수입니다 라고 출력하고
 * 7로 나눈 나머지가 0이면 7의 배수 입니다. 라고 출력하고
 * 5로 나눈 나머지가 0이고 7로 나눈 나머지도 0이면 5와 7의 공배수 라고 출력하는
 * 프로그램을 작성하시오.
 * 
 */
	public static void main(String[] args) {
		Random r = new Random();//채번 : 컴퓨터가 아무숫자를 채집하게 함
		int ranNum= r.nextInt(101);
		String result = "결과";
		System.out.printf("채번된 숫자는 %d입니다.%n",ranNum);
		if((ranNum%7==0)||(ranNum%5==0)) {
			if((ranNum%7==0)&&(ranNum%5==0)) {
				result = "5와 7의 공배수";
				System.out.printf("채번된 숫자 %d은(는) %c입니다.",ranNum,result);
			}
			else if((ranNum%7!=0)&&(ranNum%5==0)) {
				result = "7의 배수";
				System.out.printf("채번된 숫자 %d은(는) %c입니다.",ranNum,result);
			}
		}
		else {
			System.out.printf("이 숫자는 5와 7의 배수가 아닙니다.",ranNum);
		}
	}

}
