package com.ch4;

import java.util.Random;

public class ControlSt_Test3_switch {
	/*
	 * 연습문제
	 * 1부터 100사이의 숫자를 채번해서 5의 배수이면 5의 배수입니다 라고 출력하고
	 * 7로 나눈 나머지가 0이면 7의 배수 입니다. 라고 출력하고
	 * 5로 나눈 나머지가 0이고 7로 나눈 나머지도 0이면 5와 7의 공배수 라고 출력하는
	 * 프로그램을 작성하시오.
	 * 
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int insNum = r.nextInt(101);
		System.out.println("채번된 숫자:"+insNum);
		int calNum = insNum%7;
		switch (calNum) {//switch문을 두번이상 걸쳐쓰는방식은 안되는 것은 아니지만, 계산이 더 많아지므로 부하가 생김
			case 0:
				calNum=insNum%5;
				switch (calNum) {
					case 0:
					System.out.printf("%d는 5와 7의 공배수입니다.",insNum);
					break;
					default:
					System.out.printf("%d는 7의 배수입니다.",insNum);
					break;
				}break;
			default:
				calNum=insNum%5;
				switch (calNum) {
					case 0:
					System.out.printf("%d는 5의 배수입니다.",insNum);
					break;
					default:
					System.out.printf("%d는 5와 7 어느 쪽도 배수가 되지 않습니다.",insNum);
					break;
			}break;
		}//end of switch	
	}//////end of main
}//////////end of class
