package com.pojo;

import java.util.List;
import java.util.Map;

/*
 * 제안
 * 회원관리 업무를 처리하는 MemberController에서 FrontController클래스에 ActionForward를 반환하고 있으므로
 * select일 경우 조회 결과를 담은 List계열의 자료구조 클래스도 ActionForward클래스에 담을 수 있다면 
 * 리턴 타입을 여러가지로 가져가지 않아도 되지 않을까?
 * 그렇다면 ActionForward에 select 결과를 담고 있는 List를 담을 수 있는 변수와 메소드를 추가해 봅시다. 
 * 
 */
public class ActionForward {
	private int status = -2;
	private boolean isRedirect = false;//forward니? 네 -true 아닌데... -false
	private String path = null;//이동할 페이지의 이름
	private List<Map<String,Object>> list = null;
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
