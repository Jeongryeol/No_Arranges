package com.base;

public class W01_B4_Tivoli {
	//�� static�����ȿ����� �Ұ�
	//�ٸ� �޼ҵ� �������� �� ������ ����� �� �ִ�.
	static int speed = 0;//�������� : Ŭ���� �������� ����� �� �ִ�.
	static void methodB(int wheelNum) {//�������� : ����ڰ� �Է��� ��, { } �ȿ����� ��밡�� 
		System.out.println(wheelNum);//6
	}
	static void speedUp() {//static�� �������� ������־ ���������� ������!
		int wheelNum = 4;//��������
		speed = speed + 1;
		System.out.println(speed); //�ڡڡ� ����϶�� ȣ���� �־��
		}

	void speedDown() {
		speed = speed - 1;
		//�������� �� ��� �ٸ� ���������� ���Ұ��� �����߻�
		//System.out.println("�������� "+wheelNum);
	}
	/* ���� ������ ����� main�޼ҵ尡 ���� ���� ȣ��ǹǷ�
	 * 22-23-7-8(���⼭ 6�� ��µ�)-9-24 �� speedUp�� sppedDown�� ȣ������ �ʾ����Ƿ� �����ȸ�� ������.
	 */
	public static void main(String[] args) {
		methodB(6);
		speedUp();//�ڡڡ������ �ȵ�?????
	}

}
