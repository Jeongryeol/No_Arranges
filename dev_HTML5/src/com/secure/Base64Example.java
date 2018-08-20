package com.secure;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/*
 * Base64��� : �⺻ ���ȸ�� ����
 */
public class Base64Example {
	
	public static void main(String[] args) {
		String mem_id = "test2";//�׽�Ʈ�� ���̵� �� ��й�ȣ
		String mem_pw = "456";
		
		//�����ڵ� �����ϱ�
		
		byte[] idBytes = mem_id.getBytes();				 //���ڷκ��� ����Ʈ�迭 ���
		Encoder idEncoder = Base64.getEncoder();		 //java�� �����ϴ� Base64API�� ���� ��ȯ�� ��ü ����
		byte[] encodeBytesID = idEncoder.encode(idBytes);//��ȯ�밴ü�� ���� ����Ʈ�迭�� ���ڵ��� ����Ʈ�迭�� ����
		String base64ID = new String(encodeBytesID);	 //����� ��ȯ����� ���ڿ��� �ٽ� ����
		
		System.out.println("mem_id 	 : "+mem_id);	//Ȯ��
		System.out.println("base64ID : "+base64ID);
		
		byte[] pwBytes = mem_pw.getBytes();
		Encoder pwEncoder = Base64.getEncoder();
		byte[] encodeBytesPW = pwEncoder.encode(pwBytes);
		String base64PW = new String(encodeBytesPW);
		
		System.out.println("mem_pw 	 : "+mem_pw);	//Ȯ��
		System.out.println("base64PW : "+base64PW);	//Ȯ��
		
		
		System.out.println("==================================");
		//�����ڵ� �����ϱ�
		//�̶�, DB(����Ŭ)�� ����� �������� ���̰� �߻��ϱ� ������ ����Ŭ���� �����ϴ� �ڵ带 �̿��ؾ��Ѵ�. 
		
		Decoder idDecoder = Base64.getDecoder();			 //java�� �����ϴ� Base64API�� ���� ��ȯ�� ��ü ����
		byte[] decodeBytes = idDecoder.decode(encodeBytesID);//��ȯ�밴ü�� ���� ����Ʈ�迭�� ���ڵ��� ����Ʈ�迭�� ����
		String org_id = new String(decodeBytes);			 //����� ��ȯ����� ���ڿ��� �ٽ� ����
		
		System.out.println("org_id 	 : "+org_id);	//Ȯ��
		
		
	}
	
}
