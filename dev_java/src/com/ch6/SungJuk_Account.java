package com.ch6;

public class SungJuk_Account {
	
	   public void account(String[][] datas) {//������ ����� ���� ���ؼ� �����
		      System.out.println("sungJukAccount ȣ�� ����");
		      System.out.println(" ");
		      for(int i=0;i<datas.length;i++) {
		      //   for(int j=0;j<datas[i].length;j++) {
		            System.out.printf("%3s %8s %5s %5s %6s %6s %6s %n",datas[i][0]
		                                                  			  ,datas[i][1]
		                                                  			  ,datas[i][2]
		                                                  			  ,datas[i][3]
		                                                  			  ,datas[i][4]
		                                                  			  ,datas[i][5]
		                                                  			  ,datas[i][6]
		                                                  			  ,datas[i][7]);
		      //   }
		      }
		      
	   }
	   
	   public static void main(String[] avrg) {
		   	SungJuk_InitData sjApp = new SungJuk_InitData();
		   	String[][] datas = null;
		   	datas = sjApp.initData();//������ �ʱ�ȭ - ������ ���� - ������ ���� �ִ�.
		   	
		   	SungJuk_Hap hap = new SungJuk_Hap();
		   	int[] haps = hap.hap(datas);//ȣ���Ҷ� �����̸���, �޼ҵ弱�� �Ҷ� Ÿ�Ե� ����
		   	
		   	SungJuk_Avg avg = new SungJuk_Avg();
		   	double[] avgs = avg.avg(haps);//������ 3������ 3���� ������
		   	
		   	SungJuk_Ranking ranking = new SungJuk_Ranking();
		   	int[] ranks = ranking.ranking(haps);

		   	SungJuk_Account account = new SungJuk_Account();  
		    for(int i=0;i<datas.length;i++) {
		       datas[i][5] = String.valueOf(haps[i]);
		       datas[i][6] = String.valueOf(avgs[i]);
		       datas[i][7] = String.valueOf(ranks[i]);
		    }
		    account.account(datas);
	   }
	   
}
