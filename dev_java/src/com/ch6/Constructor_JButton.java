package com.ch6;

import javax.swing.JButton;

public class Constructor_JButton {

	Constructor_JButton() {//생성자 선언
		initDisplay();//non-staitc인 자기자신의 매소드 호출 (this를 쓸 필요는 없음)
	}
	
	public void initDisplay() {//non-static 메소드 선언
		System.out.println("initDisplay호출 성공");//메소드 호출 성공시 볼 출력문 작성
	}
	
	public static void main(String[] args) {
		
		Constructor_JButton cj = new Constructor_JButton();//자기자신을 인스턴스화
		
		JButton jbtn_new = new JButton();//import된 API를 인스턴스화
		jbtn_new.setText("새게임");//생성자 호출
		
		JButton jbtn_exit = new JButton("종료");//단축

	}

}
