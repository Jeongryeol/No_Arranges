package com.ch8;

public class FinallyExam {

	public void test() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException cne) {
			System.out.println("����̹� Ŭ������ ã�� �� �����ϴ�.");
		}catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}finally {
			System.out.println("[finally] : ���ܿ� ������� ������ ó���ؾߵǴ� ���� ���� ��...");
			test2();
		}
	}
	
	
	public void test2() {
		System.out.println("test2ȣ�� ����!!");
	}
	
	
	public static void main(String[] args) {
		FinallyExam fe = new FinallyExam();
		fe.test();
	}

}
