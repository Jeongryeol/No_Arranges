package com.ch3;

public class W02_E2_Banana {
		private int x;
		private static int nth;
		W02_E2_Banana() { x = nth++; }
		W02_E2_Banana(int x) { this.x = x; } //호출할때 입력되는 값이 있을 경우에 생성자의 x에 대입되게 됨
	public static void main(String[] args) {
		W02_E2_Banana b1 = new W02_E2_Banana();
		W02_E2_Banana b2 = new W02_E2_Banana();
		W02_E2_Banana b3 = new W02_E2_Banana(1);
		W02_E2_Banana b4 = b3;
	}
}

