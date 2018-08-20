package com.ch2;

public class W02_B2_P33 {

	public static void main(String[] args) {
		int i = 3;
		double d = 5.0;
		//i = d; 컴파일에러 발생. 더 큰타입을 더 작은 타입에 담을 수 없다.
		d=i;
		System.out.println(d);//3이 출력될 걸? no 3.0이 출력됨!!!! (double타입)
		int jimsu1 = 85;
		int jimsu2 = 70;
		int jimsu3 = 90;
		//위 3개의 점수의 평균을 구해서 담을 변수를 선언하시오.
		int total = jimsu1+jimsu2+jimsu3;
		System.out.println("총점은 "+total);
		//평균을 구해서 담을 변수를 선언언하세요
		double avrg = 0.0d; 
		avrg = total/3;
		System.out.println("평균은 "+avrg);//계산 결과는 int ( total은 int, 나누는값도 int : 계산결과가 애매함 )
		avrg = total/3.0;
		System.out.println("평균은 "+avrg);//계산 결과는 double ( total은 int, 나누는 값이 double : 계산결과가 double로 정확함)
		avrg = total/(double)3;
		System.out.println("평균은 "+avrg);//계산 결과는 double ( 형변환을 통해 int를 double로 전환하여 계산 : 계산결과가 double로 정확 )
		

	}

}
