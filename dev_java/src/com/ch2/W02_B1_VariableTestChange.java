package com.ch2;

import java.util.Random;

public class W02_B1_VariableTestChange {

	public static void main(String[] args) {
		//x�� y���� ���� ��ȯ�غ��� ����
		int x=10;
		int y=20;
		System.out.println("���� ���� x�� y�� ���� ���� "+x+", "+y+"�̴�.");
		System.out.println(" ");
		System.out.println("���� x�� y�� ���� ���� �����غ���.");
		System.out.println(" ");
		int z=0;//z��� �� ���� ����
		z=y;//z��� ������ y�� ���
		y=x;//y�� x�� ���
		x=z;//x�� ���� y�� ���
		System.out.println("����� ���� x�� y�� ���� ���� "+x+", "+y+"�̴�.");
		System.out.println(" ");
		//----���½ð��� �ϴ� ���ε���----
		//Random�� �����ؼ� ��ȯ�غ���.
		Random r = new Random();//r�� ����API�� ���� �ּҹ����� ���� java.util.Random@5c647e05
		int dap = r.nextInt(50);
		System.out.println(" ");
		System.out.println("---���½ð��� �ϴ� ���κ���---");
		System.out.println(" ");
		System.out.println("�̹� �õ��� �������� ���õ� ��(dap)�� "+dap+"�̴�.");
		System.out.println(" ");	
		System.out.println("���� ����� ���� x�� ���� ���õ� ���� ����ְ�,");
		System.out.println("x���� �ٽ� y���� �־��.");
		System.out.println(" ");
		y=x;
		x=dap;
		System.out.println("�����Ǿ� ����� ���� x�� y�� ���� ���� "+x+", "+y+"�̴�.");
		System.out.println(" ");
		
		
	}

}
