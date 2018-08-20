package com.ch7_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.ch6.Sonata;
import com.oracle.jdbc.EmpVO;

public class InterfaceTest {
	//사용자정의메소드 : 현재는 관계가 없으므로 오버로딩만 생각
	public void setSonataList(Vector<String> nameList) {//구현체클래스를 파라미터로
		nameList.add("NF 소나타");
		nameList.add("2017년형 소나타");
		nameList.add("2018년형 소나타");
	}
	public void setSonataList(ArrayList<String> nameList) {//구현체클래스를 파라미터로
		nameList.add("그녀의 소나타");
		nameList.add("그놈의 소나타");
		nameList.add("당신의 소나타");
	}
	public void setSonataList(List<String> nameList) {//인터페이스를 파라미터로
		nameList.add("이코노미 소나타");
		nameList.add("2.4소나타");
		nameList.add("2.5소나타");
	}
	//중요채팅용 메소드 코딩 (Sonata자리에 Thread를 꽂아 넣어야할것이다)
	public void setSonataList2(List<Sonata> nameList) {
		//메소드 오버로딩할때 파라미터의 제네릭타임(<>)은 영향이 없기 때문에, 메소드이름에 2가 없으면 오버로딩 중복선언에 해당된다.
		Sonata myCar = new Sonata();
		nameList.add(myCar);
		Sonata herCar = new Sonata();
		nameList.add(herCar);
		Sonata himCar = new Sonata();
		nameList.add(himCar);
	}
	public void setSonataList3(List<EmpVO> nameList) {
		//메소드 오버로딩할때 파라미터의 제네릭타임(<>)은 영향이 없기 때문에, 메소드이름에 2가 없으면 오버로딩 중복선언에 해당된다.
		EmpVO empno1 = new EmpVO();
		nameList.add(empno1);
		EmpVO empno2 = new EmpVO();
		nameList.add(empno2);
	}
	//메인메소드
	public static void main(String[] args) {
		//사용자정의메소드 3종을 호출해보자
		InterfaceTest ift = new InterfaceTest();
		Vector<String> nameList = new Vector<String>();
		ArrayList<String> nameList2 = new ArrayList<String>();
		List<String> nameList3 = new ArrayList<String>();
		System.out.println("───────────────────────────────────────────────────────────────────────────");
		ift.setSonataList(nameList);
		for(String carName:nameList) {//개선형 for문 사용해서 확인해보자
			System.out.println("Vector[멀티스레드 안전-속도느림]: "+nameList);
		}//원본을 사용하기때문에 리턴타입(void)에 관계없이 출력가능함
		System.out.println("───────────────────────────────────────────────────────────────────────────");
		ift.setSonataList(nameList2);
		for(String carName:nameList2) {//개선형 for문 사용해서 확인해보자
			System.out.println("ArrayList[싱글스레드 안전-속도빠름]: "+nameList2);
		}//원본을 사용하기때문에 리턴타입(void)에 관계없이 출력가능함
		System.out.println("───────────────────────────────────────────────────────────────────────────");
		ift.setSonataList(nameList3);
		for(String carName:nameList3) {//개선형 for문 사용해서 확인해보자
			System.out.println("List [Vector도 ArrayList도 다 받아준다] : "+nameList3);
		}//원본을 사용하기때문에 리턴타입(void)에 관계없이 출력가능함
		System.out.println("───────────────────────────────────────────────────────────────────────────");
	}

}
