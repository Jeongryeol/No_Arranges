package com.ch3;

public class W02_E2_Banana {
		private int x;
		private static int nth;
		W02_E2_Banana() { x = nth++; }
		W02_E2_Banana(int x) { this.x = x; } //ȣ���Ҷ� �ԷµǴ� ���� ���� ��쿡 �������� x�� ���Եǰ� ��
	public static void main(String[] args) {
		W02_E2_Banana b1 = new W02_E2_Banana();
		W02_E2_Banana b2 = new W02_E2_Banana();
		W02_E2_Banana b3 = new W02_E2_Banana(1);
		W02_E2_Banana b4 = b3;
	}
}

