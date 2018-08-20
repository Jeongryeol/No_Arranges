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
			/*	사진을 찍는 카메라 역할을 하는 FileInputStream
				카메라의 필터역할을 하는 BuffedInputStream
				카메라와 필터를 합쳐보자 */
			BufferedInputStream bis 
				= new BufferedInputStream(new FileInputStream(filePath+"text.txt"));
			System.out.println(bis.read());
			int data = 0;
			while( (data=bis.read()) != -1 )
				System.out.println(data); //아스키코드로 출력됨	
			/*	
			 	AB	: ASCII Code no.10 LF (Line Feed --> 다음줄 이동)
			 		: ASCII Code no.13 CR (Cariage Resturn --> 제일 처음 칸으로)
			 		: ASCII Code no.32 SP (Space --> 공백추가)
			 */
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void fileRead() {
		String filePath = "src\\com\\ch15\\IOTest.java";	//파일경로를 담는 변수
		FileReader fr =null;						//파일을 읽는 필터클래스
		Scanner scan = null;						//클래스객체를 읽는 스캐너클래스객체
		try{
			fr = new FileReader(filePath);			//해당경로의 파일을 읽어서 객체에 담음
			scan = new Scanner(fr);					//객체를 스캔하여 읽어둠
			while(scan.hasNextLine()) 				//읽은 객체에 다음 줄이 있으면 반복
				System.out.println(scan.nextLine());//읽은 객체의 다음 줄을 리턴받음
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
