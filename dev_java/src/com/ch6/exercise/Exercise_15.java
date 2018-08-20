package com.ch6.exercise;

public class Exercise_15 {

	public static void main(String args[]) {
		
		Integer s = new Integer(9);
		Integer t = new Integer(9);
		Long u = new Long(9);

		//Which tests would return true?
		//a.
		System.out.println(s.equals(t));
						//변수이름이 가르키는 주소번지의 내용물을 비교하므로 true
		//b.
		System.out.println(s.equals(new Integer(9)));
						//변수와 선언된 새객체의 내용물을 비교하므로 true
		//c.
		System.out.println(s.equals(9));
						//변수이름이 가르키는 주소번지의 내용물과 autoboxing으로 설정된 int타입의 9를 비교하므로 ture
		//d.
		System.out.println(s == t);
						//주소번지를 비교하는 ==의 경우 서로 다름 false
		//e.
//		System.out.println(s == u);
						//주소번지를 비교하는 ==의 경우, 서로 다른 타입을 비교할 수 없으므로 오류
	}
}
