package com.ch6;

public class SungJuk_Avg {

	public double[] avg(int[] haps) {
	      System.out.println("avg ȣ�� ����");
	      //insert here - 1���迭
	      double[] avgs = new double[5];
	      for(int i=0;i<haps.length;i++) {
	         avgs[i] = haps[i]/3.0;
	      }
	      return avgs;
	}
	
}
