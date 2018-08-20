package com.finalTest;

public class Test_05 {

	public static void main(String[] args) {
		int i = 1;
		int j = 10;
		do {
			if( i > j) continue;
			j--;
		}while(++i<6);
		System.out.println("i : "+i+", j :"+j);
	}
}
