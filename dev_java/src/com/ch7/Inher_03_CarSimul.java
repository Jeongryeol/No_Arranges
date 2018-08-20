package com.ch7;

public class Inher_03_CarSimul {

	public static void main(String[] args) {
		System.out.println("부모타입으로 자식클래스를 인스턴스화 했습니다.");
		Inher_03_Suv car = new Inher_03_Sorento();
		System.out.printf("3....2....1....%n테스트를 시작합니다!%n");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("Step.1 / 부모클래스의 전역변수 초기화하기");
		car.speed = 30;
		System.out.println("car.speed = "+car.speed);//예상 30 SUV++출력
		System.out.println("※ 인스턴스변수 car는 부모클래스 타입에 자식클래스의 주소를 넣은 것으로, 부모클래스의 speedUp가 있습니다.");
		System.out.println("car.speedUp()의 결과 ");
		car.speedUp();//예상 30 SUV++출력
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("자식타입으로 자식클래스를 인스턴스화 했습니다.");
		Inher_03_Sorento car2 = new Inher_03_Sorento();
		System.out.println("Step.2 / 자식클래스의 전역변수 초기화하기");
		System.out.println("초기화 전 자식클래스의 carColor = "+car2.carColor);//예상 Matt-Black
		//car.carColor = "Deep-Blue" //에러발생 : 부모클래스에는 carColor 변수가 없음
		System.out.println("<에러>car.carColor = Deep-Blue //에러발생 : 부모클래스에는 carColor 변수가 없음");
		System.out.println("<초기화>car2.carColor = Deep-Blue");//예상 Matt-Black
		car2.carColor = "Deep-Blue";
		System.out.println("초기화 후 자식클래스의 carColor = "+car2.carColor);//예상 Matt-Black
		System.out.println(" ");
		System.out.println("※ 인스턴스변수 car는 부모클래스 타입에 자식클래스의 주소를 넣은 것으로, carColor가 없습니다.");
		System.out.println("※ 인스턴스변수 car2는 자식클래스 타입에 자신의 주소를 넣은 것으로, carColor가 있습니다.");
		
	}

}
