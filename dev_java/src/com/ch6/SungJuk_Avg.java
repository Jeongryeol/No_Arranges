package com.ch6;

public class SungJuk_Avg {

	public double[] avg(int[] haps) {
	      System.out.println("avg 호출 성공");
	      //insert here - 1차배열
	      double[] avgs = new double[5];
	      for(int i=0;i<haps.length;i++) {
	         avgs[i] = haps[i]/3.0;
	      }
	      return avgs;
	}
	
}
