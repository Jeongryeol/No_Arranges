package com.ch2;

import java.util.Scanner;

public class W02_B3_P74 {

	public static void main(String[] args) {
		//��������
/*			���� �߷��� ���� �߷��� 17%�� �Ұ��մϴ�.
			�������� �����԰� 100kg�� ����� �޿����� 17kg�ۿ� �ȵ˴ϴ�.
			����� �����Դ� �޿��� ���Դϱ�?
		
			��°��
			���������� : 100kg
			�� ������ : 17kg*/
		double grvMoon = 17;
		int manWeight = 100;
		int manMoonWeight = manWeight*(int)grvMoon/100;
		System.out.println("���������԰� "+manWeight+"kg�� �����");
		System.out.println("�޿����� �����Դ� "+manMoonWeight+"kg�� �ȴ�.");

		//������
		//Scanner Ŭ������ �̿��� ȭ�鿡�� ����ڷκ��� �� �Է¹ޱ� (p.40~41)
		System.out.println("����� �����Ը� �Է��ϼ���");
		//��ȣ�ȿ� System�� ������ ����ϴ� ��ǻ�Ϳ� �ش�
		//���� in�� �Է���ġ�κ��� ���� �о�� �� ����ϴ� ����
		Scanner answer = new Scanner(System.in);//Scanner�� �Է��ϰ��� �ڹ�API ����� �߰��ϱ� ���� ������(���콺����)
		//�ֿܼ��� �Է¹��� ���� ��� StingŸ������ String������ ����
		//����ڰ� �Է��� ���� ���� �� �о�ö�  nextLine�޼ҵ带 ����Ͽ�  ȣ��
		//�޼ҵ带 ������ �� {}�� ������
		//�޼ҵ带 ȣ���� �� �����ݷ�(;)���� ����.
		//�Է¹��� ������ input�� ����
		String input = answer.nextLine();
		//�����԰� �Ҽ����� �ִ� ��츦 �����Ͽ� double�� �����ϰ�
		//�ֿܼ��� �Է¹��� ���� ����ó�� �ϱ����� double�� ������.
		//parseDouble�޼ҵ�� staticŸ���� �޼ҵ� �̹Ƿ�
		//Double db = new Double()�� ��ü�� �ε����� �ʰ� �ٷ� ȣ���� �� ����.		
		double num = Double.parseDouble(input);//input�� ����� �Է¹��� ������ intŸ�� ������ ����
		System.out.println("������ ������ : "+num+"kg");
		//���� �����Ը� ���� ���� ����
		double m_weight = 0.0;
		m_weight = (num*17)/100;
		System.out.println("���� ������ : "+m_weight+"kg");
	}

}
