package com.ch7;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class Inher_05_PopUp extends JFrame implements ActionListener{
	JButton jbtn_id = new JButton ("ID�ߺ�üũ");
	JButton jbtn_zipcode = new JButton ("�����ȣ �˻�");
	//�θ�â�� ���� ȭ��ó�� �޼ҵ��� ����Ʈ �����ڿ��� ȣ���ϰ� �ִ�. (�Ʒ�Ȯ��)
	//��Ӱ��迡 �ִ� Ŭ������ �ִ� ��� �ڽ�Ŭ���� ������ ȣ������ �θ� �����ڰ� ���� ȣ���.
	//�ֳ��ϸ�... �׷��� �ڽ�Ŭ������ �޼ҵ尡 �������̵� �������� �ľ��� �� ����
	//�Ʒ� �ڵ� [�̺�Ʈó��]���� �ν��Ͻ�ȭ�� �ι� �Ͼ.
	//�̰� �θ�â�� ���� ����Ʈ �����ڰ� �� �� ȣ���� �Ǵ� ����.
	//���� �޼ҵ忡�� �� �� â�� ������, �̺�Ʈ�� �Ͼ�� �θ�â�� �� �� ������ ���� �� ������
	//�׷� �� ������ �ذ��غ�����. : �����ڸ� �̿��Ͽ� �ذ��ϱ�
	public Inher_05_PopUp() { initDisplay(); }
	public Inher_05_PopUp(String str) { 
		System.out.println
		("PopUp(String str) ������ ȣ��� :: initDisplay()�� ȣ���������");
	}
	public void diaLogView(int w, int h, String title, boolean vs) {
		System.out.println("diaLogView ȣ�⼺�� [ PopUP class ]");
	}
	public void initDisplay() {
		jbtn_id.addActionListener(this);
		jbtn_zipcode.addActionListener(this);
		this.add("North",jbtn_id);
		this.add("South",jbtn_zipcode);
		this.setSize(500,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Inher_05_PopUp();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {//Eventó���ϴ°��� ����� ó���ϱ�
		String label = ae.getActionCommand();//�̺�Ʈ�ҽ��� �󺧰� ��ȯ(String)
	//�ڹٴ� ����ο� �����ο� ���� Ŭ������ �ٸ� �� �ִ�.
	//�ڹٴ� �����ο� ����� Ŭ������ ���� �޸𸮿� �ε��ȴ�.
	//�׷��ٸ� ����ο� ���� ���� Ÿ�԰� ������ Ÿ�� �� ���� �޼ҵ��̸��� ȣ��Ǿ�����, ���� ȣ��Ǵ°�?
		Inher_05_PopUp pop = null;
		//if(label.equals("ID�ߺ�üũ")) 
		if("ID�ߺ�üũ".equals(label)){
		//�񱳹��ڿ��� ���� ���°�� null������ ����(nullPointException)�� ������ �� �ִ�.
			//Inher_05_IDCheck idChec	= new Inher_05_IDCheck("");
			pop		= new Inher_05_IDCheck("");
			//idChec.diaLogView(200,100,"ID�ߺ�üũ",true);
			//pop.diaLogView(200,100,"ID�ߺ�üũ2",true);
		}else if("�����ȣ�˻�".equals(label)) {
			Inher_05_ZipCodeSearch zcs 	= new Inher_05_ZipCodeSearch();
			pop 	= new Inher_05_ZipCodeSearch();
			
		}
	}
}
