package com.kannan.pv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Engine {

	Board brd;
	int intDepth=0;
	
	List<MoveScore> mv = new ArrayList<MoveScore>();
	
	//mv = brd.getValidMoveList("d3",1);
	

	public Engine(String strX) {

		brd = new Board(strX);
		Search();
		
	}

	
	public String getNextBestMove() {

		int intScore=0;
		String strBestMove="";
		int i=0;
		
		for (Iterator<MoveScore> iterator = mv.iterator(); iterator.hasNext();) {
			MoveScore moveScore = (MoveScore) iterator.next();
			
			if (i==0){
				strBestMove=moveScore.getMoveFrom()+moveScore.getMoveTo();
			}
			i++;
			if (moveScore.getScore()>intScore){
				intScore=moveScore.getScore();
				strBestMove=moveScore.getMoveFrom()+moveScore.getMoveTo();
			}
			
			//System.out.println(moveScore.getMoveFrom()+moveScore.getMoveTo());
			
			
		}
	
		return strBestMove;
	}


	
	
	
	/*	
	public List<MoveScore> Search(){
		
		for (int i = 0; i < 7; i++) {

			for (int j = 0; j < 7; j++) {

				mv.addAll(brd.getValidMoveList(new Point(i, j).getNotation(),
						intDepth));

				System.out.println(mv.size()); 
				
			}
		}

		
		
		return brd.getValidMoveList("d5",intDepth);
		
	}

	*/
	
	
	public void Search(){
		
		for (int i = 0; i < 7; i++) {

			for (int j = 0; j < 7; j++) {

				mv.addAll(brd.getValidMoveList(new Point(i, j).getNotation(),
						intDepth));

				//System.out.println(mv.size()); 
				
			}
		}
		
	}
	
	
	
	
	
	
}
