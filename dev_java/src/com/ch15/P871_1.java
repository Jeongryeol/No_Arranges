package com.ch15;

import java.io.FileReader;
import java.util.Scanner;

public class P871_1 {

	public static void main(String[] args) {
		FileReader fr = null;
		Scanner scan = null;
		try {
			 fr = new FileReader("src//com//ch15//"+"IOTest.java");
			 scan = new Scanner(fr);
			 while(scan.hasNextLine()) {
				 System.out.println(scan.nextLine());
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
