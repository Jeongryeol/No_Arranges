package com.ch3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class W02_C6_Excercise_2 {

	public static void main(String[] args) {
		/*
		 * ��������
		 * ����ڷκ��� ���̵�� ����� �Է¹޾Ƽ� ���̵�� ����� ��ġ�ϸ� �̼��Ŵ� ȯ���մϴ� ��� ����ϰ�
		 * ���̵� �������� ������ ���̵� �������� �ʽ��ϴ�.��� ����ϰ�
		 * ���̵�� �´µ� ����� Ʋ���� ����� �߸� �Է� �Ͽ����ϴ�. ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ� 
		 */
		JFrame winLog = new JFrame();
		String userId = JOptionPane.showInputDialog(winLog,"����� ���̵� �Է����ּ���");
		int chanUserId = Integer.parseInt(userId);
		if(chanUserId == 15450428) {
			String userPw = JOptionPane.showInputDialog(winLog,"����� ��й�ȣ�� �Է����ּ���");
			int chanUserPw = Integer.parseInt(userPw);
			if(chanUserPw == 2102103) {
			JOptionPane.showMessageDialog(null,"�̼��Ŵ� ȯ���մϴ�.");
			}
			else {
			JOptionPane.showMessageDialog(null,"��й�ȣ�� �߸� �Է��Ͽ����ϴ�.");	
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"���̵� Ȯ���� �ֽʽÿ�.");				
		}
		
		
	}

}
