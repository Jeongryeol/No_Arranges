package com.ch13;

import java.util.ArrayList;
import java.util.List;

public class ChefSimul {
	List<Chef> li = null;
	Chef ch1 = null;
	Chef ch2 = null;
	Chef ch3 = null;
	
	public static void main(String[] args) {
		ChefSimul cs = new ChefSimul();
		cs.ch1 = new Chef();
		cs.ch2 = new Chef();
		cs.ch3 = new Chef();
		System.out.println("----인스턴스화 완료----");
		
		cs.li = new ArrayList<Chef>();
		cs.li.add(cs.ch1);
		cs.li.add(cs.ch2);
		cs.li.add(cs.ch3);
		
		for(int i=0;i<cs.li.size();i++) {
			cs.li.get(i);
		}
		
	}
	
}
