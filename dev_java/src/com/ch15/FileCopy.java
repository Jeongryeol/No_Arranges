package com.ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		//try-catch��� ���� catch������ ������ ����ϰ� �ʹٸ�,
		//try �ٱ��ʿ��� ������ �����ؾ��Ѵ�. (catch���忡�� ������������ �ϱ� ����)
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
