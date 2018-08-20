package com.ch6;

public class MethodTest1 {

	//�ν��Ͻ�ȭ�� ���������� ���𰡴�
	MethodTest1 mt2 = new MethodTest1();
	
	//�������� ���԰� ����
	public static void methodA() {}
	public final void methodB() {}
	public void methodC() {}
	
	//����Ÿ�԰� final����(�޼ҵ�������̵� �Ұ�)
	public static int methodA1() {return 0;}
	public double methodB1() {double d=0.5; return d;}
	public final String methodC1() {return "�ȳ�";}
	
	public static void main(String[] args) {

		methodA();//static�� �ν��Ͻ�ȭ���� ȣ�Ⱑ��
		//static�ȿ��� ȣ���Ҷ��� ���ȿ� �ִ��� non-static�� �ν��Ͻ�ȭ �ʿ�
		//�ν��Ͻ�ȭ�� ���������� ����
		//���������� ���� ������ �Է��ص� ������ �߻����� �ʴ� ������ ������������ ������ �ν��Ͻ�ȭ �� ���̱� ����
		MethodTest1 mt = new MethodTest1();
		mt.methodB();
		mt.methodC();
		mt.methodC();

		//�������� mt2�� main�޼ҵ忡�� ������ �� �ִ�|����.
//		mt2.methodA();//����. �ֳ��ϸ� mt2������ non-staticŸ���̱� ����.
		//���� static�� Ŭ�����̸� �տ� ���̰� �Ǹ� ������ �� �ְ� ��.
		//�׷��� �����ǰ� �ǹǷ�, �������� ����ϴ� ���� �ƴ϶� ���� �ϳ��� �����ϰ� �Ǵ� ����.

		//�������� mt2�� non-static���� �����ؼ� �����ϰ� �ʹٸ�, �ּҹ����� �ι� ����ؾ���
		//mt�� �������� ������, MethodTest1Ŭ������ �޸�(static����)�� �ε������ֹǷ�
		//mt2 ���������� ������ �� �ִ� ��.
		mt.mt2.methodC1();
		//�̶�, ��� Ŭ������ �ƹ����� ObjectŬ������ ���ǵ� �޼ҵ� toSting()�� ȣ�� �� �� �ְ� �Ǵ� ��.
		//��, �����ν��Ͻ����� ������ ���� �����ν��Ͻ������� ���� + ObjectŬ���� �� toString�޼ҵ� ȣ��
		mt.mt2.toString();
		System.out.println(mt.mt2.toString());


	}

}
