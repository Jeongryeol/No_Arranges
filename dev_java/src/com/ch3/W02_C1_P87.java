package com.ch3;

public class W02_C1_P87 {

	public static void main(String[] args) {
		//������
		System.out.println(4<<2);//4=00000100 -> 16=00010000
		System.out.println(4>>2);//4=00000100 -> 1=00000001
		//������������(%)
		System.out.println(5%2);
		int x = 5;
		int y = 2;
		System.out.println(x%y);
		//�񱳿�����
		//�񱳿����� ����� boolean�̴� (true or false)
		//���� ���� �Ϸ� ������ 100������ ������ ���Թ� �ݰ� Ŭ������
		int account = 0;
		//��縦 �ߴ���, ������ 102������ ����ٸ�?
		account = 1020000; 
		if(account>1000000) {
			System.out.println("Ŭ������ ���");
		}
		else {
			System.out.println("�׳� ����ϱ�");
		}
		//������
		if(1!=2) {//1�� 2�� �޶�?
			System.out.println("�ٸ�");			
		}//if�� ��ȣ ���� ���ǽ��� ���̸� ����
		else {
			System.out.println("����");
		}//�����̸� ����
		//��������		
		double himHei = 0;
		int himCash = 0;
		himHei = 183.5;
		himCash = 315000000;
		boolean herAns = true;
		if(himHei>=180 & himCash>=300000000) {
			herAns=true;
			System.out.println("���� �Ұ��ÿ� �����ž�...");
		}
		else {
			herAns=false;
			System.out.println("�� �Ұ��� �Ȱ���...");
		}
		himHei = 170;
		himCash = 300;
		if(himHei>=180 | himCash>=300000000) {			
			herAns=true;
			System.out.println("���� �Ұ��ÿ� �����ž�...");
		}
		else {
			herAns=false;
			System.out.println("�� �Ұ��� �Ȱ���..");
		}
		
	}

}
