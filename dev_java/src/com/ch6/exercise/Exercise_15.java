package com.ch6.exercise;

public class Exercise_15 {

	public static void main(String args[]) {
		
		Integer s = new Integer(9);
		Integer t = new Integer(9);
		Long u = new Long(9);

		//Which tests would return true?
		//a.
		System.out.println(s.equals(t));
						//�����̸��� ����Ű�� �ּҹ����� ���빰�� ���ϹǷ� true
		//b.
		System.out.println(s.equals(new Integer(9)));
						//������ ����� ����ü�� ���빰�� ���ϹǷ� true
		//c.
		System.out.println(s.equals(9));
						//�����̸��� ����Ű�� �ּҹ����� ���빰�� autoboxing���� ������ intŸ���� 9�� ���ϹǷ� ture
		//d.
		System.out.println(s == t);
						//�ּҹ����� ���ϴ� ==�� ��� ���� �ٸ� false
		//e.
//		System.out.println(s == u);
						//�ּҹ����� ���ϴ� ==�� ���, ���� �ٸ� Ÿ���� ���� �� �����Ƿ� ����
	}
}
