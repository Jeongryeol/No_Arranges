package com.ch4;

import java.util.Random;

public class ControlSt_Test3_switch {
	/*
	 * ��������
	 * 1���� 100������ ���ڸ� ä���ؼ� 5�� ����̸� 5�� ����Դϴ� ��� ����ϰ�
	 * 7�� ���� �������� 0�̸� 7�� ��� �Դϴ�. ��� ����ϰ�
	 * 5�� ���� �������� 0�̰� 7�� ���� �������� 0�̸� 5�� 7�� ����� ��� ����ϴ�
	 * ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int insNum = r.nextInt(101);
		System.out.println("ä���� ����:"+insNum);
		int calNum = insNum%7;
		switch (calNum) {//switch���� �ι��̻� ���ľ��¹���� �ȵǴ� ���� �ƴ�����, ����� �� �������Ƿ� ���ϰ� ����
			case 0:
				calNum=insNum%5;
				switch (calNum) {
					case 0:
					System.out.printf("%d�� 5�� 7�� ������Դϴ�.",insNum);
					break;
					default:
					System.out.printf("%d�� 7�� ����Դϴ�.",insNum);
					break;
				}break;
			default:
				calNum=insNum%5;
				switch (calNum) {
					case 0:
					System.out.printf("%d�� 5�� ����Դϴ�.",insNum);
					break;
					default:
					System.out.printf("%d�� 5�� 7 ��� �ʵ� ����� ���� �ʽ��ϴ�.",insNum);
					break;
			}break;
		}//end of switch	
	}//////end of main
}//////////end of class
