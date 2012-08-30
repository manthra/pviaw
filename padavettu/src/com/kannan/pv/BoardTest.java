package com.kannan.pv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardTest {

	public static void main(String[] args) {

		Board brd = new Board();
		brd.renderBoard();

		try {

			String strNotation = "";
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

					/*Engine eg = new Engine(brd.getBoardPosition());
					System.out.println("NBM " + eg.getNextBestMove());
					*/
					
					Engine eg = new Engine(brd.getBoardPosition());
					
					System.out.println(eg.getNextBestMove());
					
					/*
					List<MoveScore> mv = new ArrayList<MoveScore>();
					
					mv = eg.Search();
					//mv= brd.getValidMoveList("d5", 1);
					
					for (Iterator<MoveScore> iterator = mv.iterator(); iterator.hasNext();) {
						MoveScore moveScore = (MoveScore) iterator.next();
						
						System.out.println(moveScore.getMoveTo() + "_" + moveScore.getMoveFrom() + "_" + moveScore.getScore() + "_" + moveScore.getBoard() + "_" + moveScore.getDepth());
						
					}
					*/
					/*String[] strPos=brd.getValidMoves("d3");
					
					
					if (strPos!=null){
						
						for (int i = 0; i < strPos.length; i++) {
							
							System.out.println(strPos[i]);
							
						}
						
					}
	*/				
					
					/*brd.Move(strNotation);
					brd.renderBoard();
*/
					
					//Engine eng = new Engine(brd.getBoardPosition());
					
					//System.out.println(eng.getNextBestMove());
					
					
					
					//System.out.println(brd.getBoardPosition());
/*
					brd.setBoardPosition("__BBB__/__BBB__/WWWBBBB/WWWWBBB/WWW BBB/__WWW__/__WWW__/B");

					brd.renderBoard();
*/				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
