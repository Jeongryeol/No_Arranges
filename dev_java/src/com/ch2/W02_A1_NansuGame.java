package com.ch2;

public class W02_A1_NansuGame {

	public static void main(String[] args) {
		//��ǻ�Ͱ� ä���� ���ڸ� ��� ���� dap
		int dap = 3;
		//����ڰ� �Է��� ���� ���� ����
		int user = -1; //0~9 �������� ��ȿ�� ������ ���� ��ȹ�̹Ƿ�, �������� ���� �ʱ�ȭ�������� ����
		//-1�̶�� ���� ���α׷��迡���� end of file �̶�� �Ͽ� ���̻� ã���� ������, Ȥ�� ������ �� ã������ ����ϴ� ��������� ���� ���
		user = 7;
		String hint = "";
		if(user>dap) {//-1�� 7���� ũ��? true of flase - boolean
			hint = "�����";//if�� ��ȣ�ȿ� ���ǽ��� ���϶��� ����Ǵ� ������.
			System.out.println(hint);
		}
		else if(user<dap) {//-1�� 7���� �۴�, �� ��÷
			hint = "������";
			System.out.println(hint);
		}
		else if (user==dap) {
			System.out.println("�����մϴ�...¦¦¦...");
			System.exit(0);//�ڹٰ���ӽŰ� ������� ��� ������ ������ (��ȣ���� 0��  �����Ҷ� ���� ��ӵ� ��� System.exit(0);�� �Ѽ�Ʈ)
		}
		
	}

}
