package com.ch3;

public class W02_D2_Excercise_Test2 {

	public static void main(String[] args) {
		String s1 = new String("true");
		Boolean b1 = new Boolean(true);
		System.out.println("s1:"+s1+", b1:"+b1);
		if(b1) {
			System.out.println("b1은 boolean 이므로 true 가 성립된");
		}
		else {//만일 b1이 false이면 아래가 실행됨.
			System.out.println("b1은 booelan 이므로 true 가 맞으니까 이건 실행안되지....");
						
		}
/*		if(s1) {
			System.out.println("s1은 String 즉 문자열 이니까 true가 문자열임, 그러니까 if문 안에는 못써");
		}
		else {//만일 s1은 true 혹은 false 값이 아니므로 비교못함.
			System.out.println("s1은 문자열이므로 if문에서는 문법에러.....");			
		}
		*/
	}

}
