package com.ch6;

public class MethodTest1_HP extends Object {//모든 클래스는 Object 클래스를 아버지로 두고 상속되어있다.
	
	//insert here - 같은 이름의 메소드를 4개 정의해보세요.
	//메소드 오버로딩을 적용하여 같은 이름의 메소드를 n개 만큼 정의할 수 있다.
	public void call() {}								//0번
	public void call(String phoneNumber) {}				//0번
	public void call(String phoneNumber,String name) {}	//0번
	void call(int phoneNumber) {}						//1번
	int call(int phoneNumber, int newPhoneNumber) {return newPhoneNumber;} //1번,2번
	public void call(String phoneNumber, String name, String gender) throws Exception {}
	//메소드 오버로딩 : 메소드 이름은 같지만, 파라미터로 구분하여 새롭게 정의함
/* 	[ 메소드 오버로딩 결론 ]
	 0. 무조건 파라미터의 타입이나 개수가 달라야 작동한다
	 1. 접근제한자가 있고 없고는 영향이 없다.
	 2. 리턴타입이 있고 없고는 영향이 없다.
	 3. 예외를 던지고 안 던지고에 영향이 없다.			*/
	
	
	//@ : annotation 메소드 재정의예약어 기입용 기호
	@Override//아래 메소드의 리턴타입을 고정시켜 JVM에게 기억시킨다.
	public String toString() {
		return "리턴타입이 고정된 메소드";
	}//클래스 사이에서 Override된 메소드를 로딩(호출)하는 경우, 반드시 원형을 지켜준다.
	
	public String parseInt() {
		return "리턴타입이 고정되지않은 메소드";
	}
	
	public static void main(String[] args) {
		MethodTest1_HP hp = new MethodTest1_HP();//변수hp는 지역변수
		System.out.println(hp.toString());
	}
	
}
