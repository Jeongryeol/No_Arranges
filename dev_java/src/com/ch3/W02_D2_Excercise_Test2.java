package com.ch3;

public class W02_D2_Excercise_Test2 {

	public static void main(String[] args) {
		String s1 = new String("true");
		Boolean b1 = new Boolean(true);
		System.out.println("s1:"+s1+", b1:"+b1);
		if(b1) {
			System.out.println("b1�� boolean �̹Ƿ� true �� ������");
		}
		else {//���� b1�� false�̸� �Ʒ��� �����.
			System.out.println("b1�� booelan �̹Ƿ� true �� �����ϱ� �̰� ����ȵ���....");
						
		}
/*		if(s1) {
			System.out.println("s1�� String �� ���ڿ� �̴ϱ� true�� ���ڿ���, �׷��ϱ� if�� �ȿ��� ����");
		}
		else {//���� s1�� true Ȥ�� false ���� �ƴϹǷ� �񱳸���.
			System.out.println("s1�� ���ڿ��̹Ƿ� if�������� ��������.....");			
		}
		*/
	}

}
