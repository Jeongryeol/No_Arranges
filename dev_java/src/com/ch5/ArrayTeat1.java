package com.ch5;

public class ArrayTeat1 {

	public static void main(String[] args) {
		int jls[] = new int[3];
		jls[0] = 1;//1�� �迭�� ù��° �濡�� 0���� 1�� �ʱ�ȭ
		jls[1] = 2;//1�� �迭�� �ι�° �濡�� 0���� 2�� �ʱ�ȭ
		jls[2] = 8;//1�� �迭�� ����° �濡�� 0���� 8�� �ʱ�ȭ
		for(int i=0;i<3;i++) {
			System.out.println(jls[i]);
		}
		//boolean�� 3�� ���� �� �ִ� ���� ������
		//3���� ��ȿ��� default(false)���� �������. ��? ����Ÿ���̱⶧��
		boolean bools[] = new boolean[3];
		for(int i=0;i<3;i++) {
			System.out.println(bools[i]);//false�� 3�� ��µ�
		}
		double ds[] = new double[4];
		for(int i=0;i<ds.length;i++) {//���ǽĿ� ������ٴ� ds.length�� ����ϸ� �迭�� ���̸� ������� (�������)
			System.out.println(ds[i]);//false�� 4�� ��µ�
		}
	}

}
