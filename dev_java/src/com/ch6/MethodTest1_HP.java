package com.ch6;

public class MethodTest1_HP extends Object {//��� Ŭ������ Object Ŭ������ �ƹ����� �ΰ� ��ӵǾ��ִ�.
	
	//insert here - ���� �̸��� �޼ҵ带 4�� �����غ�����.
	//�޼ҵ� �����ε��� �����Ͽ� ���� �̸��� �޼ҵ带 n�� ��ŭ ������ �� �ִ�.
	public void call() {}								//0��
	public void call(String phoneNumber) {}				//0��
	public void call(String phoneNumber,String name) {}	//0��
	void call(int phoneNumber) {}						//1��
	int call(int phoneNumber, int newPhoneNumber) {return newPhoneNumber;} //1��,2��
	public void call(String phoneNumber, String name, String gender) throws Exception {}
	//�޼ҵ� �����ε� : �޼ҵ� �̸��� ������, �Ķ���ͷ� �����Ͽ� ���Ӱ� ������
/* 	[ �޼ҵ� �����ε� ��� ]
	 0. ������ �Ķ������ Ÿ���̳� ������ �޶�� �۵��Ѵ�
	 1. ���������ڰ� �ְ� ����� ������ ����.
	 2. ����Ÿ���� �ְ� ����� ������ ����.
	 3. ���ܸ� ������ �� ������ ������ ����.			*/
	
	
	//@ : annotation �޼ҵ� �����ǿ���� ���Կ� ��ȣ
	@Override//�Ʒ� �޼ҵ��� ����Ÿ���� �������� JVM���� ����Ų��.
	public String toString() {
		return "����Ÿ���� ������ �޼ҵ�";
	}//Ŭ���� ���̿��� Override�� �޼ҵ带 �ε�(ȣ��)�ϴ� ���, �ݵ�� ������ �����ش�.
	
	public String parseInt() {
		return "����Ÿ���� ������������ �޼ҵ�";
	}
	
	public static void main(String[] args) {
		MethodTest1_HP hp = new MethodTest1_HP();//����hp�� ��������
		System.out.println(hp.toString());
	}
	
}
