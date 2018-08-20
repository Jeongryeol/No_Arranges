package dev_java_exprience;

public class Practice_0419___Integer_parseInt {

	// static을 써서 전역변수를 static 메인메소드에 호출하였음
	static int ryanNo = 6;//int는 원시형 타입 변수
	static String Ryan = "라이언";//string은 참조형 타입 변수로 문자가 출력됨
	
	public static void main(String[] args) {

		int appeachNo = 1;
		String Appeach = "어피치";
		appeachNo = 3;		
		System.out.println("친구들, 안녕! 나는 "+appeachNo+"번째로 카카오프렌즈에 들어온 "+Appeach+" 라고해!");
		System.out.println("친구들, 안녕! 나는 "+ryanNo+"번째로 카카오프렌즈에 들어온 "+Ryan+" 이라고해!");
		System.out.println("");

		int con;
		con = Integer.parseInt(args[0]);
		System.out.println(con);
		System.out.println("");
		
		double kakaoFR = 5.5+1;
		System.out.println("카카오 프렌드는 모두 "+kakaoFR+"명이 모두 친구야!");
		System.out.println("");
		
		boolean AppFace = true;
		if(AppFace) {
			System.out.println("인식된 어피치의 얼굴값 : "+AppFace);
			System.out.println("어피치는 기분이 좋은 얼굴을 하고 있어요.");
			System.out.println("");
		}
		else {
			System.out.println("인식된 어피치의 얼굴값 : "+AppFace);
			System.out.println("어피치는 우울한 얼굴을 하고 있어요.");
			System.out.println("");
	}
		
	}

}
