package com.ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		//try-catch블록 사용시 catch문에서 변수를 사용하고 싶다면,
		//try 바깥쪽에서 변수를 선언해야한다. (catch입장에서 전역변수여야 하기 때문)
		FileInputStream	 fis = null;
		FileOutputStream fos = null;
		try {
			String path = "D:\\dev_kosmo201804\\";
			fis = new FileInputStream(path+"textForTest.txt");
			fos = new FileOutputStream(path+"textForTest_copy.txt");
			int data = 0;
			while((data=fis.read())!=-1) {
				fos.write(data);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			}catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
