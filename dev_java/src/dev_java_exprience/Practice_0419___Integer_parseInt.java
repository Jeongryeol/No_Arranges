package dev_java_exprience;

public class Practice_0419___Integer_parseInt {

	// static�� �Ἥ ���������� static ���θ޼ҵ忡 ȣ���Ͽ���
	static int ryanNo = 6;//int�� ������ Ÿ�� ����
	static String Ryan = "���̾�";//string�� ������ Ÿ�� ������ ���ڰ� ��µ�
	
	public static void main(String[] args) {

		int appeachNo = 1;
		String Appeach = "����ġ";
		appeachNo = 3;		
		System.out.println("ģ����, �ȳ�! ���� "+appeachNo+"��°�� īī������� ���� "+Appeach+" �����!");
		System.out.println("ģ����, �ȳ�! ���� "+ryanNo+"��°�� īī������� ���� "+Ryan+" �̶����!");
		System.out.println("");

		int con;
		con = Integer.parseInt(args[0]);
		System.out.println(con);
		System.out.println("");
		
		double kakaoFR = 5.5+1;
		System.out.println("īī�� ������� ��� "+kakaoFR+"���� ��� ģ����!");
		System.out.println("");
		
		boolean AppFace = true;
		if(AppFace) {
			System.out.println("�νĵ� ����ġ�� �󱼰� : "+AppFace);
			System.out.println("����ġ�� ����� ���� ���� �ϰ� �־��.");
			System.out.println("");
		}
		else {
			System.out.println("�νĵ� ����ġ�� �󱼰� : "+AppFace);
			System.out.println("����ġ�� ����� ���� �ϰ� �־��.");
			System.out.println("");
	}
		
	}

}
