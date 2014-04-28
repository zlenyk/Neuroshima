package con;

import gui.StartMenu;
import gui.MainWindow;

/**
 * @author zygmunt
 *	Class controls behavior of start menu. Implements its buttons actions.
 */
public class StartMenuController {
	
	StartMenu appMenu;
	
	public StartMenuController(StartMenu a){
		appMenu = a;
	}
	
	/**
	 * Obtains new MainWindow in which game will be played.
	 * @return obtained MainWindow
	 */
	private MainWindow getNewMainWindow(){
		return MainWindow.getInstance(appMenu.getFrame());
	}
	
	/**
	 * Starts game in new game window.
	 */
	public void startNewGame(){
		MainWindow newGameWindow = getNewMainWindow();
		newGameWindow.initMainWindow();
	}
}
