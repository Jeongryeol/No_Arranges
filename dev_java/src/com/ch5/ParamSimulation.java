package com.ch5;//������ �Ѿ�ٴ� ���� Ȯ�� �ϴ°�

class Param{   //���� �ʱⰪ

	int ival = 100; 
}

public class ParamSimulation {
   
   public void effectParam(Param p) {//p = �ν��Ͻ� 1�� �ּ�
      p.ival = 250; // �ν��Ͻ� 1 = 250
      p = new Param();//�ν��Ͻ�2
      System.out.println("sub ival : "+p.ival);//�ν��Ͻ�2 100
   }
   
   public static void main(String[] args) {
      ParamSimulation ps = new ParamSimulation();
      Param p = new Param();//�ν��Ͻ�1
      p.ival = 500;
      ps.effectParam(p);
      //insert here
      System.out.println("main ival : "+p.ival);//�ν��Ͻ�1 250
   }

}