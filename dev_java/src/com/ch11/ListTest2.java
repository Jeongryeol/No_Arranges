package com.ch11;

//util�� awt�� �򰥸��� ����!! (awt�� ȭ�鱸���� API)
import java.util.Iterator;
import java.util.List;

public class ListTest2 {

	public static void main(String[] args) {
		ListTest1 lt1 = new ListTest1();
		//ListŸ������ �̸��� ��Ҵ�
		List nameList = lt1.setNameList();
		//List�� �����ϴ� iterator
		Iterator iter = nameList.iterator();
		
		//�����ϰ����ϴ� List�� �������� ������ ������ (true)
		while(iter.hasNext()) {
			Object obj  = iter.next();	//�о ����
			System.out.println(obj);	//���
		}
	}
}
