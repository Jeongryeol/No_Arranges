package com.ch5;

import com.base.W01_A1_Sonata;
//Ÿ ��Ű���� Ŭ������ �ҷ��ö�, �ҷ��� Ŭ���� ������ main �޼ҵ尡 public �̸� �ҷ��ü� �ְ�, import�� ���� �����ϴ°��� �ڵ��� �����ϴ�.
public class ArrayTest3_ObjectArray {

	public static void main(String[] args) {
		W01_A1_Sonata cars[] = new W01_A1_Sonata[24];//Ŭ������ ���� �� �ν��Ͻ�ȭ�ؼ� �迭�� ������
		W01_A1_Sonata yjdCars = new W01_A1_Sonata();//Ŭ������ ���� �� �ν��Ͻ�ȭ�ؼ� ������ ������ (������ Ŭ�����̹Ƿ� �ּҹ����� ����)
		cars[0] = yjdCars;//������ �迭 0���濡 ������ ������ �Է���
		for(int i=0;i<cars.length;i++) {
			System.out.println(cars[i]);//0���濡 ������ ������ ���� �ּҹ����� ��µ�
		}

	}

}
