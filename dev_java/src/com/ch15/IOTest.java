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
		
		//��δ� ����η�, ������ ����������.
		String filePath = "src\\com\\ch13\\";
		
		try{
			InputStream is = null;
			OutputStream os = null; 
			
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			
			File f	= new File(filePath+"HP.java");
			File f2 = new File(filePath+"HP2.java");
			boolean isOk	= f.exists();//������ �����ϴ����� ���θ� ��ȯ�ϴ� �޼ҵ�
			boolean isOk2	= f2.exists();//������ �����ϴ����� ���θ� ��ȯ�ϴ� �޼ҵ�
			System.out.println("HP.java ������ �����մϱ�? : "+isOk);
			System.out.println("HP2.java ������ �����մϱ�? : "+isOk2);
			
		} catch (Exception e) {

		} finally {
			
		}
	}

}
