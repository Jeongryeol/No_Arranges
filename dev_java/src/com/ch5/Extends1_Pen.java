package com.ch5;
//��� �ֻ���Ŭ����(superclass) object�� ���(extends)�Ǿ� ����
public class Extends1_Pen extends Object{
	
	int noX;//���������� �ʱ�ȭ���� �ʾƵ� ��
	
	public static void main(String[] args) {
		int x=0;//���������� �ݵ�� �ʱ�ȭ�� �ؾ���
		x = 10;
		Extends2_Audio au[] = new Extends2_Audio[3];
//		au[0] = x;
		/*	�Ұ��� ���� 1 : Ÿ���� �ٸ��� ����!!
				����ϴ°�ü�� ������Ÿ�� - ��ӵǴ°�ü�� ������ Ÿ��
			�Ұ��� ���� 2 : ���� �ٸ��� ����!!
				����ϴ°�ü�� Ŭ������ - ��ӵǴ°�ü�� ������Ÿ�� */ 
		Object obj[] = new Object[3];
		obj[0] = x;
		//������ ���� : ����Ŭ���� �����Ǳ� ����!!
		//�ֻ��� Ŭ���� Object���� ����Ŭ����(wrapper class)�� IntegerŬ������ �����Ǳ� ������ ����
		System.out.println(obj[0]);

	}

}
