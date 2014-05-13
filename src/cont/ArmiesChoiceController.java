package cont;

import gui.ArmiesChoice;

import java.util.List;

import mod.Config;
import mod.InvalidConfigException;

/**
 * @author zygmunt
 * Controls behavior and apperance of armies-choice-window.
 */
public class ArmiesChoiceController extends WindowController{
		
	public ArmiesChoiceController(ArmiesChoice ac,GUIController gui){
		super(ac,gui);
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
	 * @throws InvalidConfigException 
	 */
	public void startNewGame(List<String> armies,List<String> playersNames){
		String check = checkConfig(armies,playersNames);
		System.out.println("FE");

		if(check.equals("OK")){
			guiController.startNewGame(armies,playersNames);
		}
		else{
			guiController.reportError(check, this);
		}
	}

	private String checkConfig(List<String>armies,List<String>playersNames){
		if(armies.size() != 2){
			return "You must choose exactly 2 armies.";
		}
		if(playersNames.size() != Config.getPLAYERS()){
			return "There must be " + Config.getPLAYERS() + "players.";
		}
		for(int i = 0; i<playersNames.size(); i++){
			if(playersNames.get(i).length() > 20 || playersNames.get(i).length() < 2){
				return "Name must have between 2 and 20 characters";
			}
		}
		return "OK";
	}
}
