package dev_java_exprience;

import java.util.Random;

import javax.swing.JOptionPane;

public class Practice_0514___ObjectArray_Method {
	//main메소드에 최소한의 코딩을 하도록 하기 위해 각 명령을 처리할 메소드를 추가한다.
/**************************************************************************
 * ***연습문제***
 * 0에서 10까지의 숫자를 100번 채번하고 (Ramdom 클래스)
 * 채번된 숫자를 배열에 순서대로 10개씩 담고
 * 각 숫자가 채번된 횟수를 나타내는 빈도를 찾아서
 * 배열과 빈도를 출력해보자.
 **************************************************************************/

	//2// 100개의 방에 채번한 숫자 담기
	public void zeroToTenArray(int numbers[], int ordinal) {//파라미터로 주소번지와 값을 받음
		Random ran = new Random();//랜덤채번
		for(int i=0;i<ordinal;i++) {
			numbers[i] = ran.nextInt(10);//numbers배열의 i번 방에 0부터 10까지 랜덤 채번된 숫자를 입력함
		}
	}
	
	
	//3//배열을 10개씩 한줄로 출력하는 메소드 만들기
	public void numArrayPrint10(int uc, int nums[], int ordinal2) {//파라미터로 주소번지와 값을 받음
		System.out.printf("%d번 랜덤채번된 숫자의 배열%n",uc);
		for(int i=0;i<ordinal2;i++) {
			if(i%10==0)System.out.printf("%n");
			System.out.printf("%3d",nums[i]);
		}
		
	}

	
	//4// 빈도를 세서 배열에 담는 메소드 만들기
	public void numArrayCheck(int freCheck[], int nums[], int ordinal3) {
		int index;
		for(int i=0;i<ordinal3;i++) {
			index = nums[i];//i번 방에 있는 숫자를 index변수에 초기화함
			freCheck[index]++;//index변수와 같은 값을 가지는 freCheck배열의 방에 1회 추가하게 함
		}
	}
	
	
	//5//빈도배열을 출력하는 메소드 만들기
	public int[] numArrayPrint(int freCheck[],int size) {
		System.out.printf("%n%n");
		System.out.print("★ 숫자    : ");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		System.out.print("★ 빈도수 : ");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d",freCheck[i]);
		}		
		return freCheck;
	}
	
	
	//1// main메소드에 100개짜리 배열 만들기
	public static void main(String[] args) {
		
		String userInput = JOptionPane.showInputDialog(" 0~9까지의 숫자를 몇 번 추첨하시겠습니까? ");//팝업설정, 100번입력
		int userCount = Integer.parseInt(userInput);//입력된 숫자를 String에서 int로 변경
		int[] rdnum = new int[userCount];//n번 채번한다고 했으므로 n개짜리 방이 만들어짐
		
		//자기자신을 호출하여 자기자신 안에있는 다른 메소드를 사용할 수 있도록 함
		Practice_0514___ObjectArray_Method callMyself = new Practice_0514___ObjectArray_Method();
		//호출된 자기자신 안에 있는 메소드 zeroToTenArray에 들어갈 내용을 초기화해줌 (파라미터로 주소번지와 값을 넘겨서 초기화함.)
		callMyself.zeroToTenArray(rdnum,rdnum.length);
		//해당 메소드를 통과하고 나면 배열이 완성됨
		callMyself.numArrayPrint10(userCount,rdnum,rdnum.length);//n번 채운 배열 출력하기위해 피라미터로 주소번지와 값을 넘김
		//n번 채운 배열을 10개씩 끊어서 배열함
		
		//빈도를 체크할 배열을 선언함
		int freCheck[] = new int[10];//0~9까지 몇번 나왔는지를 체크하므로 10개의 방짜리 새로운 배열을 선언함
		//완성된 배열을 기본으로 빈도를 체크할 메소드에 내용을 넘김
		callMyself.numArrayCheck(freCheck,rdnum,rdnum.length);
		callMyself.numArrayPrint(freCheck,freCheck.length);
		
	}

}
