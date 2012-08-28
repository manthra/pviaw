package com.kannan.pv;

public class MoveScore {

	
	public MoveScore(int intScore, String strMove, String strBoard, int intDepth){
		this.intScore=intScore;
		this.strMove=strMove;
		this.strBoard=strBoard;
		this.intDepth=intDepth;
	}
	
	int intScore=0;
	int intDepth=0;
	String strMove="";
	String strBoard="";
	
	
	public int getScore(){
		return this.intScore;
	}
	
	public void setScore(int intScore){
		this.intScore=intScore;
	}
	
	public String getMove(){
		return this.strMove;
	}
	
	public void setMove(String strMove){
		this.strMove=strMove;
	}
	
	public String getBoard(){
		return this.strBoard;
	}
	
	public void setBoard(String strBoard){
		this.strBoard=strBoard;
	}
	
	
	public int getDepth(){
		return this.intDepth;
	}
	
	public void setDepth(int intDepth){
		this.intDepth=intDepth;
	}
	
	
}
