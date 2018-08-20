package com.semi.addressbook_2nd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

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

/*
 * 사용자와 시스템이 소통하기 위한 UI를 실행시킬 클래스
 * 화면을 구성하는 프레임과 버튼, 조히검색결과와 삭제결과를 보자
 * 이 곳에서 입력창과 수정창을 다시켜서(Dialog) 다른 클래스와 연동해보자
 */
public class AddressBookUI {

	//선언부 (전역변수 및 전역인스턴스변수 선언)
	Addr_DBConnectionMgr dbcon = new Addr_DBConnectionMgr();//DB서버와 연결
	Connection con = null;//JavaAPI SQL용 연결API Connection 클래스타입 변수선언 (연결정보저장)
	Statement stmt = null;//JavaAPI SQL용 전령API Statement 클래스타입 변수선언 (송수신정보저장)
	ResultSet rs   = null;//JavaAPI SQL용 결과API ResultSet 클래스타입 변수선언 (결과정보 저장)
	
	String [][] addrArray = null;//조회결과를 담을 2차배열 변수선언
	
	//선언부2 (화면-메뉴를 구성할 변수 선언)
	JFrame		jf_addr		= new JFrame();
	JMenuBar	jmb_addr	= new JMenuBar();
	JMenu		jm_file		= new JMenu("File");
	JMenu		jm_edit		= new JMenu("edit");
	JMenuItem	jmi_ins		= new JMenuItem("입력");
	JMenuItem	jmi_upd		= new JMenuItem("수정");
	JMenuItem	jmi_del		= new JMenuItem("삭제");
	JMenuItem	jmi_det		= new JMenuItem("상세조회");
	JMenuItem	jmi_all		= new JMenuItem("전체조회");
	JMenuItem	jmi_exit	= new JMenuItem("종료");
	
	//선언부3 (화면-툴바를 구성할 변수선언)
	JToolBar	jtb			= new JToolBar();
	JButton		jbtn_ins	= new JButton();
	JButton		jbtn_upd	= new JButton();
	JButton		jbtn_del	= new JButton();
	JButton		jbtn_det	= new JButton();
	JButton		jbtn_all	= new JButton();
	JButton		jbtn_exit	= new JButton();
	
	//선언부4 (화면-툴바아이콘의 이미지경로 설정)
	String imgPath = "E:\\dev_kosmo201804\\dev_java\\src\\com\\images";
	
	//선언부5 (화면-결과자료를 구성할 변수선언)
	String[][]	datas_addr	= new String [50][4];//데이터의 크기정의
	String[]	header_addr	= {"순번","이름","핸드폰","이메일주소"};//데이터의 컬럼명을 정의
	DefaultTableModel dtm_addr = new DefaultTableModel(datas_addr, header_addr);//데이터를 정리해두는 기본데이터셋
	JTable jt_addr = new JTable(dtm_addr);//데이터셋을 볼수있도록 담아주는 JTable
	JScrollPane jsp_addr = new JScrollPane(jt_addr);//JTable을 담아줄 도화지 역할을 하는 JScrollPane
	
	//선언부6 (실행용 외부메소드 인스턴스화)
	AddressCUD addrCUD = new AddressCUD();
	
	
	
	//생성자
	//default생성자를 별도로 지정하여 메인메소드에서 인스턴스화하면 자동으로 실행되도록 설정
	public AddressBookUI() {}
	
	
	
	//사용자정의 메소드
	//화면을 켜도록 구성하는 메소드
	public void initDisplay() {
		//이벤트소스 역할을 하는 5개의 버튼과 이벤트처리를 담당하는 클래스(actionPerformed소유)를 매핑
		//이벤트처리	:: 이벤트소스가 클릭|체크 되는것을 감지 ( ActionListener 로 감지 )
		//이벤트 핸들러	:: 이벤트소스와 이벤트처리를 매핑	 ( ActionPerformed  로 감지 )
		jbtn_ins.addActionListener((ActionListener)this);
		jbtn_upd.addActionListener((ActionListener)this);
		
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {deletActionPerformed(e);} });
		jmi_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {deletActionPerformed(e);} });
	}
	
	//검색기능을 실행하는 메소드 (SELECT) //SQL : SELECT * FROM 집합명 WHERE 이름 = '이름(입력값)'
	public String[][] getAddressList(String name) {
		//오라클(DB)서버에 전달할 SQL문 작성(초기화)
		String sql = "SELECT addno, addname, addhp, addemail FROM ADDRASS";
		sql +=" WHERE addname = '"+name+"' ORDER BY addno";
		//전달시도
		try {//결과배열의 크기가 달라질때에 대응하기위한 방법
			stmt = dbcon.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE//연결정보저장할 createStatement()메소드 인스턴스화
					 					    ,ResultSet.CONCUR_UPDATABLE);//그리고 스크롤에 따라 커서를 이동을 가능하게하는 메소드를 파라미터에 입력 
			System.out.println("[[query]]"+sql);//쿼리문 출력
	        rs = stmt.executeQuery(sql);
	        ResultSetMetaData column = rs.getMetaData();//rs커서의 (컬럼)주소값을 받아오는 함수
	        rs.last();//커서를 제일 마지막으로 이동시킴
	        int row = rs.getRow();//커서의 로우정보를 얻어서 int변수에 저장함
	        rs.beforeFirst();//커서를 다시 처음으로 복귀시킴
	  		
	        String[][] addrArray = new String[row][column.getColumnCount()];//조회된 결과에 따른 배열크기를 정의
	  		int count = 0;//로우번호를 담을 변수선언
	  	    while(rs.next()) {//커서를 이동시키면서 배열에 정리
	  	    				 addrArray[count][0] = rs.getString("addno");
	  	    				 addrArray[count][1] = rs.getString("addname");
	  	    				 addrArray[count][2] = rs.getString("addhp");
	  	    				 addrArray[count][3] = rs.getString("addemail");
	  	    				 count += 1;//배열정의가 끝나면 로우번호를 1개 올림
	  	    }//while문으로 반복
	  	    
	  	    for(int i=0;i<addrArray[i].length;i++) {
	  	    	for(int j=0;j<addrArray[i][j].length();j++) {
	  	    		System.out.print(addrArray[i][j]);
	  	    	}
	  	    }//for문으로 결과출력확인
		} catch(Exception e) {}
		return addrArray;//조회결과를 담는 리턴값 설정
	}
	
	//삭제기능을 실행하는 메소드 (DELETE) //SQL : DELETE FROM 집합이름 WHERE 조건
	public  void deletActionPerformed(ActionEvent e) {
		int[] index= jt_addr.getSelectedRows();//JTable에 띄워진 값을 선택한 것에 대한 로우를 인식하고 get함
		if(index.length==0) {//선택된 로우가 없어서 배열의 길이가 0일때
			JOptionPane.showMessageDialog(jf_addr,"삭제할 대상을 선택해주세요.","INFO"
										 ,JOptionPane.INFORMATION_MESSAGE);
		} else {//뭔가 선택했구나
			for(int i=0;i<dtm_addr.getRowCount();i++) {//전체 데이터양식의 로우값을 얻으면 for문의 최고범위 설정가능
				if(jt_addr.isRowSelected(i))//JTable에 보여진 값중에서 선택되어있으면 불린값을 리턴받고
				{System.out.println(dtm_addr.getValueAt(i,0));}//입력된 값을 리턴함
			}
		}
		
	}
	
	
	
	//메인메소드
	//메인메소드 (실행부)
	public static void main(String[] args) {
		AddressBookUI test = new AddressBookUI();
		test.getAddressList("신철우");
	}

}
