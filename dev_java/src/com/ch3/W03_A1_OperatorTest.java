package com.ch3;

public class W03_A1_OperatorTest {

	public static void main(String[] args) {
		int i = 1;
		int j = i++;
		if((i==++j)|i==j) {
			i+=j;//i=i+j
		}
		//insert here - Ãâ·Â
		System.out.println("i="+i);
	}

}
