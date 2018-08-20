package com.ch13;

//요리사가 3명인 식당의 주방 내에서 서비스하는 요리를 구현해보자
public class Chef extends Thread{
	
	public Chef() {
		start();
	}
	
	public void run() {
		String food = null;
		System.out.println("run메소드 호출");
		System.out.println("--------------");
		for(int i=0;i<5;i++) {
			food = getFood();//랜덤한 음식을 담아봄
			System.out.println("Chef "+i+" 서빙 :"+food);
			try {
				this.sleep(i*500);//mili-sec 단위
			}catch (InterruptedException e) {//쓰레드에 대한 예외
				 System.out.println("앗 누구냐 넌!!!! (인터셉트가 일어났다)");
			}
		}
		System.out.println("--------------");
	}
	
	//음식을 제공하는 메소드
	public String getFood() {
		String food = null;
		//무엇을 주문할 지 모르니 난수를 발생시켜본다
		switch((int)(Math.random()*3)) {
		case 0:
			food = "족발";
			break;
		case 1:
			food = "몬스터와퍼";
			break;
		case 2:
			food = "육회";
			break;
		}
		return food;
	}
	
}
