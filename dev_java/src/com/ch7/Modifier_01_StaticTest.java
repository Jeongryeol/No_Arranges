package com.ch7;

class Test1 {}//�޼ҵ� �տ��� static�� �� �� ����. 

public class Modifier_01_StaticTest {

	//static�� ���� ���ƾ���. 2�������� ����Ҷ� ������ ã�ƺ�����.
	//static �޼ҵ��, ������
	static int i = 10;//����, �Ѱ�(����), �켱���� ����. 
	
	static {//static �� (���� ������ ����)
		System.out.println("static ���� �����ϲ�?");
	}
	
	//main - main thread(�켱������ ����-����/�ð�����/����) - entry point
	public static void main(String[] args) {
		System.out.println("static main �޼ҵ尡 �����ϰž�");
	}

}
