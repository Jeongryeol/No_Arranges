package com.ch7;

public class Inher_01_ChildSimul {

	public static void main(String[] args) {
		
		//�ƺ� �޸𸮿� �ε��ϱ�
		Inher_01_Parent p = new Inher_01_Parent();
		System.out.println("before p.i :"+p.i);//10
		//�ڳ� �޸𸮿� �ε��ϱ�
		Inher_01_Child c = new Inher_01_Child();
		System.out.println("before c.i :"+c.i);//10

		c.i=100;
		System.out.println("after c.i :"+c.i);//100	//�ڳ��� i��Ӻ��� �ʱ�ȭ
		System.out.println("after p.i :"+p.i);//10	//�θ��� i�� ������ �ʴ´�!!
		
		//�θ��� i(p.i)�� 100�� �������� �Ϸ���???
		c.i=p.i;
		System.out.println("after2 p.i :"+p.i);//10
							//���������� �θ��� i�� �־����Ƿ� 10		
		c.i=100;
		p.i=c.i;
		System.out.println("after3 p.i :"+p.i);//100
							//������ �θ��� i�� �ʱ�ȭ�� ��Ӻ����� ���� �־� �ʱ�ȭ��
		
		//�ٸ����
		//p = c;//���Կ����ڸ� �������� �������� ���� ��(�ڳ�Ŭ����)�� �;���.
		System.out.println("after4 c.1 :"+c.i);//100
		System.out.println("after4 p.1 :"+p.i);//100
		
		
		
		p = c; 
		//�� ������ ������ ������ �߻��ϴ� ����? [�ڵ������ �߻��ϴ� ���� :ĳ���ÿ���]
		//Exception in thread "main" java.lang.ClassCastException:
		//com.ch7.Inheritance_Parent cannot be cast to com.ch7.Inheritance_Child
		//at com.ch7.Inheritance_ChildSimulation.main(Inheritance_ChildSimulation.java:44)
		//�ڽ�Ŭ������ �θ�Ŭ������ ��ӵǴ� ������ ������ ������,
		//�θ�Ŭ������ �ڽ�Ŭ������ ��Ӱ��迡 �־ �������̰� �� ū �����̴�
		//����, �ν��Ͻ�ȭ�� �θ�Ŭ������ �ν��Ͻ�ȭ�� �ڽ�Ŭ������ �ּҷ� �ֱ� ���ؼ���
		//�ݵ�� ����� �������� [�θ�Ŭ����(����)]�� [�ڽ�Ŭ����(����)]�� �ּҹ����� �־��־��
		//�Ʒ��� �������� [�θ�Ŭ����(����)]�� [�ڽ�Ŭ����(����)]�� ����ȯ��ų �� �ִ� ���̴�.
		c = (Inher_01_Child)p;
		c.i = 100;
		System.out.println("after5 c.1 :"+c.i);//100
		System.out.println("after5 p.1 :"+p.i);//100
	}
	
}
