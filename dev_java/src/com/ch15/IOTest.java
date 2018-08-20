package com.ch15;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest {

	public static void main(String[] args) {
		
		//경로는 상대경로로, 변수로 관리해주자.
		String filePath = "src\\com\\ch13\\";
		
		try{
			InputStream is = null;
			OutputStream os = null; 
			
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			
			File f	= new File(filePath+"HP.java");
			File f2 = new File(filePath+"HP2.java");
			boolean isOk	= f.exists();//파일이 존재하는지를 여부를 반환하는 메소드
			boolean isOk2	= f2.exists();//파일이 존재하는지를 여부를 반환하는 메소드
			System.out.println("HP.java 파일이 존재합니까? : "+isOk);
			System.out.println("HP2.java 파일이 존재합니까? : "+isOk2);
			
		} catch (Exception e) {

		} finally {
			
		}
	}

}
