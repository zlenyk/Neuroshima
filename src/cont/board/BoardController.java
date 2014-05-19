package cont.board;

import gui.Board;
import gui.Field;

import java.awt.Point;

import mod.BoardModel;
import mod.FieldModel;
import mod.Player;
import mod.Tile;
import mod.tiles.empty.Empty;
import cont.GUIController;
import cont.game.GameController;

/**
 *	Provides methods to change board state. Is responsible for displaying changes.
 *
 */
public class BoardController {
	private BoardModel boardModel;
	private Board board;
	private GameController gameController;
	private GUIController guiController;
	public BoardController(GameController game,GUIController gui,Board b){
		gameController = game;
		guiController = gui;
		board = b;
	}
	/**
	 * @param gui
	 * @param game
	 * @return board controller for a new Board, connected to given GUI and Game controllers.
	 * Creates new board and displays it in a main window.
	 */
	public static BoardController createNewBoard(GUIController gui,GameController game){
		Board b = new Board(gui,game);
		BoardController bc = b.getController();
		bc.boardModel = new BoardModel(bc);
		setEmpty(bc.getBoardModel());
		BoardGenerator.generateBoard(b,bc);
		bc.guiController.addBoard(bc.getBoard());

		return bc;
	}

	/**
	 * @param point
	 * Called when board is clicked.
	 * Depending on game state, does what needs to be done.
	 */
	public void select(Point point){
		FieldModel fm = boardModel.getFieldModelThatContains(point);
		if(gameController.isSztabTurn()){
			if(!(fm.getTile() instanceof Empty)){
				return;
			}
			Player player = gameController.getActivePlayer();
			if(player.getSztabPosition() > -1){
				putTileAtPosition(new mod.tiles.empty.Empty(),player.getSztabPosition());
			}
			putTileAtPosition(player.getSztab(),fm.getPosition());
			player.setSztabPosition(fm.getPosition());
		}
		else{
			fm.selectTile();
		}
	}
	/**
	 * @param tile
	 * @param position
	 * Puts given tile at selected position on a board.
	 */
	public void putTileAtPosition(Tile tile,int position){
		FieldModel fm = boardModel.getFieldModelAt(position);
		fm.changeTile(tile);
		repaintBoard(this);
	}
	/**
	 * Called after every turn. Clears all selections made by a player on a board.
	 */
	public void clearSelections(){
		for(Field f : boardModel.getFields()){
			if(f.isSelected()){
				f.changeSelect();
			}
		}
	}
	/**
	 * @param bc
	 * Applies changes on a board. Should be called whenever board state is changed and we want to 
	 * display that changes.
	 */
	public void repaintBoard(BoardController bc){
		BoardGenerator.generateBoard(board, bc);
		board.repaint();
	}
	/**
	 * @param bc
	 * Sets all the fields on a board to Empty field.
	 */
	private static void setEmpty(BoardModel bc){
		for(int i = 0; i<21; i++){
			bc.getFieldModelAt(i).changeTile(new mod.tiles.empty.Empty());
		}
	}
	public Board getBoard(){
		return board;
	}
	public BoardModel getBoardModel(){
		return boardModel;
	}
}
