package com.ch13;

/**************************************************************
 * [등장인물]
 ***제빵사(ThreadCntl_Baker.java) 
 *  제빵사에 쓰레드를 구현했다면, run()메소드에서는 무엇을 처리해야할까?
 ***진열대(ThreadCntl_BreadStack.java)
 * 	진열대에서 빵을 추가하거나 빵을 꺼내는 행위에 필한 메소드를 선언해세요.
 * 	실제로 빵을 진열하는데 필요한 클래스는 누가 좋을까?
 ***고객	(ThreadCntl_Customer.java)
 * 	만일 고객에 쓰레드를 적용했다면, run메()메소드에서는 어떤 일을 처리해야할까?
 **************************************************************
 * [테스트]
 * -테스트클래스(ThreadCntl_Simulation.java)
 *  위 테스트 시나리오에 따라 시뮬레이션클래스에서 테스트에 필요한 쓰레드 갯수를 정해보시오.
 *  위 테스트 시나리오에서 동기화가 필요한 부분이 있는지 생각해보고, 필요하다면 적용해보세요.
 **************************************************************
 * 빵정보는 String에 담기로 한다.
 * 빵종류 3가지를 선정해보자
 * 제빵사가 만드는 빵을 랜덤하게 결정해보자
 * 
 * 어떤 클래스를 Thread로 해야할지 결정해 보자.
 **************************************************************/
public class ThreadCntl_Customer extends Thread {

	//빵은 진열대에서 꺼내는것이니 진열대가 필요
	private ThreadCntl_BreadStack bs = null;
	String bread = null;
	
	public ThreadCntl_Customer(ThreadCntl_BreadStack bs,String bread) {
		this.bs = bs;
		this.bread = bread;
	}
	
	//돈만 가져와서 원하는 빵만 주문하기 때문에 run()메소드만 있으면 된다.
	@Override
	public void run() {
		String bread = null;
		//저 빵 주세요(그런데, 새치기 당할 수 있다.)
		bs.pop("도너츠");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("이색히!! 내 빵~~~~");
		}
	}
}
