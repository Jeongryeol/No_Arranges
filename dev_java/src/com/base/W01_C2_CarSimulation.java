package com.base;
/**************************************************************
 * CarSimulationŬ���� �ȿ��� TivoliŬ������ ���ǵ� ������ �޼ҵ带 ����ϰ� ������
 * ����ϰ� ���� Ŭ������ �����ϰ� �����ϸ� �̿��� �� �־��.
 * Tivoli herCar = new Tivoli();
 * Tivoli myCar = new Tivoli();
 * Tivoli yourcar = new Tivoli();
 * Tivoli Ÿ���� �ڵ��� 3�� ����� ��
 * 3���� �ڵ����� Ÿ���� ������ ���� �ٸ� �ڵ����ϱ� 3����� �̿��� ������.
 * �ؾ�� �����ϸ� ���� ����� �ؾ�� �� ���� 3������ ����� ���µ�
 * ����� ���� ���� �� ���� �������� ��ü�̾ ģ���� ������ ���� �� ����.
 * �ڹٿ����� �̷��� ���� Ÿ���� Ŭ������ ���� ���� �� �������� ����� �� �� �־��.
 * �׷��� ��縸 ���� ���� �� ���� �ٸ� Ŭ������� �����ؾ� �� �� ���ƿ�.
 * 5�忡�� �ٽ� �̾߱��� ���ô�...
 **************************************************************/
public class W01_C2_CarSimulation {

	public static void main(String[] args) {
		//���� himCar�� ������ ������
		W01_A1_Sonata himcar = new W01_A1_Sonata();
		System.out.println(himcar);
		//���� herCar�� ������ ������
		W01_B4_Tivoli herCar = new W01_B4_Tivoli();//new�� �̿��ؼ� �ٸ� Ŭ������ static �ӿ� ���ǵ� ������ ������ �� �ִ�.
		System.out.println(herCar);
		String myName = "�̼���";
		System.out.println(myName);//�ּ� ������ �ƴ϶� �̼����� �����
		System.out.println(herCar.speed);
		

	}

}
