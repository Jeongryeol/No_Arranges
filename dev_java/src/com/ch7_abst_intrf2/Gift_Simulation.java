package com.ch7_abst_intrf2;

public class Gift_Simulation {
	//선언부
	//The_Gift gift = null;
	//생성자
	public Gift_Simulation() {

		The_Gift gift = new GiftForGirlfriend();
		//gift = new GiftForGirlfriend();
		gift.boxEdge = 4;
		gift.setSizeW(50);
		gift.setSizeD(75);
		gift.setSizeH(45);
		System.out.printf("이번 선물상자의 크기는 너비 %.1f, 깊이 %.1f, 높이 %.1f의 %d각박스 입니다.%n"
				,gift.getSizeW(),gift.getSizeD(),gift.getSizeH(),gift.boxEdge);
		System.out.println("───────────────────────────────────────────────────────");
		gift.include(4);
		//gift.wrapPattern(pPattern);
		gift.wrapPattern("별");
		((Heart) gift).give();
		System.out.println("그리고 이제!");
		((Thanks) gift).take();
	}
	//메인메소드
	public static void main(String[] args) {
		Gift_Simulation gs = new Gift_Simulation();
	}
}
