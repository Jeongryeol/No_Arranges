package com.ch5;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//���� ~ �迭 ~ �ڷᱸ��
/*
 * Ű����κ��� 5���� ������ �Է¹޾Ƽ� �迭�� �����ϼ���.
 * �׸��� �̵��� �հ�� ����� ����ϼ���.
 * 
 * ��������
 * ��~~? ����ڰ� �Է��� ����... StringŸ���̾����Ͱ�����.. �հ�� intŸ���ε�? �����??
 * �ذ���
 * String�� intŸ������ �ٲپ���ϴµ�..  >>  String -> int  >> Integer.parseInt( )
 * 
 * �����ذ��� ���� �Ǹ��� :: int�迭�� �ʿ��� �� ����.
 * 
 * @param	input 	- 5�� ������ �޾Ƽ� ���� ���� ( �迭 - String )
 * @return	sum 	- 5�� ������ ���� ��´�.
 */

public class MyArray {
	//�հ踦 ���ϴ� �޼ҵ带 ������ ������.
	public int hap(String user[]) {
		//insert here - ���� �����ؼ� �������� �ذ��ϱ�
		int sum = 0;
		JFrame jf = new JFrame();
		int[] input = new int[user.length];//�ڡڡں����� ���� �����ϱ�
		
		//���� ���ϴ� ���� �����ϱ�
		for(int i=0;i<input.length;i++) {
			String userinput = JOptionPane.showInputDialog(jf,i+1+"�� �������� �Է����ּ���.");
			int chinput = Integer.parseInt(userinput);
			input[i] = chinput;
//���̱�		input[i] = Integer.parseInt(userinput);
			sum = sum + input[i];
//�ڡڿ�����	sum += input[i];
/*			if(i==4) {
				System.out.println("�Է��� ������ �� = "+sum);
			}			
*/		}
		return sum;
	}
	
	//����� ���ϴ� �޼ҵ带 ������ ������.
						    //����� ���ϴµ� �ʿ��� ���� �����ϱ�1 (�հ�)
	public double myAvg(int sum, int inwon) {//hap�޼ҵ��� ���������� ����Ҽ� ����. ���� �����
								//����� ���ϴµ� �ʿ��� ���� �����ϱ�2					
		//insert here - ����� ���� ���� ����
		double avg = 0.0;
		avg = sum / inwon;
						
		//����� ���ϴ� ���� �����ϱ�
		return avg;
	}
	
	//���� ���� ����Ǵ� main�޼ҵ�
	public static void main(String[] args) {
		//static�� �ν��Ͻ�ȭ ���̵� ���� �� �ִ�.(ȣ���� �� �ִ�. ��, ���) :: ����� ����ϰ� �ʹ�. ~ ����
		
		if(args.length < 5) {
			System.out.println("0���� 100������ ������ 5�� �Է��ϼ���.");
			return;//mainŻ��
		}
		
		//()�� ĳ���ÿ�����, �޼ҵ�, ������ ������ ����
		MyArray myApp = new MyArray();//Ŭ���� MyArray�� ������ ������
		int tot = 0;
		double avg = 0.0;//�����ϰ�
		tot = myApp.hap(args);
		avg = myApp.myAvg(tot,args.length);//���� Ŭ����.�޼ҵ� �ȿ� ����
		
		System.out.println("�հ� : "+tot);
		System.out.println("��� : "+avg);
		
		int[] account = new int[5];//���ο� Ÿ���� �迭�� �� �̸����� ������.
		account[0] = 30000;
		account[1] = 22000;
		account[2] = 13500;
		account[3] = 69500;
		account[4] = 34900;

//		int account[] = {30000,22000,13500,69500,34900};
		
		//�հ豸�غ���
		int sum = 0;
		for (int i=0;i<account.length;i++) {
		    sum = sum + account[i];
			if(i==4) {
				System.out.println("1~5������ �迭���� �� : "+sum);
				break;
			}
				
		}
			
		
	}
	
}
