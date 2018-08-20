package com.ch13;

//Thread를 상속받았으므로 T1 메소드 1개 / 총2개
public class T1 extends Thread{
	int i = 0;
	//대기했던 run()메소드가 작동한다
	public void run() {
		System.out.println("run");
	}
	//main Thread 1개 / 총2개
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();//run()메소드가 대기한다
		System.out.println(t1.i);//출력한다
	}
}      