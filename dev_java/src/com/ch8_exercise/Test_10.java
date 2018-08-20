package com.ch8_exercise;

class ExcO extends Exception {}

class Excl extends ExcO {}

public class Test_10 {
	
	public static void main(String[] args) {
		
		try {
			throw new Excl();
		}catch (ExcO eO) {
			System.out.println("ExO caught");
		}catch (Exception e) {
			System.out.println("exception caught");
		}
	}
}


