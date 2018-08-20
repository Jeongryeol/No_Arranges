package com.ch7;
/*
 * 상속 완결편!!
 * 부모클래스와 자식클래스 관계일때, [상속관계일 때]
 * 0. 부모클래스보다 자녀클래스가 누릴것이  더 많다.
 * 	     즉, 상속받을때는 상위클래스보다 하위클래스가를 상속받는것이 누릴 것이 더 많다.
 * 1. Parent p1 = new Parent();
 * 		부모클래스는 부모클래스 내에 선언된 변수나 메소드만 누릴수 있다??
 * 		자녀클래스의 변수나 메소드는 호출할 수 없다.
 * 2. Parent p2 = new Child();
 * 		위와같이 선언부와 생성부가 다른 형태의 인스턴스화 할 때,
 * 		부모클래스에서 자식클래스의 변수나 메소드로 접근할 수 있다.
 * 		위와같이 선언된 경우, 변수 p2로 접근할 수 있는 자녀클래스는 methodC이다.
 * 		이때 부모클래스의 methodC는 쉐도우메소드가 된다. *  
 */
public class Inher_01_ChildSimul2 {

	public static void main(String[] args) {
		//Parent 타입의 변수 p   |  child 클래스 호출 ( child 클래스 안의 생성자 호출 )
		System.out.println("■■■■■■■■■■■■■■[ 테 스 트 ]■■■■■■■■■■■■■■■■■");
		Inher_01_Parent p = new Inher_01_Child();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("=======[부모클래스 메소드 호출]======");
			p.methodA();
			p.methodC();		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		Inher_01_Child c = new Inher_01_Child();
		System.out.println("=======[자식클래스 메소드 호출]======");
			c.methodA();
			c.methodB();
			c.methodC();	
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		

	}

}
