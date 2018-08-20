package com.ch5;

public class SungJukApplication {
   
   public String[][] initData() {//�������� - ����
      //�Ķ���Ϳ� ����� ������ ���������̰�, �迭�̹Ƿ� ����(38����)�� �ּҹ����� ���´�
      System.out.println("iniData�޼ҵ� ȣ�� ����");
      //2�� �迭 ������ ����
      String[][] datas = {
                      	  {"1","�̼���","80","75","85","","",""}         
                      	 ,{"2","������","90","85","80","","",""}
                      	 ,{"3","������","70","75","70","","",""}
                     	 };
      return datas;
   }
   
   public int[] hap(String[][] datas) {
      System.out.println("hap ȣ�� ����");
      //insert here - 1�� �迭 ����
      int[] haps = new int[3];
      for(int i=0;i<datas.length;i++) {//datas[i].length - �÷�üũ
      haps[i] = Integer.parseInt(datas[i][2])
              + Integer.parseInt(datas[i][3])
              + Integer.parseInt(datas[i][4]);
      }
      return haps;
   }
   
   public double[] avg(int[] haps) {
      System.out.println("avg ȣ�� ����");
      //insert here - 1���迭
      double[] avgs = new double[3];
      for(int i=0;i<haps.length;i++) {
         avgs[i] = haps[i]/3.0;
      }
      return avgs;
   }
   
   public int[] ranking(int[] haps) {
      System.out.println("ranking ȣ�� ����");
      //insert here - 1���迭
      int[] ranks = {1,1,1};//3�� ������ 0�� ����ִ�
      for(int i=0;i<haps.length;i++) {
         for(int j=0;j<haps.length;j++){
            if(haps[i] <= haps[j]) {
               ranks[i]++;
            }
         }
      }
      return ranks;
   }
   
   public void sungJukAccount(String[][] datas) {
      System.out.println("sungJukAccount ȣ�� ����");
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
   
   public static void main(String[] args) {//�����ȿ��� �Ķ����Ұ� - �ν��Ͻ�ȭ
      SungJukApplication sjApp = new SungJukApplication();
      String[][] datas = null;
      //�Ķ���Ϳ� �Ѿ�� datas�� �ּҹ����̴� - new-����Ÿ��-�θ���-�ּҹ���
      //�ּҹ��� - ���� 
      datas = sjApp.initData();//������ �ʱ�ȭ - ������ ���� - ������ ���� �ִ�.
      int[] haps = sjApp.hap(datas);//ȣ���Ҷ� �����̸���, �޼ҵ弱�� �Ҷ� Ÿ�Ե� ����
      double[] avgs = sjApp.avg(haps);//������ 3������ 3���� ������
//      for(int i=0;i<haps.length;i++) {
//         
//         System.out.println(haps[i]);
//      }
      int[] ranks = sjApp.ranking(haps);
//      for(int i=0;i<ranks.length;i++) {
//         System.out.println(ranks[i]);
//      }
      
      for(int i=0;i<datas.length;i++) {
         datas[i][5] = String.valueOf(haps[i]);
         datas[i][6] = String.valueOf(avgs[i]);
         datas[i][7] = String.valueOf(ranks[i]);
      }
      sjApp.sungJukAccount(datas);
   }

}