package com.google.googleMap_db;
/***************************************************
 * DB Table Script�����κ��� ������ �÷������� ������� VOŬ���� ����
 * �ϰ����� :	Alt + shift + A
 * �ҹ��� ���� :	Alt + shift + Y
 * Generate Getter and Setter Method
 * 
 * [equal-join + PK/FK�� ���� ������ �Ʒ� �ּ� ����
 ***************************************************/
public class VO_FS_Menu {

	private int		fsm_code    = 0; //NUMBER(4)             NOT NULL,
	private String	fsm_name    = ""; //VARCHAR2(50 BYTE),
	private String	fsm_price   = ""; //VARCHAR2(50 BYTE),
	private String	fsm_picture = ""; //VARCHAR2(100 BYTE),
	private int		fsm_good    = 0; //NUMBER(10),
	private int		fsm_bad     = 0; //NUMBER(10),
	private int		fs_code     = 0; //NUMBER(4)
	
	public VO_FoodStore fsvo = null;
	/*
	 * �ڽİ��迡 �ִ� ���̺��� ������ �θ����̺�VOŬ�������� �ٷ�� �ϰ��� ��
	 * 		�θ����̺��� VOŬ�����κ���
	 * 		�ڽ����̺��� VOŬ������ ���� �� ����,�б� ����
	 * 
	  	[���� ���̺���� �޴����̺��� �θ�(PK����)�̰� ��������̺��� �ڳ�(FK����)��]
	  
	  		ALTER TABLE KING.FS_MENU ADD (
			  CONSTRAINT XPKFS_MENU
			  PRIMARY KEY
			  (FSM_CODE)
			  USING INDEX KING.XPKFS_MENU
			  ENABLE VALIDATE);
			
			ALTER TABLE KING.FS_MENU ADD (
			  CONSTRAINT FOOD_STORE_FK 
			  FOREIGN KEY (FS_CODE) 
			  REFERENCES KING.FOOD_STORE (FS_CODE)
			  ENABLE VALIDATE);
	  
	 *  �ؽ����� ��� Ű�� ������ ���� �ذ��� �� ����
	 */
	
	public int getFsm_code() {
		return fsm_code;
	}
	public void setFsm_code(int fsm_code) {
		this.fsm_code = fsm_code;
	}
	public String getFsm_name() {
		return fsm_name;
	}
	public void setFsm_name(String fsm_name) {
		this.fsm_name = fsm_name;
	}
	public String getFsm_price() {
		return fsm_price;
	}
	public void setFsm_price(String fsm_price) {
		this.fsm_price = fsm_price;
	}
	public String getFsm_picture() {
		return fsm_picture;
	}
	public void setFsm_picture(String fsm_picture) {
		this.fsm_picture = fsm_picture;
	}
	public int getFsm_good() {
		return fsm_good;
	}
	public void setFsm_good(int fsm_good) {
		this.fsm_good = fsm_good;
	}
	public int getFsm_bad() {
		return fsm_bad;
	}
	public void setFsm_bad(int fsm_bad) {
		this.fsm_bad = fsm_bad;
	}
	public int getFs_code() {
		return fs_code;
	}
	public void setFs_code(int fs_code) {
		this.fs_code = fs_code;
	}
	public VO_FoodStore getFsvo() {
		return fsvo;
	}
	public void setFsvo(VO_FoodStore fsvo) {
		this.fsvo = fsvo;
	}
	
}
