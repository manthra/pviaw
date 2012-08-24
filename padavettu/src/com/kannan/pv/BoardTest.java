package com.kannan.pv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
