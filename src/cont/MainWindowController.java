package cont;

import gui.MainWindow;

import java.util.List;

/**
 * @author zygmunt
 *	Class controls game window behavior. 
 *	Implements its button actions and provides couple of functions to modify main window appearance.
 */
public class MainWindowController extends WindowController {
	
	public MainWindowController(MainWindow mw,GUIController gui){
		super(mw,gui);
	}
	
	/**
	 * @param gui
	 * @param armies
	 * @return controller to a new MainWindow
	 * Creates and displays new MainWindow.
	 */
	public static MainWindowController openNewMainWindow(GUIController gui,
								List<String> armies,List<String>playersNames){
		MainWindow mw = new MainWindow(gui,armies,playersNames);
		mw.getFrame().setVisible(true);
		return mw.getController();
	}

	public void nextTurn(){
		guiController.nextTurn();
	}
	/**
	 * Implementation of close-game-button. Calls method from GUIController.
	 */
	public void closeGame(){
		guiController.closeGame();
	}

}
