package com.semi.address;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddressCUD extends JDialog implements ActionListener {
	//JDialog 	jdi_cud 	= new JDialog();
	JLabel 		jlb_name 	= new JLabel("이름 :");
	JTextField 	jtf_name	= new JTextField(20);
	JLabel 		jlb_id 	= new JLabel("아이디 :");
	JTextField 	jtf_id	= new JTextField(10);
	JLabel 		jlb_pw 	= new JLabel("비번 :");
	JTextField 	jtf_pw	= new JTextField(10);
	JLabel 		jlb_gender 	= new JLabel("성별 :");
	String[]    genderList  = {"남자","여자"};
	JComboBox 	jcb_gender	= new JComboBox(genderList);
	JLabel 		jlb_bigo 	= new JLabel("비교 :");
	JTextArea 	jta_bigo	= new JTextArea(3,20);
	JScrollPane jsp_bigo    = new JScrollPane(jta_bigo);
	JPanel      jp_center   = new JPanel();
	//버튼 추가하기
	JButton     jbtn_cud	= new JButton();
	JButton     jbtn_cancel	= new JButton("취소");
	//자식창이 활성화|비활성(메모리에는 로딩되어 있지만 화면에는 안보임)
	boolean isView = false;
	//자식창에 타이틀 담기
	String title = null;
	//부모창에 주소번지를 담기-원본
	AddressBookUI aBook = null;
	AddressVO pvo = null;
	AddressBookDAO aDAO = new AddressBookDAO();
	public AddressCUD() {
	}
	//파라미터를 갖는 생성자가 하나라도 있으면 디폴트 생성자는 제공안됨.
	public AddressCUD(boolean isView) {
		this.isView = isView;
	}
	//부모창에서 자식창 설정하기
	public void set(String title, boolean isView, AddressBookUI aBook) {
		this.title = title;
		this.isView = isView;
		this.aBook = aBook;
	}
	//부모창에서 자식창 설정하기
	/******************************************************************
	 * 부모창에서 자식창 설정관련 코드 추가
	 * @param title - 입력|수정|상세조회
	 * @param isView - 자식창을 활성화|비활성
	 * @param aBook - 부모창의 주소번지 - 새로고침
	 * @param pvo - select한 결과
	 * @param isOk - 입력컴포넌트를 활성화|비활성화
	 *****************************************************************/
	public void set(String title, boolean isView, AddressBookUI aBook
			      , AddressVO pvo, boolean isOk) {
		this.title = title;
		this.isView = isView;
		this.aBook = aBook;
		this.pvo = pvo;
		this.setValue(pvo);
		this.setEditable(isOk);
	}	
	//입력의 경우 컴포넌트의 모든 값을 빈문자열로 처리
	//조회와 수정시는 Value Object(AddressVO)에서 받은 값으로 설정
	public void setValue(AddressVO pvo) {//pvo-조회결과가 담겨있음.
		if(pvo==null) {//너 입력버튼을 누른거야?
			setName("");
			setBigo("");
			setGender("남자");
			setId("");
			setPw("");
		}
		else {//상세조회 버튼|수정버튼을 누른거야?
			setName(pvo.getA_name());
			setBigo(pvo.getA_bigo());
			setGender(pvo.getGender());
			//어디다 추가하지? jtf_id, jtf_pw, 무엇(아이디와 비번)을 추가하지?
			//어디(set()호출 넘어왔죠-ravo)에 있지?
			setId(pvo.getA_id());
			setPw(pvo.getA_pw());
		}
	}
	//자식창에 배치된 컴포넌트의 상태를 활성화 또는 비활성화
	public void setEditable(boolean isOk) {
		jtf_name.setEditable(isOk);
		jta_bigo.setEditable(isOk);
	}
	public void initDisplay() {
		jbtn_cud.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		//jtf_name.setText("예시) 유재덕");
		//System.out.println(jtf_name.getText());
		jp_center.setLayout(null);
		jlb_name.setBounds(20, 20, 100, 20);
		jtf_name.setBounds(120, 20, 150, 20);
		jlb_gender.setBounds(20, 45, 100, 20);
		jcb_gender.setBounds(120, 45, 150, 20);
		jlb_bigo.setBounds(20, 70, 100, 20);
		jsp_bigo.setBounds(120, 70, 200, 60);
		jlb_id.setBounds(20, 135, 100, 20);
		jtf_id.setBounds(120, 135, 100, 20);
		jlb_pw.setBounds(20, 160, 100, 20);
		jtf_pw.setBounds(120, 160, 100, 20);
		jbtn_cud.setBounds(60, 300, 100, 25);
		jbtn_cancel.setBounds(180, 300, 100, 25);
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_gender);
		jp_center.add(jcb_gender);
		jp_center.add(jlb_bigo);
		jp_center.add(jsp_bigo);
		jbtn_cud.setText(title);
		jp_center.add(jbtn_cud);
		jp_center.add(jbtn_cancel);
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jlb_pw);
		jp_center.add(jtf_pw);		
		this.add("Center",jp_center);
		this.setTitle(title);
		this.setSize(350, 500);
		this.setVisible(isView);
	}
	//각 컬럼의 값들을 컴포넌트(JTextField)에설정하거나  읽어오는 getter/setter메소드 추가하기
	public String getId() {
		return jtf_id.getText();
	}
	public void setId(String id) {
		jtf_id.setText(id);
	}
	public String getPw() {
		return jtf_pw.getText();
	}
	public void setPw(String pw) {
		jtf_pw.setText(pw);
	}	
	public String getName() {
		return jtf_name.getText();
	}
	public void setName(String name) {
		jtf_name.setText(name);
	}
	public String getBigo() {
		return jta_bigo.getText();
	}
	public void setBigo(String bigo) {
		jta_bigo.setText(bigo);
	}	
	public String getGender() {
		if("남자".equals(jcb_gender.getSelectedItem())) return "1";
		else return "0";
	}
	public void setGender(String gender) {
		if("남자".equals(gender)) jcb_gender.setSelectedItem("남자");
		else jcb_gender.setSelectedItem("여자");
	}	
	public static void main(String args[]) {
	    //AddressCUD aCUD = new AddressCUD(true);
		//aCUD.initDisplay();
		//aCUD.setName("유재덕");
		//System.out.println(aCUD.getName());
		//aCUD.setBigo("테스트..테스트....");
		//System.out.println(aCUD.getBigo());
		//aCUD.setGender("0");
		//System.out.println(aCUD.getGender());
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생한 클래스의 주소번지를 담는다.(jbtn_cud or jbtn_cancel)
		Object obj = ae.getSource();
		if(obj==jbtn_cud) {
			System.out.println(jbtn_cud.getText());
			if("입력".equals(jbtn_cud.getText())) {
				AddressVO pavo = new AddressVO();
				pavo.setA_name(getName());
				pavo.setA_bigo(getBigo());
				pavo.setGender(getGender());
				pavo.setA_id(getId());
				pavo.setA_pw(getPw());
				JOptionPane.showMessageDialog(aBook.jf_addr
						                    , pavo.getA_id()
						                 +","+pavo.getA_pw()
						                 +","+pavo.getA_name()
						                 +","+pavo.getGender()
						                 +","+pavo.getA_bigo()
						                    , "INFO"
						                    , JOptionPane.INFORMATION_MESSAGE);
				int result = aDAO.addrInsert(pavo);
				if(result==1) {//등록된거야?
					JOptionPane.showMessageDialog(aBook.jf_addr
							                     ,"주소록에 추가되었습니다."
							                     ,"INFO"
							                     , JOptionPane.INFORMATION_MESSAGE);
					jbtn_cud.setText("");
					this.dispose();
					aBook.refreshData(null);
				}else {//등록 실패했네......
					JOptionPane.showMessageDialog(aBook.jf_addr
		                     ,"등록 실패."
		                     ,"ERROR"
		                     , JOptionPane.ERROR_MESSAGE);
				}
			}
			else if("수정".equals(jbtn_cud.getText())) {
				AddressVO pavo = new AddressVO();
				pavo.setAno(pvo.getAno());
				pavo.setA_id(getId());
				pavo.setA_pw(getPw());
				pavo.setA_bigo(getBigo());
				pavo.setGender(getGender());
				int result = aDAO.addrUpdate(pavo);
				if(result==1) {//수정한거야?
					JOptionPane.showMessageDialog(aBook.jf_addr
							                     ,"수정되었습니다."
							                     ,"INFO"
							                     , JOptionPane.INFORMATION_MESSAGE);
					jbtn_cud.setText("");
					this.dispose();
					aBook.refreshData(null);
				}else {//등록 실패했네......
					JOptionPane.showMessageDialog(aBook.jf_addr
		                     ,"수정 실패."
		                     ,"ERROR"
		                     , JOptionPane.ERROR_MESSAGE);
				}				
			}
		}
	}
}










