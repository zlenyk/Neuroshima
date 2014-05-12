package cont;

import gui.StartMenu;

/**
 * @author zygmunt
 *	Class controls start menu behavior. Implements its buttons actions.
 */
public class StartMenuController extends WindowController{
		
	public StartMenuController(StartMenu a,GUIController gui){
		super(a,gui);
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

}
