package com.ch7;

import com.base.W01_A1_Sonata;
import com.base.W01_A3_Pen;

public class ReturnTest {
	//리턴타입이 오브젝트인 경우를 이해하라!!
	public Inher_06_Sonata getMycar() {
		//insert here
		Inher_06_Sonata myCar = new Inher_06_Sonata();
		return myCar;
	}
	public W01_A3_Pen getMyPen() {
		//insert here;
		W01_A3_Pen myPen = new W01_A3_Pen();
		return myPen;
	}
	//각 변수를 클래스단위로 묶어둠. 변조가 가능할까?
	
	public static void main(String[] args) {
		ReturnTest rt = new ReturnTest();
		rt.getMycar();
		rt.getMyPen();
		Inher_06_Sonata herCar = rt.getMycar();
		herCar.speedUp();
	}

}
