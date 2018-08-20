package com.ch7;

public class Inher_06_SonataSimul {

	//메인메소드
	public static void main(String[] args) {		
		Inher_06_Sonata car = new Inher_06_Sonata();
		Inher_06_Sonata car2 = new Inher_06_Sonata2018();
		Inher_06_Sonata2018 car3 = new Inher_06_Sonata2018();
		
		//아래 코드 논리오류 발생으로 안됨.
//		car2.cruise();
		//이유 : 부모클래스타입으로 선언된 변수는 부모와 자식 양쪽에 있는 메소드만 호출 가능하다.
		
		int speed = car2.speed;
		int whleelNum = car2.wheelNum;
		//아래 코드 논리오류 발생으로 안됨. 
//		String carColor = car2.carColor;
//		String carName = car2.carName;
		//부모타입의 변수는 오직 부모클래스의 변수만 접근 가능.
		
		//아래 구문은 에러 ( 하위클래스에 상위클래스를 넣음 )
//		car3 = car;
		car3 = (Inher_06_Sonata2018) car;
		//캐스팅 연산자(형전환)를 이용하여 부모타입을 자식타입으로 구문에러 수정 가능
		String carColor = car3.carColor;
		String carName	= car3.carColor;
		car3.cruise();
		car3.speedUp();
		car3.speedDown();
		
	}

}
