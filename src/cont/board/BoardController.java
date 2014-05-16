package cont.board;

import mod.BoardModel;
import cont.GUIController;
import cont.game.GameController;

public class BoardController {
	BoardModel boardModel;
	BoardGUIController boardGuiController;
	GameController gameController;
	GUIController guiController;
	BoardController(GameController game,GUIController gui){
		gameController = game;
		guiController = gui;
	}
	public static BoardController createNewBoard(GUIController gui,GameController game){
		BoardController bc = new BoardController(game,gui);
		bc.boardModel = new BoardModel(bc);
		bc.boardGuiController = BoardGUIController.createNewBoard(bc.boardModel.getFields());
		bc.guiController.addBoard(bc.boardGuiController.getBoard());
		return bc;
	}
	
}
