package com.base;

public class W01_B2_CircleArea {
/*
 * ��������
 * ���� ������ ���ϴ� ������ ���̹����� ã�ƺ��� ���� ������ ����� �ִ� ���α׷��� �ۼ��� ���ÿ�.
 * Ŭ���� �̸� CircleArea.java
 * ������ ���� �̸� : r
 * ��°��
 * ���� ������ XXX �Դϴ�.
 * 
 */
	public static void main(String[] args) {//args�����̸�, []�迭
		//int Radius = 20;
		//int CArea = 1256;
		//String r = "������";
		
		//System.out.println(r+" = "+Radius);
		//System.out.println("���Ǹ��� = "+"��"+r+"��");
		//System.out.println("�׷��Ƿ� "+r+"�� "+Radius+"�� ���� ������ "+CArea+"�̴�.");
		
		//�Ǽ��� ��� ����? - Ÿ���̸��� ����?
		//int pi = 3.14;// ����������? �Ǽ��� �Է� ������ Ÿ�� int
		
		//�Ǽ� ���� ���ڸ� �����ϴ� Ÿ���� double
		//����� ������ �� Ÿ�� �տ� final�� �ٿ��� ������ (double final)
		final double PI = 3.14;
		
		//������ ���ǵ� �̸��� ���� ������ �� �� ���� (int)
		//����� ���ǵ� �̸��� ���� ������ �� �� ���� (final double)
		int speed = 0;
		speed = 50;

		//double TO = 20;
		//System.out.println(TO);

		//double �� int�� ���̴� �Ҽ���  ǥ�������� ���� ��
		
		int r = 5;
		//int+int = int
		//double+int=double
		//double/int=double
		//double*int=double
		double carea = r*r*PI;
		System.out.println("���� ������ "+carea+" �Դϴ�.");
		
		
	}

}
