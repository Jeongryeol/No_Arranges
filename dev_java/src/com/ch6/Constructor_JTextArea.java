package com.ch6;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Constructor_JTextArea {

	//[�����]
	JFrame jf = new JFrame();
	JTextArea jta = new JTextArea("�ʱⰪ�� �־ �ؽ�Ʈ������ ����� �־��",5,3);
//	��JFrame ���ο� ������ JTextArea�� �ֵ��� ������
	JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	��JTextArea�� ������ ��ũ�Ѽ����� ����.                                                                                                           	
	Constructor_JTextArea jta_test = null;
	/*	���Ͱ��� ���������� �����Ҷ� �ݵ�� null�� �ؾ��ϴ� ����?
	 	����ִ� �����϶��� �ν��Ͻ������� ������ �����Ͽ� �ּҹ����� �Է��ϸ�, ������ �ּҹ����� ���� �� ����	*/
//	Construction_JTextArea jta_test2 = new Construction_JTextArea();
	/*	���������� �ʱ�ȭ ���� �� new�� �������� ����?
 		���� ���� ���� new�� ����ؼ� �ν��Ͻ�ȭ �ϸ�, ������ ����� ���� �ƴ϶� �������� ����ϰ� ��.	*/
	
	//[������]
	public Constructor_JTextArea() {
		System.out.println("Construction_JTextArea ����Ʈ ������ ȣ�� ����");
		//initDisplay();//Ŭ���� �ȿ� �ִ� �޼ҵ带 �����ڿ��� ȣ����
	}
	
	//[�޼ҵ��]
	//ȭ�� ó�� �޼ҵ�
	public void initDisplay() {
		System.out.println("initDisplay ȣ�⼺��");
		jf.add("Center",jsp);//�߾ӿ� jsp��ũ�ѹٸ� ����
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	//�޼ҵ�A
	public void methodA(Constructor_JTextArea jta_test) {
		System.out.println("�Ķ���ͷ� �Ѱ����� �ּҹ��� : "+jta_test);
		this.jta_test = jta_test;//���������� ����ִ�(null) ������Ÿ�� jta_test�� �Ķ���ͷ� �Ѿ�� ���������� �Է��Ͽ� �ʱ�ȭ��Ŵ
		jta_test.initDisplay();//�ּҹ����� ���� �ش� Ŭ���� ���� �޼ҵ带 ȣ����
	}
	
	//[���θ޼ҵ��]
	public static void main(String[] args) {
/*		�Ʒ��� ��� �ν��Ͻ��� �ּҹ����� ������ �����Ƿ�, �Ķ�̷��� �Ѱ� �ٸ� �޼ҵ忡�� �� �ּҹ����� ���� �� �ִ�.
		�̶�, ���������� �����ϰ� �Ķ���ͷ� �ʱ�ȭ ���� �ֱ⸸ �ϸ�,
		���������� �� �ּҹ����� ���ԵǾ� �Ķ���� �����ӿ��� �ұ��ϰ� �������� ��밡��������.*/
		Constructor_JTextArea jta_test = new Constructor_JTextArea();
		jta_test.methodA(jta_test);
		
		new Constructor_JTextArea();//Ŭ���� �ȿ��ִ� �޼ҵ带 ���θ޼ҵ忡 ������
	}

}
