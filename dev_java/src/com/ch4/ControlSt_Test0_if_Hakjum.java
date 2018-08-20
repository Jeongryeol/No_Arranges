package com.ch4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlSt_Test0_if_Hakjum {

	public static void main(String[] args) {
		//사용자로부터 점수를 입력받아요 - 범위는 0부터 100입니다.
		//먼저 사용자가 입력한 값이 유효한 값인지 체크해봐
		JFrame jf = new JFrame(); 
		String userJumsu = ""; 
		userJumsu = JOptionPane.showInputDialog("0부터 100까지 점수를 입력하세요.");
		//사용자로부터 입력받는 값이 String타입으로 반환되니까, 정수 타입으로 먼저 바꿔야 해!
		int myJumsu = 0;
		myJumsu = Integer.parseInt(userJumsu,10);
		//String hakjum ='';
		char chakjum = 'F';
		if((myJumsu>=0)&&(myJumsu<=100)) {
			if(90<=myJumsu & myJumsu<=100) {//너가 입력한 값이 0부터 100사이에 있는 값이니? - 네
				//이제부터 A학점인지, B학점인지, C학점인지, D학점인지 따져봐요
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
		else {//너가 입력한 값은 0부터 100사이에 있지 않구나? - 넌 채점할수 없는데..  다시 확인해봐
			System.out.println("INSERT VALUE ERROR, PLEASE CHECK AGAIN");
			JOptionPane.showMessageDialog(jf, "입력하신 값은 0부터 100의 범위를 벗어납니다.",
											"ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);//종료
		}
		System.out.println("입력된 점수는 "+chakjum+"학점입니다.");//변화와 관계없이 반복하는 대상은 밖으로 뺀다.		
	}



}
