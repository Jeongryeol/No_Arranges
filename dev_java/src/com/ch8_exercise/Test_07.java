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
	//������ ����Ʈ�������� ������, �ϴ� �߻��ϸ� ������ �� ���� �ɰ��� ������
	//���ܴ� �ڵ���� ������, �߻��ϴ��� ���������� ���� �� �ɰ��� ������
}
/*
	What is the result?
		A. ABCD
		B. Compilation fails.
		C. C is printed before exiting with an error message.[ ����  ]
		D. BC is printed before exiting with an error message. 
		E. BCD is printed before exiting with an error message. [ �� ]
*/