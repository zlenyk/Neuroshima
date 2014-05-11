package cont;

import gui.MainWindow;

import java.util.List;

/**
 * @author zygmunt
 *	Class controls main game window behavior. Implements its button actions and provides couple of functions
 *	to modify main window appearance.
 */
public class MainWindowController {
	final MainWindow mainWindow;
	final GUIController guiController;
	
	public MainWindowController(MainWindow m,GUIController gui){
		mainWindow = m;
		guiController = gui;
	}
	
	public static MainWindowController openNewMainWindow(GUIController gui,List<String> armies){
		MainWindow mw = new MainWindow(gui,armies);
		mw.setVisible(true);
		return mw.getController();
	}
	public void hideWindow(){
		mainWindow.setVisible(false);
	}
	public void closeGame(){
		guiController.closeGame();
	}

}
