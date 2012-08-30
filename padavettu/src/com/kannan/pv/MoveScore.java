package com.kannan.pv;

public class MoveScore {

	
	public MoveScore(int intScore, String strMoveTo, String strMoveFrom, String strBoard, int intDepth){
		this.intScore=intScore;
		this.strMoveTo=strMoveTo;
		this.strMoveFrom=strMoveFrom;
		this.strBoard=strBoard;
		this.intDepth=intDepth;
	}
	
	int intScore=0;
	int intDepth=0;
	String strMoveTo="";
	String strMoveFrom="";
	
	String strBoard="";
	
	
	public int getScore(){
		return this.intScore;
	}
	
	public void setScore(int intScore){
		this.intScore=intScore;
	}
	
	public String getMoveTo(){
		return this.strMoveTo;
	}
	
	public void setMoveTo(String strMoveTo){
		this.strMoveTo=strMoveTo;
	}
	
	
	public String getMoveFrom(){
		return this.strMoveFrom;
	}
	
	public void setMoveFrom(String strMoveFrom){
		this.strMoveFrom=strMoveFrom;
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
