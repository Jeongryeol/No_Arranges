package com.ch5;

public class ArrayTest6_ObjectArray2D_StringReverse {
/*
 * ���������.length() ������� �迭�� ����, �� ���� ������ ��ȯ�ϰ�
 * ����������.length() �������� ���ڿ��� ���̸� ��ȯ��
 */
	public static void main(String[] args) {
		String msg = "Have a good time!";
		String msg1[] = {"Have", "a", "good", "time"};
		String msg2[] = new String[4];
		//�迭[�ο��ȣ] = String����.substring(���۹�ȣ,����ȣ);
		//���� Ȥ�� �ʱ�ȭ�� StringŸ���� ���ڸ� ���۰� ���� ������ ��´�.
		msg2[0] = msg.substring(0, 4);
		msg2[1] = msg.substring(5, 6);
		msg2[2] = msg.substring(7, 11);
		msg2[3] = msg.substring(12, 17);
		System.out.println("msg2[0] = "+msg2[0]);
		System.out.println("msg2[1] = "+msg2[1]);
		System.out.println("msg2[2] = "+msg2[2]);
		System.out.println("msg2[3] = "+msg2[3]);
		//���ڿ��� ���̸� ����غ���?
		System.out.println(msg.length());	
/*
 * 		��������
 * 		Have a good time!��
 * 		!eime doog a evaH��
 * 		����غ��ÿ�.
 */
		//****��Ʈ****		
		//for(int i=0;i<msg2.length;i++) {
		for(int i=msg1.length-1;i>=0;i--) {
			System.out.println(msg1[i]);
		}
		System.out.println("\n============================\n");
		
		//���ڿ� Have�� toCharArray() �޼ҵ带 ȣ���Ͽ� char�迭�� �����
		char chs[] = "Have".toCharArray();
		for(int i=0;i<chs.length;i++) {
			System.out.println(chs[i]);
		}
		System.out.println("\n============================\n");
		String s = "good";
		for(int i=s.length()-1;i>0;i--) {
			System.out.println(s.charAt(i));
		}
		
		
		
		System.out.println("\n===========��´��============\n");		
		for(int i=msg1.length-1;i>=0;i--) {
			char msg2p[] = msg1[i].toCharArray();
			for(int j=msg2p.length-1;j>=0;j--) {
				System.out.println(msg2p[j]);
			}
		}

		System.out.println("\n===========��ģ���============\n");		
		char msg2p[] = msg.toCharArray();
		for(int i=msg2p.length-1;i>=0;i--) {
				System.out.println(msg2p[i]);
			
		}
		
		//****������****
		String msgA = "Have a good time";
		System.out.println("\n=====[���1]=====");
		char chsA[] = msgA.toCharArray();
		for(int i=chsA.length-1;i>=0;i--) {
			System.out.println(chsA[i]);
		}
		System.out.println("\n=====[���2]=====");
		String msgB[] = {"Have", "a", "good", "time"};
		for(int i=msgB.length-1;i>=0;i--) {
			for(int j=msgB[i].length()-1;j>=0;j--) {
				System.out.println(msgB[i].charAt(j));
			}
		}
		
	}

}
