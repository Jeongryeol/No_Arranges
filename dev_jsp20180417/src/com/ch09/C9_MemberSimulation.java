package com.ch09;

public class C9_MemberSimulation {

	public static void main(String[] args) {
		C9_MemberDao jDao = new C9_MemberDao();
		String mem_name = jDao.login("test","123");
		System.out.println("Á¶È¸ : "+mem_name);
	}

}
