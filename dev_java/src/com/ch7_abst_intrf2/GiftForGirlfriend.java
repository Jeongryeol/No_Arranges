package com.ch7_abst_intrf2;

public class GiftForGirlfriend extends The_Gift implements Heart, Thanks {
	@Override//추상클래스를 상속받은 구현체클래스는 모든 추상메소드의 몸통{}을 규정해주어야한다.
	public void include(int contain) {
		this.contain = contain;//상속받은 부모의 변수에 파라미터로 받은 변수값으로 초기화시킨다.
		System.out.println("야생의 include() 메소드가 실행되었다!!...");
		System.out.printf("[새소식]상자에  %d개의 선물을 담았습니다!^^♥%n",contain);
		System.out.println("──────────────────────────────────");
		
	}
	@Override//추상클래스를 상속받은 구현체클래스는 모든 추상메소드의 몸통{}을 규정해주어야한다.
	public boolean wrapPattern(String pattern) {
		this.isRibon = true;
		System.out.println("야생의 wrapPattren() 메소드를 오버로드한 메소드가 실행되었다!!... @param : String pattern");
		System.out.println("[새소식]상자의 패턴은 '"+pattern+"'무늬이다.");
		System.out.println("────────────────────────────────────────────────────────────────────────────");
		return isRibon;
	}
	//오버로드
	public boolean wrapPattern() {return isRibon;}
	@Override
	public void give() {System.out.println("나는 그녀에게 내 마음을 담은 선물을 주었습니다~♡");}
	@Override
	public void take() {System.out.println("그녀는 나에게 많은 것을 주었습니다~♥");}
}
