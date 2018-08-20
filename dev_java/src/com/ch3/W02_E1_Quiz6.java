package com.ch3;

public class W02_E1_Quiz6 {

	public static void main(String[] args) {
		W02_E2_Banana b1 = new W02_E2_Banana();
		W02_E2_Banana b2 = new W02_E2_Banana();
		W02_E2_Banana b3 = new W02_E2_Banana(1);
		W02_E2_Banana b4 = b3;
		//W02_E2_Banana b4 = new W02_E2_Banana();//이것과 위의 문장은 서로 다른 객체를 보고있음 
		//W02_E2_Banana b4 = new W02_E2_Banana(1);//상동
		
		b4 =new W02_E2_Banana();//새롭게 정의할 수 있다. 
		
		System.out.println("b1:"+b1);
		System.out.println("b2:"+b2);
		System.out.println("b3:"+b4);
		System.out.println("b4:"+b3);
		
	}
}


