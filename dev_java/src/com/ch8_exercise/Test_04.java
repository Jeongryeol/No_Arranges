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
		//catch�� ���� Exception�� ���� ������ ���� �ɷ��� �ڿ�
		//����  �������� ���� ū Exception���� ���ƾ��Ѵ�.
		System.out.println("finished");
	}
	
	/*
		What is the result?
			A. finished
			B. Exception [ �� ]
			C. Compilation fails. [����]
			D. Arithmetic Exception
	*/
}
