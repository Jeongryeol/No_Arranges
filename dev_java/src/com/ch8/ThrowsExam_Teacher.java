package com.ch8;

import java.util.Scanner;

public class ThrowsExam_Teacher {
	
	public void test() throws NumberFormatException,Exception{
		System.out.println("0부터 9사이의 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);	//콘솔창을 통해서 시스템에 입력된 내용(파라미터)을 스캔하는 Scanner클래스
		String val = scan.nextLine();			//스캔된 내용에 커서를 다음줄로 옮겨 담으면서 문자열에 담음
		
		if(val.length()>1) {//문자열의 길이를 알려주는 string이름.length()
			//new Exception("메시지")
			throw new Exception("한자리만 입력하세요.");//Exception의 메시지
		}
		
		if(val==null || val.equals("")) {
			throw new NumberFormatException();
		}
		System.out.println((int)val.charAt(0));
		
		if(!((int)val.charAt(0)>=48 && (int)val.charAt(0)<=57)) {
			throw new Exception("넌 0부터 9사이의 숫자가 아닌 걸......");
		}
		System.out.println("여기...");
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
