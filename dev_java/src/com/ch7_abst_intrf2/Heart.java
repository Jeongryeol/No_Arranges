package com.ch7_abst_intrf2;

public interface Heart {

	//�������̽��� ������ ����� �ڵ���ȯ�ȴ�.
	//(final�� �����ǵ� �ڵ�����)
	public double temperature = 36.5;
	
	//�������̽��� �����ڸ� ������ ����
	//����ü�� ���� ���� �� �ֱ� �����̴�.
//	public Heart();
	
	//�������̽��� �޼ҵ�� �߻�޼ҵ�� �ڵ� ��ȯ�ȴ�.
	//(final�� �����ǵ� �ڵ�����)
	public void give();
}
