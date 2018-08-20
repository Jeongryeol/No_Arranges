package com.oracle.jdbc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

/**********************************************
 * util폴더의 DBConnectionMgr의 연결정보 생성을 토대로
 * Oracle DB에 저장된 계층형 게시판의 데이터를 가지고 와서 표시해보자
 * 
 * 이 클래스는 화면출력을 구현하기위해 JFrame을 상속받았다.
 * 이 클래스는 버튼액션을 구현하기위해 ActionListener를  상속받았다.
 * 
 * 0.생성자
 * 1.UI 구현메소드
 * 2.게시판목록 조회 구현메소드
 * 3.게시판목록 입력 구현메소드
 * 4.게시판목록 수정 구현메소드
 * 5.게시판목록 삭제 구현메소드
 * ++메인메소드
 * ++오버라이드메소드(구현체)
 **********************************************/
public class BoardManager_JL2 extends JFrame implements ActionListener{
	/*선언부*/
	//화면 결과를 표시하려면, DB에 있는 컬럼내용과 같은 컬럼을 가진 표가 화면에 필요하다 ( JTable )
	//JTable에 담길 DefaultTableModel, DTM을 구성하는 컬럼(1차배열)과 데이터볼륨(2차배열)
	String cols_name[] 	= {"사원번호", "사원명", "직책", "고용일자", "연봉"};
	String datas[][] 	= new String[0][5];//컬럼이 들어갈 자리만 있으면 되니까 로우는 0
	DefaultTableModel dtm_board_JL
						= new DefaultTableModel(datas, cols_name);
										//파라미터(데이터볼륨(2차배열),볼륨의 컬럼명(1차배열))
	JTable jtb_board2 	= new JTable(dtm_board_JL);//JTable에 DTM을 담는다
	JScrollPane jsp_board2 = new JScrollPane(jtb_board2,//JScollPane에 담고 스크롤시각정책을 정의한다.
									JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
									JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//JScrollPane << JTable << DefalutTableModle << data[][](결과데이터 2차배열), cols[](컬럼 1차배열)
	
	//SQL문을 사용하는 4개 버튼을 생성함
	//JButton이 여러개이면, GridLayout으로 담겨야한다
	//GridLayout은 JPanel에서 그 배치를 설정할 수 있다.
	JPanel jp_north_4b = new JPanel();
	JButton jbtn_select = new JButton("조회");
	JButton jbtn_insert = new JButton("입력");
	JButton jbtn_update = new JButton("수정");
	JButton jbtn_delete = new JButton("삭제");
	
	//결과를 담을 테이블이 생성되었으므로, 서버에서 SQL문을 요청하여 결과를 받기위해 서버에 접속 및 결과담기를 준비한다.
	//서버연결정보의 결과인 Connection은 util폴더에 DBConnectionMgr가 있다.
	DBConnectionMgr dbcMgr	= null;	//연결할때 인스턴스
	Connection		con		= null;	//dbcMgr.getConnection():Connection
	PreparedStatement pstmt	= null;	//con을 토대로 서버에 요청할 SQL쿼리문이 동적쿼리이므로 이것을 담을 동적전령 pstmt
	ResultSet		rs		= null;	//SELECT문의 리턴값은 ResultSet이고 여기에 조회결과값이 담겨있음
	int				rpoint	= 0;	//INS,UPD,DEL문의 리턴값은 int이고 여기에 결과개수가 0,1이 담김
	//ResultSet을 담아서 다른 클래스로 넘어가려면 List<HashMap<String.Object>>가 필요함 (각 메소드에서 재정의할 예정)
	List<HashMap<String,Object>> lists					
		= new ArrayList<HashMap<String,Object>>();	//해쉬맵을 담는 어레이리스트를 만들자(전역으로)
	
	/*생성자*/
	public BoardManager_JL2() {//메인메소드의 인스턴스화로 호출되는 디펄트메소드
		initDisplay();//화면처리부 호출
	}
	/*사용자정의메소드*/
	public void initDisplay() {//화면처리부
		//버튼을 속지에 붙인다.(GridLayout(세로길이,가로길이))
		jp_north_4b.setLayout(new GridLayout(1,4));//1로우 4컬럼으로 4칸을 횡으로 배치할 자리 생성
		jp_north_4b.add(jbtn_select);
		jp_north_4b.add(jbtn_insert);
		jp_north_4b.add(jbtn_update);
		jp_north_4b.add(jbtn_delete);
		//버튼의 액션감지를 준비한다.
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		//JFrame의 위치에 속지와 테이블을 붙인다
		this.add("North",jp_north_4b);
		this.add("Center",jsp_board2);
		//외각 JFrame을 설정함
		this.setTitle("DB연동하여 게시판출력하기(2차시도)");
		this.setSize(600, 500);
		this.setVisible(true);
		//확인용 메소드완료팝업창 
		//JOptionPane.showMessageDialog(this, "화면팝업완료", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	public void boardSelect() {//게시판 조회하기
		
	}
	/*메인메소드*/
	public static void main(String[] args) {//가장 먼저 실행되는 메인메소드
		new BoardManager_JL2();//인스턴스+디펄트생성자 호출
	}
	/*구현체메소드-오버라이드*/
	@Override
	public void actionPerformed(ActionEvent ae) {
		//JOptionPane.showMessageDialog(this, "버튼액션감지", "INFO2", JOptionPane.INFORMATION_MESSAGE); //확인용 메소드완료팝업창
		Object obj = ae.getSource();					//액션이벤트의 소스를 오브젝트로 담는다
		
		//서버로부터 조회를 진행하고 >> 조회된 결과값을 받아서 자료구조로 담고 >> 담은 자료구조를 화면에 띄운다
		dbcMgr = DBConnectionMgr.getInstance();			//DBConnectionMgr에 인스턴스화하는 메소드 호출 :리턴값은 인스턴스값
		con = dbcMgr.getConnection();					//연결정보담기
		StringBuilder sb_sql = new StringBuilder();		//연결정보에 보낼 전령과 전령에 담을 sql문 준비
		
		if(obj==jbtn_select) { //감지된 액션이 조회버턴을 담는거라면
			try {
				sb_sql.append("SELECT empno, ename, job, hiredate, sal FROM emp");	//sql문 추가하기
				pstmt = con.prepareStatement(sb_sql.toString());			//연결정보를 토대로 전령에 sql문 담기
			//	pstmt.setString(parameterIndex, x);		//동적쿼리를 구성할때, 변동되는 ?자리에 값  대치할때 사용하는 메소드 setString
				rs = pstmt.executeQuery(); 				//sql문을 담아준 전령으로 서버에 요청하고 결과값 담아두기 (SELECT문이기 때문)
				
				//담아둔 결과값을 자료구조로 옮겨담기
				while(rs.next()) {									//만약 결과값의 커서가 다음으로 이동이 된다면
					HashMap<String,Object> hmaps
						= new HashMap<String, Object>();			//새로운 해쉬맵을 만들고
			//기본꼴	hmaps.put("담을인덱스명", rs.getType("컬럼명"));		//어떤 컬럼명의 자료를 어떤 타입으로 어떤 인덱스를 달아서 해쉬맵에 넣어라
					hmaps.put("empno", rs.getInt("empno"));			//empno컬럼의 값을 int형으로 empno인덱스를 달아서 해쉬맵에 넣어라
					hmaps.put("ename", rs.getString("ename"));
					hmaps.put("job", rs.getString("job"));
					hmaps.put("hiredate", rs.getString("hiredate"));
					hmaps.put("sal", rs.getInt("sal"));			//empno컬럼의 값을 int형으로 empno인덱스를 달아서 해쉬맵에 넣어라
					lists.add(hmaps);								//해쉬맵을 어레이리스트에 넣어라
				}
			//	System.out.println(lists);//확인용 출력구문
				
				//개선된 for문으로 해쉬맵의 값을 dtm에 담기
				//Lists(오른쪽)에 담겨있는 Hashmap타입의 hmaps(왼쪽)을 순서대로 돌려보자
				for(HashMap<String,Object> hmaps:lists) {
					Vector ss = new Vector();				//1개의 로우를 담을 새로운 자료구조 생성 (dtm은 Vector자료형을 받을 수 있음)
			/*		System.out.println(hmaps.get("empno"));
					System.out.println(hmaps.get("ename"));
					System.out.println(hmaps.get("job"));		//hmaps.get("인덱스이름") : 해당 이름으로 된 해쉬맵의 값을 얻어온다
					System.out.println(hmaps.get("hiredate"));
					System.out.println(hmaps.get("sal"));	*/	//확인용 출력구문
					
					ss.add(hmaps.get("empno"));				//해쉬맵의 인덱스로 값을 불러온 다음에 Vector에 담음
					ss.add(hmaps.get("ename"));
					ss.add(hmaps.get("job"));
					ss.add(hmaps.get("hiredate"));
					ss.add(hmaps.get("sal"));
					
					dtm_board_JL.addRow(ss);				//Vector를 dtm에 1개의 로우로 옮겨담음 (여기서 실제적인 화면의 한줄이 채워짐)
															//for문이 끝날 때까지 반복되어 모든 로우가 담김
				}
				
			}catch (SQLException se) {
				se.printStackTrace();
			}catch (Exception e) {

			}//////////////end of try-catch
			
		}//////////////////end of if(obj==jbtn_select)
		
	}//////////////////////end of actionPerformed(ActionEvent ae)
	
}//////////////////////////end of class
