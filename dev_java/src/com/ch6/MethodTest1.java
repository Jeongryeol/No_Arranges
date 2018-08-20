package com.ch6;

public class MethodTest1 {

	//인스턴스화는 전역에서도 선언가능
	MethodTest1 mt2 = new MethodTest1();
	
	//수정자의 기입과 생략
	public static void methodA() {}
	public final void methodB() {}
	public void methodC() {}
	
	//리턴타입과 final고정(메소드오버라이딩 불가)
	public static int methodA1() {return 0;}
	public double methodB1() {double d=0.5; return d;}
	public final String methodC1() {return "안녕";}
	
	public static void main(String[] args) {

		methodA();//static은 인스턴스화없이 호출가능
		//static안에서 호출할때는 내안에 있더라도 non-static은 인스턴스화 필요
		//인스턴스화는 지역에서도 가능
		//전역변수와 같은 구문을 입력해도 에러가 발생하지 않는 이유는 지역변수에서 새로이 인스턴스화 한 것이기 때문
		MethodTest1 mt = new MethodTest1();
		mt.methodB();
		mt.methodC();
		mt.methodC();

		//전역변수 mt2는 main메소드에서 접근할 수 있다|없다.
//		mt2.methodA();//없다. 왜냐하면 mt2변수는 non-static타입이기 때문.
		//만일 static을 클래스이름 앞에 붙이게 되면 접근할 수 있게 됨.
		//그러나 공유되게 되므로, 복제본을 사용하는 것이 아니라 원본 하나를 공유하게 되는 것임.

		//전역변수 mt2를 non-static으로 선언해서 접근하고 싶다면, 주소번지를 두번 사용해야함
		//mt는 지역변수 아지만, MethodTest1클래스를 메모리(static영역)에 로딩시켜주므로
		//mt2 전역변수에 접근할 수 있는 것.
		mt.mt2.methodC1();
		//이때, 모든 클래스의 아버지인 Object클래스에 정의된 메소드 toSting()을 호출 할 수 있게 되는 것.
		//즉, 지역인스턴스변수 선언을 통해 전역인스턴스변수로 접근 + Object클래스 내 toString메소드 호출
		mt.mt2.toString();
		System.out.println(mt.mt2.toString());


	}

}
