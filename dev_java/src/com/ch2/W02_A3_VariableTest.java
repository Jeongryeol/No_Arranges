package com.ch2;

public class W02_A3_VariableTest {

	public static void main(String[] args) {
		//▶▶▶▶▶int변수를 각각 저장하여 다 더하는 가장 기초적인 방법
		int numA = 1;
		int numB = 2;
		int numC = 3;
		int numD = 4;
		int numE = 5;
		int numSum = numA+numB+numC+numD+numE;
		System.out.println("int를 6개 사용하여 만든 1~5까지의 합은 "+numSum);
		System.out.println("");
		//▶▶▶▶▶변수 100만개면 저걸 다 입력할텐가? 최소한의 변수로 추가하는것이 훨씬 효율적일 것이다.
		int v = 1;
		int hap = 0;
		hap = hap+v;//hap=0+1=1
		v=v+1;//v=2
		hap = hap+v;//hap=1+2=3
		v=v+1;//v=3
		hap = hap+v;//hap=1+2+3=6
		v=v+1;//v=4
		hap = hap+v;//hap=1+2+3+4=10
		v=v+1;//v=5
		hap = hap+v;//hap=1+2+3+4+5=15
		System.out.println("int를 2개만 사용하여 만든 1~5까지의 합은 "+hap);
		System.out.println("");
		//▶▶▶▶▶반복을 효율적으로 하기 위해 배우는 for문
		int newNumSum = 0;
		int newNum = 1;
		for(int i=1;i<6;i=i+1) {//for문 안에서 i라는 지역변수를 생성해주어야 하기때문에 int 사용한 것
			newNumSum = newNumSum+newNum;
			newNum = i + 1;
		}
		if(newNumSum==15) {//== : 조건에 대해 이 값이 같다는 가정을 걸어주는 것은 대입연산자2개!!
			System.out.println("for문을 사용해서 1~5까지의 합을 계산한 값은 "+newNumSum);
			System.out.println("");
		}
		else {
			System.out.println("응 아니야~");
		}
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		//★★★★★★★★★쌤이 입력해주신 답안★★★★★★★★★★
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		int oh = 1;
		int deoham = 0;//만일 초기화를 2로 하면 답이 17이 나오므로 초기값은 0이 맞다.
		deoham = deoham+oh;//0+1
		System.out.println(deoham);//1
		oh = oh+1;//그 다음 더해야하는 숫자는 2
		deoham = deoham+oh;//1+2
		System.out.println(deoham);//3
		oh = oh+1;//그 다음 더해야하는 숫자는 3
		deoham = deoham+oh;//3+3
		System.out.println(deoham);//6
		oh = oh+1;//그 다음 더해야하는 숫자는 4
		deoham = deoham+oh;//6+4
		System.out.println(deoham);//10
		oh = oh+1;//그 다음 더해야하는 숫자는 5
		deoham = deoham+oh;//10+5
		System.out.println(deoham);//15
		System.out.println("");
		System.out.println("1부터 5까지 쌤이 더한 값은 "+deoham);//15
		System.out.println("");
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		//★★★★★★★★★쌤이 입력해주신 개선코드★★★★★★★★
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		int shot = 1;
		int shotSum = 0;
		for(shot=1;shot<6;shot=shot+1) {//1~5까지 5번 반복수행함 (1,2,3,4,5)
			shotSum = shotSum + shot;//각 단계마다 증가된 shot을 더하는 것을 수행함
		}
		System.out.println("1부터 5까지 쌤이 for문을 써서 더한 값은 "+shotSum);
		System.out.println("");
		//오전수업 마무리용 문제
		//1부터 5까지의 짝수의 합을 출력하시오
		v=2;//새롭게 시작할 변화값을 입력
		hap=0;//hap은 현재 윗줄에서 15인 상태인데, 초기화과정을 거치지 않았을때,
		hap=hap+v;//이 줄에서의 합은 17이 나오게  되어 원하는 계산이 어렵게 된다.
		v=v+2;//v의 다음 짝수를 찾기위해 2를 더함
		hap=hap+v;
		System.out.println("오전수업 마지막 과제인 1부터 5까지 짝수의 합은 "+hap);
		System.out.println("");
		
	}

}
