package cont;

import gui.StartMenu;

/**
 * @author zygmunt
 *	Class controls behavior of start menu. Implements its buttons actions.
 */
public class StartMenuController {
	
	final StartMenu appMenu;
	final GUIController guiController;
	
	public StartMenuController(StartMenu a,GUIController gui){
		appMenu = a;
		guiController = gui;
	}
	/**
	 * Starts game in new game window.
	 */
	public void chooseArmies(){
		guiController.chooseArmies();
	}
	
	/**
	 * @return StartMenuController to the newly opened StartMenus
	 */
	public static StartMenuController openNewStartMenu(GUIController gui){
		StartMenu startMenu = new StartMenu(gui);
		startMenu.getFrame().setVisible(true);
		return startMenu.getController();
	}
	public void hideMenu(){
		appMenu.getFrame().setVisible(false);
	}
}
