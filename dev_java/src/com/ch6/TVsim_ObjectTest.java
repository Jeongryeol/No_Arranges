package com.ch6;

public class TVsim_ObjectTest {

	public static void main(String[] args) {
		
		//�� �濡 �ִ� TV�� �ν��Ͻ�ȭ
		TV_ObjectTest myRoom = new TV_ObjectTest(2,7,30,24); 
		System.out.println(myRoom.channel+", "+myRoom.volume
					 +", "+myRoom.width+", "+myRoom.height);
		
		//�θ�� �濡 �ִ� TV�� �ν��Ͻ�ȭ
		TV_ObjectTest parentRoom = new TV_ObjectTest(0,5,68,45);
		System.out.println(parentRoom.channel+", "+parentRoom.volume
				     +", "+parentRoom.width+", "+parentRoom.height);
				
		//insert here - �ƺ��濡 TV��  ���ٷ�?
			//[������]�ν��Ͻ�ȭ �� �θ�� �濡 �ִ� TV ����
			//parentRoom.powerOff();
		
		//���� �θ�Թ� TV�� ���� ���·� �������� �����?
		parentRoom.isPower = true;//�ν��Ͻ�ȭ�� Ŭ������ ���������� ������ �ʱ�ȭ��

		//Ȥ�� �ٸ������ �ִٸ�? �޼ҵ� ȣ���ϱ��??
		boolean tvStatus = parentRoom.powerOff();
		if(tvStatus) {
			System.out.println("�θ�Թ� TV�� ���� ����");
		}
		else if (!tvStatus) {
			System.out.println("�θ�Թ� TV�� ���� ����");			
		}

		//������ ������ �����
		//���� �ش� �ν��Ͻ������� �����ڰ� ������, ���콺 �����ؼ� �ڵ��ϼ��ϴ� ����� ����
		TV_ObjectTest herRoom = new TV_ObjectTest(0,5,true);
		TV_ObjectTest yourRoom = new TV_ObjectTest(true,0,5);
	}

}
