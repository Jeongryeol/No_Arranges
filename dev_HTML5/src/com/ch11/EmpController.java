package com.ch11;


import java.util.List;

import com.vo.VO_FoodStore;

public class EmpController {//���������� ������ ���� �б�ó���� �ϴ� Ŭ������ ����

	final static String _INS = "insert";//��ȯŸ�� : int
	final static String _UPD = "update";//��ȯŸ�� : int
	final static String _DEL = "delete";//��ȯŸ�� : int
	final static String _SEL = "select";//��ȯŸ�� : ResultSet( Cursor������ �ʿ��� )
	
	VO_FoodStore	pevo = new VO_FoodStore();
	EmpDAO	eDao = new EmpDAO();//JDBC����Ŭ����
	
	public int CUDEmp() {//�Է�,����,������ �б��� �޼ҵ�
		int result = 0;
		if(_INS.equals(pevo.getCommand())) {
			
		}else if(_UPD.equals(pevo.getCommand())){
			
		}else if(_DEL.equals(pevo.getCommand())) {
			
		}
		return result;
	}
	
	public List<VO_FoodStore> getEmpList(VO_FoodStore evo){
		
		return null;
	}
}
