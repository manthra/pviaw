package com.kannan.pv;

public class Board {

	public Board() {
		Init();
	}

	String[][] strCell = new String[7][7];
	boolean isValid = true;
	String strName = "";
	int xPos = 0;
	int yPos = 0;
	String strNone = "_";
	String strBlank = " ";
	String strBlack = "B";
	String strWhite = "W";

	public String Name() {

		return strName;

	}

	public enum Player {
		Black, White
	}

	Player currentPlayer, nextPlayer;

	public void Name(String strName) {

		this.strName = strName;

	}

	public void renderBoard() {

		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {
				System.out.print(strCell[r][c]);
			}
			System.out.print("\n");
		}

	}

	public Player getNextPlayer() {

		return nextPlayer;
	}

	private String getOpponent(String strP) {

		if (strP.equals(strBlack)) {
			return strWhite;

		} else {

			return strBlack;
		}

	}

	public boolean isValidMove(int rF, int cF, int rT, int cT, String strP) {

		boolean isValid = false;

		if (strCell[rF][cF].equals(strP)) {

			System.out.println("ONE");

			// all right left top bottom are valid

			if (cF == cT && rF != rT) { // same column diff row -- rowwise
										// movement

				System.out.println("same column");
				if (rF == rT - 1) { // bottom
					System.out.println("bottom");
					isValid = true;

				}

				if (rF == rT + 1) { // top
					System.out.println("top");
					isValid = true;
				}

				if ((rF == rT - 2)
						&& strCell[rF + 1][cF].equals(getOpponent(strP))) { // bottom
																			// cut
					System.out.println("bottom cut");
					isValid = true;
					strCell[rF + 1][cF] = strBlank;

				}

				if ((rF == rT + 2)
						&& strCell[rF - 1][cF].equals(getOpponent(strP))) { // top
																			// cut
					System.out.println("top cut");
					isValid = true;
					strCell[rF - 1][cF] = strBlank;
				}

			} else { // diff column

				if (cF != cT && rF == rT) { // same row diff column --
											// columnwise movement

					System.out.println("diff column");
					if (cF == cT - 1) { // right
						System.out.println("right");
						isValid = true;

					}

					if (cF == cT + 1) { // top
						System.out.println("left");
						isValid = true;
					}

					if ((cF == cT - 2)
							&& strCell[rF][cF + 1].equals(getOpponent(strP))) { // right
																				// cut
						System.out.println("right cut");
						isValid = true;
						strCell[rF][cF + 1] = strBlank;
					}

					if ((cF == cT + 2)
							&& strCell[rF][cF - 1].equals(getOpponent(strP))) { // left
																				// cut
						System.out.println("left cut");
						isValid = true;
						strCell[rF][cF - 1] = strBlank;
					}

				} else { // diff column diff row -- diagonal movements

					if (cF != cT && rF != rT) { // diff row diff column --

						System.out.println("diagonal move");

						if ((cF == cT - 1) && (rF == rT - 1)) { // bottm right
							System.out.println("bottm right");
							isValid = true;

						}

						if ((cF == cT + 1) && (rF == rT - 1)) { // bottm right
							System.out.println("bottm left");
							isValid = true;

						}

						if ((cF == cT + 1) && (rF == rT + 1)) { // top left
							System.out.println("top left");
							isValid = true;

						}

						if ((cF == cT - 1) && (rF == rT + 1)) { // top right
							System.out.println("top right");
							isValid = true;

						}

						// diagonal cut start

						// Not tested
						if ((cF == cT - 2)
								&& (rF == rT - 2)
								&& strCell[rF + 1][cF + 1]
										.equals(getOpponent(strP))) { // bottm
																		// right
																		// cut
							strCell[rF + 1][cF + 1] = strBlank;
							System.out.println("bottm right cut");
							isValid = true;

						}

						// Correct
						if ((cF == cT + 2)
								&& (rF == rT + 2)
								&& strCell[rF - 1][cF - 1]
										.equals(getOpponent(strP))) { // top
																		// left
																		// cut
							strCell[rF - 1][cF - 1] = strBlank;
							System.out.println("top left cut");
							isValid = true;

						}

						// Not tested
						if ((cF == cT + 2)
								&& (rF == rT - 2)
								&& strCell[rF + 1][cF - 1]
										.equals(getOpponent(strP))) { // bottm
																		// left
																		// cut
							strCell[rF + 1][cF - 1] = strBlank;
							System.out.println("bottm left cut");
							isValid = true;

						}

						// Not tested
						if ((cF == cT - 2)
								&& (rF == rT + 2)
								&& strCell[rF - 1][cF + 1]
										.equals(getOpponent(strP))) { // top
																		// right
																		// cut
							strCell[rF - 1][cF + 1] = strBlank;
							System.out.println("top right cut");
							isValid = true;

						}

						// diagonal cut end

					}
				}

			}

		}

		return isValid;
	}

	public boolean Move(String strNotation) {

		PointFT pnt = new PointFT(strNotation);

		int rF = pnt.getRowFrom();
		int cF = pnt.getColumnFrom();
		int rT = pnt.getRowTo();
		int cT = pnt.getColumnTo();
		String strP;

		if (currentPlayer == Player.Black) {
			strP = "B";
		} else {
			strP = "W";
		}

		if (isValidMove(rF, cF, rT, cT, strP)) {

			System.out.println("Valid");

			strCell[rF][cF] = strBlank;
			strCell[rT][cT] = strP;

		} else {

			System.out.println("inValid");
		}

		return true;
	}

	public boolean Move(int rF, int cF, int rT, int cT, String strP) {

		if (isValidMove(rF, cF, rT, cT, strP)) {

			System.out.println("Valid");

			strCell[rF][cF] = strBlank;
			strCell[rT][cT] = strP;

		} else {

			System.out.println("inValid");
		}

		return true;
	}

	public int getPoints(String strP) {

		int pnts = 0;
		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {
				if (strCell[r][c].equals(strP)) {
					pnts++;
				}
			}

		}

		return pnts;
	}

	private void Init() {
		strName = "Board";
		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {

				if ((r < 2 && c < 2) || (r < 2 && c > 4) || (r > 4 && c < 2)
						|| (r > 4 && c > 4)) {
					strCell[r][c] = strNone;
				} else {

					if ((r > 1 && c < 3) || (r > 4 && c < 5)
							|| (r == 4 && c == 3)) {
						strCell[r][c] = strWhite;
					} else {

						if (r == 3 && c == 3) {
							strCell[r][c] = strBlank;
						} else {
							strCell[r][c] = strBlack;
						}
					}

				}
			}

		}

		currentPlayer = Player.White;

	}

}
