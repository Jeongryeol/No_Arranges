package com.ch6;

public class SungJuk_Hap {

	public int[] hap(String[][] datas) {
	      System.out.println("hap ȣ�� ����");
	      //insert here - 1�� �迭 ����
	      int[] haps = new int[5];
	      for(int i=0;i<datas.length;i++) {//datas[i].length - �÷�üũ
	      haps[i] = Integer.parseInt(datas[i][2])
	              + Integer.parseInt(datas[i][3])
	              + Integer.parseInt(datas[i][4]);
	      }
	      return haps;
	}
	
}