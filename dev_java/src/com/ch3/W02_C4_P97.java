package com.ch3;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

public class W02_C4_P97 {

	public static void main(String[] args) {
		int wheelNum = 4;
		int speed = 0;
		String carColor = "검정색";
		//내 자동차는 바퀴수가 4개이고, 색상은 검정색 이고, 현재 속도는 60km 주행중
		System.out.printf("내 자동차는 바퀴수가 %d이고, 색상은 %s, 현재속도는 %dkm 주행중",wheelNum,carColor,speed);//print folmat
		//사용자로부터 값을 입력 받아서 처리하고 싶을 땐
		JFrame jf = new JFrame();
		String yourWheelNum = 
				JOptionPane.showInputDialog(jf, "당신의 자동차 바퀴수는 얼마인지 적어보세요.");//부모창(jf)로 부터 자식창()
		System.out.println("\n==================================");
		System.out.printf("%s", yourWheelNum);
		wheelNum = Integer.parseInt(yourWheelNum);//입력받은 값을 int로 형변환
		System.out.printf("%n%d%n",  wheelNum);//%n : 줄바꿈
		System.out.printf("%n%5d%n",  wheelNum);//%d : d앞에 숫자를 붙인만큼 자리수를 생성
	}

}
