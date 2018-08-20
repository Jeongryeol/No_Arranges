package com.ch11;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vo.EmpVO;

public class EmpManager extends JFrame implements ActionListener {

	EmpController empCtrl = new EmpController();
	
	String[][] data = new String[0][8];
	String[] cols = {"�����ȣ","�����","�׷��ڵ�","JOB","�Ի�����","�޿�","�μ�Ƽ��","�μ���ȣ"};
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	
	JButton jbtn_select = new JButton("��ȸ");
	
	public EmpManager() {
		initDisplay();
	}
	
	public void initDisplay() {
		jbtn_select.addActionListener(this);
		this.add("North",jbtn_select);
		this.add("Center",jsp);
		this.setTitle("������� �ý���");
		this.setSize(900, 500);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jbtn_select) {//������ �׼��� ��ȸ��ư�̴�??
			List<EmpVO> empList = empCtrl.getEmpList(null);	//�������� ���� �ڷḦ List�� ��ƿ�
			Iterator iter = empList.iterator();				//�ڷᱸ���� �����ϴ� Iterator(���ͷ�����)
			
			int size = empList.size();
			
			//while(iter.hasNext()) {//���ʷ��� �ݺ���	//�о�� ���ͷ����Ϳ� ���� ���� �ο��ڷᰡ �ִ�? ������ �������� �ѱ�� �ݺ��Ϸ�
			for(int i=0;iter.hasNext();i++) {		//�������
				if(i==size) break;					//��������϶�, ���������� �������� �ѱ��, �Ѿ ������ ���� ���̹Ƿ� ũ�⺸�� �� ���� �ݺ��ϰ� �Ǳ⶧���� ���� 
				
				//ClassCastException�߻�.. ArrayList�ΰ��� Vector�� �ٲܼ�����!!
				//dtm.addRow((Vector)empList);
				
				Vector<Object> v = new Vector<Object>();//�� �� �ο츦 ���� �����ڷ�
				v.add(empList.get(i).getEmpno());		//�� �� �ο� �������� �÷����� ����� �����Ͱ��� �о ���Ϳ� ���� 
				v.add(empList.get(i).getEname()); 		//List�� ���ȣ�� ���� �����͸� ����
				
				EmpVO evo = null;//�� �ڵ�� �� ������ ��ģ��
				evo = empList.get(i);
				v.add(evo.getMgr());	//EmpVO�̱� ������ �ѹ��� �����ص� ��.
				v.add(evo.getJob());
				v.add(evo.getHiredate());
				v.add(evo.getSal());
				v.add(evo.getComm());
				v.add(evo.getDeptno());
				
				dtm.addRow(v);			//�ο� �� ���� dtm�� �߰��Ͽ� ȭ�鿡 ���
				
				//������Ʈ �迭�� �����ϴ�!! ( Object[] rowdata )
				//dtm.addRow(new EmpVO[5]);
			}
		}
	}

	public static void main(String[] args) {
		new EmpManager();
		//DB�����ڵ� �����׽�Ʈ �غ�����.
/*		EmpController empCtrl = new EmpController();
		List<EmpVO> empList = empCtrl.getEmpList(null);
		System.out.println(empList.size());	*/
	}

}
