package com.kannan.pv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardTest {

	/**
	 * @param args
	 */

	static String[][] strBoard = new String[7][7];

	static String strNone = " ";
	static String strBlank = " ";
	static String strBlack = "B";
	static String strWhite = "W";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Board brd= new Board();
		brd.renderBoard();
		
		try {
			//Board cpBrd = (Board) brd.clone();
		
		
		String strNotation="";
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		
		while (!(strNotation.equals("quit"))) {
			try {
				strNotation = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (!(strNotation.equals("quit"))) {
		
				brd.Move(strNotation);
				brd.renderBoard();

				System.out.println(brd.getBoardPosition());
				
				brd.setBoardPosition("__BBB__/__BBB__/WWWBBBB/WWWWBBB/WWW BBB/__WWW__/__WWW__/");
				//cpBrd.renderBoard();
				
				brd.renderBoard();
			}
		}
		
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/*brd.Move("d3d4");
		brd.renderBoard();

		brd.Move("d5d3");
		brd.renderBoard();

		
		brd.Move("d2d4");
		brd.renderBoard();

		brd.Move("d4d3"); //invalid
		brd.renderBoard();


		brd.Move("e3d3");
		brd.renderBoard();
*/		
		
		
/*		brd.Move("e3d3");
		brd.renderBoard();
		
		
		brd.Move("d3e3");
		brd.renderBoard();
		
		brd.Move("d4e3");
		brd.renderBoard();
		
		brd.Move("d3d4");
		brd.renderBoard();
		

		brd.Move("d3d4");
		brd.renderBoard();
		
		brd.Move("e3d3");
		brd.renderBoard();

		
*/		/*
		brd.Move(4, 3, 3, 3, "W");
		brd.renderBoard();
		
		brd.Move(2, 3, 4, 3, "B");
		brd.renderBoard();
		
		
		brd.Move(5, 3, 3, 3, "W");
		brd.renderBoard();
		
		brd.Move(2, 4, 2, 3, "B");
		brd.renderBoard();
		

		brd.Move(2, 2, 2, 4, "W");
		brd.renderBoard();
		
		brd.Move(3, 4, 2, 3, "B");
		brd.renderBoard();
		
		
		brd.Move(5, 2, 4, 3, "W");
		brd.renderBoard();
		

		brd.Move(4, 4, 2, 2, "B");
		brd.renderBoard();
		
		//brd.showBoardCords("g1a7");
		
		
		System.out.println("B" + brd.getPoints("B")+"_W" + brd.getPoints("W"));
*/		
		
		
/*		showBoard();
		FillBoard();
		renderBoard();
*/	}

	/*private static void renderBoard() {

		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {
				System.out.print(strBoard[r][c]);
			}
			System.out.print("\n");
		}

	}

	private static void FillBoard() {

		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {

				if ((r < 2 && c < 2) || (r < 2 && c > 4) || (r > 4 && c < 2)
						|| (r > 4 && c > 4)) {
					strBoard[r][c] = strNone;

				} else {

					if ((r > 1 && c < 3) || (r > 4 && c < 5)
							|| (r == 4 && c == 3)) {

						strBoard[r][c] = strWhite;
					} else {

						if (r == 3 && c == 3) {

							strBoard[r][c] = strBlank;
						} else {

							strBoard[r][c] = strBlack;
						}
					}

				}
			}
			System.out.print("\n");
		}

	}

	private static void showBoard() {

		for (int r = 0; r < 7; r++) {

			for (int c = 0; c < 7; c++) {

				if ((r < 2 && c < 2) || (r < 2 && c > 4) || (r > 4 && c < 2)
						|| (r > 4 && c > 4)) {
					System.out.print("   \t");
				} else {

					System.out.print("[ ]\t");

				}
			}
			System.out.print("\n");
		}

	}
*/
}
