package com.ch03;
/*
 * jsp���� java code�� �ν��Ͻ�ȭ�� �� java�ʹ� ���̰� �ְ�,
 * �� �� scope�� ���� ���ظ� �� �ʿ��մϴ�.
 */
public class Sonata {
	//�����
	int speed;
	//����Ʈ ������
	public Sonata() {
		System.out.println("Sonata ����Ʈ ������ ȣ�� ����");
	}
	//�޼ҵ�
	public int speedUp() {
		speed += 1;
		return speed;
	}
}
