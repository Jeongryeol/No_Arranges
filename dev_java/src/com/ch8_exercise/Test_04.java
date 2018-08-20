package com.ch8_exercise;

public class Test_04 {
		
	public static void main(String[] args) {
		
		try {
			int x = 0;
			int y = 5 / x;
		} catch (ArithmeticException ae) {
			System.out.println("Arithmetic Exception");
		} catch (Exception e) {
			System.out.println("Exception");
		}
		//catch에 들어온 Exception은 좁은 에러를 먼저 걸러준 뒤에
		//제일  마지막에 가장 큰 Exception으로 막아야한다.
		System.out.println("finished");
	}
	
	/*
		What is the result?
			A. finished
			B. Exception [ ● ]
			C. Compilation fails. [정답]
			D. Arithmetic Exception
	*/
}
