package cont;

import gui.Window;

public class WindowController {
	Window window;
	GUIController guiController;
	
	WindowController(Window w,GUIController gui){
		window = w;
		guiController = gui;
	}
	public void show(){
		window.getFrame().setVisible(true);
	}
	public void hide(){
		window.getFrame().setVisible(false);
	}
	public void repaint(){
		window.getFrame().repaint();
	}
}
