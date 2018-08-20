package com.ch7_class;

public class InnerTest {

	public static void main(String[] args) {
		Outter outt = new Outter();
		outt.go();
		Outter.Inner inn = outt.new Inner();
		//Outter.Inner inn2 = new outt.Inner();//구문오류 발생
		inn.come();
	}

}
