package com.ch8;

/* ���ܸ� �ݵ�� ó���ؾ��ϴ� ��Ű���� �����Ѵ�
	* javaj.net.Socket
	* java.io.PrintWriter | ObjectInputStream | ObjectOutputStream
	* java.lang.Thread
 * ���� ��� ����ó���� ������ ���� ������ ������ �߻��Ѵ�.*/

public class ThrowTest {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	//throw�� ȣ���ϸ� ���ܸ� ������ �߻������ִµ�
	//���ܸ� ������ �����Ѽ� �ð��� ������� �� ���̿� �ٸ� ó���� �� �� �ִ�.
	//���� ��� ����Ŭ���� Ʈ����� ó���� �Ҷ�...
			throw new ClassNotFoundException();
		}catch (ClassNotFoundException ce) {
			System.out.println("����̹� Ŭ������ ã��  �� �����ϴ�.");
		}catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
		System.out.println("����µʡ�");
	}
}
//Ʈ����� ó����, ���� ó���Ǵ� ������ �ϳ��� ���� ó���Ǿ�� �Ҷ� (ex.�������)
	//�ֹ������� ���̺� ����?����? �ֹ��ߴ����� ���� ������ ����ϰ�
	//�ֹ��� ���̺� ������?�? �ֹ��ߴ����� ���� ������ �������� ����Ѵٸ�
	//�ֹ������� ���̺� ������ INSERT�ϰ�, (commit�� �ϴ°� �ƴ϶� ����Ų��)
	//�ֹ��� ���̺� ������ INSERT�� �ڿ� commit�� ��Ų��.
	//�ֳ��ϸ�, �����Է��� �߸��Ǿ������, rollback�� ���Ѽ�,
	//�ٽ� ��� ������ ���ÿ� ó��(commit)�ϱ� ���� ��ġ (��������� ������ ������ ���� ���� �ǹ̰� ���� ��������)
