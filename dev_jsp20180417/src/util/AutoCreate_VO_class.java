package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;
/*********************************************************************
 * @author	����
 * @since	2018.08.08
 * @comment	�ۼ��ϰ����ϴ� ���̺���� �Է��ϸ� �ش��ϴ� �÷���� VOŬ������ �������ִ� ��ƿ��Ƽ Ŭ����
 *********************************************************************/
public class AutoCreate_VO_class {
	
	private DBConnectionMgr dbcon = DBConnectionMgr.getInstance();
	private Connection con;//���ᰴü
	private PreparedStatement pstmt;//����������ü
	private ResultSet rs;//��ȸĿ�����۰�ü
	private String tableName;//������̺��
	private File file;//���ϻ������ఴü
	private PrintWriter pw;//��°�ü
	
	//[1] ���� :: ���̺�� �Է�
	public static void main(String[] args) {
	/*	//���� �Է¹޾Ƽ� ���̺���� �����ϴ� �ڵ� : �ټ��� �ڵ带 �������ϴ��� ������ �����ϱ�	
	  	Scanner sc = new Scanner(System.in);
		System.out.println("��������ϴ� ���̺� ���� �Է��Ͻÿ�");
		String userInput = sc.next();
		System.out.println(userInput+"���� ���̺� ������ �����մϴ�.");*/
		
		String userInput = "emp";//��������ϴ� ���̺� �� ���
		new AutoCreate_VO_class(userInput);
	}
	
	//[2] �������� �ʱ�ȭ + �����޼ҵ� ȣ��
	public AutoCreate_VO_class(String tableName) {
		this.tableName = tableName;
		createVO();
	}

	//[3] �����޼ҵ� :: VO������ ���ϸ�� ��θ� �����ϴ� �޼ҵ�
	public void createVO() {
		try {
			//���ϸ�
			String fileName = tableName.substring(0, 1).toUpperCase()
							+ tableName.substring(1).toLowerCase();
			//���ϰ��
			file = new File("src/com/vo/", fileName + "VO.java");
			//���ϻ���
			createFile(file); //���࿡ �����̸��� ��ġ�°� �ִٸ� �����
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//[4] ���ϻ����޼ҵ� :: ������ �����Ҷ� ��� ���� �ۼ��� �Ǿ�� �ϴ°��� ���� �ۼ�
	public void createFile(File file) { 
		try {
			//���ⰴü ����
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			//������ �ڹ�Ŭ���� �̸� ���� : ù���ڴ� �빮��, �ι�°���ں��ʹ� �ҹ��ڷ� ��ȯ
			String className = tableName.substring(0, 1).toUpperCase()
							 + tableName.substring(1).toLowerCase(); 
			
			List<Map<String, String>> tableInfos = getTableInfo();//���̺������� ������ �޼ҵ� ȣ��
			
			//��ü����
			pw.println("package com.vo;");
			pw.println();// �ٹٲ�
			pw.println("public class " + className + "VO {");
			pw.println();
			//�������� ����
			for (Map<String, String> tableInfo : tableInfos) {
				String type		= tableInfo.get("colType");				 //�÷�Ÿ�Կ� ���� ��ȯ�� ������ ����
				String colName	= tableInfo.get("colName").toLowerCase();//�÷����� �ҹ���
				pw.println("	private "+ type + " " + colName +";");	 //�÷��� �������� ���� ���
			}
			//getter(),setter() �޼ҵ� ����
			for (Map<String, String> tableInfo : tableInfos) {
				pw.println();//�ٹٲ�
				String colName	  = tableInfo.get("colName");			//�÷���
				String methodName = colName.substring(0, 1).toUpperCase()
								  + colName.substring(1).toLowerCase();	//�޼ҵ�� (ù���ڸ� �빮��)
				String type		  = tableInfo.get("colType");			//�÷�Ÿ��
				String varName	  = colName.toLowerCase();				//�÷��̸�(��������)
				//getter
				pw.println("	public " + type + " get" + methodName + "() {");
				pw.println("		return " + varName + ";");
				pw.println("	}");
				pw.println();//�ٹٲ�
				//setter
				pw.println("	public void set" + methodName + "(" + type + " " + varName + ")" + "{");
				pw.println("		this." + varName + " = " + varName + ";");
				pw.println("	}");
			}
			pw.println();//�ٹٲ�
			pw.println("}");//�ݱ�
			pw.flush();//�������
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();//�ݱ�
		}
	}
	
	//���̺������� ��ȯ�ϴ� �޼ҵ� : DB���� �÷������� ������Ÿ���� ������ �����ͼ� �����ϰ� �ĺ��ϰ� ��Ƶα�.
	public List<Map<String, String>> getTableInfo() {
		//��ȯŸ�Լ���
		List<Map<String, String>> tableInfos = new ArrayList<>();
		//���̺������� ��ȸȰ SQL�� �ۼ�
		StringBuilder sql = new StringBuilder();
		tableName = tableName.toUpperCase();
		sql.append(//������ ���̺��� �÷��� ���Ͽ�, �÷���� �÷�Ÿ���� �о���� ������
				"SELECT CNAME, DECODE(COLTYPE,'NUMBER',DECODE(scale,0,'int','double')"
											+",'VARCHAR2','String'"
										   	+",'VARCHAR','String'"
										   	+",'DATE','String') type "
				+" FROM COL"
				+" WHERE TNAME = '" + tableName + "'");
		//DB����
		try {
			con = dbcon.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, String> tableInfo = new HashMap<>();	//�� ����
				tableInfo.put("colName", rs.getString("CNAME"));	//�÷��� ���
				tableInfo.put("colType", rs.getString("type"));		//�÷�Ÿ�� ���
				tableInfos.add(tableInfo);							//�ʿ� ���
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableInfos;//�÷������� ��� ����Ʈ ��ȯ (K:V=�÷���:�÷�Ÿ��)
	}

}
