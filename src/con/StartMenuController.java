package con;

import gui.StartMenu;
import gui.MainWindow;

public class StartMenuController {
	StartMenu appMenu;
	
	public StartMenuController(StartMenu a){
		appMenu = a;
	}
	
	/**
	 * Opens new MainWindow
	 * @return opened MainWindow
	 */
	MainWindow openNewMainWindow(){
		return MainWindow.getInstance(appMenu.getFrame());
	}
	
	public void startNewGame(){
		MainWindow newGameWindow = openNewMainWindow();
		newGameWindow.initMainWindow();
	}
}
