package com.ch6;

public class Istance_B {

	//�����
	//Ŭ����B �������� ����� �� �ִ� ���� �ν��Ͻ� ������ �����
	Istance_A replicaA = new Istance_A();//Ŭ����B�� Ŭ����A�� �޼ҵ� A�� ȣ���غ�����.
	
	//�޼ҵ念��
	void expB() {
		replicaA.methodA();//���� �ν��Ͻ� ������ ���� ����ϴ� ȣ��		
	}
	
	//main�޼ҵ� ����
	public static void main(String[] args) {
		
		//Ÿ���� ���� �ٸ� Ŭ������ ���� �ν��Ͻ����� �� �����Ǿ���.(���� �ν��Ͻ� �����ʹ� �ٸ� �������� �� ��)
		Istance_A replicaA = new Istance_A();
		replicaA.methodA();//���� �ν��Ͻ� ������ ���� ����ϴ� ȣ��
		
	}
	
}
