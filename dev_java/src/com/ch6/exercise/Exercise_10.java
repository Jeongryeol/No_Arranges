package com.ch6.exercise;

public class Exercise_10 {

	public static void main(String[] args) {
		
		float f = 4.2f;
		Float g = new Float(4.2f);
		Double d = new Double(4.2);
		
		System.out.println("g : "+g);
						//autoboxing������� floatŸ������ �ڵ�����ȯ ��.
		
		
		/*
		 * ==�� �񱳿����ڷ� �ּҰ��� ���Ѵ�.
		 * equals()�޼ҵ�� ������ ���Ѵ�.
		 */
		
		
		System.out.println(f==g);
						//true	: floatŸ���� ���� �ּҹ����� ����ִ� floatŸ���� ���� ���� true
		System.out.println(d==f);
						//false	: floatŸ���� ���� �ּҹ����� ����ִ� doubleŸ���� ���� ���� false
		System.out.println(g==g);
						//true	: Ÿ���� ���� ���� �ּҰ��̹Ƿ� true (�ڱ��ڽŰ� ��)
		System.out.println(d.equals(f));
						//false : doubleŸ�� 4.2d�� floatŸ�� 4.2f ���̹Ƿ� false
		System.out.println(d.equals(g));
						//false : doubleŸ�� 4.2d�� floatŸ�� 4.2f ���̹Ƿ� false
		System.out.println(g.equals(4.2));
						//false	: floatŸ�� 4.2�� (�Ǽ����� defalut Ÿ����) doubleŸ�� 4.2 ���̹Ƿ� false
			
	}

}
