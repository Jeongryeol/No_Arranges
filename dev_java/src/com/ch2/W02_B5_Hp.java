package com.ch2;

public class W02_B5_Hp {
	//�ذ���1. String �տ� static�� ���δ�.
	String hpColor = "black";
	public static void main(String[] args) {
		//System.out.println(hpColor);//�������� �߻�
		//�� Ŭ���� �ȿ��� ����� ������ �ϴ��� non-ststic����(hp)�� static���� ���� �Ұ���.
		W02_B5_Hp hp = new W02_B5_Hp();
		//�ذ���2. ��� �� �ȿ� �ִ� ������ �ϴ��� new�� �̿��ؼ� ��ü�� �����ϸ�
		//�ּҹ����� �̿��ؼ� ���� ������. (�׷��� �Ź� new�� ���ο� ��ü�� �����ϸ� ������  �ڿ��� �����ϰԵ�)
		System.out.println(hp.hpColor);
		W02_B5_Hp herHp = new W02_B5_Hp();
		herHp.hpColor = "red";
		System.out.println("hp�� �� :"+hp.hpColor);
		System.out.println("herHp�� �� : "+herHp.hpColor);
	}

}
