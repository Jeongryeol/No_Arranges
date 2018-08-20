package com.base;
/**************************************************************
 * CarSimulation클래스 안에서 Tivoli클래서의 정의된 변수나 메소드를 사용하고 싶을땐
 * 사용하고 싶은 클래스를 선언하고 생성하면 이용할 수 있어요.
 * Tivoli herCar = new Tivoli();
 * Tivoli myCar = new Tivoli();
 * Tivoli yourcar = new Tivoli();
 * Tivoli 타입의 자동차 3대 만들어 줌
 * 3대의 자동차는 타입은 같지만 서로 다른 자동차니까 3사람이 이용할 수있죠.
 * 붕어빵을 구매하면 같은 모양의 붕어빵이 한 번에 3마리씩 만들어 지는데
 * 모양이 같은 것일 뿐 각가 개별적인 객체이어서 친구와 나누어 먹을 수 있죠.
 * 자바에서는 이렇게 같은 타입의 클래스를 쉽게 여러 개 복제본을 만들어 낼 수 있어요.
 * 그러나 모양만 같은 것일 뿐 서로 다른 클래스라고 생각해야 될 것 같아요.
 * 5장에서 다시 이야기해 봅시다...
 **************************************************************/
public class W01_C2_CarSimulation {

	public static void main(String[] args) {
		//변수 himCar는 참조형 변수임
		W01_A1_Sonata himcar = new W01_A1_Sonata();
		System.out.println(himcar);
		//변수 herCar는 참조형 변수임
		W01_B4_Tivoli herCar = new W01_B4_Tivoli();//new를 이용해서 다른 클래스의 static 속에 정의된 내용을 가져올 수 있다.
		System.out.println(herCar);
		String myName = "이순신";
		System.out.println(myName);//주소 번지가 아니라 이순신을 출력함
		System.out.println(herCar.speed);
		

	}

}
