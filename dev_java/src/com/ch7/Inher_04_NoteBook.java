package com.ch7;

public class Inher_04_NoteBook extends Inher_03_Sorento{
	//ObjectŸ���� ������ �� �ִ�.
	public boolean isTyupeCheck(Inher_04_NoteBook nb) {
		boolean isOk = true;
		//instanceof �����ڿ� ���� �˾ƺ��ÿ�.
		if(nb instanceof Inher_04_NoteBook) {
			isOk = true;
		}
		else if (nb instanceof Inher_03_Sorento) {//�� ������ �����ΰ�?
			
		}
		//nb�� NoteBook Ÿ������ SorentoŸ���� �ƴϹǷ� �����Ͽ����� �߻���.
		//instanceof�� �ν��Ͻ������� ���� Ÿ�������� ���ϴ� ��������.
		return isOk;  
	}
	
	@Override
	public String toString() {
		return "���� �Ｚ��Ʈ���Դϴ�.";
		//toString�� ��Ӱ��踦 �������� �ʾƵ� �⺻������ ����Ǵ�
		//����Ŭ���� Object�� �޼ҵ� �� �ϳ���, �������̵�� �������Ͽ� ��밡���ϴ�.  
	}
	
	public static void main(String[] args) {
		Inher_04_NoteBook nb = new Inher_04_NoteBook();
		System.out.println(nb.toString());
		
		boolean isOk = nb.isTyupeCheck(nb);
		if(isOk) {
			System.out.println("���� NoteBookŸ���� �½��ϴ�.");
		}else {
			System.out.println("���� NoteBookŸ���� �ƴմϴ�.");
		}
	}
}
