package com.ch7;
/*
 * Ŭ���� �տ� final�� �� �� �ִ�. (static�� �ȵ�)
 * �ǹ� : �ڼ�Ŭ������ ���� �� ����. 
 * ��������?
 * ��ǰ�� ���� ����(����)�� �����ϱ� ���� --������ ����� ���� ���ڴ�.--
 */
//public final class Modifier_02_final_Duck {//�ڽ�Ŭ������ �����߻���
public class Modifier_02_final_Duck {

	int leg = 2;
	int eye = 2;
	final int wings = 2;//final�� ���̸� ���ȭ. ����Ұ�!!!
	
	public void flying() {
		leg = 6;
		//wings = 9;//final�� �� ����� ����Ұ�!!
	}
	public void display() {
		
	}
	public final void swimming() {//final�� ���̸� �����ǺҰ�!!! override�Ұ�
		
	}
}
