package com.ch8_exercise;

/* ����� return�� ���� ������ �� ��.......
 * if������ return�� ����ϸ� �� ��(�� �ش� �޼ҵ�)�� Ż���Ѵ�.
 * return ���Ŀ� ������� ������� �ʴ´�.
 * �޼ҵ� �ȿ� return�� ����ϸ� ���� ��ȯ�Ѵ�.
 */

public class Test_01_Return {

	public static void foo(int x) {
		if(x==5) {
			return;
		}else{
			System.out.println("else");
		}
		System.out.println("����");
	}
	
	public static void main(String[] args) {
		//�Ķ���Ϳ� 5�� ������ �ƹ��͵� ��µ��� ����
		//foo(5);
		foo(3);
	}
	
}
