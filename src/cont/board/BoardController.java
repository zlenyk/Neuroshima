package cont.board;

import mod.BoardModel;
import mod.FieldModel;
import mod.Player;
import mod.Tile;
import mod.tiles.empty.Empty;
import cont.GUIController;
import cont.game.GameController;

public class BoardController {
	private BoardModel boardModel;
	private BoardGUIController boardGuiController;
	private GameController gameController;
	private GUIController guiController;
	BoardController(GameController game,GUIController gui){
		gameController = game;
		guiController = gui;
	}
	public static BoardController createNewBoard(GUIController gui,GameController game){
		BoardController bc = new BoardController(game,gui);
		bc.boardModel = new BoardModel(bc);
		bc.boardGuiController = BoardGUIController.createNewBoard(bc);
		bc.guiController.addBoard(bc.boardGuiController.getBoard());

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
		boardGuiController.repaintBoard(this);
	}
	public BoardModel getBoardModel(){
		return boardModel;
	}
}
