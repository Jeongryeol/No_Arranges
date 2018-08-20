package com.ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class P871 {
	
	public void filterClass() {
		String filePath = "src\\com\\ch15\\";
		try {
			/**[p.871]***************************************************
			 * 
			 * 	FileInputStream fis = new FileInputStream("text.txt");
			 * 	BuffterInputStream bis = new BufferInputStream(fis);
			 * 	bis.read();
			 * 
			 ************************************************************/
			/*	������ ��� ī�޶� ������ �ϴ� FileInputStream
				ī�޶��� ���Ϳ����� �ϴ� BuffedInputStream
				ī�޶�� ���͸� ���ĺ��� */
			BufferedInputStream bis 
				= new BufferedInputStream(new FileInputStream(filePath+"text.txt"));
			System.out.println(bis.read());
			int data = 0;
			while( (data=bis.read()) != -1 )
				System.out.println(data); //�ƽ�Ű�ڵ�� ��µ�	
			/*	
			 	AB	: ASCII Code no.10 LF (Line Feed --> ������ �̵�)
			 		: ASCII Code no.13 CR (Cariage Resturn --> ���� ó�� ĭ����)
			 		: ASCII Code no.32 SP (Space --> �����߰�)
			 */
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void fileRead() {
		String filePath = "src\\com\\ch15\\IOTest.java";	//���ϰ�θ� ��� ����
		FileReader fr =null;						//������ �д� ����Ŭ����
		Scanner scan = null;						//Ŭ������ü�� �д� ��ĳ��Ŭ������ü
		try{
			fr = new FileReader(filePath);			//�ش����� ������ �о ��ü�� ����
			scan = new Scanner(fr);					//��ü�� ��ĵ�Ͽ� �о��
			while(scan.hasNextLine()) 				//���� ��ü�� ���� ���� ������ �ݺ�
				System.out.println(scan.nextLine());//���� ��ü�� ���� ���� ���Ϲ���
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}
	
	public static void main(String[] args) {
		P871 p = new P871();
		//p.fileRead();
		p.filterClass();
	}
}
