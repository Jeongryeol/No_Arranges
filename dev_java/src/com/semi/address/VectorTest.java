package com.semi.address;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector v = new Vector();
		AddressVO avo = new AddressVO();
		avo.setA_name("�̼���");
		v.add(avo);//�̼�������
		System.out.println(avo);
		avo = new AddressVO();
		avo.setA_name("������");
		v.add(avo);//����������
		System.out.println(avo);
		avo = new AddressVO();
		avo.setA_name("�̼���");
		v.add(avo);//�̼�������
		System.out.println(avo);
		//insert here
		System.out.println(avo.getA_name());
		//Vector�� add�޼ҵ带 ȣ���ϸ� ���� �ϳ��� �þ�� �����ϸ� �ϳ��� �پ��
		//Vector�� ���� ���� ����� ����
		System.out.println("Vector�� ���� ������ "+v.size());
		System.out.println("===================================");
		//Vector�� ����ִ� �ּҹ��� 3�� ����� ����
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
			AddressVO ravo = (AddressVO)v.get(i);
			System.out.println(((AddressVO)v.get(i)).getA_name());
			//System.out.println((AddressVO)v.get(i).getA_name());����
		}
		int i=(int)3.5;
	}

}






