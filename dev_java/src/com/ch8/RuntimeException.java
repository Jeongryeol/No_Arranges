package com.ch8;

import java.util.ArrayList;
import java.util.List;

public class RuntimeException {

	String a = "테스트용 문자입니다.";
	int x,y,z;
	int out;
	
	public void run() {
		//try블럭 안에는 예외가 발생할 가능성이 있는 코드를 넣어준다.
		try {
			//ArithExc();
			//NumFormExc();
			//IndexOutofBoundExc();
			IndexOutofBoundExc_List();
			
	//Exception을 멀티블럭으로 처리할때, 하위클래스가 먼저 나온 뒤에 상위클래스가 나와야 된다.
		}catch (ArithmeticException ae) {
			
			System.out.println("ArithmeticException : "+ae.getMessage());
			//java.lang.ArithmeticException: / by zero (어떤 수를 0으로 나눈 경우의 런타임 에러)
			
		}catch (NumberFormatException nfe) {
			
			System.out.println("ArithmeticException : "+nfe.getMessage());			
			//java.lang.NumberFormatException: null (들어온 값이 null이라 형이 맞지 않아 발생한 런타임 에러)
			
		}catch (ArrayIndexOutOfBoundsException aib) {
			
			System.out.println("ArrayIndexOutOfBoundsException :"+aib.getMessage());
			//ArrayIndexOutOfBoundsException :3 ( 배열의 자리수가 잘못된 상태로 실행한 런타임 에러 )
			//java.lang.IndexOutOfBoundsException: Index: 1, Size: 1 (방크기에 대해 잘못 얻은 상태로 실핸한 런타임 에러)
			
		}catch (Exception e) {
			
			System.out.println(e);
		}
		
		System.out.println("try-catch문을 수행하고 출력코드가 실행되었습니다.");
		
	}
	
	
	
	public void ArithExc() {
		x=10; y=0;
		out = x/y; //문법상엔 오류가 없는 상태
		//java.lang.ArithmeticException: / by zero (어떤 수를 0으로 나눈 경우의 런타임 에러)
		System.out.println(out);
	}
	
	public void NumFormExc() {
		x = Integer.parseInt(a);//문법상엔 오류가 없는 상태
		//java.lang.NumberFormatException: null (들어온 값이 null이라 형이 맞지 않아 발생한 런타임 에러)
		System.out.println(x);
	}
	
	public void IndexOutofBoundExc() {
		x = 10; y=9; z=8;
		int arr[] = {x,y,z};
		for(int i=0;i<4;i++)//문법상엔 오류가 없는 상태
			System.out.println(arr[i]);
		//ArrayIndexOutOfBoundsException :3 ( 배열의 자리수가 잘못된 상태로 실행한 런타임 에러 )
		
	}
	
	public void IndexOutofBoundExc_List() {
		List list = new ArrayList();
		String name = "이순신";
		list.add(name);
		System.out.println(list.get(1));
		//java.lang.IndexOutOfBoundsException: Index: 1, Size: 1 (방크기에 대해 잘못 얻은 상태로 실핸한 런타임 에러)
		
	}
	
	public static void main(String[] args) {
		RuntimeException re = new RuntimeException();
		re.run();
	}

}
