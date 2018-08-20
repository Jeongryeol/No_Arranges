package com.ch8;

public class ThrowsTest {

	public double avg(int tot,int inwon) throws Exception{
		double temp = tot/inwon;
		return temp;
	}
	public static void main(String args[]) {
		ThrowsTest tt = new ThrowsTest();
		double result = 0;
		try {
			result = tt.avg(256,0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception : "+e.getMessage());
		}
	}
}
