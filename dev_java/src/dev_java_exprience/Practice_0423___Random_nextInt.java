package dev_java_exprience;

import java.util.Random;//�ڹ�API���� �����ϴ� Random�� �ҷ����� ����


public class Practice_0423___Random_nextInt {
	
	public static void main(String[] args) {
		//����r�̶�� �̸��� �ҷ���  Random Ŭ����(API �����)�� ������ ���ڸ� �㵵�� ����
		Random bigR = new Random();//r�� �ּҹ��� ������ �� (@abcd1234), ������ ����
		//��ǻ�Ͱ� ä���� ���ڸ� ��� ���� dap
		//0���� �Ķ����(10)�̸��� ������ �����ϰ� �������� �޼ҵ�
		int smallR = bigR.nextInt(10);//������ ���� r�� call �ؼ� nextInt�� ��
		System.out.println("Random�޼ҵ带 ���� ��� : "+smallR);
		System.out.println(" ");			
		
		int i = 1;
		int att = 0;
		for(i=1;i<11;i=i+1) {
				att=att+i+i*i;
				System.out.println(i+"ȸ�� ���");
				System.out.println("����°� : "+att);
				System.out.println(" ");			
		}
		System.out.println("������°� "+att+" ��� �Ϸ�");
		System.out.println(" ");			
	}

}
