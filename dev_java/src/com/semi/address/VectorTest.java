package com.semi.address;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector v = new Vector();
		AddressVO avo = new AddressVO();
		avo.setA_name("이순신");
		v.add(avo);//이순신저장
		System.out.println(avo);
		avo = new AddressVO();
		avo.setA_name("김유신");
		v.add(avo);//김유신저장
		System.out.println(avo);
		avo = new AddressVO();
		avo.setA_name("이성계");
		v.add(avo);//이성계저장
		System.out.println(avo);
		//insert here
		System.out.println(avo.getA_name());
		//Vector는 add메소드를 호출하면 방이 하나씩 늘어나고 삭제하면 하나씩 줄어듬
		//Vector의 방의 수를 출력해 보면
		System.out.println("Vector의 방의 갯수는 "+v.size());
		System.out.println("===================================");
		//Vector에 들어있는 주소번지 3개 출력해 보기
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
			AddressVO ravo = (AddressVO)v.get(i);
			System.out.println(((AddressVO)v.get(i)).getA_name());
			//System.out.println((AddressVO)v.get(i).getA_name());에러
		}
		int i=(int)3.5;
	}

}






