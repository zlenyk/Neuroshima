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
		if(fm == null) return;
		if(gameController.isSztabTurn()){
			if(!(fm.getTile() instanceof Empty)){
				return;
			}
			Player player = gameController.getActivePlayer();
			if(player.getSztabPosition() > -1){
				putTileAtPosition(new mod.tiles.empty.Empty(),player.getSztabPosition());
			}
			player.setSztabPosition(fm.getPosition());
			putTileAtPosition(player.getSztab(),fm.getPosition());
		}
		else{
			Tile selectedTile = getSelectedTile();
			if(selectedTile != null){
				selectedTile.changeSelect();
			}
			fm.selectTile();
			
			selectedTile = getSelectedTile();
			if(gameController.wantToMove()){
				int prevPos = gameController.getLastPutTilePosition();
				Tile prevTile = boardModel.getFieldModelAt(prevPos).getTile();
				for(Integer i : prevTile.pick()){
					if(i == getSelectedFieldModel().getPosition()){
						swapTiles(i,gameController.getLastPutTilePosition());
						gameController.setLastPutTilePosition(i);
						gameController.setWantMove(false);
						break;
					}
				}
			}
			else if(gameController.isWaitingForAccept()){
				if(getSelectedFieldModel().getPosition() == gameController.getLastPutTilePosition()){
					gameController.setWantMove(true);
				}
				else{
					gameController.setWantMove(false);
				}
			}
		}
		gameController.enablePutButtonOrNot();
		gameController.enableRotateFieldButtonOrNot();
	}
	public FieldModel getSelectedFieldModel(){
		return boardModel.getSelectedFieldModel();
	}
	private Tile getSelectedTile(){
		if(getSelectedFieldModel() != null){
			return getSelectedFieldModel().getTile();
		}
		return null;
	}
	public Tile getTileAtPosition(int position){
		return boardModel.getFieldModelAt(position).getTile();
	}
	/**
	 * @param tile
	 * @param position
	 * Puts given tile at selected position on a board.
	 */
	public void putTileAtPosition(Tile tile,int position){
		
		FieldModel fm = boardModel.getFieldModelAt(position);
		if(!tile.isInstant()){
			fm.changeTile(tile);
		}
		if(tile.isInstant() || tile.isSztab()) tile.put(position, 0);
		repaintBoard(this);
	}
	
	public void swapTiles(int position1, int position2){
		Tile t1 = boardModel.getFieldModelAt(position1).getTile();
		Tile t2 = boardModel.getFieldModelAt(position2).getTile();
		
		boardModel.getFieldModelAt(position1).changeTile(t2);
		boardModel.getFieldModelAt(position2).changeTile(t1);
		
		repaintBoard(this);
	}
	public void rotateField(int position){
		FieldModel fm = boardModel.getFieldModelAt(position);
		Field f = fm.getTile().getField();
		f.rotate();
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
