package com.ch6;

public class Istance_A {//Ŭ����A�� Ŭ����C�� �޼ҵ�C�� ȣ���غ�����.

	//�����
	Istance_C replicaC = new Istance_C();//Ŭ���� C�� ��°�� �����Ͽ� ���� �ν��Ͻ� ���� C�� ������
	
	//�޼ҵ� ����
	public void methodA() {//Ŭ����A�� �޼ҵ�A�� �����ϼ���. ����Ÿ���� ������� �ϼ���~ ��?������ ó���Ұ� �ƴϱ� ����
		System.out.println("[�˸�] classA�� methodA ȣ�� �����߽��ϴ�.");
	}
	
	//main�޼ҵ� ����
	public static void main(String[] args) {
		
		Istance_A replicaA = new Istance_A();//Ŭ���� A�� ��°�� �����Ͽ� ���� �ν��Ͻ� ������ ������
		replicaA.replicaC.methodC();//������ �����ν��Ͻ����� A �ȿ���, ���� �ν��Ͻ� ���� C�� ã��, �� �ȿ� �޼ҵ�C�� ã�Ƽ� ȣ����
	
	}
	
}
