package com.ch3;

public class W02_D1_ExcerciseTest {

	public static void main(String[] args) {
		/*�������� 1��
		Which two are legal String declarations? (Choose two.)*/
		String a1 = null;//[�ùٸ� ǥ��]//String s = null;s�� print �ϸ� null �̶�� ��µǳ�?
		String a2 = "aa";//[������ ������ ǥ��]//String s = 'aa'; (���������̼��� �ʿ��� JAVA)
		String a3 = (String)"abc";//[������ ������ ǥ��]//String s = (String)'abc';(���������̼��� �ʿ��� JAVA)
		String a4 = "This is a string";//[�ùٸ� ǥ��] 
		String a5 = "This is a very\nlongstring";//[������ ������ ǥ��]//��������n �� ���ٹ̴� �������, ���峻���� ������ ������(;)�Ǿ����
		
		//�ڡڡڡڡڡڡڡڡڡ��߿� üũ����Ʈ�ڡڡڡڡڡڡڡڡڡ�
		//System.out.println(a1.toString());//[�����ڵ�]
		//��ü�� null�� ���·� ��������� ���� �����̱⶧����,
		//NullPointException ���� �߻��ϰ� �� (�����󿡼� ������ ����)
		
		/*�������� 2��
		Which two are valid declarations of a boolean? (Choose two.)*/
		//boolean b1 = 0;//true�� false ���� ���� �� �ִ� boolean
		boolean b1 = true;//[�ùٸ�ǥ��]//��
	    //boolean b2 = "true";//���ڿ��� ���� �� ����
		//boolean b3= 'true';//���ڿ��� ���� �� ����, ���ڿ��� ���� �����̼��� �ʿ���
		boolean b4 = (3 >= 0);//[�ùٸ� ǥ��]//�񱳿����� �� ���� ���� true false�� �Էµ�
		boolean b5 = Boolean.TRUE;
		
		//�ڡڡڡڡڡڡڡڡڡ��߿� üũ����Ʈ�ڡڡڡڡڡڡڡڡڡ�
		/*boolean isFlag;//[�����ڵ�]
		System.out.println(isFalg);//[�����ڵ�] ������ �ʱ�ȭ�� �ص��� �ʾұ� ������ �������� �߻�

		boolean isFlag;
		isFlag=false;
		System.out.println(isFlag);//[�����ڵ�]//Ȥ��
		
		boolean isFlag=false;
		System.out.println(isFlag);//[�����ڵ�]
		*/
			
		//�ڡڡڡڡڡڡڡڡڡ��߿� üũ����Ʈ�ڡڡڡڡڡڡڡڡڡ�
		/*������ Ÿ���� ������ �޼ҵ带 �Ŵ����� ����.
		 boolean bb1;
		 bb1 = true 
		 System.out.println(bb1.toStinf());//[�����ڵ�] ���� ���� ������Ÿ���� ���� ���� �� �ִ�. 
		 Boolean boo = new Boolean(true);//��,������ Ÿ�� ������ �޼ҵ带 �޴� ��� : Wrapper Ŭ���� (Ŭ������)
		 System.out.println(boo.toString());//����
		 */ 
			
		//�ڡڡڡڡڡڡڡڡڡ��߿� üũ����Ʈ�ڡڡڡڡڡڡڡڡڡ�
		//int�� inteager�� ����� ������ Ŭ���� ���� ��������, 1.5���� ���ķ� �ڵ�����ȯ�� �ǵ��� ������Ʈ �Ǿ� ����.
		
		/*Integer ing = new Integer("50");//Ŭ������ Integer & �ڵ�����ȯ���� ���ڿ��� ���ڿ��� �ٲپ intȭ ����
		System.out.println(ing+10);//����ȯ�� ������ ������
		 
		Interger ing2 = ing.valueOf("60");//�Ϲ������� ���� ing�� �޼ҵ�valueOF()�� �Ŵ����� ������,
		//Integer�� ���� Ŭ���������� �ö� Wrapper Ŭ�����̹Ƿ� ���� 
		 
		Interger ing3 = new Integer("70");@abcd1234
		Interger ing4 = new Integer("70");@abcd1234
		System.out.println(ing3 == ing4);//�� ������ �ּҹ����� ���� ���̱� ������, false �� ����
		System.out.println(ing3.equal(ing3));//�� ������ �����μ� ���� ���̱� ������, true �� ���� :: ����.equal(����)*/

		
		Integer c1 = new Integer(10); //new�� ���� �ٸ� ��ü�� ����� ��
		Integer c2 = new Integer(10);
		Integer c3 = c1;//c1�� ���� ��ü�� ��� �����Ƿ� ���� �ּҹ����� ����
		int c4 = 10;
		double c5 = 10.0;

		/* (c1 == c3) true // Ŭ������ Ŭ������ ���ϸ� ����ִ� �ּҹ����� ���ϰ� �� (���� ��ü ������)
		 * (c4 == c5) true // ������ ������ ���ϸ� ��� �ִ� ���� ���ϰ� �� (����10�� �Ǽ�10.0�� ����)
		 * (c2 == c4) true // Ŭ������ü�� ������ ���ϸ� ����ִ� ���� ���ϰ� ��
		 * (c1 == c2) false// Ŭ������ Ŭ������ ���ϸ� ����ִ� �ּҹ����� ���ϰ� �� (�ٸ� ��ü�� ����) 
		 * (c2 == c3) false// Ŭ������ Ŭ������ ���ϸ� ����ִ� �ּҹ����� ���ϰ� �� (�ٸ� ��ü�� ����)
		 * (c4 == 10.0)true// ������ ���� ���ϸ� ��� �ִ� ���� ���ϰ� �� (����10�� 10.0�� ����)
		 */
		
		Integer cc1 = new Integer(10);
		Integer cc2 = new Integer(10);
		System.out.println(cc1=cc2);//Wrapper Class�� �ּҹ����� ���ϹǷ� false�� ��µ�
		System.out.println(cc1.equals(cc2));//Wrapper Class�� ���� cc1�� equal()�޼ҵ带 �Ŵ����� cc2�� ȣ����. ������ true
		Integer cc11 = new Integer(10);
		Integer cc22 = new Integer(100);
		System.out.println(cc11==cc22);//�ּҹ����� ���ϹǷ� false�� ��µ�
		System.out.println(cc11.equals(cc22));//�ּҹ����� ����Ű�� ���� ����Ƿ� false�� ��µ�.
		Integer cc0 = cc1;//���� C�� ��� new�� �Ἥ Ŭ������ �޸𸮿� �ε��� �� �ƴ϶� ������ �ִ� Ŭ������ ����Ŵ. �׷��� true
		System.out.println(cc1==cc0);//�ּҹ����� ������ ���ϹǷ� true�� ��µ�
		int dd = 10;  	 //�񱳴���� ������ �ּҹ��� �ٸ� ������ �������� ��� d�� �ּҹ����� �����Ƿ� �� �ش�Ǵ� ���� ���ϰ� ��
		double ee = 10.0;//int Ÿ�Ե� 10.0������ ����ֹǷ� doubleŸ�԰� ���� ������ true�� ��µ�.
		System.out.println(dd==ee);		

		
		
		System.out.println(6^3);
		
		String s11 = new String("true");
		Boolean b11 = new Boolean(true);
		if(s11.equals(b11)) { ///����.equals(���ڿ�)
		System.out.println("%nEqual");
				
		}
		
	}

}
