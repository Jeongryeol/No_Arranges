package dev_java_exprience;

public class Practice_0510_2___ObjectArraySub {

		public int		stud_no 	= 0;
		public String	stud_name 	= null;
		public int		stud_age	= 0;
		public String	stud_grd	= null;

		public static void main(String[] args) {
			
			int		booknos[] 		= {1,2,3,4};
			String	booknames[] 	= {"BookA","BookB","BookC","BookD"};
			String	bookwriters[] 	= {"Writer mr.A","Writer ms.B","Writer mr.C","Writer mss.D"};
			for(int i=0;i<booknos.length;i++) {
				System.out.printf("%d번서적 / 이름 : %s / 저자 : %s%n",booknos[i],booknames[i],bookwriters[i]);
			}
		}
}
