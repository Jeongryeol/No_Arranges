package com.ch8;

import java.util.ArrayList;
import java.util.List;

public class RuntimeException {

	String a = "�׽�Ʈ�� �����Դϴ�.";
	int x,y,z;
	int out;
	
	public void run() {
		//try�� �ȿ��� ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �־��ش�.
		try {
			//ArithExc();
			//NumFormExc();
			//IndexOutofBoundExc();
			IndexOutofBoundExc_List();
			
	//Exception�� ��Ƽ������ ó���Ҷ�, ����Ŭ������ ���� ���� �ڿ� ����Ŭ������ ���;� �ȴ�.
		}catch (ArithmeticException ae) {
			
			System.out.println("ArithmeticException : "+ae.getMessage());
			//java.lang.ArithmeticException: / by zero (� ���� 0���� ���� ����� ��Ÿ�� ����)
			
		}catch (NumberFormatException nfe) {
			
			System.out.println("ArithmeticException : "+nfe.getMessage());			
			//java.lang.NumberFormatException: null (���� ���� null�̶� ���� ���� �ʾ� �߻��� ��Ÿ�� ����)
			
		}catch (ArrayIndexOutOfBoundsException aib) {
			
			System.out.println("ArrayIndexOutOfBoundsException :"+aib.getMessage());
			//ArrayIndexOutOfBoundsException :3 ( �迭�� �ڸ����� �߸��� ���·� ������ ��Ÿ�� ���� )
			//java.lang.IndexOutOfBoundsException: Index: 1, Size: 1 (��ũ�⿡ ���� �߸� ���� ���·� ������ ��Ÿ�� ����)
			
		}catch (Exception e) {
			
			System.out.println(e);
		}
		
		System.out.println("try-catch���� �����ϰ� ����ڵ尡 ����Ǿ����ϴ�.");
		
	}
	
	
	
	public void ArithExc() {
		x=10; y=0;
		out = x/y; //������ ������ ���� ����
		//java.lang.ArithmeticException: / by zero (� ���� 0���� ���� ����� ��Ÿ�� ����)
		System.out.println(out);
	}
	
	public void NumFormExc() {
		x = Integer.parseInt(a);//������ ������ ���� ����
		//java.lang.NumberFormatException: null (���� ���� null�̶� ���� ���� �ʾ� �߻��� ��Ÿ�� ����)
		System.out.println(x);
	}
	
	public void IndexOutofBoundExc() {
		x = 10; y=9; z=8;
		int arr[] = {x,y,z};
		for(int i=0;i<4;i++)//������ ������ ���� ����
			System.out.println(arr[i]);
		//ArrayIndexOutOfBoundsException :3 ( �迭�� �ڸ����� �߸��� ���·� ������ ��Ÿ�� ���� )
		
	}
	
	public void IndexOutofBoundExc_List() {
		List list = new ArrayList();
		String name = "�̼���";
		list.add(name);
		System.out.println(list.get(1));
		//java.lang.IndexOutOfBoundsException: Index: 1, Size: 1 (��ũ�⿡ ���� �߸� ���� ���·� ������ ��Ÿ�� ����)
		
	}
	
	public static void main(String[] args) {
		RuntimeException re = new RuntimeException();
		re.run();
	}

}
