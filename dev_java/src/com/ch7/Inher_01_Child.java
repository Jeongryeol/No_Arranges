package com.ch7;

public class Inher_01_Child extends Inher_01_Parent {

	int j;
	
	public Inher_01_Child() {
		System.out.println("�ڽ�Ŭ������ ����Ʈ�����ڰ� ȣ��Ǿ����ϴ�.");
	}
	
	public void methodB() {
		System.out.println("�ڽ�Ŭ������  methodB�� ȣ��Ǿ����ϴ�.");
	}
	
	//[Q.]methodC�� ������ JVM�� ��� �޼ҵ带 �������̵��Ҷ� �̸�,����Ÿ��,�Ķ���͸� �˰� ������ ���ϱ�?
	//�޸��忡�ٰ� �ڵ��� �ϸ� ���� ���α׷��� �������� �ν��Ͻ�ȭ�ϸ鼭 ��Ӱ��踦 Ȯ���ϰ� �����޼����� Ȯ���� �� �ִ�.
	//	Parent p = new Child();�� �ν��Ͻ�ȭ�� �����ڸ� ȣ���ϰԵǸ�, �θ�� �ڽ��� ������ ��� ȣ��ȴ�.(p.312)
	//[Tips]�����ڵ�� ��Ŭ������ �۵����� �������̵�� �޼ҵ��� �̸��� ����Ÿ��, �Ķ���͸� üũ�Ѵ�.
	
	@Override//(p.327)
	public void methodC() {
		System.out.println("[�������̵�]�ڽ�Ŭ������  methodC�� ȣ��Ǿ����ϴ�.");		
	}
	
	//Overload (p.327)
	public void methoc(int i) {
		System.out.println("[�����ε�]�ڽ�Ŭ������ methodC�� int i = "+i+"�� �Ķ���ͷ� ȣ��Ǿ����ϴ�.");
	}
}
