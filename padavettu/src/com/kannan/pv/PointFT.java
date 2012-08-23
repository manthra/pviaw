package com.kannan.pv;

public class PointFT {

	private int cF, rF, cT, rT;

	public PointFT() {

		Init("a1a2");

	}

	public PointFT(String strNotation) {

		Init(strNotation);
	}

	private void Init(String strNotation) {

		if (strNotation.length() == 4) {

			cF = getCordinateColumn(strNotation.substring(0, 1).charAt(0));
			rF = getCordinateRow(strNotation.substring(1, 2).charAt(0));
			cT = getCordinateColumn(strNotation.substring(2, 3).charAt(0));
			rT = getCordinateRow(strNotation.substring(3, 4).charAt(0));

		}

	}

	public int getColumnFrom() {

		System.out.print(cF);
		return cF;
	}

	public int getRowFrom() {

		System.out.print(rF);
		return rF;
	}

	public int getColumnTo() {

		System.out.print(cT);
		return cT;
	}

	public int getRowTo() {

		System.out.print(cT);
		return rT;
	}

	private int getCordinateRow(char chRow) {

		int intRet = 0;

		switch (chRow) {
		case '1':
			intRet = 6;
			break;
		case '2':
			intRet = 5;
			break;
		case '3':
			intRet = 4;
			break;
		case '4':
			intRet = 3;
			break;
		case '5':
			intRet = 2;
			break;
		case '6':
			intRet = 1;
			break;
		case '7':
			intRet = 0;
			break;
		default:
			intRet = 0;
			break;

		}

		return intRet;

	}

	private int getCordinateColumn(char chColumn) {

		int intRet = 0;

		switch (chColumn) {
		case 'a':
			intRet = 0;
			break;
		case 'b':
			intRet = 1;
			break;
		case 'c':
			intRet = 2;
			break;
		case 'd':
			intRet = 3;
			break;
		case 'e':
			intRet = 4;
			break;
		case 'f':
			intRet = 5;
			break;
		case 'g':
			intRet = 6;
			break;
		default:
			intRet = 0;
			break;

		}

		return intRet;

	}

}
