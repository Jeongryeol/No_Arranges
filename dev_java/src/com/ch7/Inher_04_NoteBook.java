package com.ch7;

public class Inher_04_NoteBook extends Inher_03_Sorento{
	//Object타입을 선택할 수 있다.
	public boolean isTyupeCheck(Inher_04_NoteBook nb) {
		boolean isOk = true;
		//instanceof 연산자에 대해 알아보시오.
		if(nb instanceof Inher_04_NoteBook) {
			isOk = true;
		}
		else if (nb instanceof Inher_03_Sorento) {//왜 컴파일 에러인가?
			
		}
		//nb는 NoteBook 타입이지 Sorento타입이 아니므로 컴파일에러가 발생함.
		//instanceof는 인스턴스변수가 누구 타입인지를 비교하는 연산자임.
		return isOk;  
	}
	
	@Override
	public String toString() {
		return "나는 삼성노트북입니다.";
		//toString은 상속관계를 정의하지 않아도 기본적으로 적용되는
		//조상클래스 Object의 메소드 중 하나로, 오버라이드로 재정의하여 사용가능하다.  
	}
	
	public static void main(String[] args) {
		Inher_04_NoteBook nb = new Inher_04_NoteBook();
		System.out.println(nb.toString());
		
		boolean isOk = nb.isTyupeCheck(nb);
		if(isOk) {
			System.out.println("나는 NoteBook타입이 맞습니다.");
		}else {
			System.out.println("나는 NoteBook타입이 아닙니다.");
		}
	}
}
