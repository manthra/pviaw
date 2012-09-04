package com.kannan.pv;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Engine {

	/*
	 * private int intDepth=0; private long lnPoints=0;
	 */

	private List<MoveScore> mv = new ArrayList<MoveScore>();

	// mv = brd.getValidMoveList("d3",1);

	private String strP = "";

	public Engine(String strX) {

		Board brd = new Board(strX);

		strP = brd.currentPlayer.getChar();
		// System.out.println(strP);

		Search(brd, 0, "Root", 0);

	}

	public String getMovePos() {

		String strRet = "";
		String strParentID = getBestMove();

		Collections.reverse(mv);

		strRet = FindMove(strParentID);

		return strRet;

	}

	public String FindMove(String strMoveParentID) {

		String strNextID = strMoveParentID;
		String strNextMove = "";

		for (Iterator<MoveScore> iterator = mv.iterator(); iterator.hasNext();) {
			MoveScore mvsc = (MoveScore) iterator.next();

			if (mvsc.getKey().equals(strNextID)) {

				strNextID = mvsc.getParentKey();
				strNextMove = mvsc.getMoveFrom() + mvsc.getMoveTo();
			}
		}

		System.out.println(strNextMove);
		
		return strNextMove;
	}

	public String getBestMove() {

		String strBestMove = "";
		long lnP = 0;

		
		PrintWriter out;
		try {
			out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(
							"F:\\tmp\\test.log", false),
							"utf-8")));
		
		
		for (Iterator<MoveScore> iterator = mv.iterator(); iterator.hasNext();) {
			MoveScore moveScore = (MoveScore) iterator.next();

			if (strP.equals("B")) {
				if (moveScore.getScore() < lnP) {
					lnP = moveScore.getScore();
					strBestMove = moveScore.getParentKey();
				}

			} else {
				if (moveScore.getScore() > lnP) {
					lnP = moveScore.getScore();
					strBestMove = moveScore.getParentKey();
				}

			}

			 /*System.out.println(moveScore.getKey() + " _ " +
			 moveScore.getParentKey() + " _ " + moveScore.getPlayer() + " _ "
			 + moveScore.getDepth() + " _ " + moveScore.getScore() + " _ " +
			 moveScore.getMoveFrom() + moveScore.getMoveTo() + " _ " +
			 moveScore.getBoard());
			 */
			 
			out.write(moveScore.getKey() + "\t" +
					 moveScore.getParentKey() + "\t" + moveScore.getPlayer() + "\t"
					 + moveScore.getDepth() + "\t" + moveScore.getScore() + "\t" +
					 moveScore.getMoveFrom() + moveScore.getMoveTo() + "\t" +
					 moveScore.getBoard() + "\n" );
			 

		}

		out.flush();
		out.close();
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 System.out.println(lnP);

		return strBestMove;
	}

	public void Search(Board brdX, int intD, String strParentKey,
			long lnParentPoints) {

		List<MoveScore> mvS = new ArrayList<MoveScore>();

		for (int i = 0; i < 7; i++) {

			for (int j = 0; j < 7; j++) {

				mvS.clear();

				mvS.addAll(brdX.getValidMoveList(new Point(i, j).getNotation(),
						intD, strParentKey, lnParentPoints));

				mv.addAll(mvS);

				for (Iterator<MoveScore> iterator = mvS.iterator(); iterator
						.hasNext();) {
					MoveScore moveScore = (MoveScore) iterator.next();

					if (moveScore.getDepth() < 1) {

						Board brd1 = new Board(moveScore.getBoard());
						brd1.Move(moveScore.getMoveFrom()
								+ moveScore.getMoveTo());

					/*	Search(brd1, moveScore.getDepth() + 1,
								moveScore.getKey(), moveScore.getScore());
					
						*/
						if (strP.equals(brd1.currentPlayer.getChar())) {
							Search(brd1, moveScore.getDepth() + 1,
									moveScore.getKey(), moveScore.getScore());
						} else {
							Search(brd1, moveScore.getDepth(),
									moveScore.getKey(), moveScore.getScore());
						}

					}
				}

			}
		}

	}

}
