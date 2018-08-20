package com.autoPerfection;

public class VO_BookList {

	private int	   b_code     =0;	//NUMBER(4)         NOT NULL,
	private String b_name     ="";	//VARCHAR2(50 BYTE),
	private String b_price    ="";	//VARCHAR2(50 BYTE),
	private String b_picture  ="";	//VARCHAR2(100 BYTE)
	
	public int getB_code() {
		return b_code;
	}
	public void setB_code(int b_code) {
		this.b_code = b_code;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_price() {
		return b_price;
	}
	public void setB_price(String b_price) {
		this.b_price = b_price;
	}
	public String getB_picture() {
		return b_picture;
	}
	public void setB_picture(String b_picture) {
		this.b_picture = b_picture;
	}
}
