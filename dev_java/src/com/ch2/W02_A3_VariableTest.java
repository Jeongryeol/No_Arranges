package com.ch2;

public class W02_A3_VariableTest {

	public static void main(String[] args) {
		//����������int������ ���� �����Ͽ� �� ���ϴ� ���� �������� ���
		int numA = 1;
		int numB = 2;
		int numC = 3;
		int numD = 4;
		int numE = 5;
		int numSum = numA+numB+numC+numD+numE;
		System.out.println("int�� 6�� ����Ͽ� ���� 1~5������ ���� "+numSum);
		System.out.println("");
		//�������������� 100������ ���� �� �Է����ٰ�? �ּ����� ������ �߰��ϴ°��� �ξ� ȿ������ ���̴�.
		int v = 1;
		int hap = 0;
		hap = hap+v;//hap=0+1=1
		v=v+1;//v=2
		hap = hap+v;//hap=1+2=3
		v=v+1;//v=3
		hap = hap+v;//hap=1+2+3=6
		v=v+1;//v=4
		hap = hap+v;//hap=1+2+3+4=10
		v=v+1;//v=5
		hap = hap+v;//hap=1+2+3+4+5=15
		System.out.println("int�� 2���� ����Ͽ� ���� 1~5������ ���� "+hap);
		System.out.println("");
		//�����������ݺ��� ȿ�������� �ϱ� ���� ���� for��
		int newNumSum = 0;
		int newNum = 1;
		for(int i=1;i<6;i=i+1) {//for�� �ȿ��� i��� ���������� �������־�� �ϱ⶧���� int ����� ��
			newNumSum = newNumSum+newNum;
			newNum = i + 1;
		}
		if(newNumSum==15) {//== : ���ǿ� ���� �� ���� ���ٴ� ������ �ɾ��ִ� ���� ���Կ�����2��!!
			System.out.println("for���� ����ؼ� 1~5������ ���� ����� ���� "+newNumSum);
			System.out.println("");
		}
		else {
			System.out.println("�� �ƴϾ�~");
		}
		//�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		//�ڡڡڡڡڡڡڡڡڽ��� �Է����ֽ� ��ȡڡڡڡڡڡڡڡڡڡ�
		//�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		int oh = 1;
		int deoham = 0;//���� �ʱ�ȭ�� 2�� �ϸ� ���� 17�� �����Ƿ� �ʱⰪ�� 0�� �´�.
		deoham = deoham+oh;//0+1
		System.out.println(deoham);//1
		oh = oh+1;//�� ���� ���ؾ��ϴ� ���ڴ� 2
		deoham = deoham+oh;//1+2
		System.out.println(deoham);//3
		oh = oh+1;//�� ���� ���ؾ��ϴ� ���ڴ� 3
		deoham = deoham+oh;//3+3
		System.out.println(deoham);//6
		oh = oh+1;//�� ���� ���ؾ��ϴ� ���ڴ� 4
		deoham = deoham+oh;//6+4
		System.out.println(deoham);//10
		oh = oh+1;//�� ���� ���ؾ��ϴ� ���ڴ� 5
		deoham = deoham+oh;//10+5
		System.out.println(deoham);//15
		System.out.println("");
		System.out.println("1���� 5���� ���� ���� ���� "+deoham);//15
		System.out.println("");
		//�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		//�ڡڡڡڡڡڡڡڡڽ��� �Է����ֽ� �����ڵ�ڡڡڡڡڡڡڡ�
		//�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		int shot = 1;
		int shotSum = 0;
		for(shot=1;shot<6;shot=shot+1) {//1~5���� 5�� �ݺ������� (1,2,3,4,5)
			shotSum = shotSum + shot;//�� �ܰ踶�� ������ shot�� ���ϴ� ���� ������
		}
		System.out.println("1���� 5���� ���� for���� �Ἥ ���� ���� "+shotSum);
		System.out.println("");
		//�������� �������� ����
		//1���� 5������ ¦���� ���� ����Ͻÿ�
		v=2;//���Ӱ� ������ ��ȭ���� �Է�
		hap=0;//hap�� ���� ���ٿ��� 15�� �����ε�, �ʱ�ȭ������ ��ġ�� �ʾ�����,
		hap=hap+v;//�� �ٿ����� ���� 17�� ������  �Ǿ� ���ϴ� ����� ��ư� �ȴ�.
		v=v+2;//v�� ���� ¦���� ã������ 2�� ����
		hap=hap+v;
		System.out.println("�������� ������ ������ 1���� 5���� ¦���� ���� "+hap);
		System.out.println("");
		
	}

}
