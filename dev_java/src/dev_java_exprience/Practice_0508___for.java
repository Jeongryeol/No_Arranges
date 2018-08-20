package dev_java_exprience;

public class Practice_0508___for {

	public static void main(String[] args) {
		int num;
		int num2;
		for(int i=1;i<10;i++) {
			num=i;
			for(int j=1;j<10;j++) {
				num2=j;
				System.out.println(num+" x "+num2+" = "+num*num2);
				if(j==5) {
					System.out.print("\n");
					break;
				}
			}
		}

	}

}
