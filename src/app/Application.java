package app;

import java.awt.EventQueue;

import mod.Config;
import cont.GUIController;

public class Application {

	public static void main(String[]  args){
		Application app = new Application();
		Config.setPLAYERS(2);
		app.openNewMainMenu();
	}
	
	private void openNewMainMenu(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIController gui = new GUIController();
					gui.showNewStartMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
