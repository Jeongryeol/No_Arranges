package com.ch7;

public class Inher_06_SonataSimul {

	//���θ޼ҵ�
	public static void main(String[] args) {		
		Inher_06_Sonata car = new Inher_06_Sonata();
		Inher_06_Sonata car2 = new Inher_06_Sonata2018();
		Inher_06_Sonata2018 car3 = new Inher_06_Sonata2018();
		
		//�Ʒ� �ڵ� ������ �߻����� �ȵ�.
//		car2.cruise();
		//���� : �θ�Ŭ����Ÿ������ ����� ������ �θ�� �ڽ� ���ʿ� �ִ� �޼ҵ常 ȣ�� �����ϴ�.
		
		int speed = car2.speed;
		int whleelNum = car2.wheelNum;
		//�Ʒ� �ڵ� ������ �߻����� �ȵ�. 
//		String carColor = car2.carColor;
//		String carName = car2.carName;
		//�θ�Ÿ���� ������ ���� �θ�Ŭ������ ������ ���� ����.
		
		//�Ʒ� ������ ���� ( ����Ŭ������ ����Ŭ������ ���� )
//		car3 = car;
		car3 = (Inher_06_Sonata2018) car;
		//ĳ���� ������(����ȯ)�� �̿��Ͽ� �θ�Ÿ���� �ڽ�Ÿ������ �������� ���� ����
		String carColor = car3.carColor;
		String carName	= car3.carColor;
		car3.cruise();
		car3.speedUp();
		car3.speedDown();
		
	}

}
