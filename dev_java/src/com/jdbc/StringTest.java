package com.jdbc;

/****************************************************************
 * String대신 StringBuilder나 StringBuffer를 사용하는 이유??
 * String은 문자열을 저장하고 추가[+="추가문자열"]해서 갱신할 때 객체가 매번 생성되고,
 * 원본이 변하지 않아서 반드시 대입연산자에 새로 담아줘야함.
 * 
 * StringBuilder나 StringBuffer는  원본을 각 문자단위로 저장되고,
 * 추가[.append("추가문자열")]하여 원본이 변하므로, 호출하면 즉각 변화된것을 확인할 수 있다.
 * 
 * StringBuilder나 StringBuffer는 원본을 변화시켜서 메모리에 할당되는 값을 줄임
 * StringBuilder는 싱글스레드에서 | StringBuffer는 멀티스레드에서 적합하다.
 * 
 * Builder클래스와 Buffer클래스의 내부적인 저장 매커니즘은 확인할 것!!
 ***************************************************************/

public class StringTest {

	public void test() {
		String s = "Have";
		System.out.println(s);
		s+= " a";
		System.out.println(s);
		s+= " good";
		System.out.println(s);
		s+= " time!!";
		System.out.println(s);
		//
	}
	
	public static void main(String[] args) {
		//String은 원본이 바뀌지 않고 문자열을 덩어리로 저장한다.
		
		String s = "hello";
		s.replace('e','o');
		System.out.println(s);	//hello가 출력됨.. hollo여야 하지만...
		
		//반드시 대입연산자는 새로운 값을 담아야 함.
		s = s.replace('e','o');	//이러면 hollo가 출력됨.
		System.out.println(s);
		System.out.println("==============");
		
		StringTest st = new StringTest();
		st.test();
	}
}
