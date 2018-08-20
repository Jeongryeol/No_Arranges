package com.ch6;

public class Istance_A {//클래스A에 클래스C의 메소드C를 호출해보세요.

	//선언부
	Istance_C replicaC = new Istance_C();//클래스 C를 통째로 복제하여 전역 인스턴스 변수 C를 선언함
	
	//메소드 영역
	public void methodA() {//클래스A에 메소드A를 선언하세요. 리턴타입은 마음대로 하세요~ 왜?업무를 처리할게 아니기 때문
		System.out.println("[알림] classA의 methodA 호출 성공했습니다.");
	}
	
	//main메소드 영역
	public static void main(String[] args) {
		
		Istance_A replicaA = new Istance_A();//클래스 A를 통째로 복제하여 지역 인스턴스 변수로 선언함
		replicaA.replicaC.methodC();//복제된 지역인스턴스변수 A 안에서, 전역 인스턴스 변수 C를 찾고, 그 안에 메소드C를 찾아서 호출함
	
	}
	
}
