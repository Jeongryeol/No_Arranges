package com.ch5;

public class ArrayTest6_ObjectArray2D_StringReverse {
/*
 * 명사형변수.length() 명사형은 배열의 길이, 즉 방의 갯수를 반환하고
 * 동사형변수.length() 동사형은 문자열의 길이를 반환함
 */
	public static void main(String[] args) {
		String msg = "Have a good time!";
		String msg1[] = {"Have", "a", "good", "time"};
		String msg2[] = new String[4];
		//배열[로우번호] = String변수.substring(시작번호,끝번호);
		//선언 혹은 초기화된 String타입의 문자를 시작과 끝을 순서로 담는다.
		msg2[0] = msg.substring(0, 4);
		msg2[1] = msg.substring(5, 6);
		msg2[2] = msg.substring(7, 11);
		msg2[3] = msg.substring(12, 17);
		System.out.println("msg2[0] = "+msg2[0]);
		System.out.println("msg2[1] = "+msg2[1]);
		System.out.println("msg2[2] = "+msg2[2]);
		System.out.println("msg2[3] = "+msg2[3]);
		//문자열의 길이를 출력해볼까?
		System.out.println(msg.length());	
/*
 * 		도전문제
 * 		Have a good time!을
 * 		!eime doog a evaH로
 * 		출력해보시오.
 */
		//****힌트****		
		//for(int i=0;i<msg2.length;i++) {
		for(int i=msg1.length-1;i>=0;i--) {
			System.out.println(msg1[i]);
		}
		System.out.println("\n============================\n");
		
		//문자열 Have를 toCharArray() 메소드를 호출하여 char배열에 담아줌
		char chs[] = "Have".toCharArray();
		for(int i=0;i<chs.length;i++) {
			System.out.println(chs[i]);
		}
		System.out.println("\n============================\n");
		String s = "good";
		for(int i=s.length()-1;i>0;i--) {
			System.out.println(s.charAt(i));
		}
		
		
		
		System.out.println("\n===========출력답안============\n");		
		for(int i=msg1.length-1;i>=0;i--) {
			char msg2p[] = msg1[i].toCharArray();
			for(int j=msg2p.length-1;j>=0;j--) {
				System.out.println(msg2p[j]);
			}
		}

		System.out.println("\n===========고친답안============\n");		
		char msg2p[] = msg.toCharArray();
		for(int i=msg2p.length-1;i>=0;i--) {
				System.out.println(msg2p[i]);
			
		}
		
		//****모범답안****
		String msgA = "Have a good time";
		System.out.println("\n=====[방법1]=====");
		char chsA[] = msgA.toCharArray();
		for(int i=chsA.length-1;i>=0;i--) {
			System.out.println(chsA[i]);
		}
		System.out.println("\n=====[방법2]=====");
		String msgB[] = {"Have", "a", "good", "time"};
		for(int i=msgB.length-1;i>=0;i--) {
			for(int j=msgB[i].length()-1;j>=0;j--) {
				System.out.println(msgB[i].charAt(j));
			}
		}
		
	}

}
