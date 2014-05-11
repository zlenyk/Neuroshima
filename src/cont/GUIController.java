package cont;

import java.util.List;

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
	
	public GUIController(){}
	
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
		startMenuController.hideMenu();
		armiesChoiceController = ArmiesChoiceController.openNewArmiesChoice(this);
	}
	/**
	 * @param armies
	 * Hides armies-choice menu, opens main window and passes armies chosen by players.
	 */
	public void openNewGameWindow(List<String>armies){
		armiesChoiceController.hideMenu();
		mainWindowController = MainWindowController.openNewMainWindow(this,armies);
	}
	/**
	 * Closes game window. Make GUIController forget currently held references and opens new start menu.
	 */
	public void closeGame(){
		mainWindowController.hideWindow();
		mainWindowController = null;
		armiesChoiceController = null;
		
		showNewStartMenu();
	}
}
