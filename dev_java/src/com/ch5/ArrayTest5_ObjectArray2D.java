package com.ch5;

public class ArrayTest5_ObjectArray2D {

	public static void main(String[] args) {
		int is[][] = new int[3][2];//���� �? �ʱⰪ�� ��?
		for(int i=0;i<is.length;i++) {//is.length�� �󸶴�? row�� ���� 3��
			for(int j=0;j<is[i].length;j++) {//�׷��ٸ�, column�� ���̴� ��� ������?
				System.out.println("["+i+"]["+j+"] = "+is[i][j]);
			}
		}
		System.out.println(" ");

		int is2[][] = {
						{10,11,12}
					   ,{13,14,15}
					   ,{16,17,18}
			   		  };
		//insert here l- is2�迭�� ����� ������.
		for(int i=0;i<is2.length;i++) {
			System.out.println(is2[i]);
			System.out.println("is2["+i+"] = "+is2[i]);
		}
		System.out.println(" ");
		for(int i=0;i<is2.length;i++) {
			for(int j=0;j<is2[i].length;j++) {
				System.out.println("is2["+i+"]["+j+"] = "+is2[i][j]);
			}
		}
		System.out.println(" ");

		for(int i=0;i<is2.length;i++) {
			for(int j=0;j<is2[i].length;j++) {
				System.out.printf("is2[%d][%d]="+is2[i][j]+"%n",i,j);
			}
		}
		System.out.println(" ");
		
		int is3[][] = new int [2][];//size�� �������� �������·� �迭�� �����
		is3[0] = new int [3];
		is3[0][0] = 1;
		is3[0][1] = 2;
		is3[0][2] = 3;
		is3[1] = new int [5];//�÷��� ���� �ο츶�� �ٸ��� ������ �� �ְ�, ����� �� ����
		is3[1][0] = 10;
		is3[1][1] = 20;
		is3[1][2] = 30;
		is3[1][3] = 40;
		is3[1][4] = 50;
		for(int i=0;i<is3.length;i++) {
			for(int j=0;j<is3[i].length;j++) {
				System.out.println("is3["+i+"]["+j+"] = "+is3[i][j]);
			}
		}
		
	}

}
