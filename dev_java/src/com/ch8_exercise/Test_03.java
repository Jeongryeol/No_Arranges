package com.ch8_exercise;

public class Test_03 {
	
	public static void main(String[] args) {
		try {
			return;
		} finally {
			System.out.println("Finally");
		}
		
		//return은
		// 1. 메소드의 결과값을 반환하고 메소드를 빠져나온다.
		// 2. 조건문(if)에서 사용되면 조건문을 즉시 빠져나온다.
		
		//만약, 위 구문처럼 try구문 안에서 return이 실행되면,
		//try구문 이후의 finally는 반드시 실행되고 return이 곧바로 실행된다. 
	}
}

/*
	What is the result?
		A. Finally [정답] 
		B. Compilation fails. [ ● ]
		C. The code runs with no output.
		D. An exception is thrown at runtime.
*/
