package app;

import view.MainWindow;
import mod.Config;
public class Application {
	MainWindow mainWindow;
	private Application(){
		mainWindow = new MainWindow();
	}
	private void start(){
		mainWindow.init(Config.getHEIGHT(),Config.getWIDTH());
	}
	public static void main(String[] args){
		Application application = new Application();
		application.start();
	}
}
