package com.ch7;

public class subTest extends test {

	public subTest() {
		System.out.println("subTest�� ����Ʈ�����ڰ� ȣ��Ǿ����ϴ�.");
	}
	
	public subTest(subTest sb) {
		if(sb instanceof test) {
			System.out.println("True :: suTest�� sb�� testŬ������ instance��, ����ȯ�� �����մϴ�.");
		} else {
			System.out.println("False :: suTest�� sb�� testŬ������ instance�� �� �˴ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		test t = new subTest();
		t.toString();
		subTest sb = new subTest();
		t = new subTest(sb);
		
	}
}
