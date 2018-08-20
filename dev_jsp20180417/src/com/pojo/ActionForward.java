package com.pojo;

import java.util.List;
import java.util.Map;

/*
 * ����
 * ȸ������ ������ ó���ϴ� MemberController���� FrontControllerŬ������ ActionForward�� ��ȯ�ϰ� �����Ƿ�
 * select�� ��� ��ȸ ����� ���� List�迭�� �ڷᱸ�� Ŭ������ ActionForwardŬ������ ���� �� �ִٸ� 
 * ���� Ÿ���� ���������� �������� �ʾƵ� ���� ������?
 * �׷��ٸ� ActionForward�� select ����� ��� �ִ� List�� ���� �� �ִ� ������ �޼ҵ带 �߰��� ���ô�. 
 * 
 */
public class ActionForward {
	private int status = -2;
	private boolean isRedirect = false;//forward��? �� -true �ƴѵ�... -false
	private String path = null;//�̵��� �������� �̸�
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
