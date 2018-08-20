package com.ch6.exercise;

public class Exercise_10 {

	public static void main(String[] args) {
		
		float f = 4.2f;
		Float g = new Float(4.2f);
		Double d = new Double(4.2);
		
		System.out.println("g : "+g);
						//autoboxing기능으로 float타입으로 자동형전환 됨.
		
		
		/*
		 * ==은 비교연산자로 주소값을 비교한다.
		 * equals()메소드는 내용을 비교한다.
		 */
		
		
		System.out.println(f==g);
						//true	: float타입의 값과 주소번지에 들어있는 float타입의 값을 비교함 true
		System.out.println(d==f);
						//false	: float타입의 값과 주소번지에 들어있는 double타입의 값을 비교함 false
		System.out.println(g==g);
						//true	: 타입이 같고 같은 주소값이므로 true (자기자신과 비교)
		System.out.println(d.equals(f));
						//false : double타입 4.2d와 float타입 4.2f 비교이므로 false
		System.out.println(d.equals(g));
						//false : double타입 4.2d와 float타입 4.2f 비교이므로 false
		System.out.println(g.equals(4.2));
						//false	: float타입 4.2와 (실수값의 defalut 타입인) double타입 4.2 비교이므로 false
			
	}

}
