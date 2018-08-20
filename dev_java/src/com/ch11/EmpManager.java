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
	String[] cols = {"사원번호","사원명","그룹코드","JOB","입사일자","급여","인센티브","부서번호"};
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	
	JButton jbtn_select = new JButton("조회");
	
	public EmpManager() {
		initDisplay();
	}
	
	public void initDisplay() {
		jbtn_select.addActionListener(this);
		this.add("North",jbtn_select);
		this.add("Center",jsp);
		this.setTitle("사원관리 시스템");
		this.setSize(900, 500);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jbtn_select) {//감지된 액션이 조회버튼이니??
			List<EmpVO> empList = empCtrl.getEmpList(null);	//서버에서 받은 자료를 List로 담아옴
			Iterator iter = empList.iterator();				//자료구조에 접근하는 Iterator(이터레이터)
			
			int size = empList.size();
			
			//while(iter.hasNext()) {//기초레벨 반복문	//읽어온 이터레이터에 현재 읽을 로우자료가 있니? 있으면 다음으로 넘기고 반복하렴
			for(int i=0;iter.hasNext();i++) {		//권장사항
				if(i==size) break;					//권장사항일때, 마지막에서 다음으로 넘기고, 넘어간 다음은 없는 곳이므로 크기보다 더 많이 반복하게 되기때문에 멈춤 
				
				//ClassCastException발생.. ArrayList인것을 Vector로 바꿀수없음!!
				//dtm.addRow((Vector)empList);
				
				Vector<Object> v = new Vector<Object>();//한 개 로우를 담을 벡터자료
				v.add(empList.get(i).getEmpno());		//한 개 로우 데이터의 컬럼값에 저장된 데이터값을 읽어서 벡터에 담음 
				v.add(empList.get(i).getEname()); 		//List의 방번호를 들어가서 데이터를 얻어옴
				
				EmpVO evo = null;//위 코드는 이 문장을 합친것
				evo = empList.get(i);
				v.add(evo.getMgr());	//EmpVO이기 때문에 한번만 연결해도 됨.
				v.add(evo.getJob());
				v.add(evo.getHiredate());
				v.add(evo.getSal());
				v.add(evo.getComm());
				v.add(evo.getDeptno());
				
				dtm.addRow(v);			//로우 한 개씩 dtm에 추가하여 화면에 띄움
				
				//오브젝트 배열도 가능하다!! ( Object[] rowdata )
				//dtm.addRow(new EmpVO[5]);
			}
		}
	}

	public static void main(String[] args) {
		new EmpManager();
		//DB연동코드 단위테스트 해보세요.
/*		EmpController empCtrl = new EmpController();
		List<EmpVO> empList = empCtrl.getEmpList(null);
		System.out.println(empList.size());	*/
	}

}
