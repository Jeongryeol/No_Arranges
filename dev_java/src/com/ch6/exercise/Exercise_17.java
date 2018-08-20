package com.ch6.exercise;

/* 문자열인 원본을 함께 변경하면서 효율적으로 작업할때는,
 * StringBuffer, StringBuilder 클래스를 사용해야한다.
 * 그렇지 않으면 계속해서 쓰지않는 값이 쌓여감 */

public class Exercise_17 {

	public static void main(String[] args) {
		
		String s="Hello";
		s=s.toLowerCase() + " there";
		System.out.println(s + " my friend");
		
		//만약 아래와 같다면?
		s.toLowerCase();//String은 반드시 대입연산자를 사용해야만 원본문자열을 초기화할 수 있다.
		System.out.println(s + " my friend (만약의 경우)");//이 경우엔, toLowerCase메소드가 적용되지 않았음. 
		
	}

}
