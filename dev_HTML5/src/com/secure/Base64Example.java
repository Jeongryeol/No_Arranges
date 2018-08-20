package com.secure;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/*
 * Base64방식 : 기본 보안모듈 예제
 */
public class Base64Example {
	
	public static void main(String[] args) {
		String mem_id = "test2";//테스트용 아이디 및 비밀번호
		String mem_pw = "456";
		
		//보안코드 적용하기
		
		byte[] idBytes = mem_id.getBytes();				 //문자로부터 바이트배열 얻기
		Encoder idEncoder = Base64.getEncoder();		 //java가 제공하는 Base64API를 통해 변환용 객체 생성
		byte[] encodeBytesID = idEncoder.encode(idBytes);//변환용객체를 통해 바이트배열을 인코딩한 바이트배열로 저장
		String base64ID = new String(encodeBytesID);	 //저장된 변환방식을 문자열로 다시 저장
		
		System.out.println("mem_id 	 : "+mem_id);	//확인
		System.out.println("base64ID : "+base64ID);
		
		byte[] pwBytes = mem_pw.getBytes();
		Encoder pwEncoder = Base64.getEncoder();
		byte[] encodeBytesPW = pwEncoder.encode(pwBytes);
		String base64PW = new String(encodeBytesPW);
		
		System.out.println("mem_pw 	 : "+mem_pw);	//확인
		System.out.println("base64PW : "+base64PW);	//확인
		
		
		System.out.println("==================================");
		//보안코드 복구하기
		//이때, DB(오라클)에 저장된 원래값과 차이가 발생하기 때문에 오라클에서 제공하는 코드를 이용해야한다. 
		
		Decoder idDecoder = Base64.getDecoder();			 //java가 제공하는 Base64API를 통해 변환용 객체 생성
		byte[] decodeBytes = idDecoder.decode(encodeBytesID);//변환용객체를 통해 바이트배열을 디코딩한 바이트배열로 저장
		String org_id = new String(decodeBytes);			 //저장된 변환방식을 문자열로 다시 저장
		
		System.out.println("org_id 	 : "+org_id);	//확인
		
		
	}
	
}
