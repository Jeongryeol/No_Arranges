package com.ch6;

public class TVsim_ObjectTest {

	public static void main(String[] args) {
		
		//내 방에 있는 TV로 인스턴스화
		TV_ObjectTest myRoom = new TV_ObjectTest(2,7,30,24); 
		System.out.println(myRoom.channel+", "+myRoom.volume
					 +", "+myRoom.width+", "+myRoom.height);
		
		//부모님 방에 있는 TV로 인스턴스화
		TV_ObjectTest parentRoom = new TV_ObjectTest(0,5,68,45);
		System.out.println(parentRoom.channel+", "+parentRoom.volume
				     +", "+parentRoom.width+", "+parentRoom.height);
				
		//insert here - 아빠방에 TV좀  꺼줄래?
			//[모색방안]인스턴스화 한 부모님 방에 있는 TV 끄기
			//parentRoom.powerOff();
		
		//먼저 부모님방 TV가 켜진 상태로 만들어보려면 어떡하지?
		parentRoom.isPower = true;//인스턴스화된 클래스의 전역변수를 가져와 초기화함

		//혹은 다른방법이 있다면? 메소드 호출하기로??
		boolean tvStatus = parentRoom.powerOff();
		if(tvStatus) {
			System.out.println("부모님방 TV가 켜진 상태");
		}
		else if (!tvStatus) {
			System.out.println("부모님방 TV가 꺼진 상태");			
		}

		//적절한 생성자 만들기
		//만약 해당 인스턴스변수에 생성자가 없으면, 마우스 오버해서 자동완성하는 기능이 있음
		TV_ObjectTest herRoom = new TV_ObjectTest(0,5,true);
		TV_ObjectTest yourRoom = new TV_ObjectTest(true,0,5);
	}

}
