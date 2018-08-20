package com.ch8_exercise;

public class Test_06 {
	
	public static void main(String[] args) {
	
		try {
			badMethod();
			System.out.println("A");
		} catch (Exception ex) {
			System.out.println("B");
		} finally {
			System.out.println("C");
		}
		System.out.println("D");
	}

	public static void badMethod() {
		throw new RuntimeException();
	}
}

/*What is the result?
	A. AB
	B. BC
	C. ABC
	D. BCD [ ¡Ü ]
	E. Compilation fails.
*/

