package dev_java_exprience;

public class Practice_0510_1___Array {
	//�����迭 �����ϱ�
	String penNames[] = null;//null������ �������� ����, �ʱ�ȭ�� ������������ �� ��
	
	void penList() {//���ȿ� Ư���� �޼ҵ� �����ϱ�
		penNames = new String[5];//�����迭 �ʱ�ȭ�ϱ�(***�ʱ�ȭ�Ҷ��� row���� �������Ҽ����°ɱ�?***)
		penNames[0] = "PentelFiner_BLACK";
		penNames[1] = "PentelFiner_RED";
		penNames[2] = "PentelChock_BLACK";
		penNames[3] = "PentelChock_RED";
		penNames[4] = "Holder";	
	}
	
	//������ �ٸ� �޼ҵ带 ȣ���ϰ� ������
	void runTest() {//ȣ���� �޼ҵ� ���� Ȥ�� ����
		System.out.println("\n�ޡޡ�[static�޼ҵ� ���� �Ϲݸ޼ҵ念��]\n");	
		penList();//���ǵ� �ٸ� �޼ҵ� ȣ����
		for(int i=0;i<penNames.length;i++) {//�����迭�� �޾Ƽ� ȣ��� �޼ҵ� ���ο��� �ʱ�ȭ�� ������ ����� 
			System.out.println("penNames["+i+"] = "+penNames[i]);
		}
		//�ڡڡ�for�� �����ϱ� : String�迭�� �������� ���� ����ϴ� for���ڡڡ�
		System.out.println("\n����[������ for������ ����� ���]");	
		for(String pen:penNames) {//for(Ÿ�� �̸�:�ּҹ���)
			System.out.println(pen);
		}
		System.out.println("\n�ޡޡ�[static�޼ҵ� ���� �Ϲݸ޼ҵ念��]");	
	}
	
	//static �޼ҵ� ���� �޼ҵ忡 �ִ� �������� ����ϱ�
	public static void main(String[] args) {
		int newis[] = null;//�����迭 ����
		newis = new int[3];//�迭�� �ʱ�ȭ

		System.out.println("��[static�޼ҵ� ���� �޼ҵ带 �ν��Ͻ�ȭ+ȣ�� & ����ϱ�]");
		Practice_0510_1___Array doRun = new Practice_0510_1___Array();//Ŭ������ �ν��Ͻ�ȭ�Ͽ� �����ϰ� �̸����̱�
		doRun.runTest();//������ Ŭ������ ���ο� �ִ� �ٸ� �޼ҵ带 ȣ���Ѵ�.
				
		System.out.println("\n��[static�޼ҵ� ���� �޼ҵ带 �ν��Ͻ�ȭ+ȣ��+�ʱ�ȭ & ����ϱ�]");
		Practice_0510_1___Array doRun2 = new Practice_0510_1___Array();//Ŭ������ �ν��Ͻ�ȭ�Ͽ� �����ϰ� �̸����̱�
		doRun2.penNames = new String[4];//������ Ŭ������ ���ο� ���ǵ� �����迭�� �����
		doRun2.penNames[0] = "Sharpe";
		doRun2.penNames[1] = "Pluspen_BLUE";
		doRun2.penNames[2] = "Pluspen_GREEN";
		doRun2.penNames[3] = "Pencil";
		
		for(String dodo:doRun2.penNames) {//for(Ÿ��  �̸�:�ּҹ���)
			System.out.println(dodo);
		}
		
	}

}
