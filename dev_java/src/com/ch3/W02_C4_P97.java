package com.ch3;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

public class W02_C4_P97 {

	public static void main(String[] args) {
		int wheelNum = 4;
		int speed = 0;
		String carColor = "������";
		//�� �ڵ����� �������� 4���̰�, ������ ������ �̰�, ���� �ӵ��� 60km ������
		System.out.printf("�� �ڵ����� �������� %d�̰�, ������ %s, ����ӵ��� %dkm ������",wheelNum,carColor,speed);//print folmat
		//����ڷκ��� ���� �Է� �޾Ƽ� ó���ϰ� ���� ��
		JFrame jf = new JFrame();
		String yourWheelNum = 
				JOptionPane.showInputDialog(jf, "����� �ڵ��� �������� ������ �������.");//�θ�â(jf)�� ���� �ڽ�â()
		System.out.println("\n==================================");
		System.out.printf("%s", yourWheelNum);
		wheelNum = Integer.parseInt(yourWheelNum);//�Է¹��� ���� int�� ����ȯ
		System.out.printf("%n%d%n",  wheelNum);//%n : �ٹٲ�
		System.out.printf("%n%5d%n",  wheelNum);//%d : d�տ� ���ڸ� ���θ�ŭ �ڸ����� ����
	}

}
