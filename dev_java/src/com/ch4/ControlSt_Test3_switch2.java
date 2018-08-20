package com.ch4;

import java.util.Random;

public class ControlSt_Test3_switch2 {
	/*
	 * ��������
	 * 1���� 100������ ���ڸ� ä���ؼ� 5�� ����̸� 5�� ����Դϴ� ��� ����ϰ�
	 * 7�� ���� �������� 0�̸� 7�� ��� �Դϴ�. ��� ����ϰ�
	 * 5�� ���� �������� 0�̰� 7�� ���� �������� 0�̸� 5�� 7�� ����� ��� ����ϴ�
	 * ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * ������ �߿��ϴ�
	 * ������ ���� ����� �޶��� �� �ִ�.
	 * 35�� ���� 5�� ���� �����ų� 7�� ���� ������ �������� �Ѿ�� �ùٸ��� ��������� ����
	 * ������� ������ ���� �������� ���� case�� �ۼ��ϸ� �ۼ��ؾ��ϴ� �ڵ差�� ���� ���ϵ� ������
	 * (switch���̵� if���̵� ª�� ������ ȿ�����̰�, �ߺ������ ���� �ʾƾ� ���ϰ� ����. 
	 * 
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int rnum = r.nextInt(100);
		rnum = rnum+1;//1���� 100���� ä���ϱ� ���� ó��
		System.out.println("ä���� ���ڴ� "+rnum);
		switch(rnum%35) {
			case 0:
				System.out.println(rnum+"�� 5�� 7�� ������Դϴ�.");
				break;
		
			case 5: case 10: case 15: case 20: case 25: case 30:  
				System.out.println(rnum+"�� 5�� ����Դϴ�.");
				break;
			case 7: case 14: case 21: case 28:  
				System.out.println(rnum+"�� 7�� ����Դϴ�.");
				break;
			default:
				System.out.println(rnum);
				break;
		}
	}
}

