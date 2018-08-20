package com.ch8;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ThrowExam {

	public void test() {
		System.out.println("0부터 9사이의 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();

		try {
			if(val.length()>1) {
				//new Exception("예외메시지")
				throw new Exception("한자리만 입력하세요.");
			}
			if(val==null || val.equals("")) {
				throw new NumberFormatException();
			}
			System.out.println((int)val.charAt(0));
			if(!((int)val.charAt(0)>=48 && (int)val.charAt(0)<=57)) {
				throw new Exception("넌 0부터 9사이의 숫자가 아닌걸.....");
			}//아스키코드로 비교한 숫자범위 체크 ( 오후 수업인 ajax에서 응용가능한 부문 )
			
		}catch (NumberFormatException ne) {
			JOptionPane.showMessageDialog(null, "숫자를 입력하세요", "ERROR",JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		ThrowExam te = new ThrowExam();
		te.test();
	}
	
}
