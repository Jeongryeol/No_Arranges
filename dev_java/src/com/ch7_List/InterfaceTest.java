package com.ch7_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.ch6.Sonata;
import com.oracle.jdbc.EmpVO;

public class InterfaceTest {
	//��������Ǹ޼ҵ� : ����� ���谡 �����Ƿ� �����ε��� ����
	public void setSonataList(Vector<String> nameList) {//����üŬ������ �Ķ���ͷ�
		nameList.add("NF �ҳ�Ÿ");
		nameList.add("2017���� �ҳ�Ÿ");
		nameList.add("2018���� �ҳ�Ÿ");
	}
	public void setSonataList(ArrayList<String> nameList) {//����üŬ������ �Ķ���ͷ�
		nameList.add("�׳��� �ҳ�Ÿ");
		nameList.add("�׳��� �ҳ�Ÿ");
		nameList.add("����� �ҳ�Ÿ");
	}
	public void setSonataList(List<String> nameList) {//�������̽��� �Ķ���ͷ�
		nameList.add("���ڳ�� �ҳ�Ÿ");
		nameList.add("2.4�ҳ�Ÿ");
		nameList.add("2.5�ҳ�Ÿ");
	}
	//�߿�ä�ÿ� �޼ҵ� �ڵ� (Sonata�ڸ��� Thread�� �Ⱦ� �־���Ұ��̴�)
	public void setSonataList2(List<Sonata> nameList) {
		//�޼ҵ� �����ε��Ҷ� �Ķ������ ���׸�Ÿ��(<>)�� ������ ���� ������, �޼ҵ��̸��� 2�� ������ �����ε� �ߺ����� �ش�ȴ�.
		Sonata myCar = new Sonata();
		nameList.add(myCar);
		Sonata herCar = new Sonata();
		nameList.add(herCar);
		Sonata himCar = new Sonata();
		nameList.add(himCar);
	}
	public void setSonataList3(List<EmpVO> nameList) {
		//�޼ҵ� �����ε��Ҷ� �Ķ������ ���׸�Ÿ��(<>)�� ������ ���� ������, �޼ҵ��̸��� 2�� ������ �����ε� �ߺ����� �ش�ȴ�.
		EmpVO empno1 = new EmpVO();
		nameList.add(empno1);
		EmpVO empno2 = new EmpVO();
		nameList.add(empno2);
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		//��������Ǹ޼ҵ� 3���� ȣ���غ���
		InterfaceTest ift = new InterfaceTest();
		Vector<String> nameList = new Vector<String>();
		ArrayList<String> nameList2 = new ArrayList<String>();
		List<String> nameList3 = new ArrayList<String>();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		ift.setSonataList(nameList);
		for(String carName:nameList) {//������ for�� ����ؼ� Ȯ���غ���
			System.out.println("Vector[��Ƽ������ ����-�ӵ�����]: "+nameList);
		}//������ ����ϱ⶧���� ����Ÿ��(void)�� ������� ��°�����
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		ift.setSonataList(nameList2);
		for(String carName:nameList2) {//������ for�� ����ؼ� Ȯ���غ���
			System.out.println("ArrayList[�̱۽����� ����-�ӵ�����]: "+nameList2);
		}//������ ����ϱ⶧���� ����Ÿ��(void)�� ������� ��°�����
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		ift.setSonataList(nameList3);
		for(String carName:nameList3) {//������ for�� ����ؼ� Ȯ���غ���
			System.out.println("List [Vector�� ArrayList�� �� �޾��ش�] : "+nameList3);
		}//������ ����ϱ⶧���� ����Ÿ��(void)�� ������� ��°�����
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

}
