package cont;

import gui.StartMenu;

/**
 * @author zygmunt
 *	Class controls start menu behavior. Implements its buttons actions.
 */
public class StartMenuController {
	
	final StartMenu appMenu;
	final GUIController guiController;
	
	public StartMenuController(StartMenu a,GUIController gui){
		appMenu = a;
		guiController = gui;
	}
	/**
	 * Implements choose-armies-button.Calls method from GUIController.	 
	 */
	public void chooseArmies(){
		guiController.chooseArmies();
	}
	
	/**
	 * @return StartMenuController to the newly opened StartMenu
	 * Opens and displays new StartMenu
	 */
	public static StartMenuController openNewStartMenu(GUIController gui){
		StartMenu startMenu = new StartMenu(gui);
		startMenu.getFrame().setVisible(true);
		return startMenu.getController();
	}
	/**
	 * Hides StartMenu.
	 */
	public void hideMenu(){
		appMenu.getFrame().setVisible(false);
	}
}
