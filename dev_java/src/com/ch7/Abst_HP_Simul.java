package com.ch7;

public class Abst_HP_Simul {
	public static void main(String[] args) {
		//�߻�Ŭ������ �ܵ����� �ν��Ͻ�ȭ �� �� ����. :: ����ü Ŭ������ �ݵ�� �ʿ���.
		//Abst_HP hp = new Abst_HP();
		
		//����ο� �������� �̸��� �ٸ���. (�������� �����ϴ�.)
		//�Ʒ��� ���� ���·� �߻�Ŭ������ ����üŬ������ �������� �����Ͽ� ȣ�� �����ϴ�.
		Abst_HP hp = new Abst_iPhone();
		hp.call();	//�߻�޼ҵ带 iPhone���� �����Ͽ���.
		hp.view();	//�߻�޼ҵ带 iPhone���� �����Ͽ���.
		hp.off();	//�Ϲݸ޼ҵ带 ������ �� �ִ�. - �߻�Ŭ������...
		
		hp = null; //null(����.)
		//iPhone�� Candidate���·� ������. (��� �����Ǵ°� �ƴϴ�.)
		//�׷� ���� �����Ǵ°�? Garvage Collector : System.gc() ���� ȣ�� ����
		hp = new Abst_Galaxy();//�ٽ� �ν��Ͻ�ȭ �Ѵ�.
				
	}
	
}
