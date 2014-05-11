package cont;

import gui.ArmiesChoice;

import java.util.List;

/**
 * @author zygmunt
 * Controls behavior and apperance of armies-choice-window.
 */
public class ArmiesChoiceController {
	
	ArmiesChoice armiesChoice;
	GUIController guiController;
	
	public ArmiesChoiceController(ArmiesChoice ac,GUIController gui){
		armiesChoice = ac;
		guiController = gui;
	}
	/**
	 * @param gui
	 * @return controller to the newly created armies-choice-window.
	 * Creates and displays new army-choice-window.
	 */
	public static ArmiesChoiceController openNewArmiesChoice(GUIController gui){
		ArmiesChoice ac = new ArmiesChoice(gui);
		System.out.println("FAE");
		ac.getFrame().setVisible(true);
		return ac.getController();
	}
	/**
	 * @param armies
	 * Implements start-game-button. Passes armies-list to GUIController and asks to create new game.
	 */
	public void startNewGame(List<String> armies){
		guiController.openNewGameWindow(armies);
	}
	/**
	 * Hides armies-choice-window.
	 */
	public void hideMenu(){
		armiesChoice.getFrame().setVisible(false);
	}
}
