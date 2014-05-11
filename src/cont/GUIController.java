package cont;

import java.util.List;

public class GUIController {
	
	StartMenuController startMenuController;
	ArmiesChoiceController armiesChoiceController;
	MainWindowController mainWindowController;
	
	public GUIController(){}
	
	public void showNewStartMenu(){
		startMenuController = StartMenuController.openNewStartMenu(this);
	}
	public void chooseArmies(){
		startMenuController.hideMenu();
		armiesChoiceController = ArmiesChoiceController.openNewArmiesChoice(this);
	}
	public void startNewGame(List<String>armies){
		armiesChoiceController.hideMenu();
		mainWindowController = MainWindowController.openNewMainWindow(this,armies);
	}
	public void closeGame(){
		mainWindowController.hideWindow();
		mainWindowController = null;
		armiesChoiceController = null;
		
		showNewStartMenu();
	}
}
