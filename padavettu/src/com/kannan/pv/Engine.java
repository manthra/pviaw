package com.kannan.pv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Engine {

	
	int intDepth=0;
	
	List<MoveScore> mv = new ArrayList<MoveScore>();
	
	//mv = brd.getValidMoveList("d3",1);
	
	private String strP="";

	public Engine(String strX) {

		Board brd = new Board(strX);

		strP=brd.currentPlayer.getChar();
//		System.out.println(strP);
		
		Search(brd, 0, "Root");

	}
	
	
	long lnPoints=0;
	
	public void getBestMove(String strParent){
		
		
		
		for (Iterator<MoveScore> iterator = mv.iterator(); iterator.hasNext();) {
			MoveScore moveScore = (MoveScore) iterator.next();

			
			if (moveScore.getParentKey().equals(strParent)){
				
				lnPoints=lnPoints+moveScore.getScore();
				getBestMove(moveScore.getKey());
				
				
				//System.out.println(moveScore.getParentKey());
				
				if (moveScore.getParentKey().equals("Root")){
					
					System.out.println(lnPoints);
					lnPoints=0;
				}
				
				
			}
			//lnPoints=0;
			//System.out.println(strParent);
			/*if (strParent.equals("Root")) {
				System.out.println(lnPoints);
			}*/
		}
		
		
//		return 0;
	}
	
	
	
	
	
	
	public String getNextBestMove() {

		long lnScore=0;
		String strBestMove="";
		long i=0;
		long b=0, w=0;
		
		
		
		for (Iterator<MoveScore> iterator = mv.iterator(); iterator.hasNext();) {
			MoveScore moveScore = (MoveScore) iterator.next();
			
			
			
			
			
			
			
			
			
			
			
			if (i==0){
				strBestMove=moveScore.getMoveFrom()+moveScore.getMoveTo();
			}
			
			i++;
			if (moveScore.getScore()>lnScore){
				lnScore=moveScore.getScore();
				strBestMove=moveScore.getMoveFrom()+moveScore.getMoveTo();
			}
			
			
			
			
			if (moveScore.getPlayer().equals("W")){
				w++;
			}
			

			if (moveScore.getPlayer().equals("B")){
				b++;
			}
			
			
			System.out.println(moveScore.getKey() + " _ " + moveScore.getParentKey() + " _ " + moveScore.getPlayer() + " _ "  + moveScore.getDepth() + " _ " + moveScore.getScore() + " _ " + moveScore.getMoveFrom() + moveScore.getMoveTo() + " _ " + moveScore.getBoard());
			
			
		}
	
		System.out.println( i + " B:" + b + " W:" +w );
		
		return strBestMove;
	}


	
	
		
	

	
	
	
	public void Search(Board brdX, int intD, String strParentKey) {

		List<MoveScore> mvS = new ArrayList<MoveScore>();

		for (int i = 0; i < 7; i++) {

			for (int j = 0; j < 7; j++) {

				mvS.clear();
				mvS.addAll(brdX.getValidMoveList(new Point(i, j).getNotation(),
						intD, strParentKey));
				mv.addAll(mvS);

				for (Iterator<MoveScore> iterator = mvS.iterator(); iterator
						.hasNext();) {
					MoveScore moveScore = (MoveScore) iterator.next();

					if (moveScore.getDepth() <1) {

						Board brd1 = new Board(moveScore.getBoard());
						brd1.Move(moveScore.getMoveFrom()
								+ moveScore.getMoveTo());

						
						if (strP.equals(brd1.currentPlayer.getChar())){
							Search(brd1, moveScore.getDepth() + 1, moveScore.getKey());
						} else {
							Search(brd1, moveScore.getDepth(), moveScore.getKey());
						}
						
					}
				}

			}
		}

	}
	
	
	
}
