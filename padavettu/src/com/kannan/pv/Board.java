package com.kannan.pv;

public class Board {

	public Board() {
		Init();
	}
	

	String[][] strCell = new String[7][7];
	boolean isValid = true;
	boolean IsLastCapture=false;
	
	boolean isEnd=false;
	
	
	
	String strName = "";
	int xPos = 0;
	int yPos = 0;
	String strNone = "_";
	String strBlank = " ";

		
	
	Player currentPlayer, nextPlayer, previousPlayer, won;

		
	public void renderBoard() {

		System.out.println("----------------------------------------------------------");
		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {
				System.out.print("\t" + strCell[r][c]);
			}
			System.out.print("\n\n");
		}
		System.out.println("----------------------------------------------------------");
		
		if (isEnd){
			System.out.println(won.name() + " won the game!" );
		} else{
			System.out.println(currentPlayer.name() + " to Move" );
		}
	}

	
	
	public Player getNextPlayer() {

		return nextPlayer;
	}

		
	
	
	public boolean isValidMove(PointFT pnt) {

		int rF = pnt.getRowFrom();
		int cF = pnt.getColumnFrom();
		int rT = pnt.getRowTo();
		int cT = pnt.getColumnTo();

		
		
		
		/*PointFT pp = new PointFT(rF, cF, rT, cT);
		
		System.out.println("NNN" + pp.getNotation());
*/
		
		boolean isValid = false;
		boolean isCapture = false;

		int cCapture = 0;
		int rCapture = 0;

		//String strP;

/*		if (strCell[rF][cF].equals("W")) {
			currentPlayer = Player.WHITE;
			
		} else {
			currentPlayer = Player.BLACK;
			
		}
*/		
		//strP = currentPlayer.getChar();
		
/*		System.out.println("CP " + currentPlayer.getChar());
		
		System.out.println("PP " + previousPlayer.getChar());
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
						&& strCell[rF + 1][cF].equals(currentPlayer.Opponent().getChar())) { // bottom
																			// cut
					System.out.println("bottom cut");
					isCapture = true;
					rCapture = rF + 1;
					cCapture = cF;

					isValid = true;

					// strCell[rF + 1][cF] = strBlank;

				}

				if ((rF == rT + 2)
						&& strCell[rF - 1][cF].equals(currentPlayer.Opponent().getChar())) { // top
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
							&& strCell[rF][cF + 1].equals(currentPlayer.Opponent().getChar())) { // right
																				// cut
						System.out.println("right cut");
						isCapture = true;
						rCapture = rF;
						cCapture = cF + 1;

						isValid = true;
						// strCell[rF][cF + 1] = strBlank;
					}

					if ((cF == cT + 2)
							&& strCell[rF][cF - 1].equals(currentPlayer.Opponent().getChar())) { // left
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
								&& strCell[rF + 1][cF + 1]
										.equals(currentPlayer.Opponent().getChar())) { // bottm
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
								&& strCell[rF - 1][cF - 1]
										.equals(currentPlayer.Opponent().getChar())) { // top
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
								&& strCell[rF + 1][cF - 1]
										.equals(currentPlayer.Opponent().getChar())) { // bottm
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
								&& strCell[rF - 1][cF + 1]
										.equals(currentPlayer.Opponent().getChar())) { // top
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

		}

		return isValid;
	}
	
	
	
	
	
	
	public boolean Move(String strNotation) {

		PointFT pnt = new PointFT(strNotation);

		
		
		if (isValidMove(pnt)) {

			System.out.println("Valid");

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



	
	
	//Done
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

		if (strBrd[7].equals("W")){			
			previousPlayer=Player.WHITE;
			currentPlayer=Player.BLACK;
			nextPlayer=Player.WHITE;
		} else {
			previousPlayer=Player.BLACK;
			currentPlayer=Player.WHITE;
			nextPlayer=Player.BLACK;
		}
		
		return blRet;
	}	
	
	
	
	
	
	
	//Done
	 public String getBoardPosition(){
		
		 
		//__BBB__/__BBB__/WWWBBBB/WWWWBBB/WWW BBB/__WWW__/__WWW__/     init Pos 
		String strRet="";

		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {

				strRet+=strCell[r][c];
			}
			
			strRet+="/";
		}
	
		strRet+=nextPlayer.getChar();
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
						strCell[r][c] =  Player.WHITE.getChar(); //strWhite;
					} else {

						if (r == 3 && c == 3) {
							strCell[r][c] = strBlank;
						} else {
							strCell[r][c] = Player.BLACK.getChar(); //strBlack;
						}
					}

				}
			}

		}

		currentPlayer = Player.WHITE;
		previousPlayer=Player.NONE;
		nextPlayer=Player.NONE;

	}

}
