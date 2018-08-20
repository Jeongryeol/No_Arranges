package com.ch5;

public class ArrayTeat1 {

	public static void main(String[] args) {
		int jls[] = new int[3];
		jls[0] = 1;//1차 배열의 첫번째 방에서 0에서 1로 초기화
		jls[1] = 2;//1차 배열의 두번째 방에서 0에서 2로 초기화
		jls[2] = 8;//1차 배열의 세번째 방에서 0에서 8로 초기화
		for(int i=0;i<3;i++) {
			System.out.println(jls[i]);
		}
		//boolean을 3개 담을 수 있는 방을 만들어보자
		//3개의 방안에는 default(false)값이 들어있음. 왜? 원시타입이기때문
		boolean bools[] = new boolean[3];
		for(int i=0;i<3;i++) {
			System.out.println(bools[i]);//false가 3번 출력됨
		}
		double ds[] = new double[4];
		for(int i=0;i<ds.length;i++) {//조건식에 상수보다는 ds.length를 사용하면 배열의 길이를 계산해줌 (권장사항)
			System.out.println(ds[i]);//false가 4번 출력됨
		}
	}

}
