package com.base;

public class W01_C1_VariableTest {
	//�����(������ �޼ҵ带 ������ �� �־��)
	//tot������ �Ķ���, methodA�� �Ķ���
	//�׷��ϱ� methodA������ tot ���� ��� ����
	static int tot = 0;//CYAN
	static double avg = 0.0;//������ �޼ҵ�
	void methodA() {//�Ķ��� �޼ҵ�
		System.out.println(tot);
		//������ �Ķ������� ��밡����.
		System.out.println(W01_C1_VariableTest.avg);		
	}
	//�Ķ�����  ������������ ��� �Ұ��ϹǷ� 16�� ���� ������
	static void methodB() {//������ �޼ҵ�
		System.out.println(tot);
		}
	static void methodC() {//������ �޼ҵ�
		//���� �����̶� avg���� ��� ������
	}
	public static void main(String args[]) {
	
	}
}
