package com.base;
/*****************************************************************************************************************
 * 변수는 선언 위치에 따라 사용할 수 있는 범위가 달라지기도 합니다.
 * 선언부에 선언하면 전역변수(global variable, member variable)
 * 메소드 안에 선언하면 지역변수(local variable, automatic variable)
 * @author kosmo0
 *****************************************************************************************************************/
public class W01_B3_Hp {
	//선언부 - 변수를 선언할 수 있다. ■■변수를 사용하는 이유는 해당내용과 변수를 기억하기 위해서!!
	//□□변수 선언시 타입앞에 final이 오면 상수선언이 되고
	//□□static이 오면 static타입의 변수가 되어서 클래스 생성(5장에서...)없이도 사용할 수 있고
	//□□또 static영역안[ 메인메소드 ]에서도 사용할 수 있어요.
	//□□□□메인메소드는 가상머신이 정의하고있는 것으로 static 없이 메인메소드가 될 수 없음.
	boolean isOk = false;
	//false는 default값 : 초기화를 생략하면 [가성머신이] 자동으로 할당되는 값을 설정해둔다.
	//■■변수이름앞에 is가 붙어있다면 boolean을 생각하고 있다고 판단 
	//클래스안에 메소드가 올 수 있다. - 파란색
	public static void main(String[] args) {
	
			boolean isFlag = false;
			System.out.println("isFlag : "+isFlag);//true를 출력할걸...
			//현재 여러분이 가지고 있는 핸드폰의 전원상태를 코드로 작성해 보세요.
			String status1 = "ON";
			String status2 = "OFF";
			String status3 = "A";
			
			System.out.println("현재 나의 핸드폰은 "+isFlag+" 상태이다.");
			System.out.println("현재 나의 핸드폰은 "+status2+" 상태이다.");
			//만일 isFlag가 ture이면 ON을, flase이면 OFF를 출력하고 싶다면 어떡하지? IF문을 사용해서 처리할 수 있어요.

			if(isFlag) {
				status3 = "ON";
				System.out.println("현재 내 폰은 "+status3+" 상태이다.");
			}
			else {
				status3 = "OFF";
				System.out.println("현재 내 폰은 "+status3+" 상태이다.");
			}
			
			//여기에 isOk변수에 들어있는 값을 출력할 수 있다 | 없다. → 없다.
			//만일 출력할 수 없다고 생각한다면 이유는 뭐지?
			//■■why? isOk는 non-static타입으로 static영역인 main메소드 안에서 접근할 수 없다.
			//isOk변수에 값을 출력하고 싶다면 어떡하지?
			//■■접근하고자한다면 static boolean isOK = false; 로 초반부에 선언되었어야 한다.

	}

	void methodA() {
		System.out.println("isOk : "+isOk);
	}
	
}