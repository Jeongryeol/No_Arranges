package com.oracle.jdbc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

//SELECT의 결과를 담아서 UI에 나타내는 보드매니저 클래스
public class BoardManager_JL extends JFrame implements ActionListener {
	
/*선언부*/
	//DefaultTableModel의 헤더에 담길 컬럼변수(1차배열)와 출력된 값을 담을 데이터변수(2차배열)
	String cols[]	= {"글번호", "제목", "작성자", "작성일", "조회수"};
	String data[][]	= new String[0][5];
	//DefaultTabelModel에 사용할 자료가 위 2구문으로 만들어졌으므로 넣어보자
	DefaultTableModel dtm_board = new DefaultTableModel(data,cols);
	//dtm을 담을 JTable과 JTable을 담아서 연속으로 보이게 할 JScrollPane 속지
	JTable jtb_board = new JTable(dtm_board);
	JScrollPane jsp_board = new JScrollPane(jtb_board
											,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//버튼담기 - 버튼을 4개 담을 속지 GridLayout(1,4)
	JPanel jp_north = new JPanel();
	JButton jbtn_select = new JButton("조회하기");
	JButton jbtn_insert = new JButton("입력하기");
	JButton jbtn_update = new JButton("수정하기");
	JButton jbtn_delete = new JButton("삭제하기");
	//연결용 공통코드 가져오기
	//(드라이버정보, 커넥션정보 가져올 수 있음)
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
/*생정자*/
	public BoardManager_JL() {
		initDisplay();
	}
/*게시글 목록 조회 구현 메소드*/
	/*********************************************
	 * 게시글 목록 조회 구현 메소드
	 * @param : HashMap<String,Object> 해당없음
	 * @return : List<HashMap<String,Object>>
	 * 작성자 : 이정렬
	 *********************************************/
	public ArrayList getBoardList() {
		
		//조회결과를 담아줄 변수 선언
		//(왜? ResultSet을 닫았을때 조회결과를 볼수없어지고, 조회결과를 다른 곳으로 가져가기 위해서 )
		ArrayList<HashMap<String,Object>> lists
			= new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> maps = null;
		
		try {
			
			dbMgr = new DBConnectionMgr();	//서버연결클래스를 인스턴스 오브젝트생성
			con = dbMgr.getConnection();	//이 오브젝트의 연결을 하는 메소드 호출하여 서버연결정보생성
			
			//sql문을 담을 스트링빌더 생성하고, 스트링빌더에 SQL문 담음
			StringBuilder sbd = new StringBuilder();	
			sbd.append("SELECT b_no,b_title,b_content,b_writer,b_date,b_hit FROM jdbc_board");
			
			//pstmt에 연결정보(con)에 따라 preparedStatement()메소드를 호출할때,
			//파라미터에 'sql문을 스트링으로 바꿔넣고 호출'해서 전령을 리턴받아 준비함
			pstmt = con.prepareStatement(sbd.toString());
			
			//DML SQL중 SELECT문은 서버에 요청하고나면 (pstmt 전령을 서버에 요청함 : executeQuery)
			//조회결과가 리턴되므로, 조회결과를 담아줄 변수가 필요함 (리턴타입 : ResultSet)
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {//조회결과의 한 로우의 내용이 모두 입력되면 커서를 이동시킨다.
				maps = new HashMap<String, Object>();
				maps.put("b_no",rs.getInt("b_no"));
				maps.put("b_title",rs.getString("b_title"));
				maps.put("b_writer",rs.getString("b_writer"));
				maps.put("b_date",rs.getString("b_date"));
				maps.put("b_hit",rs.getInt("b_hit"));
				lists.add(maps);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return lists;
	}
	
/*게시글 등록 구현 메소드*/
	/*****************************************
	 * 게시글 등록 구현 메소드
	 * @param : HashMap<String,Object> 꼭 필요함
	 * @return : int
	 * 작성자  : 이정렬
	 *****************************************/
	public int boardInsert(HashMap<String,Object> pMap) {
		int result = 0;
		// 파라미터에 값이 들어있는지 테스트해보기
		System.out.println("제목 : " + pMap.get("b_title"));
		System.out.println("내용 : " + pMap.get("b_content"));
		System.out.println("작성자 : " + pMap.get("b_writer"));

		try {
			dbMgr = new DBConnectionMgr(); // 서버연결클래스를 인스턴스 오브젝트생성
			con = dbMgr.getConnection(); // 이 오브젝트의 연결을 하는 메소드 호출하여 서버연결정보생성

			// sql문을 담을 스트링빌더 생성하고, 스트링빌더에 SQL문 담음
			StringBuilder sbd = new StringBuilder();
			sbd.append("INSERT INTO jdbc_board ( b_no,b_title,b_content,b_writer,b_date " + 
					"VALUES (seq_jdbc_board_no.nextval,?,?,?,TO_CHAR(sysdate,'YYYY-MM-DD'))");
			// pstmt에 연결정보(con)에 따라 preparedStatement()메소드를 호출할때,
			// 파라미터에 'sql문을 스트링으로 바꿔넣고 호출'해서 전령을 리턴받아 준비함
			pstmt = con.prepareStatement(sbd.toString());
			// 물음표 마크에 변수를 입력시켜보자
			pstmt.setString(1, "테스트글제목");
			pstmt.setString(2, "테스트글내용");
			pstmt.setString(3, "테스트글작성자");
			
			// DML SQL중 INSERT,UPDATE,DELETE 문은 서버에 요청하고나면
			// 적용된 로우개수(int)가 리턴되므로, 조회결과를 담아줄 변수가 필요함 (리턴타입 :int)
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
/*게시글 수정 구현 메소드*/
	/*****************************************
	 * 게시글 수정 구현 메소드
	 * @param : HashMap<String,Object> 꼭 필요함
	 * @return : int
	 * 작성자  : 이정렬
	 *****************************************/
	public int boardUpdate(HashMap<String,Object> pMap) {
		int result = 0;
		//파라미터에 값이 들어있는지 테스트해보기
		System.out.println("제목 : "+pMap.get("b_title"));
		System.out.println("내용 : "+pMap.get("b_content"));
		System.out.println("작성자 : "+pMap.get("b_writer"));
		return result;
	}
/*게시글 삭제 구현 메소드*/
	/*****************************************
	 * 게시글 삭제 구현 메소드
	 * @param : int 꼭 PK이어야 함 - 무엇을 삭제할거니?
	 * @return : int
	 * 작성자  : 이정렬
	 *****************************************/
	public int boardDelete(int b_no) {
		int result = 0;
		//파라미터에 값이 들어있는지 테스트해보기
		System.out.println("글번호 : "+b_no);
		return result;
	}
	
/*화면처리부*/
	public void initDisplay() {
		//테이블의 사이즈를 변경시켜보자
		jtb_board.getColumnModel().getColumn(0).setWidth(100);
		//버튼이 여러개이기 때문에 GridLayout이 필요하고,그 레이아웃이 속지(JPanel)에 설정한다.
		//이후에 순서대로 넣는다.
		jp_north.setLayout(new GridLayout(1, 4));
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);
		//액션을 추가하자
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		//속지를 북쪽에 달자
		this.add("North", jp_north);
		//중앙에 표를 설치할거야
		this.add("Center",jsp_board);
		this.setTitle("계층형게시판");
		this.setSize(800,500);
		this.setVisible(true);
	}
/*메인메소드*/
	public static void main(String[] args) {
		BoardManager_JL bm = new BoardManager_JL();
	}
/*오버라이드메소드*/
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jbtn_select) {
			//확인창 띄우기
			System.out.println("조회하기 버튼 액션호출성공");
			JOptionPane.showMessageDialog(this,"조회성공","INFO",JOptionPane.INFORMATION_MESSAGE);
			
			//조회해주는 메소드를 호출해서 반환타입에 맞추어 변수에 담음
			ArrayList<HashMap<String,Object>> selectRs = getBoardList();
			
			//개선된 for문으로 객체(왼쪽)를 오브젝트(오른쪽)에 맞춰서 순서대로 돌림
			for(HashMap<String,Object> item : selectRs) {
				System.out.println(item);
			}
/*			System.out.println("1");
			//버튼 눌렀을때 연결시키면 되겠지?
			dbMgr = new DBConnectionMgr();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b_no, b_title, b_writer, b_date, b_hit FROM jdbc_board");
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				//자료구조에 변화를 주어보자 (VO가 없으므로 해쉬맵으로 해보자)
				//HashMap은 대용량 자료구조의 처리속도에 월등히 빠르다.
				List<HashMap<String,Object>> boardList =
						new ArrayList<HashMap<String,Object>>();
				
				while(rs.next()) {
					HashMap<String,Object> rMap = new HashMap<String, Object>();
					rMap.put("b_no",	rs.getInt("b_no"));
					rMap.put("b_title",	rs.getString("b_title"));
					rMap.put("b_writer",rs.getString("b_writer"));
					rMap.put("b_date",	rs.getString("b_date"));
					rMap.put("b_hit",	rs.getInt("b_hit"));
					boardList.add(rMap);
				}
				//boardList가 0보다 큰 사이즈가 나오면, 연동이 되었는지 아닌지를 확인할 수 있는 단위테스트가 될것이다!!
				System.out.println(boardList.size());
				
			}catch (Exception e) {
				// TODO: handle exception'
			e.printStackTrace();
			
			}////end of try-catch
*/			
		}////////end of if(조회하기)
		else if(obj==jbtn_insert) {
			//확인창 띄우기
			System.out.println("입력하기 버튼 액션호출성공");
			JOptionPane.showMessageDialog(this,"입력성공","INFO",JOptionPane.INFORMATION_MESSAGE);
			
			//해쉬맵에 넣을 자료담기
			HashMap<String,Object> insertHm= new HashMap<String, Object>();
			insertHm.put("b_title","글등록연습");
			insertHm.put("b_content","글등록내용");
			insertHm.put("b_writer","글등록작성자");
			
			//조회해주는 메소드를 호출해서 반환타입에 맞추어 변수에 담음
			
		}////////end of if(입력하기)
		else if(obj==jbtn_update) {
			
		}////////end of if(수정하기)
		else if(obj==jbtn_delete) {
			
		}////////end of if(삭제하기)
		
	}////////////end of actionPerformed()메소드

}////////////////end of class
