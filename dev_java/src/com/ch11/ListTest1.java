package com.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/*
 * ������� Ÿ�԰� �������� Ÿ���� �ٸ� �� �ִ�. - �������� ��������
 * �ٸ� ��� �����ο� ���� Ŭ���� Ÿ������ ��ü ������ �Ͼ.
 * ����ο� �� ����Ŭ������ �������̽��� ���� �����ο� �پ��� Ŭ������ �ν��Ͻ�ȭ �� �� �־ ����.
 * ��) �ڵ带 �� �����ϰ� �䱸������ ������ų �� �ִ�.
 */
public class ListTest1 {
	List nameList = new ArrayList();
	ArrayList aniList = new ArrayList();
	List nameList2 = new Vector();
	Vector aniList2 = new Vector();
	public List setNameList() {
		nameList.add("���缮");
		nameList.add(1, "������");
		nameList.add(2, "����");
		return nameList;
	}
	public List setNameList2() {
		nameList2.add("���缮");
		nameList2.add(1, "������");
		nameList2.add(2, "����");
		return nameList2;
	}
	public ArrayList setAniList() {
		aniList.add("cat");
		aniList.add(1, "dog");
		aniList.add(2, "pig");
		return aniList;
	}
	public Vector setAniList2() {
		aniList2.addElement("cat");
		boolean isFlag2 = aniList2.add("dog");
		System.out.println("isFlag2 : "+isFlag2);
		aniList2.add(2, "pig");
		return aniList2;
	}
	public void printNameList() {
		for(int i=0;i<nameList.size();i++) {
			System.out.println(nameList.get(i));
		}
		System.out.println("===[[���� for��]]===");
		for(Object obj:nameList) {//��ü��� ����� ��
			System.out.println(obj);
		}
	}
	public void printAniList() {
		for(int i=0;i<aniList2.size();i++) {
			System.out.println(aniList2.get(i));
		}
		System.out.println("===[[���� for��]]===");
		for(Object obj:aniList2) {//��ü��� ����� ��
	//�÷��������ӿ�ũ Ŭ������ ��� ObjectŸ���� ��´�.
	//���׸��� ������� �ʴ� ��� Ÿ���� ���� ���� �־�� �Ѵ�.		
			String myAni = (String)obj;
			System.out.println(myAni);
		}		
		System.out.println("���� �־�?"+aniList2.contains("dog"));
		System.out.println("�׹ٱ��� ��� �־�?"+aniList2.isEmpty());
		aniList2.remove("dog");
		System.out.println("===[[���� for��]]===");
		for(Object obj:aniList2) {//��ü��� ����� ��
	//�÷��������ӿ�ũ Ŭ������ ��� ObjectŸ���� ��´�.
	//���׸��� ������� �ʴ� ��� Ÿ���� ���� ���� �־�� �Ѵ�.		
			String myAni = (String)obj;
			System.out.println(myAni);
		}
	}
	public static void main(String[] args) {
		ListTest1 lt1 = new ListTest1();
		lt1.setNameList();
		lt1.printNameList();
		lt1.setAniList2();
		lt1.printAniList();
	}

}
