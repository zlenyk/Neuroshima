package cont;

import gui.ArmiesChoice;

import java.util.List;

public class ArmiesChoiceController {
	ArmiesChoice armiesChoice;
	GUIController guiController;
	
	public ArmiesChoiceController(ArmiesChoice ac,GUIController gui){
		armiesChoice = ac;
		guiController = gui;
	}
	public static ArmiesChoiceController openNewArmiesChoice(GUIController gui){
		ArmiesChoice ac = new ArmiesChoice(gui);
		System.out.println("FAE");
		ac.getFrame().setVisible(true);
		return ac.getController();
	}
	public void startNewGame(List<String> armies){
		guiController.startNewGame(armies);
	}
	public void hideMenu(){
		armiesChoice.getFrame().setVisible(false);
	}
}
