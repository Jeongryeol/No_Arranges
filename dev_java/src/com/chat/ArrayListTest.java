package com.chat;

import java.util.ArrayList;
import java.util.List;

import com.ch6.Sonata;
import com.ch7.Encaps_TimeVO;

public class ArrayListTest {

	ArrayList al = new ArrayList();	//< >(Generic)�� ������� �ʾƼ� ��� ������ ����(�������)
	ArrayList<String> als = new ArrayList<String>(); //���׸��� ������ �ٸ�Ÿ�� ���� ��� ����?
	ArrayList<Encaps_TimeVO> ald = new ArrayList<Encaps_TimeVO>(); //�̷��� �ϸ� ��!
	ArrayList<Object> alo = new ArrayList<Object>(); //�ֻ��� ������Ʈ�� ���׸��� ������� ���� �� �������� �� �־�� ����
	
	List al2 = new ArrayList();		//�������̽� �̸�  = new ����üŬ����
	
	List<String> al3 = new ArrayList<String>();	//�������̽�<Ŭ����> �̸� = new ����üŬ����<Ŭ����>();
	List<Sonata> al4 = new ArrayList<Sonata>();

	//List<T>	al5 = new ArrayList<T>();
	//al������ ���׸��� �����ϱ� � Ÿ���̵� ���� �� �־��.
	//�׷��� ���� �� ���� ��� Ÿ���� �� �� �ִ� �ɱ�?
	
	public void setList() {
		al.add("����");
		al.add(new Sonata());
		al.add(10);//al�� ���׸��� ������ � Ÿ���̵� ���� �� �ִ�.
		//��, ���׸��� ������ ���� Ÿ�Ը� ���� �� �ִ�.
		//�׷���, ���׸��� �־ ���� �ٸ� Ÿ���� ��� �ʹ�.....
/*		als.add("����");
		als.add(new Sonata());	//�� �繰�� ������... String�� ����ִ°� �ƴѵ�....
		als.add(10);			//���ڵ� ��ܾ� �ϴµ� �ФФ�...
*/		
		//������Ʈ�� ���׸����� �ߴ��� ���� �� �������־�!!!������
		alo.add("����");
		alo.add(new Sonata());
		alo.add(10);
		//�׷���... ��� ������.. �װ� � Ÿ������ �˰� ��Ʋ�����...?
	}

	//�پ��� Ÿ������ ������ ���� Ȯ���ϴ� ���!
	public void getList() {
		for(int i=0;i<alo.size();i++) {
			if(alo.get(i) instanceof String) {//�� Ȥ�� StringŸ���̴�?
				String str = (String)alo.get(i);//String����ȯ
				System.out.println(str);
			}else if(alo.get(i) instanceof Integer) {//�� Ȥ�� IntegerŸ���̴�?
				Integer intg = (Integer)alo.get(i);//Integer����ȯ
				System.out.println(intg);
			}else if(alo.get(i) instanceof Sonata) {//�� Ȥ�� SonataŬ���� Ÿ���̴�?
				Sonata myCar = (Sonata)alo.get(i);
				System.out.println(myCar);
			}
		}
	}
	
	//�ҳ�Ÿ�� �ǽ�
	public void setList2() {
		//�ҳ�Ÿ�κ��� 3���� �ҳ�Ÿ�� ������
		Sonata ysCar = new Sonata();
		Sonata gsCar = new Sonata();
		Sonata bhCar = new Sonata();
		//�ҳ�Ÿ�� �ӵ�����?? (�ϳ��� Ŭ������ ������ ���� �����ε� �ٸ� ���� ������ �� �ִ�)
		ysCar.speed = 350; //�����ڵ����� Ʃ������ ���� �ӵ��� ��û ������ �ٲ���Ҵ�
		gsCar.speed = 220; //�Լ��ڵ����� ��������..
		bhCar.speed = 100; //�����ڵ����� ��������..
		//�� 3���� �ڵ����� �ʱ�ȭ�� �������� al4�� ��ƺ���
		al4.add(ysCar);
		al4.add(gsCar);
		al4.add(bhCar);
		//��Ƴ� ���� ������ �޼ҵ� getList2()�� ����
		getList2();
	}
	
	public void getList2() {
		//���ȿ� �ִ� Ÿ���� Sonata�� ��� ���⶧����, instanceof�� Ÿ���� ã�� �ʿ�� ����.
		for(int i=0;i<al4.size();i++) {
			Sonata gnomCar = al4.get(i);
			System.out.println(gnomCar.speed);
		}
	}
	
	public static void main(String[] args) {
		ArrayListTest alt = new ArrayListTest();
/*		alt.setList();
		alt.getList();
*/
		alt.setList2();
		}

}
