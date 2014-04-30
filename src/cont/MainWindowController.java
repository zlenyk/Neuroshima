package cont;

import gui.MainWindow;

/**
 * @author zygmunt
 *	Class controls main game window behavior. Implements its button actions and provides couple of functions
 *	to modify main window appearance.
 */
public class MainWindowController {
	MainWindow mainWindow;
	
	public MainWindowController(MainWindow m){
		mainWindow = m;
	}
	/**
	 * @return MainWindow object which this class works for.
	 */
	public MainWindow getMainWindow(){
		return mainWindow;
	}
	/**
	 * Implements button "Close game". Makes current MainWindow hide, and show start menu.
	 */
	public void closeGame(){
		mainWindow.hideWindow();
	}
	
	public void initMainWindow(){
		mainWindow.initMainWindow();
	}

}
