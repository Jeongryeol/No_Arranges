package com.ch8_exercise;

public class Test_03 {
	
	public static void main(String[] args) {
		try {
			return;
		} finally {
			System.out.println("Finally");
		}
		
		//return��
		// 1. �޼ҵ��� ������� ��ȯ�ϰ� �޼ҵ带 �������´�.
		// 2. ���ǹ�(if)���� ���Ǹ� ���ǹ��� ��� �������´�.
		
		//����, �� ����ó�� try���� �ȿ��� return�� ����Ǹ�,
		//try���� ������ finally�� �ݵ�� ����ǰ� return�� ��ٷ� ����ȴ�. 
	}
}

/*
	What is the result?
		A. Finally [����] 
		B. Compilation fails. [ �� ]
		C. The code runs with no output.
		D. An exception is thrown at runtime.
*/
