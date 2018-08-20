package com.ch6;
/*
 * 나는 생성자를 선언할 수 있다.
 * 나는 내가 필요한 생성자를 호출 할 수 있다.
 * 생성자는 리턴타입이 없다.
 */
public class Constructor_Card {

	int j;
	
	Constructor_Card() {
		int j = 1;//지역변수
		//this는 자기자신 클래스를 가리킬 때 사용하는 예약어
		//this가 붙은 i는 전역변수에 있는 변수 j를 가리키는 것, 대입연산자 옆의 j는 지역변수 j임.
		this.j = j;//전역변수에 지역변수의 값으로 초기화하는 것
		//이 연산이후에는 지역변수 j의 값이 전역변수 j의 값에 영향을 미쳐 전역에서 사용가능해짐.
		System.out.println("디폴트생성자");
		System.out.println("");
	}

	Constructor_Card(double d) {
		System.out.println(d+"가 호출되었습니다.");
		System.out.println( "파라미터가 double인 생성자");
		System.out.println("");
	}

	Constructor_Card(int i) {
		System.out.println(i+" 호출되었습니다.");
		System.out.println("파라미터가 int인 생성자");
		System.out.println("");
	}

	Constructor_Card(String wt, int qt) {//사용자 정의 생성자 (매개변수를 자유롭게 추가 가능)
		System.out.println(wt+" "+qt+"명 호출완료되었습니다.");
		System.out.println("파라미터가 2개인 생성자");
		System.out.println("");
	}

	void Card() {//사용자 정의 메소드 (매개변수를 자유롭게 추가 가능)
	}
	
	public static void main(String[] args) {
		new Constructor_Card(10);
		new Constructor_Card("사람",1);

		Constructor_Card replicaCard = new Constructor_Card();
//		replicaCard.Card();
		
		new Constructor_Card(replicaCard.j);
		
		System.out.println(replicaCard.j);
	}

}
