package com.ch6.exercise;

public class Exercise_16 {

	public static void main(String args[]){
	
		int i = 0;
		int j = 0;
		
		outer:
			for(i=1; i<3; i++){
				inner:
					for(j=1; j<3; j++) {
						if(j==2) {
							continue outer;
						//	break outer;
						//	continue inner;
						}
						System.out.println("Value are " + i + " " + j);
					}
			}
	
	}
	
}
