package com.ch4;

public class ControlSt_Test5_break {

	public static void main(String[] args) {
		int i;
		for(i=0;i<10;i++) {
			System.out.println(i);
/*			if(i==5) {
				break;//���� ����� �ݺ����� ���
				//i=5�� �Ǹ� break�� �ߵ��Ǿ� for���� ���
			}*/
		}//(break�� ���� ����� �ݺ���)
		System.out.println("����-for�� ��");
		//�ݺ�������
		//���ѷ��� �����ڵ带 �� �߰��սô�. -break�� ����ϱ�
		//while(i>5) {
		System.out.println(i);
		while(i<5) {//�̽������� i�� �󸶴�?
			System.out.println("while�� ���̿�!!");
			break;
		}
		System.out.println("����-while�� ��");
	}

}
