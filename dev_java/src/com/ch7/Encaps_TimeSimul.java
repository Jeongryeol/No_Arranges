package com.ch7;

public class Encaps_TimeSimul {

	public void methodA(Encaps_TimeVO tvo) {
		//tvo ��������(�Ķ���ͷ� �Ѿ���Ƿ� ���ñǾ���)
		System.out.println(tvo.name+" ��! "
				+tvo.getYear()+"/"+tvo.getMonth()+"/"+tvo.getDate()+" "
				+tvo.getHour()+":"+tvo.getMinute()+":"+tvo.getSecond()
				+" �����մϴ�. �����ϼ̽��ϴ�! ^0^");
		//insert here - ������ �ٲ��� �ʵ��� �ڵ带 ������ ������.
		tvo = null;
		tvo = new Encaps_TimeVO();//candidate���·� �������� ��ġ�ϴ� ���� ���� ����
		tvo.name = "�����ķ�";//������ �ٲ�� ��
	}
	
	public static void main(String[] args) {
		Encaps_TimeSimul tsim = new Encaps_TimeSimul();
		Encaps_TimeVO tvo = new Encaps_TimeVO();
		
		tvo.name = "������";//public�̹Ƿ� ���������� �� (������ �ٲ�� ��)
		
		tvo.setYear(2018);//private�� �����ص� ������ �������� �Ұ�
		tvo.setMonth(10);
		tvo.setDate(26);
		tvo.setHour(11);
		tvo.setMinute(31);
		tvo.setSecond(13);
		
		tsim.methodA(tvo);
		System.out.println(tvo.name+" ��! "
				+tvo.getYear()+"/"+tvo.getMonth()+"/"+tvo.getDate()+" "
				+tvo.getHour()+":"+tvo.getMinute()+":"+tvo.getSecond()
				+" �����մϴ�. �����ϼ̽��ϴ�! ^0^");
	}

}
