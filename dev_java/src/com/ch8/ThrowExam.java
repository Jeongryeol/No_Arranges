package com.ch8;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ThrowExam {

	public void test() {
		System.out.println("0���� 9������ ���ڸ� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();

		try {
			if(val.length()>1) {
				//new Exception("���ܸ޽���")
				throw new Exception("���ڸ��� �Է��ϼ���.");
			}
			if(val==null || val.equals("")) {
				throw new NumberFormatException();
			}
			System.out.println((int)val.charAt(0));
			if(!((int)val.charAt(0)>=48 && (int)val.charAt(0)<=57)) {
				throw new Exception("�� 0���� 9������ ���ڰ� �ƴѰ�.....");
			}//�ƽ�Ű�ڵ�� ���� ���ڹ��� üũ ( ���� ������ ajax���� ���밡���� �ι� )
			
		}catch (NumberFormatException ne) {
			JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���", "ERROR",JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		ThrowExam te = new ThrowExam();
		te.test();
	}
	
}
