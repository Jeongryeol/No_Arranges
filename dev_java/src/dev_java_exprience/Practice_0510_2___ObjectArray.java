package dev_java_exprience;

//Ÿ��Ű���� Ŭ������ �ҷ����� ���, �ҷ��� Ŭ������ main�޼ҵ尡 public�϶� ������
//�̶� import�� ���� �����ϴ� ���� �ڵ��Է¿� ������.
import dev_java_exprience.Practice_0510_2___ObjectArraySub;

public class Practice_0510_2___ObjectArray {

	public static void main(String[] args) {
		//�ҷ��� Ŭ������ ������Ű�� ���ο� �迭�� ������
		Practice_0510_2___ObjectArraySub stud_names[] = new Practice_0510_2___ObjectArraySub[5];
		//�ҷ��� Ŭ������ �����Ͽ� ������ ������
		Practice_0510_2___ObjectArraySub studs = new Practice_0510_2___ObjectArraySub();
		//������ �� �迭�� �濡 ������ ������ �ʱ�ȭ��Ŵ  
		stud_names[0] = studs;
		//����ϸ� �ּҹ����� ��µǰ�, ���� �迭�� ���� �ҷ��� Ŭ������ ���ǵ� ���̸�ŭ ���(null)���� ��ϵ�
		for(int i=0;i<stud_names.length;i++) {
			System.out.println(stud_names[i]);
		}
		
		System.out.println("\n�ڡڡڡڡ�JAVA�󿡼� DB�� �����ϱ� ���� 1����ü�迭 �����ϱ�ڡڡڡڡ�\n");

		//�ҷ��� Ŭ������ ������Ű�� ���ο� �迭�� ������ (���̺���)
		Practice_0510_2___ObjectArraySub high_studs[] = new Practice_0510_2___ObjectArraySub[4];
		//�ҷ��� Ŭ������ �����Ͽ� ������ ������ (������ �� �ּҹ����� ����)
		Practice_0510_2___ObjectArraySub high_stud = new Practice_0510_2___ObjectArraySub();
		high_stud.stud_no 	= 20050001;//�� ������ ���� �ʱ�ȭ ��
		high_stud.stud_name = "ȫ�浿";
		high_stud.stud_age 	= 14430000;
		high_stud.stud_grd	= "������";
		high_studs[0]		= high_stud;//������ �迭(���̺�)�� 0����(1���ο�)�� ������ ������ �Է���
		
		high_stud = new Practice_0510_2___ObjectArraySub();//���ο� �ּҹ��� �ο�
		high_stud.stud_no 	= 20050002;//�� ������ �ٽ� ���� �ʱ�ȭ ��
		high_stud.stud_name = "������";
		high_stud.stud_age 	= 9481228;
		high_stud.stud_grd	= "�����";
		high_studs[1]		= high_stud;//������ �迭(���̺�)�� 1����(2���ο�)�� ������ ������ �Է���
		
		high_stud = new Practice_0510_2___ObjectArraySub();//���ο� �ּҹ��� �ο�
		high_stud.stud_no 	= 20050003;//�� ������ �ٽ� ���� �ʱ�ȭ ��
		high_stud.stud_name = "��������";
		high_stud.stud_age 	= 6290000;
		high_stud.stud_grd	= "������";
		high_studs[2]		= high_stud;//������ �迭(���̺�)�� 2����(3���ο�)�� ������ ������ �Է���
		
		high_stud = new Practice_0510_2___ObjectArraySub();//���ο� �ּҹ��� �ο�
		high_stud.stud_no 	= 20050004;//�� ������ �ٽ� ���� �ʱ�ȭ ��
		high_stud.stud_name = "��Ȳ";
		high_stud.stud_age 	= 15020103;
		high_stud.stud_grd	= "������";
		high_studs[3]		= high_stud;//������ �迭(���̺�)�� 3����(4���ο�)�� ������ ������ �Է���
		
		//����ϱ�
		for(int i=0;i<high_studs.length;i++) {
			Practice_0510_2___ObjectArraySub high_studsA = high_studs[i];
			System.out.printf("�й� : %d / �̸� : %s / ������� : %d / ����б� : %s%n"
						     ,high_studsA.stud_no
						     ,high_studsA.stud_name
						     ,high_studsA.stud_age
						     ,high_studsA.stud_grd);
		}
	}

}
