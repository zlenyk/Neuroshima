package cont.board;

import gui.Board;
import gui.Field;

import java.awt.Point;
import java.util.List;

public class BoardController {
	/**
	 * Controls board behavior.
	 */
	Board board;
	public BoardController(Board b){
		board = b;
	}
	public Board getBoard(){
		return board;
	}
	public static BoardController createNewBoard(List<Field> fieldList){
		Board b = new Board(fieldList);
		b.getController().generateBoard(fieldList);
		return b.getController();
		
	}
	private void generateBoard(List<Field> fieldList){
		BoardGenerator.generateBoard(board,fieldList);
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
