package com.ch7;

class Test1 {}//메소드 앞에는 static을 쓸 수 없음. 

public class Modifier_01_StaticTest {

	//static은 쓰지 말아야함. 2년차부터 사용할때 별도로 찾아보세요.
	//static 메소드앞, 변수앞
	static int i = 10;//공유, 한개(원본), 우선순위 높다. 
	
	static {//static 블럭 (거의 사용되지 않음)
		System.out.println("static 블럭이 먼저일껄?");
	}
	
	//main - main thread(우선순위가 높다-순서/시간조절/경합) - entry point
	public static void main(String[] args) {
		System.out.println("static main 메소드가 나중일거야");
	}

}
