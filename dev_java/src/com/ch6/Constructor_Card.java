package com.ch6;
/*
 * ���� �����ڸ� ������ �� �ִ�.
 * ���� ���� �ʿ��� �����ڸ� ȣ�� �� �� �ִ�.
 * �����ڴ� ����Ÿ���� ����.
 */
public class Constructor_Card {

	int j;
	
	Constructor_Card() {
		int j = 1;//��������
		//this�� �ڱ��ڽ� Ŭ������ ����ų �� ����ϴ� �����
		//this�� ���� i�� ���������� �ִ� ���� j�� ����Ű�� ��, ���Կ����� ���� j�� �������� j��.
		this.j = j;//���������� ���������� ������ �ʱ�ȭ�ϴ� ��
		//�� �������Ŀ��� �������� j�� ���� �������� j�� ���� ������ ���� �������� ��밡������.
		System.out.println("����Ʈ������");
		System.out.println("");
	}

	Constructor_Card(double d) {
		System.out.println(d+"�� ȣ��Ǿ����ϴ�.");
		System.out.println( "�Ķ���Ͱ� double�� ������");
		System.out.println("");
	}

	Constructor_Card(int i) {
		System.out.println(i+" ȣ��Ǿ����ϴ�.");
		System.out.println("�Ķ���Ͱ� int�� ������");
		System.out.println("");
	}

	Constructor_Card(String wt, int qt) {//����� ���� ������ (�Ű������� �����Ӱ� �߰� ����)
		System.out.println(wt+" "+qt+"�� ȣ��Ϸ�Ǿ����ϴ�.");
		System.out.println("�Ķ���Ͱ� 2���� ������");
		System.out.println("");
	}

	void Card() {//����� ���� �޼ҵ� (�Ű������� �����Ӱ� �߰� ����)
	}
	
	public static void main(String[] args) {
		new Constructor_Card(10);
		new Constructor_Card("���",1);

		Constructor_Card replicaCard = new Constructor_Card();
//		replicaCard.Card();
		
		new Constructor_Card(replicaCard.j);
		
		System.out.println(replicaCard.j);
	}

}
