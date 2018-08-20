package com.ch4;
/*return 을 이해하자
 *for문, while문을 중지시키고 싶을때 break
 *if문을 위한 것은 return!!
 */
public class ControlSt_Test6_if_return {

	public static void main(String[] args) {
//		다른 클래스가 소유한 메소드를 호출할 때 - 인스턴스화
//		다른 방법이 있다. static
//		메소드 앞에 static이 있으면 인스턴스화 없이도 가능하다.
		//args = new String[1];
		//null은 아래와 같이 사용됨
		String myName = null;
//		아래 12번에서 NumberFormatException이 발생함.
//		왜냐면 디폴트가 null이므로 숫자타입으로 변경이 불가능하기 때문에...
		int user = Integer.parseInt(args[0]);//args는 변수가 아닌 배열이다. 즉 값이아닌 주소번지가 나온다. 현재 args는 지역변수인 상태임.
//		버그에 위험이 있는 상태.
		//insert here - 버그를 피할 수 있는 코드를 추가해 보세요.
		if(args==null) {
			return;//그 다음의 코드는 멍때리고 있는 상태일테니 if문과 break를 이용해서 멈추는 것.
		}//return은 main method를 탈출함.
		if(args[0].length()==1) {//너 한자리 숫자만 입력한거야?
			char ch = args[0].charAt(0); 
			if(ch>=48 && ch<=57) {//유니코드 범위값 ::참고::  http://www.bluene.net/blog/359
				user = Integer.parseInt(args[0]);
			}
			else {
				System.out.println("숫자만 입력하세요.");
				return;//return은 main method를 탈출함.
			}
		}
		System.out.println("사용자가 입력한 숫자 : "+(user+3));
		//너 숫자를 입력한거니?
		char ch = 1;//char type은 한칸짜리 알파벳이나 숫자 둘다 입력받을 수 있음.
		System.out.println(ch>=0);
		System.out.println('C'>'B');
		
		System.out.println(Integer.parseInt("10"));				
// 		System.out.println(Integer.parseInt("true"));//숫자로 바꿀수있는 문자열타입이 아님		
//		System.out.println(Integer.parseInt("회식"));//상동	
//		System.out.println(Integer.parseInt(null));//객체가 할당되기 전이므로 문제가 됨

	}

}
