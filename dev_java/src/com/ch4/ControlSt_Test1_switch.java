package com.ch4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlSt_Test1_switch {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		String userJumsu = ""; 
		userJumsu = JOptionPane.showInputDialog("0���� 100���� ������ �Է��ϼ���.");
		int myJumsu = 0;
		myJumsu = Integer.parseInt(userJumsu,10);
		
		char chakjum = 'F';
		switch(myJumsu/10) {//switch�� ���ǽ��� ������� ���� �������� �Ǵ��Ѵ�.
			case 10: case 9:
				chakjum = 'A';
				break;//�ش������� �Ϸ��ϸ� switch ���ǹ��� �Ϸ��ϰ� �������� (������   �������)
			case 8:
				chakjum = 'B';
				break;
			case 7:
				chakjum = 'C';
				break;
			case 6:
				chakjum = 'D';
				break;
			case 5: case 4: case 3: case 2: case 1: case 0: //��������
				chakjum = 'D';
				break;
			default:
				System.out.println("INSERT VALUE ERROR, PLEASE CHECK AGAIN");
				JOptionPane.showMessageDialog(jf, "�Է��Ͻ� ���� 0���� 100�� ������ ����ϴ�.",
												"ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
		}
		System.out.println("�Էµ� ������ "+chakjum+"�����Դϴ�.");//��ȭ�� ������� �ݺ��ϴ� ����� ������ ����.
	}

}
