package com.ch7_abst_intrf2;

public class Gift_Simulation {
	//�����
	//The_Gift gift = null;
	//������
	public Gift_Simulation() {

		The_Gift gift = new GiftForGirlfriend();
		//gift = new GiftForGirlfriend();
		gift.boxEdge = 4;
		gift.setSizeW(50);
		gift.setSizeD(75);
		gift.setSizeH(45);
		System.out.printf("�̹� ���������� ũ��� �ʺ� %.1f, ���� %.1f, ���� %.1f�� %d���ڽ� �Դϴ�.%n"
				,gift.getSizeW(),gift.getSizeD(),gift.getSizeH(),gift.boxEdge);
		System.out.println("��������������������������������������������������������������������������������������������������������������");
		gift.include(4);
		//gift.wrapPattern(pPattern);
		gift.wrapPattern("��");
		((Heart) gift).give();
		System.out.println("�׸��� ����!");
		((Thanks) gift).take();
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		Gift_Simulation gs = new Gift_Simulation();
	}
}
