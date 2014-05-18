package cont.board;

import gui.Board;
import mod.BoardModel;

public class BoardGUIController {
	/**
	 * Controls board behavior.
	 */
	Board board;
	BoardController boardController;
	public BoardGUIController(Board b){
		board = b;
	}
	public Board getBoard(){
		return board;
	}
	public static BoardGUIController createNewBoard(BoardController bc){
		Board b = new Board();
		setEmpty(bc.getBoardModel());
		BoardGenerator.generateBoard(b,bc);
		b.getController().boardController = bc;
		return b.getController();
	}
	public void repaintBoard(BoardController bc){
		BoardGenerator.generateBoard(board, bc);
		board.repaint();
	}
	private static void setEmpty(BoardModel bc){
		for(int i = 0; i<21; i++){
			bc.getFieldModelAt(i).changeTile(new mod.tiles.empty.Empty());
		}
	}
	public void select(int x,int y){
		boardController.select(x,y);
	}
}
