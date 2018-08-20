package com.ch4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlSt_Test1_switch {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		String userJumsu = ""; 
		userJumsu = JOptionPane.showInputDialog("0부터 100까지 점수를 입력하세요.");
		int myJumsu = 0;
		myJumsu = Integer.parseInt(userJumsu,10);
		
		char chakjum = 'F';
		switch(myJumsu/10) {//switch는 조건식의 결과값에 대한 내용으로 판단한다.
			case 10: case 9:
				chakjum = 'A';
				break;//해당조건을 완료하면 switch 조건문을 완료하고 빠져나옴 (없으면   계속진행)
			case 8:
				chakjum = 'B';
				break;
			case 7:
				chakjum = 'C';
				break;
			case 6:
				chakjum = 'D';
				break;
			case 5: case 4: case 3: case 2: case 1: case 0: //다중조건
				chakjum = 'D';
				break;
			default:
				System.out.println("INSERT VALUE ERROR, PLEASE CHECK AGAIN");
				JOptionPane.showMessageDialog(jf, "입력하신 값은 0부터 100의 범위를 벗어납니다.",
												"ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
		}
		System.out.println("입력된 점수는 "+chakjum+"학점입니다.");//변화와 관계없이 반복하는 대상은 밖으로 뺀다.
	}

}
