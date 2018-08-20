package com.semi.address;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class AddressBookUI implements ActionListener {
	//선언부
	static AddressBookUI aBook = null;
	JFrame 		jf_addr 	= new JFrame();
	JMenuBar 	jmb 		= new JMenuBar();
	JMenu 		jm_file 	= new JMenu("File");
	JMenu 		jm_edit 	= new JMenu("Edit");
	JMenuItem 	jmi_ins 	= new JMenuItem("입력");
	JMenuItem 	jmi_upd 	= new JMenuItem("수정");
	JMenuItem 	jmi_del 	= new JMenuItem("삭제");
	JMenuItem 	jmi_det 	= new JMenuItem("상세조회");
	JMenuItem 	jmi_all 	= new JMenuItem("전체조회");
	JMenuItem 	jmi_exit 	= new JMenuItem("종료");
	//툴바 추가
	JToolBar    jtbBar		= new JToolBar();
	JButton		jbtn_ins	= new JButton();
	JButton		jbtn_upd	= new JButton();
	JButton		jbtn_del	= new JButton();
	JButton		jbtn_det	= new JButton();
	JButton		jbtn_all	= new JButton();
	//JTable추가하기
	String[] header = {"순번","이름","성별"};
	String[][] datas = new String[0][3];
	//데이터셋(구조체)-Object이면 모두 다 OK 
	DefaultTableModel dtm   = new DefaultTableModel(datas,header);
	//폼(양식)-JTable를 인스턴스화 할때 파라미터에 DefaultTableModel 넘긴다(포개)
	JTable 		jtb_addr	= new JTable(dtm);
	//JScrollPane은 도화지(스크롤바)
	JScrollPane jsp_addr	= new JScrollPane(jtb_addr);
	//이미지 경로 변수 선언하기
	String imgPath = "E:\\dev_kosmo201804\\dev_java\\src\\com\\images\\";
	ImageIcon titleIcon = new ImageIcon(imgPath+"address.png");//시작표시줄의 아이콘 경로설정하기
	AddressCUD  aCUD = new AddressCUD();
	//생성자
	public AddressBookUI() {
		initDisplay();
	}
	//화면처리 메소드
	public void initDisplay() {
		
		//JFrame에서 창끝의 X버튼을 클릭했을때 종료명령 처리하기
		jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//위아래 모두, 어플을 완전히 끄는 방법
/*		jf_addr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});//닫기 누른 뒤에 완전종료시키는 윈도우리스너 + 윈도우클로징 
*/		
		//메뉴아이콘의 종료버튼 클릭했을때 종료명령 처리하기
		jmi_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);//자바가상머신과 연결고리르 끊는다.
				//cadidate상태로 해당 자원UI의 연결을 끊고 JVM이 회수함
			}
		});
		
		//이벤트 소스(버튼5개)와 이벤트 처리를 담당하는 클래스(actionPerformed소유)를
		//매핑
		//이벤트처리-이벤트소스가 클릭|체크 감지(ActionListener)
		//이벤트소스와 이벤트 처리 클래스를 매핑(actionPerformed구현클래스)
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});//여기
		jmi_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}			
		});
	//	jbtn_det.addActionListener(this);
		jbtn_det.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//파라미터 e의 역할은 이벤트 소스를 얻을때(이벤트가 어디서 일어났니?)
				detailActionPerformed(e);
				
			}
			
		});
		//jbtn_all.addActionListener(this);
		jbtn_all.addActionListener(new ActionListener() {//익명 클래스 구현하기
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshData(e);
			}
		});
		
		//버튼에 이미지 아이콘 추가하기
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif"));
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif"));
		jbtn_det.setIcon(new ImageIcon(imgPath+"detail.gif"));
		jbtn_all.setIcon(new ImageIcon(imgPath+"search.gif"));
		//툴바 버튼에 풍선말 추가하기
		jbtn_ins.setToolTipText("입력");
		jbtn_upd.setToolTipText("수정");
		jbtn_del.setToolTipText("삭제");
		jbtn_det.setToolTipText("상세조회");
		jbtn_all.setToolTipText("전체조회");
		//툴바에 버튼 추가하기
		jtbBar.add(jbtn_ins);
		jtbBar.add(jbtn_upd);
		jtbBar.add(jbtn_del);
		jtbBar.add(jbtn_det);
		jtbBar.add(jbtn_all);
		jmb.add(jm_file);
		jm_file.add(jmi_exit);
		jmb.add(jm_edit);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jm_edit.add(jmi_det);
		jm_edit.add(jmi_all);
		jf_addr.setJMenuBar(jmb);
		//툴바 북쪽에 배치하기
		jf_addr.add("North",jtbBar);
		jf_addr.add("Center", jsp_addr);
		jf_addr.setIconImage(titleIcon.getImage());//아이콘이미지설치
		jf_addr.setTitle("주소록 Ver1.0");
		jf_addr.setSize(500, 400);
	//	jf_addr.setLocation(800, 300);//창이 열리는 위치를 절대좌표로 지정함 
		Dimension di = Toolkit.getDefaultToolkit().getScreenSize();//현재 윈도우의 사이즈를 계산해줌
		Dimension di2 = jf_addr.getSize();//현재 JFrame의 사이즈를 찾아줌
		jf_addr.setLocation((int)(di.getWidth()/2-di2.getWidth()/2)
						   ,(int)(di.getHeight()/2-di2.getHeight()/2));//창이 열리는 위치를 절대좌표로 지정함 
		jf_addr.setVisible(true);
	}
	/************************************************************************
	 * [상세보기 구현]
	 * @param e - 이벤트소스에  정보  예)e.getSource():Object		 ::객체의 주소번지 리턴
	 * 						      에)e.getActionCommand():String ::버튼의 라벨 등 리턴
	 ************************************************************************/
    protected void detailActionPerformed(ActionEvent e) {
		Object obj	 = e.getSource();
		String label = e.getActionCommand();
		//너 누구에 대한 정보를 보고 싶은 거야?-식별자 PK가 선택되어야함 <ano>
		//사용자(업무담당자)가 선택하고 감지하는건 JVM, 그것을 구현하는것이 개발자
		int index[] = jtb_addr.getSelectedRows();
		if(index.length==0) {//선택은 if문이 효율적
			JOptionPane.showMessageDialog(jf_addr
					                     ,"보고싶은 데이터를 선택하세요"
					                     ,"WARN"
					                     ,JOptionPane.WARNING_MESSAGE);
			return;//선택안했을때 
		} else if (index.length>1) {
			JOptionPane.showMessageDialog(jf_addr
					,"보고싶은 데이터를 1건만 선택하세요"
					,"WARN"
					,JOptionPane.WARNING_MESSAGE);
			return;//선택안했을때 
		} else {//1건이상 선택했을때
			//선택한 로우의 PK인 ano를 읽어오기 - WHERE ano=?
			Integer ano = (Integer)dtm.getValueAt(index[0], 0);
			//getAddressList메소드 호출할때
			//선택한 로우의 PK ano를 AddressVO타입에 담아서 넘겨야 함.
			//그래서 인스턴스화하고, 그 클래스의 ano 변수에 선택한 로우의 ano를 담음.
			AddressVO pavo = new AddressVO();
			pavo.setAno(ano);
			//aDAO의 전체조회와 상세조회를 모두 조회하는 메소드 호출할때 값이 담긴 pavo를 넘김
			AddressBookDAO aDAO = new AddressBookDAO();
			AddressVO ravos[] = aDAO.getAddressList(pavo);
			//배열의 방에 있는 정보를 변수로 꺼냄 			
			AddressVO ravo = null;
			if(ravos.length==1) ravo = ravos[0];
			System.out.println("성별:"+ravo.getGender());
			//자식창에 보여줄 정보들을 초기화하고
			aCUD.set("상세조회",true, aBook,ravo,false);
			//초기화가 끝나면 자식창을 내보낸다(응답)
			aCUD.initDisplay();
		}
		
	}
	//삭제메뉴아이템이나 삭제 아이콘 선택시 작업을 정의
	protected void deleteActionPerformed(ActionEvent e) {
		int[] index = jtb_addr.getSelectedRows();
		int anos[] = new int[index.length];//배열의 길이를 계산하여 방 생성
		int result = 0;
		/*for(int i:index) {
			System.out.println("i:"+i);
		}*/
		if(index.length==0) {//너 삭제할 로우를 선택안했구나?
			JOptionPane.showMessageDialog(jf_addr, "삭제할 로우를 선택하세요.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;//deleteActionPerformed탈출
		}
		else {//너 선택했구나? 1..n개
			int j=0;//선택한 로우의 ano를 담을 방의 index값
			for(int i=0;i<jtb_addr.getRowCount();i++) {
				//System.out.println(dtm.getValueAt(i, 0));
				if(jtb_addr.isRowSelected(i)) {					
					anos[j] = (Integer)dtm.getValueAt(i,0);
					j++;
				}
			}
			for(int ano:anos) {//선택한 로우의 순번이 제대로 입력되었는지 테스트
				System.out.println("ano : "+ano);				
			}
			AddressBookDAO aDAO = new AddressBookDAO();
			result = aDAO.addrDelete(anos);
			JOptionPane.showMessageDialog(jf_addr
					,result+"건이 삭제되었습니다."
					,"INFO",JOptionPane.INFORMATION_MESSAGE);
			refreshData(null);
		}
	}
	//전체 데이터를 다시 조회합니다.
	public void refreshData(ActionEvent e)
	{
		//이미 테이블에 보여지는 데이터가 있는 경우 모두 삭제하고 다시 출력
		while(dtm.getRowCount()>0) {
			dtm.removeRow(0);
		}
		AddressBookDAO aDAO = new AddressBookDAO();
		AddressVO pavo = new AddressVO();
		AddressVO[] ravos = aDAO.getAddressList(pavo);
		for(int i=0;i<ravos.length;i++) {
			Vector oneRow = new Vector();//DefaultTableModel이 addRow()제공,파라미터로 Vector
			oneRow.add(ravos[i].getAno());
			oneRow.add(ravos[i].getA_name());
			oneRow.add(ravos[i].getGender());
			dtm.addRow(oneRow);
		}
	}
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		aBook = new AddressBookUI();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트 소스(버튼5개)의 문자열 
		String label = ae.getActionCommand();
		//이벤트 소스의 주소번지
		Object obj = ae.getSource();
		if(obj==jbtn_ins) {//너 입력버튼 누른거야?
			//자식창을 화면에 띄우기
			aCUD.set("입력",true,aBook,null,true);
			aCUD.initDisplay();
		}
		else if(obj==jbtn_upd) {//너 수정보튼 클릭했어?
			int index[] = jtb_addr.getSelectedRows();
			if(index.length==0) {//선택은 if문이 효율적
				JOptionPane.showMessageDialog(jf_addr
						                     ,"보고싶은 데이터를 1건 선택하세요"
						                     ,"WARN"
						                     ,JOptionPane.WARNING_MESSAGE);
				return;//선택안했을때 
			} else if (index.length>1) {
				JOptionPane.showMessageDialog(jf_addr
						,"보고싶은 데이터를 1건만 선택하세요"
						,"WARN"
						,JOptionPane.WARNING_MESSAGE);
				return;//선택안했을때 
			} else {//1건이상 선택했을때
				//선택한 로우의 PK인 ano를 읽어오기 - WHERE ano=?
				Integer ano = (Integer)dtm.getValueAt(index[0], 0);
				AddressVO pavo = new AddressVO();
				pavo.setAno(ano);
				AddressBookDAO aDAO = new AddressBookDAO();
				AddressVO ravos[] = aDAO.getAddressList(pavo);	
				AddressVO ravo = null;
				if(ravos.length==1) ravo = ravos[0];
				System.out.println("성별:"+ravo.getGender());
				//자식창에 보여줄 정보들을 초기화하고
				aCUD.set("수정",true, aBook,ravo,true);
				//초기화가 끝나면 자식창을 내보낸다(응답)
				aCUD.initDisplay();
			}
		}/////////end of else if
	}/////////////end of actionPerformed
}/////////////////end of AddressBookUI
