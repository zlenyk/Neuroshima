package cont.board;

import gui.Board;
import gui.Field;

import java.awt.Point;
import java.util.List;

public class BoardGUIController {
	/**
	 * Controls board behavior.
	 */
	Board board;
	public BoardGUIController(Board b){
		board = b;
	}
	public Board getBoard(){
		return board;
	}
	public static BoardGUIController createNewBoard(List<Field> fieldList){
		Board b = new Board();
		BoardGenerator.generateBoard(b,fieldList);
		return b.getController();
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
