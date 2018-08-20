package com.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/*
 * 선언부의 타입과 생성부의 타입이 다를 수 있다. - 다형성의 전제조건
 * 다를 경우 생성부에 오는 클래스 타입으로 객체 생성이 일어남.
 * 선언부에 더 상위클래스나 인터페이스가 오면 생성부에 다양한 클래스를 인스턴스화 할 수 있어서 좋다.
 * 예) 코드를 덜 수정하고 요구사항을 만족시킬 수 있다.
 */
public class ListTest1 {
	List nameList = new ArrayList();
	ArrayList aniList = new ArrayList();
	List nameList2 = new Vector();
	Vector aniList2 = new Vector();
	public List setNameList() {
		nameList.add("유재석");
		nameList.add(1, "김종국");
		nameList.add(2, "하하");
		return nameList;
	}
	public List setNameList2() {
		nameList2.add("유재석");
		nameList2.add(1, "김종국");
		nameList2.add(2, "하하");
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
		System.out.println("===[[개선 for문]]===");
		for(Object obj:nameList) {//전체모두 출력할 때
			System.out.println(obj);
		}
	}
	public void printAniList() {
		for(int i=0;i<aniList2.size();i++) {
			System.out.println(aniList2.get(i));
		}
		System.out.println("===[[개선 for문]]===");
		for(Object obj:aniList2) {//전체모두 출력할 때
	//컬렉션프레임워크 클래스는 모두 Object타입을 담는다.
	//제네릭을 사용하지 않는 경우 타입을 따로 맞춰 주어야 한다.		
			String myAni = (String)obj;
			System.out.println(myAni);
		}		
		System.out.println("개가 있어?"+aniList2.contains("dog"));
		System.out.println("그바구니 비어 있어?"+aniList2.isEmpty());
		aniList2.remove("dog");
		System.out.println("===[[개선 for문]]===");
		for(Object obj:aniList2) {//전체모두 출력할 때
	//컬렉션프레임워크 클래스는 모두 Object타입을 담는다.
	//제네릭을 사용하지 않는 경우 타입을 따로 맞춰 주어야 한다.		
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
