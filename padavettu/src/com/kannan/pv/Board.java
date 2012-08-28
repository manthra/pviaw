package com.kannan.pv;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public Board() {
		Init();
	}

	public Board(String strBoardPos) {
		setBoardPosition(strBoardPos);
	}

	String[][] strCell = new String[7][7];
	boolean isValid = true;
	boolean IsLastCapture = false;

	boolean isEnd = false;

	String strName = "";
	String strNone = "_";
	String strBlank = " ";

	Player currentPlayer, nextPlayer, previousPlayer, won;

	public void renderBoard() {

		System.out
				.println("----------------------------------------------------------");
		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {
				System.out.print("\t" + strCell[r][c]);
			}
			System.out.print("\n\n");
		}
		System.out
				.println("----------------------------------------------------------");

		if (isEnd) {
			System.out.println(won.name() + " won the game!");
		} else {
			System.out.println(Player.WHITE.getChar() + ":"
					+ getPoints(Player.WHITE) + " " + Player.BLACK.getChar()
					+ ":" + getPoints(Player.BLACK));
			System.out.println(currentPlayer.name() + " to Move");
		}
	}

	public Player getNextPlayer() {

		return nextPlayer;
	}

	public boolean Move(String strNotation) {

		PointFT pnt = new PointFT(strNotation);

		int rF = pnt.getRowFrom();
		int cF = pnt.getColumnFrom();
		int rT = pnt.getRowTo();
		int cT = pnt.getColumnTo();

		/*
		 * PointFT pp = new PointFT(rF, cF, rT, cT);
		 * 
		 * System.out.println("NNN" + pp.getNotation());
		 */

		boolean isValid = false;
		boolean isCapture = false;

		int cCapture = 0;
		int rCapture = 0;

		// String strP;

		/*
		 * if (strCell[rF][cF].equals("W")) { currentPlayer = Player.WHITE;
		 * 
		 * } else { currentPlayer = Player.BLACK;
		 * 
		 * }
		 */
		// strP = currentPlayer.getChar();

		/*
		 * System.out.println("CP " + currentPlayer.getChar());
		 * 
		 * System.out.println("PP " + previousPlayer.getChar());
		 */
		if (strCell[rF][cF].equals(currentPlayer.getChar())) {

			// System.out.println("ONE");

			// all right left top bottom are valid

			if (cF == cT && rF != rT) { // same column diff row -- rowwise
										// movement

				System.out.println("same column");

				if (currentPlayer != previousPlayer) {

					if (rF == rT - 1) { // bottom
						System.out.println("bottom");
						isValid = true;
					}

					if (rF == rT + 1) { // top
						System.out.println("top");
						isValid = true;
					}
				}

				if ((rF == rT - 2)
						&& strCell[rF + 1][cF].equals(currentPlayer.Opponent()
								.getChar())) { // bottom
					// cut
					System.out.println("bottom cut");
					isCapture = true;
					rCapture = rF + 1;
					cCapture = cF;

					isValid = true;

					// strCell[rF + 1][cF] = strBlank;

				}

				if ((rF == rT + 2)
						&& strCell[rF - 1][cF].equals(currentPlayer.Opponent()
								.getChar())) { // top
					// cut
					System.out.println("top cut");
					isCapture = true;
					rCapture = rF - 1;
					cCapture = cF;

					isValid = true;
					// strCell[rF - 1][cF] = strBlank;
				}

			} else { // diff column

				if (cF != cT && rF == rT) { // same row diff column --
											// columnwise movement

					System.out.println("diff column");

					if (currentPlayer != previousPlayer) {

						if (cF == cT - 1) { // right
							System.out.println("right");
							isValid = true;

						}

						if (cF == cT + 1) { // top
							System.out.println("left");
							isValid = true;
						}

					}

					if ((cF == cT - 2)
							&& strCell[rF][cF + 1].equals(currentPlayer
									.Opponent().getChar())) { // right
						// cut
						System.out.println("right cut");
						isCapture = true;
						rCapture = rF;
						cCapture = cF + 1;

						isValid = true;
						// strCell[rF][cF + 1] = strBlank;
					}

					if ((cF == cT + 2)
							&& strCell[rF][cF - 1].equals(currentPlayer
									.Opponent().getChar())) { // left
						// cut
						System.out.println("left cut");
						isCapture = true;
						rCapture = rF;
						cCapture = cF - 1;

						isValid = true;
						// strCell[rF][cF - 1] = strBlank;
					}

				} else { // diff column diff row -- diagonal movements

					if (cF != cT && rF != rT) { // diff row diff column --

						System.out.println("diagonal move");

						if (currentPlayer != previousPlayer) {

							if ((cF == cT - 1) && (rF == rT - 1)) { // bottm
																	// right
								System.out.println("bottm right");
								isValid = true;

							}

							if ((cF == cT + 1) && (rF == rT - 1)) { // bottm
																	// right
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

						}
						// diagonal cut start

						// Not tested
						if ((cF == cT - 2)
								&& (rF == rT - 2)
								&& strCell[rF + 1][cF + 1].equals(currentPlayer
										.Opponent().getChar())) { // bottm
							// right
							// cut
							isCapture = true;
							rCapture = rF + 1;
							cCapture = cF + 1;

							// strCell[rF + 1][cF + 1] = strBlank;
							System.out.println("bottm right cut");
							isValid = true;

						}

						// Correct
						if ((cF == cT + 2)
								&& (rF == rT + 2)
								&& strCell[rF - 1][cF - 1].equals(currentPlayer
										.Opponent().getChar())) { // top
							// left
							// cut
							isCapture = true;
							rCapture = rF - 1;
							cCapture = cF - 1;

							// strCell[rF - 1][cF - 1] = strBlank;
							System.out.println("top left cut");
							isValid = true;

						}

						// Not tested
						if ((cF == cT + 2)
								&& (rF == rT - 2)
								&& strCell[rF + 1][cF - 1].equals(currentPlayer
										.Opponent().getChar())) { // bottm
							// left
							// cut
							isCapture = true;
							rCapture = rF + 1;
							cCapture = cF - 1;

							// strCell[rF + 1][cF - 1] = strBlank;
							System.out.println("bottm left cut");
							isValid = true;

						}

						// Not tested
						if ((cF == cT - 2)
								&& (rF == rT + 2)
								&& strCell[rF - 1][cF + 1].equals(currentPlayer
										.Opponent().getChar())) { // top
							// right
							// cut
							isCapture = true;
							rCapture = rF - 1;
							cCapture = cF + 1;

							// strCell[rF - 1][cF + 1] = strBlank;
							System.out.println("top right cut");

							isValid = true;

						}

						// diagonal cut end

					}
				}

			}

		}

		if (isValid) {

			// From Cell
			strCell[rF][cF] = strBlank;

			// Capture Cell
			if (isCapture) {
				strCell[rCapture][cCapture] = strBlank;
			}

			// To Cell
			strCell[rT][cT] = currentPlayer.getChar();

			previousPlayer = currentPlayer;
			currentPlayer = currentPlayer.Opponent();
			nextPlayer = currentPlayer.Opponent();

		} else {

			System.out.println("Invalid");
		}

		return isValid;
	}

	public int getPoints(Player player) {

		int pnts = 0;
		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {
				if (strCell[r][c].equals(player.Opponent().getChar())) {
					pnts++;
				}
			}

		}

		return 16 - pnts;
	}

	// Done
	public boolean setBoardPosition(String strBrdPos) {
		boolean blRet = false;

		String[] strBrd = strBrdPos.split("/");

		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {

				try {
					strCell[r][c] = Character.toString(strBrd[r].charAt(c));
				} catch (Exception e) {
					// Do nothing
				}

			}

			blRet = true;
		}

		if (strBrd[7].equals("W")) {
			previousPlayer = Player.WHITE;
			currentPlayer = Player.BLACK;
			nextPlayer = Player.WHITE;
		} else {
			previousPlayer = Player.BLACK;
			currentPlayer = Player.WHITE;
			nextPlayer = Player.BLACK;
		}

		return blRet;
	}

	public String[] getValidMoves(String strCurrentPos) {
		String[] strMoves = null;

		List<String> list = new ArrayList<String>();
		Point pnt = new Point(strCurrentPos);

		int rF = pnt.getRowFrom();
		int cF = pnt.getColumnFrom();

		/*System.out.println(rF);
		System.out.println(cF);
*/
		if (currentPlayer.getChar().equals(strCell[rF][cF])) {
//			System.out.println("Correct");

//			System.out.println(strCell[rF - 1][cF]);

			try {
				// up-1
				if (strCell[rF - 1][cF] == Player.NONE.getChar()) {
					list.add(new Point(rF - 1, cF).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e15) {
				// TODO Auto-generated catch block
				e15.printStackTrace();
			}

			try {
				// up-2
				if (strCell[rF - 2][cF] == Player.NONE.getChar()
						&& strCell[rF - 1][cF] == currentPlayer.Opponent()
								.getChar()) {
					list.add(new Point(rF - 2, cF).getNotation());
					//System.out.println("Inside2");
				}
			} catch (Exception e14) {
				// TODO Auto-generated catch block
				e14.printStackTrace();
			}

			try {
				// down+1
				if (strCell[rF + 1][cF] == Player.NONE.getChar()) {
					list.add(new Point(rF + 1, cF).getNotation());
					//System.out.println("Inside3");
				}
			} catch (Exception e13) {
				// TODO Auto-generated catch block
				e13.printStackTrace();
			}

			try {
				// down+2
				if (strCell[rF + 2][cF] == Player.NONE.getChar()
						&& strCell[rF + 1][cF] == currentPlayer.Opponent()
								.getChar()) {
					list.add(new Point(rF + 2, cF).getNotation());
					//System.out.println("Inside4");
				}
			} catch (Exception e12) {
				// TODO Auto-generated catch block
				e12.printStackTrace();
			}

			try {
				// right+1
				if (strCell[rF][cF + 1] == Player.NONE.getChar()) {
					list.add(new Point(rF, cF + 1).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
			}

			try {
				// right+2
				if (strCell[rF][cF + 2] == Player.NONE.getChar()
						&& strCell[rF][cF + 1] == currentPlayer.Opponent()
								.getChar()) {
					list.add(new Point(rF, cF + 2).getNotation());
					//System.out.println("Inside2");
				}
			} catch (Exception e10) {
				// TODO Auto-generated catch block
				e10.printStackTrace();
			}

			try {
				// left-1
				if (strCell[rF][cF - 1] == Player.NONE.getChar()) {
					list.add(new Point(rF, cF - 1).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e9) {
				// TODO Auto-generated catch block
				e9.printStackTrace();
			}

			try {
				// left+2
				if (strCell[rF][cF - 2] == Player.NONE.getChar()
						&& strCell[rF][cF - 1] == currentPlayer.Opponent()
								.getChar()) {
					list.add(new Point(rF, cF - 2).getNotation());
					//System.out.println("Inside2");
				}
			} catch (Exception e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
			

			try {
				// left-1 top-1
				if (strCell[rF - 1][cF - 1] == Player.NONE.getChar()) {
					list.add(new Point(rF - 1, cF - 1).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e7) {
				// TODO Auto-generated catch block
				e7.printStackTrace();
			}

			try {
				// right+1 top+1
				if (strCell[rF - 1][cF + 1] == Player.NONE.getChar()) {
					list.add(new Point(rF - 1, cF + 1).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			}

			try {
				// left-1 bottom+1
				if (strCell[rF + 1][cF - 1] == Player.NONE.getChar()) {
					list.add(new Point(rF + 1, cF - 1).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}

			try {
				// right+1 top+1
				if (strCell[rF + 1][cF + 1] == Player.NONE.getChar()) {
					list.add(new Point(rF + 1, cF + 1).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}


		
			
			
			
			
			try {
				// left-1 top-1
				if (strCell[rF - 2][cF - 2] == Player.NONE.getChar() && strCell[rF - 1][cF - 1] == currentPlayer.Opponent().getChar() ) {
					list.add(new Point(rF - 2, cF - 2).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}

			try {
				// right+1 top+1
				if (strCell[rF - 2][cF + 2] == Player.NONE.getChar() && strCell[rF - 1][cF + 1] == currentPlayer.Opponent().getChar()) {
					list.add(new Point(rF - 2, cF + 2).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				// left-1 bottom+1
				if (strCell[rF + 2][cF - 2] == Player.NONE.getChar() && strCell[rF + 1][cF - 1] == currentPlayer.Opponent().getChar()) {
					list.add(new Point(rF + 2, cF - 2).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				// right+1 top+1
				if (strCell[rF + 2][cF + 2] == Player.NONE.getChar() && strCell[rF + 1][cF + 1] == currentPlayer.Opponent().getChar()) {
					list.add(new Point(rF + 2, cF + 2).getNotation());
					//System.out.println("Inside1");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		} else {
			//System.out.println("Incorrect");
		}

		if (list.size() > 0) {

			strMoves = new String[list.size()];

			list.toArray(strMoves);
		}

		return strMoves;
	}

	// Done
	public String getBoardPosition() {

		// __BBB__/__BBB__/WWWBBBB/WWWWBBB/WWW BBB/__WWW__/__WWW__/ init Pos
		String strRet = "";

		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {

				strRet += strCell[r][c];
			}

			strRet += "/";
		}

		strRet += nextPlayer.getChar();
		return strRet;

	}

	private void Init() {
		strName = "GameBoard";
		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {

				if ((r < 2 && c < 2) || (r < 2 && c > 4) || (r > 4 && c < 2)
						|| (r > 4 && c > 4)) {
					strCell[r][c] = strNone;
				} else {

					if ((r > 1 && c < 3) || (r > 4 && c < 5)
							|| (r == 4 && c == 3)) {
						strCell[r][c] = Player.WHITE.getChar(); // strWhite;
					} else {

						if (r == 3 && c == 3) {
							strCell[r][c] = strBlank;
						} else {
							strCell[r][c] = Player.BLACK.getChar(); // strBlack;
						}
					}

				}
			}

		}

		currentPlayer = Player.WHITE;
		previousPlayer = Player.NONE;
		nextPlayer = Player.NONE;

	}

}
