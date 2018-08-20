package dev_java_exprience;

public class Practice_0418___if_else {

	public static void main(String[] args) {

		String manA = "남자1호";
		
		int manAweight = 90;
		double manAheight = 183.1;
		
		System.out.println(manA+"의 기초 프로필");
		System.out.println("신장 : "+manAweight+" cm");
		System.out.println("체중 : "+manAweight+" cm");
		System.out.println("");
		
		String manB = "남자2호";
		
		int manBweight = 75;
		double manBheight = 175.4 + 3;
		
		System.out.println(manB+"의 기초 프로필");
		System.out.println("신장 : "+manBweight+" cm");
		System.out.println("체중 : "+manBweight+" cm");
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("");
				
		String womanA = "여자1호";
		
		int womanAweight = 51;
		double womanAheight = 164.5 + 5;
		
		System.out.println(womanA+"의 기초 프로필");
		System.out.println("신장 : "+womanAweight+" cm");
		System.out.println("체중 : "+womanAweight+" cm");
		System.out.println("");
		
		String womanB = "여자2호";
		
		int womanBweight = 42;
		double womanBheight = 152.3 + 9;
		
		System.out.println(womanB+"의 기초 프로필");
		System.out.println("신장 : "+womanBweight+" cm");
		System.out.println("체중 : "+womanBweight+" cm");
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("");
		
		
		boolean feelWmA = false;
		
		if(feelWmA) {
			System.out.println("여성1호 사전응답 : "+womanA);
			womanA = "Excellent!";
			System.out.println("여성1호 응답 : "+feelWmA);
			System.out.println("남성1호에 대한 여성1호의 답변 : "+womanA);
			System.out.println("");
		}
		else {
			System.out.println("여성1호 사전응답 : "+womanA);
			womanA = "Hate it!";
			System.out.println("여성1호 응답 : "+feelWmA);
			System.out.println("남성1호에 대한 여성1호의 답변 : "+womanA);
			System.out.println("");
		}
		
		boolean feelWmB = true;
		
		if(feelWmB) {
			System.out.println("여성2호 사전응답 : "+womanB);
			womanB = "Excellent!";
			System.out.println("여성2호 응답 : "+feelWmB);
			System.out.println("남성2호에 대한 여성2호의 답변 : "+womanB);
			System.out.println("");
		}
		else {
			System.out.println("여성2호 사전응답 : "+womanB);
			womanB = "Hate it!";
			System.out.println("여성2호 응답 : "+feelWmB);
			System.out.println("남성2호에 대한 여성2호의 답변 : "+womanB);
			System.out.println("");
		}
		System.out.println("------------------------------");
		System.out.println("");
		
		
	}

}
