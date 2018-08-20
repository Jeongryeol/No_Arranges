package com.ch8;

public class FinallyExam {

	public void test() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException cne) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
		}catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}finally {
			System.out.println("[finally] : 예외와 상관없이 무조건 처리해야되는 일이 있을 때...");
			test2();
		}
	}
	
	
	public void test2() {
		System.out.println("test2호출 성공!!");
	}
	
	
	public static void main(String[] args) {
		FinallyExam fe = new FinallyExam();
		fe.test();
	}

}
