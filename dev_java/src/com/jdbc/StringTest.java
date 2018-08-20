package com.jdbc;

/****************************************************************
 * String��� StringBuilder�� StringBuffer�� ����ϴ� ����??
 * String�� ���ڿ��� �����ϰ� �߰�[+="�߰����ڿ�"]�ؼ� ������ �� ��ü�� �Ź� �����ǰ�,
 * ������ ������ �ʾƼ� �ݵ�� ���Կ����ڿ� ���� ��������.
 * 
 * StringBuilder�� StringBuffer��  ������ �� ���ڴ����� ����ǰ�,
 * �߰�[.append("�߰����ڿ�")]�Ͽ� ������ ���ϹǷ�, ȣ���ϸ� �ﰢ ��ȭ�Ȱ��� Ȯ���� �� �ִ�.
 * 
 * StringBuilder�� StringBuffer�� ������ ��ȭ���Ѽ� �޸𸮿� �Ҵ�Ǵ� ���� ����
 * StringBuilder�� �̱۽����忡�� | StringBuffer�� ��Ƽ�����忡�� �����ϴ�.
 * 
 * BuilderŬ������ BufferŬ������ �������� ���� ��Ŀ������ Ȯ���� ��!!
 ***************************************************************/

public class StringTest {

	public void test() {
		String s = "Have";
		System.out.println(s);
		s+= " a";
		System.out.println(s);
		s+= " good";
		System.out.println(s);
		s+= " time!!";
		System.out.println(s);
		//
	}
	
	public static void main(String[] args) {
		//String�� ������ �ٲ��� �ʰ� ���ڿ��� ����� �����Ѵ�.
		
		String s = "hello";
		s.replace('e','o');
		System.out.println(s);	//hello�� ��µ�.. hollo���� ������...
		
		//�ݵ�� ���Կ����ڴ� ���ο� ���� ��ƾ� ��.
		s = s.replace('e','o');	//�̷��� hollo�� ��µ�.
		System.out.println(s);
		System.out.println("==============");
		
		StringTest st = new StringTest();
		st.test();
	}
}
