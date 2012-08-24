package com.kannan.pv;

public enum Player {
	WHITE {
		public String getChar() {
			return "W";
		}
	},
	BLACK {
		public String getChar() {
			return "B";
		}
	},
	NONE {
		public String getChar() {
			return "*";
		}
	};

	public abstract String getChar();

	
	public Player Opponent() {
		if (this == WHITE)
			return BLACK;
		else
			return WHITE;
	}
}