package cont;

import gui.MainWindow;

import java.util.List;

/**
 * @author zygmunt
 *	Class controls game window behavior. 
 *	Implements its button actions and provides couple of functions to modify main window appearance.
 */
public class MainWindowController {
	final MainWindow mainWindow;
	final GUIController guiController;

	public MainWindowController(MainWindow mw,GUIController gui){
		mainWindow = mw;
		guiController = gui;
	}
	
	/**
	 * @param gui
	 * @param armies
	 * @return controller to a new MainWindow
	 * Creates and displays new MainWindow.
	 */
	public static MainWindowController openNewMainWindow(GUIController gui,List<String> armies){
		MainWindow mw = new MainWindow(gui,armies);
		mw.setVisible(true);
		return mw.getController();
	}
	/**
	 * Hides MainWindow.
	 */
	public void hideWindow(){
		mainWindow.setVisible(false);
	}
	/**
	 * Implementation of close-game-button. Calls method from GUIController.
	 */
	public void closeGame(){
		guiController.closeGame();
	}

}
