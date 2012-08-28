package com.kannan.pv;

public class Point {
	private int cF, rF;
	private String strNt;

	public Point() {

		Init("a1");

	}

	public Point(String strNotation) {

		Init(strNotation);
	}

	public Point(int rF, int cF) {

		Init(rF, cF);
	}

	private void Init(int rF, int cF) {

		strNt = Character.toString(getCordinateColumnI(cF))
				+ Character.toString(getCordinateRowI(rF));

	}

	private void Init(String strNotation) {

		if (strNotation.length() == 2) {

			cF = getCordinateColumn(strNotation.substring(0, 1).charAt(0));
			rF = getCordinateRow(strNotation.substring(1, 2).charAt(0));

		}

	}

	public String getNotation() {

		return strNt;
	}

	public int getColumnFrom() {

		return cF;
	}

	public int getRowFrom() {

		return rF;
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

	private char getCordinateRowI(int intRow) {

		char chRet = 0;

		switch (intRow) {
		case 6:
			chRet = '1';
			break;
		case 5:
			chRet = '2';
			break;
		case 4:
			chRet = '3';
			break;
		case 3:
			chRet = '4';
			break;
		case 2:
			chRet = '5';
			break;
		case 1:
			chRet = '6';
			break;
		case 0:
			chRet = '7';
			break;
		default:
			chRet = 0;
			break;

		}

		return chRet;

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

	private char getCordinateColumnI(int intColumn) {

		char chRet = 0;

		switch (intColumn) {
		case 0:
			chRet = 'a';
			break;
		case 1:
			chRet = 'b';
			break;
		case 2:
			chRet = 'c';
			break;
		case 3:
			chRet = 'd';
			break;
		case 4:
			chRet = 'e';
			break;
		case 5:
			chRet = 'f';
			break;
		case 6:
			chRet = 'g';
			break;
		default:
			chRet = 0;
			break;

		}

		return chRet;

	}

}
