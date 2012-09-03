package com.kannan.pv;

public class MoveScore {

	
	public MoveScore(long lnScore, String strMoveTo, String strMoveFrom, String strBoard, int intDepth, String strPlayer, String strKey, String strParentKey){
		this.lnScore=lnScore;
		this.strMoveTo=strMoveTo;
		this.strMoveFrom=strMoveFrom;
		this.strBoard=strBoard;
		this.intDepth=intDepth;
		this.strPlayer=strPlayer;
		this.strKey=strKey;
		this.strParentKey=strParentKey;
		
		
	}
	
	private long lnScore=0;
	private int intDepth=0;
	private String strMoveTo="";
	private String strMoveFrom="";
	
	private String strBoard="";
	private String strPlayer="";
	private String strKey="";
	private String strParentKey="";
	
	
	
	public long getScore(){
		return this.lnScore;
	}
	
	public void setScore(long lnScore){
		this.lnScore=lnScore;
	}
	
	
	public String getPlayer(){
		return this.strPlayer;
	}
	
	public void setPlay(String strPlayer){
		this.strPlayer=strPlayer;
	}
	
	
	public String getKey(){
		return this.strKey;
	}
	
	public void setKey(String strKey){
		this.strKey=strKey;
	}
	
	
	public String getParentKey(){
		return this.strParentKey;
	}
	
	public void setParentKey(String strParentKey){
		this.strParentKey=strParentKey;
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
