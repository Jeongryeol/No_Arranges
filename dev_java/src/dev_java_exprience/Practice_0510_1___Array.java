package dev_java_exprience;

public class Practice_0510_1___Array {
	//전역배열 선언하기
	String penNames[] = null;//null값으로 미지정만 가능, 초기화는 지역변수에서 할 것
	
	void penList() {//내안에 특이한 메소드 선언하기
		penNames = new String[5];//지역배열 초기화하기(***초기화할때는 row값을 미지정할순없는걸까?***)
		penNames[0] = "PentelFiner_BLACK";
		penNames[1] = "PentelFiner_RED";
		penNames[2] = "PentelChock_BLACK";
		penNames[3] = "PentelChock_RED";
		penNames[4] = "Holder";	
	}
	
	//내안의 다른 메소드를 호출하고 누리기
	void runTest() {//호출할 메소드 선택 혹은 생성
		System.out.println("\n◇◇◇[static메소드 밖의 일반메소드영역]\n");	
		penList();//정의된 다른 메소드 호출함
		for(int i=0;i<penNames.length;i++) {//전역배열을 받아서 호출된 메소드 내부에서 초기화된 내용을 출력함 
			System.out.println("penNames["+i+"] = "+penNames[i]);
		}
		//★★★for문 개선하기 : String배열을 조건으로 값만 출력하는 for문★★★
		System.out.println("\n▷▼[개선된 for문으로 출력한 결과]");	
		for(String pen:penNames) {//for(타입 이름:주소번지)
			System.out.println(pen);
		}
		System.out.println("\n◇◇◇[static메소드 밖의 일반메소드영역]");	
	}
	
	//static 메소드 밖의 메소드에 있는 변수들을 사용하기
	public static void main(String[] args) {
		int newis[] = null;//지역배열 선언
		newis = new int[3];//배열의 초기화

		System.out.println("▼[static메소드 밖의 메소드를 인스턴스화+호출 & 출력하기]");
		Practice_0510_1___Array doRun = new Practice_0510_1___Array();//클래스를 인스턴스화하여 복제하고 이름붙이기
		doRun.runTest();//복제된 클래스의 내부에 있는 다른 메소드를 호출한다.
				
		System.out.println("\n▼[static메소드 밖의 메소드를 인스턴스화+호출+초기화 & 출력하기]");
		Practice_0510_1___Array doRun2 = new Practice_0510_1___Array();//클래스를 인스턴스화하여 복제하고 이름붙이기
		doRun2.penNames = new String[4];//복제된 클래스의 내부에 정의된 전역배열에 방생성
		doRun2.penNames[0] = "Sharpe";
		doRun2.penNames[1] = "Pluspen_BLUE";
		doRun2.penNames[2] = "Pluspen_GREEN";
		doRun2.penNames[3] = "Pencil";
		
		for(String dodo:doRun2.penNames) {//for(타입  이름:주소번지)
			System.out.println(dodo);
		}
		
	}

}
