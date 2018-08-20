package com.ch7;

public class Inher_01_ChildSimul {

	public static void main(String[] args) {
		
		//아빠 메모리에 로딩하기
		Inher_01_Parent p = new Inher_01_Parent();
		System.out.println("before p.i :"+p.i);//10
		//자녀 메모리에 로딩하기
		Inher_01_Child c = new Inher_01_Child();
		System.out.println("before c.i :"+c.i);//10

		c.i=100;
		System.out.println("after c.i :"+c.i);//100	//자녀의 i상속변수 초기화
		System.out.println("after p.i :"+p.i);//10	//부모의 i는 변하지 않는다!!
		
		//부모의 i(p.i)가 100이 찍히도록 하려면???
		c.i=p.i;
		System.out.println("after2 p.i :"+p.i);//10
							//변하지않은 부모의 i를 넣었으므로 10		
		c.i=100;
		p.i=c.i;
		System.out.println("after3 p.i :"+p.i);//100
							//복제한 부모의 i에 초기화된 상속변수의 값을 넣어 초기화함
		
		//다른방법
		//p = c;//대입연산자를 기준으로 오른쪽이 작은 것(자녀클래스)이 와야함.
		System.out.println("after4 c.1 :"+c.i);//100
		System.out.println("after4 p.1 :"+p.i);//100
		
		
		
		p = c; 
		//위 구문이 없으면 에러가 발생하는 이유? [코드실행중 발생하는 오류 :캐스팅오류]
		//Exception in thread "main" java.lang.ClassCastException:
		//com.ch7.Inheritance_Parent cannot be cast to com.ch7.Inheritance_Child
		//at com.ch7.Inheritance_ChildSimulation.main(Inheritance_ChildSimulation.java:44)
		//자식클래스는 부모클래스에 상속되는 정보를 가지고 있으나,
		//부모클래스는 자식클래스와 상속관계에 있어도 독립적이고 더 큰 집합이다
		//따라서, 인스턴스화한 부모클래스를 인스턴스화한 자식클래스의 주소로 넣기 위해서는
		//반드시 상단의 구문으로 [부모클래스(상위)]에 [자식클래스(하위)]의 주소번지를 넣어주어야
		//아래의 구문에서 [부모클래스(상위)]가 [자식클래스(하위)]로 형변환시킬 수 있는 것이다.
		c = (Inher_01_Child)p;
		c.i = 100;
		System.out.println("after5 c.1 :"+c.i);//100
		System.out.println("after5 p.1 :"+p.i);//100
	}
	
}
