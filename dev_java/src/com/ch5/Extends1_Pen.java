package com.ch5;
//모든 최상위클래스(superclass) object에 상속(extends)되어 있음
public class Extends1_Pen extends Object{
	
	int noX;//전역변수는 초기화하지 않아도 됨
	
	public static void main(String[] args) {
		int x=0;//지역변수는 반드시 초기화를 해야함
		x = 10;
		Extends2_Audio au[] = new Extends2_Audio[3];
//		au[0] = x;
		/*	불가한 이유 1 : 타입이 다르기 때문!!
				상속하는객체는 참조형타입 - 상속되는객체는 원시형 타입
			불가한 이유 2 : 급이 다르기 때문!!
				상속하는객체는 클래스급 - 상속되는객체는 원시형타입 */ 
		Object obj[] = new Object[3];
		obj[0] = x;
		//가능한 이유 : 래퍼클래스 제공되기 때문!!
		//최상위 클래스 Object에는 래퍼클래스(wrapper class)인 Integer클래스가 제공되기 때문에 가능
		System.out.println(obj[0]);

	}

}
