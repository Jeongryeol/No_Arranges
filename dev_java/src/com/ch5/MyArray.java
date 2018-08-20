package com.ch5;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//변수 ~ 배열 ~ 자료구조
/*
 * 키보드로부터 5개의 정수를 입력받아서 배열에 저장하세요.
 * 그리고 이들의 합계와 평균을 출력하세요.
 * 
 * 문제제기
 * 어~~? 사용자가 입력한 값은... String타입이었던것같은데.. 합계는 int타입인데? 어떡하지??
 * 해결방법
 * String을 int타입으로 바꾸어야하는데..  >>  String -> int  >> Integer.parseInt( )
 * 
 * 문제해결을 위한 실마리 :: int배열이 필요할 것 같아.
 * 
 * @param	input 	- 5개 정수를 받아서 담을 변수 ( 배열 - String )
 * @return	sum 	- 5개 정수의 합을 담는다.
 */

public class MyArray {
	//합계를 구하는 메소드를 선언해 보세요.
	public int hap(String user[]) {
		//insert here - 변수 선언해서 문법문제 해결하기
		int sum = 0;
		JFrame jf = new JFrame();
		int[] input = new int[user.length];//★★★변수에 의한 대응하기
		
		//합을 구하는 로직 구현하기
		for(int i=0;i<input.length;i++) {
			String userinput = JOptionPane.showInputDialog(jf,i+1+"번 지출비용을 입력해주세요.");
			int chinput = Integer.parseInt(userinput);
			input[i] = chinput;
//줄이기		input[i] = Integer.parseInt(userinput);
			sum = sum + input[i];
//★★연산자	sum += input[i];
/*			if(i==4) {
				System.out.println("입력한 지출의 합 = "+sum);
			}			
*/		}
		return sum;
	}
	
	//평균을 구하는 메소드를 선언해 보세요.
						    //평균을 구하는데 필요한 변수 선언하기1 (합계)
	public double myAvg(int sum, int inwon) {//hap메소드의 지역변수는 사용할수 없음. 새로 언언함
								//평균을 구하는데 필요한 변수 선언하기2					
		//insert here - 평균을 담을 변수 선언
		double avg = 0.0;
		avg = sum / inwon;
						
		//평균을 구하는 로직 구현하기
		return avg;
	}
	
	//가장 먼저 실행되는 main메소드
	public static void main(String[] args) {
		//static은 인스턴스화 없이도 누릴 수 있다.(호출할 수 있다. 즉, 기능) :: 기능을 기억하고 싶다. ~ 변수
		
		if(args.length < 5) {
			System.out.println("0부터 100사이의 정수를 5개 입력하세요.");
			return;//main탈출
		}
		
		//()는 캐스팅연산자, 메소드, 생성자 에서만 사용됨
		MyArray myApp = new MyArray();//클래스 MyArray를 새로이 생성함
		int tot = 0;
		double avg = 0.0;//선언하고
		tot = myApp.hap(args);
		avg = myApp.myAvg(tot,args.length);//값을 클래스.메소드 안에 담음
		
		System.out.println("합계 : "+tot);
		System.out.println("평균 : "+avg);
		
		int[] account = new int[5];//새로운 타입의 배열을 새 이름으로 시작함.
		account[0] = 30000;
		account[1] = 22000;
		account[2] = 13500;
		account[3] = 69500;
		account[4] = 34900;

//		int account[] = {30000,22000,13500,69500,34900};
		
		//합계구해보기
		int sum = 0;
		for (int i=0;i<account.length;i++) {
		    sum = sum + account[i];
			if(i==4) {
				System.out.println("1~5까지의 배열방의 합 : "+sum);
				break;
			}
				
		}
			
		
	}
	
}
