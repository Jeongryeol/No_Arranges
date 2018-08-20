package com.chat;

import java.util.ArrayList;
import java.util.List;

import com.ch6.Sonata;
import com.ch7.Encaps_TimeVO;

public class ArrayListTest {

	ArrayList al = new ArrayList();	//< >(Generic)이 사용하지 않아서 경고를 보내는 내용(권장사항)
	ArrayList<String> als = new ArrayList<String>(); //제네릭이 있을때 다른타입 담기는 어떻게 하지?
	ArrayList<Encaps_TimeVO> ald = new ArrayList<Encaps_TimeVO>(); //이렇게 하면 돼!
	ArrayList<Object> alo = new ArrayList<Object>(); //최상위 오브젝트를 제네릭에 써버려서 뭐든 다 때려넣을 수 있어요 ㅋㅋ
	
	List al2 = new ArrayList();		//인터페이스 이름  = new 구현체클래스
	
	List<String> al3 = new ArrayList<String>();	//인터페이스<클래스> 이름 = new 구현체클래스<클래스>();
	List<Sonata> al4 = new ArrayList<Sonata>();

	//List<T>	al5 = new ArrayList<T>();
	//al변수는 제네릭이 없으니까 어떤 타입이든 담을 수 있어요.
	//그런데 꺼내 쓸 때는 어떻게 타입을 알 수 있는 걸까?
	
	public void setList() {
		al.add("하하");
		al.add(new Sonata());
		al.add(10);//al은 제네릭이 없으니 어떤 타입이든 담을 수 있다.
		//즉, 제네릭이 있으면 같은 타입만 담을 수 있다.
		//그런데, 제네릭이 있어도 서로 다른 타입을 담고 싶다.....
/*		als.add("하하");
		als.add(new Sonata());	//그 사물의 정보는... String만 들어있는게 아닌데....
		als.add(10);			//숫자도 담겨야 하는데 ㅠㅠㅠ...
*/		
		//오브젝트를 제네릭으로 했더니 뭐든 다 담을수있어!!!ㅋㅋㅋ
		alo.add("하하");
		alo.add(new Sonata());
		alo.add(10);
		//그런데... 얘네 꺼낼때.. 그게 어떤 타입인줄 알고 담아꺼내지...?
	}

	//다양한 타입으로 꺼낼때 형을 확인하는 방법!
	public void getList() {
		for(int i=0;i<alo.size();i++) {
			if(alo.get(i) instanceof String) {//너 혹시 String타입이니?
				String str = (String)alo.get(i);//String형전환
				System.out.println(str);
			}else if(alo.get(i) instanceof Integer) {//너 혹시 Integer타입이니?
				Integer intg = (Integer)alo.get(i);//Integer형전환
				System.out.println(intg);
			}else if(alo.get(i) instanceof Sonata) {//너 혹스 Sonata클래스 타입이니?
				Sonata myCar = (Sonata)alo.get(i);
				System.out.println(myCar);
			}
		}
	}
	
	//소나타로 실습
	public void setList2() {
		//소나타로부터 3대의 소나타를 만들어보자
		Sonata ysCar = new Sonata();
		Sonata gsCar = new Sonata();
		Sonata bhCar = new Sonata();
		//소나타의 속도들이?? (하나의 클래스가 가지는 같은 변수인데 다른 값을 저장할 수 있다)
		ysCar.speed = 350; //영식자동차는 튜닝으로 차의 속도가 엄청 빠르게 바꿔놓았다
		gsCar.speed = 220; //규성자동차는 이정도로..
		bhCar.speed = 100; //보현자동차는 이정도로..
		//이 3대의 자동차의 초기화된 변수값을 al4에 담아보자
		al4.add(ysCar);
		al4.add(gsCar);
		al4.add(bhCar);
		//담아낸 값을 꺼내는 메소드 getList2()를 얻어보자
		getList2();
	}
	
	public void getList2() {
		//내안에 있는 타입은 Sonata로 모두 같기때문에, instanceof로 타입을 찾을 필요는 없다.
		for(int i=0;i<al4.size();i++) {
			Sonata gnomCar = al4.get(i);
			System.out.println(gnomCar.speed);
		}
	}
	
	public static void main(String[] args) {
		ArrayListTest alt = new ArrayListTest();
/*		alt.setList();
		alt.getList();
*/
		alt.setList2();
		}

}
