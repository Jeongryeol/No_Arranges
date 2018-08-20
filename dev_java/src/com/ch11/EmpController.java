package com.ch11;


import java.util.ArrayList;
import java.util.List;

import com.vo.EmpVO;

public class EmpController {//���������� ������ ���� �б�ó���� �ϴ� Ŭ������ ����

	final static String _INS = "insert";//��ȯŸ�� : int
	final static String _UPD = "update";//��ȯŸ�� : int
	final static String _DEL = "delete";//��ȯŸ�� : int
	final static String _SEL = "select";//��ȯŸ�� : ResultSet( Cursor������ �ʿ��� )
	
	EmpVO	pevo = new EmpVO();
	EmpDAO	eDao = new EmpDAO();//JDBC����Ŭ����
	
	public int CUDEmp() {//�Է�,����,������ �б��� �޼ҵ�
		int result = 0;
		if(_INS.equals(pevo.getCommand())) {
			
		}else if(_UPD.equals(pevo.getCommand())){
			
		}else if(_DEL.equals(pevo.getCommand())) {
			
		}
		return result;
	}
	//�ּ��� ���̴� ������ �ݵ�� ���� ��!!
	/********************************************************
	 * ������ ��ȸ ����
	 * @param	evo - ����ڰ� ������ ���� (���� �˻��� �� )
	 * @return	List<EmpVO>
	 * @since	2018-07-05
	 * @author	������
	 ********************************************************/
	public List<EmpVO> getEmpList(EmpVO evo){
		//��ȯŸ�� ����
		List<EmpVO> empList = new ArrayList<EmpVO>();
		//��ü��ȸ
		empList = eDao.getEmpList(evo);
		
		return empList;
	}
}
