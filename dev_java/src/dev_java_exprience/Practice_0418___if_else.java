package dev_java_exprience;

public class Practice_0418___if_else {

	public static void main(String[] args) {

		String manA = "����1ȣ";
		
		int manAweight = 90;
		double manAheight = 183.1;
		
		System.out.println(manA+"�� ���� ������");
		System.out.println("���� : "+manAweight+" cm");
		System.out.println("ü�� : "+manAweight+" cm");
		System.out.println("");
		
		String manB = "����2ȣ";
		
		int manBweight = 75;
		double manBheight = 175.4 + 3;
		
		System.out.println(manB+"�� ���� ������");
		System.out.println("���� : "+manBweight+" cm");
		System.out.println("ü�� : "+manBweight+" cm");
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("");
				
		String womanA = "����1ȣ";
		
		int womanAweight = 51;
		double womanAheight = 164.5 + 5;
		
		System.out.println(womanA+"�� ���� ������");
		System.out.println("���� : "+womanAweight+" cm");
		System.out.println("ü�� : "+womanAweight+" cm");
		System.out.println("");
		
		String womanB = "����2ȣ";
		
		int womanBweight = 42;
		double womanBheight = 152.3 + 9;
		
		System.out.println(womanB+"�� ���� ������");
		System.out.println("���� : "+womanBweight+" cm");
		System.out.println("ü�� : "+womanBweight+" cm");
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("");
		
		
		boolean feelWmA = false;
		
		if(feelWmA) {
			System.out.println("����1ȣ �������� : "+womanA);
			womanA = "Excellent!";
			System.out.println("����1ȣ ���� : "+feelWmA);
			System.out.println("����1ȣ�� ���� ����1ȣ�� �亯 : "+womanA);
			System.out.println("");
		}
		else {
			System.out.println("����1ȣ �������� : "+womanA);
			womanA = "Hate it!";
			System.out.println("����1ȣ ���� : "+feelWmA);
			System.out.println("����1ȣ�� ���� ����1ȣ�� �亯 : "+womanA);
			System.out.println("");
		}
		
		boolean feelWmB = true;
		
		if(feelWmB) {
			System.out.println("����2ȣ �������� : "+womanB);
			womanB = "Excellent!";
			System.out.println("����2ȣ ���� : "+feelWmB);
			System.out.println("����2ȣ�� ���� ����2ȣ�� �亯 : "+womanB);
			System.out.println("");
		}
		else {
			System.out.println("����2ȣ �������� : "+womanB);
			womanB = "Hate it!";
			System.out.println("����2ȣ ���� : "+feelWmB);
			System.out.println("����2ȣ�� ���� ����2ȣ�� �亯 : "+womanB);
			System.out.println("");
		}
		System.out.println("------------------------------");
		System.out.println("");
		
		
	}

}
