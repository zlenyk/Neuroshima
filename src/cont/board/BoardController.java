package cont.board;

import gui.Board;
import gui.Field;
import mod.BoardModel;
import mod.FieldModel;
import mod.Player;
import mod.Tile;
import mod.tiles.empty.Empty;
import cont.GUIController;
import cont.game.GameController;

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
	public static BoardController createNewBoard(GUIController gui,GameController game){
		Board b = new Board(gui,game);
		BoardController bc = b.getController();
		bc.boardModel = new BoardModel(bc);
		setEmpty(bc.getBoardModel());
		BoardGenerator.generateBoard(b,bc);
		bc.guiController.addBoard(bc.getBoard());

		return bc;
	}
	public void select(int x,int y){
		if(gameController.isSztabTurn()){
			int position = boardModel.getPosition(x,y);
			if(!(boardModel.getFieldModelAt(position).getTile() instanceof Empty)){
				return;
			}
			Player p = gameController.getActivePlayer();
			if(p.getSztabPosition() > -1){
				putTileAtPosition(new mod.tiles.empty.Empty(),p.getSztabPosition());
			}
			putTileAtPosition(p.getSztab(),position);
			p.setSztabPosition(position);
		}
		else{
			FieldModel fm = boardModel.getFieldModelThatContains(x, y);
			fm.selectTile();
		}
	}
	public void putTileAtPosition(Tile tile,int position){
		FieldModel fm = boardModel.getFieldModelAt(position);
		fm.changeTile(tile);
		repaintBoard(this);
	}
	public void clearSelections(){
		for(Field f : boardModel.getFields()){
			if(f.isSelected()){
				f.changeSelect();
			}
		}
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
	public Board getBoard(){
		return board;
	}
	public BoardModel getBoardModel(){
		return boardModel;
	}
}
