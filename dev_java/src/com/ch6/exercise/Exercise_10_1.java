package com.ch6.exercise;

public class Exercise_10_1 {

	public static void main(String[] args) {
		
		int i = 5;
		Integer ig = new Integer(5);
		String s = new String("5");
		String u_id = "test";
	
		if(i==5) {
			System.out.println("����");
		}

//		if(i==s) { ������ Ÿ�԰� Ŭ���� Ÿ���� ���� �񱳺Ұ���.
		if(i==ig) {
			
		}
		if(u_id.equals("test")) {//equals �� �ּҹ����� ����Ű�� ���� ��Ÿ��
			System.out.println("���̵� ��ġ�ؿ�");
		}
	
	}
}
