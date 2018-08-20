package com.ch7_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RoomInList {
	public List<String> getRoomInList(){//List라는 인터페이스의 리스트타입은 List<type> 라고 쓸수있다.
		/*
		 * nameList는 List타입입니다.
		 * nameList의 구현체 클래스로 ArrayList가 선택되었습니다.
		 * 아래와 같이 인스턴스화를 진행하였고 컴파일 문제가 발생되지 않았다는 건 합법이라는 의미입니다.
		 * 즉, List의 추상메소드인 add(E e):boolean 과
		 * add(int index,E e):void 는 ArrayList 클래스가 구현했다는 의미입니다. ( E : Element )
		 * 따라서 누릴수 있게 됩니다.
		 */
		List<String> nameList = new ArrayList<String>();
		//nameList = new Vector<String>();
		boolean isOk = nameList.add("유재덕");
		nameList.add(1,"박의");
		isOk = nameList.add("김희진");
		return nameList;
	}
	public void nameListPrint() {
		List li = getRoomInList();//메소드를 호출하고 그 리턴타입에 맞는 값으로 저장한다.
		System.out.println(li.toString());//list에 담긴 내용을 모두 출력한다.
		System.out.println(li.get(0));//list에 0번째로 담긴 내용을 얻어온다.
		System.out.println(li.get(1));//list에 1번째로 담긴 내용을 얻어온다.
		System.out.println(li.get(2));//list에 2번째로 담긴 내용을 얻어온다.
	}
	public static void main(String[] args) {
		RoomInList rlist = new RoomInList();
		rlist.nameListPrint();
	}

}
