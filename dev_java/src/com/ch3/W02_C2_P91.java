package com.ch3;

public class W02_C2_P91 {

	public static void main(String[] args) {
		//단항연산자
		//증가연산자(++), 감소연산자(--)
		/*
		 * x+=1; 은 x=x+1와 같은 의미입니다.
		 * ++x;도 x=x+1과 같은 의미입니다.
		 * 다만 x++로도 사용할 수 도 있는데
		 * 앞에 있으면 먼저 1을 더하고, 뒤에 있으면 나중에 1을 더합니다.
		 */
		int x = 2;//여기서 x는 2였으나
		int y = ++x;//여기서 x 앞에 증감연산자가 왔으므로 1을 더한 값을 변수y에 대입하고 자신도 1 증가하게 돕니다.
		//전위연산자 : 앞위치에서 참조되기전에 1을 더한다
		//insert here x=2?, y=3
		System.out.println("x = "+x+", y = "+y);// x=3, y=3???
		
		x = 2;//여기서 x는 2였으나
		y = x++;//
		//후위연산자 : 뒷위치에서 먼저 참조된후에 1을 더한다
		//insert here x=2?, y=3?
		System.out.println("x = "+x+", y = "+y);// x=3, y=2???

	}

}
