package cont.board;

import gui.Board;
import gui.Field;

import java.awt.Point;

public class BoardController {
	/**
	 * Controls board behavior.
	 */
	Board board;
	
	public BoardController(Board b){
		board = b;
	}
	public void generateBoard(){
		BoardGenerator.generateBoard(board);
	}
	public void mouseAction(int x,int y){
		Point p = new Point(x,y);
		for(Field f : board.getFields()){
			if(f.contains(p)){
				f.changeSelect();
			}
		}
	}
}
