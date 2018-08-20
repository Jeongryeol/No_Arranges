package com.ch13;

import java.util.Vector;

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
public class ThreadCntl_BreadStack {//자원으로, Baker와 Customer가 접근하므로, 변수가 선언될 클래스

	//진열대에 올릴 빵의 칸 10개 확보
	private Vector<String> vec = new Vector<String>(10);
	
	//빵을 가져가는 메소드 구현
	//멀티스레드일때 안전하게 하기위해  synchrinized
	public synchronized String pop(String cBread) {//고객이 원하는 빵을 가져감
		String bread = null;
		//빵이 있을때 - 
		if(vec.size()>0) {
			vec.remove(bread);//벡터에서 빵을 꺼내자
		}
		//빵이 없을때 - 기다려...wait(), sleep(), suspend()...
		else if(vec.size()==0) {
			try {
				System.out.println("빵이 없습니다. 잠시만 기다려주세요.");
				//동기화코드(Synchonized-code)에서 DeadLock상태를 방지하는 wait
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return bread;
	}
	//빵을 진열하는 메소드
	public void push(String bBread) {//제빵사가 만든 빵을 진열함
		//빵이 나왔음을 알려서 잠자는 쓰레드를 깨우자... interrupt(), notify(), notifyAll()
		this.notify();
		//Vec에 빵을 추가하자(add)
		vec.add(bBread);
	}
}
