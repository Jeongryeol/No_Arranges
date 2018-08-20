package com.ch8;

import java.io.*;
/*����ó���� �ݵ�� �ؾ��ϴ� ��Ű���� �����Ѵ�*/

public class Exception_P431 {

	public static void main(String[] args) {
		//command line���� �Է¹��� ���� �̸����� ���� ������ �����Ѵ�.
		File f = createFile(args[0]);
		System.out.println(f.getName() + "������ ���������� �����Ǿ����ϴ�.");
	}//end of main() method

	static File createFile(String fileName) {
		try {
			if(fileName==null||fileName.equals(""))
				throw new Exception("���� �̸��� ��ȿ���� �ʽ��ϴ�.");
		}catch (Exception e) {
			//fileName�� �������� ���, ���� �̸��� '�������.txt'�� �Ѵ�.
			fileName = "�������.txt";
		}finally {
			File f = new File(fileName);//FileŬ������ ��ü�� �����.
			createNewFile(f);			//������ ��ü�� �̿��ؼ� ������ �����Ѵ�.
			return f;
		}//end of try-catch-finally
	}//end of createFile(String) method

	static void createNewFile(File f) {
		try {
			f.createNewFile();		//������ �����Ѵ�.
		}catch (Exception e) {
		}//end of try-catch
	}//end of createNewFile(File) method

}
