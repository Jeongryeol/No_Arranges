package com.ch3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class W02_C5_Exercise_JOptionPane {

	public static void main(String[] args) {
		/*
		 * 연습문제
		 * 사용자로부터 0부터 9까지의 숫자를 입력받아서 짝수인지 홀수인지를 판정하는 프로그램을 작성하시오.
		 * 1)%연산자를 사용할 수 있다.
		 * 2)사용자로부터 값을 입력받을때 showMessageInput 을 활용할 수 있다.
		 * 
		 */
		JFrame jf = new JFrame();
		String insertNum = JOptionPane.showInputDialog(jf,"0~9까지의 숫자를 입력해 주세요");
		int reNum = Integer.parseInt(insertNum);
		if(reNum>=0&reNum<10) {
			if(reNum%2 == 0 ) {
				System.out.printf("입력해주신 값 %d는 짝수입니다.", reNum);
							}
			else {
				System.out.printf("입력해주신 값 %d는 홀수입니다.", reNum);				
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"잘못입력하셨습니다.");//팝업은 변수선언이 필요없
		}// 다시 위로 돌아가고 싶어요.....
		
	}

}
