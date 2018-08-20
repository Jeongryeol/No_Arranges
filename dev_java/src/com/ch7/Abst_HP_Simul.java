package com.ch7;

public class Abst_HP_Simul {
	public static void main(String[] args) {
		//추상클래스는 단독으로 인스턴스화 할 수 없다. :: 구현체 클래스가 반드시 필요함.
		//Abst_HP hp = new Abst_HP();
		
		//선언부와 생성부의 이름이 다르다. (다형성이 가능하다.)
		//아래와 같은 형태로 추상클래스를 구현체클래스로 다형성을 적용하여 호출 가능하다.
		Abst_HP hp = new Abst_iPhone();
		hp.call();	//추상메소드를 iPhone에서 구현하였다.
		hp.view();	//추상메소드를 iPhone에서 구현하였다.
		hp.off();	//일반메소드를 소유할 수 있다. - 추상클래스가...
		
		hp = null; //null(없다.)
		//iPhone이 Candidate상태로 빠진다. (즉시 삭제되는건 아니다.)
		//그럼 언제 삭제되는가? Garvage Collector : System.gc() 직접 호출 가능
		hp = new Abst_Galaxy();//다시 인스턴스화 한다.
				
	}
	
}
