package com.ch7_abst_intrf2;

public class GiftForGirlfriend extends The_Gift implements Heart, Thanks {
	@Override//�߻�Ŭ������ ��ӹ��� ����üŬ������ ��� �߻�޼ҵ��� ����{}�� �������־���Ѵ�.
	public void include(int contain) {
		this.contain = contain;//��ӹ��� �θ��� ������ �Ķ���ͷ� ���� ���������� �ʱ�ȭ��Ų��.
		System.out.println("�߻��� include() �޼ҵ尡 ����Ǿ���!!...");
		System.out.printf("[���ҽ�]���ڿ�  %d���� ������ ��ҽ��ϴ�!^^��%n",contain);
		System.out.println("��������������������������������������������������������������������");
		
	}
	@Override//�߻�Ŭ������ ��ӹ��� ����üŬ������ ��� �߻�޼ҵ��� ����{}�� �������־���Ѵ�.
	public boolean wrapPattern(String pattern) {
		this.isRibon = true;
		System.out.println("�߻��� wrapPattren() �޼ҵ带 �����ε��� �޼ҵ尡 ����Ǿ���!!... @param : String pattern");
		System.out.println("[���ҽ�]������ ������ '"+pattern+"'�����̴�.");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
		return isRibon;
	}
	//�����ε�
	public boolean wrapPattern() {return isRibon;}
	@Override
	public void give() {System.out.println("���� �׳࿡�� �� ������ ���� ������ �־����ϴ�~��");}
	@Override
	public void take() {System.out.println("�׳�� ������ ���� ���� �־����ϴ�~��");}
}
