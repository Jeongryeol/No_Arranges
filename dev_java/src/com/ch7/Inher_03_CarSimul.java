package com.ch7;

public class Inher_03_CarSimul {

	public static void main(String[] args) {
		System.out.println("�θ�Ÿ������ �ڽ�Ŭ������ �ν��Ͻ�ȭ �߽��ϴ�.");
		Inher_03_Suv car = new Inher_03_Sorento();
		System.out.printf("3....2....1....%n�׽�Ʈ�� �����մϴ�!%n");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("Step.1 / �θ�Ŭ������ �������� �ʱ�ȭ�ϱ�");
		car.speed = 30;
		System.out.println("car.speed = "+car.speed);//���� 30 SUV++���
		System.out.println("�� �ν��Ͻ����� car�� �θ�Ŭ���� Ÿ�Կ� �ڽ�Ŭ������ �ּҸ� ���� ������, �θ�Ŭ������ speedUp�� �ֽ��ϴ�.");
		System.out.println("car.speedUp()�� ��� ");
		car.speedUp();//���� 30 SUV++���
		
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("�ڽ�Ÿ������ �ڽ�Ŭ������ �ν��Ͻ�ȭ �߽��ϴ�.");
		Inher_03_Sorento car2 = new Inher_03_Sorento();
		System.out.println("Step.2 / �ڽ�Ŭ������ �������� �ʱ�ȭ�ϱ�");
		System.out.println("�ʱ�ȭ �� �ڽ�Ŭ������ carColor = "+car2.carColor);//���� Matt-Black
		//car.carColor = "Deep-Blue" //�����߻� : �θ�Ŭ�������� carColor ������ ����
		System.out.println("<����>car.carColor = Deep-Blue //�����߻� : �θ�Ŭ�������� carColor ������ ����");
		System.out.println("<�ʱ�ȭ>car2.carColor = Deep-Blue");//���� Matt-Black
		car2.carColor = "Deep-Blue";
		System.out.println("�ʱ�ȭ �� �ڽ�Ŭ������ carColor = "+car2.carColor);//���� Matt-Black
		System.out.println(" ");
		System.out.println("�� �ν��Ͻ����� car�� �θ�Ŭ���� Ÿ�Կ� �ڽ�Ŭ������ �ּҸ� ���� ������, carColor�� �����ϴ�.");
		System.out.println("�� �ν��Ͻ����� car2�� �ڽ�Ŭ���� Ÿ�Կ� �ڽ��� �ּҸ� ���� ������, carColor�� �ֽ��ϴ�.");
		
	}

}
