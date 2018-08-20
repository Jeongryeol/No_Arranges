package com.base;

public class W01_B2_CircleArea {
/*
 * 연습문제
 * 원의 면적을 구하는 공식을 네이버에서 찾아보고 원의 면적을 계산해 주는 프로그램을 작성해 보시오.
 * 클래스 이름 CircleArea.java
 * 반지름 변수 이름 : r
 * 출력결과
 * 원의 면적은 XXX 입니다.
 * 
 */
	public static void main(String[] args) {//args변수이름, []배열
		//int Radius = 20;
		//int CArea = 1256;
		//String r = "반지름";
		
		//System.out.println(r+" = "+Radius);
		//System.out.println("원의면적 = "+"π"+r+"²");
		//System.out.println("그러므로 "+r+"이 "+Radius+"인 원의 면적은 "+CArea+"이다.");
		
		//실수를 어떻게 담지? - 타입이름이 뭐지?
		//int pi = 3.14;// 에러이유는? 실수만 입력 가능한 타입 int
		
		//실수 외의 숫자를 정의하는 타입은 double
		//상수로 정의할 땐 타입 앞에 final을 붙여서 정의함 (double final)
		final double PI = 3.14;
		
		//변수로 정의된 이름은 값을 재정의 할 수 있음 (int)
		//상수로 정의된 이름은 값을 재정의 할 수 없음 (final double)
		int speed = 0;
		speed = 50;

		//double TO = 20;
		//System.out.println(TO);

		//double 과 int의 차이는 소수점  표현가능의 유무 임
		
		int r = 5;
		//int+int = int
		//double+int=double
		//double/int=double
		//double*int=double
		double carea = r*r*PI;
		System.out.println("원의 면적은 "+carea+" 입니다.");
		
		
	}

}
