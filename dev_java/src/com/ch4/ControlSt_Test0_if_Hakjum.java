package com.ch4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlSt_Test0_if_Hakjum {

	public static void main(String[] args) {
		//����ڷκ��� ������ �Է¹޾ƿ� - ������ 0���� 100�Դϴ�.
		//���� ����ڰ� �Է��� ���� ��ȿ�� ������ üũ�غ�
		JFrame jf = new JFrame(); 
		String userJumsu = ""; 
		userJumsu = JOptionPane.showInputDialog("0���� 100���� ������ �Է��ϼ���.");
		//����ڷκ��� �Է¹޴� ���� StringŸ������ ��ȯ�Ǵϱ�, ���� Ÿ������ ���� �ٲ�� ��!
		int myJumsu = 0;
		myJumsu = Integer.parseInt(userJumsu,10);
		//String hakjum ='';
		char chakjum = 'F';
		if((myJumsu>=0)&&(myJumsu<=100)) {
			if(90<=myJumsu & myJumsu<=100) {//�ʰ� �Է��� ���� 0���� 100���̿� �ִ� ���̴�? - ��
				//�������� A��������, B��������, C��������, D�������� ��������
				chakjum = 'A';
			}
			else if (80<=myJumsu & myJumsu<90){
				chakjum = 'B';
			}
			else if (70<=myJumsu & myJumsu<80){
				chakjum = 'C';
			}
			else if (60<=myJumsu & myJumsu<70){
				chakjum = 'D';
			}
			else if (0<=myJumsu & myJumsu<60){
				chakjum = 'F';
			}
		}
		else {//�ʰ� �Է��� ���� 0���� 100���̿� ���� �ʱ���? - �� ä���Ҽ� ���µ�..  �ٽ� Ȯ���غ�
			System.out.println("INSERT VALUE ERROR, PLEASE CHECK AGAIN");
			JOptionPane.showMessageDialog(jf, "�Է��Ͻ� ���� 0���� 100�� ������ ����ϴ�.",
											"ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);//����
		}
		System.out.println("�Էµ� ������ "+chakjum+"�����Դϴ�.");//��ȭ�� ������� �ݺ��ϴ� ����� ������ ����.		
	}



}
