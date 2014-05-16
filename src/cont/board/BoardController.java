package cont.board;

import mod.BoardModel;
import mod.FieldModel;
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
		for(int i = 0; i<21; i++){
			
		}
		return bc;
	}
	public void select(int x,int y){
		FieldModel fm = boardModel.getFieldModelThatContains(x, y);
		fm.getTile().getField().changeSelect();
	}
	public BoardModel getBoardModel(){
		return boardModel;
	}
}
