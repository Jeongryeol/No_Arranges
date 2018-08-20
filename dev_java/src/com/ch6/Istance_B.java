package com.ch6;

public class Istance_B {

	//선언부
	//클래스B 전역에서 사용할 수 있는 전역 인스턴스 변수로 선언됨
	Istance_A replicaA = new Istance_A();//클래스B에 클래스A의 메소드 A를 호출해보세요.
	
	//메소드영역
	void expB() {
		replicaA.methodA();//전역 인스턴스 변수로 부터 사용하는 호출		
	}
	
	//main메소드 영역
	public static void main(String[] args) {
		
		//타입이 같은 다른 클래스가 지역 인스턴스변수 로 복제되었다.(전역 인스턴스 변수와는 다른 복제본이 된 것)
		Istance_A replicaA = new Istance_A();
		replicaA.methodA();//지역 인스턴스 변수로 부터 사용하는 호출
		
	}
	
}
