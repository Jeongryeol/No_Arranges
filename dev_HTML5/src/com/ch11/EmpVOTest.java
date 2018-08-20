package com.ch11;

import com.vo.VO_FoodStore;

public class EmpVOTest {

	public static void main(String[] args) {
		VO_FoodStore evo = new VO_FoodStore();
		System.out.println(evo);
		evo = new VO_FoodStore();
		System.out.println(evo);
		evo = new VO_FoodStore();
		System.out.println(evo);
		evo = new VO_FoodStore();
		System.out.println(evo);
		evo = new VO_FoodStore();
		System.out.println(evo);
		System.out.println("--------------------------");
		System.out.println("같은 이름이라도 다른 주소번지를 가지고 있다.");
		System.out.println("하나의 row만 담을 수 있는 evo를 여러개 생성해야하므로 while문 안에 있어야 한다.");
	}

}
