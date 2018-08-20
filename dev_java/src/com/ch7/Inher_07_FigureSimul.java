package com.ch7;

public class Inher_07_FigureSimul {

	public static void main(String[] args) {
		Inher_07_Figure figRec = new Inher_07_Rectangle();
		Inher_07_Figure figTri = new Inher_07_Triangle();
		Inher_07_Figure figCir = new Inher_07_Circle();

		figRec.area(10,10);
		figTri.area(10,10);
		figCir.area(10,10);
	}

}
