package cont;

import gui.MainWindow;
import gui.StartMenu;

import java.util.List;

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
	private MainWindowController getNewMainWindowController(List<String> armies){
		return MainWindow.getInstance(appMenu.getFrame(),armies);
	}
	
	/**
	 * Starts game in new game window.
	 */
	public void startNewGame(List<String> armiesList){
		MainWindowController newGameWindowController = getNewMainWindowController(armiesList);
		newGameWindowController.initMainWindow();
	}
	
	/**
	 * @return StartMenuController to the newly opened StartMenus
	 */
	public static StartMenuController openNewStartMenu(){
		StartMenu startMenu = new StartMenu();
		startMenu.getFrame().setVisible(true);
		return startMenu.getController();
	}
}
