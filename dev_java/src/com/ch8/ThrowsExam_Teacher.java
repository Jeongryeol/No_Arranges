package com.ch8;

import java.util.Scanner;

public class ThrowsExam_Teacher {
	
	public void test() throws NumberFormatException,Exception{
		System.out.println("0���� 9������ ���ڸ� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);	//�ܼ�â�� ���ؼ� �ý��ۿ� �Էµ� ����(�Ķ����)�� ��ĵ�ϴ� ScannerŬ����
		String val = scan.nextLine();			//��ĵ�� ���뿡 Ŀ���� �����ٷ� �Ű� �����鼭 ���ڿ��� ����
		
		if(val.length()>1) {//���ڿ��� ���̸� �˷��ִ� string�̸�.length()
			//new Exception("�޽���")
			throw new Exception("���ڸ��� �Է��ϼ���.");//Exception�� �޽���
		}
		
		if(val==null || val.equals("")) {
			throw new NumberFormatException();
		}
		System.out.println((int)val.charAt(0));
		
		if(!((int)val.charAt(0)>=48 && (int)val.charAt(0)<=57)) {
			throw new Exception("�� 0���� 9������ ���ڰ� �ƴ� ��......");
		}
		System.out.println("����...");
	}
	
	public static void main(String[] args) {
		ThrowsExam_Teacher te = new ThrowsExam_Teacher();
		try {
			te.test();
		} catch(NumberFormatException ne) {
			System.out.println("NumberFormatException:"+ne.toString());
		} catch (Exception e) {
			System.out.println("Exception:"+e.toString());
			e.printStackTrace();
		}
	}
	
}
