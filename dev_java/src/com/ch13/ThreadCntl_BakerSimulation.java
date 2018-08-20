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
public class ThreadCntl_BakerSimulation {//테스트용 시뮬레이션 클래스

	public static void main(String[] args) {
		ThreadCntl_BreadStack bs = new  ThreadCntl_BreadStack();
		ThreadCntl_Baker ba1 = new ThreadCntl_Baker(bs);
		ba1.start();
		ThreadCntl_Baker ba2 = new ThreadCntl_Baker(bs);
		ba2.start();
		ThreadCntl_Baker ba3 = new ThreadCntl_Baker(bs);
		ba3.start();
		ThreadCntl_Customer cus1 = new ThreadCntl_Customer(bs,"티라미스");
		cus1.start();
		ThreadCntl_Customer cus2 = new ThreadCntl_Customer(bs,"몬스터와퍼");
		cus2.start();
		ThreadCntl_Customer cus3 = new ThreadCntl_Customer(bs,"도너츠");
		cus3.start();		
	}
	
}
