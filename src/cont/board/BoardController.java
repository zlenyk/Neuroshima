package cont.board;

import gui.Board;
import gui.Field;

import java.awt.Point;

public class BoardController {
	Board board;
	BoardGenerator bg;
	public BoardController(Board b){
		board = b;
		bg = new BoardGenerator(board);
	}
	public void generateBoard(){
		bg.generateBoard();
	}
	public void mouseAction(int x,int y){
		Point p = new Point(x,y);
		for(Field f : bg.fieldList){
			if(f.contains(p)){
				f.changeSelect();
			}
		}
	}
}
