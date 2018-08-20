package com.ch8;

import javax.swing.JOptionPane;

public class ThrowsExam {

	String userInput;
	int changeInt;
	
	public ThrowsExam() {
		doRun();
	}
	
	public void haveThrows() throws NumberFormatException {
		userInput = JOptionPane.showInputDialog("0���� 9���� ���ڸ� �Է����ּ���");
		changeInt = Integer.parseInt(userInput);
		
		if(changeInt>=0 && changeInt<=9) {
			System.out.println("�Է����ֽ� ���� "+changeInt+" �Դϴ�.");
		}else {
			JOptionPane.showMessageDialog(null,	"0���� 9������ ���ڸ� �Է°����մϴ�.", "ERROR�߻�", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void doRun() {
		try {
			haveThrows();
		}catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());	/* ��°��1 : For input string: "aa" */
			System.out.println(nfe.toString());		/* ��°��2 : java.lang.NumberFormatException: For input string: "aa" */
			nfe.printStackTrace();
													/* ��°��3 ( �Ʒ�����)
													 * java.lang.NumberFormatException: For input string: "aa"
													 * at java.lang.NumberFormatException.forInputString(Unknown Source)
													 * at java.lang.Integer.parseInt(Unknown Source)
													 * at java.lang.Integer.parseInt(Unknown Source)
													 * at com.ch8.ThrowsExam.haveThrows(ThrowsExam.java:16)
													 * at com.ch8.ThrowsExam.doRun(ThrowsExam.java:27)
													 * at com.ch8.ThrowsExam.<init>(ThrowsExam.java:11)
													 * at com.ch8.ThrowsExam.main(ThrowsExam.java:36) */
		}catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		new ThrowsExam();
	}
	
}
