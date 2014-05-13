package cont;

import gui.StartMenu;

/**
 * @author zygmunt
 *	Class controls start menu behavior. Implements its buttons actions.
 */
public class StartMenuController implements WindowController{
		
	GUIController guiController;
	StartMenu startMenu;

	public StartMenuController(StartMenu sm,GUIController gui){
		guiController = gui;
		startMenu = sm;
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
	@Override
	public void show() {
		startMenu.getFrame().setVisible(true);
	}
	@Override
	public void hide() {
		startMenu.getFrame().setVisible(false);
	}
	@Override
	public void repaint() {
		startMenu.getFrame().repaint();
	}

}
