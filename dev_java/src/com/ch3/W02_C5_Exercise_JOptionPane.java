package com.ch3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class W02_C5_Exercise_JOptionPane {

	public static void main(String[] args) {
		/*
		 * ��������
		 * ����ڷκ��� 0���� 9������ ���ڸ� �Է¹޾Ƽ� ¦������ Ȧ�������� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * 1)%�����ڸ� ����� �� �ִ�.
		 * 2)����ڷκ��� ���� �Է¹����� showMessageInput �� Ȱ���� �� �ִ�.
		 * 
		 */
		JFrame jf = new JFrame();
		String insertNum = JOptionPane.showInputDialog(jf,"0~9������ ���ڸ� �Է��� �ּ���");
		int reNum = Integer.parseInt(insertNum);
		if(reNum>=0&reNum<10) {
			if(reNum%2 == 0 ) {
				System.out.printf("�Է����ֽ� �� %d�� ¦���Դϴ�.", reNum);
							}
			else {
				System.out.printf("�Է����ֽ� �� %d�� Ȧ���Դϴ�.", reNum);				
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"�߸��Է��ϼ̽��ϴ�.");//�˾��� ���������� �ʿ��
		}// �ٽ� ���� ���ư��� �;��.....
		
	}

}
