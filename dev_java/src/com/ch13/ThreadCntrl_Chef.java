package com.ch13;

public class ThreadCntrl_Chef extends Thread{
	
	//나는 run메소드에 무엇을 코딩할 지를 알고 있다|없다.
	public void run() {
		String food = null;
		System.out.println("run메소드 호출");
		for(int i=0;i<5;i++) {
			food=getFood();
			System.out.println("Chef("+Thread.currentThread().getName()+")===>"+food);
			try {
				this.sleep(2000);//밀리세크 단위
			} catch (InterruptedException ie) {
				System.out.println("앗~~~~ 누구냐!! 넌....");
			}
		}
	}
	//음식을 제공하는 메소드
	public String getFood() {
		String food = null;
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
