package com.semi.address;
/*
 * getter 메소드는 read
 * setter 메소드는 write|save
 */
public class AddressVO {
	private int    ano    =0; 
	private String a_id   =null; 
	private String a_pw   =null; 
	private String a_name =null; 
	private String a_hp   =null;
	private String a_bigo = null;
	private String gender = null;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_pw() {
		return a_pw;
	}
	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_hp() {
		return a_hp;
	}
	public void setA_hp(String a_hp) {
		this.a_hp = a_hp;
	}
	public String getA_bigo() {
		return a_bigo;
	}
	public void setA_bigo(String a_bigo) {
		this.a_bigo = a_bigo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	} 
}
