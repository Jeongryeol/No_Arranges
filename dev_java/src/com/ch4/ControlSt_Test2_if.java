package com.ch4;

import java.util.Random;

public class ControlSt_Test2_if {
/*
 * ��������
 * 1���� 100������ ���ڸ� ä���ؼ� 5�� ����̸� 5�� ����Դϴ� ��� ����ϰ�
 * 7�� ���� �������� 0�̸� 7�� ��� �Դϴ�. ��� ����ϰ�
 * 5�� ���� �������� 0�̰� 7�� ���� �������� 0�̸� 5�� 7�� ����� ��� ����ϴ�
 * ���α׷��� �ۼ��Ͻÿ�.
 * 
 */
	public static void main(String[] args) {
		Random r = new Random();//ä�� : ��ǻ�Ͱ� �ƹ����ڸ� ä���ϰ� ��
		int ranNum= r.nextInt(101);
		String result = "���";
		System.out.printf("ä���� ���ڴ� %d�Դϴ�.%n",ranNum);
		if((ranNum%7==0)||(ranNum%5==0)) {
			if((ranNum%7==0)&&(ranNum%5==0)) {
				result = "5�� 7�� �����";
				System.out.printf("ä���� ���� %d��(��) %c�Դϴ�.",ranNum,result);
			}
			else if((ranNum%7!=0)&&(ranNum%5==0)) {
				result = "7�� ���";
				System.out.printf("ä���� ���� %d��(��) %c�Դϴ�.",ranNum,result);
			}
		}
		else {
			System.out.printf("�� ���ڴ� 5�� 7�� ����� �ƴմϴ�.",ranNum);
		}
	}

}
