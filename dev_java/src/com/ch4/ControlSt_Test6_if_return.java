package com.ch4;
/*return �� ��������
 *for��, while���� ������Ű�� ������ break
 *if���� ���� ���� return!!
 */
public class ControlSt_Test6_if_return {

	public static void main(String[] args) {
//		�ٸ� Ŭ������ ������ �޼ҵ带 ȣ���� �� - �ν��Ͻ�ȭ
//		�ٸ� ����� �ִ�. static
//		�޼ҵ� �տ� static�� ������ �ν��Ͻ�ȭ ���̵� �����ϴ�.
		//args = new String[1];
		//null�� �Ʒ��� ���� ����
		String myName = null;
//		�Ʒ� 12������ NumberFormatException�� �߻���.
//		�ֳĸ� ����Ʈ�� null�̹Ƿ� ����Ÿ������ ������ �Ұ����ϱ� ������...
		int user = Integer.parseInt(args[0]);//args�� ������ �ƴ� �迭�̴�. �� ���̾ƴ� �ּҹ����� ���´�. ���� args�� ���������� ������.
//		���׿� ������ �ִ� ����.
		//insert here - ���׸� ���� �� �ִ� �ڵ带 �߰��� ������.
		if(args==null) {
			return;//�� ������ �ڵ�� �۶����� �ִ� �������״� if���� break�� �̿��ؼ� ���ߴ� ��.
		}//return�� main method�� Ż����.
		if(args[0].length()==1) {//�� ���ڸ� ���ڸ� �Է��Ѱž�?
			char ch = args[0].charAt(0); 
			if(ch>=48 && ch<=57) {//�����ڵ� ������ ::����::  http://www.bluene.net/blog/359
				user = Integer.parseInt(args[0]);
			}
			else {
				System.out.println("���ڸ� �Է��ϼ���.");
				return;//return�� main method�� Ż����.
			}
		}
		System.out.println("����ڰ� �Է��� ���� : "+(user+3));
		//�� ���ڸ� �Է��ѰŴ�?
		char ch = 1;//char type�� ��ĭ¥�� ���ĺ��̳� ���� �Ѵ� �Է¹��� �� ����.
		System.out.println(ch>=0);
		System.out.println('C'>'B');
		
		System.out.println(Integer.parseInt("10"));				
// 		System.out.println(Integer.parseInt("true"));//���ڷ� �ٲܼ��ִ� ���ڿ�Ÿ���� �ƴ�		
//		System.out.println(Integer.parseInt("ȸ��"));//��	
//		System.out.println(Integer.parseInt(null));//��ü�� �Ҵ�Ǳ� ���̹Ƿ� ������ ��

	}

}
