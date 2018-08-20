package com.ch7;

import javax.swing.JFrame;

public class Inher_02_JFrameTest extends JFrame{
	//선언부
	
	//생성자
	public Inher_02_JFrameTest() {
		initDisplay();
	}

	//사용자정의메소드
	//화면처리부
	public void initDisplay() {
		//this :Inheritance_JFrameTest(자기자신) 지칭  | this() : 디펄트생성자호출
		//super : JFrame | super() : JFrame() : 디펄트생성자 호출
		this.setSize(500,300);
		this.setVisible(true);
	}
		
	public static void main(String[] args) {
		Inher_02_JFrameTest jft = new Inher_02_JFrameTest();//디폴트생성자 호출 

	}

}
