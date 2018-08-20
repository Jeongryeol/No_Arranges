package com.ch5;//원본이 넘어간다는 것을 확인 하는것

class Param{   //원본 초기값

	int ival = 100; 
}

public class ParamSimulation {
   
   public void effectParam(Param p) {//p = 인스턴스 1의 주소
      p.ival = 250; // 인스턴스 1 = 250
      p = new Param();//인스턴스2
      System.out.println("sub ival : "+p.ival);//인스턴스2 100
   }
   
   public static void main(String[] args) {
      ParamSimulation ps = new ParamSimulation();
      Param p = new Param();//인스턴스1
      p.ival = 500;
      ps.effectParam(p);
      //insert here
      System.out.println("main ival : "+p.ival);//인스턴스1 250
   }

}