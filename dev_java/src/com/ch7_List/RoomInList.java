package com.ch7_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RoomInList {
	public List<String> getRoomInList(){//List��� �������̽��� ����ƮŸ���� List<type> ��� �����ִ�.
		/*
		 * nameList�� ListŸ���Դϴ�.
		 * nameList�� ����ü Ŭ������ ArrayList�� ���õǾ����ϴ�.
		 * �Ʒ��� ���� �ν��Ͻ�ȭ�� �����Ͽ��� ������ ������ �߻����� �ʾҴٴ� �� �չ��̶�� �ǹ��Դϴ�.
		 * ��, List�� �߻�޼ҵ��� add(E e):boolean ��
		 * add(int index,E e):void �� ArrayList Ŭ������ �����ߴٴ� �ǹ��Դϴ�. ( E : Element )
		 * ���� ������ �ְ� �˴ϴ�.
		 */
		List<String> nameList = new ArrayList<String>();
		//nameList = new Vector<String>();
		boolean isOk = nameList.add("�����");
		nameList.add(1,"����");
		isOk = nameList.add("������");
		return nameList;
	}
	public void nameListPrint() {
		List li = getRoomInList();//�޼ҵ带 ȣ���ϰ� �� ����Ÿ�Կ� �´� ������ �����Ѵ�.
		System.out.println(li.toString());//list�� ��� ������ ��� ����Ѵ�.
		System.out.println(li.get(0));//list�� 0��°�� ��� ������ ���´�.
		System.out.println(li.get(1));//list�� 1��°�� ��� ������ ���´�.
		System.out.println(li.get(2));//list�� 2��°�� ��� ������ ���´�.
	}
	public static void main(String[] args) {
		RoomInList rlist = new RoomInList();
		rlist.nameListPrint();
	}

}
