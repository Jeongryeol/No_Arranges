package com.ch3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class W02_D3_LoginAction_JOptionPane {

	public static void main(String[] args) {
		String db_id = "test";
		String db_pw = "123";
		String db_name = "�̼���";
		//����ڷκ��� id�� pw�� �Է¹޾Ƽ�
		//id�� pw�� ��� ��ġ�ϸ� �̼��Ŵ� ȯ���մϴ�. ��� ����ϰ�
		//id�� �������� ������ ���̵� �������� �ʽ��ϴ�. ��� ����ϰ�
		//id�� ���������� pw�� ���� ������ ��й�ȣ�� Ʋ�Ƚ��ϴ�. ��� ����غ���.
		
		//����ڷκ��� ���ޱ�. (���� ���)
		String user_id = JOptionPane.showInputDialog("���̵� �Է��ϼ���.");
		String user_pw = JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���.");
		JFrame jf = new JFrame();
		if (db_id.equals(user_id)) {//db���� ������ ���̵�� ����ڰ� �Է��� ���̵� ����?
			if (db_pw.equals(user_pw)) {//db���� ������ ����� ����ڰ� �Է��� ����� ����?
				JOptionPane.showMessageDialog(jf,db_name+"�� ȯ���մϴ�.","HELLO"
													,JOptionPane.INFORMATION_MESSAGE);				
			}
			else {//�޶��
				JOptionPane.showMessageDialog(jf, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.","ERROR"
													,JOptionPane.WARNING_MESSAGE);			
			}
		}
		else {//���̵� �������� ����
			JOptionPane.showMessageDialog(jf, "�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.","ERROR"
													,JOptionPane.WARNING_MESSAGE);
		}
		
		//Ŭ������ ���
		/*JFrame logIn = new JFrame();
		String user_id = JOptionPane.showInputDialog(logIn,"���̵� �Է��ϼ���.");
		String user_pw = JOptionPane.showInputDialog(logIn,"��й�ȣ�� �Է��ϼ���.");
		Boolean id_check = (db_id == user_id);
		Boolean pw_check = (db_pw == user_pw);
		if (id_check){
			if (pw_check) {
				JOptionPane.showMessageDialog(logIn, "�̼��Ŵ� ȯ���մϴ�.");
			}
			else {
				JOptionPane.showMessageDialog(logIn, "�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");				
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");				
		}*/
	}

}
