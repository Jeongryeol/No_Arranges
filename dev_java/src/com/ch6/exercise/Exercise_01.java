package com.ch6.exercise;

class Super{
    public float getNum(){return 3.0f;}
}

public class Exercise_01 extends Super{

//	a.
	public float getNum(){return 4.f;}
	//�������̵� : �θ�Ŭ������ �޼ҵ带, ���� �̸��� �޼ҵ��, �Ӽ��� �Ķ���͸� ��ȭ��Ű�� ����ä, ���ϰ��� ���� �����ϴ°�

//	b.
	//public void getNum(){return 4.0f;}//�޼ҵ��� ����Ÿ���� void�� ���������Ƿ� ������ ��

//	c.
	public void getNum(double d){};
	//�����ε� : �θ�Ŭ������ �޼ҵ带, ���� �̸��� �޼ҵ��, �Ӽ��� ��ȭ��Ű��ų� �߰��Ͽ�, �̿��ϴ� ��

//	d.
	public double getNum(float d){return 4.0d;}
	//�����ε� : �θ�Ŭ������ �޼ҵ带, ���� �̸��� �޼ҵ��, �Ӽ��� ��ȭ��Ű��ų� �߰��Ͽ�, �̿��ϴ� ��
	
}
