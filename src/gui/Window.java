package gui;

import javax.swing.JFrame;

import cont.GUIController;

public class Window {
	JFrame frame;
	GUIController guiController;
	
	public JFrame getFrame(){
		return frame;
	}
	Window(GUIController gui){
		guiController = gui;
		frame = new JFrame();
	}
}
