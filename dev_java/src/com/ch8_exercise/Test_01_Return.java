package com.ch8_exercise;

/* 예약어 return에 대해 정리해 둘 것.......
 * if문에서 return을 사용하면 그 블럭(즉 해당 메소드)를 탈출한다.
 * return 이후에 문장들은 실행되지 않는다.
 * 메소드 안에 return를 사용하면 값을 반환한다.
 */

public class Test_01_Return {

	public static void foo(int x) {
		if(x==5) {
			return;
		}else{
			System.out.println("else");
		}
		System.out.println("여기");
	}
	
	public static void main(String[] args) {
		//파라미터에 5를 넣으면 아무것도 출력되지 않음
		//foo(5);
		foo(3);
	}
	
}
