package com.ch5;

import java.util.Random;

/*
 * ���� : -10���� 10 ������ ������ 10�� ä���Ͽ� ������ ����� �հ踦 ���Ͻÿ�.
 * ��Ʈ : Random Ŭ���� Ȱ���ϱ�
 */
public class AttayTest7_ObjectArray2D_quiz1 {

	public static void main(String[] args) {
		Random r  = new Random();
		int dap = 0;
		int[] rArr = new int[args.length];
		int sum = 0;
		
		for(int i=0;i<args.length;i++) {
			dap = r.nextInt(10);
			rArr[i] = dap;
			sum = sum + dap;
			System.out.println(i+" ��° ä������ : "+rArr[i]);
			if(i==9)
				System.out.println("\n"+i+"��° ä�����ڱ����� �հ� : "+sum);
		}

	}

}
