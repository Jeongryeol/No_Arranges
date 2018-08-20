package com.ch5;

public class SungJukApplication {
   
   public String[][] initData() {//지역변수 - 선언
      //파라미터에 선언된 변수는 지역변수이고, 배열이므로 원본(38번줄)의 주소번지를 갖는다
      System.out.println("iniData메소드 호출 성공");
      //2차 배열 선언해 봐요
      String[][] datas = {
                      	  {"1","이순신","80","75","85","","",""}         
                      	 ,{"2","김유신","90","85","80","","",""}
                      	 ,{"3","강감찬","70","75","70","","",""}
                     	 };
      return datas;
   }
   
   public int[] hap(String[][] datas) {
      System.out.println("hap 호출 성공");
      //insert here - 1차 배열 선언
      int[] haps = new int[3];
      for(int i=0;i<datas.length;i++) {//datas[i].length - 컬럼체크
      haps[i] = Integer.parseInt(datas[i][2])
              + Integer.parseInt(datas[i][3])
              + Integer.parseInt(datas[i][4]);
      }
      return haps;
   }
   
   public double[] avg(int[] haps) {
      System.out.println("avg 호출 성공");
      //insert here - 1차배열
      double[] avgs = new double[3];
      for(int i=0;i<haps.length;i++) {
         avgs[i] = haps[i]/3.0;
      }
      return avgs;
   }
   
   public int[] ranking(int[] haps) {
      System.out.println("ranking 호출 성공");
      //insert here - 1차배열
      int[] ranks = {1,1,1};//3개 공간에 0이 들어있다
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
      System.out.println("sungJukAccount 호출 성공");
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
   
   public static void main(String[] args) {//빨강안에서 파랑사용불가 - 인스턴스화
      SungJukApplication sjApp = new SungJukApplication();
      String[][] datas = null;
      //파라미터에 넘어가는 datas는 주소번지이다 - new-참조타입-부르면-주소번지
      //주소번지 - 원본 
      datas = sjApp.initData();//데이터 초기화 - 데이터 수집 - 정보를 갖고 있다.
      int[] haps = sjApp.hap(datas);//호출할땐 변수이름만, 메소드선언 할때 타입도 같이
      double[] avgs = sjApp.avg(haps);//과목이 3개여서 3으로 나눈다
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