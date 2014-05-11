package app;

import java.awt.EventQueue;

import cont.StartMenuController;

public class Application {

	public static void main(String[]  args){
		Application app = new Application();
		app.openNewMainMenu();
	}
	
	private void openNewMainMenu(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenuController controller = StartMenuController.openNewStartMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
