package com.ch7_abst_intrf2;

public abstract class The_Gift {//�������ڿ� ���� �߻�Ŭ����

	//��������
	public	int 	contain	= 0;	//���� ������ ����
	public	int 	boxEdge	= 0;	//������ ������ ��
	public	boolean	isRibon	= false;//������������
	private	double	sizeW;	//�ڽ� �ʺ�
	private	double	sizeD;	//�ڽ� ���̰�
	private	double	sizeH;	//�ڽ� ���̰�

	//�Ϲݸ޼ҵ�
	//�ڽ��� ������(�ʺ�,����,����)�� �޾� ������ getter/setter�޼ҵ�
	public double getSizeW() {return sizeW;}
	public void setSizeW(double sizeW) {this.sizeW = sizeW;}
	public double getSizeD() {return sizeD;}
	public void setSizeD(double sizeD) {this.sizeD = sizeD;}
	public double getSizeH() {return sizeH;}
	public void setSizeH(double sizeH) {this.sizeH = sizeH;}
	
	//�߻�޼ҵ�
	public abstract void include(int contain);//�������ڿ� ��� ����� �ر׸��� �߻�޼ҵ�
	public abstract boolean wrapPattern(String pattern);//���������� �������� ������ ��� ����� �ر׸��� �߻�޼ҵ�
}
