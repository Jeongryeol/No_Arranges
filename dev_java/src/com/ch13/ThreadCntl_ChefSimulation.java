package com.ch13;

public class ThreadCntl_ChefSimulation {

	public static void main(String[] args) {
		Chef chef1 = new Chef();
		chef1.start();
		Chef chef2 = new Chef();
		chef2.start();
		Chef chef3 = new Chef();
		chef3.start();		
	}
	
}
