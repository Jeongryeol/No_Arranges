package com.ch3;

public class W02_D1_ExcerciseTest {

	public static void main(String[] args) {
		/*연습문제 1번
		Which two are legal String declarations? (Choose two.)*/
		String a1 = null;//[올바른 표현]//String s = null;s를 print 하면 null 이라고 출력되네?
		String a2 = "aa";//[오답을 수정한 표현]//String s = 'aa'; (더블쿼테이션이 필요한 JAVA)
		String a3 = (String)"abc";//[오답을 수정한 표현]//String s = (String)'abc';(더블쿼테이션이 필요한 JAVA)
		String a4 = "This is a string";//[올바른 표현] 
		String a5 = "This is a very\nlongstring";//[오답을 수정한 표현]//역슬러쉬n 은 한줄미는 기능으로, 문장내에서 기입후 마무리(;)되어야함
		
		//★★★★★★★★★★중요 체크포인트★★★★★★★★★★
		//System.out.println(a1.toString());//[에러코드]
		//객체가 null인 상태로 만들어지지 않은 상태이기때문에,
		//NullPointException 에러 발생하게 됨 (문법상에선 문제가 없음)
		
		/*연습문제 2번
		Which two are valid declarations of a boolean? (Choose two.)*/
		//boolean b1 = 0;//true나 false 값만 담을 수 있는 boolean
		boolean b1 = true;//[올바른표현]//상동
	    //boolean b2 = "true";//문자열은 담을 수 없음
		//boolean b3= 'true';//문자열은 담을 수 없고, 문자열은 더블 쿼테이션이 필요함
		boolean b4 = (3 >= 0);//[올바른 표현]//비교연산을 한 값에 대한 true false가 입력됨
		boolean b5 = Boolean.TRUE;
		
		//★★★★★★★★★★중요 체크포인트★★★★★★★★★★
		/*boolean isFlag;//[에러코드]
		System.out.println(isFalg);//[에러코드] 변수의 초기화를 해두지 않았기 때문에 문법에러 발생

		boolean isFlag;
		isFlag=false;
		System.out.println(isFlag);//[에러코드]//혹은
		
		boolean isFlag=false;
		System.out.println(isFlag);//[에러코드]
		*/
			
		//★★★★★★★★★★중요 체크포인트★★★★★★★★★★
		/*원시형 타입은 변수나 메소드를 거느릴수 없다.
		 boolean bb1;
		 bb1 = true 
		 System.out.println(bb1.toStinf());//[에러코드] 값만 담은 원시형타입은 값만 담을 수 있다. 
		 Boolean boo = new Boolean(true);//단,원시형 타입 변수가 메소드를 받는 경우 : Wrapper 클래스 (클래스급)
		 System.out.println(boo.toString());//가능
		 */ 
			
		//★★★★★★★★★★중요 체크포인트★★★★★★★★★★
		//int와 inteager의 관계는 변수와 클래스 간의 관계지만, 1.5버전 이후로 자동형변환을 되도록 업데이트 되어 있음.
		
		/*Integer ing = new Integer("50");//클래스급 Integer & 자동형전환으로 문자열을 숫자열로 바꾸어서 int화 해줌
		System.out.println(ing+10);//형전환된 값으로 연산함
		 
		Interger ing2 = ing.valueOf("60");//일반적으로 변수 ing는 메소드valueOF()를 거느릴순 없지만,
		//Integer에 의해 클래스급으로 올라간 Wrapper 클래스이므로 가능 
		 
		Interger ing3 = new Integer("70");@abcd1234
		Interger ing4 = new Integer("70");@abcd1234
		System.out.println(ing3 == ing4);//두 변수의 주소번지를 비교한 것이기 때문에, false 가 나옴
		System.out.println(ing3.equal(ing3));//두 변수를 값으로서 비교한 것이기 때문에, true 가 나옴 :: 변수.equal(변수)*/

		
		Integer c1 = new Integer(10); //new에 의해 다른 객체가 만들어 짐
		Integer c2 = new Integer(10);
		Integer c3 = c1;//c1과 같은 객체를 담고 있으므로 같은 주소번지를 담음
		int c4 = 10;
		double c5 = 10.0;

		/* (c1 == c3) true // 클래스와 클래스를 비교하면 담고있는 주소번지를 비교하게 됨 (같은 객체 지향함)
		 * (c4 == c5) true // 변수와 변수를 비교하면 담고 있는 값을 비교하게 됨 (정수10과 실수10.0을 비교함)
		 * (c2 == c4) true // 클래스객체와 변수를 비교하면 담고있는 값을 비교하게 됨
		 * (c1 == c2) false// 클래스와 클래스를 비교하면 담고있는 주소번지를 비교하게 됨 (다른 객체를 담음) 
		 * (c2 == c3) false// 클래스와 클래스를 비교하면 담고있는 주소번지를 비교하게 됨 (다른 객체를 담음)
		 * (c4 == 10.0)true// 변수와 값을 비교하면 담고 있는 값을 비교하게 됨 (정수10과 10.0을 비교함)
		 */
		
		Integer cc1 = new Integer(10);
		Integer cc2 = new Integer(10);
		System.out.println(cc1=cc2);//Wrapper Class의 주소번지를 비교하므로 false가 출력됨
		System.out.println(cc1.equals(cc2));//Wrapper Class급 변수 cc1이 equal()메소드를 거느리고 cc2를 호출함. 값비교함 true
		Integer cc11 = new Integer(10);
		Integer cc22 = new Integer(100);
		System.out.println(cc11==cc22);//주소번지를 비교하므로 false가 출력됨
		System.out.println(cc11.equals(cc22));//주소번지가 가르키는 값을 비교흐므로 false가 출력됨.
		Integer cc0 = cc1;//변수 C의 경우 new를 써서 클래스를 메모리에 로딩한 게 아니라 기존에 있는 클래스를 가르킴. 그래서 true
		System.out.println(cc1==cc0);//주소번지가 같은지 비교하므로 true가 출력됨
		int dd = 10;  	 //비교대상이 한쪽은 주소번지 다른 한쪽은 원시형인 경우 d는 주소번지가 없으므로 다 해당되는 값을 비교하게 됨
		double ee = 10.0;//int 타입도 10.0까지는 밭아주므로 double타입과 같은 값으로 true가 출력됨.
		System.out.println(dd==ee);		

		
		
		System.out.println(6^3);
		
		String s11 = new String("true");
		Boolean b11 = new Boolean(true);
		if(s11.equals(b11)) { ///변수.equals(문자열)
		System.out.println("%nEqual");
				
		}
		
	}

}
