package com.ch8_exercise;

public class Test_05 {
	
	//public static void aMethod() throws Exception {
	public static void aMethod() {
		try {
			throw new Exception();
			//�����ڵ�� �߻��ϴ� ������?
			//catch���� ���!
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		} finally {
			System.out.println("finally");
		}
	}
	
	public static void main(String args[]) {
		try {
			aMethod();
		} catch(Exception e) {
			System.out.println("exception");
		}
		System.out.println("finished");
	}
}

/*
		What is the result?
		A. finally
		B. exception
		finished
		C. finally
		exception
		finished [ �� ]
		D.Compilation fails
*/
