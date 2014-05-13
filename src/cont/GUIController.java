package cont;

import gui.MessageWindow;

import java.util.List;

import cont.game.GameController;

/**
 * @author zygmunt
 * Manages gui in whole application. Holds references to specific windows controllers.
 * Each GUIController should be used only to one game, so it holds exactly one reference to each type of window.
 * It is the only method of communication between different GUI elements.
 * GUI elements don't know each other.
 */
public class GUIController {
	
	StartMenuController startMenuController;
	ArmiesChoiceController armiesChoiceController;
	MainWindowController mainWindowController;
	GameController gameController;
	MessageWindow messageWindow;
	
	public GUIController(){
		messageWindow = new MessageWindow(this);
	}
	
	/**
	 * Opens new start menu.
	 */
	public void showNewStartMenu(){
		startMenuController = StartMenuController.openNewStartMenu(this);
	}
	/**
	 * Closes start menu and opens armies-choice menu.
	 */
	public void chooseArmies(){
		startMenuController.hide();
		armiesChoiceController = ArmiesChoiceController.openNewArmiesChoice(this);
	}
	/**
	 * @param armies
	 * Hides armies-choice menu, opens main window and passes armies chosen by players.
	 */
	public void startNewGame(List<String>armies,List<String> playersNames){
		armiesChoiceController.hide();
		mainWindowController = MainWindowController.openNewMainWindow(this,armies,playersNames);
		gameController = new GameController(this,playersNames);
		gameController.startNewGame();
		showMessage(MessageBuilder.nextTurnMessage(gameController.getActivePlayerName()));
	}
	public void nextTurn(){
		gameController.nextTurn();
		showMessage(MessageBuilder.nextTurnMessage(gameController.getActivePlayerName()));
	}
	/**
	 * Closes game window. Make GUIController forget currently held references and opens new start menu.
	 */
	public void closeGame(){
		mainWindowController.hide();
		mainWindowController = null;
		armiesChoiceController = null;
		
		showNewStartMenu();
	}
	public void reportError(String message,WindowController windowController){
		messageWindow.showMessage(message);
		windowController.repaint();
	}
	private void showMessage(String message){
		messageWindow.showMessage(message);
	}
}
