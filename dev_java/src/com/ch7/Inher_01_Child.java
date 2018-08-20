package com.ch7;

public class Inher_01_Child extends Inher_01_Parent {

	int j;
	
	public Inher_01_Child() {
		System.out.println("자식클래스의 디펄트생성자가 호출되었습니다.");
	}
	
	public void methodB() {
		System.out.println("자식클래스의  methodB가 호출되었습니다.");
	}
	
	//[Q.]methodC의 원형을 JVM이 어떻게 메소드를 오버라이드할때 이름,리턴타입,파라미터를 알고 에러를 보일까?
	//메모장에다가 코딩을 하면 실제 프로그램을 돌렸을때 인스턴스화하면서 상속관계를 확인하고 에러메세지를 확인할 수 있다.
	//	Parent p = new Child();로 인스턴스화로 생성자를 호출하게되면, 부모와 자식의 생성자 모두 호출된다.(p.312)
	//[Tips]현재코드는 이클립스가 작동전에 오버라이드된 메소드의 이름과 리턴타입, 파라미터를 체크한다.
	
	@Override//(p.327)
	public void methodC() {
		System.out.println("[오버라이드]자식클래스의  methodC가 호출되었습니다.");		
	}
	
	//Overload (p.327)
	public void methoc(int i) {
		System.out.println("[오버로드]자식클래스의 methodC가 int i = "+i+"을 파라미터로 호출되었습니다.");
	}
}
