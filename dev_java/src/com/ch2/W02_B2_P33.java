package com.ch2;

public class W02_B2_P33 {

	public static void main(String[] args) {
		int i = 3;
		double d = 5.0;
		//i = d; �����Ͽ��� �߻�. �� ūŸ���� �� ���� Ÿ�Կ� ���� �� ����.
		d=i;
		System.out.println(d);//3�� ��µ� ��? no 3.0�� ��µ�!!!! (doubleŸ��)
		int jimsu1 = 85;
		int jimsu2 = 70;
		int jimsu3 = 90;
		//�� 3���� ������ ����� ���ؼ� ���� ������ �����Ͻÿ�.
		int total = jimsu1+jimsu2+jimsu3;
		System.out.println("������ "+total);
		//����� ���ؼ� ���� ������ ������ϼ���
		double avrg = 0.0d; 
		avrg = total/3;
		System.out.println("����� "+avrg);//��� ����� int ( total�� int, �����°��� int : ������� �ָ��� )
		avrg = total/3.0;
		System.out.println("����� "+avrg);//��� ����� double ( total�� int, ������ ���� double : ������� double�� ��Ȯ��)
		avrg = total/(double)3;
		System.out.println("����� "+avrg);//��� ����� double ( ����ȯ�� ���� int�� double�� ��ȯ�Ͽ� ��� : ������� double�� ��Ȯ )
		

	}

}
