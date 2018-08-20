package com.ch15;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ScannerURL {

	public static void main(String[] args) {
		URLConnection urlCon = null;
		URLConnection urlCon2 = null;
		Scanner scan = null;
		try {
			//������ URL���� ������ ����
			//urlCon	= new URL("http://192.168.0.230:9000/datagrid/datagridEmp.jsp")
			//				.openConnection();
			urlCon2	= new URL("http://www.10X10.co.kr")
					.openConnection();
			
			//URL���ᰴü�� �Է½�Ʈ�� ��ü�� �о ����
			scan = new Scanner(urlCon2.getInputStream());
			
			//���� ��ü�� ���ڸ� ������ ������� ����ǥ����
			scan.useDelimiter("\\Z");
			
			//���� ��ü�� �Ϸ�� ��ū�� StringŸ������ ����
			String text = scan.next();
			//���
			System.out.println(text);
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}

}
