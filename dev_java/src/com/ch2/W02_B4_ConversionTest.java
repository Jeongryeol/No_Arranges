package com.ch2;

public class W02_B4_ConversionTest {

	public static void main(String[] args) {
		//int i = (int)"hello";//����������
		int j = (int)3.14;
		//boolean isFlag = (boolean)"�ȳ�";//����������
		//boolean isFlag2 = (boolean)"false";//����������	
		
		boolean isFlag4 = Boolean.parseBoolean("false");//static�϶� ���� �ҷ��ͼ� �Ҽ�����
		
		Boolean bool = new Boolean(false);//Ȥ�� ���� Ÿ���� ��ü�� ���������� �θ��� ���� ����ȭ�Ͽ�
		boolean isFlag3 = bool.parseBoolean("false");//����ȭ�� Ŭ������  �ҷ��ͼ� ����� �� ����
		
		System.out.println(bool);
		
		W02_B3_P74 hi = new W02_B3_P74();//(^��^)
				
	}

}