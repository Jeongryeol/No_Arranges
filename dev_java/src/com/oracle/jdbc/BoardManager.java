package com.oracle.jdbc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class BoardManager extends JFrame implements ActionListener {
	//DefaultTableModel
	String cols[] = {"글번호","글제목","작성자","작성일","조회수"};
	//DefaultTableModel
	String data[][] = new String[0][5];
	DefaultTableModel dtm_board
				= new DefaultTableModel(data,cols);
	JTable jtb_board = new JTable(dtm_board);
	JScrollPane jsp_board 
		= new JScrollPane(jtb_board
				         ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				         ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//버튼을 4개 담을 속지-GridLayout(1,4)
	JPanel jp_north = new JPanel();
	JButton jbtn_select = new JButton("조회");
	JButton jbtn_insert = new JButton("입력");
	JButton jbtn_update = new JButton("수정");
	JButton jbtn_delete = new JButton("삭제");
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//생성자
	public BoardManager() {
		
	}
	//게시글 목록 조회 구현 메소드
	/****************************************************************
	 * 게시글 목록 조회 구현 메소드
	 * @param : HashMap<String,Object> 해당없음
	 * @return : List<HashMap<String,Object>>
	 * 작성자 : 유재덕
	 ***************************************************************/
	public List<HashMap<String,Object>> getBoardList(){
		List<HashMap<String,Object>> boardList = 
				new ArrayList<HashMap<String,Object>>();
		
		return boardList;
	}
	//게시글 등록 구현 메소드
	/****************************************************************
	 * 게시글 등록  구현 메소드
	 * @param : HashMap<String,Object> 꼭 필요함
	 * @return : int
	 * 작성자 : 유재덕
	 ***************************************************************/	
	public int boardInsert(HashMap<String,Object> pMap){
		int result=0;
		//파라미터에 값이 들어있는지 테스트 해보기
/*		System.out.println("제목:"+pMap.get("b_title"));
		System.out.println("내용:"+pMap.get("b_content"));
		System.out.println("작성자:"+pMap.get("b_writer"));*/
		dbMgr=DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO jdbc_board (b_no,            ");
        sql.append("        b_title,                         ");
        sql.append("        b_content,                       ");
        sql.append("        b_writer,                        ");
        sql.append("        b_date)                          ");
        sql.append("VALUES (seq_jdbc_board_no.NEXTVAL,       ");
        sql.append("        ?,                        ");
        sql.append("        ?,                           ");
        sql.append("        ?,                           ");
        sql.append("        TO_CHAR (SYSDATE, 'YYYY-MM-DD'))");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pMap.get("b_title").toString());
			pstmt.setString(2, pMap.get("b_content").toString());
			pstmt.setString(3, pMap.get("b_writer").toString());
			result = pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//사용한 자원 반납하기
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}	
	//게시글 수정 구현 메소드
	/****************************************************************
	 * 게시글 수정  구현 메소드
	 * @param : HashMap<String,Object> 꼭 필요함 - 무엇을 수정할거니?
	 * @return : int
	 * 작성자 : 유재덕
	 ***************************************************************/
	public int boardUpdate(HashMap<String,Object> pMap){
		int result=0;
		//파라미터에 값이 들어있는지 테스트 해보기
		System.out.println("제목:"+pMap.get("b_title"));
		System.out.println("내용:"+pMap.get("b_content"));
		System.out.println("작성자:"+pMap.get("b_writer"));
		result = 1;
		return result;
	}	
	//게시글 삭제 구현 메소드
	/****************************************************************
	 * 게시글 수정  구현 메소드
	 * @param : int 꼭 PK이어야 함 - 무엇을 삭제할거니?
	 * @return : int
	 * 작성자 : 유재덕
	 ***************************************************************/	
	public int boardDelete(int b_no){
		int result=0;
		//파라미터에 값이 들어있는지 테스트 해보기
		System.out.println("글번호:"+b_no);
		result = 1;
		return result;
	}	
	//화면처리부
	public void initDisplay() {
		jp_north.setLayout(new GridLayout(1,4));
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		this.add("North", jp_north);
		this.add("Center",jsp_board);
		this.setTitle("계층형 게시판");
		this.setSize(800, 500);
		this.setVisible(true);
	}
	//main메소드
	public static void main(String[] args) {
		BoardManager bm = new BoardManager();
		bm.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jbtn_select) {
			dbMgr=DBConnectionMgr.getInstance();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b_no, b_title, b_writer, b_date, b_hit FROM jdbc_board");
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				List<HashMap<String,Object>> boardList = 
						new ArrayList<HashMap<String,Object>>();
				while(rs.next()) {
					HashMap<String,Object> rMap =
							new HashMap<String,Object>();
					rMap.put("b_no", rs.getInt("b_no"));
					rMap.put("b_title", rs.getString("b_title"));
					rMap.put("b_writer", rs.getString("b_writer"));
					rMap.put("b_date", rs.getString("b_date"));
					rMap.put("b_hit", rs.getInt("b_hit"));
					boardList.add(rMap);
				}
				System.out.println(boardList.size());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//////////////////////end of 조회 끝
		else if(obj==jbtn_insert) {
			int result = 0;
			HashMap<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("b_title","글등록 연습");
			pMap.put("b_content","테스트");
			pMap.put("b_writer","작성자1");
			result = boardInsert(pMap);
			if(result==1) {
				JOptionPane.showMessageDialog(this, "등록성공"
						                   , "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "등록실패"
		                   , "ERROR", JOptionPane.ERROR_MESSAGE);				
			}
		}//////////////////////end of 입력
		else if(obj==jbtn_update) {
			int result = 0;
			HashMap<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("b_no",2);
			pMap.put("b_title","글등록 연습2");
			pMap.put("b_content","테스트2");
			pMap.put("b_writer","작성자2");
			result = boardUpdate(pMap);
			if(result==1) {
				JOptionPane.showMessageDialog(this, "수정성공"
						                   , "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "수정실패"
		                   , "ERROR", JOptionPane.ERROR_MESSAGE);				
			}			
		}//////////////////////end of 수정
		else if(obj==jbtn_delete) {
			int result = 0;
			int b_no = 2;
			result = boardDelete(b_no);
			if(result==1) {
				JOptionPane.showMessageDialog(this, "삭제성공"
						                   , "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "삭제실패"
		                   , "ERROR", JOptionPane.ERROR_MESSAGE);				
			}				
		}//////////////////////end of 삭제
	}//////////////////////////end of actionPerformed

}
