package dev_java_exprience;

import java.util.Random;

import javax.swing.JOptionPane;

public class Practice_0514___ObjectArray_Method {
	//main�޼ҵ忡 �ּ����� �ڵ��� �ϵ��� �ϱ� ���� �� ����� ó���� �޼ҵ带 �߰��Ѵ�.
/**************************************************************************
 * ***��������***
 * 0���� 10������ ���ڸ� 100�� ä���ϰ� (Ramdom Ŭ����)
 * ä���� ���ڸ� �迭�� ������� 10���� ���
 * �� ���ڰ� ä���� Ƚ���� ��Ÿ���� �󵵸� ã�Ƽ�
 * �迭�� �󵵸� ����غ���.
 **************************************************************************/

	//2// 100���� �濡 ä���� ���� ���
	public void zeroToTenArray(int numbers[], int ordinal) {//�Ķ���ͷ� �ּҹ����� ���� ����
		Random ran = new Random();//����ä��
		for(int i=0;i<ordinal;i++) {
			numbers[i] = ran.nextInt(10);//numbers�迭�� i�� �濡 0���� 10���� ���� ä���� ���ڸ� �Է���
		}
	}
	
	
	//3//�迭�� 10���� ���ٷ� ����ϴ� �޼ҵ� �����
	public void numArrayPrint10(int uc, int nums[], int ordinal2) {//�Ķ���ͷ� �ּҹ����� ���� ����
		System.out.printf("%d�� ����ä���� ������ �迭%n",uc);
		for(int i=0;i<ordinal2;i++) {
			if(i%10==0)System.out.printf("%n");
			System.out.printf("%3d",nums[i]);
		}
		
	}

	
	//4// �󵵸� ���� �迭�� ��� �޼ҵ� �����
	public void numArrayCheck(int freCheck[], int nums[], int ordinal3) {
		int index;
		for(int i=0;i<ordinal3;i++) {
			index = nums[i];//i�� �濡 �ִ� ���ڸ� index������ �ʱ�ȭ��
			freCheck[index]++;//index������ ���� ���� ������ freCheck�迭�� �濡 1ȸ �߰��ϰ� ��
		}
	}
	
	
	//5//�󵵹迭�� ����ϴ� �޼ҵ� �����
	public int[] numArrayPrint(int freCheck[],int size) {
		System.out.printf("%n%n");
		System.out.print("�� ����    : ");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		System.out.print("�� �󵵼� : ");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d",freCheck[i]);
		}		
		return freCheck;
	}
	
	
	//1// main�޼ҵ忡 100��¥�� �迭 �����
	public static void main(String[] args) {
		
		String userInput = JOptionPane.showInputDialog(" 0~9������ ���ڸ� �� �� ��÷�Ͻðڽ��ϱ�? ");//�˾�����, 100���Է�
		int userCount = Integer.parseInt(userInput);//�Էµ� ���ڸ� String���� int�� ����
		int[] rdnum = new int[userCount];//n�� ä���Ѵٰ� �����Ƿ� n��¥�� ���� �������
		
		//�ڱ��ڽ��� ȣ���Ͽ� �ڱ��ڽ� �ȿ��ִ� �ٸ� �޼ҵ带 ����� �� �ֵ��� ��
		Practice_0514___ObjectArray_Method callMyself = new Practice_0514___ObjectArray_Method();
		//ȣ��� �ڱ��ڽ� �ȿ� �ִ� �޼ҵ� zeroToTenArray�� �� ������ �ʱ�ȭ���� (�Ķ���ͷ� �ּҹ����� ���� �Ѱܼ� �ʱ�ȭ��.)
		callMyself.zeroToTenArray(rdnum,rdnum.length);
		//�ش� �޼ҵ带 ����ϰ� ���� �迭�� �ϼ���
		callMyself.numArrayPrint10(userCount,rdnum,rdnum.length);//n�� ä�� �迭 ����ϱ����� �Ƕ���ͷ� �ּҹ����� ���� �ѱ�
		//n�� ä�� �迭�� 10���� ��� �迭��
		
		//�󵵸� üũ�� �迭�� ������
		int freCheck[] = new int[10];//0~9���� ��� ���Դ����� üũ�ϹǷ� 10���� ��¥�� ���ο� �迭�� ������
		//�ϼ��� �迭�� �⺻���� �󵵸� üũ�� �޼ҵ忡 ������ �ѱ�
		callMyself.numArrayCheck(freCheck,rdnum,rdnum.length);
		callMyself.numArrayPrint(freCheck,freCheck.length);
		
	}

}
