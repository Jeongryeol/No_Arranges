package com.ch5;
/*
 * �迭�� ����� �ʱ�ȭ�� �����Ͽ� �ϴ°͵� ����
 */
public class ArrayTest2 {
	String names[] = null;//��������
	void namesInit() {
		names = new String[3];
		names[0] = "�̱���";
		names[1] = "����";
		names[2] = "�����";//���� ��ȭ�濡 �����ִ� ����� �̸���� �ʱ�ȭ ��ų �� ����
	}
	/* ����
	 * �̱���, ����, ����� �� ģ���� �̸��� ����ϴ� �޼ҵ带 �����غ�����.
	 * insert here 1
	 */
	//answer here 1/2
	void nameList() {
	//�������� names�迭�� ���� ���� �Ǿ��ְ�
	//�迭�� �ʱ�ȭ�� namsInit() �޼ҵ� �ȿ��� �̷�� ��������, ȣ���� ���� �ؾ߰ھ��.
		namesInit();//�� �ȿ� �ִ� �޼ҵ带 �ҷ��� ȣ���ϱ�
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]);
		}
		//������ for������ �ٲپ� ����غ��Կ�. - ��ü�� ����ϴ� ����̱⶧����, ����� �����ϰ���?
		System.out.println("=====[�ܺ�ȣ�� �޼ҵ� ��/�Ʒ�/������ for������ ó���� ���]=====");
		for(String name:names) {//ù��°�� �迭�ȿ� Ÿ���� �ۼ��ϰ� �����̸��� : �ι�°�� �迭�� �ּҹ����� ������ ����.
			System.out.println(name);
		}
	}
	//public�� ����������(access modifier) public > protected > friendly > private
	//���������ڰ� ������ friendy �����̰�, ���� ��Ű�� ���� Ŭ�������� ȣ���� ���ִ�.
	//�׷��� �ٸ� ��Ű���� �ִ� Ŭ���������� ȣ���� �� ����.
	public static void main(String[] args) {
		int is[] = null;//���� //��������
		is = new int[3];//�ʱ�ȭ
		//non-static ���� names�� static�����ȿ��� ����� �� �ִ�. (��? ���������̱� ������ �����ϴ�.)
		//how? ���? - �ν��Ͻ�ȭ!!!
		ArrayTest2 at2 = new ArrayTest2();//�ν��Ͻ�ȭ
		//answer here 2/2 - nameList()�޼ҵ� ȣ���ϱ�
		System.out.println("=====[�Ʒ�/static main �޼ҵ� ���� �޼ҵ带 ȣ���Ͽ� ó���ϱ�]=====");
		at2.nameList();
		System.out.println("=====[�Ʒ�/�޼ҵ���� ���������� static main�޼ҵ� �ȿ� �ν��Ͻ�ȭ�� �ҷ��� ó���� ���]=====");
		at2.names = new String[3];//�������� ������ ��迭 ����
		at2.names[0] = "������";
		at2.names[1] = "������";
		at2.names[2] = "������";
		for(int i=0;i<3;i++) {
			System.out.println(at2.names[i]);	
		}
		
	}

}
