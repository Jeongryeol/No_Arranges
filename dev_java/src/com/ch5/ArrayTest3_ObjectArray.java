package com.ch5;

import com.base.W01_A1_Sonata;
//타 패키지의 클래스를 불러올때, 불러올 클래스 내부의 main 메소드가 public 이면 불러올수 있고, import로 먼저 선언하는것이 코딩에 유리하다.
public class ArrayTest3_ObjectArray {

	public static void main(String[] args) {
		W01_A1_Sonata cars[] = new W01_A1_Sonata[24];//클래스를 복제 및 인스턴스화해서 배열로 지정함
		W01_A1_Sonata yjdCars = new W01_A1_Sonata();//클래스를 복제 및 인스턴스화해서 변수로 지정함 (참조된 클래스이므로 주소번지값 보유)
		cars[0] = yjdCars;//복제된 배열 0번방에 복제된 변수를 입력함
		for(int i=0;i<cars.length;i++) {
			System.out.println(cars[i]);//0번방에 복제된 변수의 원래 주소번지가 출력됨
		}

	}

}
