package com.ch6;

public class SungJuk_Ranking {

	public int[] ranking(int[] haps) {
	      System.out.println("ranking ȣ�� ����");
	      //insert here - 1���迭
	      int[] ranks = {1,1,1,1,1};
	      for(int i=0;i<haps.length;i++) {
	         for(int j=0;j<haps.length;j++){
	            if(haps[i] <= haps[j]) {
	               ranks[i]++;
	            }
	         }
	      }
	      return ranks;
	}
	
}
