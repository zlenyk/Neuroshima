package con;

import gui.MainWindow;

public class MainWindowController {
	MainWindow mainWindow;
	
	public MainWindowController(MainWindow m){
		mainWindow = m;
	}
	public MainWindow getMainWindow(){
		return mainWindow;
	}
	public void closeGame(){
		mainWindow.hideWindow();
	}

}
