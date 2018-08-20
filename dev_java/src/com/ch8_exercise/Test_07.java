package com.ch8_exercise;

public class Test_07 {
	
	public static void main(String[] args) {
		try {
			badMethod();
			System.out.println("A");
		} catch (Exception ex) {
			System.out.println("B");
		} finally {
			System.out.print("C");
		}
		System.out.println("D");
	}

	public static void badMethod() {
		throw new Error();
	}
	//에러는 소프트웨어적인 문제로, 일단 발생하면 복구할 수 없는 심각한 오류임
	//예외는 코드상의 문제로, 발생하더라도 수습가능한 비교적 덜 심각한 상태임
}
/*
	What is the result?
		A. ABCD
		B. Compilation fails.
		C. C is printed before exiting with an error message.[ 정답  ]
		D. BC is printed before exiting with an error message. 
		E. BCD is printed before exiting with an error message. [ ● ]
*/